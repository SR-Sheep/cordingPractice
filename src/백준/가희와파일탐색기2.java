package 백준;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.StringTokenizer;

public class 가희와파일탐색기2 {
	//https://www.acmicpc.net/problem/25240
	
	static Map<String, Set<String>> Groups; //유저의 그룹
	
	//파일 클래스
	static class JoFile{
		String name; //이름(사용은 안함)
		int[] auths; //권한(소유자, 그룹, 이외)
		String user,group; //소유자, 그룹
		//생성자
		public JoFile(String name, int auth, String user, String group) {
			this.name=name;
			this.user = user;
			this.group = group;
			this.auths=new int[3];
			for(int i=2;i>=0;i--) {
				auths[i]=auth%10;
				auth/=10;
			}
		}
		//가능 여부
		public int isPossible(String user, char cmd) {
			//실행 명령
			int idx = -1;
			if(cmd=='R') {
				idx = 2;
			}else if(cmd=='W') {
				idx = 1;
			}else {
				idx = 0;
			}
			//user의 권한
			int auth = -1;
			//소유자라면
			if(user.equals(this.user)) {
				auth = auths[0];
			//그룹이라면
			}else if(Groups.get(this.group).contains(user)) {
				auth = auths[1];
			//그외 경우
			}else {
				auth = auths[2];
			}
			//해당 권한이 1이라면 1, 아니라면 0
			return ((1<<idx)&auth)==(1<<idx)?1:0;
		}
		
		@Override
		public String toString() {
			return this.name;
		}
		
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st=new StringTokenizer(br.readLine());
		int u=Integer.parseInt(st.nextToken()); //유저 수
		int f=Integer.parseInt(st.nextToken()); //파일 수
		
		//유저 입력
		Groups  = new HashMap<>();
		for(int i=0;i<u;i++) {
			st=new StringTokenizer(br.readLine());
			String name = st.nextToken();
			while(st.hasMoreTokens()) {
				String group = st.nextToken(" |,");
				Groups.putIfAbsent(group, new HashSet<>());
				Groups.get(group).add(name);
			}
			Groups.putIfAbsent(name, new HashSet<>());
			Groups.get(name).add(name);
		}
		//파일 입력
		Map<String, JoFile> joFiles = new HashMap<>();
		for(int i=0;i<f;i++) {
			st=new StringTokenizer(br.readLine());
			String name = st.nextToken();
			int auth = Integer.parseInt(st.nextToken());
			String user = st.nextToken();
			String group = st.nextToken();
			joFiles.put(name, new JoFile(name, auth, user, group));
		}
		
		//문제
		int q = Integer.parseInt(br.readLine());
		for(int i=0;i<q;i++) {
			st=new StringTokenizer(br.readLine());
			String username = st.nextToken();
			String file = st.nextToken();
			char cmd = st.nextToken().charAt(0);
			bw.append(joFiles.get(file).isPossible(username, cmd)+"\n");
		}
		
		
		bw.close();
		br.close();
	}
}
