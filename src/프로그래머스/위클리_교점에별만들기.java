package ���α׷��ӽ�;

import java.util.ArrayList;
import java.util.List;

public class ��Ŭ��_������������� {
	/*
	Ax + By + C = 0���� ǥ���� �� �ִ� n���� ������ �־��� ��,
	�� ������ ���� �� ���� ��ǥ�� ���� �׸��� �մϴ�.
	���� A, B, C�� ���� ������ ��� �迭 line�� �Ű������� �־����ϴ�.
	�̶� ��� ���� �����ϴ� �ּ� �簢���� return �ϵ��� solution �Լ��� �ϼ����ּ���.

	���ѻ���
	line�� ����(��) ���̴� 2 �̻� 1,000 ������ �ڿ����Դϴ�.
	line�� ����(��) ���̴� 3�Դϴ�.
	line�� �� ���Ҵ� [A, B, C] �����Դϴ�.
	A, B, C�� -100,000 �̻� 100,000 ������ �����Դϴ�.
	������ ���� ������ ����� ���� ���� �־����� �ʽ��ϴ�.
	A = 0�̸鼭 B = 0�� ���� �־����� �ʽ��ϴ�.
	������ 1,000 * 1,000 ũ�� �̳����� ǥ���˴ϴ�.
	���� �� �� �̻� �׷����� �Է¸� �־����ϴ�.
	*/
	//���� ���� list
	static List<Long[]> Stars;
	//x y�� �ּ� �ִ밪
	static Long XMin,XMax,YMin,YMax;
	
	//���� ���ϱ�
	public static void meetPoint(int[] m, int[] n) {
		long a=m[0], b=m[1], e=m[2];
		long c=n[0], d=n[1], f=n[2];
		
		double gradient =a*d-b*c;
		if(gradient==0) return;
		
		double x = (b*f-e*d)/gradient;
		double y = (e*c-a*f)/gradient;
		//���Ⱑ 0�̸� ����
		if(x-(long)x!=0||y-(long)y!=0) return;
		//x �ִ� �ּ�, y �ִ� �ּ� ����
		XMin=Math.min(XMin,(long)x);
		XMax=Math.max(XMax, (long)x);
		YMin=Math.min(YMin,(long)y);
		YMax=Math.max(YMax, (long)y);
		//����Ʈ�� ��ǥ�� �߰�
		Stars.add(new Long[] {(long)x,(long)y});
	}
	
    public static String[] solution(int[][] line) {
        Stars=new ArrayList<>();
        XMin=YMin=Long.MAX_VALUE;
        XMax=YMax=Long.MIN_VALUE;
        //��ǥ�� �ֱ�
        for(int i=0;i<line.length-1;i++) {
        	for(int j=i+1;j<line.length;j++) {
        		meetPoint(line[i], line[j]);
        	}
        }
        //y�� ����(row)
        int ylength=(int)(YMax-YMin+1);
        //x�� ����(col)
        int xlength=(int)(XMax-XMin+1);
        //���� ������� �ӽ� 2�� �迭 ����
        String[][] tmp = new String[ylength][xlength];
        //���� ���� 1�� �迭 ����
        String[] answer = new String[ylength];
        //�ӽ� �迭 .���� ä���
        for(int y=0;y<YMax-YMin+1;y++) {
        	for(int x=0;x<XMax-XMin+1;x++) {
        		tmp[y][x]=".";
        	}
        }
        //�ش� ��ǥ���� * �ֱ�
        for(Long[] star:Stars) {
        	int yidx =(int)(-YMin+star[1]);
        	int xidx=(int)(-XMin+star[0]);
        	tmp[yidx][xidx]="*";
        }
        //�ش� ��ǥ���� �������� ����
        for(int i=0;i<YMax-YMin+1;i++) {
        	StringBuilder sb = new StringBuilder();
        	for(String s:tmp[ylength-1-i]) {
        		sb.append(s);
        	}
        	answer[i]=sb.toString();
        }
        return answer;
    }
    
	public static void main(String[] args) {
		int[][] line = {{2, -1, 4}, {-2, -1, 4}, {0, -1, 1}, {5, -8, -12}, {5, 8, 12}};
		for(String s:solution(line)) {
			System.out.println(s);
		};
	}

}
