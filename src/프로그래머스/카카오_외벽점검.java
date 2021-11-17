package ���α׷��ӽ�;

import java.util.Arrays;

public class īī��_�ܺ����� {
	//https://programmers.co.kr/learn/courses/30/lessons/60062;
	//https://www.youtube.com/watch?v=LtPYdZbJlzk ������ ������
	//�ּҰ� ���ϱ� -> 1���� �����ϰ�, �湮���� üũ // 2��° ����� �湮�� �� �о��� ��� ����, ���� �ִ밪�� ������ �극��ũ
	
	static final int INF  = Integer.MAX_VALUE;
	static int[] Dist;
	static int[] Weak;
	static int N;
	static int Answer;
	
	static void search(int count, int position, int visited) {
		if(count>Dist.length||count>=Answer) return;
		
		for(int i=0;i<Weak.length;i++) {
			int next = (position+i)%Weak.length;
			int diff = Weak[next]-Weak[position];
			//�Ÿ��� ������ n ���ϱ�
			if(diff<0) diff+=N;
			//�� ��° ū ��
			if(diff>Dist[Dist.length-count]) break;
			//�湮���� Ȯ��
			visited|=1<<next;
		}
		//����� �湮�� �� ����
		if(visited==(1<<Weak.length)-1) {
			Answer=count;
			return;
		}
		for(int i=0;i<Weak.length;i++) {
			//�湮�� �� �о�
			if((visited&(1<<i))!=0) continue;
			//���
			search(count+1,i,visited);
		}
	}
	
    public static int solution(int n, int[] weak, int[] dist) {
        Answer=INF;
    	N=n;
        Arrays.sort(dist);
        Dist=dist;
        Weak=weak;
        
        for(int i=0;i<weak.length;i++) {
        	search(1, i, 0); //����, ������, �湮����
        }
        return Answer==INF?-1:Answer;
    }
    
	public static void main(String[] args) {
		int n = 12;
//		int[] weak = {1,5,6,10};
//		int[] dist= {1,2,3,4};
//		System.out.println(solution(n, weak, dist));
//		int[] weak2 = {1, 3, 4, 9, 10};
//		int[] dist2= {3,5,7};
//		System.out.println(solution(n, weak2, dist2));
		n=200;
		int[] weak3 = {0, 10, 50, 80, 120, 160};
		int[] dist3= {1, 10, 5, 40, 30};
		System.out.println(solution(n, weak3, dist3)); //3
		
	}

}
