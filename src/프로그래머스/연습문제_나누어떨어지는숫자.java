package ���α׷��ӽ�;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ��������_����������¼��� {
	/*https://programmers.co.kr/learn/courses/30/lessons/12910
	���� ����
	array�� �� element �� divisor�� ������ �������� ���� ������������ ������ �迭�� ��ȯ�ϴ� �Լ�, solution�� �ۼ����ּ���.
	divisor�� ������ �������� element�� �ϳ��� ���ٸ� �迭�� -1�� ��� ��ȯ�ϼ���.

	���ѻ���
	arr�� �ڿ����� ���� �迭�Դϴ�.
	���� i, j�� ���� i �� j �̸� arr[i] �� arr[j] �Դϴ�.
	divisor�� �ڿ����Դϴ�.
	array�� ���� 1 �̻��� �迭�Դϴ�.
	*/
	
    public static List<Integer> solution(int[] arr, int divisor) {
        List<Integer> list = new ArrayList<>();
        Arrays.sort(arr);
        for(int i:arr){
            if(i%divisor==0) list.add(i);
        }
        if(list.isEmpty()) list.add(-1);
        return list;
    }
    
    
}
