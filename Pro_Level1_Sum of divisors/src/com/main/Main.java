package com.main;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class Main {
	/*
	[문제 설명]
	정수 n을 입력받아 n의 약수를 모두 더한 값을 리턴하는 함수, solution을 완성해주세요.
	[제한사항]
	n은 0 이상 3000이하인 정수입니다.
	[입출력 예]
	n		return
	12		28
	5		6
	[입출력 예 설명]
	입출력 예 #1
		12의 약수는 1, 2, 3, 4, 6, 12입니다. 이를 모두 더하면 28입니다.
	입출력 예 #2
		5의 약수는 1, 5입니다. 이를 모두 더하면 6입니다.
	*/
	public static void main(String[] args) {
		int n1 = 12;
		int n2 = 5;
		
		System.out.print(n1+" ");
		System.out.println(solution(n1));
		System.out.print(n2+" ");
		System.out.println(solution(n2));
	}
	
	public static int solution(int n) {
        int answer = 0;
        // 중복값을 가지지 않는 Set 생성
        Set<Integer> set = new HashSet<>();
        // 제곱근을 이용한 약수 구하기
        for(int i=1; i<=Math.sqrt(n); i++) {
        	if(n%i == 0) {
        		set.add(n/i);
        		set.add(i);
        	}
        }
        // Set에 있는 약수를 하나씩 가져와 answer에 더해준다.
        // Set은 순서가 없으므로 get()로 데이터를 가져오지 못하며 Iterator를 생성 while문으로 반복하며 데이터를 가져온다.
        Iterator<Integer> divisors = set.iterator();
        while(divisors.hasNext()) {
        	answer += divisors.next();
        }
        return answer;
    }

}
