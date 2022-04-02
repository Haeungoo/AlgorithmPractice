package com.haeuni.cando;

import java.util.Arrays;
import java.util.Scanner;

public class Greedy3_Step1 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[] arr = new int[n];

        for(int i =0; i <n; i++){
            arr[i] = sc.nextInt();
        }

        Arrays.sort(arr);

        int preTime = 0; // 이전까지의 대기시간 합산
        int sum = 0; // 사람별 대기시간 총합

        for(int i = 0; i < n; i++){
            sum += preTime + arr[i]; // 이전시간 + 현재 사람이 걸리는 시간
            preTime += arr[i]; // 이전까지의 누적합에 현재 걸리는 시간 합산
        }
        System.out.println(sum);

    }
}
