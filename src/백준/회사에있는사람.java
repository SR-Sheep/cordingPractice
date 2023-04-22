package 백준;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;
//https://www.acmicpc.net/problem/7785
public class 회사에있는사람 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int n = Integer.parseInt(br.readLine());
		StringTokenizer st;
		Map<String, Boolean> map = new HashMap<>();
		for(int i=0;i<n;i++) {
			st=new StringTokenizer(br.readLine());
			String name = st.nextToken();
			String cmd = st.nextToken();
			map.put(name, cmd.charAt(0)=='e'); //e면 출근, 아니면 퇴근
		}
		List<String> list = new ArrayList<>();
		for(String name:map.keySet()) {
			if(map.get(name)) list.add(name); //출근하면 list 넣기
		}
		Collections.sort(list,Collections.reverseOrder()); //역순
		for(String name:list) bw.append(name+"\n"); //출력
		bw.close();
		br.close();
	}
}
