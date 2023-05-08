package com.main;

import java.util.Arrays;
import java.util.Collections;

public class Main {
	/*
	[문제 설명]
	함수 solution은 정수 n을 매개변수로 입력받습니다. n의 각 자릿수를 큰것부터 작은 순으로 정렬한 새로운 정수를 리턴해주세요. 
	예를들어 n이 118372면 873211을 리턴하면 됩니다.
	[제한사항]
	n은 1이상 8000000000 이하인 자연수입니다.
	[입출력 예]
	n				return
	118372		873211
	*/
	public static void main(String[] args) {
		long n = 118372;
		
		System.out.print(n+" ");
		System.out.println(solution(n));
	}
	
	public static long solution(long n) {
		// n을 String으로 변환
        String str = String.valueOf(n);
        String temp = "";
        Long[] arr = new Long[str.length()];
        // str을 한 문자와 공백으로 나누어서 temp에 저장
        for(int i=0; i<str.length(); i++) {
        	temp += str.charAt(i)+" ";
        }
        // temp을 String 배열로 변환
        String[] strArr = temp.split(" ");
        // String 배열을 Long 배열로 변환
        for(int i=0; i<strArr.length; i++) {
        	arr[i] = Long.parseLong(strArr[i]);
        }
        // 내림차순으로 정렬
        Arrays.sort(arr, Collections.reverseOrder());
        // Long배열을 String으로 변환하고 다시 Long으로 변환하여 answer에 저장
        String arrStr = "";
        for(int i=0; i<arr.length; i++) {
        	arrStr += arr[i];
        }
        long answer = Long.parseLong(arrStr);
        return answer;
    }
}
