package 백준;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;
import java.util.StringTokenizer;

public class 에디터 {
	//https://www.acmicpc.net/problem/1406
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		List<Character> list = new LinkedList<>();
		for(char c:br.readLine().toCharArray()) {
			list.add(c);
		}
		ListIterator<Character> it = list.listIterator();
		//커서 맨 마지막으로 이동
		while(it.hasNext()) {
			it.next();
		}
		//명령 반복 횟수
		int t = Integer.parseInt(br.readLine());
		StringTokenizer st;
		//명령 실행
		for(int i=0;i<t;i++) {
			st=new StringTokenizer(br.readLine());
			char cmd = st.nextToken().charAt(0);
			//L이면 커서 왼쪽으로 이동
			if(cmd=='L'&&it.hasPrevious()) {
				it.previous();
			//D이면 커서 오른쪽으로 이동
			}else if(cmd=='D'&&it.hasNext()) {
				it.next();
			//B이면 커서 왼쪽 삭제이므로 왼쪽으로 한칸 이동 후 삭제	
			}else if(cmd=='B'&&it.hasPrevious()) {
				it.previous();
				it.remove();
			//P이면 커서 왼쪽 삽입 후 오른쪽으로 이동 (커서는 자동으로 옮겨짐)
			}else if(cmd=='P') {
				it.add(st.nextToken().charAt(0));
			}
		}
		//출력
		for(char c:list) {
			bw.append(c);
		}
		br.close();
		bw.close();
	}
}
