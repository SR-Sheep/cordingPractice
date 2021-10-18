package ���α׷��ӽ�;

import java.util.*;

public class ����_K��°�� {
	/*
	�迭 array�� i��° ���ں��� j��° ���ڱ��� �ڸ��� �������� ��, k��°�� �ִ� ���� ���Ϸ� �մϴ�.

	���� ��� array�� [1, 5, 2, 6, 3, 7, 4], i = 2, j = 5, k = 3�̶��
	
	array�� 2��°���� 5��°���� �ڸ��� [5, 2, 6, 3]�Դϴ�.
	1���� ���� �迭�� �����ϸ� [2, 3, 5, 6]�Դϴ�.
	2���� ���� �迭�� 3��° ���ڴ� 5�Դϴ�.
	�迭 array, [i, j, k]�� ���ҷ� ���� 2���� �迭 commands�� �Ű������� �־��� ��,
	commands�� ��� ���ҿ� ���� �ռ� ������ ������ �������� �� ���� �����
	�迭�� ��� return �ϵ��� solution �Լ��� �ۼ����ּ���.
	
	*���ѻ���
	array�� ���̴� 1 �̻� 100 �����Դϴ�.
	array�� �� ���Ҵ� 1 �̻� 100 �����Դϴ�.
	commands�� ���̴� 1 �̻� 50 �����Դϴ�.
	commands�� �� ���Ҵ� ���̰� 3�Դϴ�.
	 */
	
    public static int[] solution(int[] array, int[][] commands) {
        int[] answer = new int[commands.length];
        int idx=0;
        for(int[] command:commands){
        	//�迭 ����
            int[] tmpArr=Arrays.copyOfRange(array,command[0]-1,command[1]);
            Arrays.sort(tmpArr); //����
            answer[idx++]=tmpArr[command[2]-1]; //�� �ֱ�  
        }
        return answer;
    }
	
	public static void main(String[] args) {
		int[] array = {1, 5, 2, 6, 3, 7, 4};
		int[][] commands= {{2,5,3},{4,4,1},{1,7 ,3}};
		for(int i:solution(array, commands)) System.out.println(i);
		
	}
}
