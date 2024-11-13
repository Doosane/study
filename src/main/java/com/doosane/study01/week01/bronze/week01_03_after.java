
package com.doosane.study01.week01.bronze;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class week01_03_after {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= n; i++) {
            sb.append(createLine(n, i)).append("\n");
        }

        for (int i = n - 1; i >= 1; i--) {
            sb.append(createLine(n, i)).append("\n");
        }

        System.out.print(sb);
    }

    private static String createLine(int n, int i) {
        String stars = "*".repeat(i);
        String spaces = " ".repeat(2 * (n - i));
        return stars + spaces + stars;
    }
}