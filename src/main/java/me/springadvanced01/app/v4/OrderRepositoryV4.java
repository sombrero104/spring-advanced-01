package me.springadvanced01.app.v4;

import lombok.RequiredArgsConstructor;
import me.springadvanced01.trace.TraceStatus;
import me.springadvanced01.trace.logtrace.LogTrace;
import me.springadvanced01.trace.template.AbstractTemplate;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class OrderRepositoryV4 {

    private final LogTrace trace;

    public void save(String itemId) {
        AbstractTemplate<Void> template = new AbstractTemplate<Void>(trace) {
            @Override
            protected Void call() {
                // 저장 로직
                if(("ex").equals(itemId)) {
                    throw new IllegalStateException("예외 발생!");
                }
                sleep(1000);
                return null;
            }
        };
        template.execute("OrderRepository.save()");
    }

    private void sleep(int millis) {
        try {
            Thread.sleep(millis);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
