package com.haeuni.cando.week3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Bus{
    int start;
    int end;
    int time;
    public Bus(int start, int end, int time){
        this.start = start;
        this.end = end;
        this.time = time;
    }
}
// 11657
public class Dijkstra3_Step1 {
    private static int n,m;
    private static Bus[] bus;
    private static long[] dist;
    private static int INF = Integer.MAX_VALUE;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        bus = new Bus[m];
        dist = new long[n+1];

        // 최단 거리 테이블 초기화
        for(int i =1; i < n+1; i++){
            dist[i] = INF;
        }

        for(int i = 0; i < m ;i++){
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int time = Integer.parseInt(st.nextToken());
            bus[i] = new Bus(start, end, time);
        }
        if(bellmanford(1)){
            System.out.println("-1");
        }else{
            // 1번 노드를 제외한 다른 모든 노드로 가기 위한 최단거리 출력
            for(int i = 2; i <n+1; i++){
                if(dist[i] == INF){ // 도달할 수 없을 경우 -1
                    System.out.println("-1");
                }else{
                    System.out.println(dist[i]);
                }
            }
        }
    }
    private static boolean bellmanford(int start){
        dist[start] = 0;
        for(int i =1; i < n+1; i++){
            for(int j = 0; j < m; j++){
                int cur = bus[j].start;
                int next = bus[j].end;
                int cost = bus[j].time;
                if(dist[cur] == INF) continue;
                // 현재 간선을 거쳐서 다른 노드로 이동하는 거리가 짦은 경우
                if(dist[next] > (dist[cur] + cost)){
                    dist[next] = dist[cur] + cost;
                    // n번째에 값이 갱신된다면 음수 존재
                    if(i == n){
                        return true;
                    }
                }

            }
        }
        return false;
    }
}
