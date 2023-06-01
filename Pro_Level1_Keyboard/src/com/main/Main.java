package com.main;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Main {
	/*
	[문제 설명]
	휴대폰의 자판은 컴퓨터 키보드 자판과는 다르게 하나의 키에 여러 개의 문자가 할당될 수 있습니다. 
	키 하나에 여러 문자가 할당된 경우, 동일한 키를 연속해서 빠르게 누르면 할당된 순서대로 문자가 바뀝니다.
	예를 들어, 1번 키에 "A", "B", "C" 순서대로 문자가 할당되어 있다면 1번 키를 한 번 누르면 "A", 두 번 누르면 "B", 세 번 누르면 "C"가 되는 식입니다.
	같은 규칙을 적용해 아무렇게나 만든 휴대폰 자판이 있습니다. 
	이 휴대폰 자판은 키의 개수가 1개부터 최대 100개까지 있을 수 있으며, 특정 키를 눌렀을 때 입력되는 문자들도 무작위로 배열되어 있습니다. 
	또, 같은 문자가 자판 전체에 여러 번 할당된 경우도 있고, 키 하나에 같은 문자가 여러 번 할당된 경우도 있습니다. 
	심지어 아예 할당되지 않은 경우도 있습니다. 따라서 몇몇 문자열은 작성할 수 없을 수도 있습니다.
	이 휴대폰 자판을 이용해 특정 문자열을 작성할 때, 키를 최소 몇 번 눌러야 그 문자열을 작성할 수 있는지 알아보고자 합니다.
	1번 키부터 차례대로 할당된 문자들이 순서대로 담긴 문자열배열 keymap과 입력하려는 문자열들이 담긴 문자열 배열 targets가 주어질 때, 
	각 문자열을 작성하기 위해 키를 최소 몇 번씩 눌러야 하는지 순서대로 배열에 담아 return 하는 solution 함수를 완성해 주세요.
	단, 목표 문자열을 작성할 수 없을 때는 -1을 저장합니다.
	[제한 사항]
	1 ≤ keymap의 길이 ≤ 100
		1 ≤ keymap의 원소의 길이 ≤ 100
		keymap[i]는 i + 1번 키를 눌렀을 때 순서대로 바뀌는 문자를 의미합니다.
			예를 들어 keymap[0] = "ABACD" 인 경우 1번 키를 한 번 누르면 A, 두 번 누르면 B, 세 번 누르면 A 가 됩니다.
		keymap의 원소의 길이는 서로 다를 수 있습니다.
		keymap의 원소는 알파벳 대문자로만 이루어져 있습니다.
	1 ≤ targets의 길이 ≤ 100
		1 ≤ targets의 원소의 길이 ≤ 100
		targets의 원소는 알파벳 대문자로만 이루어져 있습니다.
	[입출력 예 설명]
	keymap						targets					result
	["ABACD", "BCEFD"]	["ABCD","AABB"]	[9, 4]
	["AA"]						["B"]						[-1]
	["AGZ", "BSSS"]		["ASA","BGZ"]		[4, 6]
	["BC"]						["AC","BC"]			[-1, 3]
	[입출력 예 설명]
	입출력 예 #1
		"ABCD"의 경우,
		1번 키 한 번 → A
		2번 키 한 번 → B
		2번 키 두 번 → C
		1번 키 다섯 번 → D
		따라서 총합인 9를 첫 번째 인덱스에 저장합니다.
		"AABB"의 경우,
		1번 키 한 번 → A
		1번 키 한 번 → A
		2번 키 한 번 → B
		2번 키 한 번 → B
		따라서 총합인 4를 두 번째 인덱스에 저장합니다.
		결과적으로 [9,4]를 return 합니다.
	입출력 예 #2
		"B"의 경우, 'B'가 어디에도 존재하지 않기 때문에 -1을 첫 번째 인덱스에 저장합니다.
		결과적으로 [-1]을 return 합니다.
	입출력 예 #3
		"ASA"의 경우,
		1번 키 한 번 → A
		2번 키 두 번 → S
		1번 키 한 번 → A
		따라서 총합인 4를 첫 번째 인덱스에 저장합니다.
		"BGZ"의 경우,
		2번 키 한 번 → B
		1번 키 두 번 → G
		1번 키 세 번 → Z
		따라서 총합인 6을 두 번째 인덱스에 저장합니다.
		결과적으로 [4, 6]을 return 합니다.
	 */
	public static void main(String[] args) {
		String[] keymap1 = {"ABACD", "BCEFD"};
		String[] targets1 = {"ABCD", "AABB"};
		String[] keymap2 = {"AA"};
		String[] targets2 = {"B"};
		String[] keymap3 = {"AGZ", "BSSS"};
		String[] targets3 = {"ASA","BGZ"};
		String[] keymap4 = {"BC"};
		String[] targets4 = {"AC","BC"};
		
		System.out.println(Arrays.toString(keymap1) + " " + Arrays.toString(targets1));
		System.out.println(Arrays.toString(solution(keymap1, targets1)));
		System.out.println(Arrays.toString(keymap2) + " " + Arrays.toString(targets2));
		System.out.println(Arrays.toString(solution(keymap2, targets2)));
		System.out.println(Arrays.toString(keymap3) + " " + Arrays.toString(targets3));
		System.out.println(Arrays.toString(solution(keymap3, targets3)));
		System.out.println(Arrays.toString(keymap4) + " " + Arrays.toString(targets4));
		System.out.println(Arrays.toString(solution(keymap4, targets4)));
	}
	
	public static int[] solution(String[] keymap, String[] targets) {
		// answer배열의 길이는 targets배열의 길이와 같다.
        int[] answer = new int[targets.length];
        // targets배열의 길이 만큼 반복
        for(int i=0; i<targets.length; i++) {
        	// targets[i]의 길이 만큼 반복 (한 문자씩 탐색 해야하므로)
        	for(int j=0; j<targets[i].length(); j++) {
        		// targets[i]의 각 문자마다 keymap배열에서 탐색되는 인덱스 저장 List생성 
        		List<Integer> list = new ArrayList<>();
        		// keymap배열의 길이 만큼 반복
        		for(int k=0; k<keymap.length; k++) {
        			// keymap의 각 인덱스의 문자열에서 targets[i]문자열의 한 문자씩 꺼내어 탐색하여 첫번째로 탐색되는 인덱스를 저장
        			int temp = keymap[k].indexOf(targets[i].charAt(j));
        			// 만약 탐색이 되지 않아 temp가 -1이면 list에 저장하지 않는다.
        			if(temp != -1) {
        				list.add(temp+1);
        			}	
        		}
        		// 문제에서 최소한의 키 누름으로 만들어야하므로 오름차순 정렬하여 제일 처음 0번 인덱스를 꺼내와 answer배열의 각 인덱스에 더해 준다.
        		// 만약 list가 비어있으면 answer배열에 -1을 저장하고 break문으로 가장 가까운 for문을 벗어나서 다음으로 넘어간다.
        		Collections.sort(list);
        		if(list.size() != 0) {
        			answer[i] += list.get(0);
        		}else {
        			answer[i] = -1;
        			break;
        		}
        	}
        }
        return answer;
    }
}