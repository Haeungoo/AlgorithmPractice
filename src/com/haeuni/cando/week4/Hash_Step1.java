package com.haeuni.cando.week4;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

// 프로그래머스 - 완주하지 못한 선수
public class Hash_Step1 {
    private String solution(String[] participant, String[] completion){
        String answer = "";
        HashMap<String, Integer> hm = new HashMap<>();
        for(String p : participant){
            hm.put(p, hm.getOrDefault(p,0)+1);
        }
        for(String p: completion){
            hm.put(p, hm.get(p)-1);
        }
        Iterator<Map.Entry<String,Integer>> iter = hm.entrySet().iterator();
        while(iter.hasNext()){
            Map.Entry<String, Integer> entry = iter.next();
            if(entry.getValue() != 0) {
                answer = entry.getKey();
                break;
            }
        }
        return answer;
    }

    public static void main(String[] args){
        String[] part = {"leo","kiki", "eden"};
        String[] comp = {"eden", "kiki"};
        Hash_Step1 hash_step1= new Hash_Step1();
        System.out.println(hash_step1.solution(part,comp));
    }
}
