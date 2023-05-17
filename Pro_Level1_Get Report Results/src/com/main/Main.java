package com.main;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;


public class Main {
	/*
	[���� ����]
	���Ի�� ������ �Խ��� �ҷ� �̿��ڸ� �Ű��ϰ� ó�� ����� ���Ϸ� �߼��ϴ� �ý����� �����Ϸ� �մϴ�. 
	������ �����Ϸ��� �ý����� ������ �����ϴ�.
	�� ������ �� ���� �� ���� ������ �Ű��� �� �ֽ��ϴ�.
	�Ű� Ƚ���� ������ �����ϴ�. ���� �ٸ� ������ ����ؼ� �Ű��� �� �ֽ��ϴ�.
	�� ������ ���� �� �Ű��� ���� ������, ������ ������ ���� �Ű� Ƚ���� 1ȸ�� ó���˴ϴ�.
	k�� �̻� �Ű�� ������ �Խ��� �̿��� �����Ǹ�, �ش� ������ �Ű��� ��� �������� ���� ����� ���Ϸ� �߼��մϴ�.
	������ �Ű��� ��� ������ �����Ͽ� �������� �Ѳ����� �Խ��� �̿� ������ ��Ű�鼭 ���� ������ �߼��մϴ�.
	������ ��ü ���� ����� ["muzi", "frodo", "apeach", "neo"]�̰�, k = 2(��, 2�� �̻� �Ű���ϸ� �̿� ����)�� ����� �����Դϴ�.

	���� ID		������ �Ű��� ID		����
	"muzi"		"frodo"				"muzi"�� "frodo"�� �Ű��߽��ϴ�.
	"apeach"	"frodo"				"apeach"�� "frodo"�� �Ű��߽��ϴ�.
	"frodo"		"neo"					"frodo"�� "neo"�� �Ű��߽��ϴ�.
	"muzi"		"neo"					"muzi"�� "neo"�� �Ű��߽��ϴ�.
	"apeach"	"muzi"				"apeach"�� "muzi"�� �Ű��߽��ϴ�.
	�� �������� �Ű���� Ƚ���� ������ �����ϴ�.

	���� ID		�Ű���� Ƚ��
	"muzi"		1
	"frodo"		2
	"apeach"	0
	"neo"			2
	�� ���ÿ����� 2�� �̻� �Ű���� "frodo"�� "neo"�� �Խ��� �̿��� �����˴ϴ�. 
	�̶�, �� �������� �Ű��� ���̵�� ������ ���̵� �����ϸ� ������ �����ϴ�.

	���� ID		������ �Ű��� ID			������ ID
	"muzi"		["frodo", "neo"]		["frodo", "neo"]
	"frodo"		["neo"]					["neo"]
	"apeach"	["muzi", "frodo"]	["frodo"]
	"neo"			����						����
	���� "muzi"�� ó�� ��� ������ 2ȸ, "frodo"�� "apeach"�� ���� ó�� ��� ������ 1ȸ �ް� �˴ϴ�.

	�̿����� ID�� ��� ���ڿ� �迭 id_list, �� �̿��ڰ� �Ű��� �̿����� ID ������ ��� ���ڿ� �迭 report, 
	���� ������ �Ǵ� �Ű� Ƚ�� k�� �Ű������� �־��� ��, �� �������� ó�� ��� ������ ���� Ƚ���� �迭�� ��� 
	return �ϵ��� solution �Լ��� �ϼ����ּ���.
	[���� ����]
	2 �� id_list�� ���� �� 1,000
		1 �� id_list�� ���� ���� �� 10
		id_list�� ���Ҵ� �̿����� id�� ��Ÿ���� ���ڿ��̸� ���ĺ� �ҹ��ڷθ� �̷���� �ֽ��ϴ�.
		id_list���� ���� ���̵� �ߺ��ؼ� ������� �ʽ��ϴ�.
	1 �� report�� ���� �� 200,000
		3 �� report�� ���� ���� �� 21
		report�� ���Ҵ� "�̿���id �Ű���id"������ ���ڿ��Դϴ�.
		���� ��� "muzi frodo"�� ��� "muzi"�� "frodo"�� �Ű��ߴٴ� �ǹ��Դϴ�.
		id�� ���ĺ� �ҹ��ڷθ� �̷���� �ֽ��ϴ�.
		�̿���id�� �Ű���id�� ����(�����̽�)�ϳ��� ���еǾ� �ֽ��ϴ�.
		�ڱ� �ڽ��� �Ű��ϴ� ���� �����ϴ�.
	1 �� k �� 200, k�� �ڿ����Դϴ�.
	return �ϴ� �迭�� id_list�� ��� id ������� �� ������ ���� ��� ���� ���� ������ �˴ϴ�.
	[����� ��]
	id_list											report																							k	result
	["muzi", "frodo", "apeach", "neo"]	["muzi frodo","apeach frodo","frodo neo","muzi neo","apeach muzi"]	2	[2,1,1,0]
	["con", "ryan"]								["ryan con", "ryan con", "ryan con", "ryan con"]								3	[0,0]
	[����� �� ����]
	����� �� #1
		������ ���ÿ� �����ϴ�.
	����� �� #2
		"ryan"�� "con"�� 4�� �Ű�������, �־��� ���ǿ� ���� �� ������ ���� ������ ���� �� �Ű��� ���� �Ű� Ƚ�� 1ȸ�� ó���մϴ�. 
		���� "con"�� 1ȸ �Ű���߽��ϴ�. 3�� �̻� �Ű���� �̿��ڴ� ������, "con"�� "ryan"�� ��� ������ ���� �ʽ��ϴ�. 
		���� [0, 0]�� return �մϴ�.
	 */
	public static void main(String[] args) {
		String[] id_list1 = {"muzi", "frodo", "apeach", "neo"};
		String[] report1 = {"muzi frodo","apeach frodo","frodo neo","muzi neo","apeach muzi"};
		int k1 = 2; 
		String[] id_list2 = {"con", "ryan"};
		String[] report2 = {"ryan con", "ryan con", "ryan con", "ryan con"};
		int k2 = 3; 
		
		System.out.println(Arrays.toString(id_list1)+" "+Arrays.toString(report1)+" "+k1);
		System.out.println(Arrays.toString(solution(id_list1, report1, k1)));
		System.out.println(Arrays.toString(id_list2)+" "+Arrays.toString(report2)+" "+k2);
		System.out.println(Arrays.toString(solution(id_list2, report2, k2)));
	}
	
	public static int[] solution(String[] id_list, String[] report, int k) {
		int[] answer = new int[id_list.length];
		// report�� �ߺ��� ���Ÿ� ���� Set���� ��ȯ (���� ���� ����)
		Set<String> reportSet = new LinkedHashSet<>(Arrays.asList(report));
		// �ߺ����� ������ Set�� �ٽ� �迭�� ��ȯ
		String[] reportArr = reportSet.toArray(new String[0]);
		// �Ű� ���� id=key, Ƚ��=value�� �����ϱ� ���� Map ���� �� ����
		Map<String, Integer> notify = new LinkedHashMap<>();
		for(String notifyId : reportArr) {
			String[] temp = notifyId.split(" ");
			// �� ������ �ٽ� �ڵ� getOrDefault() �޼ҵ� ���
			notify.put(temp[1], notify.getOrDefault(temp[1], 0) + 1);
		}
		// �Ű� ���� id �� �̿� ������ id List�� ����
		List<String> bannedId = new ArrayList<>();
		for(String notifyKey : notify.keySet()) {
			if(notify.get(notifyKey) >= k) {
				bannedId.add(notifyKey);
			}
		}
		// �̿� ������ id�� �Ű��� id ���ϱ�
		List<String> reportId = new ArrayList<>();
		for(int i=0; i<reportArr.length; i++) {
			String[] temp = reportArr[i].split(" ");
			for(int j=0; j<bannedId.size(); j++) {
				if(temp[1].equals(bannedId.get(j))) {
					reportId.add(temp[0]);
				}
			}
		}
		// �Ű��� id�� id_list ���ؼ� ������ ī�����Ͽ� answer�� ����
		for(int i=0; i<id_list.length; i++) {
			for(int j=0; j<reportId.size(); j++) {
				if(id_list[i].equals(reportId.get(j))) {
					answer[i]++;
				}
			}
		}
		return answer;
    }
}