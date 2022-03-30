package com.haeuni.cando;

import java.util.Arrays;
import java.util.Scanner;

// BOJ 1931
public class Greedy_Step2 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int meetingCnt = sc.nextInt();
        int[][] meetingArr = new int[meetingCnt][2];
        for(int i = 0; i < meetingCnt; i++){
            meetingArr[i][0] = sc.nextInt();
            meetingArr[i][1] = sc.nextInt();
        }

        // 0번 인덱스 기준으로 오름차순 정렬
        Arrays.sort(meetingArr, (o1,o2)-> {
            return o1[0]-o2[0];
        });

        // 0번 인덱스 기준으로 오름차순 정렬
        Arrays.sort(meetingArr, (o1,o2)-> {
            return o1[1]-o2[1];
        });

        int result = 0;
        int endTime = 0;

        for(int i = 0; i < meetingCnt; i++){
            if(meetingArr[i][0] >= endTime){
                endTime = meetingArr[i][1];
                result++;
            }
        }
        System.out.println(result);
    }
}
