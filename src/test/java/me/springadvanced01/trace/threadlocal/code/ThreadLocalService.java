package me.springadvanced01.trace.threadlocal.code;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class ThreadLocalService {

    /**
     * ThreadLocal
     * 해당 스레드가 스레드 로컬을 사용한 후에는
     * ThreadLocal.remove()를 호출해서 스레드 로컬에 저장된 값을 제거해줘야 한다.
     * 제거하지 않으면 특정 상황에서 메모리 누수가 발생할 수 있다.
     */
    private ThreadLocal<String> nameStore = new ThreadLocal<>();

    public String logic(String name) {
        log.info("저장 name={} -> nameStore={}", name, nameStore.get());
        nameStore.set(name);
        sleep(1000);
        log.info("조회 nameStore={}", nameStore.get());
        return nameStore.get();
    }

    private void sleep(int millis) {
        try {
            Thread.sleep(millis);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
