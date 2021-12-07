package me.springadvanced01.trace.strategy;

import lombok.extern.slf4j.Slf4j;
import me.springadvanced01.trace.strategy.code.strategy.ContextV2;
import me.springadvanced01.trace.strategy.code.strategy.Strategy;
import me.springadvanced01.trace.strategy.code.strategy.StrategyLogic1;
import me.springadvanced01.trace.strategy.code.strategy.StrategyLogic2;
import org.junit.jupiter.api.Test;

@Slf4j
public class ContextV2Test {

    /**
     * 전략 패턴 적용
     *
     * Context와 Strategy를 '선 조립 후 실행'하는 방식이 아니라
     * Context를 실행할 때마다 전략을 인수로 전달한다.
     * 클라이언트는 Context를 실행하는 시점에 원하는 Strategy를 전달할 수 있다.
     * 따라서 이전 방식과 비교해서 원하는 전략을 더욱 유연하게 변경할 수 있다.
     * 테스트 코드를 보면 하나의 Context만 생성한다.
     * 그리고 하나의 Context에 실행 시점에 여러 전략을 인수로 전달해서 유연하게 실행한다.
     */
    @Test
    void strategyV1() {
        ContextV2 context = new ContextV2();
        context.execute(new StrategyLogic1());
        context.execute(new StrategyLogic2());
    }

    /**
     * 전략 패턴 익명 내부 클래스
     */
    @Test
    void strategyV2() {
        ContextV2 context = new ContextV2();
        context.execute(new Strategy() {
            @Override
            public void call() {
                log.info("비즈니스 로직 1 실행");
            }
        });
        context.execute(new Strategy() {
            @Override
            public void call() {
                log.info("비즈니스 로직 2 실행");
            }
        });
    }

    /**
     * 전략 패턴 익명 내부 클래스2, 람다
     */
    @Test
    void strategyV3() {
        ContextV2 context = new ContextV2();
        context.execute(() -> log.info("비즈니스 로직 1 실행"));
        context.execute(() -> log.info("비즈니스 로직 2 실행"));
    }

}
