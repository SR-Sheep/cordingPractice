package ���α׷��ӽ�;

import java.util.HashSet;

public class �������_�Ҽ������ {
	/*
	���� ����
	�־��� ���� �� 3���� ���� ������ �� �Ҽ��� �Ǵ� ����� ������ ���Ϸ��� �մϴ�.
	���ڵ��� ����ִ� �迭 nums�� �Ű������� �־��� ��,
	nums�� �ִ� ���ڵ� �� ���� �ٸ� 3���� ��� ������ �� �Ҽ��� �Ǵ� ����� ������ return �ϵ��� solution �Լ��� �ϼ����ּ���.

	���ѻ���
	nums�� ����ִ� ������ ������ 3�� �̻� 50�� �����Դϴ�.
	nums�� �� ���Ҵ� 1 �̻� 1,000 ������ �ڿ����̸�, �ߺ��� ���ڰ� ������� �ʽ��ϴ�.
	*/
	
	public static boolean isPrime(int n){
        if(n%2==0) return false;
        for(int i=3;i*i<=n;i+=2){
            if(n%i==0) return false;
        }
        return true;
    }
    
    public static int solution(int[] nums) {
        int answer=0;
        HashSet<Integer> set = new HashSet<>();
        for(int i=0;i<nums.length-2;i++){
            for(int j=i+1;j<nums.length-1;j++){
                for(int k=j+1;k<nums.length;k++){
                    if(isPrime(nums[i]+nums[j]+nums[k])) answer++;
                }
            }
        }
        return answer;
    }
    
    public static void main(String[] args) {
		int[] nums= {1,2,3,4}; //1
		System.out.println(solution(nums));
	}
}
