package com.main;

public class Main {
	/*
	[문제 설명]
	정수 num이 짝수일 경우 "Even"을 반환하고 홀수인 경우 "Odd"를 반환하는 함수, solution을 완성해주세요.
	[제한사항]
	num은 int 범위의 정수입니다.
	0은 짝수입니다.
	[입출력 예]
	num	return
	3		"Odd"
	4		"Even"
	*/
	public static void main(String[] args) {
		int num1 = 3;
		int num2 = 4;
		
		System.out.print(num1+" ");
		System.out.println(solution(num1));
		System.out.print(num2+" ");
		System.out.println(solution(num2));
	}
	
	public static String solution(int num) {
        String answer = "";
        if(num%2 == 0){
            answer = "Even";
        }else{
            answer = "Odd";
        }
        return answer;
    }

}
