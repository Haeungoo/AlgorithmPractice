package com.haeuni.cando.week3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 9184
public class DP2_Step1 {
    private static int[][][] dp = new int[21][21][21];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        while(true){
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            // -1, -1, -1 이 나오면 종료
            if(a == -1 && b == -1 && c == -1){
                break;
            }

            sb.append("w(" + a + ", "+ b + ", " + c + ") = ").append(w(a,b,c)).append("\n");
        }
        System.out.println(sb);
    }

    private static int w(int a, int b, int c){
        // a,b,c가 범위를 벗어나지 않고 Memoization이 되는 경우
        // Memoization => 주어진 입력값에 대한 결과를 저장해서 같은 입력값에 대해 함수가 한번 실행되는 것을 보장
        if(inRange(a,b,c) && dp[a][b][c] != 0){
            return dp[a][b][c];
        }
        if(a <= 0 || b <= 0 || c <= 0){
            return 1;
        }
        if(a > 20 || b > 20 || c > 20){
            return dp[20][20][20] = w(20,20,20);
        }

        if(a < b && b < c){
            return dp[a][b][c] = w(a,b,c-1) + w(a,b-1, c-1) - w(a, b-1, c);
        }
        return dp[a][b][c] = w(a-1, b, c) + w(a-1, b-1, c) + w(a-1,b, c-1) - w(a-1,b-1, c-1);
    }
    private static boolean inRange(int a, int b, int c){
        return a >= 0 && a <= 20 && b >= 0 && b <= 20 && c >= 0 && c <= 20;
    }

}
