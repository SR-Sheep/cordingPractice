package 백준;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class 트리의부모찾기 {
	//https://www.acmicpc.net/problem/11725
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int t = Integer.parseInt(br.readLine());
		StringTokenizer st;
		List<Integer>[] list = new ArrayList[t+1]; //인접리스트 저장
		//리스트 객체 생성
		for(int i=0;i<t+1;i++) {
			list[i] = new ArrayList<>();
		}
		boolean[] visited = new boolean[t+1]; //방문여부
		int[] parents = new int[t+1]; //부모
		//인접리스트 추가
		for(int i=0;i<t-1;i++) {
			st=new StringTokenizer(br.readLine());
			int a=Integer.parseInt(st.nextToken());
			int b=Integer.parseInt(st.nextToken());
			list[a].add(b);
			list[b].add(a);
		}
		//큐 선언
		Queue<Integer> q = new LinkedList<>();
		q.add(1); //트리 루트 1 추가
		//너비 우선 탐색
		while(!q.isEmpty()) {
			int curr = q.poll();
			visited[curr]=true; //방문 체크
			//인접 리스트 검색
			for(int i:list[curr]) {
				if(visited[i]) continue; //방문시 패쓰
				parents[i]=curr; //비 방문시 부모 설정
				q.add(i); //큐에 새 번호 삽입
			}
		}
		//2부터 부모 출력
		for(int i=2;i<=t;i++) {
			bw.append(parents[i]+"\n");
		}
		br.close();
		bw.close();
	}
}
