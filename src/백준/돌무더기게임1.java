package 백준;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class 돌무더기게임1 {
	//https://www.acmicpc.net/problem/24678
	//돌의 개수가 홀수인 무더기가 2개 이상이라면 후공이 이기고, 아니라면 선공이 승리
	public static char winnerOfStoneGame(long[] stones) {
		int odd=0;
		for(long stone:stones) {
			if(stone%2==1) {
				odd++;
			}
		}
		if(odd>1) return 'B';
		return 'R';
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int t = Integer.parseInt(br.readLine());
		StringTokenizer st;
		for(int i=0;i<t;i++) {
			st=new StringTokenizer(br.readLine());
			long[] stones = new long[3];
			for(int j=0;j<3;j++) {
				stones[j]=Long.parseLong(st.nextToken());
			}
			bw.append(winnerOfStoneGame(stones)+"\n");
		}
		br.close();
		bw.close();
	}
}
