package com.doosane.study01.week01.silver;
/* 참외밭
1m2의 넓이에 자라는 참외 개수를 헤아린 다음,
참외밭의 넓이를 구하면 비례식을 이용하여 참외의 총개수를 구할 수 있다.
*/

import java.util.Scanner;

public class week01_05 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // 입력 처리
        int K = sc.nextInt(); // 1m²당 자라는 참외 개수

        int[] directions = new int[6];

        int[] lengths = new int[6];

        for (int i = 0; i < 6; i++) {
            directions[i] = sc.nextInt(); // 방향
            lengths[i] = sc.nextInt();   // 길이
        }

        sc.close();

        // 최대 가로 세로 길이 구하기
        int maxWidth = 0; // 최대 가로 길이
        int maxHeight = 0; // 최대 세로 길이

        int maxWidthIndex = 0; // 최대 가로 길이의 인덱스
        int maxHeightIndex = 0; // 최대 세로 길이의 인덱스

        for (int i = 0; i < 6; i++) {
            if (directions[i] == 1 || directions[i] == 2) {

                // 방향이 1(동) or 2(서)인 경우
                if (lengths[i] > maxWidth) {
                    maxWidth = lengths[i];
                    maxWidthIndex = i;
                    // => 최대 가로 길이의 인덱스 저장
                }

            } else if (directions[i] == 3 || directions[i] == 4) {

                // 방향이 3(남) or 4(북)인 경우
                if (lengths[i] > maxHeight) {
                    maxHeight = lengths[i];
                    maxHeightIndex = i;
                    // => 최대 세로 길이의 인덱스 저장
                }
            }
        }

        // 육각형 내부의 작은 사각형의 넓이 계산
        int smallWidth = Math.abs(lengths[(maxHeightIndex + 5) % 6] - lengths[(maxHeightIndex + 1) % 6]);
        int smallHeight = Math.abs(lengths[(maxWidthIndex + 5) % 6] - lengths[(maxWidthIndex + 1) % 6]);

        // 큰 직사각형의 면적 = 전체 육각형의 외곽 넓이
        int rectangleArea = maxWidth * maxHeight;

        // 작은 직사각형의 면적
        int smallRectangleArea = smallWidth * smallHeight;

        // 참외밭의 면적 = 큰 직사각형 넓이 - 작은 직사각형 넓이
        int farmArea = rectangleArea - smallRectangleArea;

        // 참외 개수 계산
        int totalMelons = farmArea * K;

        // 결과 출력
        System.out.println(totalMelons);
    }
}
