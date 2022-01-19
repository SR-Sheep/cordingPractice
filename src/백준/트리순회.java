package 백준;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 트리순회 {
//	https://www.acmicpc.net/problem/1991
	static Node[] Tree;
	static StringBuilder Sb;
	
	public static void preorder(Node node) {
		if(node==null) return;
		Sb.append(node.c);
		preorder(node.left);
		preorder(node.right);
	} 
	public static void inorder(Node node) {
		if(node==null) return;
		inorder(node.left);
		Sb.append(node.c);
		inorder(node.right);
	} 
	public static void postorder(Node node) {
		if(node==null) return;
		postorder(node.left);
		postorder(node.right);
		Sb.append(node.c);
	} 
	
	static class Node{
		char c;
		int idx;
		Node left,right;
		
		public Node(int charIdx) {
			this.c=(char)('A'+charIdx);
			this.left=null;
			this.right=null;
		}
		
		public void setChildren(char left, char right) {
			if(left!='.') {
				this.left=Tree[left-'A'];
			}
			if(right!='.') {
				this.right=Tree[right-'A'];
			}
		}
		
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		Tree=new Node[26];
		for(int i=0;i<26;i++) {
			Tree[i]=new Node(i);
		}
		int t = Integer.parseInt(br.readLine());
		StringTokenizer st;
		for(int i=0;i<t;i++) {
			st=new StringTokenizer(br.readLine());
			char c=st.nextToken().charAt(0);
			char left=st.nextToken().charAt(0);
			char right=st.nextToken().charAt(0);
			Tree[c-'A'].setChildren(left, right);
		}
		//전위 순회
		Sb= new StringBuilder();
		preorder(Tree[0]);
		System.out.println(Sb);
		//중위 순회
		Sb= new StringBuilder();
		inorder(Tree[0]);
		System.out.println(Sb);
		//후위 순회
		Sb= new StringBuilder();
		postorder(Tree[0]);
		System.out.println(Sb);
		br.close();
	}
}
