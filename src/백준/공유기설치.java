package 백준;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 공유기설치 {
	//https://www.acmicpc.net/problem/2110
	
	static int RouterCount;
	static int[] Routers;
	
	public static boolean isPossible(int mid) {
		int count = 1; //처음 1개 설치
		int curr = Routers[0]; //공유기 위치, 처음부터 시작
		for(int i=0;i<Routers.length;i++) {
			if(Routers[i]-curr>=mid) { //공유기 거리가 mid 보다 크면
				count++; //횟수 증가
				curr=Routers[i]; //마지막 공유기 위치 업데이트
			}
		}
		return count>=RouterCount?true:false; //횟수가 공유기 수보다 많다면 true, 적다면 false
	}
	
	public static int solution() {
		Arrays.sort(Routers); //정렬
		int answer = 0;
		//이분 탐색
		int left=1,right=Routers[Routers.length-1],mid=-1;
		while(left<=right) {
			mid=(left+right)/2;
			if(isPossible(mid)) { //가능하면 답 업데이트
				answer=mid;
				left=mid+1; //최소값 증가
			}else {
				right=mid-1; //최대값 감소
			}
		}
		return answer;
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=new StringTokenizer(br.readLine());
		int n=Integer.parseInt(st.nextToken());
		RouterCount=Integer.parseInt(st.nextToken());
		Routers = new int[n];
		for(int i=0;i<n;i++) {
			Routers[i]=Integer.parseInt(br.readLine());
		}
		System.out.println(solution());
		br.close();
	}
}
