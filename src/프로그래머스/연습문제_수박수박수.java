package ���α׷��ӽ�;

public class ��������_���ڼ��ڼ� {
	
//	https://programmers.co.kr/learn/courses/30/lessons/12922
	
    public static String solution(int n) {
        int repeat = n/2; //�ݺ�Ƚ��
        int su = n%2; //������
        StringBuilder sb = new StringBuilder();
        //�ݺ�Ƚ����ŭ ���� ���̱�
        while(repeat-->0){
            sb.append("����");
        }
        //�������� ������ �� ���̱�
        if(su>0) sb.append("��");
        //����
        return sb.toString();
    }
	
	public static void main(String[] args) {
		int n=3;
		System.out.println(solution(n));
	}

}
