package 백준;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class 여행가자 {
	
	static int[] Roots;
	
	public static int getRoot(int city) {
		if(Roots[city]!=city){
			Roots[city]=getRoot(Roots[city]);
		}
		return Roots[city];
		
	}
	
	public static void setRoot(int city1, int city2) {
		if(city1>city2) {
			int tmp = city1;
			city1= city2;
			city2 = tmp;
		}
		Roots[getRoot(city2)]=getRoot(city1);
	} 
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine()); //도시 수
		int m = Integer.parseInt(br.readLine()); //여행 계획 도시 수
		
		Roots= new int[n+1];
		for(int i=1;i<=n;i++) {
			Roots[i]=i;
		}
		StringTokenizer st;
		for(int i=1;i<=n;i++) {
			st=new StringTokenizer(br.readLine());
			for(int j=1;j<=n;j++) {
				int conn = Integer.parseInt(st.nextToken());
				if(i>=j) continue;
				if(conn==1) {
					setRoot(i, j);
				}
			}
		}
		st=new StringTokenizer(br.readLine());
		int city = Integer.parseInt(st.nextToken());
		int root = getRoot(city);
		boolean isPossible = true;
		for(int i=1;i<m;i++) {
			int next = Integer.parseInt(st.nextToken());
			if(root!=getRoot(next)) {
				isPossible=false;
				break;
			}
		}
		System.out.println(isPossible?"YES":"NO");
		br.close();
	}
}
