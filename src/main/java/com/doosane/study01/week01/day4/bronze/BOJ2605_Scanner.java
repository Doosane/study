package com.doosane.study01.week01.day4.bronze;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
/*
문제 분석 :
- 학생들이 한 줄로 선 후, 첫번째 학생부터 차례로 번호를 뽑는다.
- 첫 번째로 줄을 선 학생은 무조건 0번 번호를 받아 제일 앞에 줄을 선다.
- 두 번째로 줄을 선 학생은 0번 또는 1번 둘 중 하나의 번호를 뽑는다.
- 0번을 뽑으면 그자리에 있고, 1번을 뽑으면 바로 앞의 학생 앞으로 가서 줄을 선다.
- 세 번째로 줄을 선 학생은 0,1 또는 2 중 하나의 번호를 뽑는다.
- 각자 뽑은 번호는 자신이 처음에 선 순서보다는 작은 수이다.
- 줄을 선 학생들이 차례로 뽑은 번호가 주어질 때 학생들이 최종적으로 줄을 선 순서를 출력

제약 조건
- 학생의 수가 100 이하이고, 학생들이 뽑는 번호는 0 또는 자연수이며
- 학생들이 뽑은 번호 사이에는 빈 칸이 하나씩 있다.
- 각자 뽑은 번호는 자신이 처음에 선 순서보다는 작은 수이다.

의사 결정
- Scanner nextInt() 를 통해 학생수 n , 각 학생이 뽑은 번호를 입력을 받는다.
- 학생이 번호를 뽑고 해당 번호 만큼 앞에 삽입 하도록 for문으로 최종 결과를 넣을 리스트에 담는다.
- 최종 출력한다.
 */

/*
결과
메모리 18372 KB
시간 200 ms
 */
public class BOJ2605_Scanner {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in); // Scanner로 입력 받아서
        int n = sc.nextInt(); // 학생수 n 입력 받아서

        int[] selectedNum = new int[n]; // 각 학생이 뽑은 번호 입력 받아서
        for(int i = 0; i < n; i ++) {
            selectedNum[i] = sc.nextInt();
        }

        List<Integer> studentLineOrder = new ArrayList<>(); // 결과를 담을 리스트 (1부터 n까지의 학생 번호)

        for(int i = 0; i < n; i++) { // 각 학생에 대해 번호를 뽑고, 해당 번호만큼 앞에 삽입
            int num = selectedNum[i]; // 학생이 뽑은 번호
            studentLineOrder.add(studentLineOrder.size() - num, i + 1); // i + 1은 학생 번호
        }

        for (int student : studentLineOrder) {
            System.out.print(student + " ");
        }

    }
}

