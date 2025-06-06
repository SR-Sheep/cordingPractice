package 프로그래머스;

public class 연습문제_하샤드수 {
	
	//https://programmers.co.kr/learn/courses/30/lessons/12947
	//자릿수의 숫자를 모두 더한 수로 나눠지면 하샤드수
	
    public static boolean solution(int x) {
        int sum = 0;
        int n=x;
        while(n>0){
            sum+=n%10;
            n/=10;
        }
        return x%sum==0;
    }
	
	public static void main(String[] args) {
		int x = 10;
		System.out.println(solution(x));
	}
}
