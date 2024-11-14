package com.doosane.study01.week01.bronze;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Week02_04_BOJ_9184 {
    static int[][][] memoizationTable = new int[101][101][101];

    public static void main(String[] args) throws IOException {

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder stringBuilder = new StringBuilder();

        while (true) {
            StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
            int a = Integer.parseInt(stringTokenizer.nextToken());
            int b = Integer.parseInt(stringTokenizer.nextToken());
            int c = Integer.parseInt(stringTokenizer.nextToken());

            if (a == -1 && b == -1 && c == -1) {
                break;
            }

            int result = w(a, b, c);

            stringBuilder.append(String.format("w(%d, %d, %d) = %d\n", a, b, c, result));
        }

        System.out.print(stringBuilder.toString());
    }

    static int w(int a, int b, int c) {

        int indexA = a + 50;
        int indexB = b + 50;
        int indexC = c + 50;

        if (a <= 0 || b <= 0 || c <= 0) {
            return 1;
        }

        if (a > 20 || b > 20 || c > 20) {
            return w(20, 20, 20);
        }

        if (memoizationTable[indexA][indexB][indexC] != 0) {
            return memoizationTable[indexA][indexB][indexC];

        }

        if (a < b && b < c) {
            memoizationTable[indexA][indexB][indexC] = w(a, b, c-1) + w(a, b-1, c-1) - w(a, b-1, c);

        } else {
            memoizationTable[indexA][indexB][indexC] = w(a-1, b, c) + w(a-1, b-1, c) + w(a-1, b, c-1) - w(a-1, b-1, c-1);

        }
        return memoizationTable[indexA][indexB][indexC];

    }
}