package com.main;

public class Main {
	/*
	[문제 설명]
	두 문자열 s와 skip, 그리고 자연수 index가 주어질 때, 다음 규칙에 따라 문자열을 만들려 합니다. 암호의 규칙은 다음과 같습니다.
		문자열 s의 각 알파벳을 index만큼 뒤의 알파벳으로 바꿔줍니다.
		index만큼의 뒤의 알파벳이 z를 넘어갈 경우 다시 a로 돌아갑니다.
		skip에 있는 알파벳은 제외하고 건너뜁니다.
	예를 들어 s = "aukks", skip = "wbqd", index = 5일 때, a에서 5만큼 뒤에 있는 알파벳은 f지만 [b, c, d, e, f]에서 'b'와 'd'는 skip에 포함되므로 세지 않습니다.
	따라서 'b', 'd'를 제외하고 'a'에서 5만큼 뒤에 있는 알파벳은 [c, e, f, g, h] 순서에 의해 'h'가 됩니다. 나머지 "ukks" 또한 위 규칙대로 바꾸면 "appy"가 되며 결과는 "happy"가 됩니다.
	두 문자열 s와 skip, 그리고 자연수 index가 매개변수로 주어질 때 위 규칙대로 s를 변환한 결과를 return하도록 solution 함수를 완성해주세요.
	[제한 사항]
	5 ≤ s의 길이 ≤ 50
	1 ≤ skip의 길이 ≤ 10
	s와 skip은 알파벳 소문자로만 이루어져 있습니다.
		skip에 포함되는 알파벳은 s에 포함되지 않습니다.
	1 ≤ index ≤ 20
	[입출력 예 설명]
	s				skip			index		result
	"aukks"		"wbqd"		5			"happy"
	"zzzzz"		"a"			1			"bbbbb"
	[입출력 예 설명]
	입출력 예 #1
		본문 내용과 일치합니다.
	 */
	public static void main(String[] args) {
		String s = "aukks";
		String skip = "wbqd";
		int index = 5;
		String s1 = "zzzzz";
		String skip1 = "a";
		int index1 = 1;
		String s2 = "z";
		String skip2 = "abcdefghij";
		int index2 = 20;
		
		System.out.println(s + " " + skip + " " + index);
		System.out.println(solution(s, skip, index));
		System.out.println(s1 + " " + skip1 + " " + index1);
		System.out.println(solution(s1, skip1, index1));
		System.out.println(s2 + " " + skip2 + " " + index2);
		System.out.println(solution(s2, skip2, index2));
	}
	
	public static String solution(String s, String skip, int index) {
		// 문자열 s를 char배열로 변환
        char[] chararcters = s.toCharArray();
        // char배열 길이만큼 반복
        for(int i=0; i<chararcters.length; i++) {
        	// index 만큼 반복
        	for(int j=1; j<=index; j++) {
        		// do while문의 초기에 char배열의 i인텍스 값을 1씩 더한다. 그 다음 if문으로 가고, 그 다음 while문의 조건식을 검증한다.
        		// while 조건문 false이면 j++ 를 실행하여 다시 do while 문의 초기로 간다.
        		// while 조건문 true이면 j++를 실행하지 않고 계속 do while문 안을 반복한다. 
        		do {
        			chararcters[i]++;
        			if(chararcters[i] > 122) {
        				chararcters[i] -= 26;
        			}
        		}while(skip.contains(String.valueOf(chararcters[i])));
        	}
        }
        // 반복이 완료된 char배열을 문자열로 변환하여 answer에 넣어준다.
        String answer = String.valueOf(chararcters);
        return answer;
    }
}