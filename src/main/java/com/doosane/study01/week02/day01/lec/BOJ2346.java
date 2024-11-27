package com.doosane.study01.week02.day01.lec;
import java.util.*;

public class BOJ2346 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();

        int N = sc.nextInt();  // 풍선의 개수

        // 풍선 번호와 이동 값을 저장할 deque
        Deque<short[]> deque = new ArrayDeque<>();

        // short 배열로 이동 값을 저장하여 메모리 절약
        for (int i = 0; i < N; i++) {
            deque.add(new short[]{(short) (i + 1), sc.nextShort()});  // {풍선 번호, 이동 값}
        }

        while (!deque.isEmpty()) {
            // 현재 풍선 꺼내기
            short[] current = deque.pollFirst();
            int index = current[0];  // 풍선 번호
            int move = current[1];   // 이동할 값
            sb.append(index).append(" ");

            if (deque.isEmpty()) break;  // 마지막 풍선이면 종료

            // 이동 값에 따라 deque를 회전시키기
            if (move > 0) {
                // 양수면 오른쪽으로 이동
                for (int i = 0; i < move - 1; i++) {
                    deque.addLast(deque.pollFirst());
                }
            } else {
                // 음수면 왼쪽으로 이동
                for (int i = 0; i < Math.abs(move); i++) {
                    deque.addFirst(deque.pollLast());
                }
            }
        }

        // 결과 출력
        System.out.println(sb.toString().trim());
    }
}

