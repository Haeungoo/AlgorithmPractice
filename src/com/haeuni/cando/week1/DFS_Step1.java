package com.haeuni.cando.week1;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class DFS_Step1 {
    static int node[][]; // 아파트 단지 배열
    static int check[][]; // 각 아파트 단지 방문여부 배열
    static int cnt = 1;
    static ArrayList<Integer> array = new ArrayList<>(); // 각 단지수를 저장하기 위한 ArrayList

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        // 입력값 저장 과정
        int n = sc.nextInt(); // 지도의 크기 n
        node = new int[n][n]; // 지도 배열
        check = new int[n][n]; // 지도 방문배열
        for(int i = 0; i < node.length; i++){
            String numStr = sc.next();
            for(int j = 0; j < node[i].length; j++){
                node[i][j] = numStr.charAt(j) - '0'; // 문자를 숫자로 변경(아스키코드 사용)
            }
        }

        // 탐색 시작
        for(int i = 0; i < node.length; i++){
            for(int j = 0; j < node[i].length; j++){
                // 1이면서 방문하지 않은 아파트 단지의 경우
                if(node[i][j] == 1 && check[i][j] == 0){
                    cnt = 1; // 초기화
                    dfs(i,j);
                    array.add(cnt); // 단지의 수 저장 => 1,2,3 이렇게 보여주기 위함
                }
            }
        }
        // 출력
        System.out.println(array.size()); // 단지의 개수
        Collections.sort(array); // 오름차순 정렬 (1->2->3)
        for(int i = 0; i< array.size(); i++){
            System.out.println(array.get(i));
        }

    }

    // 기준행,기준열을 기준으로 방문하지 않은 곳이고 1의 값을 가지는 곳은 상,하,좌,우로 탐색하는 과정
    public static void dfs(int x, int y){
        check[x][y] = 1; // 전달받은 인자는 방문 완료 => 1로 초기화

        // 기준열의 오른쪽열 탐색
        // 오른쪽열이 1이면서 방문하지 않은 곳
        if(y<node.length-1 && node[x][y+1]==1 && check[x][y+1] ==0){
            cnt++; // cnt 변수 증가
            dfs(x, y+1); // 오른쪽열로 이동
        }

        // 기준행의 아래쪽행 탐색
        // 아래쪽행이 1이면서 방문하지 않은 곳
        if(x<node.length-1 && node[x+1][y]==1 && check[x+1][y] ==0){
            cnt++; // cnt 변수 증가
            dfs(x+1, y); // 아래쪽행으로 이동
        }

        // 기준열의 왼쪽열 탐색
        // 왼쪽열이 1이면서 방문하지 않은 곳
        if(y>0 && node[x][y-1]==1 && check[x][y-1] ==0){
            cnt++; // cnt 변수 증가
            dfs(x, y-1); // 왼쪽열로 이동
        }

        // 기준행의 윗쪽행 탐색
        // 윗쪽행이 1이면서 방문하지 않은 곳
        if(x>0 && node[x-1][y]==1 && check[x-1][y] ==0){
            cnt++; // cnt 변수 증가
            dfs(x-1, y); // 오른쪽열로 이동
        }
    }
}
