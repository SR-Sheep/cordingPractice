package 프로그래머스;

import java.util.HashSet;

public class 카카오_불량사용자 {
	//https://programmers.co.kr/learn/courses/30/lessons/64064
	
	static int N;
	static String[] User;
	static String[] Ban;
	static HashSet<String> Bad;
	static HashSet<Integer> Bad2;
	
	//배열이용
	public static void candidate(int idx,boolean[] visited){
		if(idx==N) {
			StringBuilder sb = new StringBuilder();
			for(boolean b:visited) {
				if(b)sb.append("1");
				else sb.append("0");
			}
			Bad.add(sb.toString());
			return;
		}
		//정규표현식
		String regex = Ban[idx];
		
		for(int i=0;i<User.length;i++) {
			if(User[i].matches(regex)&&!visited[i]) {
				visited[i]=true;
				candidate(idx+1, visited);
				visited[i]=false;
			}
		}
	}
	
	//비트마스크 이용
	public static void candidate2(int idx,int visited){
		if(idx==N) {
			Bad2.add(visited);
			return;
		}
		String regex = Ban[idx];
		for(int i=0;i<User.length;i++) {
			if(User[i].matches(regex)&&(visited&1<<i)==0) {
				visited=visited|(1<<i);
				candidate2(idx+1, visited);
				visited=visited^(1<<i);
			}
		}
	}
	
    public static int solution(String[] user_id, String[] banned_id) {
        N=banned_id.length;
    	User=user_id;
    	Ban=new String[N];
    	//*을 정규표현식으로 변경
    	for(int i=0;i<N;i++) {
    		Ban[i]=banned_id[i].replace("*", "[a-z0-9]{1}");
    	}
    	//배열이용
    	Bad=new HashSet<>();
    	candidate(0,new boolean[user_id.length]);
    	//비트마스크이용
    	Bad2=new HashSet<>();
    	candidate2(0,1<<user_id.length-1);
    	
        return Bad2.size();
    }
	
	
	public static void main(String[] args) {
		String[] u = {"frodo", "fradi", "crodo", "abc123", "frodoc"};
		String[] b = {"fr*d*", "abc1**"};
		
		System.out.println(solution(u, b));
		
		for(Integer i:Bad2) {
			System.out.println(Integer.toBinaryString(i));
		}

		
		
		//System.out.println(list.size());
		
		
		
		
	}

}
