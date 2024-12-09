package com.doosane.study01.week03.day05.ex02;

import java.io.*;
import java.util.*;

/*
    백준 문제 18352번 : 특정 거리의 도시 찾기
    문제 분석:
        특정한 도시 X로부터 출발하여 도달할 수 있는 모든 도시 중에서,
        최단 거리가 정확히 K인 모든 도시들의 번호를 출력하는 프로그램을 작성

     제약 조건:
        첫째 줄에 도시의 개수 N, 도로의 개수 M, 거리 정보 K, 출발 도시의 번호 X가 주어진다.
        (2 ≤ N ≤ 300,000, 1 ≤ M ≤ 1,000,000, 1 ≤ K ≤ 300,000, 1 ≤ X ≤ N)
        둘째 줄부터 M개의 줄에 걸쳐서 두 개의 자연수 A, B가 공백을 기준으로 구분되어 주어진다.
        이는 A번 도시에서 B번 도시로 이동하는 단방향 도로가 존재한다는 의미다.
        (1 ≤ A, B ≤ N) 단, A와 B는 서로 다른 자연수이다.

    의사 결정:
         X로부터 출발하여 도달할 수 있는 도시 중에서, 최단 거리가 K인 모든 도시의 번호를 한 줄에 하나씩 오름차순으로 출력한다.
         이 때 도달할 수 있는 도시 중에서, 최단 거리가 K인 도시가 하나도 존재하지 않으면 -1을 출력한다.
 */
public class BOJ18352 {
    public static void main(String[] args) throws IOException {
        // 입력을 받기 위해 BufferedReader를 사용
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()); // 첫 번째 줄의 입력을 받아 공백을 기준으로 분리

        int n = Integer.parseInt(st.nextToken());  // 도시의 개수를 정수형으로 변환하여 변수 n에 저장
        int m = Integer.parseInt(st.nextToken());  // 도로의 개수를 정수형으로 변환하여 변수 m에 저장
        int k = Integer.parseInt(st.nextToken());  // 거리 정보를 정수형으로 변환하여 변수 k에 저장
        int x = Integer.parseInt(st.nextToken());  // 출발 도시의 번호를 정수형으로 변환하여 변수 x에 저장

        // 도시 간의 연결 관계를 저장할 리스트 배열을 초기화
        List<Integer>[] graph = new ArrayList[n + 1];

        // 각 리스트 배열을 ArrayList로 초기화
        for (int i = 1; i <= n; i++) {
            graph[i] = new ArrayList<>();
        }

        // 도로 정보를 입력받아 그래프에 추가
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());  // 도로의 시작 도시 a를 정수형으로 변환하여 저장
            int b = Integer.parseInt(st.nextToken()); // 도로의 끝 도시 b를 정수형으로 변환하여 저장

            // 시작 도시 a에서 끝 도시 b로의 단방향 도로를 그래프에 추가
            graph[a].add(b);
        }

        // 각 도시의 거리를 저장할 배열을 초기화한다. 초기값은 -1.
        int[] distance = new int[n + 1];
        Arrays.fill(distance, -1);

        // 출발 도시의 거리는 0으로 설정
        distance[x] = 0;

        // BFS 탐색을 위한 큐를 초기화하고 출발 도시를 추가
        Queue<Integer> queue = new LinkedList<>();
        queue.add(x);

        // 큐가 빌 때까지 반복
        while (!queue.isEmpty()) {
            // 큐에서 현재 도시를 꺼낸다.
            int current = queue.poll();
            // 현재 도시와 연결된 모든 도시를 탐색

            for (int next : graph[current]) {
                // 방문하지 않은 도시라면
                if (distance[next] == -1) {
                    // 다음 도시의 거리를 현재 도시의 거리 +1로 설정
                    distance[next] = distance[current] + 1;
                    // 다음 도시를 큐에 추가
                    queue.add(next);
                }
            }
        }

        // 최단 거리가 K인 도시가 있는지 여부를 나타내는 변수를 초기화
        boolean found = false;

        // 모든 도시를 탐색하여
        for (int i = 1; i <= n; i++) {
            // 최단 거리가 K인 도시를 찾으면
            if (distance[i] == k) {
                // 해당 도시의 번호를 출력
                System.out.println(i);

                // 최단 거리가 K인 도시가 있음을 표시
                found = true;
            }
        }

        // 최단 거리가 K인 도시가 없다면 -1을 출력
        if (!found) {
            System.out.println(-1);
        }
    }
}