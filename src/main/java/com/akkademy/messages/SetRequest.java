package com.akkademy.messages;

import java.io.Serializable;

/**
 * Created by walid on 22/07/2017.
 */
public class SetRequest implements Serializable {
    public final String key;
    public final Object value;

    public SetRequest(String key, Object value) {
        this.key = key;
        this.value = value;
    }

    @Override
    public String toString() {
        return "SetRequest{" +
                "key='" + key + '\'' +
                ", value=" + value +
                '}';
    }
}