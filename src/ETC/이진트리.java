package ETC;

public class 이진트리 {
	
	static class Node{
		private int data;
		private Node left;
		private Node right;
		
		public Node(int data) {
			this.data = data;
			this.left=null;
			this.right=null;
		}

		public int getData() {
			return data;
		}

		public void setData(int data) {
			this.data = data;
		}

		public Node getLeft() {
			return left;
		}

		public void setLeft(Node left) {
			this.left = left;
		}

		public Node getRight() {
			return right;
		}

		public void setRight(Node right) {
			this.right = right;
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
					//루트보다 작으면 왼쪽 탐색
					if(head.data>ele) {
						head = head.left;
						//왼쪽이 비었으면 생성후 종료
						if(head==null) {
							currNode.left=new Node(ele);
							break;
						}
					//루트보다 크면 오른쪽 탐색
					}else {
						head=head.right;
						//오른쪽 비었으면 생성후 종료
						if(head==null) {
							currNode.right=new Node(ele);
							break;
						}
						
					}
						
				}
				
			}
			
		}
		
		//노드 삭제
		public boolean removeNode(int ele) {
			Node remove = root;
			Node parent=null;
			
			while(remove.data != ele) {
				parent=remove;
				//삭제할 값이 작으면 왼쪽 탐색
				if(remove.data<ele) {
					remove = remove.left;
				} else {
					remove=remove.right;
				}
				if(remove==null) {
					return false;
				}
			}//while end
			
			//자식이 없으면
			if(remove.left==null&&remove.right==null) {
				//삭제 대상이 루트라면
				if(remove==root) {
					root=null;
				} else if(remove==parent.left) {
					parent.left=null;
				} else {
					parent.right=null;
				}
			//오른쪽 자식만 있을때
			}else if(remove.left==null) {
				//삭제 대상이 루트라면
				if(remove==root) {
					//오른쪽이 이제부터 루트다!
					root=remove.right;
				//삭제 대상이 부모의 오른팔이라면
				} else if(remove==parent.right) {
					//남은 자식도 오른팔
					parent.right=remove.right;
				//삭제 대상이 부모의 왼팔이라면
				} else {
					//남은 자식은 왼팔
					parent.left=remove.right;
				}
			//왼쪽 자식만 있을때
			} else if(remove.right==null) {
				//삭제 대상이 루트라면
				if(remove==root) {
					//왼쪽이 이제부터 루트다!
					root=remove.left;
				//삭제 대상이 부모의 왼팔이라면
				} else if(remove==parent.left) {
					//남은 자식도 왼팔
					parent.left=remove.left;
				//삭제 대상이 부모의 오른팔이라면
				} else {
					//남은 자식은 부모의 오른팔
					parent.right=remove.left;
				}
			//둘 다 존재 시 왼쪽의 가장 큰값을 올리거나, 오른쪽의 가장 작은 값을 올림
			}else {
				//대체 부모
				Node parentReplace = remove;
				//대체 노드(오른쪽)
				Node replace = remove.right;
				
				//왼쪽 자식이 없을때까지 (왼쪽 최소값)
				while(replace.left==null) {
					parentReplace = replace;
					replace=replace.left;
				}
				//왼쪽 최소값으로 변경되었다면
				if(replace != remove.right) {
					//대체 노드 부모의 왼쪽은 빈값 (가장 작은 값이므로)
					parentReplace.left=replace.right; //
					//대체 노드의 오른쪽 자식은 삭제할 노드의 오른쪽
					replace.right=remove.right;
				}
				//만약 루트로드 삭제라면
				if(remove==root) {
					root=replace;
				//삭제하려는 노드가 부모의 오른쪽이라면
				} else if(remove==parent.right) {
					parentReplace.right = replace;
				//삭제하려는 노드가 부모의 왼쪽이라면
				} else {
					parentReplace.left=replace;
				}
			}
			return true;
			
		}//removeNode() end
		
		//중위
		public void inorder(Node root, int depth) {
			if(root!=null) {
				System.out.print("(");
				inorder(root.left, depth+1);
//				for(int i=0;i<depth;i++) System.out.print("■");
				System.out.print(root.data);
				inorder(root.right, depth+1);
				System.out.print(")");
			}
		}
		//후위
		public void postorder(Node root, int depth) {
			if(root!=null) {
				System.out.print("(");
				postorder(root.left, depth+1);
				postorder(root.right, depth+1);
				System.out.print(root.data+")");
			}
		}
		
		//전위
		public void preorder(Node root, int depth) {
			if(root!=null) {
				//for(int i=0;i<depth;i++) System.out.print("ㄴ");
				System.out.print("("+root.data);
				preorder(root.left, depth+1);
				preorder(root.right, depth+1);
				System.out.print(")");
			}
		}
	}
	
	
	public static void main(String[] args) {
		
		BinarySearchTree tree = new BinarySearchTree();
		tree.insertNode(1);
		tree.insertNode(2);
		tree.insertNode(3);
		tree.insertNode(4);
		tree.insertNode(5);
		tree.insertNode(6);
		tree.insertNode(8);
		tree.insertNode(7);
		
		tree.preorder(tree.root, 0);
		System.out.println();
		tree.inorder(tree.root, 0);
		System.out.println();
		tree.postorder(tree.root, 0);
		
	}
	

}
