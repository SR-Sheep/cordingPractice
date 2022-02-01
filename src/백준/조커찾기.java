package 백준;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 조커찾기 {
	//https://www.acmicpc.net/problem/24393
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		int joker = 1; //조커 위치
		while(t-->0) {
			boolean left = true; //왼쪽에 있는지?
			//13보다 크면 오른쪽에 있고, 오른쪽 카드 중 현재 위치 -13번째에 있음
			if(joker>13) {
				left = false;
				joker-=13;
			}
			boolean isRight=true; //카드는 오른쪽에서 부터 섞음을 표시
			StringTokenizer st = new StringTokenizer(br.readLine());
			//왼쪽, 오른쪽 합쳐진 카드 수
			int l=0,r=0;
			//합쳐진 카드가 27보다 작으면 반복
			while(l+r<27) {
				//합칠 카드 수
				int card = Integer.parseInt(st.nextToken());
				//합칠 카드가 오른쪽이라면
				if(isRight) {
					//합칠 오른쪽 카드 더하기
					r+=card;
					//현재 조커가 오른쪽에 있고, 합칠 오른쪽 카드 수가 조커의 순서 이상이라면
					if(!left&&r>=joker) {
						//조커의 위치 = 왼쪽 합칠 카드 + 현재 조커의 위치
						joker = joker+l;
						//조커의 순서가 정해졌음으로 break;
						break;
					}
					
				//합칠 카드가 왼쪽이라면
				}else {
					//합칠 왼쪽 카드 더하기
					l+=card;
					//현재 조커가 왼쪽에 있고, 합칠 왼쪽 카드 수가 조커의 순서 이상이라면
					if(left&&l>=joker) {
						//조커의 위치 = 오른쪽 합칠 카드 + 현재 조커의 위치
						joker = joker+r;
						//조커의 순서가 정해졌음으로 break;
						break;
					}
				}
				//섞는 방향 바꾸기
				isRight=!isRight;
			}
		}
		//조커 위치 출력
		System.out.println(joker);
		br.close();
	}
}
