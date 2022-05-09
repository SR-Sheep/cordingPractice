package 백준;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class 전화번호목록 {
	//https://www.acmicpc.net/problem/5052
	
	static class Trie{
		//root 생성
		PhoneNumber root = new PhoneNumber();
		//char 형을 int 형으로 변환
		public int charToInt(char c) {
			return c-'0';
		}
		//트라이에 전화번호 넣기
		public boolean setPhoneNumber(String phoneNumber) {
			PhoneNumber parent = root;
			int no;
			for(char c:phoneNumber.toCharArray()) {
				//숫자 변환
				no=charToInt(c);
				//null이면 새로 생성
				if(parent.children[no]==null) {
					parent.children[no]=new PhoneNumber(c);
				}
				//부모 재설정
				parent = parent.children[no];
				//이미 끝난 전적이 있다면 false 리턴
				if(parent.end) {
					return false;
				}
			}
			//단어가 끝났음을 체크
			parent.end=true;
			//자식들 있는지 검사, 있다면 false
			for(PhoneNumber pn:parent.children) {
				if(pn!=null) return false;
			}
			//모든 검사 통과했음으로 true
			return true;
		}
	}
	//전화번호 숫자 클래스
	static class PhoneNumber{
		//해당 숫자
		int n;
		//끝났음을 체크
		boolean end=false;
		//자식들, 0-9 숫자
		PhoneNumber[] children=new PhoneNumber[10];
		//기본생성자
		public PhoneNumber() {};
		
		public PhoneNumber(int n) {
			this.n=n;
		}
	}
	
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int t=Integer.parseInt(br.readLine());
		while(t-->0) {
			//전화번호 수
			int n=Integer.parseInt(br.readLine());
			//트라이 생성
			Trie trie = new Trie();
			//일관성 체크
			boolean isConsistency = true;
			//탐색
			for(int i=0;i<n;i++) {
				String phoneNumber = br.readLine();
				//일관성이 true이고, 핸드폰 번호를 트라이에 넣을 수 없다면
				if(isConsistency&&!trie.setPhoneNumber(phoneNumber)) {
					//일관성 false;
					isConsistency=false;
				};
			}
			//일관성이 있으면 YES, 아니면 NO 출력
			bw.append(isConsistency?"YES":"NO").append("\n");
		}
		bw.close();
		br.close();
	}
}
