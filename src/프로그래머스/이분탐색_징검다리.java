package ���α׷��ӽ�;

import java.util.Arrays;

public class �̺�Ž��_¡�˴ٸ� {
	/*
	 * ����
	 * ���� ���� ��
	 * �ּ�(1), �ִ� �Ÿ�(distance) ������ ���� ���� ���� mid ����
	 * mid���� �� ������ ���� �ı�
	 * 
	 * �ּҰ� �ִ뺸�� Ŭ������ �ݺ�
	 * 
	 * �� �ı� Ƚ���� n���� �۰ų� ���ٸ�
	 * ��� ���Ͽ� ū���� ���ѵ�
	 * �ּҰ��� mid+1�� �����ϰ� �ݺ�
	 * 
	 * �� �ı� Ƚ���� n���� ũ�ٸ�
	 * �ִ밪�� mid-1�� �����ϰ� �ݺ�
	 * 
	 */
    public static int solution(int distance, int[] rocks, int n) {
        int answer = 0;
        Arrays.sort(rocks);
        //�ּ� �Ÿ� 1, �ִ� �Ÿ� = distance
        int left = 1, right = distance, mid=0;
        
        while(left<=right) {
        	int prev = 0; //���� ��
        	int cnt=0; //Ƚ��
        	//�߰� �Ÿ� ����
        	mid = (left+right)/2;
        	//Ž�� ����
        	for(int rock:rocks) {
        		//���� ���� ���� �� ������ �Ÿ��� �̵庸�� �۴ٸ� �� �ı�(Ƚ�� ����)
        		if(mid>rock-prev) {
        			cnt++;
        		} else {
        			//�ƴ϶�� �������� ����
        			prev = rock;
        		}
        	}
        	//������ ��ҿ� ���� �˻�
        	if(distance-prev <mid) cnt++;
        	
        	//�� �ı� Ƚ���� ������ ���ں��� �۴ٸ�
        	if(cnt<=n) {
        		//left���� mid+1�� ����
        		left = mid+1;
        		//���� mid�� �ִ밪���� ����
        		answer = Math.max(answer, mid);
        	//�� �ı� Ƚ���� n���� ũ�� ���ǿ� ���� �������� right�� ����
        	}else {
        		right = mid-1;
        	}
        }
        
        return answer;
    }
	
	public static void main(String[] args) {
		int d = 25;
		int[] rocks = {2,14,11,21,17};
		int n= 2;
		System.out.println(solution(d, rocks, n));
		
	}

}
