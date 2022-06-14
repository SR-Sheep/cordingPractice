package 백준;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 사이클게임 {
	//https://www.acmicpc.net/problem/20040
	static int[] Roots; //root 저장
	//해당 node의 root 찾기
	public static int getRoot(int node) {
		if(Roots[node]!=node){
			Roots[node]=getRoot(Roots[node]);
		}
		return Roots[node];
		
	}
	//2개의 node의 root 세팅
	public static int setRoot(int node1, int node2) {
		//node1은 node2 보다 작은것으로 변경
		if(node1>node2) {
			int tmp = node1;
			node1= node2;
			node2 = tmp;
		}
		int root1 = getRoot(node1); //node1의 root
		int root2 = getRoot(node2); //node2의 root
		//node1의 root와 node2의 root가 서로 같음
		//= 이미 사이클이 생성됨
		//-> 1 리턴
		if(root1==root2) return 1;
		else {
			//node1의 root와 node2의 root가 서로 다르면 root 세팅 
			Roots[getRoot(node2)]=getRoot(node1);
			return -1;
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=new StringTokenizer(br.readLine());
		int n=Integer.parseInt(st.nextToken());// 노드의 수
		int m=Integer.parseInt(st.nextToken());// 연결된 점의 수
		
		int answer = 0; //답, 사이클이 존재하지 않으면 0
		Roots = new int[n]; //노드의 수만큼 root 생성
		for(int i=0;i<n;i++) {
			Roots[i]=i; //모든 root는 자기 자신 값을 가짐
		}
		
		for(int i=1;i<=m;i++) {
			st=new StringTokenizer(br.readLine());
			int node1=Integer.parseInt(st.nextToken());
			int node2=Integer.parseInt(st.nextToken());
			//node1과 node2의 부모 세팅, 사이클이면 1 아니면 -1
			int result = setRoot(node1, node2);
			//사이클 생성 시 해당 순번을 출력
			if(result>0) {
				answer = i;
				break;
			}
		}
		//출력
		System.out.println(answer);
		br.close();
	}
}
