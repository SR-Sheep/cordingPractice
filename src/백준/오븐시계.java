package 백준;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 오븐시계 {
	//https://www.acmicpc.net/problem/2525
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=new StringTokenizer(br.readLine());
		int hour=Integer.parseInt(st.nextToken());
		int min=Integer.parseInt(st.nextToken());
		int cookingMin=Integer.parseInt(br.readLine());
		min+=cookingMin;
		hour+=min/60;
		min%=60;
		hour%=24;
		System.out.println(hour+" "+min);
		br.close();
	}
}
