package 프로그래머스;

public class 연습문제_수박수박수 {
	
//	https://programmers.co.kr/learn/courses/30/lessons/12922
	
    public static String solution(int n) {
        int repeat = n/2; //반복횟수
        int su = n%2; //나머지
        StringBuilder sb = new StringBuilder();
        //반복횟수만큼 수박 붙이기
        while(repeat-->0){
            sb.append("수박");
        }
        //나머지가 있으면 수 붙이기
        if(su>0) sb.append("수");
        //리턴
        return sb.toString();
    }
	
	public static void main(String[] args) {
		int n=3;
		System.out.println(solution(n));
	}

}
