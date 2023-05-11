package com.main;

public class Main {
	/*
	[문제 설명]
	단어 s의 가운데 글자를 반환하는 함수, solution을 만들어 보세요. 단어의 길이가 짝수라면 가운데 두글자를 반환하면 됩니다.
	[제한사항]
	s는 길이가 1 이상, 100이하인 스트링입니다.
	[입출력 예]
	s				return
	"abcde"		"c"
	"qwer"		"we"
	*/
	public static void main(String[] args) {
		String s1 = "abcde";
		String s2 = "qwer";
		
		System.out.print(s1+" ");
		System.out.println(solution(s1));
		System.out.print(s2+" ");
		System.out.println(solution(s2));
	}
	
	public static String solution(String s) {
        String answer = "";
        // s의 길이가 짝수일 때와 홀수 일 때로 분기
        // substring으로 가운데 문자가 반환되게 문자열 나누어 준다.
        if(s.length()%2 == 1){
            answer = s.substring(s.length()/2,s.length()/2+1);
        }else{
            answer = s.substring((s.length()/2)-1,s.length()/2+1);
        }
        return answer;
    }
}
