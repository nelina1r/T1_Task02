package service.joiners.implement;

import entity.Pair;
import service.joiners.interfaces.Joiner;

import java.io.IOException;
import java.io.Writer;
import java.util.ArrayList;

public class ArrayListJoiner implements Joiner<ArrayList<Pair>> {

    @Override
    public void join(ArrayList<Pair> table1, ArrayList<Pair> table2, Writer writer) throws IOException {
        for (Pair firstFilePair : table1) {
            for (Pair secondFilePair : table2) {
                if (firstFilePair.getId().equals(secondFilePair.getId())) {
                    writer.write(lineFormatter(firstFilePair.getId(), firstFilePair.getValue(), secondFilePair.getValue()));
                }
            }
        }
    }
}
