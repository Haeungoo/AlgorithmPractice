package com.haeuni.cando.week5_week6;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

// 프로그래머스 - 다리를 지나는 트럭
public class Queue2_Step2 {
    private int solution(int bridge_length, int weight, int[] truck_weights){
        Queue<Integer> queue = new LinkedList<>();
        int sum = 0;
        int time = 0;

        for(int truck : truck_weights){
            while(true){
                if(queue.isEmpty()){
                    queue.add(truck);
                    sum += truck;
                    time ++;
                    System.out.println(truck +", "+ queue + ", "+ sum + ", " + time);
                    break;
                }else if(queue.size() == bridge_length){
                    sum -= queue.poll();
                }else{
                    if(sum + truck <= weight){
                        queue.add(truck);
                        sum += truck;
                        time ++;
                        System.out.println(truck +", "+ queue + ", "+ sum + ", " + time);
                        break;
                    }else{
                        queue.add(0);
                        time ++;
                    }
                }
            }
        }
        return time + bridge_length;
    }
    public static void main(String[] args){
        int bridge_length = 2;
        int weight = 10;
        int[] truck_weights = {7,4,5,6};
        Queue2_Step2 queue2_Step2 = new Queue2_Step2();
        System.out.println(queue2_Step2.solution(bridge_length, weight, truck_weights));
    }
}
