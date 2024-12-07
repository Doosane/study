package com.doosane.study01.week03.day04;
import java.io.*;
import java.util.*;

/*
    백준 문제 24479번 깊이 우선 탐색 1

    문제 분석 :
        정점 R에서 시작하여 깊이 우선 탐색으로 노드를 방문할 경우 노드의 방문 순서를 출력

    제약 조건 :
        첫째 줄에 정점의 수 N (5 ≤ N ≤ 100,000), 간선의 수 M (1 ≤ M ≤ 200,000), 시작 정점 R (1 ≤ R ≤ N)이 주어진다.

    의사 결정 :
        1. BufferedReader 사용, 입력 받고
        2. 정점번호, 간선의 가중치를 고려한 계산후, 첫째 줄부터 N개의 줄에 정수를 한개 씩 출력한다.
        3. i번째 줄에는 정점 i의 방문 순서를 출력한다.
        4. 시작 정점에서 방문할 수 없는 경우 0을 출력한다.
 */
public class BOJ24479 {
    private static int N; // 정점 수
    private static int M; // 간선 수
    private static int R; // 시작 정점

    private static List<Integer>[] graph; // 그래프 인접 리스트
    private static boolean[] visited; // 방문 여부 체크
    private static int[] visitOrder; // 방문 순서를 저장
    private static int order = 1; // 방문 순서 카운터
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken()); // 정점의 수
        M = Integer.parseInt(st.nextToken()); // 간선의 수
        R = Integer.parseInt(st.nextToken()); // 시작 정점

        graph = new ArrayList[N + 1]; // 그래프 초기화 인접 리스트 사용

        for (int i = 1; i <= N; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int i = 0; i < M; i++) { // 간선 정보 입력 및 그래프 구성
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            graph[u].add(v);
            graph[v].add(u);
        }

        for (int i = 1; i <= N; i++) { // 각 정점의 인접 리스트를 오름차순으로 정렬
            Collections.sort(graph[i]);
        }

        visited = new boolean[N + 1]; // 방문 여부 배열 초기화
        visitOrder = new int[N + 1];  // 방문 순서 배열 초기화

        dfs(R); // 깊이 우선 탐색 시작

        for (int i = 1; i <= N; i++) { // 각 정점의 방문 순서를 출력
            System.out.println(visitOrder[i]);
        }
    }

    // 깊이 우선 탐색 (DFS) 재귀
    private static void dfs(int node) {
        visited[node] = true; // 현재 노드를 방문처리
        visitOrder[node] = order++; // 방문 순서를 기록

        for( int next : graph[node]) { // 현재 노드의 인접 노드를 탐색
            if( !visited[next]) { // 방문하지 않은 노드가 있으면
                dfs(next); // 재귀적으로 DFS 수행
            }
        }
    }
}