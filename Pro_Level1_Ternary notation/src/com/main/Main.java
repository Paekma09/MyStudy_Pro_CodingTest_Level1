package com.main;

public class Main {
	/*
	[문제 설명]
	자연수 n이 매개변수로 주어집니다. 
	n을 3진법 상에서 앞뒤로 뒤집은 후, 이를 다시 10진법으로 표현한 수를 return 하도록 solution 함수를 완성해주세요.
	[제한사항]
	n은 1 이상 100,000,000 이하인 자연수입니다.
	[입출력 예]
	n		result
	45		7
	125	229
	[입출력 예 설명]
	입출력 예 #1
		답을 도출하는 과정은 다음과 같습니다.
		n (10진법)	n (3진법)	앞뒤 반전(3진법)	10진법으로 표현
		45				1200			0021					7
		따라서 7을 return 해야 합니다.
	입출력 예 #2
		답을 도출하는 과정은 다음과 같습니다.
		n (10진법)	n (3진법)	앞뒤 반전(3진법)	10진법으로 표현
		125			11122		22111				229
		따라서 229를 return 해야 합니다.
	*/
	public static void main(String[] args) {
		int n1 = 45;
		int n2 = 125;
		
		System.out.print(n1+" ");
		System.out.println(solution(n1));
		System.out.print(n2+" ");
		System.out.println(solution(n2));
	}
	
	public static int solution(int n) {
        int answer = 0;
        // int형 10진수를 문자열 3진수로 변환
        String three = Integer.toString(n, 3);
        // 문자열을 이용하여 StringBuffer 생성
        StringBuffer sb = new StringBuffer(three);
        // StringBuffer를 이용하여 문자열 뒤집기하고 다시 문자열로 저장
        String reverseThree = sb.reverse().toString();
        // 문자열 3진수를 int형 10진수로 변환 저장
        answer = Integer.parseInt(reverseThree, 3);
        return answer;
    }
}
