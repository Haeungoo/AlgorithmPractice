package com.haeuni.cando.week5_week6;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

// 프로그래머스 - 프린터
public class Queue_Step2 {
    class Task{
        int location;
        int priority;
        public Task(int location, int priority){
            this.location = location;
            this.priority = priority;
        }
    }
    private int solution(int[] priorities, int location){
        int answer = 0;
        Queue<Task> queue = new LinkedList<Task>();
        for(int i = 0; i < priorities.length; i++){
            queue.add(new Task(i, priorities[i]));
        }
        int now = 0;
        while(!queue.isEmpty()){
            Task cur = queue.poll();
            boolean flag = false;
            for(Task t : queue){
                if(t.priority > cur.priority){
                    flag = true;
                }
            }
            if(flag){
                queue.add(cur);
            }else{
                now++;
                if(cur.location == location){
                    answer = now;
                    break;
                }
            }
        }
        return answer;
    }
    public static void main(String[] args){
        int[] priorities = {2, 1, 3, 2};
        int location = 	2;
        Queue_Step2 queue_Step2 = new Queue_Step2();
        System.out.println(queue_Step2.solution(priorities, location));
    }
}
