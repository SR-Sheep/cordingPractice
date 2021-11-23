package 프로그래머스;

public class 연습문제_두정수사이의합 {
	//https://programmers.co.kr/learn/courses/30/lessons/12912
	//두 수 사이의 모든 수를 더한 값을 리턴
	
    public static long solution(int a, int b) {
        long num1 = a;
        long num2 = b;
        if(a>b){
            num1=b;
            num2=a;
        }
        if(num1==num2) return num1;
        return (num2*(num2+1)/2)-(num1*(num1+1)/2)+num1;
    }
    
    public static void main(String[] args) {
		int a= 3, b=5;
		System.out.println(solution(a, b));
	}

}
