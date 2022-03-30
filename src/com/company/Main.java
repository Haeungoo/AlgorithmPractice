package com.company;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int coinTypeCnt = sc.nextInt();
        int totalMoney = sc.nextInt();
        System.out.println(coinTypeCnt + ":" + totalMoney);
        int result = 0;

        ArrayList<Integer> coinType =  new ArrayList<>(coinTypeCnt);
        for(int i = 0; i <coinTypeCnt; i++){
             coinType.add(sc.nextInt());
        }
        for(int i = coinTypeCnt-1; i >= 0; i--){
            System.out.println(i+ "=" + coinType.get(i));
            if(totalMoney >= coinType.get(i)){
                int changeCnt = (totalMoney/coinType.get(i));
                System.out.println("==>" + changeCnt );
                result += changeCnt;
                totalMoney -= (coinType.get(i) * changeCnt) ;
                System.out.println("==>" + totalMoney );
            }

        }
        System.out.println(result);


    }
}
