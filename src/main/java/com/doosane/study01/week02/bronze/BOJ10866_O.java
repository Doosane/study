package com.doosane.study01.week02.bronze;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

/**
문제 분석 :
    덱(Deque)을 사용하여 여러 가지 명령을 처리하는 프로그램
    명령에 따라 덱의 앞과 뒤에서 값을 추가하거나 제거하고, 크기와 상태를 출력

제약 조건 :
    1 ≤ N ≤ 100,000: 명령의 개수는 최대 100,000개까지 주어진다.
    -10^9 ≤ X ≤ 10^9: 값 X는 매우 큰 정수일 수 있다.
    덱의 크기나 명령어의 실행 횟수가 매우 크므로 시간 복잡도에 대한 고려가 필요
    덱의 삽입과 삭제는 평균적으로 O(1)의 시간 복잡도를 가진다.
    명령어의 실행은 각 명령에 대해 한 번에 한 작업만 처리되므로 전체적인 시간 복잡도는 O(N)이 된다.

의사 결정 :
  명령어 처리
     push_front, push_back: 각각 덱의 앞과 뒤에 원소를 추가하는 연산.
     pop_front, pop_back: 덱의 앞과 뒤에서 원소를 제거하는 연산. 비어 있으면 -1 출력.
     size: 덱의 크기 출력.
     empty: 덱이 비었으면 1, 아니면 0을 출력.
     front, back: 덱의 앞과 뒤의 원소를 확인. 비어 있으면 -1 출력.

  시간 복잡도:
     각 명령은 O(1) 시간이 걸리므로, 전체 프로그램의 시간 복잡도는 O(N)이다.
     이는 주어진 제약조건을 충분히 만족

  전체 흐름
     입력 받기: BufferedReader를 사용해 N을 입력받고, 각 명령을 처리
     명령 처리: switch문을 사용하여 각 명령에 대해 덱을 조작
     결과 출력: 각 명령의 결과를 StringBuilder에 누적시킨 후 한 번에 출력
 */
public class BOJ10866_O {
    public static void main(String[] args) throws IOException {
        // 입력을 빠르게 받기 위해 BufferedReader 사용
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 첫 번째 입력: 명령의 개수 N
        int N = Integer.parseInt(br.readLine());

        // 출력 결과를 한 번에 저장할 StringBuilder 객체
        StringBuilder sb = new StringBuilder();

        // 덱(Deque) 선언 (양쪽 끝에서 원소를 추가하거나 제거할 수 있는 자료구조)
        Deque<Integer> deq = new ArrayDeque<Integer>();

        // N개의 명령을 처리하는 반복문
        for (int i = 0; i < N; i++) {
            // 명령을 공백으로 구분하여 토큰화
            StringTokenizer st = new StringTokenizer(br.readLine());

            // 첫 번째 토큰은 명령어
            String S = st.nextToken();

            // 명령어에 따라 적절한 동작 수행
            switch (S) {
                case "push_front" :
                    // 덱의 앞에 값 추가
                    deq.addFirst(Integer.parseInt(st.nextToken()));
                    break;

                case "push_back" :
                    // 덱의 뒤에 값 추가
                    deq.addLast(Integer.parseInt(st.nextToken()));
                    break;

                case "pop_front" :
                    // 덱이 비었으면 -1 출력, 아니면 덱 앞에서 값 제거 후 출력
                    if (deq.isEmpty()) sb.append(-1).append("\n");
                    else sb.append(deq.pollFirst()).append("\n");
                    break;

                case "pop_back" :
                    // 덱이 비었으면 -1 출력, 아니면 덱 뒤에서 값 제거 후 출력
                    if (deq.isEmpty()) sb.append(-1).append("\n");
                    else sb.append(deq.pollLast()).append("\n");
                    break;

                case "size" :
                    // 덱의 크기를 출력
                    sb.append(deq.size()).append("\n");
                    break;

                case "empty" :
                    // 덱이 비었으면 1, 아니면 0 출력
                    if (deq.isEmpty()) sb.append(1).append("\n");
                    else sb.append(0).append("\n");
                    break;

                case "front" :
                    // 덱이 비었으면 -1 출력, 아니면 덱 앞의 값을 출력
                    if (deq.isEmpty()) sb.append(-1).append("\n");
                    else sb.append(deq.peekFirst()).append("\n");
                    break;

                case "back" :
                    // 덱이 비었으면 -1 출력, 아니면 덱 뒤의 값을 출력
                    if (deq.isEmpty()) sb.append(-1).append("\n");
                    else sb.append(deq.peekLast()).append("\n");
                    break;
            }
        }
        // 모든 명령 처리 후, 한 번에 결과 출력
        System.out.println(sb);
    }
}
