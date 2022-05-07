package com.haeuni.cando.week5_week6;

import java.util.Arrays;
import java.util.Stack;

public class Stack2_Step2 {
    private int[] solution(int[] prices){
        int[] answer = {};
        Stack<Integer> stack = new Stack<Integer>();
        int[] arr = new int[prices.length];

        for(int i = 0; i < prices.length; i++){
            while(!stack.isEmpty()){
                int peek = prices[stack.peek()];
                //System.out.println("peek > " + peek + " stack.peek() >> " + stack.peek());
                if(peek > prices[i]){
                    //System.out.println("prices[i] "+ i + "보다 큰 peek > " + peek);
                    int pop = stack.pop();
                    arr[pop] = i - pop;
                    //System.out.println("arr배열 > " +arr[pop] + ", pop > " + pop + ", i > " + i);
                }else{
                    break;
                }
            }
            stack.add(i);
            System.out.println(stack);
        }
        while(!stack.isEmpty()){
            int pop = stack.pop();
            System.out.print(pop + " , ");
            arr[pop] = prices.length - pop - 1;
            System.out.println(arr[pop]);
        }
        answer = arr;
        return answer;
    }
    public static void main(String[] args){
        int[] prices = {1, 2, 3, 2, 3};
        Stack2_Step2 stack2_Step2 = new Stack2_Step2();
        System.out.println(Arrays.toString(stack2_Step2.solution(prices)));
    }
}
