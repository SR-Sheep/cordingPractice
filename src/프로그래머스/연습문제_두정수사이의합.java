package ���α׷��ӽ�;

public class ��������_�������������� {
	//https://programmers.co.kr/learn/courses/30/lessons/12912
	//�� �� ������ ��� ���� ���� ���� ����
	
    public static long solution(int a, int b) {
        long num1 = a;
        long num2 = b;
        if(a>b){
            num1=b;
            num2=a;
        }
        if(num1==num2) return num1;
        return (num2*(num2+1)/2)-(num1*(num1+1)/2)+num1;
    }
    
    public static void main(String[] args) {
		int a= 3, b=5;
		System.out.println(solution(a, b));
	}

}
