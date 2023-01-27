package 백준;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class 럭비클럽 {
	//https://www.acmicpc.net/problem/2083
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st=new StringTokenizer(br.readLine());
		String name = st.nextToken();
		while(!name.equals("#")) {
			int age = Integer.parseInt(st.nextToken());
			int weight = Integer.parseInt(st.nextToken());
			//17살이 넘거나, 몸무게가 80 이상이면 Senior
			if(age>17||weight>=80) {
				bw.append(name+" Senior\n");
			//그 외의 경우 Junior
			}else {
				bw.append(name+" Junior\n");
			}
			//다음 선수
			st=new StringTokenizer(br.readLine());
			name = st.nextToken();
		}
		bw.close();
		br.close();
	}
}
