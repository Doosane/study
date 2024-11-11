package com.doosane.lec.backjun.silver;
import java.util.Scanner;


public class pwPronunciation {
    // 모음인지 확인
    private static boolean isVowel(char ch) {
        return "aeiou".indexOf(ch) != -1;
    }

    // 주어진 규칙에 비밀번호가 맞게 설정되었는지 확인
    private static boolean isHighQualityPassword(String password) {
        boolean hasVowel = false;
        int consecutiveVowels = 0;
        int consecutiveConsonants = 0;
        char previousChar = '\0';

        for (int i = 0; i < password.length(); i++) {
            char currentChar = password.charAt(i);

            // 모음 하나를 반드시 포함하는지 확인
            if (isVowel(currentChar)) {
                hasVowel = true;
                consecutiveVowels++;
                consecutiveConsonants = 0;

            } else {
                consecutiveVowels = 0;
                consecutiveConsonants++;
            }

            // 모음이 연속으로 3번 오는지 확인
            if (consecutiveVowels >= 3 || consecutiveConsonants >= 3) {
                return false;
            }

            // 같은 글자가 연속적으로 두번 오면 안되나, ee나 oo는 허용
            if (previousChar == currentChar && !(currentChar == 'e' || currentChar == 'o')) {
                return false;
            }

            previousChar = currentChar;
        }

        // 모음 하나를 반드시 포함
        return hasVowel;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // 각각의 테스트 케이스 진행
        while (true) {
            String password = scanner.nextLine();
            // end 입력시 끝냄
            if (password.equals("end")) {
                break;
            }
            // 비밀번호 규칙에 부합하는지 확인
            if (isHighQualityPassword(password)) {
                System.out.println("<" + password + "> is acceptable.");
            } else {
                System.out.println("<" + password + "> is not acceptable.");
            }
        }
        scanner.close();
    }
}
