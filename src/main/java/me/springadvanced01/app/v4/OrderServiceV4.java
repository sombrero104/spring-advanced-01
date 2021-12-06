package me.springadvanced01.app.v4;

import lombok.RequiredArgsConstructor;
import me.springadvanced01.trace.TraceStatus;
import me.springadvanced01.trace.logtrace.LogTrace;
import me.springadvanced01.trace.template.AbstractTemplate;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class OrderServiceV4 {

    private final OrderRepositoryV4 orderRepository;
    private final LogTrace trace;

    public void orderItem(String itemId) {
        AbstractTemplate<Void> template = new AbstractTemplate<Void>(trace) {
            @Override
            protected Void call() {
                orderRepository.save(itemId);
                return null;
            }
        };
        template.execute("OrderService.orderItem()");
    }

}
