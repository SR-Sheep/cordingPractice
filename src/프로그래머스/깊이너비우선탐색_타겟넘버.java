package 프로그래머스;

public class 깊이너비우선탐색_타겟넘버 {
	/*
	n개의 음이 아닌 정수가 있습니다. 이 수를 적절히 더하거나 빼서 타겟 넘버를 만들려고 합니다.
	예를 들어 [1, 1, 1, 1, 1]로 숫자 3을 만들려면 다음 다섯 방법을 쓸 수 있습니다.

	-1+1+1+1+1 = 3
	+1-1+1+1+1 = 3
	+1+1-1+1+1 = 3
	+1+1+1-1+1 = 3
	+1+1+1+1-1 = 3
	
	사용할 수 있는 숫자가 담긴 배열 numbers, 타겟 넘버 target이 매개변수로 주어질 때
	숫자를 적절히 더하고 빼서 타겟 넘버를 만드는 방법의 수를 return 하도록 solution 함수를 작성해주세요.

	제한사항
	주어지는 숫자의 개수는 2개 이상 20개 이하입니다.
	각 숫자는 1 이상 50 이하인 자연수입니다.
	타겟 넘버는 1 이상 1000 이하인 자연수입니다.
	*/
	
	public static int countRightNumber(int[] numbers,int target,int idx,int sum) {
		//마지막 idx까지 계산을 마쳤을 때
		if(idx++==numbers.length-1) {
			//타겟과 sum이 같으면 1 증가
			if(sum==target) return 1;
			return 0; //아니면 0
		}
		//재귀하되 idx 증가 및 sum+ 와 sum- 값의 합
		return countRightNumber(numbers,target,idx,sum+numbers[idx])+countRightNumber(numbers,target,idx,sum-numbers[idx]);
		 
	}
		
	public static int solution(int[] numbers, int target) {
		return countRightNumber(numbers,target,-1,0); 
	}
	
	
	public static void main(String[] args) {
		int[] n = {1,1,1,1,1};
		int t = 3;
		System.out.println(solution(n, t));
	}
	
	
}
