package com.doosane.study01.week02.day04.prac;

import java.util.*;
/*
    문제 분석
        3명의 팀원 정보(해결한 문제 수, 입학년도, 성)를 입력받음
        두 가지 방식으로 팀 이름을 생성해야 함
    제약 조건
        입력은 항상 3명의 팀원 정보로 고정됨
        각 줄에 문제 수, 입학년도, 성이 순서대로 주어짐
    의사 결정
      1.  Member 클래스 생성: 팀원 정보를 객체로 관리하기 위함
      2.  Comparable 인터페이스 구현: 입학년도 비교를 위해 사용
      3.  두 가지 정렬 방식 사용:
      4.  Collections.sort(): 입학년도 기준 정렬
      5.  members.sort(): 해결한 문제 수 기준 정렬
      6.  StringBuilder 사용: 문자열 연산의 효율성을 위해 선택
*/
public class BOJ28114 {
    // Member 클래스: 팀원 정보를 저장하고 비교하기 위한 클래스
    static class Member implements Comparable<Member> {
        int problems;    // 해결한 문제 수
        int year;        // 입학년도
        String surname;  // 성

        // 생성자: 팀원 정보 초기화
        Member(int problems, int year, String surname) {
            this.problems = problems;
            this.year = year;
            this.surname = surname;
        }

        // 입학년도의 뒤 두 자리를 기준으로 비교
        @Override
        public int compareTo(Member other) {
            return Integer.compare(this.year % 100, other.year % 100);
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Member> members = new ArrayList<>();

        // 3명의 팀원 정보 입력 받기
        for (int i = 0; i < 3; i++) {
            int problems = scanner.nextInt();
            int year = scanner.nextInt();
            String surname = scanner.next();
            members.add(new Member(problems, year, surname));
        }

        // 첫 번째 방법: 입학년도 순으로 정렬
        Collections.sort(members);
        StringBuilder teamName1 = new StringBuilder();
        for (Member member : members) {
            // 입학년도의 뒤 두 자리를 팀 이름에 추가
            teamName1.append(String.format("%02d", member.year % 100));
        }

        // 두 번째 방법: 해결한 문제 수 내림차순으로 정렬
        members.sort((a, b) -> Integer.compare(b.problems, a.problems));
        StringBuilder teamName2 = new StringBuilder();
        for (Member member : members) {
            // 성의 첫 글자를 팀 이름에 추가
            teamName2.append(member.surname.charAt(0));
        }

        // 결과 출력
        System.out.println(teamName1);
        System.out.println(teamName2);
    }
}