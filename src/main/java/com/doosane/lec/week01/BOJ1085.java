package com.doosane.lec.week01;

import java.util.Scanner;

/*
    1일차 변수,데이터,타입,연산자
    연습문제 2.
    직사각형에서 탈출
 */
public class BOJ1085 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int x = sc.nextInt(); // 점의 x 좌표
        int y = sc.nextInt(); // 점의 y 좌표
        int w = sc.nextInt(); // 직사각형의 너비
        int h = sc.nextInt(); // 직사각형의 높이

        // x축에서 최단 거리 구하기
        int minX = (x < w - x) ? x : (w-x) ;

        // y축에서 최단 거리 구하기
        int minY = (y < h - y) ? y : (h-y) ;

        // x축과 y축에서의 최단 거리 중 작은 값 선택
        int minDistance = (minX < minY) ? minX : minY;

        // 결과 출력
        System.out.println(minDistance);

        sc.close();
    }
}
