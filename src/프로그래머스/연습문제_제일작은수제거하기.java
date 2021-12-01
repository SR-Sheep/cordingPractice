package 프로그래머스;

public class 연습문제_제일작은수제거하기 {
	//https://programmers.co.kr/learn/courses/30/lessons/12935
	//정수를 저장한 배열, arr 에서 가장 작은 수를 제거한 배열을 리턴하는 함수, solution을 완성해주세요.
	//단, 리턴하려는 배열이 빈 배열인 경우엔 배열에 -1을 채워 리턴하세요.
	//예를들어 arr이 [4,3,2,1]인 경우는 [4,3,2]를 리턴 하고, [10]면 [-1]을 리턴 합니다.
	
    public static int[] solution(int[] arr) {
        if(arr.length==1) return new int[]{-1}; //길이가 1이면 -1 리턴
        int[] answer = new int[arr.length-1];
        int min=Integer.MAX_VALUE; //최소값
        int minIdx=-1; //최소값 위치
        for(int i=0;i<arr.length;i++){
            if(min>arr[i]){ //최소값보다 작으면
                min=arr[i]; //최소값 업데이트
                minIdx=i; //최소값 인덱스 저장
            }
        }
        int idx=0;
        for(int i=0;i<arr.length;i++){
            if(i!=minIdx){
                answer[idx++]=arr[i]; //최소값 인덱스 제외하고 답
            }
        }
        
        return answer;
    }
	public static void main(String[] args) {
		int[] arr= {5,4,3,2,1};
		for(int i:solution(arr)) {
			System.out.print(i+" ");
		}
	}
}
