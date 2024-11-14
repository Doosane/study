package com.doosane.study01.week01.bronze;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Week02_03_team_BOJ_10994 {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(reader.readLine());

        // 등차수열
        // n = 1 이면 테두리 1, n = 2 이면 5, n = 3 이면 9
        // 4씩 증가하는 등차수열임을 알 수 있다.
        // 등차 수열 식 = 1 + (n - 1) * 4 = 4 * n - 3
        int size = 4 * n - 3; // 테두리의 크기
        char[][] pattern = new char[size][size];

        // 배열을 공백으로 초기화한다.
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                pattern[i][j] = ' ';
            }
        }

        drawStar(pattern, n, 0, size);

        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                System.out.print(pattern[i][j]);
            }
            System.out.println();
        }
    }

    private static void drawStar(char[][] pattern, int n, int start, int size) {
        // 종료조건
        if (n == 0) return;

        // 테두리를 별로 채우기
        for (int i = start; i < size; i++) {
            pattern[start][i] = '*'; // 위쪽
            pattern[size - 1][i] = '*'; // 아래쪽
            pattern[i][start] = '*'; // 왼쪽
            pattern[i][size - 1] = '*'; // 오른쪽
        }

        // 다음 내부 테두리 그리기
        drawStar(pattern, n - 1, start + 2, size - 2);
    }
}
