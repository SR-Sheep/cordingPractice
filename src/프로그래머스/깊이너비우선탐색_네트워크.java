package 프로그래머스;

import java.util.HashSet;
import java.util.Set;

public class 깊이너비우선탐색_네트워크 {
	static int[] Link;
	
	//부모 찾기
	public static int getParent(int x) {
		if(Link[x]==x) return x;
		return Link[x]= getParent(Link[x]);
	}
	
	//부모 병합
	public static void setParent(int a,int b) {
		a=getParent(a);
		b=getParent(b);
		if(a<b) Link[b]=a;
		else Link[a]=b;
	}
	
	public static int solution(int n, int[][] computers) {
		int l= computers.length;
		Link=new int[l];
		//자신의 부모는 자기 자신이다.
		for(int i=0;i<l;i++) Link[i]=i;
		
		for(int i=0;i<l;i++) {
			for(int j=0;j<l;j++) {
				//1이거나 자기 자신이 아니면
				if(computers[i][j]==1&&i!=j) {
					//부모 설정
					setParent(i, j);
				}
			}
		}
		//중복을 제거 하기 위한 set
		Set<Integer> set = new HashSet<>();
		for(int i:Link) {
			//부모들을 set에 넣기
			set.add(getParent(i));
		}
		//set의 길이 출력 = 부모의 수 출력
		return set.size();
	}
	
	public static void main(String[] args) {
		int n=3;
//		int[][] c={{1, 1, 0}, {1, 1, 0}, {0, 0, 1}};
		int[][] c={{1, 0, 0, 0, 0}, {0, 1, 0, 0, 1}, {0, 0, 1, 0, 1}, {0, 0, 0, 1, 1}, {1, 0, 0, 0, 1}};
		System.out.println(solution(n, c));
	}
}
