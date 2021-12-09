package ����;

import java.io.*;
import java.util.Stack;

public class ������������ {
	//�ùٸ� ��ȣ ����
	//'(','[' �� ���ÿ� �߰�
	//')',']' �� ���ÿ��� pop�Ͽ� �� �˸��� ��ȣ���� �˻�, ���� �ʰų� ������ ��������� false 
	//������ �� , ������ ��������� true, �ƴϸ� false;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		Stack<Character> stack = new Stack<>();
		String[] answer = {"yes","no"}; //�� �迭
		String s = br.readLine(); //���ڿ�
		while(!s.equals(".")) { //���ڿ��� . �̸� ����
			int idx = 0; //answer[idx], �⺻ yes
			for(char c:s.toCharArray()) { //�ش� ���� char�� ����
				if(c=='('||c=='[') { //��ȣ�� ������ ���ÿ� �ֱ�
					stack.add(c);
				}else if(c==')') { //��ȣ�� ������ ��, ������ ��ų� �ش� ��ȣ�� �����ϴ� ��ȣ�� �ƴϸ� ���� no�� ���� �� break;
					if(stack.isEmpty()||stack.pop()!='(') {
						idx=1;
						break;
					}
				}else if(c==']') { //��ȣ�� ������ ��, ������ ��ų� �ش� ��ȣ�� �����ϴ� ��ȣ�� �ƴϸ� ���� no�� ���� �� break;
					if(stack.isEmpty()||stack.pop()!='[') {
						idx=1;
						break;
					}
				}
			}
			if(!stack.isEmpty()) idx=1; //���ÿ� ���� �ܿ� ��ȣ�� ������ no
			bw.append(answer[idx]+"\n"); //�� ���
			stack.clear(); //���� �ʱ�ȭ
			s = br.readLine(); //���� ���ڿ� �θ���
		}
		br.close();
		bw.close();
	}
}
