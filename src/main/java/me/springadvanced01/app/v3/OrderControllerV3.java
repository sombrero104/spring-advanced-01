package me.springadvanced01.app.v3;

import lombok.RequiredArgsConstructor;
import me.springadvanced01.trace.TraceStatus;
import me.springadvanced01.trace.logtrace.LogTrace;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class OrderControllerV3 {

    private final OrderServiceV3 orderService;
    private final LogTrace trace;

    @GetMapping("/v3/request")
    public String request(String itemId) {
        TraceStatus status = null;
        try {
            status = trace.begin("OrderController.request()");
            orderService.orderItem(itemId);
            trace.end(status);
            return "ok";
        } catch (Exception e) {
            trace.exception(status, e);
            throw e; // 예외를 꼭 다시 던져주어야 한다. 던지지 않으면 위에서 예외를 가져가버리고 어플리케이션은 정상적으로 끝나기 때문.
        }
    }

}
