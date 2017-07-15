package com.akkademy.messages;

/**
 * Created by walid on 15/07/2017.
 */
public class VoteRequest {
    private final String key;
    private final Integer score;

    public VoteRequest(String key, Integer score) {
        this.key = key;
        this.score = score;
    }

    public String getKey() {
        return key;
    }

    public Object getScore() {
        return score;
    }
}
