package me.springadvanced01.trace.threadlocal;

import lombok.extern.slf4j.Slf4j;
import me.springadvanced01.trace.threadlocal.code.FieldService;
import org.junit.jupiter.api.Test;

@Slf4j
public class FieldServiceTest {

    private FieldService fieldService = new FieldService();

    @Test
    void field() {
        log.info("main start");

        /*Runnable userA = new Runnable() {
            @Override
            public void run() {
                fieldService.logic("userA");
            }
        };*/

        Runnable userA = () -> {
            fieldService.logic("userA");
        };
        Runnable userB = () -> {
            fieldService.logic("userB");
        };

        Thread threadA = new Thread(userA);
        threadA.setName("thread-A");
        Thread threadB = new Thread(userB);
        threadB.setName("thread-B");

        threadA.start();
        // sleep(2000); // 동시성 문제 발생 X
        sleep(100); // 동시서 문제 발생 O
        threadB.start();
        sleep(3000); // 메인 스레드 종료 대기
        // 메인 스레드가 먼저 종료되지 않도록 3초 정도 대기. (threadB가 안끝나고 종료되어 버려서.. 카운트다운래치 사용하는 것이 더 좋음)
        log.info("main exit");
    }

    private void sleep(int millis) {
        try {
            Thread.sleep(millis);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
