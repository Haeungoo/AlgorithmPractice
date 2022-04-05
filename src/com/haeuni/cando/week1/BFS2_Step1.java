package com.haeuni.cando.week1;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

class xy{ // xy좌표 저장 클래스
    int x;
    int y;
    public xy(int x, int y){
        this.x = x;
        this.y = y;
    }
}

// BOJ 2178
public class BFS2_Step1 {

    static int node[][]; // 2차원 미로 배열
    static int check[][]; // 2차원 방문여부 배열
    static int cnt = 1; // 시작점인 (1,1)은 카운트된 상태로 시작하므로 1로 초기화
    static int n,m;

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        m = sc.nextInt();
        node = new int[n][m];
        check = new int[n][m];
        for(int i = 0; i < n; i++){
            String numStr = sc.next();
            for(int j = 0; j < m ;j++){
                node[i][j] = numStr.charAt(j) - '0'; // 문자를 숫자로 변경(아스키코드)
            }
        }
        bfs(1,1); // 시작점
        System.out.println(check[n-1][m-1]); // 방문배열의 마지막 원소, 도착지점의 값을 반환하면 최단경로가 됨.
    }

    public static void bfs(int a, int b){
        Queue<xy> queue = new LinkedList<>(); // 큐
        a-=1; // 시작점이 1,1이라서 -1로 초기화
        b-=1;
        check[a][b] = cnt;

        queue.offer(new xy(a,b)); // 시작점 객체를 큐에 삽입
        while(!queue.isEmpty()){
            int x = queue.peek().x; // 큐에 저장되어 있는 객체에서 x,y좌표를 저장
            int y = queue.peek().y;
            queue.poll(); // peek()로 값을 저장했으므로 객체소멸

            // 기준열의 오른쪽열 탐색
            // 오른쪽열이 1이면서 방문하지 않은 곳
            if(y<node[x].length-1 && node[x][y]==1 && node[x][y+1] ==1 && check[x][y+1] ==0){
                check[x][y+1] = check[x][y] + 1; // 현재 점이 가지고 있는 경로값을 인접한 점의 방문배열에 저장
                queue.offer(new xy(x,y+1)); //인접한 점을 큐에 넣어줌
            }
            // 기준행의 아래쪽행 탐색
            // 아래쪽행이 1이면서 방문하지 않은 곳
            if(x<node.length-1 && node[x][y]==1 && node[x+1][y] ==1 && check[x+1][y] ==0){
                check[x+1][y] = check[x][y] + 1; // 현재 점이 가지고 있는 경로값을 인접한 점의 방문배열에 저장
                queue.offer(new xy(x+1,y)); //인접한 점을 큐에 넣어줌
            }
            // 기준행의 윗쪽행 탐색
            // 윗쪽행이 1이면서 방문하지 않은 곳
            if(x>0 && node[x][y]==1 && node[x-1][y] ==1 && check[x-1][y] ==0){
                check[x-1][y] = check[x][y] + 1; // 현재 점이 가지고 있는 경로값을 인접한 점의 방문배열에 저장
                queue.offer(new xy(x-1,y)); //인접한 점을 큐에 넣어줌
            }
            // 기준열의 왼쪽열 탐색
            // 왼쪽열이 1이면서 방문하지 않은 곳
            if(y>0 && node[x][y]==1 && node[x][y-1] ==1 && check[x][y-1] ==0){
                check[x][y-1] = check[x][y] + 1; // 현재 점이 가지고 있는 경로값을 인접한 점의 방문배열에 저장
                queue.offer(new xy(x,y-1)); //인접한 점을 큐에 넣어줌
            }

        }
    }
}
