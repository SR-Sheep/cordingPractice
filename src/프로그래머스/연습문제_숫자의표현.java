package 프로그래머스;

public class 연습문제_숫자의표현 {
	//https://programmers.co.kr/learn/courses/30/lessons/12924
	//자연수 n이 매개변수로 주어질 때, 연속된 자연수들로 n을 표현하는 방법의 수를 return하는 solution를 완성해주세요.
	
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
