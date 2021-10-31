package ���α׷��ӽ�;

import java.util.HashMap;

public class �������_��ųƮ�� {
	/*
	���� ����
	���� ��ų�̶� � ��ų�� ���� ���� ���� ����� �ϴ� ��ų�� ���մϴ�.

	���� ��� ���� ��ų ������ ����ũ �� ����Ʈ�� ��Ʈ �� ����϶�, ����� ������ ���� ����Ʈ�� ��Ʈ�� ����� �ϰ�, ����Ʈ�� ��Ʈ�� ������ ���� ����ũ�� ����� �մϴ�.

	�� ������ ���� �ٸ� ��ų(���� ��)�� ������ ������� ��� �� �ֽ��ϴ�.
	���� ����ũ �� ���� �� ����Ʈ�� ��Ʈ �� ����� ���� ��ųƮ���� ����������,
	��� �� ����ũ�� ����Ʈ�� ��Ʈ �� ����ũ �� ���� �� ����� ���� ��ųƮ���� �Ұ����մϴ�.

	���� ��ų ���� skill�� �������� ���� ��ųƮ��1�� ���� �迭 skill_trees�� �Ű������� �־��� ��,
	������ ��ųƮ�� ������ return �ϴ� solution �Լ��� �ۼ����ּ���.

	���� ����
	��ų�� ���ĺ� �빮�ڷ� ǥ���ϸ�, ��� ���ڿ��� ���ĺ� �빮�ڷθ� �̷���� �ֽ��ϴ�.
	��ų ������ ��ųƮ���� ���ڿ��� ǥ���մϴ�.
	���� ���, C �� B �� D ��� "CBD"�� ǥ���մϴ�
	���� ��ų ���� skill�� ���̴� 1 �̻� 26 �����̸�, ��ų�� �ߺ��� �־����� �ʽ��ϴ�.
	skill_trees�� ���� 1 �̻� 20 ������ �迭�Դϴ�.
	skill_trees�� ���Ҵ� ��ų�� ��Ÿ���� ���ڿ��Դϴ�.
	skill_trees�� ���Ҵ� ���̰� 2 �̻� 26 ������ ���ڿ��̸�, ��ų�� �ߺ��� �־����� �ʽ��ϴ�.
	*/
	
    public static int solution(String skill, String[] skill_trees) {
    	int answer = 0;
        for(String spell:skill_trees) {
        	HashMap<Character, Integer> map = new HashMap<>();
            for(char s:skill.toCharArray()) {
            	map.put(s, 20);
            }
            
            for(int i=0;i<spell.length();i++) {
            	if(map.containsKey(spell.charAt(i))){
            		map.put(spell.charAt(i), i);
            	}
            }
            int before=-1;
            boolean flag=true;
            for(char key:skill.toCharArray()) {
            	if(before >= map.get(key)) {
            		flag=false;
            		break;
            	}
            	before=map.get(key);
            }
            if(flag) answer++;
        }
    	
        return answer;
    }
	
	public static void main(String[] args) {
		String skill="CBD";
		String[] skill_trees= {"BACDE", "CBADF", "AECB", "BDA"};
		System.out.println(solution(skill, skill_trees));
		
	}
}
