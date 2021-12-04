package me.springadvanced01.trace;

import java.util.UUID;

public class TraceId {

    private String id; // 트랜잭션 아이디 (DB 트랜잭션이 아님.)

    private int level; // 여기에서는 메소드가 호출될 때 마다의 깊이를 레벨이라고 함.

    public TraceId() {
        this.id = createId();
        this.level = 0;
    }

    private TraceId(String id, int level) {
        this.id = id;
        this.level = level;
    }

    private String createId() {
        return UUID.randomUUID().toString().substring(0, 8); // UUID 앞의 8자리만 사용.
        // 어쩌다 중복이 되더라도 여기에서는 단순히 로그 남기는 용도로 사용하는 것이기 때문에 괜찮?
    }

    public TraceId createNextId() {
        return new TraceId(id, level + 1);
    }

    public TraceId createPreviousId() {
        return new TraceId(id, level - 1);
    }

    public boolean isFirstLevel() {
        return level == 0;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

}
