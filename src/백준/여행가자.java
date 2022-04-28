package 백준;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 여행가자 {
	//https://www.acmicpc.net/problem/1976
	static int[] Roots; //root 저장
	//해당 도시의 root 찾기
	public static int getRoot(int city) {
		if(Roots[city]!=city){
			Roots[city]=getRoot(Roots[city]);
		}
		return Roots[city];
		
	}
	//2개의 도시의 root 세팅
	public static void setRoot(int city1, int city2) {
		//city1은 city2 보다 작은것으로 변경
		if(city1>city2) {
			int tmp = city1;
			city1= city2;
			city2 = tmp;
		}
		Roots[getRoot(city2)]=getRoot(city1);
	} 
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine()); //도시 수
		int m = Integer.parseInt(br.readLine()); //여행 계획 도시 수
		//각 도시들의 root는 본인의 번호로 초기화
		Roots= new int[n+1];
		for(int i=1;i<=n;i++) {
			Roots[i]=i;
		}
		StringTokenizer st;
		//연결된 도시 찾기
		for(int i=1;i<=n;i++) {
			st=new StringTokenizer(br.readLine());
			for(int j=1;j<=n;j++) {
				//연결여부, 1이면 연결됨
				int conn = Integer.parseInt(st.nextToken());
				//i보다 작은 j는 이미 탐색함, i와 j가 같으면 같은 도시임으로 생략
				if(i>=j) continue;
				//연결되어있으면 i번째와 j번째 도시 root 세팅
				if(conn==1) {
					setRoot(i, j);
				}
			}
		}
		st=new StringTokenizer(br.readLine());
		//첫번째 도시
		int city = Integer.parseInt(st.nextToken());
		//첫번째 도시의 root
		int root = getRoot(city);
		//답 여부 판단
		boolean isPossible = true;
		//주어진 도시 탐색
		for(int i=1;i<m;i++) {
			//다음 도시
			int next = Integer.parseInt(st.nextToken());
			//첫번째 도시의 root와 다음 도시의 root가 다르면 답이 될 수 없음 표시 후 break
			if(root!=getRoot(next)) {
				isPossible=false;
				break;
			}
		}
		//답이 가능하면 YES, 불가하면 NO 출력
		System.out.println(isPossible?"YES":"NO");
		br.close();
	}
}
