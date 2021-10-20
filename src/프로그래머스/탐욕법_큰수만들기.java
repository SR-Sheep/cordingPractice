package ���α׷��ӽ�;

import java.util.Stack;

public class Ž���_ū������� {
	/*
	� ���ڿ��� k���� ���� �������� �� ���� �� �ִ� ���� ū ���ڸ� ���Ϸ� �մϴ�.

	���� ���, ���� 1924���� �� �� ���� �����ϸ�
	[19, 12, 14, 92, 94, 24] �� ���� �� �ֽ��ϴ�.
	�� �� ���� ū ���ڴ� 94 �Դϴ�.

	���ڿ� �������� ���� number�� ������ ���� ���� k�� solution �Լ��� �Ű������� �־����ϴ�.
	number���� k ���� ���� �������� �� ���� �� �ִ� �� ��
	���� ū ���ڸ� ���ڿ� ���·� return �ϵ��� solution �Լ��� �ϼ��ϼ���.
	
	���� ����
	    number�� 1�ڸ� �̻�, 1,000,000�ڸ� ������ �����Դϴ�.
	    k�� 1 �̻� number�� �ڸ��� �̸��� �ڿ����Դϴ�.
	*/
	
	
	public static String largestNum(String number, int count, int depth) {
		if(count==depth) return number;
		int num,next;
		for(int i=0;i<number.length()-1;i++) {
			num=number.charAt(i)-'0';
			next=number.charAt(i+1)-'0';
			if(num<next) {
				number=number.substring(i+1);
				depth++;
				break;
			}
		}
		System.out.println(number);
		
		return largestNum(number, count, depth);
	}
	
	
    public static String solution(String number, int k) {
    	//����� ���ڿ� ����
    	int l =number.length() - k;
    	//��� ���� ���� ��Ʈ�� ���� ����
    	StringBuilder sb = new StringBuilder();
        //���� ����(���� ��)
    	Stack<Character> stack = new Stack<>();

        for(int i=0;i<number.length();i++) {
            char c = number.charAt(i); //�ش� �ڸ��� ����
            //������ ������� �ʰų�, �ֱٿ� �� ���� c���� �۰ų�, Ƚ���� ������
            while (!stack.isEmpty() && stack.peek()<c && k-->0) {
                //���ÿ��� �����
            	stack.pop();
            }
            //���ÿ� �ֱ�
            stack.push(c);
        }
        //sb�� ���̸�ŭ stack���� �� ��������
        for (int i=0; i<l; i++) {
            sb.append(stack.get(i));
        }
        return sb.toString();
    }
	
	public static void main(String[] args) {
		Object[][] examples = {{"1924",2},{"1231234",3},{"4177252841",4},{"1000",1}};
		for(Object[] example:examples) {
			System.out.println(solution((String)example[0], (int)example[1]));
		}
		
	}
}
