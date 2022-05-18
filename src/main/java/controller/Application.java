package controller;

import entity.Pair;
import service.ArrayConvertorService;
import service.FileReaderService;
import service.JoinEmulatorService;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

public class Application {
    public static void main(String[] args) {
        if(args.length != 2){
            System.out.println("Invalid CLI arguments \n" +
                               "Expected: 'first_file_path second_file_path");
        }

        try {
            //input
            FileReaderService fileReaderService = new FileReaderService();
            String[] arrayFromFirstFile = fileReaderService.readFromFileToArray(args[0]);
            String[] arrayFromSecondFile = fileReaderService.readFromFileToArray(args[1]);
            ArrayConvertorService convertorService = new ArrayConvertorService();
            JoinEmulatorService emulatorService = new JoinEmulatorService();
            // ArrayList
            ArrayList<Pair> pairsArrayListFirst = convertorService.convertToArrayList(arrayFromFirstFile);
            ArrayList<Pair> pairsArrayListSecond = convertorService.convertToArrayList(arrayFromSecondFile);
            emulatorService.joinWithArrayList(pairsArrayListFirst, pairsArrayListSecond);
            // sorted LinkedList
            System.out.println("-----------------------------------");
            LinkedList<Pair> pairsLinkedListFirst = convertorService.convertToLinkedList(arrayFromFirstFile);
            LinkedList<Pair> pairsLinkedListSecond = convertorService.convertToLinkedList(arrayFromSecondFile);
            emulatorService.joinWithSortedLinkedList(pairsLinkedListFirst, pairsLinkedListSecond);
            // HashMap
            System.out.println("-----------------------------------");
            HashMap<Long, List<String>> pairsHashMapFirst = convertorService.convertToHashMap(arrayFromFirstFile);
            HashMap<Long, List<String>> pairsHashMapSecond = convertorService.convertToHashMap(arrayFromSecondFile);
            emulatorService.joinWithHashMap(pairsHashMapFirst, pairsHashMapSecond);
        }catch (IOException e){
            System.out.println("Error occurred during reading the file");
        }
    }
}
