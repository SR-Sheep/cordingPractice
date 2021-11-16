package 프로그래머스;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class 카카오_길찾기게임 {
	
	static List<Integer> Pre;
	static List<Integer> Post;
	
	static class Node {
		private int x,y, num;
		private Node left;
		private Node right;

		public Node(int x,int y, int idx) {
			this.x = x;
			this.num = idx;
			this.left = null;
			this.right = null;
		}

	}

	static class BinarySearchTree{
		Node root = null;
		
		public void insertNode(int x, int y, int idx) {
			if(root == null) {
				root = new Node(x,y,idx);
			}else {
				Node head = root;
				Node currNode;
				while(true) {
					currNode=head;
					//루트보다 작으면 왼쪽 탐색
					if(head.x>x) {
						head = head.left;
						//왼쪽이 비었으면 생성후 종료
						if(head==null) {
							currNode.left=new Node(x,y,idx);
							break;
						}
					//루트보다 크면 오른쪽 탐색
					}else {
						head=head.right;
						//오른쪽 비었으면 생성후 종료
						if(head==null) {
							currNode.right=new Node(x,y,idx);
							break;
						}
						
					}
						
				}
				
			}
			
		}
			
		//후위
		public void postorder(Node root) {
			if(root!=null) {
				postorder(root.left);
				postorder(root.right);
				Post.add(root.num);
			}
		}
		
		//전위
		public void preorder(Node root) {
			if(root!=null) {
				Pre.add(root.num);
				preorder(root.left);
				preorder(root.right);
			}
		}
	}
	
	
    public static int[][] solution(int[][] nodeinfo) {
        Pre = new ArrayList<Integer>();
    	Post = new ArrayList<Integer>();
    	BinarySearchTree tree = new BinarySearchTree();
    	int[][] newInfo = new int[nodeinfo.length][3];
    	for(int i=0;i<newInfo.length;i++) {
    		newInfo[i][0]=nodeinfo[i][0];
    		newInfo[i][1]=nodeinfo[i][1];
    		newInfo[i][2]=i+1;
    	}
    	Arrays.sort(newInfo, new Comparator<int[]>() {
    		@Override
    		public int compare(int[] o1, int[] o2) {
    			if(o1[1]<o2[1]) return 1;
    			else if(o1[1]>o2[1]) return -1;
    			return 0;
    		}
    	});
    	for(int[] i:newInfo) tree.insertNode(i[0], i[1], i[2]);
    	tree.postorder(tree.root);
    	tree.preorder(tree.root);
    	int[][] answer = new int[Pre.size()][Pre.size()];
    	for(int i=0;i<Pre.size();i++) {
    		answer[i][0]=Pre.get(i);
    		answer[i][1]=Post.get(i);
    	}
        return answer;
    }
	public static void main(String[] args) {
		int[][] nodeinfo = {{5,3},{11,5},{13,3},{3,5},{6,1},{1,3},{8,6},{7,2},{2,2}};
		for(int[] arr:solution(nodeinfo)) {
			for(int i:arr) System.out.print(i+" ");
			System.out.println();
		};
	}
}
