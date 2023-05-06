package com.main;

public class Main {
	/*
	[문제 설명]
	대문자와 소문자가 섞여있는 문자열 s가 주어집니다. 
	s에 'p'의 개수와 'y'의 개수를 비교해 같으면 True, 다르면 False를 return 하는 solution를 완성하세요. 
	'p', 'y' 모두 하나도 없는 경우는 항상 True를 리턴합니다. 단, 개수를 비교할 때 대문자와 소문자는 구별하지 않습니다.
	예를 들어 s가 "pPoooyY"면 true를 return하고 "Pyy"라면 false를 return합니다.
	[제한사항]
	문자열 s의 길이 : 50 이하의 자연수
	문자열 s는 알파벳으로만 이루어져 있습니다.
	[입출력 예]
	s					answer
	"pPoooyY"		true
	"Pyy"			false
	[입출력 예 설명]
	입출력 예 #1
		'p'의 개수 2개, 'y'의 개수 2개로 같으므로 true를 return 합니다.
	입출력 예 #2
		'p'의 개수 1개, 'y'의 개수 2개로 다르므로 false를 return 합니다.
	*/
	public static void main(String[] args) {
		String s1 = "pPoooyY";
		String s2 = "Pyy";
		
		System.out.print(s1+" ");
		System.out.println(solution(s1));
		System.out.print(s2+" ");
		System.out.println(solution(s2));
	}
	
	static boolean solution(String s) {
		// 문제에서 대소문자 구분이 없으므로 소문자로 통일한다.
		String str = s.toLowerCase();
		// p, y 선언 및 초기화
		int p = 0;
		int y = 0;
		// str을 인덱스별로 'p', 'y'가 있는 지 카운트 하여 변수 p, y에 저장
		for(int i=0; i<s.length(); i++) {
			if(s.charAt(i) == 'p') {
				p++;
			}else if(s.charAt(i) == 'y') {
				y++;
			}
		}
        boolean answer = true;
        // p, y 모두 0 인 것과 아닌 것으로 분기
        if(p == 0 && y == 0) {
        	answer = true;
        }else {
        	// p, y의 비교
        	if(p == y) {
        		answer = true;
        	}else {
        		answer = false;
        	}
        }
        return answer;
    }
}
