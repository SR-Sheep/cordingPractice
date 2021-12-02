package 프로그래머스;

public class 연습문제_행렬의덧셈 {
    //https://programmers.co.kr/learn/courses/30/lessons/12950
	public static int[][] solution(int[][] arr1, int[][] arr2) {
        for(int i=0;i<arr1.length;i++){
            for(int j=0;j<arr1[i].length;j++){
                arr1[i][j]+=arr2[i][j];
            }
        }
        return arr1;
    }
	
	public static void main(String[] args) {
		int[][] arr1= {{1,2},{2,3}};
		int[][] arr2= {{3,4},{5,6}};
		for(int[] arr:solution(arr1, arr2)) {
			for(int i:arr) System.out.print(i+" ");
			System.out.println();
		}
	}
}
