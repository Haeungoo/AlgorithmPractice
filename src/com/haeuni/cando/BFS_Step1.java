package com.haeuni.cando;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

// BOJ 2606
public class BFS_Step1 {
    static int[][] check; // 간선 연결상태
    static boolean[] checked; // 확인 여부
    static int n; // 정점개수
    static int m; // 간선개수

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();

        check = new int[101][101]; // 컴퓨터 수가 100개 이하 => 1번 컴퓨터부터 시작하므로 [100][100] 할당하면 런타임에러 발생
        checked = new boolean[101];

        // 간선 연결상태 저장
        for (int i = 0; i < m; i++) {
            int x = sc.nextInt();
            int y = sc.nextInt();

            check[x][y] = check[y][x] = 1;
        }

        bfs();
    }
    public static void bfs(){
        Queue<Integer> queue = new LinkedList<Integer>();
        queue.offer(1); // 1번 컴퓨터로 지정
        checked[1] = true;
        int result = 0;

        //Queue가 빌 때까지 반복, 방문 정점은 확인, 출력 후 Queue에 넣어 순서대로 확인
        while(!queue.isEmpty()){
            int temp = queue.poll(); // 데이터 꺼내옴(없으면 null)

            for(int j = 1; j <= n; j++){ // 1번 컴퓨터부터 시작
                if(check[temp][j] == 1 && checked[j] == false){
                    queue.offer(j); // 데이터 넣음
                    checked[j] = true;
                    result ++;
                    //System.out.print(j+ " ");
                }
            }

        }
        System.out.println(result);

    }
}
