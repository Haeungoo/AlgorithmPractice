package com.haeuni.cando.week4;

import java.util.HashMap;
import java.util.Iterator;

// 프로그래머스 - 위장
public class Hash2_Step2 {
    public int solution(String[][] clothes){
        HashMap<String, Integer> map = new HashMap<>();
        for(String[] cloth : clothes){
            String type = cloth[1];
            map.put(type, map.getOrDefault(type,0) + 1);
        }

        Iterator<Integer> it = map.values().iterator();
        int answer = 1;

        while(it.hasNext()){
            answer *= it.next() + 1; // 공집합
        }
        return answer - 1;
    }
    public static void main(String[] args){
        String[][] clothes = {{"yellowhat", "headgear"}, {"bluesunglasses", "eyewear"}, {"green_turban", "headgear"}};
        String[][] clothes2 = {{"crowmask", "face"}, {"bluesunglasses", "face"},{"smoky_makeup", "face"}};
        Hash2_Step2 hash2_step2= new Hash2_Step2();
        System.out.println(hash2_step2.solution(clothes));
        System.out.println(hash2_step2.solution(clothes2));
    }
}
