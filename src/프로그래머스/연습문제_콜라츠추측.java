package 프로그래머스;

public class 연습문제_콜라츠추측 {
	/*
	https://programmers.co.kr/learn/courses/30/lessons/12943
	
	문제 설명
	1937년 Collatz란 사람에 의해 제기된 이 추측은, 주어진 수가 1이 될때까지 다음 작업을 반복하면, 모든 수를 1로 만들 수 있다는 추측입니다. 작업은 다음과 같습니다.

	1-1. 입력된 수가 짝수라면 2로 나눕니다. 
	1-2. 입력된 수가 홀수라면 3을 곱하고 1을 더합니다.
	2. 결과로 나온 수에 같은 작업을 1이 될 때까지 반복합니다.
	*/
	
    public static int solution(int num) {
        int answer = 0;
        long n = (long)num;
        while(answer<=500&&n!=1){
            if(n%2==0) n/=2;
            else n=3*n+1;
            answer++;
        }
        return answer>500?-1:answer;
    }
    
    public static void main(String[] args) {
		int[] nn = {6,16,626331}; //8,4,-1
		for(int n:nn) System.out.println(solution(n));
	}
}
