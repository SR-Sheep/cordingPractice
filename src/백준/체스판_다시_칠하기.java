package 백준;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 체스판_다시_칠하기 {
	
	//https://www.acmicpc.net/problem/1018
	
	public static int solution(String[] board) {
		int answer=8*8;
		int[] wb = {Integer.parseInt("01010101",2),Integer.parseInt("10101010",2)};
		for(int i=0;i<board.length-7;i++) {
			for(int j=0;j<board[0].length()-7;j++) {
				int countW=0, countB=0;
				//탐색
				for(int k=0;k<8;k++) {
						String tmp = board[k+i].substring(j, j+8);
						countW+=Integer.bitCount(wb[k%2]^Integer.parseInt(tmp,2));
						countB+=Integer.bitCount(wb[(k+1)%2]^Integer.parseInt(tmp,2));
				}
				answer=Math.min(answer, countW);
				answer=Math.min(answer, countB);
			}
		}
		return answer;
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		String[] board=new String[n];
		for(int i=0;i<n;i++) {
			board[i]=br.readLine().replaceAll("W", "0").replaceAll("B", "1");
		}
		br.close();
		System.out.println(solution(board));
	}
}
