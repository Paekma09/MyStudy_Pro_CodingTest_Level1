package com.main;

import java.util.Arrays;

public class Main {
	/*
	[문제 설명]
	코니는 영어 단어가 적힌 카드 뭉치 두 개를 선물로 받았습니다. 
	코니는 다음과 같은 규칙으로 카드에 적힌 단어들을 사용해 원하는 순서의 단어 배열을 만들 수 있는지 알고 싶습니다.
		원하는 카드 뭉치에서 카드를 순서대로 한 장씩 사용합니다. 
		한 번 사용한 카드는 다시 사용할 수 없습니다.
		카드를 사용하지 않고 다음 카드로 넘어갈 수 없습니다.
		기존에 주어진 카드 뭉치의 단어 순서는 바꿀 수 없습니다.
	예를 들어 첫 번째 카드 뭉치에 순서대로 ["i", "drink", "water"], 두 번째 카드 뭉치에 순서대로 ["want", "to"]가 적혀있을 때 
	["i", "want", "to", "drink", "water"] 순서의 단어 배열을 만들려고 한다면 첫 번째 카드 뭉치에서 "i"를 사용한 후 
	두 번째 카드 뭉치에서 "want"와 "to"를 사용하고 첫 번째 카드뭉치에 "drink"와 "water"를 차례대로 사용하면 
	원하는 순서의 단어 배열을 만들 수 있습니다.
	문자열로 이루어진 배열 cards1, cards2와 원하는 단어 배열 goal이 매개변수로 주어질 때, 
	cards1과 cards2에 적힌 단어들로 goal를 만들 있다면 "Yes"를, 만들 수 없다면 "No"를 return하는 solution 함수를 완성해주세요.
	[제한 조건]
	1 ≤ cards1의 길이, cards2의 길이 ≤ 10
		1 ≤ cards1[i]의 길이, cards2[i]의 길이 ≤ 10
		cards1과 cards2에는 서로 다른 단어만 존재합니다.
	2 ≤ goal의 길이 ≤ cards1의 길이 + cards2의 길이
		1 ≤ goal[i]의 길이 ≤ 10
		goal의 원소는 cards1과 cards2의 원소들로만 이루어져 있습니다.
	cards1, cards2, goal의 문자열들은 모두 알파벳 소문자로만 이루어져 있습니다.
	[입출력 예]
	cards1						cards2			goal												result
	["i", "drink", "water"]	["want", "to"]	["i", "want", "to", "drink", "water"]	"Yes"
	["i", "water", "drink"]	["want", "to"]	["i", "want", "to", "drink", "water"]	"No"	
	[입출력 예 설명]
	입출력 예 #1
		본문과 같습니다.
	입출력 예 #2
		cards1에서 "i"를 사용하고 cards2에서 "want"와 "to"를 사용하여 "i want to"까지는 만들 수 있지만 
		"water"가 "drink"보다 먼저 사용되어야 하기 때문에 해당 문장을 완성시킬 수 없습니다. 따라서 "No"를 반환합니다.
	 */
	public static void main(String[] args) {
		String[] cards1 = {"i", "drink", "water"};
		String[] cards2 = {"want", "to"};
		String[] goal1 = {"i", "want", "to", "drink", "water"};
		String[] cards3 = {"i", "water", "drink"};
		String[] cards4 = {"want", "to"};
		String[] goal2 = {"i", "want", "to", "drink", "water"};
		String[] cards5 = {"a"};
		String[] cards6 = {"b"};
		String[] goal3 = {"a" ,"c"};
		String[] cards7 = {"i", "see", "to"};
		String[] cards8 = {"you", "now", "me"};
		String[] goal4 = {"i", "see", "now", "me"};
		String[] cards9 = {"a", "b", "c"};
		String[] cards10 = {"d", "e"};
		String[] goal5 = {"b", "c", "d", "e"};
		
		System.out.println(Arrays.toString(cards1)+" "+Arrays.toString(cards2)+" "+Arrays.toString(goal1));
		System.out.println(solution(cards1, cards2, goal1));
		System.out.println(Arrays.toString(cards3)+" "+Arrays.toString(cards4)+" "+Arrays.toString(goal2));
		System.out.println(solution(cards3, cards4, goal2));
		System.out.println(Arrays.toString(cards5)+" "+Arrays.toString(cards6)+" "+Arrays.toString(goal3));
		System.out.println(solution(cards5, cards6, goal3));
		System.out.println(Arrays.toString(cards7)+" "+Arrays.toString(cards8)+" "+Arrays.toString(goal4));
		System.out.println(solution(cards7, cards8, goal4));
		System.out.println(Arrays.toString(cards9)+" "+Arrays.toString(cards10)+" "+Arrays.toString(goal5));
		System.out.println(solution(cards9, cards10, goal5));
	}
	
	public static String solution(String[] cards1, String[] cards2, String[] goal) {
		// 문제의 정답을 Yes로 저장
        String answer = "Yes";
        // goal의 배열을 순회하며 cards1배열과 cards2배열을 동시에 탐색한다.
        // cards 배열의 인덱스를 만들고 각 cards의 배열의 길이보다 작고 goal과 같으면 인덱스를 1증가하고 다음 문자로 넘어간다.
        // 어떤 cards 배열의 어떤 문자도 일치하지 않으면 바로 "No"를 반환한다.
        int cards1Index = 0;
        int cards2Index = 0;
        
        for(int i=0; i<goal.length; i++) {
        	if(cards1Index < cards1.length && goal[i].equals(cards1[cards1Index])) {
        		cards1Index++;
        		continue;
        	}
        	if(cards2Index < cards2.length && goal[i].equals(cards2[cards2Index])) {
        		cards2Index++;
        		continue;
        	}
        	answer = "No";
        	return answer;
        }
        return answer;
	}
}