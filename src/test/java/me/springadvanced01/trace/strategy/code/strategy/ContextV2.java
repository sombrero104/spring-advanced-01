package me.springadvanced01.trace.strategy.code.strategy;

import lombok.extern.slf4j.Slf4j;

/**
 * 전략을 파라미터로 전달 받는 방식
 */
@Slf4j
public class ContextV2 {

    /**
     * Context2는 변하지 않는 템플릿 역할을 한다.
     * 그리고 변하는 부분은 파라미터로 넘어온 Strategy의 코드를 실행해서 처리한다.
     * 이렇게 다른 코드의 인수로서 넘겨주는 실행 가능한 코드를 콜백(callback)이라 한다.
     * 여기에서 콜백은 Strategy이다.
     * 클라이언트에서 직접 Strategy를 실행하는 것이 아니라, 클라이언트가 Context2.execute()를 실행할 때
     * Strategy를 넘겨주고, Context2 뒤에서 Strategy가 실행된다.
     */
    public void execute(Strategy strategy) { // Strategy는 콜백이다.
        long startTime = System.currentTimeMillis();
        // 비즈니스 로직 실행
        strategy.call(); // 위임
        // 비즈니스 로직 종료
        long endTime = System.currentTimeMillis();
        long resultTime = endTime - startTime;
        log.info("resultTime={}", resultTime);
    }

}
