package com.doosane.study01.week02.day05.ex04;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
    문제: 백준 1524번 - 세준 세비

    문제 분석:
    - 두 군대(세준의 군대, 세비의 군대)가 병사들의 힘을 비교하여 전투를 벌인다.
    - 각 테스트 케이스에 대해, 가장 강한 병사의 힘을 비교하여 승자를 결정한다.
    - 세준이의 병사가 세비의 병사보다 힘이 크면 "S" 출력
    - 세비의 병사가 세준의 병사보다 힘이 크면 "B" 출력
    - 동일한 힘일 경우 세준이가 승리하므로 "S" 출력

    제약 조건:
    - 1 ≤ N, M ≤ 1,000,000 (각 군대 병사의 수)
    - 병사들의 힘은 300,000,000보다 작거나 같은 자연수이다.
    - 테스트 케이스(T)의 최대 값에 따라 입력 데이터가 방대할 수 있음.

    의사 결정:
     1. 입력은 BufferedReader로 처리하여 효율적으로 데이터를 읽는다.
     2. 세준, 세비 병사들의 병사 수와 힘을 읽어들인다.
     3. 각 군대에서 가장 강한 병사의 힘을 계산한다.
     4. 가장 강한 병사들의 힘을 비교하여 승자를 결정한다.
     5. 출력은 각 테스트 케이스마다 결과("S", "B")를 한 줄에 출력한다.

    메모리 초과
    메모리 사용 최소화
    배열 대신 단일 변수 활용:

    병사의 힘을 저장하기 위해 배열이나 리스트와 같은 자료구조를 사용하지 않고, 최댓값을 저장하는 변수만 사용
    입력 데이터를 처리하면서 메모리를 바로 해제하는 방식으로, 입력 크기와 관계없이 일정한 메모리만 사용
 */
public class BOJ1524 {

    public static void main(String[] args) throws IOException {
        // 입력을 효율적으로 처리하기 위한 BufferedReader 사용
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        // 첫 줄에서 테스트 케이스의 수를 입력받음
        int testCaseCount = Integer.parseInt(reader.readLine().trim());

        // 각 테스트 케이스를 반복 처리
        for (int testCase = 0; testCase < testCaseCount; testCase++) {
            reader.readLine(); // 테스트 케이스 간 공백 줄을 읽고 무시

            // 병사의 수를 입력받음 (세준과 세비의 병사 수)
            StringTokenizer lineTokens = new StringTokenizer(reader.readLine());
            int sejunSoldierCount = Integer.parseInt(lineTokens.nextToken());
            int seviSoldierCount = Integer.parseInt(lineTokens.nextToken());

            // 초기값 설정: 두 군대에서 가장 강한 병사의 힘
            int sejunMaxPower = 0; // 세준 병사 중 가장 강한 병사의 힘
            int seviMaxPower = 0;  // 세비 병사 중 가장 강한 병사의 힘

            // 세준 병사들의 힘을 읽으면서 최대값 계산
            lineTokens = new StringTokenizer(reader.readLine());
            for (int soldier = 0; soldier < sejunSoldierCount; soldier++) {
                int power = Integer.parseInt(lineTokens.nextToken());
                sejunMaxPower = Math.max(sejunMaxPower, power); // 현재 병사의 힘과 비교하여 최대값 업데이트
            }

            // 세비 병사들의 힘을 읽으면서 최대값 계산
            lineTokens = new StringTokenizer(reader.readLine());
            for (int soldier = 0; soldier < seviSoldierCount; soldier++) {
                int power = Integer.parseInt(lineTokens.nextToken());
                seviMaxPower = Math.max(seviMaxPower, power); // 현재 병사의 힘과 비교하여 최대값 업데이트
            }

            // 두 군대의 가장 강한 병사를 비교하여 승자를 출력
            if (sejunMaxPower > seviMaxPower) {
                System.out.println("S"); // 세준 병사가 더 강할 경우 "S" 출력
            } else if (seviMaxPower > sejunMaxPower) {
                System.out.println("B"); // 세비 병사가 더 강할 경우 "B" 출력
            } else {
                System.out.println("S"); // 동일한 힘일 경우 세준 승리로 간주 "S" 출력
            }
        }
    }
}
