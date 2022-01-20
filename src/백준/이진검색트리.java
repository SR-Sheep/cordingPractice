package 백준;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 이진검색트리 {
	//https://www.acmicpc.net/problem/5639
	static StringBuilder Sb;
	
	static class Node{
		int no;
		Node left,right;
		
		public Node(int no) {
			this.no = no;
			left = null;
			right = null;		
		}
	}
	
	static class BinarySearchTree{
		Node root = null;
		
		public void insertNode(int ele) {
			if(root == null) {
				root = new Node(ele);
			}else {
				Node head = root;
				Node currNode;
				
				while(true) {
					currNode=head;
					//헤드보다 값이 작다면 left
					if(head.no>ele) {
						head = head.left;
						//만약 left가 비어있다면
						if(head==null) {
							//현재 노드의 왼쪽에 생성
							currNode.left=new Node(ele);
							break;
						}
					//헤드보다 값이 크다면 right
					}else {
						head=head.right;
						//만약 right가 비어있다면
						if(head==null) {
							//현재 노드의 right에 생성
							currNode.right=new Node(ele);
							break;
						}
					}
				}
			}
		}
		//후위 순회로 출력
		public void postorder(Node root) {
			if(root!=null) {
				postorder(root.left);
				postorder(root.right);
				Sb.append(root.no+"\n");
			}
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BinarySearchTree tree = new BinarySearchTree();
		Sb=new StringBuilder();
		while(true) {
			try {
				tree.insertNode(Integer.parseInt(br.readLine()));
			} catch (Exception e) {
				break;
			}
		}
		tree.postorder(tree.root);
		System.out.println(Sb);
		br.close();
	}
}
