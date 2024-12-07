package com.doosane.study01.week03.day04.ex04;
import java.io.*;
import java.util.*;

/**
 * - 문제 이해
 * - BFS
 * - N
 *   메모리  시간
 * 	15760	116
 */

/*
9     -> 전체 사람의 수 n
7 3   -> 촌수를 계산해야 하는 서로 다른 두사람의 번호 start , end
7     -> 부모 자식들 간의 관계의 개수 m
 */
public class BOJ2644 {

    static int N, M; // 총 사람의 수
    static boolean[] visited;
    static List<Integer>[] relation;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        // 입력
        N = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        int start = Integer.parseInt(st.nextToken()); // 촌수 계산 시작
        int target = Integer.parseInt(st.nextToken()); // 촌수 에임
        M = Integer.parseInt(br.readLine()); // 부모-자식 관계 수

        // 촌수 초기화
        relation = new ArrayList[N + 1];
        for (int i = 1; i <= N; i++) {
            relation[i] = new ArrayList<>();
        }

        // 촌수 입력
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int parent = Integer.parseInt(st.nextToken());
            int child = Integer.parseInt(st.nextToken());
            relation[parent].add(child); // 양방향이여서 관계
            relation[child].add(parent);
        }

        // 탐색한곳 visited
        visited = new boolean[N + 1];

        // bfs 탐색
        int result = bfs(start, target);

        // 출력
        bw.write(result + "\n");
        bw.flush();
        bw.close();
        br.close();
    }

    // bfs 탐색 시작
    private static int bfs(int start, int target) {
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{start, 0}); // 시작 지점
        visited[start] = true; // 방문처리 ( 처음시작이니깐 )

        while (!queue.isEmpty()) {
            int[] current = queue.poll(); // 현재 위치 ( 촌수 )
            int node = current[0];
            int depth = current[1];

            if ( node == target) {
                return depth; // 시작점으로 부터 거리
            }

            //  탐색
            for(int i = 0; i < relation[node].size(); i++) {
                if (!visited[relation[node].get(i)]) {
                    queue.add(new int[]{relation[node].get(i), depth + 1});
                    visited[relation[node].get(i)] = true;
                }
            }
        }
        return -1; // 촌수 계산이 안되는 경우
    }
}