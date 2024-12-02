package com.doosane.study01.week02.day05.ex03;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
/*

 백준 문제 16466번 : 콘서트
 문제 분석 :
    1차 티켓팅에서 이미 팔린 티켓의 번호들의 목록, 티켓의 번호는 1번부터 시작한다.
    2차 티켓팅에서 양한이가 가질 수 있는 티켓 중 가장 작은 번호를 출력한다.

 제약 조건 :
    팔린 티켓들의 수 정수 N(1 ≤ N ≤ 1,000,000)
    팔린 티켓들의 번호 정수 A(1 ≤ A ≤ 231 − 1)

 의사 결정 :
    정렬 알고리즘 개념 이용, 가장 작은 가능한 티켓 번호를 출력
    1. 사용자 입력을 받기 위한 Scanner 객체 생성, 이미 팔린 티켓의 수 N을 입력받음
    2. 팔린 티켓 번호를 저장할 ArrayList 생성
    3. N개의 팔린 티켓 번호를 입력받아 리스트에 추가
    4. 팔린 티켓 번호를 오름차순으로 정렬
    5. 가장 작은 가능한 티켓 번호를 1로 초기화
    6. 정렬된 팔린 티켓 번호를 순회하며 가장 작은 가능한 티켓 번호 찾기
    7. 현재 티켓 번호가 smallestAvailable과 같다면, 다음 번호 확인
    8. 현재 티켓 번호가 smallestAvailable보다 크다면, 빈 번호를 찾았으므로 반복 중단
    9. 찾은 가장 작은 가능한 티켓 번호 출력

 */
public class BOJ16466_prac {
    public static void main(String[] args) {
        // 사용자 입력을 받기 위한 Scanner 객체 생성
        Scanner sc = new Scanner(System.in);
        // 이미 팔린 티켓의 수 N을 입력받음
        int N = sc.nextInt();
        // 팔린 티켓 번호를 저장할 ArrayList 생성
        List<Integer> soldTickets = new ArrayList<>();
        // N개의 팔린 티켓 번호를 입력받아 리스트에 추가
        for (int i = 0; i < N; i++) {
            soldTickets.add(sc.nextInt());
        }
        // 팔린 티켓 번호를 오름차순으로 정렬
        Collections.sort(soldTickets);
        // 가장 작은 가능한 티켓 번호를 1로 초기화
        int smallestAvailable = 1;
        // 정렬된 팔린 티켓 번호를 순회하며 가장 작은 가능한 티켓 번호 찾기
        for (int ticket : soldTickets) {
            if (ticket == smallestAvailable) {
                // 현재 티켓 번호가 smallestAvailable과 같다면, 다음 번호 확인
                smallestAvailable++;
            } else if (ticket > smallestAvailable) {
                // 현재 티켓 번호가 smallestAvailable보다 크다면, 빈 번호를 찾았으므로 반복 중단
                break;
            }
            // ticket < smallestAvailable인 경우는 무시 (이미 정렬되어 있으므로 발생하지 않음)
        }
        // 가장 작은 가능한 티켓 번호 출력
        System.out.println(smallestAvailable);
    }
}