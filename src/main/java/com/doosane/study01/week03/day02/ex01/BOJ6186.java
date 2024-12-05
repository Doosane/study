package com.doosane.study01.week03.day02.ex01;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
백준 문제 6186번 : BestGrass

문제 분석:
    농장지도가 주어졌을 때, 'g'는 풀이 자란 곳을 나타내고, '.'는 풀이 없는 곳을 나타냄.
    연속된 풀이 있는 영역을 하나의 덩어리로 계산하여 총 덩어리 개수를 출력하는 프로그램 작성

제약 조건:
    첫째 줄에 농장의 세로 크기 H와 가로 크기 W가 주어진다. (1 ≤ H, W ≤ 100)
    둘째 줄부터 H개의 줄에 W개의 문자가 주어진다.

의사 결정:
    1. 농장 지도를 2차원 배열로 입력받아 저장한다.
    2. 깊이 우선 탐색(DFS)을 사용하여 풀이 있는 영역을 탐색하고, 탐색된 영역은 방문 처리한다.
    3. DFS로 풀이 있는 모든 영역을 탐색하여 덩어리 개수를 센다.
 */

public class BOJ6186 {
    private static int H, W; // 농장의 세로 크기와 가로 크기
    private static char[][] farm; // 농장 지도를 저장할 2차원 배열
    private static boolean[][] visited; // 방문 여부를 저장할 2차원 배열

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] dimensions = br.readLine().split(" ");
        H = Integer.parseInt(dimensions[0]); // 농장의 세로 크기 입력
        W = Integer.parseInt(dimensions[1]); // 농장의 가로 크기 입력

        farm = new char[H][W]; // 농장 지도 배열 초기화
        visited = new boolean[H][W]; // 방문 여부 배열 초기화

        // 농장 지도 입력
        for (int i = 0; i < H; i++) {
            String line = br.readLine();
            for (int j = 0; j < W; j++) {
                farm[i][j] = line.charAt(j); // 각 칸에 대한 입력
            }
        }

        int grass = 0; // 풀 덩어리의 개수 초기화
        // 농장 지도를 순회하면서 풀 덩어리의 개수 계산
        for (int i = 0; i < H; i++) {
            for (int j = 0; j < W; j++) {
                if (farm[i][j] == 'g' && !visited[i][j]) { // 풀이 자란 곳이고 아직 방문하지 않은 경우
                    dfs(i, j); // 깊이 우선 탐색으로 연결된 영역 모두 탐색
                    grass++; // 풀 덩어리의 개수 증가
                }
            }
        }

        // 결과 출력
        System.out.println(grass);
    }

    // 깊이 우선 탐색(DFS)으로 풀이 있는 영역 탐색
    private static void dfs(int x, int y) {
        // 경계 조건 확인
        if (x < 0 || x >= H || y < 0 || y >= W || farm[x][y] != 'g' || visited[x][y]) {
            return; // 범위를 벗어나거나 풀이 아니거나 이미 방문한 경우 반환
        }

        visited[x][y] = true; // 방문 처리

        // 탐색할 방향들 (상, 하, 좌, 우)
        int[] dx = {-1, 1, 0, 0};
        int[] dy = {0, 0, -1, 1};

        for (int i = 0; i < 4; i++) {
            dfs(x + dx[i], y + dy[i]); // 각 방향으로 DFS 호출
        }
    }
}
