package ���α׷��ӽ�;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class �ڵ�ç����1_�ΰ��̾ƴ��ϱ� {
	/*
	���� ����
	���� �迭 numbers�� �־����ϴ�. numbers���� ���� �ٸ� �ε����� �ִ� �� ���� ���� �̾�
	���ؼ� ���� �� �ִ� ��� ���� �迭�� ������������ ��� return �ϵ��� solution �Լ��� �ϼ����ּ���.

	���ѻ���
	numbers�� ���̴� 2 �̻� 100 �����Դϴ�.
	numbers�� ��� ���� 0 �̻� 100 �����Դϴ�.
	*/
    public static int[] solution(int[] numbers) {
    	//�ߺ��� �����ϱ� ���� set ����
        Set<Integer> set = new HashSet<Integer>();
        //2�� �� �̾Ƽ� ���ϱ�
        for(int i=0;i<numbers.length-1;i++) {
        	for(int j=i+1;j<numbers.length;j++) {
        		set.add(numbers[i]+numbers[j]);
        	}
        }
        //���� ������ answer �迭 ����
        int[] answer = new int[set.size()];
        //�� �ε��� ����
        int idx=0;
        //answer �迭�� set �Է�
        for(Integer num:set) answer[idx++]=num;
        //����
        Arrays.sort(answer);
        return answer;
    }
	public static void main(String[] args) {
		int[] numbers= {2,1,3,4,1};
		for(int i:solution(numbers)) System.out.println(i);
	}

}
