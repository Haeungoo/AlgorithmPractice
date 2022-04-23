package com.haeuni.cando.week4;

import java.util.Arrays;

public class Non_Hash_Step1 {
    private String solution(String[] participant, String[] completion){
        // 미리 sort해서 for문 한번만 돌릴거야
        Arrays.sort(participant);
        Arrays.sort(completion);

        int i;
        for(i = 0; i< completion.length; i++){
            if(!participant[i].equals(completion[i]))
                break;
        }
        return participant[i];
    }
    public static void main(String[] args){
        String[] part = {"leo","kiki", "eden"};
        String[] comp = {"eden", "kiki"};
        Non_Hash_Step1 non_hash_step1= new Non_Hash_Step1();
        System.out.println(non_hash_step1.solution(part,comp));
    }

}
