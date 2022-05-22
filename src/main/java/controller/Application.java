package controller;

import entity.Pair;
import service.ArrayConvertorService;
import service.FileReaderService;
import service.JoinerService;
import service.joiners.implement.ArrayListJoiner;
import service.joiners.implement.HashMapJoiner;
import service.joiners.implement.LinkedListJoiner;
import service.joiners.interfaces.Joiner;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

public class Application {

    private static final String ARRAY_LIST_OUTPUT_NAME = "array_list.txt";
    private static final String LINKED_LIST_OUTPUT_NAME = "linked_list.txt";
    private static final String HASH_MAP_OUTPUT_NAME = "hash_map.txt";

    public static void main(String[] args) {
        if (args.length != 3) {
            System.out.println("Invalid CLI arguments \n" +
                    "Expected: 'first_file_path second_file_path catalog_path");
            return;
        }

        try {
            //input
            FileReaderService fileReaderService = new FileReaderService();
            ArrayList<Pair> arrayFromFirstFile = fileReaderService.readFromFileToArray(args[0]);
            ArrayList<Pair> arrayFromSecondFile = fileReaderService.readFromFileToArray(args[1]);
            ArrayConvertorService convertorService = new ArrayConvertorService();
            JoinerService joinerService = new JoinerService();
            // ArrayList
            Joiner<ArrayList<Pair>> arrayListJoiner = new ArrayListJoiner();
            joinerService.innerJoin(arrayFromFirstFile, arrayFromSecondFile, args[2] + ARRAY_LIST_OUTPUT_NAME, new ArrayListJoiner());
            // sorted LinkedList
            System.out.println("----------");
            Joiner<LinkedList<Pair>> linkedListJoiner = new LinkedListJoiner();
            LinkedList<Pair> pairsLinkedListFirst = convertorService.convertToLinkedList(arrayFromFirstFile);
            LinkedList<Pair> pairsLinkedListSecond = convertorService.convertToLinkedList(arrayFromSecondFile);
            joinerService.innerJoin(pairsLinkedListFirst, pairsLinkedListSecond, args[2] + LINKED_LIST_OUTPUT_NAME, new LinkedListJoiner());
            // HashMap
            System.out.println("-----------");
            Joiner<HashMap<Long, List<String>>> hashMapJoiner = new HashMapJoiner();
            HashMap<Long, List<String>> pairsHashMapFirst = convertorService.convertToHashMap(arrayFromFirstFile);
            HashMap<Long, List<String>> pairsHashMapSecond = convertorService.convertToHashMap(arrayFromSecondFile);
            joinerService.innerJoin(pairsHashMapFirst, pairsHashMapSecond, args[2] + HASH_MAP_OUTPUT_NAME, new HashMapJoiner());
        } catch (IOException e) {
            System.out.println("Error occurred during reading the file");
        }
    }
}
