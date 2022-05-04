package 백준;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class 랜선연결 {
	//https://www.acmicpc.net/problem/25048
	//최대 비용
	static final long INF = Long.MAX_VALUE/3;
	//스위치 클래스
	static class Swich implements Comparable<Swich>{
		int portCount;
		long cost;
		public Swich(int portCount , long cost) {
			this.portCount= portCount;
			this.cost = cost;
		}
		//정렬, 1) 비용이 적은 순, 2) 포트 수가 적은 순 
		@Override
		public int compareTo(Swich o) {
			if(this.cost<o.cost) return -1;
			else if(this.cost>o.cost) return 1;
			else {
				if(this.portCount<o.portCount) return -1;
				else if(this.portCount>o.portCount) return 1;
				return 0;
			}
		}
	}
	
	public static long getMinCost(List<Swich> list, int swichs, int computers) {
		//리스트 정렬
		Collections.sort(list);
		//다이나믹 프로그래밍을 위한 배열 선언
		long[][] dp = new long[swichs+1][computers+1];
		//배열 값 INF로 초기화
		for(int i=0;i<swichs+1;i++) {
			for(int j=0;j<computers+1;j++) {
				dp[i][j]=INF;
			}
		}
		//스위치 0개에는 컴퓨터 1개만 사용 가능
		dp[0][1]=0;
		//연결한 스위치 번호
		for(int i=1;i<=swichs;i++) {
			Swich swich = list.get(i-1);
			//연결한 컴퓨터 수
			for(int j=1;j<=computers;j++) {
				//현재 스위치를 연결한 경우가 이전 스위치를 연결한 경우보다 비용이 적다면 업데이트
				//(이전 스위치의 연결한 컴퓨터 수 -1(인터넷 공급을 위한 선) +  현재 스위치의 포트 수 = j)
				//=> 이전 스위치의 연결한 컴퓨터 수 = j - 현재 스위치의 포트 수 +1
				if(j-swich.portCount+1>=0
						&&j-swich.portCount+1<=computers
						&&dp[i-1][j]>dp[i-1][j-swich.portCount+1]+swich.cost) {
					dp[i][j]=dp[i-1][j-swich.portCount+1]+swich.cost;
				//아닐 시 이전 스위치 비용과 같음
				}else {
					dp[i][j]=dp[i-1][j];
				}
			}
		}
		
		return dp[swichs][computers]==INF?-1:dp[swichs][computers];
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		List<Swich> list = new ArrayList<>();
		StringTokenizer st;
		for(int i=0;i<n;i++) {
			st=new StringTokenizer(br.readLine());
			int portCount=Integer.parseInt(st.nextToken())-1; //인터넷 공급 선 제외(-1)
			int cost=Integer.parseInt(st.nextToken()); //비용
			list.add(new Swich(portCount, cost));
		}
		int m = Integer.parseInt(br.readLine());
		System.out.println(getMinCost(list, n, m));
		br.close();
	}
}
