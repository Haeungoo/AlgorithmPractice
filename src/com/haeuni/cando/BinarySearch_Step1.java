package com.haeuni.cando;

import java.util.Arrays;
import java.util.Scanner;

// BOJ 1920
public class BinarySearch_Step1 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int cnt = sc.nextInt();
        int[] arr = new int[cnt];
        for(int i = 0; i <cnt ;i++){
            int num = sc.nextInt();
            arr[i] = num;
        }
        Arrays.sort(arr);

        int matchCnt = sc.nextInt();
        for(int k = 0; k < matchCnt; k++){
            if(binarySearch(arr,sc.nextInt())>=0){
                System.out.println("1");
            }else{
                System.out.println("0");
            }
        }


    }
    private static int binarySearch(int[] arr, int key){
        int start = 0; // 탐색 왼쪽 끝 인덱스
        int end = arr.length - 1; // 탐색 오른쪽 끝 인덱스

        while(start <= end){ // ** 왼쪽 인덱스가 오른쪽 인덱스보다 커지기 전까지 반복
            int mid = (start+end) / 2;

            // key의 값이 mid 위치의 값보다 작은 경우
            if(key < arr[mid]){
                end = mid - 1;
            }

            // key의 값이 mid 위치의 값보다 큰 경우
            else if(key > arr[mid]){
                start = mid + 1;
            }

            // key의 값이 mid 위치의 값과 같은 경우
            else{
                return mid;
            }
        }

        // 찾고자 하는 값이 존재하지 않을 경우
        return -1;
    }
}
