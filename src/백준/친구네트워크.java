package 백준;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.HashMap;
import java.util.StringTokenizer;

public class 친구네트워크 {
	//https://www.acmicpc.net/problem/4195
	
	static int[] Roots; //root 저장
	static int[] Networks; //네트워크 수 저장
	
	//해당 친구의 root 찾기
	public static int getRoot(int friend) {
		if(Roots[friend]!=friend){
			Roots[friend]=getRoot(Roots[friend]);
		}
		return Roots[friend];
		
	}
	//친구의 root 세팅
	public static int setRoot(int friend1, int friend2) {
		//friend1은 friend2 보다 작은것으로 변경
		if(friend1>friend2) {
			int tmp = friend1;
			friend1= friend2;
			friend2 = tmp;
		}
		int root1 = getRoot(friend1);
		int root2 = getRoot(friend2);
		if(root1!=root2) {
			Networks[root1]+=Networks[root2];
			Roots[root2]=getRoot(root1);
		}
		
		return Networks[root1];
	}
	
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int t = Integer.parseInt(br.readLine());
		StringTokenizer st;
		for(int i=0;i<t;i++) {
			int n=Integer.parseInt(br.readLine());
			HashMap<String, Integer> map = new HashMap<String, Integer>();
			int idx = 0;
			
			Roots = new int[200001];
			for(int j=1;j<200001;j++) {
				Roots[j]=j;
			}
			Networks = new int[200001];
			Arrays.fill(Networks, 1);
			while(n-->0) {
				st=new StringTokenizer(br.readLine());
				
				String name1 = st.nextToken();
				map.putIfAbsent(name1, idx++);
				int friend1 = map.get(name1);
				
				String name2 = st.nextToken();
				map.putIfAbsent(name2, idx++);
				int friend2 = map.get(name2);
				
				bw.append(setRoot(friend1, friend2)+"\n");
			}
		}
		br.close();
		bw.close();
	}
}
