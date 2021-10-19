package ���α׷��ӽ�;

public class Ž���_���̽�ƽ {
    public static int solution(String name) {
    	/*
    	���̽�ƽ���� ���ĺ� �̸��� �ϼ��ϼ���. �� ó���� A�θ� �̷���� �ֽ��ϴ�.
    	ex) �ϼ��ؾ� �ϴ� �̸��� �� ���ڸ� AAA, �� ���ڸ� AAAA

    	���̽�ƽ�� �� �������� �����̸� �Ʒ��� �����ϴ�.

    	�� - ���� ���ĺ�
    	�� - ���� ���ĺ� (A���� �Ʒ������� �̵��ϸ� Z��)
    	�� - Ŀ���� �������� �̵� (ù ��° ��ġ���� �������� �̵��ϸ� ������ ���ڿ� Ŀ��)
    	�� - Ŀ���� ���������� �̵�
    	���� ��� �Ʒ��� ������� "JAZ"�� ���� �� �ֽ��ϴ�.

    	- ù ��° ��ġ���� ���̽�ƽ�� ���� 9�� �����Ͽ� J�� �ϼ��մϴ�.
    	- ���̽�ƽ�� �������� 1�� �����Ͽ� Ŀ���� ������ ���� ��ġ�� �̵���ŵ�ϴ�.
    	- ������ ��ġ���� ���̽�ƽ�� �Ʒ��� 1�� �����Ͽ� Z�� �ϼ��մϴ�.
    	���� 11�� �̵����� "JAZ"�� ���� �� �ְ�, �̶��� �ּ� �̵��Դϴ�.
    	������� �ϴ� �̸� name�� �Ű������� �־��� ��, �̸��� ���� ���̽�ƽ ���� Ƚ���� �ּڰ��� return �ϵ��� solution �Լ��� ���弼��.
    	
    	���� ����
		name�� ���ĺ� �빮�ڷθ� �̷���� �ֽ��ϴ�.
		name�� ���̴� 1 �̻� 20 �����Դϴ�.
        */
        
        int count=0;
        int move=0;
        int streamA=0;
        int maxStreamA=0;
        int tmpIdx=0;
        int idx=0;
        int streamIdx=-1;
        final int INF = 987654321;
        
        for(char c:name.toCharArray()) {
        	//O �̻��� ���ĺ��� ��� �Ʒ� ����Ű�� �̵��� �� �Է�
        	if(c>='O') {
        		count+='Z'-c+1;
        	}else {
        		//�������� ��� �� ����Ű
        		count+=c-'A';
        	}
        	//A�� ���
        	if(c=='A') {
        		//A�� ó�� ���� �� idx�� ������
        		if(streamA==0) tmpIdx=idx;
        		//���ӵǴ� A�� Ƚ�� ���
        		streamA++;
        	}
        	//A�� �ƴϰų� ������ ������ ���
        	if(c!='A'||idx==name.length()-1){
        		//���ӵǴ� A�� �ִ�ġ ���� ���� ��ϵ� ���ӵǴ� A Ƚ���� ũ�ٸ�
        		if(maxStreamA<streamA) {
        			//�����ϴ� A�� �ִ�ġ ����
        			maxStreamA=streamA;
        			//�����ϴ� idx ���
        			streamIdx=tmpIdx;
        		}
        		//�����ϴ� A Ƚ��, �ε��� �ʱ�ȭ
        		streamA=0;
        		tmpIdx=0;
        	}
        	//�ε��� ����
        	idx++;
        }
        //��� A�� ��� 0 ����
        if(maxStreamA==name.length()) return 0;
        
        //�¿� ����Ű �ִ�ġ
        move=name.length()-1;
        
        int backmove;
        //�����ϴ� A�� idx���� ��ϵ��� �ʾҴٸ� �ڷ� ���� ���� 
        if(streamIdx==-1) backmove=INF;
        //�ڷ� �ǵ��� ���� : �����ϴ� idx�� ���ڸ��� �̵� �� �ٽ� �ǵ��ư� ��
        //�����ϴ� A�� ������ ~ name�� ��
        else backmove=(streamIdx-1)*2 + (name.length()-(streamIdx+maxStreamA));
        //�¿� ����Ű�� �ִ�ġ���� �ڷ� �ǵ��� ���� ����� ������ �ڷ� �ǵ��ư��� ����
        move=move>backmove?backmove:move;
        //���Ʒ� ����Ű �� + �¿� ����Ű �� ����
        return count+move;
    }
	
	public static void main(String[] args) {
		String[] names= {"BBBBAABBB","JEROEN","AAAABB","JAN"};
		for(String name : names) System.out.println(solution(name));
	}
}
