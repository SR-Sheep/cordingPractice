package ���α׷��ӽ�;

import java.util.*;

public class īī��_3������ {
	//https://programmers.co.kr/learn/courses/30/lessons/17684
	
    public static int[] solution(String msg) {
        List<Integer> list = new ArrayList<>();
        HashMap<String, Integer> map = new HashMap<>();
        //map �ʱ�ȭ, ���ĺ� �ֱ�
        for(int i=0;i<26;i++){
            map.put(Character.toString('A'+i),i+1);
        }
        //���� idx, 27���� ����
        int idx=27;
        //�ܾ� �˻縦 ���� ��Ʈ�� ���� ����
        StringBuilder sb = new StringBuilder();
        for(char c:msg.toCharArray()){
        	sb.append(c); //�ܾ� ���̱�
        	//map�� ���ԵǾ� ���� ������
            if(!map.containsKey(sb.toString())){
            	//�ʿ� �ش� idx�� �ʿ� �߰�
            	map.put(sb.toString(), idx++);
            	//���� �ܾ �� �� map���� idx�� list�� �߰�
            	sb.deleteCharAt(sb.length()-1);
                list.add(map.get(sb.toString()));
                //sb�� ��� �����, �ٽ� ���� �ܾ� �ֱ�
            	sb.delete(0, sb.length());
            	sb.append(c);
            }
        }
        //������ �ܾ ���� idx
        list.add(map.get(sb.toString()));
        //�迭�� ��ȯ
        int[] answer = new int[list.size()];
        for(int i=0;i<list.size();i++) answer[i]=list.get(i);
        return answer;
    }
	
	public static void main(String[] args) {
		String[] msg = {"KAKAO","TOBEORNOTTOBEORTOBEORNOT","ABABABABABABABAB"};
		for(String m:msg) {
			for(int i:solution(m)) System.out.print(i+" ");
			System.out.println();
		}
	}
}
