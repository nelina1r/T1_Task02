package service;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class FileReaderService {

    public String[] readFromFileToArray(String fileName) throws IOException{
        StringBuilder stringBuilder = new StringBuilder();
        try(BufferedReader bufferedReader = new BufferedReader(new FileReader(fileName))){
            String line = bufferedReader.readLine();
            while(line != null){
                stringBuilder.append(line).append(";");
                line = bufferedReader.readLine();
            }
        }
        return stringBuilder.toString().split(";");
    }
}
