package ���α׷��ӽ�;

public class ��������_�ùٸ���ȣ {
	//https://programmers.co.kr/learn/courses/30/lessons/12909
	
	/*
	���� ����
	��ȣ�� �ٸ��� ¦�������ٴ� ���� '(' ���ڷ� �������� �ݵ�� ¦��� ')' ���ڷ� ������ �Ѵٴ� ���Դϴ�.
	
	���� ���
	"()()" �Ǵ� "(())()" �� �ùٸ� ��ȣ�Դϴ�.
	")()(" �Ǵ� "(()(" �� �ùٸ��� ���� ��ȣ�Դϴ�.
	
	'(' �Ǵ� ')' �θ� �̷���� ���ڿ� s�� �־����� ��, ���ڿ� s�� �ùٸ� ��ȣ�̸� true�� return �ϰ�,
	�ùٸ��� ���� ��ȣ�̸� false�� return �ϴ� solution �Լ��� �ϼ��� �ּ���.

	���ѻ���
	���ڿ� s�� ���� : 100,000 ������ �ڿ���
	���ڿ� s�� '(' �Ǵ� ')' �θ� �̷���� �ֽ��ϴ�.
	*/
	
    static boolean solution(String s) {
        int num=0;
        for(int i=0;i<s.length();i++){
            if(num<0) return false;
            else{
                if(s.charAt(i)=='(') num++;
                else num--;
            }
        }
        return num==0;
    }
    
    public static void main(String[] args) {
		String[] ss = {"()()","(())()",")()(","(()("};
		for(String s:ss) System.out.println(solution(s));
	}

}
