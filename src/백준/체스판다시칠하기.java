package 백준;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 체스판다시칠하기 {
	
	//https://www.acmicpc.net/problem/1018
	
	public static int solution(String[] board) {
		int answer=8*8; //모두 다 칠하는 경우 (최대값)
		//w로 시작하는 경우, b로 시작하는 경우를 2진수로 저장
		int[] wb = {Integer.parseInt("01010101",2),Integer.parseInt("10101010",2)};
		//높이 8이므로 최대 높이 -7까지
		for(int i=0;i<board.length-7;i++) {
			//가로길이 8이므로 최대 너비 -7 까지
			for(int j=0;j<board[0].length()-7;j++) {
				//W와 B의 개수
				int countW=0, countB=0;
				//8 줄 선정
				for(int k=0;k<8;k++) {
						//각 줄에 대해 탐색
						String tmp = board[k+i].substring(j, j+8);
						//W로 시작했을 때 몇 글자를 고쳐야 할지? (비트 카운트 이용) 
						countW+=Integer.bitCount(wb[k%2]^Integer.parseInt(tmp,2));
						//B로 시작했을 때 몇 글자를 고쳐여 할지? (비트 카운트 이용)
						countB+=Integer.bitCount(wb[(k+1)%2]^Integer.parseInt(tmp,2));
				}
				//최소값을 답으로 취함
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
			//W 0으로 변환, B 1로 변환
			board[i]=br.readLine().replaceAll("W", "0").replaceAll("B", "1");
		}
		br.close();
		System.out.println(solution(board));
	}
}
