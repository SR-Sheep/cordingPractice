package 백준;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class DNA해독 {
	public static void main(String[] args) throws IOException {
		//https://www.acmicpc.net/problem/1672
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int l = Integer.parseInt(br.readLine());
		Stack<Character> stack = new Stack<>();
		for(char c:br.readLine().toCharArray()) stack.push(c);
		char base = stack.pop();
		Map<Character, Integer> map = new HashMap<>();
		map.put('A', 1);
		map.put('G', 2);
		map.put('C', 4);
		map.put('T', 8);
		while(!stack.isEmpty()) {
			char nextBase = stack.pop();
			if(base==nextBase) continue; //같으면 pass
			int result = map.get(base)+map.get(nextBase);
			//AG = 3
			if(result==3) {
				base = 'C';
			//AC = 5
			}else if(result==5) {
				base = 'A';
			//AT = 9
			}else if(result==9) {
				base = 'G';
			//GC = 6
			}else if(result==6) {
				base = 'T';
			//GT = 10
			}else if(result==10) {
				base = 'A';
			//CT = 12
			}else {
				base = 'G';
			}
		}
		System.out.println(base);
		br.close();
	}
}
