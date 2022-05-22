package service;

import entity.Pair;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class FileReaderService {

    public ArrayList<Pair> readFromFileToArray(String fileName) throws IOException {
        ArrayList<Pair> list = new ArrayList<>();
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(fileName))) {
            String line = bufferedReader.readLine();
            while (line != null) {
                String[] specs = line.split(",");
                list.add(new Pair(Long.parseLong(specs[0]), specs[1]));
                line = bufferedReader.readLine();
            }
        }
        return list;
    }
}
