package ���α׷��ӽ�;
import java.util.*;

public class �̺�Ž��_�Ա��ɻ� {
	//�ð��� ������� �˻�
    public static boolean isEnoughTime(long n,int[] times,long mid ) {
		long cnt=0;
		// mid/time : mid�ð����� ������ ���� �� �ִ���?
		for(long time:times) cnt+=mid/time;
		// n���� ���� �� ���ٸ� false
		if(n>cnt)return false;
		//n���� ���� �����ϴٸ� true
		else return true;
	}
    public static long solution(long n, int[] times) {
        //���� �ִ� �ð����� ����
    	long answer=Long.MAX_VALUE;
        //�迭 ����
        Arrays.sort(times);
        //�ּ� = 1�� 1��, �ִ� = ����� * �ִ� �ɸ��� �ð�
		long start=1,end=n*times[times.length-1],mid=0;
		
		while(start<=end) {
			//�߰��� ����
			mid=(start+end)/2;
			//���ѽð��� mid�� �������� ��, ��� ������ �����ϸ�
			if(isEnoughTime(n, times, mid)) {
				//�ּҰ��� ��, �̰��� ���� ������ �ּҰ�
				answer=mid;
				//������ �����ϹǷ� �ִ밪�� ����(mid ����)
				end=mid-1;
			//���� �Ұ��� �ּҰ��� �ø� (mid ����)
			}else start=mid+1;	
		}
		return answer;
    }
    
    public static void main(String[] args) {
		int[] times = {7,10};
		int n= 6;
		System.out.println(solution(n, times));	
	}

}
