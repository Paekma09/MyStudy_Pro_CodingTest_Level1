package com.main;

import java.util.ArrayList;
import java.util.List;

public class Main {
	/*
	[문제 설명]
	문자열 s는 한 개 이상의 단어로 구성되어 있습니다. 각 단어는 하나 이상의 공백문자로 구분되어 있습니다. 
	각 단어의 짝수번째 알파벳은 대문자로, 홀수번째 알파벳은 소문자로 바꾼 문자열을 리턴하는 함수, solution을 완성하세요.
	[제한사항]
	문자열 전체의 짝/홀수 인덱스가 아니라, 단어(공백을 기준)별로 짝/홀수 인덱스를 판단해야합니다.
	첫 번째 글자는 0번째 인덱스로 보아 짝수번째 알파벳으로 처리해야 합니다.
	[입출력 예]
	s							return
	"try hello world"	"TrY HeLlO WoRlD"
	[입출력 예 설명]
	"try hello world"는 세 단어 "try", "hello", "world"로 구성되어 있습니다. 
	각 단어의 짝수번째 문자를 대문자로, 홀수번째 문자를 소문자로 바꾸면 "TrY", "HeLlO", "WoRlD"입니다. 
	따라서 "TrY HeLlO WoRlD" 를 리턴합니다.
	*/
	public static void main(String[] args) {
		String s = "try hello world";
		String s1 = " try  hello      world   ";
		
		System.out.print(s+" ");
		System.out.println(solution(s));
		System.out.print(s1+" ");
		System.out.println(solution(s1));
	}
	
	public static String solution(String s) {
		String answer = "";
		// 공백을 제거하지 않고 공백으로 구분하여 배열로 변환
		String[] S = s.split(" ",-1);
		// 길이가 유동적이므로 List생성
		List<String> list = new ArrayList<>();
		// ' ' 일때 그대로 유지하며, 인덱스가 짝수 일때 대문자로 홀수 일때 소문자로 변환하여 문자열에 추가, List에 넣어준다
		for(int i=0; i<S.length; i++) {
			String temp = "";
			for(int j=0; j<S[i].length(); j++) {
				if(S[i].charAt(j) == ' ') {
					temp += S[i].charAt(j);
				}else {
					if(j%2==0) {
						temp += Character.toUpperCase(S[i].charAt(j));
					}else {
						temp += Character.toLowerCase(S[i].charAt(j));
					}
				}
			}
			list.add(temp);
		}
		// List를 join메소드 활용하여 공백으로 구분 문자열로 변환
		answer = String.join(" ", list);
		return answer;
	}

}
