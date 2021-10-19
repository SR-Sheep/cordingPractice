package ���α׷��ӽ�;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class ����_HIndex {
	
	/*
	H-Index�� �������� ���꼺�� ������� ��Ÿ���� ��ǥ�Դϴ�. ��� �������� H-Index�� ��Ÿ���� ���� h�� ���Ϸ��� �մϴ�. ��Ű���1�� ������, H-Index�� ������ ���� ���մϴ�.

	� �����ڰ� ��ǥ�� �� n�� ��, h�� �̻� �ο�� ���� h�� �̻��̰� ������ ���� h�� ���� �ο�Ǿ��ٸ� h�� �ִ��� �� �������� H-Index�Դϴ�.
	
	� �����ڰ� ��ǥ�� ���� �ο� Ƚ���� ���� �迭 citations�� �Ű������� �־��� ��, �� �������� H-Index�� return �ϵ��� solution �Լ��� �ۼ����ּ���.
	
	���ѻ���
	
	�����ڰ� ��ǥ�� ���� ���� 1�� �̻� 1,000�� �����Դϴ�.
	���� �ο� Ƚ���� 0ȸ �̻� 10,000ȸ �����Դϴ�.
	 */
	
    public static int solution(int[] citations) {
        int n=citations.length;
        Arrays.sort(citations); //����
        for(int i=0;i<n;i++) {
        	//�ο���� �� ���� �ο�� ���� ������ ���ų� ���ٸ� ���� ���� ����
            if(citations[i] >=n-i) return n - i;
        }
        return 0;
    }
    
	public static void main(String[] args) {
		int[] c = {3, 0, 6, 1, 5};
		int[] c1 = {1, 2, 7, 4, 5,11,0};
		System.out.println(solution(c));
	}
	
	
	
	
	
	
	

}
