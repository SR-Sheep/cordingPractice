package ���α׷��ӽ�;

import java.util.LinkedList;
import java.util.Queue;

public class ��������_���Ӹ��ִܰŸ� {
	/*
	���� ���� ���� maps�� �Ű������� �־��� ��,
	ĳ����(1,1)�� ��� �� ����(n,m)�� �����ϱ� ���ؼ� �������� �ϴ� ĭ�� ������ �ּڰ��� return �ϵ��� solution �Լ��� �ϼ����ּ���.
	��, ��� �� ������ ������ �� ���� ���� -1�� return ���ּ���.

	���ѻ���
	maps�� n x m ũ���� ���� ���� ���°� ����ִ� 2���� �迭��, n�� m�� ���� 1 �̻� 100 ������ �ڿ����Դϴ�.
	n�� m�� ���� ���� ����, �ٸ� ���� ������, n�� m�� ��� 1�� ���� �Է����� �־����� �ʽ��ϴ�.
	maps�� 0�� 1�θ� �̷���� ������, 0�� ���� �ִ� �ڸ�, 1�� ���� ���� �ڸ��� ��Ÿ���ϴ�.
	ó���� ĳ���ʹ� ���� ���� ���� ����� (1, 1) ��ġ�� ������, ���� ������ ���� ���� ���� �ϴ��� (n, m) ��ġ�� �ֽ��ϴ�.
	*/
	//����
    static int[][] D = {{1,0},{-1,0},{0,1},{0,-1}};
    public int solution(int[][] maps) {
        //�湮����
    	boolean[][] visited=new boolean[maps.length][maps[0].length];
        //������� ȸ���� ���� ť
    	Queue<int[]> q = new LinkedList<>();
        //�ʱ� ĳ���� ��ġ�� Ÿ�� �� ť ���� (0,0) , 1��
    	q.add(new int[]{0,0,1});
    	//ť ȸ��
        while(!q.isEmpty()){
            int[] now = q.poll();
            int r = now[0]; //row
            int c = now[1]; //column
            int cnt = now[2]; //Ÿ�� ��
            //������ ������ Ÿ�ϼ� ����
            if(r==maps.length-1&&c==maps[0].length-1) return cnt;
            //�������� �ƴҽ� 4���� Ž��
            for(int i=0;i<4;i++){
                int nr = r+D[i][0]; //���ο� r
                int nc = c+D[i][1]; //���ο� c
                //������ ����� ��Ƽ��
                if(nr<0||nr>=maps.length||nc<0||nc>=maps[0].length) continue;
                //����ġ�� 1�� �ƴϸ� ��Ƽ��
                if(maps[nr][nc]!=1) continue;
                //�湮������ ��Ƽ��
                if(visited[nr][nc]) continue;
                //�湮 ���� ǥ��
                visited[nr][nc]=true;
                //�� ��ġ�� ���� Ÿ�ϼ�+1 ť ���� 
                q.add(new int[] {nr,nc,cnt+1});
            }
            
        }
        //��� Ž�� ��� �������� ���ϸ� -1 ����
        return -1;
    }
}
