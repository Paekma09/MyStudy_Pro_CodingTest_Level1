package com.main;

public class Main {
	/*
	[문제 설명]
	어떤 문장의 각 알파벳을 일정한 거리만큼 밀어서 다른 알파벳으로 바꾸는 암호화 방식을 시저 암호라고 합니다. 
	예를 들어 "AB"는 1만큼 밀면 "BC"가 되고, 3만큼 밀면 "DE"가 됩니다. "z"는 1만큼 밀면 "a"가 됩니다. 
	문자열 s와 거리 n을 입력받아 s를 n만큼 민 암호문을 만드는 함수, solution을 완성해 보세요.
	[제한사항]
	공백은 아무리 밀어도 공백입니다.
	s는 알파벳 소문자, 대문자, 공백으로만 이루어져 있습니다.
	s의 길이는 8000이하입니다.
	n은 1 이상, 25이하인 자연수입니다.
	[입출력 예]
	s			n		result
	"AB"		1		"BC"
	"z"		1		"a"
	"a B z"	4		"e F d"
	*/
	public static void main(String[] args) {
		String s1 = "AB";
		int n1 = 1;
		String s2 = "z";
		int n2 = 1;
		String s3 = "a B z";
		int n3 = 4;
		
		System.out.print(s1+" "+n1+" ");
		System.out.println(solution(s1, n1));
		System.out.print(s2+" "+n2+" ");
		System.out.println(solution(s2, n2));
		System.out.print(s3+" "+n3+" ");
		System.out.println(solution(s3, n3));
	}
	
	public static String solution(String s, int n) {
		String answer = "";
		// 문자열을 문자 배열로 만든다. 공백 포함
		char[] arr = new char[s.length()];
		for(int i=0; i<s.length(); i++) {
			arr[i] = s.charAt(i);
		}
		// 공백일때는 그대로 유지 진행 -> 'z'면 'a'로 바꿔주고 진행 -> 'Z'면 'A'로 바꿔주고 진행 -> 아니면 +1씩 더하여 char문자를 1칸씩 민다.
		for(int i=0; i<arr.length; i++) {
			for(int j=1; j<=n; j++) {
				if(arr[i] == ' ') {
					arr[i] = arr[i];
					continue;
				}else if(arr[i] == 'z') {
					arr[i] = 'a';
					continue;
				}else if(arr[i] == 'Z') {
					arr[i] = 'A';
					continue;
				}else {
					arr[i] = (char)(arr[i] + 1);
				}
			}
		}
		// String생성자를 이용하여 문자 배열을 문자열로 만든다.
		answer = new String(arr);
		return answer;
	}

}
