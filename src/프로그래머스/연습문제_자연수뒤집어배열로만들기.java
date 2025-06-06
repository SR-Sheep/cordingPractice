package 프로그래머스;

public class 연습문제_자연수뒤집어배열로만들기 {
	
	//https://programmers.co.kr/learn/courses/30/lessons/12932
	
    public static int[] solution(long n) {
    	int size = Long.toString(n).length();
    	int[] answer = new int[size];
        for(int i=0;i<size;i++){
            answer[i] = (int)(n%10);
            n/=10;
        }
        return answer;
    }
	
	public static void main(String[] args) {
		long n = 12345;
		System.out.println(solution(n));
	}
}
