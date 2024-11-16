package com.doosane.study01.week01.day4.bronze;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;

public class BOJ29701 {

    public static HashMap<String, String> makeMorseMap() {
        HashMap<String, String> map = new HashMap<>();
        // HashMap을 사용 , 모스부호 와 대응하는 알파벳 / 숫자 / 특수문자 저장 후 꺼내서 사용
        map.put(".-", "A");
        map.put("-...", "B");
        map.put("-.-.", "C");
        map.put("-..", "D");
        map.put(".", "E");
        map.put("..-.", "F");
        map.put("--.", "G");
        map.put("....", "H");
        map.put("..", "I");
        map.put(".---", "J");
        map.put("-.-", "K");
        map.put(".-..", "L");
        map.put("--", "M");
        map.put("-.", "N");
        map.put("---", "O");
        map.put(".--.", "P");
        map.put("--.-", "Q");
        map.put(".-.", "R");
        map.put("...", "S");
        map.put("-", "T");
        map.put("..-", "U");
        map.put("...-", "V");
        map.put(".--", "W");
        map.put("-..-", "X");
        map.put("-.--", "Y");
        map.put("--..", "Z");
        map.put(".----", "1");
        map.put("..---", "2");
        map.put("...--", "3");
        map.put("....-", "4");
        map.put(".....", "5");
        map.put("-....", "6");
        map.put("--...", "7");
        map.put("---..", "8");
        map.put("----.", "9");
        map.put("-----", "0");
        map.put("--..--", ",");
        map.put(".-.-.-", ".");
        map.put("..--..", "?");
        map.put("---...", ":");
        map.put("-....-", "-");
        map.put(".--.-.", "@");

        return map;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // BufferedReader , InputStreamReader 사용

        int count = Integer.parseInt(br.readLine());

        String[] split = br.readLine().split(" ");
        // 공백 기준으로 BufferedReader 의 readLine() 함수로 읽어온다

        HashMap<String, String> map = makeMorseMap();
        // 모스 부호가 담겨 있는 HashMap에서

        StringBuilder s = new StringBuilder();
        // StringBuilder 사용하여 모았다가 한번에 출력한다.
        for (String value : split) {
            s.append(map.get(value));
            //    모스 부호를 대응하는 알파벳을 반복문 으로 알아낸다.
        }
        System.out.println(s.toString());
        // 출력 시 String 변환해서 출력한다.
    }
}