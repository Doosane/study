package com.doosane.study01.week01.bronze;
/* 뜨거운 붕어빵
첫째 줄에는 두 개의 정수 N과 M(0≤N,M≤10)이 주어집니다.
둘째 줄부터 N개의 줄에 걸쳐 붕어빵의 모양이 주어집니다.
각 행에는 공백을 나타내는 ‘0‘ 또는 붕어빵을 나타내는 ‘1’이 총 M개 주어집니다.
*/
import java.util.Scanner;
public class week01_04_before {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        // 행렬의 크기 N과 M을 입력
        int N = sc.nextInt();
        int M = sc.nextInt();
        sc.nextLine();  // 버퍼에 남은 줄바꿈 문자를 제거
        char[][] matrix = new char[N][M];

        // 행렬의 값을 입력
        for (int i = 0; i < N; i++) {
            matrix[i] = sc.nextLine().toCharArray();
        }
        sc.close();

        // 대칭 변환된 행렬을 출력
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                System.out.print(matrix[i][M - j - 1]);
            }
            System.out.println();
        }
    }
}
