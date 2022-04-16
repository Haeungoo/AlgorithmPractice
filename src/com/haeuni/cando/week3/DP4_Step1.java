package com.haeuni.cando.week3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// 9461 파도반 수열 (두 인접 값의 합이 다다음 인덱스에 위치함=> 피보나치는 다음 인덱스에 합의 값이 위치)
public class DP4_Step1 {
    // 100인 경우에는 약 최대 21억인 int형의 범위를 넘어간다. => Long타입
    private static Long[] arr = new Long[101];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        arr[0] = 0L;
        arr[1] = 1L;
        arr[2] = 1L;
        arr[3] = 1L;

        int testCnt = Integer.parseInt(br.readLine());

        while(testCnt>0){
            sb.append(p(Integer.parseInt(br.readLine()))).append("\n");
            testCnt--;
        }
        System.out.println(sb);
    }
    private static long p(int N){
        if(arr[N] == null){
            arr[N] = p(N-2) + p(N-3);
        }
        return arr[N];
    }
}
