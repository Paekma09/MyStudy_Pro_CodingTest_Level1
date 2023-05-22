package com.main;

public class Main {
	/*
	[문제 설명]
	네오와 프로도가 숫자놀이를 하고 있습니다. 
	네오가 프로도에게 숫자를 건넬 때 일부 자릿수를 영단어로 바꾼 카드를 건네주면 프로도는 원래 숫자를 찾는 게임입니다.
	다음은 숫자의 일부 자릿수를 영단어로 바꾸는 예시입니다.
	1478 → "one4seveneight"
	234567 → "23four5six7"
	10203 → "1zerotwozero3"
	이렇게 숫자의 일부 자릿수가 영단어로 바뀌어졌거나, 혹은 바뀌지 않고 그대로인 문자열 s가 매개변수로 주어집니다. 
	s가 의미하는 원래 숫자를 return 하도록 solution 함수를 완성해주세요.
	참고로 각 숫자에 대응되는 영단어는 다음 표와 같습니다.
	숫자	영단어
	0		zero
	1		one
	2		two
	3		three
	4		four
	5		five
	6		six
	7		seven
	8		eight
	9		nine
	[제한사항]
	1 ≤ s의 길이 ≤ 50
	s가 "zero" 또는 "0"으로 시작하는 경우는 주어지지 않습니다.
	return 값이 1 이상 2,000,000,000 이하의 정수가 되는 올바른 입력만 s로 주어집니다.
	[입출력 예]
	s								result
	"one4seveneight"		1478
	"23four5six7"			234567
	"2three45sixseven"	234567
	"123"						123
	[입출력 예 설명]
	입출력 예 #1
		문제 예시와 같습니다.
	입출력 예 #2
		문제 예시와 같습니다.
	입출력 예 #3
		"three"는 3, "six"는 6, "seven"은 7에 대응되기 때문에 정답은 입출력 예 #2와 같은 234567이 됩니다.
		입출력 예 #2와 #3과 같이 같은 정답을 가리키는 문자열이 여러 가지가 나올 수 있습니다.
	입출력 예 #4
		s에는 영단어로 바뀐 부분이 없습니다.
	[제한시간 안내]
	정확성 테스트 : 10초
	*/
	public static void main(String[] args) {
		String s1 = "one4seveneight";
		String s2 = "23four5six7";
		String s3 = "2three45sixseven";
		String s4 = "123";
		
		System.out.print(s1+" \n");
		System.out.println(solution(s1));
		System.out.print(s2+" \n");
		System.out.println(solution(s2));
		System.out.print(s3+" \n");
		System.out.println(solution(s3));
		System.out.print(s4+" \n");
		System.out.println(solution(s4));
	}
	
	public static int solution(String s) {
        int answer = 0;
        // 문자열이 숫자인지 검사하여 숫자가 아니면 반복문을 돈다.
        while(isNumeric(s) == false) {
        	if(s.contains("one")) {
        		s = s.replace("one", "1");
        	}else if(s.contains("two")) {
        		s = s.replace("two", "2");
        	}else if(s.contains("three")) {
        		s = s.replace("three", "3");
        	}else if(s.contains("four")) {
        		s = s.replace("four", "4");
        	}else if(s.contains("five")) {
        		s = s.replace("five", "5");
        	}else if(s.contains("six")) {
        		s = s.replace("six", "6");
        	}else if(s.contains("seven")) {
        		s = s.replace("seven", "7");
        	}else if(s.contains("eight")) {
        		s = s.replace("eight", "8");
        	}else if(s.contains("nine")) {
        		s = s.replace("nine", "9");
        	}else if(s.contains("zero")) {
        		s = s.replace("zero", "0");
        	}
        }
        answer = Integer.parseInt(s);
        return answer;
    }
	// 문자열이 숫자인지 검사
	public static boolean isNumeric(String str) {
	    if (str == null) {
	        return false;
	    }
	    try {
	        Long l = Long.parseLong(str);
	    } catch (NumberFormatException nfe) {
	        return false;
	    }
	    return true;
	}

}
