package com.doosane.study01.week03.day04;
import java.io.*;
import java.util.*;
/*
 백준 1181번 : 단어 정렬
 문제 분석 :
   - 알파벳 소문자로 이루어진 N개의 단어가 들어오면 아래와 같은 조건에 따라 정렬하는 프로그램을 작성
   - 길이가 짧은 것부터
   - 길이가 같으면 사전 순으로 , 단, 중복된 단어는 하나만 남기고 제거해야 한다.
 제약 조건 :
     첫째 줄에 단어의 개수 N이 주어진다. (1 ≤ N ≤ 20,000)
     둘째 줄부터 N개의 줄에 걸쳐 알파벳 소문자로 이루어진 단어가 한 줄에 하나씩 주어진다.
     주어지는 문자열의 길이는 50을 넘지 않는다.
 의사 결정 :
  1. BufferedReader로 입력을 받고
  2. TreeSet을 사용하여 정렬된 상태로 단어를 저장
  3. 길이를 비교하고, 길이가 같으면 사전순으로 정렬하며, 다르면 길이순으로 정렬
  4. 조건에 따라 정렬하여 단어들을 출력
 */

public class BOJ1181 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        // TreeSet을 사용하여 정렬된 상태로 단어를 저장
        // 길이를 비교하고, 길이가 같으면 사전순으로 정렬하며, 다르면 길이순으로 정렬
        Set<String> wordSet = new TreeSet<>((s1, s2) -> {   // 두 문자열 s1과 s2를 입력으로 받아,
            if (s1.length() == s2.length()) {   // 길이를 비교하고, 길이가 같으면 사전순으로 정렬
                return s1.compareTo(s2);
            } else {   // 길이를 비교하고, 다르면 길이순으로 정렬
                return s1.length() - s2.length();
                // s1.length()는 문자열 s1의 길이를 반환 , s2.length()는 문자열 s2의 길이를 반환
                // s1의 길이가 s2의 길이보다 길면 양수 값을 반환
                // s1의 길이가 s2의 길이보다 짧으면 음수 값을 반환 , 두 문자열의 길이가 같으면 0을 반환
            }
        });

        for (int i = 0; i < N; i++) {
            wordSet.add(br.readLine());
        }

        // TreeSet은 이미 정렬된 상태이므로 바로 출력
        for (String word : wordSet) {
            System.out.println(word);
        }
    }
}

