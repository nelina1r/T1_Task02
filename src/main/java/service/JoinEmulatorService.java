package service;

import entity.Pair;

import java.util.*;

public class JoinEmulatorService {

    public void joinWithArrayList(List<Pair> firstFilePairs, List<Pair> secondFilePairs){
        for(Pair firstFilePair : firstFilePairs){
            for(Pair secondFilePair: secondFilePairs){
                if(firstFilePair.getId().equals(secondFilePair.getId())){
                    System.out.println(firstFilePair.getId() + " " + firstFilePair.getValue() + " " + secondFilePair.getValue());
                }
            }
        }
    }

    public void joinWithSortedLinkedList(LinkedList<Pair> firstFilePairs, LinkedList<Pair> secondFilePairs){
        ListIterator<Pair> firstIterator = firstFilePairs.listIterator();
        ListIterator<Pair> secondIterator = secondFilePairs.listIterator();
        while(firstIterator.hasNext()){
            Pair firstPair = firstIterator.next();
            Pair secondPair = secondIterator.next();

            while ((firstPair.getId() > secondPair.getId()) && secondIterator.hasNext()){
                secondPair = secondIterator.next();
            }

            if(firstPair.getId().equals(secondPair.getId())){
                int counterMatches = 0;
                while(firstPair.getId().equals(secondPair.getId())){
                    System.out.println(firstPair.getId() + " " + firstPair.getValue() + " " + secondPair.getValue());
                    secondPair = secondIterator.next();
                    counterMatches++;
                }
                for(int i = 0; i < counterMatches; i++){
                    if(secondIterator.hasPrevious()){
                        secondPair = secondIterator.previous();
                    }
                }
            }
            if(firstPair.getId() < secondPair.getId()){
                secondIterator.previous();
            }
        }
    }

    public void joinWithHashMap(HashMap<Long, List<String>> pairMapFirst, HashMap<Long, List<String>> pairMapSecond){
        for(Map.Entry entry : pairMapFirst.entrySet()){
            Long id = Long.parseLong(entry.getKey().toString());
            if(pairMapSecond.containsKey(id)){
                for(String value1 : pairMapFirst.get(id)){
                    for(String value2: pairMapSecond.get(id)){
                        System.out.println(id + " " + value1 + " " + value2);
                    }
                }
            }
        }
    }
}
