package com.doosane.study01.week03.day03.ex04;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/*
    백준 문제 3187번 : 양치기 꿍

    문제 분석:
        주어진 농장 지도에서 양과 늑대의 위치를 파악하고,
        서로 다른 영역에서 양과 늑대의 수를 세어 양이 늑대보다 많으면 양이 살아남고,
        늑대가 양보다 많으면 늑대가 살아남는다.

    제약 조건:
        농장의 크기는 R x C (1 ≤ R, C ≤ 250)
        각 칸은 빈 칸, 양, 늑대, 울타리로 구성된다.

    의사 결정:
        1. 농장 지도를 2차원 배열로 입력받는다.
        2. BFS를 사용하여 각 영역을 탐색하고, 양과 늑대의 수를 센다.
        3. 각 영역에서 양과 늑대의 수에 따라 결과를 계산한다.
 */
public class BOJ3187 {
    static int R, C; // 농장의 크기 (행, 열)
    static char[][] farm; // 농장 지도
    static boolean[][] visited; // 방문 여부를 체크하는 배열

    // 이동 방향 정의 (상, 하, 좌, 우)
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 농장의 크기 R(행)과 C(열)을 입력받음
        String[] dimensions = br.readLine().split(" ");
        R = Integer.parseInt(dimensions[0]);
        C = Integer.parseInt(dimensions[1]);

        // 농장 지도와 방문 여부 배열 초기화
        farm = new char[R][C];
        visited = new boolean[R][C];

        // 농장 지도 입력 처리
        for (int i = 0; i < R; i++) {
            farm[i] = br.readLine().toCharArray(); // 한 줄씩 입력받아 문자 배열로 변환하여 저장
        }

        int totalSheep = 0; // 총 양의 수
        int totalWolves = 0; // 총 늑대의 수

        // 농장 지도를 탐색하여 각 영역의 양과 늑대 수를 계산
        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                // 방문하지 않았고 울타리가 아닌 경우에만 탐색
                if (!visited[i][j] && farm[i][j] != '#') {
                    // BFS를 사용하여 현재 영역의 양과 늑대 수를 계산
                    int[] result = bfs(i, j);
                    int sheep = result[0];
                    int wolves = result[1];

                    // 양과 늑대의 수에 따라 결과를 업데이트
                    if (sheep > wolves) {
                        totalSheep += sheep;
                    } else {
                        totalWolves += wolves;
                    }
                }
            }
        }

        // 최종 결과 출력 (총 양의 수와 총 늑대의 수)
        System.out.println(totalSheep + " " + totalWolves);
    }

    // BFS를 사용하여 각 영역을 탐색하고 양과 늑대의 수를 센다
    static int[] bfs(int x, int y) {
        Queue<int[]> queue = new LinkedList<>(); // BFS 큐 생성
        queue.add(new int[] {x, y}); // 시작 지점을 큐에 추가
        visited[x][y] = true; // 시작 지점을 방문 처리

        int sheep = 0; // 현재 영역의 양의 수
        int wolves = 0; // 현재 영역의 늑대 수

        // 시작 지점에 있는 양과 늑대의 수 체크
        if (farm[x][y] == 'k') sheep++;
        if (farm[x][y] == 'v') wolves++;

        // 큐가 빌 때까지 BFS 탐색
        while (!queue.isEmpty()) {
            int[] current = queue.poll(); // 큐에서 현재 노드 꺼내기
            int cx = current[0];
            int cy = current[1];

            // 상하좌우 인접한 노드 탐색
            for (int i = 0; i < 4; i++) {
                int nx = cx + dx[i];
                int ny = cy + dy[i];

                // 유효한 범위 내에 있고, 방문하지 않았으며 울타리가 아닌 경우
                if (nx >= 0 && nx < R && ny >= 0 && ny < C && !visited[nx][ny] && farm[nx][ny] != '#') {
                    visited[nx][ny] = true; // 방문 처리
                    queue.add(new int[] {nx, ny}); // 큐에 추가

                    // 인접한 지점에 있는 양과 늑대의 수 체크
                    if (farm[nx][ny] == 'k') sheep++;
                    if (farm[nx][ny] == 'v') wolves++;
                }
            }
        }

        return new int[] {sheep, wolves}; // 현재 영역의 양과 늑대 수 반환
    }
}
