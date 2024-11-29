package com.doosane.study01.week02.day02.ex09;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

/*
 백준 문제 2346 : 풍선 터뜨리기 , 덱

 문제 분석 :
 1. N개의 풍선이 원형으로 배치되어 있다.
 2. 각 풍선 안에는 -N부터 N까지의 정수 중 하나가 적혀 있는 종이가 들어 있다.
 3. 제일 처음에는 1번 풍선을 터뜨린다.
 4. 풍선 안에 있는 종이에 적혀 있는 값만큼 이동하여 다음 풍선을 터뜨린다.
 5. 양수인 경우 오른쪽으로, 음수인 경우 왼쪽으로 이동한다.
 6. 이미 터진 풍선은 건너뛴다.

 제약 조건 :
 1. 자연수 N(1 ≤ N ≤ 1,000)
 2. 풍선 안의 종이에 적힌 수는 -N보다 크거나 같고, N보다 작거나 같은 정수이다.

 의사 결정 :
 1. Deque를 사용하여 원형 구조를 구현한다.
 2. 각 풍선의 정보를 [인덱스, 이동값] 형태의 배열로 저장한다.
 3. 양수 이동은 앞에서 뒤로, 음수 이동은 뒤에서 앞으로 요소를 옮기는 방식으로 구현한다.
 4. StringBuilder를 사용하여 결과를 효율적으로 저장한다.
 */

public class BOJ2346 {
    public static void main(String[] args) throws IOException {
        // 입력을 받기 위한 BufferedReader 설정
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 풍선의 개수 N 입력 받기
        int N = Integer.parseInt(br.readLine());

        // 풍선 정보를 저장할 Deque 생성
        Deque<int[]> balloons = new ArrayDeque<>();

        // 풍선 안의 종이에 적힌 값들을 입력 받기
        StringTokenizer st = new StringTokenizer(br.readLine());

        // 각 풍선의 정보를 Deque에 저장
        for (int i = 1; i <= N; i++) {
            balloons.offer(new int[]{i, Integer.parseInt(st.nextToken())});
        }

        // 결과를 저장할 StringBuilder 생성
        StringBuilder sb = new StringBuilder();

        // 모든 풍선이 터질 때까지 반복
        while (!balloons.isEmpty()) {
            // 현재 터뜨릴 풍선 정보 가져오기
            int[] current = balloons.pollFirst();

            // 터뜨린 풍선의 번호를 결과에 추가
            sb.append(current[0]).append(" ");

            // 모든 풍선이 터졌다면 반복 종료
            if (balloons.isEmpty()) break;

            // 풍선 안의 종이에 적힌 값에 따라 이동
            if (current[1] > 0) {
                // 양수인 경우 오른쪽으로 이동 (앞에서 뒤로)
                for (int i = 0; i < current[1] - 1; i++) {
                    balloons.offerLast(balloons.pollFirst());
                }
            } else {
                // 음수인 경우 왼쪽으로 이동 (뒤에서 앞으로)
                for (int i = 0; i < -current[1]; i++) {
                    balloons.offerFirst(balloons.pollLast());
                }
            }
        }

        // 결과 출력
        System.out.println(sb);
    }
}