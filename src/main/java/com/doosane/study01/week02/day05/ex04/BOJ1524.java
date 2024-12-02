package com.doosane.study01.week02.day05.ex04;

import java.util.PriorityQueue;
import java.util.Scanner;

public class BOJ1524 {
    public static void main(String[] args) {
        // scanner로 입력받아서
        Scanner sc = new Scanner(System.in);
        // 테스트 케이스 수
        int T = sc.nextInt();

        while (T-- > 0) {
            // 세준이 , 세비의 병사 N ,M
            int N = sc.nextInt();
            int M = sc.nextInt();
            sc.nextLine(); // 버퍼 비우기

            // 세준이의 병사 힘을 우선순위 큐에 저장
            PriorityQueue<Integer> sejunQueue = new PriorityQueue<>();
            for (int i = 0; i < N; i++) {
                sejunQueue.offer(sc.nextInt());
            }
            sc.nextLine(); // 버퍼 비우기

            // 세비 병사 힘을 우선순위 큐에 저장
            PriorityQueue<Integer> seviQueue = new PriorityQueue<>();
            for (int i = 0; i < M; i++) {
                seviQueue.offer(sc.nextInt());
            }
            sc.nextLine(); // 버퍼 비우기

            // 전투 진행
            while (!sejunQueue.isEmpty() && !seviQueue.isEmpty()) {
                // 각 군대에서 가장 약한 병사 꺼냄
                int sejunWeak = sejunQueue.peek();
                int seviWeak = seviQueue.peek();
                if (sejunWeak <= seviWeak) {
                    // 세비 병사 죽는다
                    sejunQueue.poll(); // .poll() 사용 ,세비 병사 제거
                } else {
                    // 세준 병사 죽음
                    seviQueue.poll(); // .poll() 사용 세준 병사 제거
                }
            }

            // 전투 종료 후 남은 병사의 수로 승자 결정
            if (sejunQueue.isEmpty() && seviQueue.isEmpty()) {
                System.out.println("C"); // 두 군데 모두 병사 남지 않으면 'C'
            } else if (sejunQueue.isEmpty()) {
                System.out.println("B"); // 세준이의 병사가 모두 죽었으면 'B'
            } else {
                System.out.println("S"); // 세비의 병사가 모두 죽었으면 'S'
            }
        }
        sc.close(); // Scanner 종료
    }
}