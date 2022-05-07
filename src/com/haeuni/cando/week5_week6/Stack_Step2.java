package com.haeuni.cando.week5_week6;

import com.haeuni.cando.week4.Hash_Step3;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

// 프로그래머스 - 기능개발
public class Stack_Step2 {
    private int[] solution(int[] progresses, int[] speeds){
        List<Integer> list = new ArrayList<>();
        int[] day = new int[speeds.length];

        for(int i = 0; i< speeds.length; i++){
            day[i] = (100 - progresses[i]) / speeds[i];
            if((100 - progresses[i]) % speeds[i] != 0){
                day[i] += 1;
            }
        }
        int prev = day[0];
        int cnt = 1;
        for(int i = 1; i < day.length; i++){
            if(prev < day[i]){
                list.add(cnt);
                cnt = 1;
                prev = day[i];
            }else{
                cnt ++;
            }
        }
        list.add(cnt);
        int[] answer = new int[list.size()];
        for(int i = 0; i < list.size(); i++){
            answer[i] = list.get(i);
        }
        return answer;
    }
    public static void main(String[] args){
        int[] progresses = {93, 30, 55};
        int[] speeds = {1, 30, 5};
        Stack_Step2 stack_Step2 = new Stack_Step2();
        System.out.println(Arrays.toString(stack_Step2.solution(progresses, speeds)));
    }
}
