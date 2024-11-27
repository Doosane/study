package com.doosane.study01.week02.day01.six;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.HashMap;
import java.util.PriorityQueue;
import java.util.StringTokenizer;
/*
문제 분석:
    q는 쿼리 개수, 각 쿼리는 code(1: 값 추가, 2: 값 제거 및 합산), name, count로 구성됨.
    우선순위 큐는 내림차순으로 값 정렬, PriorityQueue와 Collections.reverseOrder()로 최대 힙 구현.
    code == 1은 큐에 값 추가, code == 2는 큐에서 최대값을 꺼내 합산하며, 큐가 비면 더 이상 꺼낼 수 없음.

제약 조건:
    쿼리 수 q는 최대 1,000,000까지 존재할 수 있으며, 이에 따라 시간 복잡도와 메모리 관리가 중요하다.
    각 쿼리에서 최대 1,000,000개의 수가 들어올 수 있다.

의사 결정:
    각 이름별로 우선순위 큐를 관리하는 맵을 사용하여 큐에 값 추가 및 삭제를 처리
    code == 2에서 큐에서 꺼낸 값을 합산하여 최종 결과를 출력

149092KB 1148ms
 */
public class BOJ22252_PriorityQueue {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 질의의 수
        int q = Integer.parseInt(br.readLine());

        // 이름별로 정보를 저장하는 맵
        HashMap<String, PriorityQueue<Integer>> infos = new HashMap<>();

        // 호석이가 구매한 정보의 합
        long totalSum = 0;

        while (q-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int command = Integer.parseInt(st.nextToken()); // 명령 종류
            String name = st.nextToken(); // 이름
            int k = Integer.parseInt(st.nextToken()); // 거래할 정보의 개수

            if (command == 1) {  // 고릴라가 정보를 얻는 경우
                PriorityQueue<Integer> info = infos.getOrDefault(name, new PriorityQueue<>(Collections.reverseOrder()));

                // k개의 정보를 우선순위 큐에 추가
                for (int i = 0; i < k; i++) {
                    int num = Integer.parseInt(st.nextToken());
                    info.offer(num);
                }

                // 업데이트된 우선순위 큐를 맵에 저장
                infos.put(name, info);

            } else {  // 호석이가 거래하는 경우
                PriorityQueue<Integer> info = infos.get(name);

                // 만약 해당 이름에 정보가 없다면 건너뛰기
                if (info == null) {
                    continue;
                }

                // k개의 정보보다 고릴라가 가진 정보가 적으면 모든 정보를 다 가져오기
                if (k >= info.size()) {
                    while (!info.isEmpty()) {
                        totalSum += info.poll(); // 가장 큰 정보부터 꺼내서 더하기
                    }
                } else {  // 거래할 정보가 충분할 때는 k개만 거래
                    for (int i = 0; i < k; i++) {
                        totalSum += info.poll(); // 가장 큰 정보부터 꺼내서 더하기
                    }
                }
            }
        }

        // 총 합을 출력
        System.out.println(totalSum);
    }
}

