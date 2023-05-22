package com.main;

public class Main {
	/*
	[문제 설명]
	문자열 s의 길이가 4 혹은 6이고, 숫자로만 구성돼있는지 확인해주는 함수, solution을 완성하세요. 
	예를 들어 s가 "a234"이면 False를 리턴하고 "1234"라면 True를 리턴하면 됩니다.
	[제한사항]
	s는 길이 1 이상, 길이 8 이하인 문자열입니다.
	s는 영문 알파벳 대소문자 또는 0부터 9까지 숫자로 이루어져 있습니다.
	[입출력 예]
	s			return
	"a234"	false
	"1234"	true
	*/
	public static void main(String[] args) {
		String s1 = "a234";
		String s2 = "1234";
		
		System.out.print(s1+" ");
		System.out.println(solution(s1));
		System.out.print(s2+" ");
		System.out.println(solution(s2));
	}
	
	public static boolean solution(String s) {
        boolean answer = true;
        // 문자열 s이 길이 저장
        int length = s.length();
        // 문자열을 문자들로 나누어서 숫자인지 판별 한다.
        boolean result = s.chars().allMatch(Character::isDigit);
        // 문제의 조건대로 문자열 길이 4 or 6 이고 result가 true 일때와 아닐 때로 분기
        if((length == 4 || length == 6) && result == true) {
        	answer = true;
        }else {
        	answer = false;
        }
        return answer;
    }
}
