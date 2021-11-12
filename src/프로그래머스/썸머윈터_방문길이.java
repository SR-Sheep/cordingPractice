package ���α׷��ӽ�;

import java.util.HashMap;

public class �������_�湮���� {
	/*
	https://programmers.co.kr/learn/courses/30/lessons/49994#
	
	���� ����
	���� ĳ���͸� 4���� ��ɾ ���� �����̷� �մϴ�. ��ɾ�� ������ �����ϴ�.

	U: �������� �� ĭ ����

	D: �Ʒ������� �� ĭ ����

	R: ���������� �� ĭ ����

	L: �������� �� ĭ ����

	ĳ���ʹ� ��ǥ����� (0, 0) ��ġ���� �����մϴ�. ��ǥ����� ���� ���� ��(-5, 5), ���� �Ʒ�(-5, -5), ������ ��(5, 5), ������ �Ʒ�(5, -5)�� �̷���� �ֽ��ϴ�.
	
	��ɾ �Ű����� dirs�� �־��� ��, ���� ĳ���Ͱ� ó�� �ɾ ���� ���̸� ���Ͽ� return �ϴ� solution �Լ��� �ϼ��� �ּ���.

	���ѻ���
	dirs�� string������ �־�����, 'U', 'D', 'R', 'L' �̿ܿ� ���ڴ� �־����� �ʽ��ϴ�.
	dirs�� ���̴� 500 ������ �ڿ����Դϴ�.
	
	*/
	
	public int solution(String dirs) {
        HashMap<Character, int[]>map = new HashMap<>(); //���� ���� �ؽ���
        map.put('U',new int[]{-1,0}); // ��
        map.put('R',new int[]{0,1});  // ������
        map.put('L',new int[]{0,-1}); // ����
        map.put('D',new int[]{1,0});  // �Ʒ�
        boolean[][] visited=new boolean[22][22]; //�湮����, �߰� ��θ� ����ؾ� ������ 2�� ����
        int r=10,c=10; //��� ��
        int answer = 0; //��
        //Ž��
        for(char ch:dirs.toCharArray()){
            //�ش� ��ǥ�� ��������
            int[] dir = map.get(ch); 
            int nr = r+dir[0];
            int nc = c+dir[1];
            //������ ����� ��Ƽ��
            if(nr+dir[0]<0||nr+dir[0]>=22||nc+dir[1]<0||nc+dir[1]>=22) continue;
            //ù �湮�� �湮���� ǥ�� �� �� ����
            if(!visited[nr][nc]){
                visited[nr][nc]=true;
                answer++;
            };
            //���� ��ǥ ������Ʈ
            r=nr+dir[0];
            c=nc+dir[1];
        }
        return answer;
    }
	
	public static void main(String[] args) {
		
	}
}
