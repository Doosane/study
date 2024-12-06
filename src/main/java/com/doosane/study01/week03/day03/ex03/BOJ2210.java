package com.doosane.study01.week03.day03.ex03;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

/*
    백준 문제 2210번 : 숫자판 점프

    문제 분석:
        숫자판이 주어졌을 때, 만들 수 있는 서로 다른 여섯 자리의 수들의 개수를 구하는 프로그램을 작성

    제약 조건:
        숫자판의 크기는 5x5
        임의의 위치에서 시작하여 상하좌우로 다섯 번 이동하여 여섯 자리 숫자를 만든다.

    의사 결정:
        1. 숫자판을 5x5 배열로 입력
        2. DFS를 사용하여 모든 가능한 경로를 탐색
        3. HashSet을 사용하여 고유한 여섯 자리 숫자를 저장하고 개수를 출력
 */
public class BOJ2210 {
    // 상수 정의: 숫자판 크기와 만들 숫자의 길이
    private static final int SIZE = 5; // 숫자판 크기
    private static final int LENGTH = 6; // 숫자의 길이 (6자리)

    // 변수 정의: 숫자판과 고유한 숫자를 저장할 HashSet
    private static int[][] board;
    private static Set<String> uniqueNumbers;

    // 방향 정의: 상하좌우 이동을 위한 배열
    private static int[] dx = {0, 0, -1, 1};
    private static int[] dy = {-1, 1, 0, 0};

    public static void main(String[] args) throws IOException {
        // BufferedReader를 사용하여 입력을 받음
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 숫자판 배열 초기화
        board = new int[SIZE][SIZE];
        // 고유한 여섯 자리 숫자를 저장할 HashSet 초기화
        uniqueNumbers = new HashSet<>();

        // 숫자판 입력 처리
        for (int i = 0; i < SIZE; i++) {
            String[] line = br.readLine().split(" ");
            for (int j = 0; j < SIZE; j++) {
                board[i][j] = Integer.parseInt(line[j]);
            }
        }

        // 모든 시작 위치에서 DFS 탐색 수행
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                dfs(i, j, 0, ""); // DFS 탐색 시작
            }
        }

        // 고유한 여섯 자리 숫자의 개수를 출력
        System.out.println(uniqueNumbers.size());
    }

    // DFS 메서드: 현재 위치 (x, y)에서 여섯 자리 숫자를 만드는 함수
    private static void dfs(int x, int y, int depth, String number) {
        if (depth == LENGTH) { // 여섯 자리 숫자를 완성한 경우
            uniqueNumbers.add(number); // 고유한 숫자로 HashSet에 추가
            return; // 탐색 종료
        }

        // 상하좌우로 이동하면서 DFS 탐색
        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];
            // 이동 가능한 위치인지 확인
            if (nx >= 0 && nx < SIZE && ny >= 0 && ny < SIZE) {
                dfs(nx, ny, depth + 1, number + board[x][y]); // 다음 위치로 이동하며 숫자 생성
            }
        }
    }
}
