package ���α׷��ӽ�;

import java.util.PriorityQueue;

public class ��������_�����Ա� {
	//https://programmers.co.kr/learn/courses/30/lessons/12913
	/* �����Ա� ������ �Ϸ��� �մϴ�. �����Ա� ������ ��(land)�� �� N�� 4���� �̷���� �ְ�, ��� ĭ���� ������ ���� �ֽ��ϴ�.
	 * 1����� ���� ������ �� �྿ ������ ��, �� ���� 4ĭ �� �� ĭ�� �����鼭 �����;� �մϴ�.
	 * ��, �����Ա� ���ӿ��� �� �྿ ������ ��, ���� ���� �����ؼ� ���� �� ���� Ư�� ��Ģ�� �ֽ��ϴ�.
	 * ������ ����� ��� �������� ��, ���� �� �ִ� ������ �ִ밪�� return�ϴ� solution �Լ��� �ϼ��� �ּ���
	 */
    public static int solution(int[][] land) {
        int answer = 0;
        int[][] dp =new int[land.length][4];
        PriorityQueue<int[]> pq = new PriorityQueue<>((x,y)->(y[1]-x[1]));
        dp[0]=land[0];
        for(int i=1;i<land.length;i++){
            for(int j=0;j<4;j++){
                pq.add(new int[]{j,dp[i-1][j]}); //idx, ��
            }
            int[] first = pq.poll(); //���� �ִ밪(idx, value)
            int[] second = pq.poll(); //���� �ι�° �ִ밪(idx, value)
            for(int j=0;j<4;j++){
                if(first[0]!=j){
                    dp[i][j]=land[i][j]+first[1];
                }else{
                    dp[i][j]=land[i][j]+second[1];
                }
            }
            pq.clear();
        }
        for(int i=0;i<4;i++){
            answer=Math.max(answer,dp[land.length-1][i]);
        }
        return answer;
    }
}
