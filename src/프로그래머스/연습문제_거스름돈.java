package 프로그래머스;

public class 연습문제_거스름돈 {
	//https://programmers.co.kr/learn/courses/30/lessons/12907
	
    public static int solution(int n, int[] money) {
        int[] dp = new int[n+1];
        for(int m : money){
            dp[m]++;
            for(int i=0;i<=n;i++){
                if(i-m>0){
                    dp[i]+=dp[i-m];
                }
            }
        }
        return dp[n];
    }
	
	public static void main(String[] args) {
		int n=5;
		int[] money = {1,2,5};
		System.out.println(solution(n, money)); //4
	}
}
