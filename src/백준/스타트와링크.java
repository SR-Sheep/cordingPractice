package ����;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class ��ŸƮ�͸�ũ {
	//https://www.acmicpc.net/problem/14889
	
	static int[][] Board;
	static int N;
	
	public static int solution() {
		int answer=Integer.MAX_VALUE;
		int half = N/2;
		int bit = 1<<N; //��Ʈ����ũ �̿�
		for(int i=1;i<bit;i++) {
			if(Integer.bitCount(i)==half) { //��Ʈ�� ���� ���� half�� ���� ��쿡��
				List<Integer> start = new ArrayList<Integer>();//��ŸƮ�� ���� ����
				List<Integer> link = new ArrayList<Integer>(); //��ũ�� ���� �ֱ�
				int startSum=0, linkSum=0;
				int sum=0;
				for(int j=0;j<N;j++) {
					int tmp = 1<<j;
					if((i&tmp)==tmp) {
						start.add(j);
					}else {
						link.add(j);
					}
				}
				//��ŸƮ�� ��
				for(int a:start) {
					for(int b:start) {
						startSum+=Board[a][b];
					}
				}
				//��ũ�� ��
				for(int a:link) {
					for(int b:link) {
						linkSum+=Board[a][b];
					}
				}
				//�� ������ ������ �ּҸ� ������ ����
				sum=startSum-linkSum;
				if(sum<0) sum*=-1;
				answer=Math.min(answer,sum);
				
			}
		}
		return answer;
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		N = Integer.parseInt(br.readLine());
		Board=new int[N][N];
		StringTokenizer st;
		for(int i=0;i<N;i++) {
			st=new StringTokenizer(br.readLine());
			for(int j=0;j<N;j++) {
				Board[i][j]=Integer.parseInt(st.nextToken());
			}
		}
		bw.append(solution()+"\n");
		br.close();
		bw.close();
	}
}
