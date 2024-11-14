package com.doosane.study01.week01.bronze;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
 * 요구 사항
 * 입력 : N(1 ≤ N ≤ 100)
 * 출력 : 규칙에 맞춰 별 출력
 *
 * 문제 풀이
 * 이전의 모양에서 테두리가 생긴다 재귀로 이전의 별 모양을 유지하며 커진다 정사각형 형태다
 * 변의 길이가 1, 5, 9, 13... 으로 4 * (n-1) + 1으로 커진다
 * 첫번째와 마지막 변을 제외하고 나머지는 양 모서리에만 별을 찍는다 (감싸는 형태)
 */

public class Week02_03_team2_BOJ_10994 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine()); // 정수 N 입력
        int size = 4 * (n - 1) + 1; // 정사각형의 크기
        char[][] star = new char[size][size]; // 정사각형을 2차원 배열로 매핑

        // 배열을 공백으로 초기화
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                star[i][j] = ' ';
            }
        }

        // 별 패턴을 재귀적으로 채우기
        printStar(star, n, 0);

        // 출력
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                sb.append(star[i][j]);
            }
            sb.append("\n");
        }
        System.out.print(sb);

        br.close();
    }

    // 별 채우기
    static void printStar(char[][] star, int current, int offset) {
        int size = 4 * (current - 1) + 1; // 현재 테두리의 길이

        // 위, 아래 행 테두리에 별 채우기
        for (int i = 0; i < size; i++) {
            star[offset][offset + i] = '*'; // 위쪽 행
            star[offset + size - 1][offset + i] = '*'; // 아래쪽 행
        }

        // 왼쪽, 오른쪽 열 테두리에 별 채우기
        for (int i = 0; i < size; i++) {
            star[offset + i][offset] = '*'; // 왼쪽 열
            star[offset + i][offset + size - 1] = '*'; // 오른쪽 열
        }

        // 더 작은 정사각형을 재귀적으로 그리기
        if (current > 1) {
            printStar(star, current - 1, offset + 2); // 2칸씩 이동
        }
    }
}
