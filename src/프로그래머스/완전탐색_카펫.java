package ���α׷��ӽ�;

public class ����Ž��_ī�� {
    public static int[] solution(int brown, int yellow) {
        //��� ã��
        for(int i=1;i*i<=yellow;i++) {
        	if(yellow%i==0) {
        		//i�� ���� ���, yellow/i = ū���
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
