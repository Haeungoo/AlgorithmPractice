package com.haeuni.cando;

import java.util.ArrayList;
import java.util.Scanner;

// BOJ 11047
public class Greedy_Step1 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int coinTypeCnt = sc.nextInt();
        int totalMoney = sc.nextInt();
        System.out.println("동전 종류 갯수 " + coinTypeCnt + ":" + "총금액 " + totalMoney);
        int result = 0;

        ArrayList<Integer> coinType =  new ArrayList<>(coinTypeCnt);
        for(int i = 0; i <coinTypeCnt; i++){
             coinType.add(sc.nextInt());
        }
        for(int i = coinTypeCnt-1; i >= 0; i--){
            System.out.println(i+ "=" + coinType.get(i));
            if(totalMoney >= coinType.get(i)){
                int changeCnt = (totalMoney/coinType.get(i));
                System.out.println("거스름돈 갯수 ==> " + changeCnt );
                result += changeCnt;
                totalMoney -= (coinType.get(i) * changeCnt) ;
                System.out.println("나머지 금액 ==> " + totalMoney );
            }

        }
        System.out.println(result);


    }
}
