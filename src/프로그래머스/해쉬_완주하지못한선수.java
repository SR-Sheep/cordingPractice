package ���α׷��ӽ�;

import java.util.HashMap;

public class �ؽ�_�����������Ѽ��� {
    /*
     * ������� �� : 1~100,000
     * completion+1=participant (�Ѹ� ���� ����)
     * �̸� = 1~20�� ���� �ҹ���
     * �������� ����
     */
	
	public static String solution(String[] participant, String[] completion) {
        //�� ����
		HashMap<String,Integer> map=new HashMap<String,Integer>();
        //������ ����� ���� �� ����, ���������� ��� value�� 1 �����մϴ�.
        for(String c:completion) {
        	map.put(c,map.getOrDefault(c, 0)+1);
        }
        //������ ��ȸ
        for(String p:participant) {
        	//�ʿ� ���ų� value�� 0�� ��� �����մϴ�.
        	if(map.get(p)==null||map.get(p)<1) return p;
        	//�����ϴ� ��� 1�� ���ҽ�ŵ�ϴ�.
        	map.put(p, map.get(p)-1);
        }
        return "";
    }
	
	public static void main(String[] args) {
		String[] participant={"leo", "kiki", "eden"};
		String[] completion = {"eden", "kiki"};
		String[] participant2={"mislav", "stanko", "mislav", "ana"};
		String[] completion2 = {"stanko", "ana", "mislav"};
		System.out.println(solution(participant2, completion2));
	}
}
