package 백준;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

//https://www.acmicpc.net/problem/10775
public class 공항 {
	
	static int[] Visited;
	
	public static int isDocking(int p) {
		if(p<0) return -1; //더이상 없음
		if(Visited[p]==-1) {
			return Visited[p] = p-1; //비어있으면 한칸 이전 idx 값
		}else {
			return Visited[p]= isDocking(Visited[p]); //idx값이 있으면 idx가 가르키는 idx값으로 변경
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int g = Integer.parseInt(br.readLine());
		int p = Integer.parseInt(br.readLine());
		//방문지 -1 로 초기화
		Visited = new int[g+1];
		for(int i=0;i<=g;i++) {
			Visited[i]=-1;
		}
		int answer = 0;
		for(int i=0;i<p;i++) {
			int gi = Integer.parseInt(br.readLine());
			if(isDocking(gi)>=0) { //idx가 존재한다면
				answer++;
			}else { //더이상 idx가 없다면 종료
				break;
			}
		}
		System.out.println(answer); //출력
		br.close();
	}
}
