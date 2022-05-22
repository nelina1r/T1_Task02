package service;

import service.joiners.interfaces.Joiner;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;

public class JoinerService {

    public <T> void innerJoin(T left, T right, String fileName, Joiner<T> joiner) throws IOException {
        try (Writer writer = new BufferedWriter(new FileWriter(fileName))) {
            long start = System.currentTimeMillis();
            joiner.join(left, right, writer);
            long finish = System.currentTimeMillis();
            System.out.println(finish - start);
        }
    }
}
