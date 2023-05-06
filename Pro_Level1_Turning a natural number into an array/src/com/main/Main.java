package com.main;

import java.util.Arrays;

public class Main {
	/*
	[문제 설명]
	자연수 n을 뒤집어 각 자리 숫자를 원소로 가지는 배열 형태로 리턴해주세요. 예를들어 n이 12345이면 [5,4,3,2,1]을 리턴합니다.
	[제한사항]
	n은 10,000,000,000이하인 자연수입니다.
	[입출력 예]
	n			return
	12345	[5,4,3,2,1]
	*/
	public static void main(String[] args) {
		long n = 12345;
		
		System.out.print(n+" ");
		System.out.println(Arrays.toString(solution(n)));
	}
	
	public static int[] solution(long n) {
		// long형을 String으료 변환
		String str = String.valueOf(n);
        int[] answer = new int[str.length()];
        // 반복하며 거꾸로 answer배열에 담기
        // 단, char이므로 '0'을 빼주어야 한다.
        for(int i=0, j=answer.length-1; i<str.length(); i++, j--) {
        	answer[j] = str.charAt(i)-'0';
        }
        return answer;
    }
}
