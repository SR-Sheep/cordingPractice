package ���α׷��ӽ�;

public class ��������_������ǥ�� {
	//https://programmers.co.kr/learn/courses/30/lessons/12924
	//�ڿ��� n�� �Ű������� �־��� ��, ���ӵ� �ڿ������ n�� ǥ���ϴ� ����� ���� return�ϴ� solution�� �ϼ����ּ���.
	
    public static int solution(int n) {
        int answer = 0;
        for(int i=1;i<=n;i++){
            int sum=0;
            for(int j=i;j<=n;j++){
                sum+=j;
                if(sum>=n) break;
            }
            if(sum==n) answer++;
        }
        return answer;
    }
	
	public static void main(String[] args) {
		int n=15;
		System.out.println(solution(n));
	}
}
