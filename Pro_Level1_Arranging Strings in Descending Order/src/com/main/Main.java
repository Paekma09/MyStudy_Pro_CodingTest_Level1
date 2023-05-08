package com.main;

import java.util.Arrays;

public class Main {
	/*
	[문제 설명]
	문자열 s에 나타나는 문자를 큰것부터 작은 순으로 정렬해 새로운 문자열을 리턴하는 함수, solution을 완성해주세요.
	s는 영문 대소문자로만 구성되어 있으며, 대문자는 소문자보다 작은 것으로 간주합니다.
	[제한사항]
	str은 길이 1 이상인 문자열입니다.
	[입출력 예]
	s				return
	"Zbcdefg"	"gfedcbZ"
	*/
	public static void main(String[] args) {
		String s1 = "Zbcdefg";
		
		System.out.print(s1+" ");
		System.out.println(solution(s1));
	}
	
	public static String solution(String s) {
        String answer = "";
        // String을 char배열로 변환
        char[] str = s.toCharArray();
        // 문제의 조건은 문자로 내림차순 정렬을 해야하므로
        // char배열을 일단 오름차순으로 정렬한 뒤
        Arrays.sort(str);
        // StringBuilder와 reverse()메소드로 내림차순으로 정렬, toString()메소드로 String으로 변환하여 answer에 저장
        answer = new StringBuilder(new String(str)).reverse().toString();
        return answer;
    }
}
