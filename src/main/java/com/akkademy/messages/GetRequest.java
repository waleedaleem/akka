package com.akkademy.messages;

import java.io.Serializable;

/**
 * Created by walid on 22/07/2017.
 */
public class GetRequest implements Serializable {
    public final String key;

    public GetRequest(String key) {
        this.key = key;
    }
}
