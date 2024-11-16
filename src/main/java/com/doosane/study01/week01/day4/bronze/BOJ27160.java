package com.doosane.study01.week01.day4.bronze;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class BOJ27160 {
    public static void main(String[] args) {
        //Scanner 로 입력 받아서
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        // 카드 개수 N
        sc.nextLine();
        // 버퍼 비움

        Map<String, Integer> fruitCount = new HashMap<>();
        //Map 으로 과일 이름, 개수 저장
        fruitCount.put("STRAWBERRY",0);
        fruitCount.put("BANANA",0);
        fruitCount.put("LIME",0);
        fruitCount.put("PLUM",0);


        for(int i= 0 ; i< N; i++) {
            // N개의 카드 정보 입력 받고 , 개수 누적
            String[] card = sc.nextLine().split(" ");
            String fruit = card[0];
            int count = Integer.parseInt(card[i]);
            fruitCount.put(fruit, fruitCount.get(fruit) + count);
        }

        // 반 복문으로 과일의 개수 중 5개가 되는지 확인함
        for (int count : fruitCount.values()) {

            if (count == 5) {
                 // 5일 경우 YES 출력
             System.out.println("YES");
             return;
            }
        }

        System.out.println("No");
        // nO출력
    }
}
