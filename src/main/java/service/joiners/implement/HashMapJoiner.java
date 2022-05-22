package service.joiners.implement;

import service.joiners.interfaces.Joiner;

import java.io.IOException;
import java.io.Writer;
import java.util.HashMap;
import java.util.List;

public class HashMapJoiner implements Joiner<HashMap<Long, List<String>>> {

    @Override
    public void join(HashMap<Long, List<String>> table1, HashMap<Long, List<String>> table2, Writer writer) throws IOException {
        for (Long id : table1.keySet()) {
            if (table2.containsKey(id)) {
                for (String value1 : table1.get(id)) {
                    for (String value2 : table2.get(id)) {
                        writer.write(lineFormatter(id, value1, value2));
                    }
                }
            }
        }
    }
}
