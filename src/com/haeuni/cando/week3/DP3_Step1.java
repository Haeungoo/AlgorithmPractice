package com.haeuni.cando.week3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// 1904
public class DP3_Step1 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        System.out.println(Tile(N));
    }
    private static int Tile(int a) {
        if(a == 1){
            return 1;
        }
        if(a == 2){
            return 2;
        }

        // 초기값 설정
        int val1 = 1;
        int val2 = 2;
        int sum = 0;

        // 피보나치 수열 (1,2,3,5,8,13, ...)
        for(int i = 2; i < a; i++){
            sum = (val1 + val2) % 15746;
            val1 = val2;
            val2 = sum;
        }
        return sum;
    }

}
