package 프로그래머스;

public class 연습문제_피보나치수 {
	//https://programmers.co.kr/learn/courses/30/lessons/12945#;
	/*
	2 이상의 n이 입력되었을 때, n번째 피보나치 수를 1234567으로 나눈 나머지를 리턴하는 함수, solution을 완성해 주세요.

	제한 사항
	n은 2 이상 100,000 이하인 자연수입니다.
	*/
    public int solution(int n) {
        int answer = 0, n1 = 0, n2 = 1;
        while(1<n--){
            answer=(n1+n2)%1234567;
            n1=n2;
            n2=answer;
        }
        return answer;
    }
}
