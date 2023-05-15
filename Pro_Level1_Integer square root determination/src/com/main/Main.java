package com.main;

public class Main {
	/*
	[문제 설명]
	임의의 양의 정수 n에 대해, n이 어떤 양의 정수 x의 제곱인지 아닌지 판단하려 합니다.
	n이 양의 정수 x의 제곱이라면 x+1의 제곱을 리턴하고, n이 양의 정수 x의 제곱이 아니라면 -1을 리턴하는 함수를 완성하세요.
	[제한사항]
	n은 1이상, 50000000000000 이하인 양의 정수입니다.
	[입출력 예]
	n		return
	121	144
	3		-1
	[입출력 예 설명]
	입출력 예 #1
		121은 양의 정수 11의 제곱이므로, (11+1)를 제곱한 144를 리턴합니다.
	입출력 예 #2
		3은 양의 정수의 제곱이 아니므로, -1을 리턴합니다.
	*/
	public static void main(String[] args) {
		long n1 = 121;
		long n2 = 3;
		
		System.out.print(n1+" ");
		System.out.println(solution(n1));
		System.out.print(n2+" ");
		System.out.println(solution(n2));
	}
	
	public static long solution(long n) {
        long answer = 0;
        // n의 제곱근 구하기 double형을 쓴 이유는 소수점 이하의 존재 유무를 확인 하기 위함
        double x = Math.sqrt(n);
        // 1로 나누었을 때 0이면 양의 정수 이고 아니면 소수점 이하가 나머지로 남기 때문이다.
        if(x%1 == 0.0) {
        	answer = (long) ((x + 1) * (x + 1));
        }else if(x%1 != 0.0){
        	answer = -1;
        }
        return answer;
    }
}
