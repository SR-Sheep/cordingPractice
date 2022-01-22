package 백준;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class 트리 {
	//https://www.acmicpc.net/problem/4803
	static List<Integer>[] Tree;
	//dfs
	public static boolean isTree(int before, int now, boolean[] visited) {
		boolean answer = true;
		//인접 리스트 탐색
		for(int adj:Tree[now]) {
			//바로 이전 노드일 경우, 이미 확인했음으로 패쓰
			if(adj==before) continue;
			//방문 이력이 있고, 바로 이전 노드가 아니라면 싸이클
			if(visited[adj]) {
				answer = false;
				continue;
			}
			//방문 여부 표시
			visited[adj]=true;
			//인접 리스트에 대해 false면 나도 false
			if(!isTree(now, adj, visited)) {
				answer = false;
			}
		}
		return answer;
	}
	
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		int caseNum = 0;
		while(true) {
			caseNum++; //케이스 넘버
			st=new StringTokenizer(br.readLine());
			int n=Integer.parseInt(st.nextToken()); //노드 수
			int t=Integer.parseInt(st.nextToken()); //간선 수
			
			if(n==0) break; //0 0 이면 중지
			
			Tree = new ArrayList[n+1]; //트리 생성
			boolean[] visited = new boolean[n+1]; //방문 여부
			//초기값 설정
			for(int i=1;i<=n;i++) {
				Tree[i]=new ArrayList<Integer>();
			}
			//각 인접 리스트에 node 추가
			for(int i=0;i<t;i++) {
				st=new StringTokenizer(br.readLine());
				int a=Integer.parseInt(st.nextToken());
				int b=Integer.parseInt(st.nextToken());
				Tree[a].add(b);
				Tree[b].add(a);
			}
			//답
			int answer = 0;
			//노드 탐색
			for(int i=1;i<=n;i++) {
				if(visited[i]) continue; //이미 방문시 컨티뉴
				visited[i]=true; //방문 여부 표시
				//트리라면 답 증가
				if(isTree(-1,i,visited)) answer++;
			}
			//출력 영역
			//케이스 번호 입력
			bw.append("Case ").append(caseNum+": ");
			//답이 2이상
			if(answer>1) {
				bw.append("A forest of "+answer+" trees.\n");
			//답이 1
			}else if(answer>0) {
				bw.append("There is one tree.\n");
			//답이 0
			}else {
				bw.append("No trees.\n");
			}
		}
		br.close();
		bw.close();
	}
}
