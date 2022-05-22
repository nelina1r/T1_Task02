package service;

import entity.Pair;

import java.util.*;

public class ArrayConvertorService {

    public LinkedList<Pair> convertToLinkedList(ArrayList<Pair> arr) {
        LinkedList<Pair> pairList = new LinkedList<>(arr);
        pairList.sort(Comparator.comparing(Pair::getId));
        return pairList;
    }

    public HashMap<Long, List<String>> convertToHashMap(ArrayList<Pair> arr) {
        HashMap<Long, List<String>> pairMap = new HashMap<>();
        for (Pair pair : arr) {
            pairMap.putIfAbsent(pair.getId(), new LinkedList<>());
            pairMap.get(pair.getId()).add(pair.getValue());
        }
        return pairMap;
    }
}
