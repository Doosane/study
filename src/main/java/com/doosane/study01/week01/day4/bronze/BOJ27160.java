package com.doosane.study01.week01.day4.bronze;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

/**
문제 분석
- 주어진 카드 개수 N개, 각 카드는 과일 이름과 숫자 ,
- 각 과일의 개수를 누적한 후, 어떤 과일의 개수가 정확히 5개가 되는지 판단

제약 조건
- 첫 줄에 N (1 <= N <= 100,000) 카드 개수
- 다음음 N개의 줄에 각 줄은 두 개의 값, 문자열(과일 이름)과 정수(개수)

의사 결정
- BufferedReader를 사용하여 입력을 빠르게 처리
- 각 과일의 개수를 저장하기 위해 HashMap을 사용과일 이름을 키로, 과일 개수를 값으로 저장
- 과일 이름과 개수를 입력 받아 HashMap에 저장,이미 존재하는 과일 이름이면 기존 값에 더함
- 모든 입력이 끝난 후, HashMap을 탐색하여 값이 5인 항목이 있는지 확인
- 값이 5인 항목이 있으면 "YES"를 출력하고, 없다면 "NO"를 출력
- StringBuilder를 사용하여 출력 결과를 효율적으로 처리
 */

public class BOJ27160 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder result = new StringBuilder();

        int N = Integer.parseInt(br.readLine()); // 카드 개수 N

        // Map 으로 과일 이름, 개수 저장
        Map<String, Integer> fruitCount = new HashMap<>();
        fruitCount.put("STRAWBERRY", 0);
        fruitCount.put("BANANA", 0);
        fruitCount.put("LIME", 0);
        fruitCount.put("PLUM", 0);

        for (int i = 0; i < N; i++) {
            // N개의 카드 정보 입력 받고, 개수 누적
            String[] card = br.readLine().split(" ");
            String fruit = card[0];
            int count = Integer.parseInt(card[1]);
            fruitCount.put(fruit, fruitCount.get(fruit) + count);
        }

        // 반복문으로 과일의 개수 중 5개가 되는지 확인
        for (int count : fruitCount.values()) {
            if (count == 5) {
                // 5일 경우 YES 출력
                result.append("YES");
                System.out.println(result);
                return;
            }
        }

        // 그 전에 리턴되지 않으면 NO 출력
        result.append("NO");
        System.out.println(result);
    }
}