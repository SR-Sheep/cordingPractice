package 프로그래머스;

public class 카카오_k진수에서소수개수구하기 {
	//https://programmers.co.kr/learn/courses/30/lessons/92335
    //소수인지 판별
	public static boolean isPrime(long num) {
		if(num<2) return false;
		for(long i=2;i*i<=num;i++) {
			if(num%i==0) {
				return false;
			}
		}
		return true;
	}
	
	public static int solution(int n, int k) {
        int answer = 0;
        //0 이외의 수로 나누기
        String[] tmp = Integer.toString(n, k).split("0+");
        for(String s:tmp) {
        	long i = Long.parseLong(s); //범위 밖의 수가 있으므로 long으로 받음
        	if(isPrime(i)) answer++; //소수이면 답 증가
        }
        return answer;
    }
    
	public static void main(String[] args) {
		int n = 1;
		int k = 2;
		System.out.println(solution(n, k));
	}
}
