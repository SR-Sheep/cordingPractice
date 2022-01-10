package ���α׷��ӽ�;

import java.util.ArrayList;
import java.util.List;

public class ����Ÿ��_�ܾ����� {
	//https://programmers.co.kr/learn/courses/30/lessons/12983
	
	static List<String>[] Pieces;
	static final int INF = 987654321;
	
    public static int solution(String[] strs, String t) {
    	Pieces = new ArrayList[6]; //������ ���� = idx�� ���
    	for(int i=1;i<6;i++) {
    		Pieces[i]=new ArrayList<>(); //�� ���̸��� ����Ʈ ����
    	}
    	//���� Ž��
    	for(String str:strs) {
    		Pieces[str.length()].add(str); //���� ���� idx�� ����Ʈ�� ���� �ֱ�
    	}
    	int len = t.length(); //���ڿ� ����
    	int[] dp = new int[len+1]; //dp ����
    	for(int i=1;i<=len;i++) {
    		dp[i]=INF; //1~ len ���� INF �� �ʱ�ȭ
    	}
    	for(int i=1;i<=len;i++) {
    		StringBuilder sb = new StringBuilder();
    		for(int j=1;j<=5;j++) {
    			if(i-j<0) break; //i-j��°�� 0���� ������ ��Ƽ��
    			sb.insert(0,t.charAt(i-j)); //sb�� �ѱ��ھ� �߰�
    			if(Pieces[j].contains(sb.toString())) { //�ش� ����Ʈ�� ������ �����Ѵٸ�
    				dp[i]=Math.min(dp[i-j]+1, dp[i]); //���� �߰� ������ dp +1 �� ���� dp ���� ���� ���� ����
    			}
    		}
    	}
    	return dp[len]==INF?-1:dp[len]; //���� ������� INF�� -1, �ƴϸ� �ش� ���� ���
    }
    
    public static void main(String[] args) {
		String[] strs = {"ba","na","n","a"};
		String t = "banana";
		System.out.println(solution(strs, t));
		String[] strs2 = {"app","ap","p","l","e","ple","pp"};
		String t2 = "apple";
		System.out.println(solution(strs2, t2));
		String[] strs3 = {"ab", "na", "n", "a", "bn"};
		String t3 = "nabnabn";
		System.out.println(solution(strs3, t3));
		String[] strs4 = {"ba", "an", "nan", "ban", "n"};
		String t4 = "banana";
		System.out.println(solution(strs4, t4));
	}
}
