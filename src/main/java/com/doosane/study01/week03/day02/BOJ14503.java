package com.doosane.study01.week03.day02;

import java.util.*;

/*
    백준 문제 14503번 : 로봇 청소기

    문제 분석:
    로봇 청소기가 주어진 방을 청소할 수 있는 영역의 개수를 구하는 문제.
    청소는 주어진 규칙에 따라 수행되며, 로봇 청소기는 방의 벽에 부딪히지 않고 청소를 계속 수행한다.

    의사 결정:
    1. scanner 사용 , 방의 크기 N,M , 로봇청소기의 현재 위치와 방향 r, c, d를 입력 받는다.
    2. 방의 상태를 반복문으로 입력하고, 청소한 칸의 개수를 count 변수에 담아 출력
    3. while 조건문에서 , 로봇 청소기가 이동하는 방향에 따라 계산 , 이동할 좌표에 따라 청소 범위 계산
    4. 계산한 청소 범위 출력
     */

public class BOJ14503 {
    static int N, M; // 방의 크기 (N x M)
    static int[][] map; // 방의 상태를 저장할 배열 (0: 빈 칸, 1: 벽)
    static boolean[][] cleaned; // 청소 상태를 저장할 배열 (true: 청소 완료, false: 미청소)
    static int r, c, d; // 로봇 청소기의 현재 위치와 방향
    static int[] dx = {-1, 0, 1, 0}; // 이동을 위한 x 방향 배열 (북, 동, 남, 서)
    static int[] dy = {0, 1, 0, -1}; // 이동을 위한 y 방향 배열 (북, 동, 남, 서)

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // 입력값 처리
        N = sc.nextInt();
        M = sc.nextInt();
        r = sc.nextInt();
        c = sc.nextInt();
        d = sc.nextInt();

        map = new int[N][M];
        cleaned = new boolean[N][M];

        // 방의 상태 입력
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                map[i][j] = sc.nextInt();
            }
        }

        // 청소 시작
        int count = cleanRoom();
        System.out.println(count); // 청소한 칸의 개수 출력
    }

    public static int cleanRoom() {
        int cleanedCount = 0; // 청소한 칸의 개수

        while (true) {
            // 1. 현재 위치를 청소한다.
            if (!cleaned[r][c]) {
                cleaned[r][c] = true; // 현재 위치를 청소 상태로 변경
                cleanedCount++; // 청소한 칸의 개수 증가
            }

            boolean cleanedOrWallAround = true; // 주위에 청소할 곳이 있는지 확인
            for (int i = 0; i < 4; i++) {
                int nd = (d + 3) % 4; // 현재 방향 기준으로 왼쪽 방향 계산
                int nx = r + dx[nd]; // 왼쪽 방향으로 이동할 x 좌표
                int ny = c + dy[nd]; // 왼쪽 방향으로 이동할 y 좌표

                // 청소하지 않은 공간이 있으면 그 방향으로 전진
                if (nx >= 0 && nx < N && ny >= 0 && ny < M && !cleaned[nx][ny] && map[nx][ny] == 0) {
                    r = nx; // 새로운 위치로 이동
                    c = ny; // 새로운 위치로 이동
                    d = nd; // 새로운 방향으로 설정
                    cleanedOrWallAround = false; // 주위에 청소할 곳 있음
                    break;
                }

                // 방향을 왼쪽으로 회전
                d = nd;
            }

            if (cleanedOrWallAround) {
                // 네 방향 모두 청소가 이미 되어 있거나 벽인 경우
                int backDirection = (d + 2) % 4; // 후진할 방향 계산
                int bx = r + dx[backDirection]; // 후진할 x 좌표
                int by = c + dy[backDirection]; // 후진할 y 좌표

                // 후진할 수 있으면 후진
                if (bx >= 0 && bx < N && by >= 0 && by < M && map[bx][by] == 0) {
                    r = bx; // 후진 위치로 이동
                    c = by; // 후진 위치로 이동
                } else {
                    // 후진할 수 없으면 작동을 멈춘다.
                    break;
                }
            }
        }

        return cleanedCount; // 청소한 칸의 총 개수 반환
    }
}
