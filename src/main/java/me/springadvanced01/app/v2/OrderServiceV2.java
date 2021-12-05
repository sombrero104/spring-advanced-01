package me.springadvanced01.app.v2;

import lombok.RequiredArgsConstructor;
import me.springadvanced01.trace.TraceId;
import me.springadvanced01.trace.TraceStatus;
import me.springadvanced01.trace.hellotrace.HelloTraceV2;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class OrderServiceV2 {

    private final OrderRepositoryV2 orderRepository;
    private final HelloTraceV2 trace;

    public void orderItem(TraceId traceId, String itemId) {
        TraceStatus status = null;
        try {
            status = trace.beginSync(traceId, "OrderService.request()");
            orderRepository.save(status.getTraceId(), itemId);
            trace.end(status);
        } catch (Exception e) {
            trace.exception(status, e);
            throw e; // 예외를 꼭 다시 던져주어야 한다. 던지지 않으면 위에서 예외를 가져가버리고 어플리케이션은 정상적으로 끝나기 때문.
        }
    }

}
