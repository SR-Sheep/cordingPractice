package ���α׷��ӽ�;

public class ��������_�ڿ���������迭�θ���� {
	
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
