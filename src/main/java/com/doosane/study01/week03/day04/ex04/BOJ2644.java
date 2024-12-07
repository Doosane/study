package com.doosane.study01.week03.day04.ex04;
import java.io.*;
import java.util.*;

/*
    백준 문제 2644번 : 촌수 계산

    문제 분석
        촌수 관계를 계산하는 문제
        관계가 없으면 -1
        친척관계 탐색 후 , 촌수 계산

    제약 조건
         사람들은 1, 2, 3, …, n (1 ≤ n ≤ 100)의 연속된 번호로 각각 표시된다.
         입력 파일의 첫째 줄에는 전체 사람의 수 n이 주어지고,
         둘째 줄에는 촌수를 계산해야 하는 서로 다른 두 사람의 번호가 주어진다.
         그리고 셋째 줄에는 부모 자식들 간의 관계의 개수 m이 주어진다.
         넷째 줄부터는 부모 자식간의 관계를 나타내는 두 번호 x,y가 각 줄에 나온다.
         이때 앞에 나오는 번호 x는 뒤에 나오는 정수 y의 부모 번호를 나타낸다.
         각 사람의 부모는 최대 한 명만 주어진다.

    의사 결정
        1. 그래프 표현 ( ArrayList를 사용한 인접 리스트 형태 ) ( 노드 번호  N + 1 ) 설정
        2. BFS 사용하여 ( 최단 경로 탐색 )
        3. 방문 여부 boolean[] visited를 사용하여 이미 탐색한 부분은 처리
        4. 도달하지 못하면 -1 반환

    메모리  시간
    15760	116
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