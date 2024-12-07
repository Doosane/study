package com.doosane.study01.week03.day04.ex02;
import java.io.*;
import java.util.*;
/*
    백준 문제 24444번 : 알고리즘 수업 - 너비 우선 탐색 1

    문제 분석:
        정점 R에서 시작하여 너비 우선 탐색으로 노드를 방문할 경우 노드의 방문 순서를 출력

    제약 조건:
        첫째 줄에 정점의 수 N (5 ≤ N ≤ 100,000), 간선의 수 M (1 ≤ M ≤ 200,000), 시작 정점 R (1 ≤ R ≤ N)이 주어진다.
        다음 M개 줄에 간선 정보 u v가 주어지며 정점 u와 정점 v의 가중치 1인 양방향 간선을 나타낸다.
        (1 ≤ u < v ≤ N, u ≠ v) 모든 간선의 (u, v) 쌍의 값은 서로 다르다.

    의사 결정:
        1. 문자를 입력 받아
        2. 첫째 줄부터 N개의 줄에 정수를 한 개씩 출력한다.
        3. i번째 줄에는 정점 i의 방문 순서를 출력한다.
        4. 시작 정점의 방문 순서는 1이다.
        5. 시작 정점에서 방문할 수 없는 경우 0을 출력한다.
 */
public class BOJ24444 {
    private static int N; // 정점 수
    private static int M; // 간선 수
    private static int R; // 시작 정점

    private static List<Integer>[] graph; // 그래프 인접 리스트

    private static boolean[] visited; // 방문 여부 체크
    private static int[] visitOrder; // 방문 순서를 저장
    private static int order = 1;  // 방문 순서 카운터

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken()); // 정점의 수
        M = Integer.parseInt(st.nextToken()); // 간선의 수
        R = Integer.parseInt(st.nextToken()); // 시작 정점

        // 그래프 초기화 (인접 리스트 사용)
        graph = new ArrayList[N + 1];
        for (int i = 1; i <= N; i++) {
            graph[i] = new ArrayList<>();
        }

        // 간선 정보 입력 및 그래프 구성
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            graph[u].add(v);
            graph[v].add(u);
        }

        // 각 정점의 인접 리스트를 오름차순으로 정렬
        for (int i = 1; i <= N; i++) {
            Collections.sort(graph[i]);
        }

        visited = new boolean[N + 1]; // 방문 여부 배열 초기화
        visitOrder = new int[N + 1]; // 방문 순서 배열 초기화

        // 너비 우선 탐색 시작
        bfs(R);

        // 각 정점의 방문 순서를 출력
        for (int i = 1; i <= N; i++) {
            System.out.println(visitOrder[i]);
        }
    }

    // 너비 우선 탐색 (BFS)
    private static void bfs(int start) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(start);
        visited[start] = true; // 시작 정점을 방문 처리
        visitOrder[start] = order++; // 시작 정점의 방문 순서를 기록

        while (!queue.isEmpty()) {
            int currentNode = queue.poll();

            // 현재 노드의 인접 노드들을 탐색
            for (int nextNode : graph[currentNode]) {
                if (!visited[nextNode]) { // 방문하지 않은 노드가 있으면
                    queue.add(nextNode);
                    visited[nextNode] = true; // 방문 처리
                    visitOrder[nextNode] = order++; // 방문 순서를 기록
                }
            }
        }
    }
}