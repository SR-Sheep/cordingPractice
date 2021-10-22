package ���α׷��ӽ�;

import java.util.HashMap;

public class ���̳ʺ�켱Ž��_Ÿ�ٳѹ� {
	/*
	n���� ���� �ƴ� ������ �ֽ��ϴ�. �� ���� ������ ���ϰų� ���� Ÿ�� �ѹ��� ������� �մϴ�.
	���� ��� [1, 1, 1, 1, 1]�� ���� 3�� ������� ���� �ټ� ����� �� �� �ֽ��ϴ�.

	-1+1+1+1+1 = 3
	+1-1+1+1+1 = 3
	+1+1-1+1+1 = 3
	+1+1+1-1+1 = 3
	+1+1+1+1-1 = 3
	
	����� �� �ִ� ���ڰ� ��� �迭 numbers, Ÿ�� �ѹ� target�� �Ű������� �־��� ��
	���ڸ� ������ ���ϰ� ���� Ÿ�� �ѹ��� ����� ����� ���� return �ϵ��� solution �Լ��� �ۼ����ּ���.

	���ѻ���
	�־����� ������ ������ 2�� �̻� 20�� �����Դϴ�.
	�� ���ڴ� 1 �̻� 50 ������ �ڿ����Դϴ�.
	Ÿ�� �ѹ��� 1 �̻� 1000 ������ �ڿ����Դϴ�.
	*/
	
	public static int countRightNumber(int[] numbers,int target,int idx,int sum) {
		//������ idx���� ����� ������ ��
		if(idx++==numbers.length-1) {
			//Ÿ�ٰ� sum�� ������ 1 ����
			if(sum==target) return 1;
			return 0; //�ƴϸ� 0
		}
		//����ϵ� idx ���� �� sum+ �� sum- ���� ��
		return countRightNumber(numbers,target,idx,sum+numbers[idx])+countRightNumber(numbers,target,idx,sum-numbers[idx]);
		 
	}
		
	public static int solution(int[] numbers, int target) {
		return countRightNumber(numbers,target,-1,0); 
	}
	
	
	public static void main(String[] args) {
		int[] n = {1,1,1,1,1};
		int t = 3;
		System.out.println(solution(n, t));
	}
	
	
}
