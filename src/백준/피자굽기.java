package 백준;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class 피자굽기 {
	//https://www.acmicpc.net/problem/1756
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=new StringTokenizer(br.readLine());
		int d=Integer.parseInt(st.nextToken()); //오븐의 깊이
		int n=Integer.parseInt(st.nextToken()); //반죽수
		
		st=new StringTokenizer(br.readLine());
		
		Stack<Integer> stack = new Stack<Integer>();
		//오븐 위에는 피자가 쌓임으로, 역삼각형 모양으로 생긴것과 같다 (위가 넓고 아래가 적은모양)
		for(int i=1;i<=d;i++) {
			int oven = Integer.parseInt(st.nextToken());
			if(stack.isEmpty()) {
				stack.add(oven);
			}else {
				//오븐의 형태는 역삼각형모양임으로 이전과 비교하여 작은 값을 취함
				stack.add(Math.min(stack.peek(), oven));
			}
		}
		
		st=new StringTokenizer(br.readLine());
		boolean isOver = false;
		for(int i=0;i<n;i++) {
			int pizza = Integer.parseInt(st.nextToken());
			boolean isRun = false;
			//사용할 오븐 층이 있다면
			while(!stack.isEmpty()) {
				//오븐 층의 너비가 피자보다 작다면 해당 피자를 굽고 break
				if(pizza<=stack.pop()) {
					//오븐이 작동함을 표시
					isRun=true;
					break;
				}
			}
			//남은 오븐이 없고, 오븐이 작동하지 않았으면 피자가 넘침
			if(stack.isEmpty()&&!isRun) {
				isOver=true;
				break;
			}
		}
		//피자가 넘치면 0, 아니면 남은 오븐수 +1을 출력(맨 위의 오븐 층 수 = 1)
		System.out.println(isOver?0:stack.size()+1);
		br.close();
	}
}
