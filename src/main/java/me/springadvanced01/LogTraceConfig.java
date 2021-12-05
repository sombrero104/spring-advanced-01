package me.springadvanced01;

import me.springadvanced01.trace.logtrace.FieldLogTrace;
import me.springadvanced01.trace.logtrace.LogTrace;
import me.springadvanced01.trace.logtrace.ThreadLocalLogTrace;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class LogTraceConfig {

    @Bean
    public LogTrace logTrace() {
        // return new FieldLogTrace();
        return new ThreadLocalLogTrace();
    }

}
