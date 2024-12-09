package com.doosane.study01.week03.day05.ex03;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

/*
 백준 문제 2606번 : 바이러스

 문제 분석:
    어느 날 1번 컴퓨터가 웜 바이러스에 걸렸을 때, 컴퓨터의 수와 네트워크 상에서 서로 연결되어 있는 정보가 주어질 때,
    1번 컴퓨터를 통해 웜 바이러스에 걸리게 되는 컴퓨터의 수를 출력하는 프로그램을 작성

 제약 조건:
    컴퓨터의 수는 100 이하인 양의 정수이고 각 컴퓨터에는 1번 부터 차례대로 번호가 매겨진다.

 의사 결정:
    1. static으로 방문여부체크를 visited , 네트워크 연결정보를 network , 감염된 컴퓨터 수를 count로 선언한다.
    2. BufferedReader를 이용해서 컴퓨터의 수 computerCount 와 네트워크상 직접 연결되어 있는 컴퓨터 directConnect를 입력받는다.
    3. 네트워크의 전체 컴퓨터를  ArrayList 사용해서 배열로 할당한다.
    4. 컴퓨터 개수만큼 반복문을 돌려서, 네트워크 배열에 넣어준다.
    5. 반복문으로 네트워크 직접 연결된 컴퓨터를 StringTokenizer로 토큰화 해서 네트워크에 넣어준다.
    6. DFS(깊이 우선 탐색)으로 방문하지 않은 노드를 재귀로 계속 탐색해서 카운트 한다.
    7. 1번 컴퓨터를 제외한 감염된 컴퓨터를 출력한다.
 */

public class BOJ2606 {
    private static boolean[] visited; // 방문 여부 체크
    private static List<Integer>[] network;// 네트워크 연결 정보
    private static int count = 0; // 감염된 컴퓨터 수

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); // BufferedReader로 입력 받고, InputStreamReader를 같이 사용하여 속도 향상, 메모리 효율 높인다.
        int computerCount = Integer.parseInt(br.readLine()); // 컴퓨터의 수
        int directConnect = Integer.parseInt(br.readLine()); // 네트워크 상에서 직접 연결되어 있는 컴퓨터

        network = new ArrayList[computerCount + 1]; // 네트워크의 전체 컴퓨터를  ArrayList 사용해서 배열로 할당

        for(int i=1; i<= computerCount; i++) {  // 컴퓨터 개수만큼 반복문을 돌려서, 네트워크 배열에 넣어준다.
            network[i] = new ArrayList<>();
        }

        for(int i=0; i<directConnect; i++) {  // 반복문으로 네트워크 직접 연결된 컴퓨터를
            StringTokenizer st = new StringTokenizer(br.readLine());    // StringTokenizer로 토큰화 해서 네트워크에 넣어준다.
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            network[u].add(v);
            network[v].add(u);
        }

        visited = new boolean[computerCount + 1];

        dfs(1); // 깊이 우선 탐색

        System.out.println(count -1); // 1번 컴퓨터를 제외한 감염된 컴퓨터 출력
    }

    // 깊이우선탐색 , 방문하지 않은 노드를 재귀로 계속 탐색해서 카운트
    private static void dfs(int node) {
        visited[node] = true;
        count++; // 감염된 컴퓨터 숫자 카운트

        for (int next : network[node]) {
            if (!visited[next]) {
                dfs(next); // 방문하지 않은 노드를 재귀로 계속 탐색
            }
        }

    }

}