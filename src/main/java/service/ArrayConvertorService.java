package service;

import entity.Pair;

import java.util.*;

public class ArrayConvertorService {

    public ArrayList<Pair> convertToArrayList(String[] arr){
        ArrayList<Pair> pairList = new ArrayList<>();
        for(String s : arr){
            String[] specs = s.split(" ");
            pairList.add(new Pair(Long.parseLong(specs[0]), specs[1]));
        }
        return pairList;
    }

    public LinkedList<Pair> convertToLinkedList(String[] arr){
        LinkedList<Pair> pairList = new LinkedList<>();
        for(String s : arr){
            String[] specs = s.split(" ");
            pairList.add(new Pair(Long.parseLong(specs[0]), specs[1]));
        }
        pairList.sort(Comparator.comparing(Pair::getId));
        return pairList;
    }

    public HashMap<Long, List<String>> convertToHashMap(String[] arr){
        HashMap<Long, List<String>> pairMap = new HashMap<>();
        for(String s : arr){
            String[] specs = s.split(" ");
            Long id = Long.parseLong(specs[0]);
            String value = specs[1];
            if(!pairMap.containsKey(id)){
                List<String> list = new ArrayList<>();
                list.add(value);
                pairMap.put(id, list);
            } else {
                pairMap.get(id).add(value);
            }
        }
        return pairMap;
    }
}
