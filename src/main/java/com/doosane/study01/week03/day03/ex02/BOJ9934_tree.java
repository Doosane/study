package com.doosane.study01.week03.day03.ex02;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
 * 백준 문제 9934 : 완전이진트리
 * 문제 분석:
 *    주어진 깊이 K의 완전 이진 트리의 노드 방문 순서를 기반으로 각 레벨에 있는 노드들을 출력
 *
 * 제약 조건:
 *    깊이 K (1 ≤ K ≤ 10)
 *    총 노드의 개수는 2^K - 1개
 *    방문 순서에 따라 노드 번호가 주어짐
 *
 * 의사 결정:
 *    1. 입력받은 방문 순서를 기반으로 트리를 구성
 *    2. 트리의 레벨별 노드를 저장
 *    3. 각 레벨에 있는 노드 번호를 출력
 */
public class BOJ9934_tree {
    public static void main(String[] args) throws IOException {
        // BufferedReader를 사용하여 입력을 받음
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 깊이 K를 입력받음
        int K = Integer.parseInt(br.readLine());

        // 2의 K승 - 1 크기의 배열을 생성 (노드의 총 개수)
        int numberOfNodes = 1;
        for (int i = 0; i < K; i++) {
            numberOfNodes *= 2;
        }
        numberOfNodes -= 1;

        // 노드 번호를 저장할 배열
        int[] buildings = new int[numberOfNodes];

        // 입력받은 노드 번호를 배열에 저장
        String[] input = br.readLine().split(" ");
        for (int i = 0; i < buildings.length; i++) {
            buildings[i] = Integer.parseInt(input[i]);
        }

        // 각 레벨별 노드를 저장할 StringBuilder 배열 생성
        StringBuilder[] levels = new StringBuilder[K];
        for (int i = 0; i < K; i++) {
            levels[i] = new StringBuilder();
        }

        // 트리 구성 및 레벨별 노드 저장 (중위 순회 방식)
        int start = 0; // 시작 인덱스
        int end = buildings.length - 1; // 종료 인덱스
        int depth = 0; // 현재 깊이

        // 스택을 사용하여 작업 수행
        int[] stack = new int[buildings.length * 3]; // 스택 배열
        int top = -1; // 스택의 꼭대기

        // 초기값 스택에 추가
        stack[++top] = start; // 시작 인덱스
        stack[++top] = end; // 종료 인덱스
        stack[++top] = depth; // 깊이

        // 스택이 비어있지 않은 동안 반복
        while (top >= 0) {
            depth = stack[top--];
            end = stack[top--];
            start = stack[top--];

            // 유효하지 않은 범위면 continue
            if (start > end) {
                continue;
            }

            // 중간 지점을 계산하여 현재 노드를 찾고 해당 레벨에 추가
            int mid = (start + end) / 2;
            levels[depth].append(buildings[mid]).append(" ");

            // 오른쪽 서브트리 추가
            stack[++top] = mid + 1;
            stack[++top] = end;
            stack[++top] = depth + 1;

            // 왼쪽 서브트리 추가
            stack[++top] = start;
            stack[++top] = mid - 1;
            stack[++top] = depth + 1;
        }

        // 각 레벨의 노드를 출력
        for (StringBuilder level : levels) {
            System.out.println(level.toString().trim());
        }
    }
}

