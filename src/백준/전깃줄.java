package ����;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class ������ {
	//https://www.acmicpc.net/problem/2565
	public static int solution(int[][] lines) {
		int[] dp = new int[lines.length];
		int answer = 0; //��ġ ����
		for(int i=0;i<lines.length;i++) {
			dp[i]=1; //�����ڽ�
			for(int j=0;j<i;j++) { //���� �������� ���� ��
				if(lines[i][1]>lines[j][1]) { //B �����뿡 �ڽź��� ���� ���� ��� ��ġ ����
					dp[i]=Math.max(dp[i], dp[j]+1); //���ΰ� �ٸ� ������ + ����
				}
			}
			answer = Math.max(answer, dp[i]); //�ִ밪�� ������ ����
		}
		return lines.length-answer; //��ü - ��ġ����
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		StringTokenizer st;
		int[][] lines = new int[t][2];
		for(int i=0;i<t;i++) {
			st=new StringTokenizer(br.readLine());
			lines[i][0]=Integer.parseInt(st.nextToken());
			lines[i][1]=Integer.parseInt(st.nextToken());
		}
		Arrays.sort(lines, new Comparator<int[]>() {
			@Override
			public int compare(int[] o1, int[] o2) {
				return o1[0]-o2[0]; //��ġ ��ȣ�� �ڿ���, ���� ��ġ�� �ΰ� �̻� ������ ����
			}
		});
		System.out.println(solution(lines));
		br.close();
	}
}
