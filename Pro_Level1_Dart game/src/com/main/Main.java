package com.main;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {
	/*
	[문제 설명]
	카카오톡에 뜬 네 번째 별! 심심할 땐? 카카오톡 게임별~
	카카오톡 게임별의 하반기 신규 서비스로 다트 게임을 출시하기로 했다. 다트 게임은 다트판에 다트를 세 차례 던져 그 점수의 합계로 실력을 겨루는 게임으로, 모두가 간단히 즐길 수 있다.
	갓 입사한 무지는 코딩 실력을 인정받아 게임의 핵심 부분인 점수 계산 로직을 맡게 되었다. 다트 게임의 점수 계산 로직은 아래와 같다.
		1. 다트 게임은 총 3번의 기회로 구성된다.
		2. 각 기회마다 얻을 수 있는 점수는 0점에서 10점까지이다.
		3. 점수와 함께 Single(S), Double(D), Triple(T) 영역이 존재하고 각 영역 당첨 시 점수에서 1제곱, 2제곱, 3제곱 (점수1 , 점수2 , 점수3 )으로 계산된다.
		4. 옵션으로 스타상(*) , 아차상(#)이 존재하며 스타상(*) 당첨 시 해당 점수와 바로 전에 얻은 점수를 각 2배로 만든다. 아차상(#) 당첨 시 해당 점수는 마이너스된다.
		5. 스타상(*)은 첫 번째 기회에서도 나올 수 있다. 이 경우 첫 번째 스타상(*)의 점수만 2배가 된다. (예제 4번 참고)
		6. 스타상(*)의 효과는 다른 스타상(*)의 효과와 중첩될 수 있다. 이 경우 중첩된 스타상(*) 점수는 4배가 된다. (예제 4번 참고)
		7. 스타상(*)의 효과는 아차상(#)의 효과와 중첩될 수 있다. 이 경우 중첩된 아차상(#)의 점수는 -2배가 된다. (예제 5번 참고)
		8. Single(S), Double(D), Triple(T)은 점수마다 하나씩 존재한다.
		9. 스타상(*), 아차상(#)은 점수마다 둘 중 하나만 존재할 수 있으며, 존재하지 않을 수도 있다.
	0~10의 정수와 문자 S, D, T, *, #로 구성된 문자열이 입력될 시 총점수를 반환하는 함수를 작성하라.
	[입력 형식]
	"점수|보너스|[옵션]"으로 이루어진 문자열 3세트.
	예) 1S2D*3T
		점수는 0에서 10 사이의 정수이다.
		보너스는 S, D, T 중 하나이다.
		옵선은 *이나 # 중 하나이며, 없을 수도 있다.
	[출력 형식]
	3번의 기회에서 얻은 점수 합계에 해당하는 정수값을 출력한다.
	예) 37
	[입출력 예 설명]
	예제	dartResult		answer	설명
	1		1S2D*3T		37			11 * 2 + 22 * 2 + 33
	2		1D2S#10S		9			12 + 21 * (-1) + 101
	3		1D2S0T			3			12 + 21 + 03
	4		1S*2T*3S		23			11 * 2 * 2 + 23 * 2 + 31
	5		1D#2S*3S		5			12 * (-1) * 2 + 21 * 2 + 31
	6		1T2D3D#		-4			13 + 22 + 32 * (-1)
	7		1D2S3T*		59			12 + 21 * 2 + 33 * 2
	 */
	public static void main(String[] args) {
		String dartResult1 = "1S2D*3T";
		String dartResult2 = "1D2S#10S";
		String dartResult3 = "1D2S0T";
		String dartResult4 = "1S*2T*3S";
		String dartResult5 = "1D#2S*3S";
		String dartResult6 = "1T2D3D#";
		String dartResult7 = "1D2S3T*";
		
		System.out.println(dartResult1);
		System.out.println(solution(dartResult1));
		System.out.println(dartResult2);
		System.out.println(solution(dartResult2));
		System.out.println(dartResult3);
		System.out.println(solution(dartResult3));
		System.out.println(dartResult4);
		System.out.println(solution(dartResult4));
		System.out.println(dartResult5);
		System.out.println(solution(dartResult5));
		System.out.println(dartResult6);
		System.out.println(solution(dartResult6));
		System.out.println(dartResult7);
		System.out.println(solution(dartResult7));
	}
	// sum배열을 전역 변수로 선언 - 기회가 3번 이므로 길이는 3.
	static int[] sum = new int[3];
	
	public static int solution(String dartResult) {
        int answer = 0;
        // Pattern으로 compile할 문자열 만들기 (정규식)
        // [0-9]{1,2} - 숫자이며 자리수가 1자리 or 2자리 이다.
        // [S|T|D] - 문자 S/T/D 중 하나인 1자리 문자이다.(반드시)
        // [*|#]{0,1} - 특수 문자 * or # 중 하나인 1자리 문자이다.(없을 수도 있고 1자리로 있을 수도 있다)
        String temp = "([0-9]{1,2}[S|T|D][*|#]{0,1})";
        // pattern 생성 시 기회가 3번 이므로 pattern 문자열을 3번 더해준다.
        Pattern pattern = Pattern.compile(temp+temp+temp);
        // matcher 생성 시 pattern의 match메소드에 dartResult를 파라미터값으로 준다.
        Matcher matcher = pattern.matcher(dartResult);
        // matcher 문자열과 패턴이 일치하는 경우 true를 반환해주고 그 위치로 이동한다.
        matcher.find();
        //matcher와 pattern이 일치하는 group의 수 만큼 반복한다.
        for(int i=1; i<=matcher.groupCount(); i++) {
        	// 분리 할 group을 ( )로 구분하여 정규식으로 pattern을 만들어 준다.
        	Pattern p1 = Pattern.compile("([0-9]{1,2})([S|T|D])([*|#]{0,1})");
        	// pattern의 그룹 i를 matcher로 생성
        	Matcher m1 = p1.matcher(matcher.group(i));
        	// matcher 문자열과 패턴이 일치하는 경우 true를 반환해주고 그 위치로 이동한다.
        	m1.find();
        	// sum배열에 Math.pow() 메소드를 활용하여 파라미터 값 m1.group(1)과 m1.group(2)의 제곱을 구하여 넣는다.
        	// 여기서 m1.group(2)의 getBonus() 메소드를 통하여 1제곱인지, 2제곱인디, 3제곱인지를 반환받아서 제곱을 구한다.
        	sum[i-1] = (int) Math.pow(Integer.parseInt(m1.group(1)) , getBonus(m1.group(2)));
        	// option()메소드에 파라미터로 i와 m1.group(3)을 넣어 sum배열에 반영해준다.
        	option(i, m1.group(3));
        }
        answer = sum[0] + sum[1] + sum[2];
        return answer;
    }
	// "S"이면 1, "D"이면 2, "T"이면 3을 반환하다.
	public static int getBonus(String s) {
		if(s.equals("S")) {
			return 1;
		} else if(s.equals("D")) {
			return 2;
		} else {
			return 3;
		}
	}
	// "*"이면 sum에 2를 곱해주고, "#"이면 sum에 -1을 곱해준다.
	// 단, "*"은 중첩을 허용하기 때문에 아래와 같이 조건을 달아준다.
	public static void option(int idx, String s) {
		if(s.equals("*")) {
			sum[idx - 1] *= 2;
			if(idx > 1) {
				sum[idx - 2] *= 2;
			}
		}else if(s.equals("#")) {
			sum[idx - 1] *= -1;
		}
	}
}