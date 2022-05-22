package service.joiners.implement;

import entity.Pair;
import service.joiners.interfaces.Joiner;

import java.io.IOException;
import java.io.Writer;
import java.util.LinkedList;
import java.util.ListIterator;

public class LinkedListJoiner implements Joiner<LinkedList<Pair>> {
    @Override
    public void join(LinkedList<Pair> table1, LinkedList<Pair> table2, Writer writer) throws IOException {
        ListIterator<Pair> firstIterator = table1.listIterator();
        ListIterator<Pair> secondIterator = table2.listIterator();

        if(!firstIterator.hasNext() || !secondIterator.hasNext())
            return;

        int steps = 1;
        while (firstIterator.hasNext()) {
            Pair firstPair = firstIterator.next();
            while (secondIterator.hasNext()) {
                Pair secondPair = secondIterator.next();
                if (firstPair.getId() == secondPair.getId()) {
                    writer.write(lineFormatter(firstPair.getId(), firstPair.getValue(), secondPair.getValue()));
                    steps++;
                } else if (firstPair.getId() < secondPair.getId()) {
                    goBack(secondIterator, steps);
                    steps = 1;
                    break;
                }
            }
            goBack(secondIterator, steps);
            steps = 1;
        }
    }

    private void goBack(ListIterator<Pair> iterator, int steps) {
        for (int i = 0; i < steps; i++) {
            if (iterator.hasPrevious()) {
                iterator.previous();
            } else break;
        }
    }
}
