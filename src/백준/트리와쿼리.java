package 백준;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class 트리와쿼리 {
	//https://www.acmicpc.net/problem/15681
	//방문여부(부모)
	static boolean[] Visited;
	//인접 리스트
	static List<Integer>[] Adj;
	//누적 자식 수 기록(서브트리)
	static int[] SubTreeCount;
	
	//트리 생성 및 자식수 리턴
	public static int makeTree(int node) {
		//노드 수(현재 본인 1개)
		int countnode = 1;
		//인접 리스트 탐색
		for(int child:Adj[node]) {
			//이미 방문(부모)라면 컨티뉴
			if(Visited[child]) continue;
			//방문 여부 체크
			Visited[child]=true;
			//자식의 자식들 수 추가
			countnode+= makeTree(child);
		}
		//자식들의 수 기록
		SubTreeCount[node]=countnode;
		//자식들 수 리턴
		return countnode;
		
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st=new StringTokenizer(br.readLine());
		int n=Integer.parseInt(st.nextToken()); //트리 정점
		int r=Integer.parseInt(st.nextToken()); //루트 번호
		int q=Integer.parseInt(st.nextToken()); //쿼리 수
		//선언
		SubTreeCount= new int[n+1];
		Visited=new boolean[n+1];
		Adj = new ArrayList[n+1];
		for(int i=0;i<=n;i++) {
			Adj[i]=new ArrayList<>();
		}
		//인접리스트 추가
		for(int i=0;i<n-1;i++) {
			st=new StringTokenizer(br.readLine());
			int node1=Integer.parseInt(st.nextToken());
			int node2=Integer.parseInt(st.nextToken());
			Adj[node1].add(node2);
			Adj[node2].add(node1);
		}
		//root 방문 여부 체크
		Visited[r]=true;
		//트리 생성
		makeTree(r);
		
		//출력
		for(int i=0;i<q;i++) {
			int node = Integer.parseInt(br.readLine());
			bw.append(SubTreeCount[node]+"\n");
		}
		
		bw.close();
		br.close();
	}
}
