package me.springadvanced01.trace;

/**
 * 로그를 시작할 때의 상태를 가지고 있음.
 */
public class TraceStatus {

    private TraceId traceId;

    private Long startTimeMs;

    private String message;

    public TraceId getTraceId() {
        return traceId;
    }

    public TraceStatus(TraceId traceId, Long startTimeMs, String message) {
        this.traceId = traceId;
        this.startTimeMs = startTimeMs;
        this.message = message;
    }

    public void setTraceId(TraceId traceId) {
        this.traceId = traceId;
    }

    public Long getStartTimeMs() {
        return startTimeMs;
    }

    public void setStartTimeMs(Long startTimeMs) {
        this.startTimeMs = startTimeMs;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

}
