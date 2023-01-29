package 백준;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 몇개고 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=new StringTokenizer(br.readLine());
		int t=Integer.parseInt(st.nextToken()); //시간
		int sul=Integer.parseInt(st.nextToken()); //술 여부
		System.out.println(t>=12&&t<=16&&sul==0?320:280); //점심시간에 술이 없으면 320, 이외 280
		br.close();
	}
}
