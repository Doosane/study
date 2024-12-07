package com.doosane.study01.week03.day04.ex04;

import java.io.*;
import java.util.*;

/*
    백준 문제 2644번 : 촌수 계산

    문제 분석:
        주어진 입력에서 촌수를 계산해야 하는 두 사람의 번호가 주어지고,
        부모 자식 관계가 주어집니다. 관계를 바탕으로 두 사람 사이의 촌수를 계산한다.
        관계가 없으면 -1을 출력한다.

    제약 조건:
        - 사람들은 1부터 n까지의 연속된 번호로 표시된다.
        - 전체 사람의 수 n은 1 ≤ n ≤ 100 이다
        - 입력의 첫 번째 줄에는 전체 사람의 수 n이 주어진다.
        - 두 번째 줄에는 촌수를 계산해야 하는 서로 다른 두 사람의 번호가 주어진다.
        - 세 번째 줄에는 부모 자식 간의 관계의 개수 m이 주어진다.
        - 이후 m개의 줄에는 두 번호 x, y가 주어지며, x는 y의 부모 번호를 나타낸다.
        - 각 사람의 부모는 최대 한 명만 주어진다.

    의사 결정:
        1. 그래프 표현 (ArrayList를 사용한 인접 리스트 형태) (노드 번호 1부터 N까지) 설정한다.
        2. BFS를 사용하여 최단 경로를 탐색한다.
        3. 방문 여부를 체크하기 위해 boolean[] visited를 사용한다.
        4. 촌수를 계산하여 출력하며, 도달하지 못하면 -1을 반환한다.
 */

public class BOJ2644 {

    static int N, M; // 총 사람의 수와 부모 자식 관계 수
    static boolean[] visited; // 방문 여부 체크
    static List<Integer>[] relation; // 인접 리스트를 통한 관계 저장

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        // 입력
        N = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        int start = Integer.parseInt(st.nextToken()); // 촌수 계산 시작하는 사람
        int target = Integer.parseInt(st.nextToken()); // 촌수를 계산할 목표 사람
        M = Integer.parseInt(br.readLine()); // 부모-자식 관계 수

        // 촌수 관계 초기화
        relation = new ArrayList[N + 1];
        for (int i = 1; i <= N; i++) {
            relation[i] = new ArrayList<>();
        }

        // 부모-자식 관계 입력
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int parent = Integer.parseInt(st.nextToken());
            int child = Integer.parseInt(st.nextToken());
            relation[parent].add(child); // 양방향 관계 설정
            relation[child].add(parent);
        }

        // 방문 여부 초기화
        visited = new boolean[N + 1];

        // BFS 탐색 시작
        int result = bfs(start, target);

        // 결과 출력
        bw.write(result + "\n");
        bw.flush();
        bw.close();
        br.close();
    }

    // BFS 탐색 메서드
    private static int bfs(int start, int target) {
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{start, 0}); // 시작 지점과 초기 촌수를 큐에 추가
        visited[start] = true; // 시작 지점 방문 처리

        while (!queue.isEmpty()) {
            int[] current = queue.poll(); // 현재 위치와 촌수 정보
            int node = current[0];
            int depth = current[1];

            if (node == target) {
                return depth; // 목표 지점에 도달하면 촌수 반환
            }

            // 인접 노드 탐색
            for (int i = 0; i < relation[node].size(); i++) {
                int nextNode = relation[node].get(i);
                if (!visited[nextNode]) {
                    queue.add(new int[]{nextNode, depth + 1}); // 다음 노드와 촌수를 큐에 추가
                    visited[nextNode] = true; // 방문 처리
                }
            }
        }
        return -1; // 촌수 계산이 불가능한 경우 -1 반환
    }
}
