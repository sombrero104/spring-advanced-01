package me.springadvanced01.trace.strategy.code.template;

import lombok.extern.slf4j.Slf4j;

/**
 * 템플릿 콜백 패턴
 */
@Slf4j
public class TimeLogTemplate {

    public void execute(Callback callback) {
        long startTime = System.currentTimeMillis();
        // 비즈니스 로직 실행
        callback.call(); // 콜백
        // 비즈니스 로직 종료
        long endTime = System.currentTimeMillis();
        long resultTime = endTime - startTime;
        log.info("resultTime={}", resultTime);
    }

}
