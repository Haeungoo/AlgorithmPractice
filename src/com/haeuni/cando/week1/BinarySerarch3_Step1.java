package com.haeuni.cando.week1;

import java.util.Scanner;

// BOJ 1654
public class BinarySerarch3_Step1 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        int cnt = sc.nextInt();
        int needs = sc.nextInt();

        int[] lanArr = new int[cnt];

        long max = 0; // 랜선의 길이의 최댓값은 int 최댓값이라서 = > long타입

        // 입력 + 랜선 최대값 Set
        for(int i = 0; i < cnt; i++){
            lanArr[i] = sc.nextInt();
            if(max < lanArr[i]){
                max = lanArr[i];
            }
        }

        // (0~max+1) 범위에서 탐색
        // 반드시 max +1 해야함 => 0/1 = 0 문제 발생
        max++;

        long min = 0; // 탐색 길이 최솟값
        long mid = 0;

        while(min < max){
            // 범위 내에서 중간 길이를 구함
            mid = (max + min) / 2 ;

            long count = 0;

            for(int i = 0; i < lanArr.length; i++){
                count += (lanArr[i] / mid);
            }

            /* upper bound 형식
               => mid길이로 랜선를 자른 갯수와 필요한 랜선의 갯수보다 작으면
               => 자르고자하는 최대 길이를 mid로 줄이고
               => 그 외는 자르고자하는 길이를 늘려야해서 최소 길이를 mid+1로 늘림.
            */
            if(count < needs){
                max = mid;
            }else{
                min = mid + 1;
            }

        }
        System.out.println(min - 1);
    }
}
