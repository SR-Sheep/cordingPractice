package 프로그래머스;

public class 코드챌린지3_n2배열자르기 {
	/*
	https://programmers.co.kr/learn/courses/30/lessons/87390
	
	정수 n, left, right가 주어집니다. 다음 과정을 거쳐서 1차원 배열을 만들고자 합니다.

	n행 n열 크기의 비어있는 2차원 배열을 만듭니다.
	i = 1, 2, 3, ..., n에 대해서, 다음 과정을 반복합니다.
	1행 1열부터 i행 i열까지의 영역 내의 모든 빈 칸을 숫자 i로 채웁니다.
	1행, 2행, ..., n행을 잘라내어 모두 이어붙인 새로운 1차원 배열을 만듭니다.
	새로운 1차원 배열을 arr이라 할 때, arr[left], arr[left+1], ..., arr[right]만 남기고 나머지는 지웁니다.
	정수 n, left, right가 매개변수로 주어집니다. 주어진 과정대로 만들어진 1차원 배열을 return 하도록 solution 함수를 완성해주세요.

	제한사항
	1 ≤ n ≤ 107
	0 ≤ left ≤ right < n2
	right - left < 105
	*/
	
    public static int[] solution(int n, long left, long right) {
        int[] answer = new int[(int)(right-left+1)];
        int idx=0;
        for(long i=left;i<=right;i++){
            int r = (int)(i/n)+1; //행
            int c = (int)(i%n)+1; //열
        	answer[idx++]=r<c?c:r; //열이 행보다 크면 행 출력, 아닐시 열 출력
        }
        return answer;
    }
	
	public static void main(String[] args) {
		int n=3;
		long left = 2,right=5;
		for(int i :solution(n, left, right)) {
			System.out.print(i+" ");
		};
	}
}
