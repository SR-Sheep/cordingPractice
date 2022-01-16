package 백준;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class 앵그리창영 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st=new StringTokenizer(br.readLine());
		int t=Integer.parseInt(st.nextToken());
		int w=Integer.parseInt(st.nextToken());
		int h=Integer.parseInt(st.nextToken());
		int squared = w*w+h*h;
		
		for(int i=0;i<t;i++) {
			int match=Integer.parseInt(br.readLine());
			if(match*match<=squared) {
				bw.append("DA\n");
			}else {
				bw.append("NE\n");
			}
		}
		br.close();
		bw.close();
	}
}
