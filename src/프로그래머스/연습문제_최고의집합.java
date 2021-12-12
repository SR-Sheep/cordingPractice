package 프로그래머스;

public class 연습문제_최고의집합 {
	/*
	https://programmers.co.kr/learn/courses/30/lessons/12938
	
	자연수 n 개로 이루어진 중복 집합(multi set, 편의상 이후에는 "집합"으로 통칭) 중에 다음 두 조건을 만족하는 집합을 최고의 집합이라고 합니다.

	각 원소의 합이 S가 되는 수의 집합
	위 조건을 만족하면서 각 원소의 곱 이 최대가 되는 집합
	예를 들어서 자연수 2개로 이루어진 집합 중 합이 9가 되는 집합은 다음과 같이 4개가 있습니다.
	{ 1, 8 }, { 2, 7 }, { 3, 6 }, { 4, 5 }
	그중 각 원소의 곱이 최대인 { 4, 5 }가 최고의 집합입니다.

	집합의 원소의 개수 n과 모든 원소들의 합 s가 매개변수로 주어질 때,
	최고의 집합을 return 하는 solution 함수를 완성해주세요.

	제한사항
	최고의 집합은 오름차순으로 정렬된 1차원 배열(list, vector) 로 return 해주세요.
	만약 최고의 집합이 존재하지 않는 경우에 크기가 1인 1차원 배열(list, vector) 에 -1 을 채워서 return 해주세요.
	자연수의 개수 n은 1 이상 10,000 이하의 자연수입니다.
	모든 원소들의 합 s는 1 이상, 100,000,000 이하의 자연수입니다.
	
	*/
	
	/*
	 * 전략
	 * 
	 * 곱의 최대값 = 평균 근처의 수로만 이루어짐(총 2개의 수, s/n, s/n+1)
	 * 
	 * 모든 수를 s/n으로 채움
	 * s와 s/n * n 의 차 만큼의 수를 s/n +1로 채움
	 */
    public static int[] solution(int n, int s) {
        if(s/n==0) return new int[] {-1};
         int[] answer = new int[n];
         int num = s/n; //평균
         int sum = num*n; //평균 * n
         int diff = s-sum; //s - 평균*n의 차이
         //차이 만큼의 수를 빼고 평균으로 채움(오름차순) 
         for(int i=0;i<n-diff;i++){
             answer[i]=num;
         }
         num++; //1증가
         //뒤에서 차이만큼의 수를 평균 + 1 만큼 채움
         for(int i=n-diff;i<n;i++){
             answer[i]=num;
         }
         return answer;
     }
    
    public static void main(String[] args) {
		int n = 2;
		int s = 9;
		for(int i:solution(n, s)) System.out.print(i+" "); //4 5
		System.out.println();
	}
}
