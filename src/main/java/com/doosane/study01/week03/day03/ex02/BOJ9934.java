package com.doosane.study01.week03.day03.ex02;
/*
 백준 문제 9934 : 완전이진트리
 문제 분석:
    주어진 깊이 K의 완전 이진 트리의 노드 방문 순서를 기반으로 각 레벨에 있는 노드들을 출력

 제약 조건:
    깊이 K (1 ≤ K ≤ 10)
    총 노드의 개수는 2^K - 1개
    방문 순서에 따라 노드 번호가 주어짐

 의사 결정:
    1.입력받은 방문 순서를 기반으로 트리를 구성
    2.트리의 레벨별 노드를 저장
    3.각 레벨에 있는 노드 번호를 출력
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ9934 {
    private static int K;
    private static int[] buildings;
    private static int index = 0;
    private static StringBuilder[] levels;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        K = Integer.parseInt(br.readLine()); // 깊이 K 입력
        buildings = new int[(1 << K) - 1]; // 2^K - 1 크기의 배열 생성
        String[] input = br.readLine().split(" ");

        for (int i = 0; i < buildings.length; i++) {
            buildings[i] = Integer.parseInt(input[i]); // 빌딩 번호 입력
        }

        levels = new StringBuilder[K]; // 각 레벨에 대한 StringBuilder 배열 생성
        for (int i = 0; i < K; i++) {
            levels[i] = new StringBuilder();
        }

        buildTree(0, buildings.length - 1, 0); // 트리 생성

        // 결과 출력
        for (StringBuilder level : levels) {
            System.out.println(level.toString().trim());
        }
    }

    // 트리를 중위 순회 방식으로 생성하는 메서드
    private static void buildTree(int start, int end, int depth) {
        if (start > end) {
            return;
        }

        int mid = (start + end) / 2; // 중간 지점 찾기
        levels[depth].append(buildings[mid]).append(" "); // 현재 레벨에 빌딩 번호 추가
        buildTree(start, mid - 1, depth + 1); // 왼쪽 서브트리 생성
        buildTree(mid + 1, end, depth + 1); // 오른쪽 서브트리 생성
    }
}