package 백준;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.StringTokenizer;

public class 최소스패닝트리 {
	//https://www.acmicpc.net/problem/1197
	
	static List<int[]> NodeList;
	static int[] Parents;
	static int V;
	
	//부모 찾기
	public static int getParent(int node) {
		if(Parents[node]==node) return node;
		return Parents[node]=getParent(Parents[node]);
	}
	//부모 세팅, 작은 수가 부모
	public static void setParent(int node1, int node2) {
		int p1 = getParent(node1);
		int p2 = getParent(node2);
		if(p1<p2) Parents[p2]=p1;
		else Parents[p1]=p2;
	}
	//같은 부모 판별
	public static boolean isSameParent(int node1, int node2) {
		//다른 부모라면 부모 세팅 후 false 리턴
		if(getParent(node1)!=getParent(node2)) {
			setParent(node1, node2);
			return false;
		}
		//같은 부모라면 true 리턴
		return true;
	}
	//크루스칼 알고리즘 사용
	public static int kruskal() {
		//간선 비용이 적은 순으로 정렬
		Collections.sort(NodeList, new Comparator<int[]>() {
			@Override
			public int compare(int[] o1, int[] o2) {
				if(o1[2]<o2[2]) return -1;
				else if(o1[2]>o2[2]) return 1;
				return 0;
			}
		});
		//선택한 간선의 개수
		int count = 0;
		int sum = 0;
		//탐색
		for(int[] edgeInfo:NodeList) {
			//모든 간선을 선택했다면 종료(트리의 간선 수 = n-1)
			if(count==V-1) break;
			int node1 = edgeInfo[0];
			int node2 = edgeInfo[1];
			int cost = edgeInfo[2];
			//다른 부모라면 간선 선택
			if(!isSameParent(node1, node2)) {
				//간선 개수 증가 및 비용 합계
				count++;
				sum+=cost;
			}
		}
		//비용 합계 출력
		return sum;
	}
	
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=new StringTokenizer(br.readLine());
		V=Integer.parseInt(st.nextToken()); //정점 개수
		int e=Integer.parseInt(st.nextToken()); //간선 개수
		int a=-1, b=-1, c=-1;
		Parents=new int[V+1];
		NodeList = new ArrayList<>();
		for(int i=1;i<=V;i++) {
			Parents[i]=i;
		}
		
		for(int i=0;i<e;i++) {
			st=new StringTokenizer(br.readLine());
			a=Integer.parseInt(st.nextToken()); //노드1
			b=Integer.parseInt(st.nextToken()); //노드2
			c=Integer.parseInt(st.nextToken()); //가중치
			NodeList.add(new int[] {a,b,c});
		}
		System.out.println(kruskal());
		br.close();
	}
}
