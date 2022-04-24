package com.haeuni.cando.week4;

import java.util.*;

// 프로그래머스 - 베스트 앨범
public class Hash_Step3 {
    private int[] solution(String[] genres, int[] plays){
        int[] answer = {};
        ArrayList<Integer> arrAnswer = new ArrayList<Integer>();
        HashMap<String, Integer> hmGenres = new HashMap<>();
        for(int i =0; i< genres.length; i++) {
            hmGenres.put(genres[i], hmGenres.getOrDefault(genres[i],0)+plays[i]);
        }
        System.out.println("1: " + hmGenres);
        List<String> keySetList = new ArrayList<>(hmGenres.keySet());
        keySetList.sort((o1, o2) -> (hmGenres.get(o2).compareTo(hmGenres.get(o1))));
        System.out.println("2: " + keySetList);
        for(String key : keySetList) {
            HashMap<Integer, Integer> hs = new HashMap<Integer, Integer>();
            for(int i = 0; i<genres.length; i++) {
                if(key.equals(genres[i])) { hs.put(i, plays[i]); }
            }
            System.out.println("3: " + hs);
            List<Integer> keyLists = new ArrayList<>(hs.keySet());
            keyLists.sort((s1, s2)->hs.get(s2).compareTo(hs.get(s1)));
            System.out.println("4: " + keyLists);
            int j = 0;
            for (Integer c : keyLists) {
                if(j>1) { break; }
                arrAnswer.add(c);
                j++;
            }
            System.out.println("5: " + arrAnswer);
        }
        answer = new int[arrAnswer.size()];
        for( int i =0;i<arrAnswer.size();i++) {
            answer[i] = arrAnswer.get(i);
        }
        return answer;
    }

    public static void main(String[] args){
        String[] genres = {"classic", "pop", "classic", "classic", "pop"};
        int[] plays = {500, 600, 150, 800, 2500};
        Hash_Step3 hash_step3 = new Hash_Step3();
        System.out.println(Arrays.toString(hash_step3.solution(genres, plays)));
    }
}
