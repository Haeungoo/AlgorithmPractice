package com.haeuni.cando.week1;

import java.util.Scanner;

// BOJ 2805
public class BinarySearch4_Step1 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        int cnt = sc.nextInt();
        int needs = sc.nextInt();

        int[] treeArr = new int[cnt];

        int min = 0;
        int max = 0;

        // 입력 + 랜선 최대값 Set
        for(int i = 0; i < cnt; i++){
            treeArr[i] = sc.nextInt();
            if(max < treeArr[i]){
                max = treeArr[i];
            }
        }

        // 이분탐색(upper bound)
        while(min < max){

            int mid = (max + min) / 2 ;
            long sum = 0;

            for(int treeHeight : treeArr){

                /*
                 * tree의 잘린 길이 = tree의 높이 - 자르는 위치(mid)
                 * tree의 잘린 길이의 합
                 * 음수인 경우는 더하지 않고 양수만 더하기
                 */

                if(treeHeight - mid > 0){
                    sum += (treeHeight - mid);
                }
            }

            /* upper bound 형식
               => 자른 나무 길이의 합이 필요한 랜선의 갯수보다 작으면
               => 자르고자하는 최대 위치를 mid로 줄이고
               => 그 외는 자르고자하는 길이를 늘려야해서 최소 길이를 mid+1로 늘림.
            */
            if(sum < needs){
                max = mid;
            } else{
                min = mid + 1;
            }

        }
        System.out.println(min - 1);
    }
}
