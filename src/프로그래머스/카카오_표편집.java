package ���α׷��ӽ�;

import java.util.*;

public class īī��_ǥ���� {
	
	//https://programmers.co.kr/learn/courses/30/lessons/81303
	
	
	//�ذ�� 1, ��Ȯ���� ����ϳ� ȿ�������� 50%�� �����
	static boolean[] IsDelete;
	static int Now,N;
	static Stack<Integer> Undo1 = new Stack<Integer>();
	static List<Node> Table;
	
	public static void cmd(String cmd) {
		//�������
		if(cmd.charAt(0)=='Z') {
			IsDelete[Undo1.pop()]=false;
		//����
		}else if(cmd.charAt(0)=='C') {
			IsDelete[Now]=true;
			//���ÿ� �߰�
			Undo1.add(Now);
			//��ĭ �Ʒ��� �̵�
			cmd("D 1");
		}else {
			//�̵���
			int num = Integer.parseInt(cmd.split(" ")[1]);
			//���� �̵�
			if(cmd.charAt(0)=='U') {
				//�����ϴ� ��������
				int last = Now;
				while(num>0&&Now>0) {
					//����ġ ����
					Now--;
					//0���� �۴ٸ�
					if(Now<0) {
						//������ �����ϴ� ������ �̵�
						Now=last;
						break;
					}
					//�������� �ʾҴٸ�
					if(!IsDelete[Now]) {
						//������ġ�� ���������� �����ϰ�
						last=Now;
						//Ƚ�� ����
						num--;
					}
				}
			//�Ʒ��� �̵�
			}else if(cmd.charAt(0)=='D'){
				//������ ���簪 ���
				int last = Now;
				//Ƚ���� ��� �Ҹ��ϰų� ���� ���� �ִٸ�
				while(num>0&&Now<N) {
					//���簪 ����
					Now++;
					//������ �Ѿ�ٸ�
					if(Now>=N) {
						//���簪�� ������������ �̵�
						Now=last;
						break;
					}
					//���� �������� ���� ���̶��
					if(!IsDelete[Now]) {
						//������ ���� �� ���
						last=Now;
						//Ƚ�� ����
						num--;
					}
				}
				//���� ��ġ�� �������ٸ�
				if(IsDelete[Now]) {
					//��ĭ ���� ����
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
	
	//�ذ�� 2 ���� ����� node�� �̿���
	static Stack<Node> Undo = new Stack<>();

	static class Node{
		int no; //��ȣ
		Node prev, next; //����, ���� ��
		public Node(int no) {
			this.no=no;
			prev=null;
			next=null;
		}
	}
	
    public static String solution(int n, int k, String[] cmds) {
    	//ó�� ��� ����
    	Node root = new Node(0);
    	//���� ���
    	Node now = root;
    	for(int i=1;i<n;i++) {
    		Node node=new Node(i);
    		now.next=node;
    		node.prev=now;
    		now=node;
    	}
    	//������ ��� ����
    	Node tail = now;
    	tail.next = root; 
    	root.prev= now;
    	
    	now=root;
    	
    	//���� ��� ����
    	while(now.no!=k) {
    		now=now.next;
    	}
    	
    	for(String cmd:cmds) {
    		//���� ��ҽ�
    		if(cmd.charAt(0)=='Z') {
    			Node undo = Undo.pop();
    			undo.prev.next=undo;
    			undo.next.prev=undo;
    			//��Ʈ, ���� ������Ʈ	
    			if(undo.no<root.no) root=undo;
    			else if(undo.no>tail.no) tail=undo;
    		//������
    		}else if(cmd.charAt(0)=='C') {
    			now.prev.next=now.next;
    			now.next.prev=now.prev;
    			Undo.add(now);
    			//��Ʈ ������
    			if(now == root) {
    				root=now.next;
    				now=root;
				//���� ������
    			}else if(now==tail) {
    				tail=now.prev;
    				now=tail;
				//�� ���� ��� ���� ��尡 ����尡 ��
    			}else {
    				now=now.next;
    			}
    		}else {
    			//�̵� ����
    			int num = Integer.parseInt(cmd.split(" ")[1]);
    			//���� �̵��� ����
    			if(cmd.charAt(0)=='U') {
    				while(num-->0) {
    					now=now.prev;
    				}
    				
    			//�Ʒ��� �̵��� ����	
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
