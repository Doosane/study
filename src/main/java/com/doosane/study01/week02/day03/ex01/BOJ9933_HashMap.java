package com.doosane.study01.week02.day03.ex01;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

/**
 * 문제 분석:
 * - 주어진 단어들 중, 역순이 일치하는 단어가 존재할 때 그 단어를 비밀번호로 결정한다.
 * - 비밀번호의 길이와 가운데 문자를 출력하는 프로그램을 작성.
 *
 * 제약 조건:
 * - 단어 수 N (2 ≤ N ≤ 100)
 * - 각 단어는 알파벳 소문자, 길이는 2보다 크고 14보다 작은 홀수
 *
 * 의사결정:
 * 1. BufferedReader 사용하여 빠른 입력 처리
 * 2. HashMap을 이용하여 단어와 그 역순을 빠르게 확인.
 * 3. 역순이 일치하는 단어를 찾으면 비밀번호로 결정하고, 비밀번호의 길이와 가운데 문자를 출력
 */
public class BOJ9933_HashMap {
    public static void main(String[] args) throws IOException {
        // BufferedReader와 InputStreamReader를 사용하여 입력을 처리.
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 첫 번째 줄에 주어지는 단어의 개수 N을 입력받음.
        int N = Integer.parseInt(br.readLine());

        // 단어들을 저장할 HashMap 선언. Key: 단어, Value: 존재 여부를 의미하는 Boolean 값
        Map<String, Boolean> words = new HashMap<>();
        String password = "";  // 비밀번호를 저장할 변수.

        // N개의 단어에 대해 반복
        for (int i = 0; i < N; i++) {
            // 한 줄씩 단어를 입력받음.
            String word = br.readLine();
            // 해당 단어를 역순으로 뒤집음.
            String reversed = new StringBuilder(word).reverse().toString();

            // 역순 단어가 이미 HashMap에 존재하거나, 해당 단어가 자기가 역순인 경우 일 때
            if (words.containsKey(reversed) || word.equals(reversed)) {
                password = word;  // 비밀번호가 결정됨.
                break;  // 찾으면 반복문 종료.
            }

            // HashMap에 현재 단어를 저장. 역순 단어를 미리 저장할 필요는 없으므로 단어만 저장.
            words.put(word, true);
        }

        // 비밀번호의 길이와 가운데 문자를 출력.
        // 비밀번호 길이는 항상 홀수이므로 가운데 문자는 중간 인덱스 위치의 문자.
        System.out.println(password.length() + " " + password.charAt(password.length() / 2));
    }
}

