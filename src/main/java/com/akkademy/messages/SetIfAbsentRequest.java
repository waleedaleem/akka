package com.akkademy.messages;

import java.io.Serializable;

/**
 * Created by walid on 22/07/2017.
 */
public class SetIfAbsentRequest implements Serializable {
    public final String key;
    public final Object value;

    public SetIfAbsentRequest(String key, Object value) {
        this.key = key;
        this.value = value;
    }

    @Override
    public String toString() {
        return "SetIfAbsentRequest{" +
                "key='" + key + '\'' +
                ", value=" + value +
                '}';
    }
}