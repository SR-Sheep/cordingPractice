package ETC;

public class ����Ʈ�� {
	
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
					//��Ʈ���� ������ ���� Ž��
					if(head.data>ele) {
						head = head.left;
						//������ ������� ������ ����
						if(head==null) {
							currNode.left=new Node(ele);
							break;
						}
					//��Ʈ���� ũ�� ������ Ž��
					}else {
						head=head.right;
						//������ ������� ������ ����
						if(head==null) {
							currNode.right=new Node(ele);
							break;
						}
						
					}
						
				}
				
			}
			
		}
		
		//��� ����
		public boolean removeNode(int ele) {
			Node remove = root;
			Node parent=null;
			
			while(remove.data != ele) {
				parent=remove;
				//������ ���� ������ ���� Ž��
				if(remove.data<ele) {
					remove = remove.left;
				} else {
					remove=remove.right;
				}
				if(remove==null) {
					return false;
				}
			}//while end
			
			//�ڽ��� ������
			if(remove.left==null&&remove.right==null) {
				//���� ����� ��Ʈ���
				if(remove==root) {
					root=null;
				} else if(remove==parent.left) {
					parent.left=null;
				} else {
					parent.right=null;
				}
			//������ �ڽĸ� ������
			}else if(remove.left==null) {
				//���� ����� ��Ʈ���
				if(remove==root) {
					//�������� �������� ��Ʈ��!
					root=remove.right;
				//���� ����� �θ��� �������̶��
				} else if(remove==parent.right) {
					//���� �ڽĵ� ������
					parent.right=remove.right;
				//���� ����� �θ��� �����̶��
				} else {
					//���� �ڽ��� ����
					parent.left=remove.right;
				}
			//���� �ڽĸ� ������
			} else if(remove.right==null) {
				//���� ����� ��Ʈ���
				if(remove==root) {
					//������ �������� ��Ʈ��!
					root=remove.left;
				//���� ����� �θ��� �����̶��
				} else if(remove==parent.left) {
					//���� �ڽĵ� ����
					parent.left=remove.left;
				//���� ����� �θ��� �������̶��
				} else {
					//���� �ڽ��� �θ��� ������
					parent.right=remove.left;
				}
			//�� �� ���� �� ������ ���� ū���� �ø��ų�, �������� ���� ���� ���� �ø�
			}else {
				//��ü �θ�
				Node parentReplace = remove;
				//��ü ���(������)
				Node replace = remove.right;
				
				//���� �ڽ��� ���������� (���� �ּҰ�)
				while(replace.left==null) {
					parentReplace = replace;
					replace=replace.left;
				}
				//���� �ּҰ����� ����Ǿ��ٸ�
				if(replace != remove.right) {
					//��ü ��� �θ��� ������ �� (���� ���� ���̹Ƿ�)
					parentReplace.left=replace.right; //
					//��ü ����� ������ �ڽ��� ������ ����� ������
					replace.right=remove.right;
				}
				//���� ��Ʈ�ε� �������
				if(remove==root) {
					root=replace;
				//�����Ϸ��� ��尡 �θ��� �������̶��
				} else if(remove==parent.right) {
					parentReplace.right = replace;
				//�����Ϸ��� ��尡 �θ��� �����̶��
				} else {
					parentReplace.left=replace;
				}
			}
			return true;
			
		}//removeNode() end
		
		//����
		public void inorder(Node root, int depth) {
			if(root!=null) {
				System.out.print("(");
				inorder(root.left, depth+1);
//				for(int i=0;i<depth;i++) System.out.print("��");
				System.out.print(root.data);
				inorder(root.right, depth+1);
				System.out.print(")");
			}
		}
		//����
		public void postorder(Node root, int depth) {
			if(root!=null) {
				System.out.print("(");
				postorder(root.left, depth+1);
				postorder(root.right, depth+1);
				System.out.print(root.data+")");
			}
		}
		
		//����
		public void preorder(Node root, int depth) {
			if(root!=null) {
				//for(int i=0;i<depth;i++) System.out.print("��");
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
