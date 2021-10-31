package 프로그래머스;


public class 코드챌린지1_스타수열 {
	/*
	문제 설명
	다음과 같은 것들을 정의합니다.

	어떤 수열 x의 부분 수열(Subsequence)이란,
	x의 몇몇 원소들을 제거하거나 그러지 않고 남은 원소들이 원래 순서를 유지하여 얻을 수 있는 새로운 수열을 말합니다.

	예를 들어, [1,3]은 [1,2,3,4,5]의 부분수열입니다. 원래 수열에서 2, 4, 5를 제거해서 얻을 수 있기 때문입니다.
	다음과 같은 조건을 모두 만족하는 수열 x를 스타 수열이라고 정의합니다.

	x의 길이가 2 이상의 짝수입니다. (빈 수열은 허용되지 않습니다.)
	x의 길이를 2n이라 할 때, 다음과 같은 n개의 집합 {x[0], x[1]}, {x[2], x[3]}, ..., {x[2n-2], x[2n-1]} 의 교집합의 원소의 개수가 1 이상입니다.
	x[0] != x[1], x[2] != x[3], ..., x[2n-2] != x[2n-1] 입니다.
	예를 들어, [1,2,1,3,4,1,1,3]은 스타 수열입니다. {1,2}, {1,3}, {4,1}, {1,3} 의 교집합은 {1} 이고, 각 집합 내의 숫자들이 서로 다르기 때문입니다.
	
	1차원 정수 배열 a가 매개변수로 주어집니다.
	a의 모든 부분 수열 중에서 가장 길이가 긴 스타 수열의 길이를 return 하도록 solution 함수를 완성해주세요.
	이때, a의 모든 부분 수열 중에서 스타 수열이 없다면, 0을 return 해주세요.

	제한사항
	a의 길이는 1 이상 500,000 이하입니다.
	a의 모든 수는 0 이상 (a의 길이) 미만입니다.
	*/
	
	//같은 수가 1칸 이상 떨어져있는지 판별한 뒤 갯수를 센 뒤 *2
    public static int solution(int[] a) {
        int answer = -1;
        int[] cnt = new int[a.length];
        int[] lastIndex = new int[a.length];
        //모든 인덱스 -1로 초기화
        for(int i=0; i<a.length; i++) lastIndex[i]=-1;
        for(int i=0; i<a.length; i++){
            int num = a[i];
            //이전값이 범위값에 있고
            //현재값이 이전값과 다르고
            //현재값의 마지막 인덱스가 이전값보다 작다면
            if(i-1>=0 && a[i-1]!=num && lastIndex[num]<i-1){
                //현재값의 횟수 증가
                cnt[num]++;
                //현재 숫자의 마지막 인덱스 값 = 현재 숫자 (2개씩 자르는 경계점)
                lastIndex[num]=i;
            //현재값 다음수가 범위내에 있고
            //현재값과 다음수가 다르다면
            }else if(i+1<a.length && a[i+1]!=num){
                //현재값의 횟수 증가
                cnt[num]++;
                //현재숫자의 마지막 인덱스 값 = 다음 숫자(2개씩 자르는 경계점)
                lastIndex[num]=i+1;
            }
            //답 중 큰수를 취함
            answer=Math.max(answer,cnt[num]);
        }
        //답은 2배
        return answer*2;
    }
	
	public static void main(String[] args) {
		int[] a = {1,2,1,2};
		System.out.println(solution(a));
	}
}
