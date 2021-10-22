package ���α׷��ӽ�;

public class ������ȹ��_�����ﰢ�� {
	
	public static long solution(int[][] triangle) {
		//���ܿ��� n�� n+1 �� �� ū ���� ���ѵ� ���� �ܰ迡 ��ħ
		//(������-1)������ �ֻ��� ������
		for(int floor=triangle.length-2;floor>=0;floor--) {
			//�� ���� ���� = floor+1
			for(int i=0;i<floor+1;i++) {
				triangle[floor][i]+=Math.max(triangle[floor+1][i],triangle[floor+1][i+1]);
			}
		}
		//root���� �ݺ� �� ���
        return triangle[0][0];
    }
	
	
	public static void main(String[] args) {
		int[][] tri = {{7}, {3, 8}, {8, 1, 0}, {2, 7, 4, 4}, {4, 5, 2, 6, 5}}; //30
		System.out.println(solution(tri));
	}
}
