package com.ground.util;

public class SlotOverlapException extends Exception {
    public SlotOverlapException(String msg) {
        super(msg);
    }
    public String toString() {
        return getMessage();
    }
}
