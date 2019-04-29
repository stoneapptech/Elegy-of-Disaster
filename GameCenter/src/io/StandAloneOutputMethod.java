package io;

import java.util.Collection;

public class StandAloneOutputMethod implements Output {

    @Override
    public void send(String message) {
        System.out.println(message);
    }

    @Override
    public void send(Collection<?> collection) {
        System.out.println(collection.toString());
    }
}
