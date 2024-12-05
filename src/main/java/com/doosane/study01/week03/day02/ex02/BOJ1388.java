package com.doosane.study01.week03.day02.ex02;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

/*
백준 문제 1388번 : 바닥장식
    문제분석:
    기훈이의 방 바닥을 장식하는데 필요한 나무 판자의 개수를 출력하는 프로그램을 작성

제약조건:
    첫째 줄에 방 바닥의 세로 크기N과 가로 크기 M이 주어진다.
    둘째 줄부터 N개의 줄에 M개의 문자가 주어진다.
    이것은 바닥 장식 모양이고, '-‘와 ’|‘로만 이루어져 있다. N과 M은 50 이하인 자연수이다.

의사결정:
    1. 방 바닥을 2차원 배열로 받아 저장한다.
    2. '-'와 '|'를 각각 연결된 부분으로 나누어 나무 판자의 개수를 센다.

 */

public class BOJ1388 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 방 바닥의 세로 크기 N과 가로 크기 M 입력
        String[] dimensions = br.readLine().split(" ");
        int N = Integer.parseInt(dimensions[0]);
        int M = Integer.parseInt(dimensions[1]);

        // 방 바닥 장식 모양을 저장할 2차원 배열
        char[][] floor = new char[N][M];

        // 방 바닥 장식 모양 입력
        for (int i = 0; i < N; i++) {
            String line = br.readLine();
            for (int j = 0; j < M; j++) {
                floor[i][j] = line.charAt(j);
            }
        }

        int plankCount = 0;

        // 가로 방향 나무 판자 개수 세기
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (floor[i][j] == '-') {
                    plankCount++;
                    // '-'가 연속된 부분을 하나의 판자로 간주하고 넘김
                    while (j < M && floor[i][j] == '-') {
                        j++;
                    }
                }
            }
        }

        // 세로 방향 나무 판자 개수 세기
        for (int j = 0; j < M; j++) {
            for (int i = 0; i < N; i++) {
                if (floor[i][j] == '|') {
                    plankCount++;
                    // '|'가 연속된 부분을 하나의 판자로 간주하고 넘김
                    while (i < N && floor[i][j] == '|') {
                        i++;
                    }
                }
            }
        }

        // 필요한 나무 판자의 총 개수 출력
        System.out.println(plankCount);
    }
}
