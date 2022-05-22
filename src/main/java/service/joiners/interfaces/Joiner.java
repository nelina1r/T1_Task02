package service.joiners.interfaces;

import java.io.IOException;
import java.io.Writer;

public interface Joiner<T> {

    void join(T table1, T table2, Writer writer) throws IOException;

    default String lineFormatter(Long id, String value1, String value2){
        return id + " " + value1 + " " + value2 + "\n";
    }
}
