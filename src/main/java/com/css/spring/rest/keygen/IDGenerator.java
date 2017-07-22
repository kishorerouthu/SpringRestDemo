package com.css.spring.rest.keygen;

import java.util.concurrent.atomic.AtomicLong;

/**
 * @author Kishore Routhu on 22/7/17 8:28 PM.
 */
public final class IDGenerator {

    private static AtomicLong currentID = new AtomicLong(0l);

    public static Long generateNewId() {
        synchronized (IDGenerator.class) {
            return currentID.incrementAndGet();
        }
    }
}
