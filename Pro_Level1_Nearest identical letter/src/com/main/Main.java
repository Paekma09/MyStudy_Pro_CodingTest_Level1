package com.main;

import java.util.Arrays;

public class Main {
	/*
	[문제 설명]
	문자열 s가 주어졌을 때, s의 각 위치마다 자신보다 앞에 나왔으면서, 자신과 가장 가까운 곳에 있는 같은 글자가 어디 있는지 알고 싶습니다.
	예를 들어, s="banana"라고 할 때,  각 글자들을 왼쪽부터 오른쪽으로 읽어 나가면서 다음과 같이 진행할 수 있습니다.
		b는 처음 나왔기 때문에 자신의 앞에 같은 글자가 없습니다. 이는 -1로 표현합니다.
		a는 처음 나왔기 때문에 자신의 앞에 같은 글자가 없습니다. 이는 -1로 표현합니다.
		n은 처음 나왔기 때문에 자신의 앞에 같은 글자가 없습니다. 이는 -1로 표현합니다.
		a는 자신보다 두 칸 앞에 a가 있습니다. 이는 2로 표현합니다.
		n도 자신보다 두 칸 앞에 n이 있습니다. 이는 2로 표현합니다.
		a는 자신보다 두 칸, 네 칸 앞에 a가 있습니다. 이 중 가까운 것은 두 칸 앞이고, 이는 2로 표현합니다.
	따라서 최종 결과물은 [-1, -1, -1, 2, 2, 2]가 됩니다.
	문자열 s이 주어질 때, 위와 같이 정의된 연산을 수행하는 함수 solution을 완성해주세요.
	[제한 조건]
	1 ≤ s의 길이 ≤ 10,000
		s은 영어 소문자로만 이루어져 있습니다.
	[입출력 예]
	s				result
	"banana"	[-1, -1, -1, 2, 2, 2]
	"foobar"		[-1, -1, 1, -1, -1, -1]
	[입출력 예 설명]
	입출력 예 #1
		지문과 같습니다.
	입출력 예 #2
		설명 생략
	 */
	public static void main(String[] args) {
		String s1 = "banana";
		String s2 = "foobar";
		
		System.out.println(s1);
		System.out.println(Arrays.toString(solution(s1)));
		System.out.println(s2);
		System.out.println(Arrays.toString(solution(s2)));
	}
	
	public static int[] solution(String s) {
		// answer의 길이는 문자열 s의 길이와 같다.
        int[] answer = new int[s.length()];
        // s문자열의 0번 인덱스 문자는 처음 나오는 문자이므로 반드시 answer[0] = -1 이다.
        answer[0] = -1;
        // 문자를 인덱스로 하나씩 꺼내어 그 인덱스 바로 앞 인덱스부터 앞으로 탐색한다.
        // 2차 반복문을 돌릴때 별도 count변수를 선언하여 반복문이 돈 횟수를 카운트한다.
        // i번 인덱스와 j번 인덱스의 문자가 같으면 answer배열에 count를 저장해주며 바로 반복문을 빠져 나온다.
        // 가장 가까운 같은 수를 찾는 것이기 때문이다.
        // 만약 같은 수가 없으면 answer는 -1이다.
        for(int i=1; i<s.length(); i++) {
        	for(int j=i-1, count=1; j>=0; j--, count++) {
        		if(s.charAt(i) == s.charAt(j)) {
        			answer[i] = count;
        			break;
        		}else {
        			answer[i] = -1;
        		}
        	}
        }
        return answer;
    }
}