package com.haeuni.cando;

import java.util.ArrayList;
import java.util.Scanner;

// BOJ 1012
public class DFS2_Step1 {
    static int node[][]; // 배추밭 배열
    static int check[][]; // 배추 방문여부 배열
    static int cnt = 0; // 배추의 묶음 세는 변수
    static ArrayList<Integer> array = new ArrayList<>(); // 각 테스트케이스를 저장하기 위한 ArrayList

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        // 입력값 저장 과정
        int t= sc.nextInt(); // 테스트 케이스

        for(int i =0; i<t;i++){
            int m = sc.nextInt(); // 배추밭 가로길이
            int n = sc.nextInt(); // 배추밭 세로길이
            int k = sc.nextInt(); // 배추 개수

            node = new int[n][m];
            check = new int[n][m];
            cnt = 0;

            for(int j=0; j<k;j++){ // 배추 위치 입력
                int a = sc.nextInt();
                int b = sc.nextInt();
                node[b][a] = 1;
            }
            // 탐색 시작
            for(int g = 0; g < node.length; g++){
                for(int j = 0; j < node[g].length; j++){
                    // 1이면서 방문하지 않은 배추 단지의 경우
                    if(node[g][j] == 1 && check[g][j] == 0){
                        cnt++; // 배추의 묶음마다 cnt추가
                        dfs(j,g);
                    }
                }
            }
            array.add(cnt);
        }


        // 출력
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
            dfs(x, y+1); // 오른쪽열로 이동
        }

        // 기준행의 아래쪽행 탐색
        // 아래쪽행이 1이면서 방문하지 않은 곳
        if(x<node.length-1 && node[x+1][y]==1 && check[x+1][y] ==0){
            dfs(x+1, y); // 아래쪽행으로 이동
        }

        // 기준열의 왼쪽열 탐색
        // 왼쪽열이 1이면서 방문하지 않은 곳
        if(y>0 && node[x][y-1]==1 && check[x][y-1] ==0){
            dfs(x, y-1); // 왼쪽열로 이동
        }

        // 기준행의 윗쪽행 탐색
        // 윗쪽행이 1이면서 방문하지 않은 곳
        if(x>0 && node[x-1][y]==1 && check[x-1][y] ==0){
            dfs(x-1, y); // 오른쪽열로 이동
        }
    }
}
