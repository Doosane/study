package com.doosane.study01.week01.day4.bronze;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class BOJ25593 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        // 근무표 주의 수 N

        sc.nextLine(); //버퍼 비움

        Map<String, Integer> workTime = new HashMap<>();
        // 근무 시간 계산을 위한 Map 작성

        for(int i =0 ; i < N ; i++) {
            // 근무표를 처리
            for(int j =0 ; j < 4; j++) {
                // 4개의 시간대별 근무자를 입력받음
                String[] shift = sc.nextLine().split(" ");
                int workHours = 0;
                if(j == 0) workHours = 4; // 08:00~12:00
                if (j == 1) workHours = 6; // 12:00 ~ 18:00
                if(j == 2 ) workHours = 4; // 18:00 ~ 22:00
                if(j == 3) workHours = 10; // 22:00 ~ 08:00

                for (String name : shift) {
                    // 해당 시간대에 근무자 있으면 , 근무 시간에 추가
                    if( !name.equals("-")) {
                        workTime.put(name, workTime.getOrDefault(name, 0) + workHours);
                    }
                }
            }
        }


        int minTime = Integer.MAX_VALUE; // 가장 많은 근무 시간
        int maxTime = Integer.MIN_VALUE; // 가장 적은 근무 시간

        for (int time : workTime.values()) {
            minTime = Math.min(minTime, time);
            maxTime = Math.max(maxTime, time);
        }

        // 공평 확인 후 출력
        if(maxTime - minTime <= 12) {
            System.out.print("Yes");
        } else {
            System.out.println("No");
        }
    }
}
