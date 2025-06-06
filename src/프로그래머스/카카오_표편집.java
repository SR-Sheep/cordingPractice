package 프로그래머스;

import java.util.*;

public class 카카오_표편집 {
	
	//https://programmers.co.kr/learn/courses/30/lessons/81303
	
	
	//해결법 1, 정확성은 통과하나 효율성에서 50%만 통과함
	static boolean[] IsDelete;
	static int Now,N;
	static Stack<Integer> Undo1 = new Stack<Integer>();
	static List<Node> Table;
	
	public static void cmd(String cmd) {
		//실행취소
		if(cmd.charAt(0)=='Z') {
			IsDelete[Undo1.pop()]=false;
		//삭제
		}else if(cmd.charAt(0)=='C') {
			IsDelete[Now]=true;
			//스택에 추가
			Undo1.add(Now);
			//한칸 아래로 이동
			cmd("D 1");
		}else {
			//이동수
			int num = Integer.parseInt(cmd.split(" ")[1]);
			//위로 이동
			if(cmd.charAt(0)=='U') {
				//존재하는 마지막값
				int last = Now;
				while(num>0&&Now>0) {
					//현위치 감소
					Now--;
					//0보다 작다면
					if(Now<0) {
						//마지막 존재하는 값으로 이동
						Now=last;
						break;
					}
					//삭제되지 않았다면
					if(!IsDelete[Now]) {
						//지금위치를 마지막으로 지정하고
						last=Now;
						//횟수 감소
						num--;
					}
				}
			//아래로 이동
			}else if(cmd.charAt(0)=='D'){
				//마지막 존재값 기록
				int last = Now;
				//횟수를 모두 소모하거나 범위 내에 있다면
				while(num>0&&Now<N) {
					//현재값 증가
					Now++;
					//범위를 넘어선다면
					if(Now>=N) {
						//현재값을 마지막값으로 이동
						Now=last;
						break;
					}
					//만약 지워지지 않은 값이라면
					if(!IsDelete[Now]) {
						//마지막 존재 값 기록
						last=Now;
						//횟수 감소
						num--;
					}
				}
				//현재 위치가 지워졌다면
				if(IsDelete[Now]) {
					//한칸 위로 실행
					cmd("U 1");
				}
			}
	
		}
		
	}
	
	public static String solution1(int n, int k, String[] cmds) {
		IsDelete=new boolean[n];
		Now=k;
		N=n;
		StringBuilder answer=new StringBuilder();
		for(String cmd:cmds) {
			cmd(cmd);
		}
		for(boolean del:IsDelete) {
			if(del) answer.append("X");
			else answer.append("O");
		}
		return answer.toString();
	}
	
	//해결법 2 서로 연결된 node를 이용함
	static Stack<Node> Undo = new Stack<>();

	static class Node{
		int no; //번호
		Node prev, next; //이전, 다음 값
		public Node(int no) {
			this.no=no;
			prev=null;
			next=null;
		}
	}
	
    public static String solution(int n, int k, String[] cmds) {
    	//처음 노드 설정
    	Node root = new Node(0);
    	//현재 노드
    	Node now = root;
    	for(int i=1;i<n;i++) {
    		Node node=new Node(i);
    		now.next=node;
    		node.prev=now;
    		now=node;
    	}
    	//마지막 노드 설정
    	Node tail = now;
    	tail.next = root; 
    	root.prev= now;
    	
    	now=root;
    	
    	//시작 노드 설정
    	while(now.no!=k) {
    		now=now.next;
    	}
    	
    	for(String cmd:cmds) {
    		//실행 취소시
    		if(cmd.charAt(0)=='Z') {
    			Node undo = Undo.pop();
    			undo.prev.next=undo;
    			undo.next.prev=undo;
    			//루트, 꼬리 업데이트	
    			if(undo.no<root.no) root=undo;
    			else if(undo.no>tail.no) tail=undo;
    		//삭제시
    		}else if(cmd.charAt(0)=='C') {
    			now.prev.next=now.next;
    			now.next.prev=now.prev;
    			Undo.add(now);
    			//루트 삭제시
    			if(now == root) {
    				root=now.next;
    				now=root;
				//꼬리 삭제시
    			}else if(now==tail) {
    				tail=now.prev;
    				now=tail;
				//이 외의 경우 다음 노드가 현노드가 됨
    			}else {
    				now=now.next;
    			}
    		}else {
    			//이동 숫자
    			int num = Integer.parseInt(cmd.split(" ")[1]);
    			//위로 이동시 이전
    			if(cmd.charAt(0)=='U') {
    				while(num-->0) {
    					now=now.prev;
    				}
    				
    			//아래로 이동시 다음	
    			}else if(cmd.charAt(0)=='D'){
    				while(num-->0) {
    					now=now.next;
    				}
    			}
    	
    		}
    	}
    	StringBuilder answer = new StringBuilder();
    	now=root;
    	for(int i=0;i<n;i++) {
    		if(now.no==i) {
    			answer.append("O");
    			now=now.next;
    		}else answer.append("X");
    	}
        return answer.toString();
    }
	
	public static void main(String[] args) {
		int n = 8;
		int k = 2;
		String[] cmds={"D 2","C","U 3","C","D 4","C","U 2","Z","Z","U 1","C"};
		System.out.println(solution(n, k, cmds));
		
	}
}
