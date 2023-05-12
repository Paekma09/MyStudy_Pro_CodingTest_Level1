package com.main;

public class Main {
	/*
	[문제 설명]
	프로그래머스 모바일은 개인정보 보호를 위해 고지서를 보낼 때 고객들의 전화번호의 일부를 가립니다.
	전화번호가 문자열 phone_number로 주어졌을 때, 
	전화번호의 뒷 4자리를 제외한 나머지 숫자를 전부 *으로 가린 문자열을 리턴하는 함수, solution을 완성해주세요.
	[제한사항]
	phone_number는 길이 4 이상, 20이하인 문자열입니다.
	[입출력 예]
	phone_number		return
	"01033334444"		"*******4444"
	"027778888"			"*****8888"
	*/
	public static void main(String[] args) {
		String phone_number1 = "01033334444";
		String phone_number2 = "027778888";
		
		System.out.print(phone_number1+" ");
		System.out.println(solution(phone_number1));
		System.out.print(phone_number2+" ");
		System.out.println(solution(phone_number2));
	}
	
	public static String solution(String phone_number) {
        String answer = "";
        // *와 번호가 나올부분으로 문자열 나누기
        // 앞부분
        String pre = phone_number.substring(0, phone_number.length()-4);
        // 앞부분 숫자 *로 대체
        String temp = pre.replaceAll("[0-9]", "*");
        // 뒷부분
        String suf = phone_number.substring(phone_number.length()-4, phone_number.length());
        // 앞부분 *로 대체된 문자열과 뒷부분 합치기
        answer = temp.concat(suf);
        return answer;
    }
}
