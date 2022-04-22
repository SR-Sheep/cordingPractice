package 백준;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 직각삼각형 {
	//https://www.acmicpc.net/problem/4153
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int a = Integer.parseInt(st.nextToken());
		int b = Integer.parseInt(st.nextToken());
		int c = Integer.parseInt(st.nextToken());
		int[] arr = new int[3];
		String[] answer = {"right","wrong"};
		//0이 없다면 실행 (0,0,0 = 끝)
		while(a*b*c!=0) {
			arr[0]=a;
			arr[1]=b;
			arr[2]=c;
			//배열 정렬
			Arrays.sort(arr);
			//피타고라스 정리 c^2 = a^2 + b^2
			if(arr[2]*arr[2]==arr[1]*arr[1]+arr[0]*arr[0]) {
				bw.append(answer[0]+"\n");
			}else {
				bw.append(answer[1]+"\n");
			}
			
			st=new StringTokenizer(br.readLine());
			a = Integer.parseInt(st.nextToken());
			b = Integer.parseInt(st.nextToken());
			c = Integer.parseInt(st.nextToken());
		}
		br.close();
		bw.close();
	}
}
