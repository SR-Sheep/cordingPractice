package 프로그래머스;

public class 동적계획법_정수삼각형 {
	
	public static long solution(int[][] triangle) {
		//말단에서 n과 n+1 중 더 큰 값을 취한뒤 상위 단계에 합침
		//(마지막-1)층부터 최상위 층까지
		for(int floor=triangle.length-2;floor>=0;floor--) {
			//각 층의 길이 = floor+1
			for(int i=0;i<floor+1;i++) {
				triangle[floor][i]+=Math.max(triangle[floor+1][i],triangle[floor+1][i+1]);
			}
		}
		//root까지 반복 후 출력
        return triangle[0][0];
    }
	
	
	public static void main(String[] args) {
		int[][] tri = {{7}, {3, 8}, {8, 1, 0}, {2, 7, 4, 4}, {4, 5, 2, 6, 5}}; //30
		System.out.println(solution(tri));
	}
}
