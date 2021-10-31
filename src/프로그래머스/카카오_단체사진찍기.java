package 프로그래머스;

import java.util.ArrayList;

public class 카카오_단체사진찍기 {
	static boolean[] Visited=new boolean[8];
	static int N, Answer=0;
	static ArrayList<int[]> Conditions=new ArrayList<>();
	
	public static void isOk(String s) {
		boolean pass=true;
		for(int[] condition:Conditions) {
			if(!pass) break;
			int a=condition[0];
			int b=condition[1];
			int sign = condition[2];
			int num = condition[3];
			
			int aIdx=-1, bIdx=-1;
			for(int i=0;i<8;i++) {
				if(a==s.charAt(i)-'0') aIdx=i; 
				else if(b==s.charAt(i)-'0') bIdx=i;
			}
			int interval =Math.abs(aIdx-bIdx)-1;
			//=
			if(sign==61) {
				if(interval!=num) pass=false; 
			//<	
			}else if(sign==60) {
				if(interval>=num) pass=false;
			//>	
			}else if(sign==62) {
				if(interval<=num) pass=false;
			}
		}
		
		if(pass) Answer++;
		
	}
	
	
	public static void permutation(String s) {
		if(s.length()==8) {
			isOk(s);
			return;
		} 
		for(int i=0;i<8;i++) {
			if(!Visited[i]) {
				Visited[i]=true;
				permutation(s+i);
				Visited[i]=false;
			}
		}
		return;
	}
	
    public static int solution(int n, String[] data) {
    	char[] friends= {'A', 'C', 'F', 'J', 'M', 'N', 'R', 'T'};
        for(String d:data) {
        	int a=-1,b=-1;
        	int sign=d.charAt(3)+0;
        	int num=d.charAt(4)-'0';
        	
        	for(int i=0;i<8;i++) {
        		char friend =friends[i];
        		if(friend==d.charAt(0)) a=i;
        		else if(friend==d.charAt(2)) b=i;
        	}
        	Conditions.add(new int[] {a,b,sign,num});
        }
        permutation("");
        return Answer;
    }
	public static void main(String[] args) {
		int n=2;
		String[] data = {"N~F=0", "R~T>2"};
//		String[] data = {"M~C<2", "C~M>1"};
		System.out.println(solution(n, data));
	}

}
