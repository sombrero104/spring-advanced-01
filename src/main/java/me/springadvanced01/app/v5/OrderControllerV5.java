package me.springadvanced01.app.v5;

import me.springadvanced01.trace.callback.TraceCallback;
import me.springadvanced01.trace.callback.TraceTemplate;
import me.springadvanced01.trace.logtrace.LogTrace;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class OrderControllerV5 {

    private final OrderServiceV5 orderService;
    private final TraceTemplate template;

    public OrderControllerV5(OrderServiceV5 orderService, LogTrace trace) {
        this.orderService = orderService;
        this.template = new TraceTemplate(trace);
        /**
         * OrderControllerV5가 싱글톤 빈이기 때문에 위 template 객체도 하나이다.
         * 위처럼 생성하거나 스프링 빈으로 template을 등록해서 사용해도 된다.
         */
    }

    @GetMapping("/v5/request")
    public String request(String itemId) {
        return template.execute("OrderController.request()", new TraceCallback<>() {
            @Override
            public String call() {
                orderService.orderItem(itemId);
                return "ok";
            }
        });
    }

}
