package ���α׷��ӽ�;

public class �������_��ƼĿ������ {
	/*
	https://programmers.co.kr/learn/courses/30/lessons/12971#
	
	�������� ����� ��ƼĿ���� �� ���� ��ƼĿ�� ���� �� ��ƼĿ�� ���� ������ ���� �ִ밡 �ǵ��� �ϰ� �ͽ��ϴ�.
	�� ��ƼĿ �� ���� ���� �������� �������ִ� ��ƼĿ�� �������� ����� �� ���� �˴ϴ�.

	��ƼĿ�� ���� ���ڰ� �迭 ���·� �־��� ��, ��ƼĿ�� ���� ���� �� �ִ� ������ ���� �ִ��� return �ϴ� solution �Լ��� �ϼ��� �ּ���.
	������ ��ƼĿ ����� ���� �迭�� ù ��° ���ҿ� ������ ���Ұ� ���� ����Ǿ� �ִٰ� �����մϴ�.

	���� ����
	sticker�� �������� ����� ��ƼĿ�� �� ĭ�� ���� ���ڰ� ������� ����ִ� �迭��, ����(N)�� 1 �̻� 100,000 �����Դϴ�.
	sticker�� �� ���Ҵ� ��ƼĿ�� �� ĭ�� ���� �����̸�, �� ĭ�� ���� ���ڴ� 1 �̻� 100 ������ �ڿ����Դϴ�.
	������ ��ƼĿ ����� ���� sticker �迭�� ù ��° ���ҿ� ������ ���Ұ� ���� ����Ǿ��ִٰ� �����մϴ�.
	*/
	public static int solution(int sticker[]) {
        if(sticker.length==1) return sticker[0];
        else if(sticker.length==2) return Math.max(sticker[0],sticker[1]);
        
        int answer=0;
        int[] point = new int[sticker.length];
        //1)ù°�� ä��
        point[0]=point[1]=sticker[0];
        for(int i=2;i<sticker.length-1;i++){
            //������, ������ �� + ���� ��ƼĿ�� �� ū���� ����
            point[i]=Math.max(point[i-1],point[i-2]+sticker[i]);
        }
        //������ ���� ���� �� �������� ������ -1 ���� ����
        answer = point[sticker.length-2];    
        
        //2)ù �� ä�� ����
        point[0]=0;
        point[1]=sticker[1];
        for(int i=2;i<sticker.length;i++){
            //������, ������ �� + ���� ��ƼĿ�� �� ū���� ����
            point[i]=Math.max(point[i-1],point[i-2]+sticker[i]);
        }
        //������ ���� ���� �� ���Ͽ� ū���� ����
        answer = Math.max(answer,point[sticker.length-1]);
        
        return answer;
    }
	
	
	public static void main(String[] args) {
		int[] sticker = {14,6,5,11,3,9,2,10}; //36
		int[] sticker2 = {1,3,2,5,4}; //8
		System.out.println(solution(sticker));
		System.out.println(solution(sticker2));
	}
}
