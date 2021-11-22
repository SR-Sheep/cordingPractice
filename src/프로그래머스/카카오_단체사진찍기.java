package ���α׷��ӽ�;

import java.util.ArrayList;

public class īī��_��ü������� {
	/*
	������ �¾� īī��������� ��ü�� ��ǳ�� ������.
	��ſ� �ð��� ������ �������� ��ü������ ��� ���� ī�޶� �տ� �Ϸķ� ������ ����.
	�׷��� ���ڰ� ���ϴ� ��ġ�� ��� �޶� � ������ ���� ���ϴµ� �ð��� ���� �ɷȴ�.
	�׿��� ���ε��� ������ ���⸦ ���߰�,
	Ʃ�갡 ���� ���� ���� ���� �ִ� ���̾��� Ʃ�꿡�Լ� ��� �� ĭ �̻� �������� ���⸦ ���ߴ�.
	������ ��� ���� ���ƿ��� �濡, ������ ��ΰ� ���ϴ� ������ �����ϸ鼭�� �ٸ��� ���� ����� ���� �ʾ����� �����غ��� �Ǿ���.
	�� ����� ���ϴ� ������ �Է����� �޾��� �� ��� ������ ������ �� �ֵ��� ���� ����� ���� ����ϴ� ���α׷��� �ۼ��غ���.

	�Է� ����
	�Է��� ������ ������ ��Ÿ���� ���� n�� n���� ���ҷ� ������ ���ڿ� �迭 data�� �־�����.
	data�� ���Ҵ� �� ����� ���ϴ� ������ N~F=0�� ���� ������ ���ڿ��� �����Ǿ� �ִ�. ���������� �Ʒ��� ����.

	1 <= n <= 100
	data�� ���Ҵ� �ټ� ���ڷ� ������ ���ڿ��̴�. �� ������ ������ ������ ����.
	ù ��° ���ڿ� �� ��° ���ڴ� ���� 8�� �� �ϳ��̴�.
	{A, C, F, J, M, N, R, T} ���� ����ġ, ��, ���ε�, ������, ����, �׿�, ���̾�, Ʃ�긦 �ǹ��Ѵ�.
	ù ��° ���ڴ� ������ ������ ������, �� ��° ���ڴ� �����̴�. ù ��° ���ڿ� �� ��° ���ڴ� �׻� �ٸ���.
	�� ��° ���ڴ� �׻� ~�̴�.
	�� ��° ���ڴ� ���� 3�� �� �ϳ��̴�. {=, <, >} ���� ����, �̸�, �ʰ��� �ǹ��Ѵ�.
	�ټ� ��° ���ڴ� 0 �̻� 6 ������ ������ �������̸�, ���ǿ� ���õǴ� ������ �ǹ��Ѵ�. �̶� ������ �� ������ ���̿� �ִ� �ٸ� �������� ���̴�.
	*/
	static boolean[] Visited;
	static int N, Answer;
	static ArrayList<int[]> Conditions;
	
	public static void isOk(String s) {
		boolean pass=true;
		for(int[] condition:Conditions) {
			if(!pass) break;
			int a=condition[0]; //�� 1
			int b=condition[1]; //�� 2
			int sign = condition[2]; //��ȣ
			int num = condition[3]; //�Ÿ�
			
			int aIdx=-1, bIdx=-1;
			for(int i=0;i<8;i++) {
				if(a==s.charAt(i)-'0') aIdx=i; //�� 1�� idx
				else if(b==s.charAt(i)-'0') bIdx=i; //�� 2�� idx
			}
			int interval =Math.abs(aIdx-bIdx)-1; //�� 1�� 2�� �Ÿ�
			//=
			if(sign==61) {
				if(interval!=num) pass=false; //�Ÿ��� num�� ���� ������ false ����
			//<	
			}else if(sign==60) {
				if(interval>=num) pass=false; //�Ÿ��� num �̻��̸� false ����
			//>	
			}else if(sign==62) {
				if(interval<=num) pass=false; //�Ÿ��� num �����̸� false ����
			}
		}
		if(pass) Answer++; //����� �� ����
	}
	
	//���� ����
	public static void permutation(String s) {
		//������ ���̰� 8
		if(s.length()==8) {
			isOk(s);
			return;
		} 
		for(int i=0;i<8;i++) {
			if(!Visited[i]) {
				Visited[i]=true;
				permutation(s+i);
				Visited[i]=false;
			}
		}
		return;
	}
	
    public static int solution(int n, String[] data) {
    	char[] friends= {'A', 'C', 'F', 'J', 'M', 'N', 'R', 'T'};
    	Visited=new boolean[8];
    	Answer=0;
    	Conditions=new ArrayList<>();
        for(String d:data) {
        	int a=-1,b=-1;
        	int sign=d.charAt(3)+0; //��ȣ
        	int num=d.charAt(4)-'0'; //����
        	//������ �迭 Ž���Ͽ� ���ڷ� ��ȯ
        	for(int i=0;i<8;i++) {
        		char friend =friends[i];
        		if(friend==d.charAt(0)) a=i; //ù��° ģ��
        		else if(friend==d.charAt(2)) b=i; //�ι�° ģ��
        	}
        	Conditions.add(new int[] {a,b,sign,num}); //��ȯ�Ͽ� ��ȣ1, ��ȣ2, ��ȣ, ���� �Է�
        }
        permutation("");
        return Answer;
    }
	public static void main(String[] args) {
		int n=2;
		String[] data = {"N~F=0", "R~T>2"};
//		String[] data = {"M~C<2", "C~M>1"};
		System.out.println(solution(n, data));
	}

}
