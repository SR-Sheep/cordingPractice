package ���α׷��ӽ�;

import java.util.HashSet;
import java.util.Set;

public class ���̳ʺ�켱Ž��_��Ʈ��ũ {
	static int[] Link;
	
	//�θ� ã��
	public static int getParent(int x) {
		if(Link[x]==x) return x;
		return Link[x]= getParent(Link[x]);
	}
	
	//�θ� ����
	public static void setParent(int a,int b) {
		a=getParent(a);
		b=getParent(b);
		if(a<b) Link[b]=a;
		else Link[a]=b;
	}
	
	public static int solution(int n, int[][] computers) {
		int l= computers.length;
		Link=new int[l];
		//�ڽ��� �θ�� �ڱ� �ڽ��̴�.
		for(int i=0;i<l;i++) Link[i]=i;
		
		for(int i=0;i<l;i++) {
			for(int j=0;j<l;j++) {
				//1�̰ų� �ڱ� �ڽ��� �ƴϸ�
				if(computers[i][j]==1&&i!=j) {
					//�θ� ����
					setParent(i, j);
				}
			}
		}
		//�ߺ��� ���� �ϱ� ���� set
		Set<Integer> set = new HashSet<>();
		for(int i:Link) {
			//�θ���� set�� �ֱ�
			set.add(getParent(i));
		}
		//set�� ���� ��� = �θ��� �� ���
		return set.size();
	}
	
	public static void main(String[] args) {
		int n=3;
//		int[][] c={{1, 1, 0}, {1, 1, 0}, {0, 0, 1}};
		int[][] c={{1, 0, 0, 0, 0}, {0, 1, 0, 0, 1}, {0, 0, 1, 0, 1}, {0, 0, 0, 1, 1}, {1, 0, 0, 0, 1}};
		System.out.println(solution(n, c));
	}
}
