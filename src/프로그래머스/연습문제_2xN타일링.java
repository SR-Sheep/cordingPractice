package 프로그래머스;

public class 연습문제_2xN타일링 {
	//https://programmers.co.kr/learn/courses/30/lessons/12900
	
    public static int solution(int n) {
        final int DIV = 1000000007;
        long[] dp = new long[n+1];
        dp[1]=1;
        dp[2]=2;
        for(int i=3;i<=n;i++){
            dp[i]+=dp[i-1]%DIV;
            dp[i]+=(dp[i-2])%DIV;
            dp[i]%=DIV;
            //System.out.println(dp[i]);
        }
        
        return (int)dp[n];
    }
    
	public static void main(String[] args) {
		int n = 4;
		System.out.println(solution(n));
		
	}
}
