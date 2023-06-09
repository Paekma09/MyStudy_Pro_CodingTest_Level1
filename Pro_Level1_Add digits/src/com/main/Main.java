package com.main;

public class Main {
	/*
	[문제 설명]
	자연수 N이 주어지면, N의 각 자릿수의 합을 구해서 return 하는 solution 함수를 만들어 주세요.
	예를들어 N = 123이면 1 + 2 + 3 = 6을 return 하면 됩니다.
	[제한사항]
	N의 범위 : 100,000,000 이하의 자연수
	[입출력 예]
	N		answer
	123	6
	987	24
	[입출력 예 설명]
	입출력 예 #1
		문제의 예시와 같습니다.
	입출력 예 #2
		9 + 8 + 7 = 24이므로 24를 return 하면 됩니다.
	*/
	public static void main(String[] args) {
		int n1 = 123;
		int n2 = 987;
		
		System.out.print(n1+" ");
		System.out.println(solution(n1));
		System.out.print(n2+" ");
		System.out.println(solution(n2));
	}
	
	public static int solution(int n) {
		 int answer = 0;
		 // int를 String으로 변환
		String str = String.valueOf(n);
		for(int i=0; i<str.length(); i++) {
			// String의 index로 char가져와 '0'을 빼주면 int로 변환되어 반복하여 더해준다.
			answer += str.charAt(i)-'0';
		}
        return answer;
    }
}
