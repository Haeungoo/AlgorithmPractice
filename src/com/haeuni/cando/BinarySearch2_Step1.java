package com.haeuni.cando;

import java.util.Arrays;
import java.util.Scanner;

// BOJ 10816
public class BinarySearch2_Step1 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int cnt = sc.nextInt();
        int[] arr = new int[cnt];
        for(int i = 0; i < cnt; i++){
            int num = sc.nextInt();
            arr[i] = num;
        }
        Arrays.sort(arr);

        int matchCnt = sc.nextInt();
        StringBuilder sb = new StringBuilder();
        for(int k = 0; k < matchCnt; k++){
            int matchNum = sc.nextInt();
            // 중복 원소에 대한 길이 = upper함수에서 구한 시작인덱스 - lower함수에서 구한 시작인덱스
            sb.append(upperBinarySearch(arr,matchNum)-lowerBinarySearch(arr,matchNum)).append(' ');
        }
        System.out.println(sb);
    }
    private static int lowerBinarySearch(int[] arr, int key){
        int start = 0; // 탐색 왼쪽 끝 인덱스
        int end = arr.length;  // 탐색 오른쪽 끝 인덱스

        while(start < end){ // 왼쪽 인덱스가 오른쪽 인덱스보다 커지기 시작하기 전까지
            int mid = (start + end)/2;

            // key의 값이 mid 위치의 값보다 작거나 같은 경우
            // (중복 원소에 대해 왼쪽으로 탐색하도록 유도)
           if(key <= arr[mid]){
                end = mid;
            }
            else{
                start = mid + 1;
            }
        }
        // 찾은 시작점 인덱스 반환
        return start;
    }

    private static int upperBinarySearch(int[] arr, int key){
        int start = 0; // 탐색 왼쪽 끝 인덱스
        int end = arr.length;  // 탐색 오른쪽 끝 인덱스

        while(start < end){ // 왼쪽 인덱스가 오른쪽 인덱스보다 커지기 시작하기 전까지
            int mid = (start + end)/2;

            // key의 값이 mid 위치의 값보다 작은 경우
            if(key < arr[mid]){
                end = mid;
            }
            else{
                start = mid + 1;
            }
        }
        // 찾은 시작점 인덱스 반환
        return start;
    }
}
