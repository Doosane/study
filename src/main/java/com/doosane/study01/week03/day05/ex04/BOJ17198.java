package com.doosane.study01.week03.day05.ex04;

import java.io.*;
import java.util.*;

/*
    백준 문제 17198번 : Bucket Brigade

    문제 분석:
        가능한 버킷 여단을 형성하는 데 필요한 최소한의 소 수를 나타내는 단일 정수를 출력한다.

    제약 조건:
        양동이는 북쪽, 남쪽, 동쪽 또는 서쪽 방향으로 바로 인접해 있는 소들 사이로 이동할 수 있다.
        호수 옆에 있는 소도 마찬가지이다.
        소는 호수에 바로 인접해 있는 경우에만 호수에서 물통을 꺼낼 수 있다.
        마찬가지로 소는 헛간에 바로 인접해 있는 경우에만 헛간에 물통을 던질 수 있다.
        바위가 있는 사각형에는 소를 놓을 수 없고, 헛간과 호수는 서로 바로 인접해 있지 않아야 한다.

    의사 결정:
        1. 첫째줄에서 BufferedReader로 테스트 케이스 개수를 입력 받아서,
        2. 문자열로 이동횟수를 입력 받아서,
        3. 몇번 움직여야 하는지 BFS 너비우선탐색으로 최단 거리를 계산한다.
        4. BFS로 계산된 값, 가능한 버킷 여단을 형성하는 데 필요한 최소한의 소 수를 출력
 */

public class BOJ17198 {
    private static char[][] board = new char[10][10]; // 10 X 10 형태의 농장을 board로 선언
    private static boolean[][] visited = new boolean[10][10]; // 방문한곳을 visited로 선언
    private static int[] dx = {-1, 1, 0, 0}; // x 축의 방향을 설정
    private static int[] dy = {0, 0, -1, 1}; // y 축의 방향을 설정

    public static void main(String[] args) throws IOException {
        // BufferedReader 를 이용하여 문자열을 입력 받고
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int barnX = 0, barnY = 0, lakeX = 0, lakeY = 0;

        // 입력 처리 및 초기 위치 설정
        for (int i = 0; i < 10; i++) {
            String line = br.readLine();
            for (int j = 0; j < 10; j++) {
                board[i][j] = line.charAt(j);
                if (board[i][j] == 'B') { // 헛간
                    barnX = i;
                    barnY = j;
                }
                if (board[i][j] == 'L') { // 호수
                    lakeX = i;
                    lakeY = j;
                }
            }
        }

        // BFS를 사용하여 계산
        int result = bfs(barnX, barnY, lakeX, lakeY);
        System.out.println(result - 1); // 거리를 계산할 때 출발 위치와 도착 위치를 제외하기 위해 -1
    }

    // BFS를 사용하여 최단 거리 계산
    private static int bfs(int startX, int startY, int endX, int endY) {
        Queue<int[]> queue = new LinkedList<>(); // BFS를 위한 큐
        queue.add(new int[]{startX, startY, 0}); // 시작 위치와 초기 이동횟수(0) 추가

        visited[startX][startY] = true; // 시작 위치 방문 처리

        while (!queue.isEmpty()) { // 큐가 비어있지 않는 조건에서
            int[] current = queue.poll(); // 현재 위치와 거리를 큐에서 꺼냄
            int x = current[0];
            int y = current[1];
            int distance = current[2];

            // 목표 위치에 도달하면 거리 출력
            if (x == endX && y == endY) {
                return distance;
            }

            // 이동 방향 탐색
            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];

                // 유효한 범위에 있고 , 방문하지 않은 경우
                if (nx >= 0 &&  nx < 10 &&  ny >= 0 && ny < 10 && !visited[nx][ny] && board[nx][ny] != 'R') { // 'R' 큰 바위의 위치
                    visited[nx][ny] = true; // 방문 처리
                    queue.add(new int[]{ nx, ny, distance + 1}); // 다음 위치, 이동 횟수 추가
                }
            }
        }
        return -1; // 경로가 없을 경우
    }
}