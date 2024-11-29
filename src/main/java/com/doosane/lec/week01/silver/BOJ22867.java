package com.doosane.lec.week01.silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

/*
백준 문제 22867번 : 종점

문제 분석 :
    버스 정비를 위한 공간이 최소 몇 개 이상 필요한지 출력

제약 조건 :
    1 ≤ N ≤ 100,000
    0 ≤ HH < 24
    0 ≤ MM < 60
    0 ≤ SS < 60
    0 ≤ sss < 1000

의사 결정 :
    1. 각 버스의 도착과 출발을 별도의 이벤트로 처리
    2. 우선순위 큐를 사용하여 이벤트를 시간순으로 정렬
    3. 이벤트를 순차적으로 처리하며 현재 버스 수를 추적
    4. 최대 동시 주차 버스 수를 계산하여 필요한 공간 수 결정
 */

public class BOJ22867 {
    public static void main(String[] args) throws IOException {
        // 입력을 받기 위한 BufferedReader 객체 생성
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // 버스의 수 N 입력 받기
        int N = Integer.parseInt(br.readLine());

        // 이벤트(도착, 출발)를 저장할 우선순위 큐 생성
        PriorityQueue<Event> events = new PriorityQueue<>();

        // N개의 버스에 대한 정보 입력 받기
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String arrivalTime = st.nextToken();
            String departureTime = st.nextToken();

            // 도착 이벤트(type 1)와 출발 이벤트(type -1)를 큐에 추가
            events.offer(new Event(convertToMillis(arrivalTime), 1));
            events.offer(new Event(convertToMillis(departureTime), -1));
        }

        int maxBuses = 0;  // 동시에 주차된 최대 버스 수
        int currentBuses = 0;  // 현재 주차된 버스 수

        // 모든 이벤트 처리
        while (!events.isEmpty()) {
            Event event = events.poll();
            currentBuses += event.type;  // 도착이면 +1, 출발이면 -1
            maxBuses = Math.max(maxBuses, currentBuses);  // 최대값 갱신
        }

        // 결과 출력
        System.out.println(maxBuses);
    }

    // 이벤트를 나타내는 내부 클래스
    static class Event implements Comparable<Event> {
        long time;  // 이벤트 발생 시간 (밀리초)
        int type;   // 이벤트 유형 (1: 도착, -1: 출발)

        Event(long time, int type) {
            this.time = time;
            this.type = type;
        }

        // 시간순으로 이벤트를 정렬하기 위한 비교 메서드
        @Override
        public int compareTo(Event other) {
            return Long.compare(this.time, other.time);
        }
    }

    // 시간 문자열을 밀리초로 변환하는 메서드
    static long convertToMillis(String time) {
        String[] parts = time.split(":");
        long hours = Long.parseLong(parts[0]);
        long minutes = Long.parseLong(parts[1]);
        long seconds = Long.parseLong(parts[2].split("\\.")[0]);
        long milliseconds = Long.parseLong(parts[2].split("\\.")[1]);

        // 시간을 밀리초 단위로 변환
        return (hours * 3600 + minutes * 60 + seconds) * 1000 + milliseconds;
    }
}