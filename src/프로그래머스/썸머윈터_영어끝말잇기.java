package ���α׷��ӽ�;

import java.util.HashMap;

public class �������_������ձ� {
	//https://programmers.co.kr/learn/courses/30/lessons/12981
	/*
	���� ����
	1���� n���� ��ȣ�� �پ��ִ� n���� ����� ���� �����ձ⸦ �ϰ� �ֽ��ϴ�. ���� �����ձ�� ������ ���� ��Ģ���� ����˴ϴ�.

	1������ ��ȣ ������� �� ����� ���ʴ�� �ܾ ���մϴ�.
	������ ����� �ܾ ���� �������� �ٽ� 1������ �����մϴ�.
	�ջ���� ���� �ܾ��� ������ ���ڷ� �����ϴ� �ܾ ���ؾ� �մϴ�.
	������ �����ߴ� �ܾ�� ����� �� �����ϴ�.
	�� ������ �ܾ�� �������� �ʽ��ϴ�.
	
	����� �� n�� ������� ������� ���� �ܾ� words �� �Ű������� �־��� ��,
	���� ���� Ż���ϴ� ����� ��ȣ�� �� ����� �ڽ��� �� ��° ���ʿ� Ż���ϴ����� ���ؼ� return �ϵ��� solution �Լ��� �ϼ����ּ���.

	���� ����
	�����ձ⿡ �����ϴ� ����� �� n�� 2 �̻� 10 ������ �ڿ����Դϴ�.
	words�� �����ձ⿡ ����� �ܾ���� ������� ����ִ� �迭�̸�, ���̴� n �̻� 100 �����Դϴ�.
	�ܾ��� ���̴� 2 �̻� 50 �����Դϴ�.
	��� �ܾ�� ���ĺ� �ҹ��ڷθ� �̷���� �ֽ��ϴ�.
	�����ձ⿡ ���Ǵ� �ܾ��� ��(�ǹ�)�� �Ű� ���� �����ŵ� �˴ϴ�.
	������ [ ��ȣ, ���� ] ���·� return ���ּ���.
	���� �־��� �ܾ��� Ż���ڰ� ������ �ʴ´ٸ�, [0, 0]�� return ���ּ���.
	
	*/
	
	public static int[] solution(int n, String[] words) {
        int[] answer = new int[]{0,0}; //���� ������ �迭 ����, 0,0 �ʱ�ȭ
        HashMap<String, Integer> map = new HashMap<>(); //����� ������ �ؽ��� ����
        map.put(words[0],1); //�� ó�� �ܾ �ʿ� �Է�
        char beforeLastChar = words[0].charAt(words[0].length()-1); //�� �ܾ��� ������ ����
        for(int i=1;i<words.length;i++){ //Ž��
        	//�� �ܾ��� ������ ���ڰ� ���� �ܾ� ù���ڿ� ��ġ�ϰ�, �ʿ� �������� �ʴ´ٸ�
            if(beforeLastChar == words[i].charAt(0)&&map.get(words[i])==null){ 
                //������ ���� ������Ʈ
            	beforeLastChar=words[i].charAt(words[i].length()-1);
                //�ʿ� �ش� �ܾ� �߰�
            	map.put(words[i],1);
            //������ ���ڰ� ���� ù���ڿ� ��ġ���� �ʰų�(�����ձ� ����)
        	//�ʿ� �����ϴ� �ܾ���(������ ���� �ܾ�)
            }else{
            	//��ȣ(�ڽ� ��ȣ)
                answer[0]=i%n +1;
                //����(���� ��)
                answer[1]=i/n +1;
                break;
            }
        }
        return answer;
    }
	
	public static void main(String[] args) {
		int num = 3;
		String[][] words= {{"tank", "kick", "know", "wheel", "land", "dream", "mother", "robot", "tank"},
				{"hello", "observe", "effect", "take", "either", "recognize", "encourage", "ensure", "establish", "hang", "gather", "refer", "reference", "estimate", "executive"},
				{"hello", "one", "even", "never", "now", "world", "draw"}};
		int[] n = {3,5,2}; //(3,3) , (0,0) , (1,3)
		for(int i=0;i<num;i++) {
			for(int j:solution(n[i], words[i])) {
				System.out.print(j+" ");
			}
			System.out.println();
		}
		
		
	}
}
