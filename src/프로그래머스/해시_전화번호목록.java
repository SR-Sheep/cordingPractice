package ���α׷��ӽ�;

import java.util.HashSet;

public class �ؽ�_��ȭ��ȣ��� {
	/*
	 * phone_book�� 1-100,000
	 * �� ��ȣ ���� : 1- 20
	 * �ߺ� ��ȣ ����
	 */
    public static boolean solution(String[] phone_book) {
        HashSet<String> set = new HashSet<String>();
        for(String phone:phone_book) set.add(phone); //����ȣ set�� �ֱ�
        for(String phone:set) {
        	for(int i=1;i<phone.length();i++) {
        		String tmp=phone.substring(0,i); //����ȣ ��������
        		if(set.contains(tmp)) return false; //������ ����ȣ ���� �� false;
        	}
        }
        return true; //��� �����, true;
      }
	
	
	public static void main(String[] args) {
		String[][] sample = {{"119", "97674223", "1195524421"},{"123","456","789"},{"12","123","1235","567","88"}};
		for(String[] s:sample) {
			System.out.println(solution(s));
		}
		
	}

}
