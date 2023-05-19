package com.main;

public class Main {
	/*
	[문제 설명]
	카카오에 입사한 신입 개발자 네오는 "카카오계정개발팀"에 배치되어, 카카오 서비스에 가입하는 유저들의 아이디를 생성하는 업무를 
	담당하게 되었습니다. "네오"에게 주어진 첫 업무는 새로 가입하는 유저들이 카카오 아이디 규칙에 맞지 않는 아이디를 입력했을 때, 
	입력된 아이디와 유사하면서 규칙에 맞는 아이디를 추천해주는 프로그램을 개발하는 것입니다.
	다음은 카카오 아이디의 규칙입니다.
		아이디의 길이는 3자 이상 15자 이하여야 합니다.
		아이디는 알파벳 소문자, 숫자, 빼기(-), 밑줄(_), 마침표(.) 문자만 사용할 수 있습니다.
		단, 마침표(.)는 처음과 끝에 사용할 수 없으며 또한 연속으로 사용할 수 없습니다.
	"네오"는 다음과 같이 7단계의 순차적인 처리 과정을 통해 신규 유저가 입력한 아이디가 카카오 아이디 규칙에 맞는 지 검사하고 
	규칙에 맞지 않은 경우 규칙에 맞는 새로운 아이디를 추천해 주려고 합니다.
	신규 유저가 입력한 아이디가 new_id 라고 한다면,	
		1단계 new_id의 모든 대문자를 대응되는 소문자로 치환합니다.
		2단계 new_id에서 알파벳 소문자, 숫자, 빼기(-), 밑줄(_), 마침표(.)를 제외한 모든 문자를 제거합니다.
		3단계 new_id에서 마침표(.)가 2번 이상 연속된 부분을 하나의 마침표(.)로 치환합니다.
		4단계 new_id에서 마침표(.)가 처음이나 끝에 위치한다면 제거합니다.
		5단계 new_id가 빈 문자열이라면, new_id에 "a"를 대입합니다.
		6단계 new_id의 길이가 16자 이상이면, new_id의 첫 15개의 문자를 제외한 나머지 문자들을 모두 제거합니다.
		     만약 제거 후 마침표(.)가 new_id의 끝에 위치한다면 끝에 위치한 마침표(.) 문자를 제거합니다.
		7단계 new_id의 길이가 2자 이하라면, new_id의 마지막 문자를 new_id의 길이가 3이 될 때까지 반복해서 끝에 붙입니다.
	예를 들어, new_id 값이 "...!@BaT#*..y.abcdefghijklm" 라면, 위 7단계를 거치고 나면 new_id는 아래와 같이 변경됩니다.
	1단계 대문자 'B'와 'T'가 소문자 'b'와 't'로 바뀌었습니다.
	"...!@BaT#*..y.abcdefghijklm" → "...!@bat#*..y.abcdefghijklm"
	2단계 '!', '@', '#', '*' 문자가 제거되었습니다.
	"...!@bat#*..y.abcdefghijklm" → "...bat..y.abcdefghijklm"
	3단계 '...'와 '..' 가 '.'로 바뀌었습니다.
	"...bat..y.abcdefghijklm" → ".bat.y.abcdefghijklm"
	4단계 아이디의 처음에 위치한 '.'가 제거되었습니다.
	".bat.y.abcdefghijklm" → "bat.y.abcdefghijklm"
	5단계 아이디가 빈 문자열이 아니므로 변화가 없습니다.
	"bat.y.abcdefghijklm" → "bat.y.abcdefghijklm"
	6단계 아이디의 길이가 16자 이상이므로, 처음 15자를 제외한 나머지 문자들이 제거되었습니다.
	"bat.y.abcdefghijklm" → "bat.y.abcdefghi"
	7단계 아이디의 길이가 2자 이하가 아니므로 변화가 없습니다.
	"bat.y.abcdefghi" → "bat.y.abcdefghi"
	따라서 신규 유저가 입력한 new_id가 "...!@BaT#*..y.abcdefghijklm"일 때, 
	네오의 프로그램이 추천하는 새로운 아이디는 "bat.y.abcdefghi" 입니다.
	[문제]
	신규 유저가 입력한 아이디를 나타내는 new_id가 매개변수로 주어질 때, 
	"네오"가 설계한 7단계의 처리 과정을 거친 후의 추천 아이디를 return 하도록 solution 함수를 완성해 주세요.
	[제한사항]
	new_id는 길이 1 이상 1,000 이하인 문자열입니다.
	new_id는 알파벳 대문자, 알파벳 소문자, 숫자, 특수문자로 구성되어 있습니다.
	new_id에 나타날 수 있는 특수문자는 -_.~!@#$%^&*()=+[{]}:?,<>/ 로 한정됩니다.
	[입출력 예]
	no		new_id										result
	예1	"...!@BaT#*..y.abcdefghijklm"	"bat.y.abcdefghi"
	예2	"z-+.^."									"z--"
	예3	"=.="										"aaa"
	예4	"123_.def"								"123_.def"
	예5	"abcdefghijklmn.p"					"abcdefghijklmn"
	[입출력 예 설명]
	입출력 예 #1
		문제의 예시와 같습니다.
	입출력 예 #2
		7단계를 거치는 동안 new_id가 변화하는 과정은 아래와 같습니다.
		1단계 변화 없습니다.
		2단계 "z-+.^." → "z-.."
		3단계 "z-.." → "z-."
		4단계 "z-." → "z-"
		5단계 변화 없습니다.
		6단계 변화 없습니다.
		7단계 "z-" → "z--"
	입출력 예 #3
		7단계를 거치는 동안 new_id가 변화하는 과정은 아래와 같습니다.
		1단계 변화 없습니다.
		2단계 "=.=" → "."
		3단계 변화 없습니다.
		4단계 "." → "" (new_id가 빈 문자열이 되었습니다.)
		5단계 "" → "a"
		6단계 변화 없습니다.
		7단계 "a" → "aaa"
	입출력 예 #4
		1단계에서 7단계까지 거치는 동안 new_id("123_.def")는 변하지 않습니다. 
		즉, new_id가 처음부터 카카오의 아이디 규칙에 맞습니다.
	입출력 예 #5
		1단계 변화 없습니다.
		2단계 변화 없습니다.
		3단계 변화 없습니다.
		4단계 변화 없습니다.
		5단계 변화 없습니다.
		6단계 "abcdefghijklmn.p" → "abcdefghijklmn." → "abcdefghijklmn"
		7단계 변화 없습니다.
	*/
	public static void main(String[] args) {
		String new_id1 = "...!@BaT#*..y.abcdefghijklm";
		String new_id2 = "z-+.^.";
		String new_id3 = "=.=";
		String new_id4 = "123_.def";
		String new_id5 = "abcdefghijklmn.p";
		
		System.out.println("입력값 : "+new_id1+" ");
		System.out.println("출력값 : "+solution(new_id1));
		System.out.println("입력값 : "+new_id2+" ");
		System.out.println("출력값 : "+solution(new_id2));
		System.out.println("입력값 : "+new_id3+" ");
		System.out.println("출력값 : "+solution(new_id3));
		System.out.println("입력값 : "+new_id4+" ");
		System.out.println("출력값 : "+solution(new_id4));
		System.out.println("입력값 : "+new_id5+" ");
		System.out.println("출력값 : "+solution(new_id5));
	}
	
	public static String solution(String new_id) {
		String answer = "";
        // 1단계 : 대문자를 모두 소문자로 변경
		String level1 = new_id.toLowerCase();
		// 2단계 : 정규식을 이용하여 허용되지 않은 문자는 모두 공백으로 대체
        String level2 = level1.replaceAll("[^a-z0-9A-Z-_.]", "");
        // 3단꼐 : 정규식을 이용하여 .이 여러개 나온 경우 .으로 모두 데체
        String level3 = level2.replaceAll("[.]{2,}", ".");
        // 4-1단계 : 첫 문자가 . 이면 공백으로 대체
        String level4 = level3;
        if(level3.charAt(0) == '.') {
        	level4 = level3.replaceFirst("[.]", "");
        }
        // 4-2단계 : 마지막 문자가 . 이면 공백으로 대체  
        if(level3.charAt(level3.length()-1) == '.') {
        	level4 = level3.replaceFirst(".$", "");
        }
        // 4-3단계 : 처음과 마지막 문자 모두 . 이면 모두 공백으로 대체
        if(level3.charAt(0) == '.' && level3.charAt(level3.length()-1) == '.') {
        	level4 = level3.replaceFirst("[.]", "").replaceFirst(".$", "");
        }
        // 5단계 : null이거나 비어있으면 a를 저장
        String level5 = level4;
        if(level4==null || level4.isEmpty()) {
        	level5 = "a";
        }
        // 6-1단계 : 길이가 15초과 이면 0번 인덱스부터 14번 인덱스까지 잘라낸다. 
        String level6 = level5;
        if(level6.length()>15) {
        	level6 = level6.substring(0, 15);	
        }
        // 6-2단계 : 잘라낸 문자열의 마지막 문자가 . 이면 공백으로 대체
        if(level6.charAt(level6.length()-1) == '.') {
            level6 = level6.replaceFirst(".$", "");
        }
        // 7단계 : 길이가 2이하이면 길이가 3이 될때까지 마지막 문자를 반복해서 채워준다.
        String level7 = level6;
        if(level6.length()<=2) {
            while(level7.length()<3){
                level7 += level6.charAt(level6.length()-1);
            }
        }
        answer = level7;
        return answer;
    }
}
