package ���α׷��ӽ�;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ��Ŭ��_���¸��ѷγ����� {
	/*
	���� ����
	n���� ����ž�� ������ ���� �ϳ��� Ʈ�� ���·� ����Ǿ� �ֽ��ϴ�.
	����� �� ������ �� �ϳ��� ��� ������ ���¸� ��Ʈ��ũ�� 2���� �����Ϸ��� �մϴ�.
	�̶�, �� ���¸��� ���� �Ǵ� ����ž�� ������ �ִ��� ����ϰ� ���߰��� �մϴ�.

	����ž�� ���� n, �׸��� ���� ���� wires�� �Ű������� �־����ϴ�.
	������ �� �ϳ��� ��� ����ž ������ ������ ����ϵ��� �� ���¸����� �������� ��,
	�� ���¸��� ������ �ִ� ����ž ������ ����(���밪)�� return �ϵ��� solution �Լ��� �ϼ����ּ���.

	���ѻ���
	n�� 2 �̻� 100 ������ �ڿ����Դϴ�.
	wires�� ���̰� n-1�� ������ 2���� �迭�Դϴ�.
	wires�� �� ���Ҵ� [v1, v2] 2���� �ڿ����� �̷���� ������,
	�̴� ���¸��� v1�� ����ž�� v2�� ����ž�� �������� ����Ǿ� �ִٴ� ���� �ǹ��մϴ�.
	1 �� v1 < v2 �� n �Դϴ�.
	���¸� ��Ʈ��ũ�� �ϳ��� Ʈ�� ���°� �ƴ� ���� �Է����� �־����� �ʽ��ϴ�.
	*/
	
	
	//�θ�������
	public static int getParent(int x,int[] link) {
		if(link[x]==x) return x;
		return link[x]= getParent(link[x],link);
	}
	
	//�θ� ����
	public static void setParent(int a,int b,int[] link) {
		a=getParent(a,link);
		b=getParent(b,link);
		if(a<b) link[b]=a;
		else link[a]=b;
	}
	
	public static int countNode(int[] l,List<int[]> list) {
		int answer=0;
		int[] link=Arrays.copyOf(l, l.length);
		int nodes=link.length-1; //0 ����
		
		//list�� ������� �θ� ����
		for(int[] w:list) setParent(w[0], w[1], link);
		
		//�θ� �� ó����ҿ� ������ �� ����
		for(int i=1;i<link.length;i++) {
			if(1==getParent(i,link)) answer++;
		}
		// �θ�1�� �� - �θ�2�� ��
		// �θ�2�� �� = (��ü ��� �� - �θ� 1�� ��);
		// ��: abs(2*�θ�1�� �� - ��ü ��� ��)
		answer=2*answer-nodes;
		//�����Ͻ� ����� ��ȯ
		return answer<0?answer*-1:answer;
	}
	
    public static int solution(int n, int[][] wires) {
    	final int INF = 987654321;
    	int answer = INF;
    	//1~n link ����(0 ��� ����)
    	int[] link=new int[n+1];
    	//link�� node�� root �ʱ�ȭ(�ڱ��ȣ)
    	for(int i=1;i<n+1;i++) link[i]=i;
        
    	//�Ѱ��� list�� ���� ���
    	for(int i=0;i<n-1;i++) {
    		List<int[]> list = new ArrayList<int[]>();
        	for(int j=0;j<n-1;j++) {
        		if(i==j) continue;
        		list.add(wires[j]);
        	}
        	//������� ���� ���Ͽ� �ּҰ��� ������ ����
        	answer=Math.min(answer, countNode(link, list));
        }
        return answer;
    }
    
    //=======================�ٸ������ Ǯ��=======================//
    
    //���ܿ������� �ڽ� ��� ��ģ ������ �̿��Ͽ� Ǯ��
    
    static int N;
	static int min;
	static int[][] map;
	static int[] vst;
	static int dfs(int n){
		//�ڽļ� ����, �ڱ� �ڽ� ����
        int child = 1;
        for(int i = 1; i <= N; i++) {
        	//�湮���� �ʰ�, n�� i�� ����Ǿ� �ִٸ�
            if(vst[i] == 0 && map[n][i] == 1) {
            	//i �湮 ���� ǥ��
                vst[i] = 1;
                child += dfs(i); //�ڽİ� ����� �ڽ� ���� ����
            }
        }
        System.out.println("n : "+n+" // child : "+child);
        
        //min�� ���� �� ���� ���� min���� ����
        min = Math.min(min, Math.abs(child - (N - child)));
        return child;
    }
    public static int solution2(int n, int[][] wires) {
        N = n;
        min = n;
        map = new int[n+1][n+1]; //�ε��� �״�� ��� �׷���
        vst = new int[n+1];
        for(int[] wire : wires) {
            int a = wire[0], b = wire[1];
            map[a][b] = map[b][a] = 1;
        }
        dfs(1);
        return min;
    }
    //===================== �ٸ������ Ǯ�� ��=====================//
    
	
	public static void main(String[] args) {
		int n=9;
		int[][] wires={{1,3},{2,3},{3,4},{4,5},{4,6},{4,7},{7,8},{7,9}}; //3
		int n2=4;
		int[][] wires2={{1,2},{2,3},{3,4}}; //0
		int n3=7;
		int[][] wires3={{1,2},{2,7},{3,7},{3,4},{4,5},{6,7}}; //1
		
		System.out.println(solution2(n, wires));
		System.out.println(solution(n2, wires2));
		System.out.println(solution(n3, wires3));
	}
}
