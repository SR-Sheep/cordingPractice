package ���α׷��ӽ�;

public class ��Ŭ��_�Ƿε� {
	/*
	XX���ӿ��� �Ƿε� �ý���(0 �̻��� ������ ǥ���մϴ�)�� ������,
	���� �Ƿε��� ����ؼ� ������ Ž���� �� �ֽ��ϴ�.
	�̶�, �� �������� Ž���� �����ϱ� ���� �ʿ��� "�ּ� �ʿ� �Ƿε�"�� ���� Ž���� ������ �� �Ҹ�Ǵ� "�Ҹ� �Ƿε�"�� �ֽ��ϴ�.
	"�ּ� �ʿ� �Ƿε�"�� �ش� ������ Ž���ϱ� ���� ������ �־�� �ϴ� �ּ����� �Ƿε��� ��Ÿ����,
	"�Ҹ� �Ƿε�"�� ������ Ž���� �� �Ҹ�Ǵ� �Ƿε��� ��Ÿ���ϴ�. ���� ��� "�ּ� �ʿ� �Ƿε�"�� 80,
	"�Ҹ� �Ƿε�"�� 20�� ������ Ž���ϱ� ���ؼ��� ������ ���� ���� �Ƿε��� 80 �̻� �̾�� �ϸ�,
	������ Ž���� �Ŀ��� �Ƿε� 20�� �Ҹ�˴ϴ�.

	�� ���ӿ��� �Ϸ翡 �� ���� Ž���� �� �ִ� ������ ������ �ִµ�,
	�� ������ ���� �� �������� �ִ��� ���� Ž���Ϸ� �մϴ�.
	������ ���� �Ƿε� k�� �� ������ "�ּ� �ʿ� �Ƿε�", "�Ҹ� �Ƿε�"�� ��� 2���� �迭 dungeons �� �Ű������� �־��� ��,
	������ Ž���Ҽ� �ִ� �ִ� ���� ���� return �ϵ��� solution �Լ��� �ϼ����ּ���.

	���ѻ���
	k�� 1 �̻� 5,000 ������ �ڿ����Դϴ�.
	dungeons�� ����(��) ����(��, ������ ����)�� 1 �̻� 8 �����Դϴ�.
	dungeons�� ����(��) ���̴� 2 �Դϴ�.
	dungeons�� �� ���� �� ������ ["�ּ� �ʿ� �Ƿε�", "�Ҹ� �Ƿε�"] �Դϴ�.
	"�ּ� �ʿ� �Ƿε�"�� �׻� "�Ҹ� �Ƿε�"���� ũ�ų� �����ϴ�.
	"�ּ� �ʿ� �Ƿε�"�� "�Ҹ� �Ƿε�"�� 1 �̻� 1,000 ������ �ڿ����Դϴ�.
	���� �ٸ� ������ ["�ּ� �ʿ� �Ƿε�", "�Ҹ� �Ƿε�"]�� ���� ���� �� �ֽ��ϴ�.
	*/
	
	static boolean[] Visited;
	static int[][] Dungeons;
	
	public static int dfs(int k) {
		int answer=0;
		for(int i=0;i<Dungeons.length;i++) {
			int tmp=0;
			int patigue = adv(k,Dungeons[i]); //Ž���� ������ �� �Ƿε�
			if(patigue<0) continue; //�Ƿε��� ������ �� pass
			if(Visited[i]) continue; //�湮 ���� �� pass
			Visited[i]=true; //�湮���� üũ
			tmp+=1+dfs(patigue); //1 ���� �� k�� ���� �Ƿε��� �����Ͽ� ���
			Visited[i]=false;//�湮���� ȸ��
			answer=Math.max(answer, tmp); //��갪�� �� �� ū���� ����
		}
		return answer;
	}
	//Ž�� ���� �� ���� �Ƿε� - �Ҹ� �Ƿε� ����, �Ұ��� -1 ����
	public static int adv(int k, int[] dungeon) {
		if(k>=dungeon[0]) {
			return k-dungeon[1];
		}
		return -1;
		
	}
	
	//���� �ڵ带 ������
	public static int dfsZip(int k) {
		int answer=0;
		for(int i=0;i<Dungeons.length;i++) {
			if(adv(k,Dungeons[i])<0) continue; //�Ƿε��� ������ �� pass
			if(!Visited[i]&&k>=Dungeons[i][0]){
				Visited[i]=true; //�湮���� üũ
				answer=Math.max(answer, 1+dfs(k-Dungeons[i][1])); //��갪�� �� �� ū���� ����
				Visited[i]=false;//�湮���� ȸ��
			}//�湮 ���� �� pass
		}
		return answer;
	}
	
	public static int solution(int k, int[][] dungeons) {
        Visited=new boolean[dungeons.length];
        Dungeons=dungeons;
        return dfs(k);
    }
    
	public static void main(String[] args) {
		int[][] d = {{80,20},{50,40},{30,10}};
		int k =80;
		System.out.println(solution(k, d));
	}
}
