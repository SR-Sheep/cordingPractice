package 프로그래머스;

public class 완전탐색_카펫 {
    public static int[] solution(int brown, int yellow) {
        //약수 찾기
        for(int i=1;i*i<=yellow;i++) {
        	if(yellow%i==0) {
        		//i는 작은 약수, yellow/i = 큰약수
        		int width = yellow/i+2;
        		int height = i+2;
        		if(brown+yellow==width*height) return new int[] {width,height};
        	}
        }
        return null;
    }
	
	public static void main(String[] args) {
		int brown =24;
		int yellow =24;
		System.out.println(solution(brown, yellow)[0]+" "+solution(brown, yellow)[1]);
		
	}
}
