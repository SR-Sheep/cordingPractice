package 백준;

import java.io.*;
import java.util.HashMap;

public class Ресторан {
	
	//https://www.acmicpc.net/problem/23738
	
	public static void main(String[] args) throws IOException {
		//매칭되는 발음 맵핑
		HashMap<Character, String> map = new HashMap<>();
		map.put('A',"a");
		map.put('B',"v");
		map.put('E',"ye");
		map.put('K',"k");
		map.put('M',"m");
		map.put('H',"n");
		map.put('O',"o");
		map.put('P',"r");
		map.put('C',"s");
		map.put('T',"t");
		map.put('Y',"u");
		map.put('X',"h");
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		String s = br.readLine();
		//답 출력을 위한 스트링빌더
		StringBuilder sb = new StringBuilder();
		//매칭되는 발음 연결
		for(char c:s.toCharArray()) {
			sb.append(map.get(c));
		}
		//���
		bw.append(sb.toString()+"\n");
		br.close();
		bw.close();
	}
}
