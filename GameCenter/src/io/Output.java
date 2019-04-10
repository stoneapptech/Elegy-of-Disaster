package io;

import org.omg.CORBA.Any;
import java.util.Collection;

public interface Output {
    void send(String message);
    void send(Collection<?> collection);
}
