package com.doosane.study01.week03.day04.ex05;

import java.io.*;
import java.util.*;
/*
    백준 문제 7562번 : 나이트의 이동

    문제 분석:
        체스판 위에 한 나이트가 놓여져 있는데, 나이트가 이동하려고 하는 칸이 주어진다.
        나이트는 몇 번 움직이면 이 칸으로 이동할 수 있는지 구한다.

    제약 조건:
        입력의 첫째 줄에는 테스트 케이스의 개수가 주어진다.
        각 테스트 케이스는 세 줄로 이루어져 있다.
        첫째 줄에는 체스판의 한 변의 길이 l(4 ≤ l ≤ 300)이 주어진다.
        체스판의 크기는 l × l이다.
        체스판의 각 칸은 두 수의 쌍 {0, ..., l-1} × {0, ..., l-1}로 나타낼 수 있다.
        둘째 줄과 셋째 줄에는 나이트가 현재 있는 칸, 나이트가 이동하려고 하는 칸이 주어진다.

    의사 결정:
        BFS(너비우선탐색)를 사용해서 나이트가 목표 위치에 도달할 때까지 각 방향으로 이동하며 최단 거리를 탐색한다.
 */
public class BOJ7562 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int testCaseCount = Integer.parseInt(br.readLine()); // 테스트 케이스의 개수 입력

        // 나이트의 8가지 이동 방향 정의
        // 두 칸 수평으로 이동한 후 한 칸 수직으로 이동
        // 두 칸 수직으로 이동한 후 한 칸 수평으로 이동
        int[] dx = {-2, -1, 1, 2, 2, 1, -1, -2};
        // dx는 이동할 수 있는 x축(수평 방향)의 변화

        int[] dy = {1, 2, 2, 1, -1, -2, -2, -1};
        // dy는 이동할 수 있는 y축(수직 방향)의 변화
        /*
        (-2, 1): 두 칸 왼쪽, 한 칸 위
        (-1, 2): 한 칸 왼쪽, 두 칸 위
        ( 1, 2): 한 칸 오른쪽, 두 칸 위
        ( 2, 1): 두 칸 오른쪽, 한 칸 위
        ( 2, -1): 두 칸 오른쪽, 한 칸 아래
        ( 1, -2): 한 칸 오른쪽, 두 칸 아래
        (-1, -2): 한 칸 왼쪽, 두 칸 아래
        (-2, -1): 두 칸 왼쪽, 한 칸 아래
         */
        StringBuilder sb = new StringBuilder();

        for (int t = 0; t < testCaseCount; t++) { // 각 테스트 케이스마다 수행
            int l = Integer.parseInt(br.readLine()); // 체스판의 한 변의 길이 입력

            // 나이트의 시작 위치 입력
            StringTokenizer st = new StringTokenizer(br.readLine());
            int startX = Integer.parseInt(st.nextToken());
            int startY = Integer.parseInt(st.nextToken());

            // 나이트의 목표 위치 입력
            st = new StringTokenizer(br.readLine());
            int endX = Integer.parseInt(st.nextToken());
            int endY = Integer.parseInt(st.nextToken());

            boolean[][] visited = new boolean[l][l]; // 방문 여부를 체크하는 배열
            Queue<int[]> queue = new LinkedList<>(); // BFS를 위한 큐
            queue.add(new int[]{startX, startY, 0}); // 시작 위치와 초기 이동 횟수(0) 추가
            visited[startX][startY] = true; // 시작 위치 방문 처리

            while (!queue.isEmpty()) {
                int[] current = queue.poll(); // 현재 위치와 이동 횟수를 큐에서 꺼냄
                int x = current[0];
                int y = current[1];
                int moves = current[2];

                // 목표 위치에 도달하면 이동 횟수 출력
                if (x == endX && y == endY) {
                    sb.append(moves).append("\n");
                    break;
                }

                // 나이트의 8가지 이동 방향을 탐색
                for (int i = 0; i < 8; i++) {
                    int nx = x + dx[i];
                    int ny = y + dy[i];

                    // 유효한 범위 내에 있고 방문하지 않은 경우
                    if (nx >= 0 && nx < l && ny >= 0 && ny < l && !visited[nx][ny]) {
                        visited[nx][ny] = true; // 방문 처리
                        queue.add(new int[]{nx, ny, moves + 1}); // 다음 위치와 이동 횟수 추가
                    }
                }
            }
        }
        System.out.print(sb.toString()); // 결과 출력
    }
}
