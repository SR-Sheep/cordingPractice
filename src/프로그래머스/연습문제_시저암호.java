package ���α׷��ӽ�;

public class ��������_������ȣ {
	//https://programmers.co.kr/learn/courses/30/lessons/12926?language=java
	//n��ŭ ���� ���� ���, �빮�ڴ� �빮�ڷ�, �ҹ��ڴ� �ҹ��ڷ�, ������ ��������
    public static String solution(String s, int n) {
        StringBuilder sb = new StringBuilder();
        for(char c:s.toCharArray()){
            char tmp = c;
            if(Character.isUpperCase(c)){
                tmp+=n;
                if(tmp>'Z') tmp-=26;
            }else if(Character.isLowerCase(c)){
                tmp+=n;
                if(tmp>'z') tmp-=26;
            }
            sb.append(tmp);
        }
        return sb.toString();
    }
    
    public static void main(String[] args) {
		String s= "a B z";
		int n= 4;
		System.out.println(solution(s, n));
	}
}
