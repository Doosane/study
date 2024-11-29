package com.doosane.study01.week02.day03.ex01;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


/*
백준 문제 9933번 민균이의 비밀번호
문제 분석 :
    파일에 적혀있는 단어가 모두 주어졌을 때, 비밀번호의 길이와 가운데 글자를 출력하는 프로그램을 작성
제약 조건 :
     단어의 수 N (2 ≤ N ≤ 100)
     단어는 알파벳 소문자 , 길이는 2보다 크고 14보다 작은 홀수
의사 결정 :
     1. BufferedReader 를 사용해서, 입력을 받고, InputStreamReader 를 함께 사용해서, 메모리 효율을 높이고 시간을 단축한다.
     2. 중복을 허용하지 않으면서 빠른 검색과 접근이 필요한 상황에서 매우 효과적인 자료구조 HashSet을 사용한다.


빠른 검색: HashSet은 O(1)의 시간 복잡도로 요소를 검색할 수 있어,
          각 단어의 뒤집힌 버전이 이미 집합에 있는지 빠르게 확인할 수 있다.

중복 제거: 문제에서 모든 단어가 고유하다고 명시하지 않았지만,
           HashSet을 사용하면 자동으로 중복을 제거할 수 있다.

메모리 효율성: 최대 100개의 단어만 저장하면 되므로,
            HashSet의 메모리 사용량은 문제가 되지 않는다.

간단한 구현: 코드가 간결하고 이해하기 쉽다.
 */

import java.util.HashSet;
import java.util.Set;

public class BOJ9933_HashSet {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        Set<String> words = new HashSet<>();
        String password = "";

        for (int i = 0; i < N; i++) {
            String word = br.readLine();
            String reversed = new StringBuilder(word).reverse().toString();

            if (words.contains(reversed) || word.equals(reversed)) {
                password = word;
                break;
            }

            words.add(word);
        }

        System.out.println(password.length() + " " + password.charAt(password.length() / 2));
    }
}