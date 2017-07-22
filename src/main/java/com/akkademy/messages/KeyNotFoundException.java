package com.akkademy.messages;

import java.io.Serializable;

/**
 * Created by walid on 22/07/2017.
 */
public class KeyNotFoundException extends Exception implements Serializable {
    public final String key;

    public KeyNotFoundException(String key) {
        this.key = key;
    }
}