package trydelete1;

import java.util.LinkedList;
import java.util.Queue;

public class BinaryTree<E> {
	
	TreeNode<E> root;
	
	//mightneed to be in treenode class
	BinaryTree<E> leftChild;
	
	private void preOrder(TreeNode<E> node)
	{
		if(node != null)
		{
			node.visit();
			preOrder(node.getLeftChild());
			preOrder(node.getRightChild());
		}
	}
	public void preOrder()
	{
		this.preOrder(root);
	}
	
	public void levelORder(){
		Queue<TreeNode<E> > q = new LinkedList< TreeNode<E>>();
		q.add(root);
		while(!q.isEmpty()){
			TreeNode<E> curr = q.remove();
			if(curr != null){
				curr.visit();
				q.add(curr.getLeftChild());
				q.add(curr.getRightChild());
			}
		}
	}
	

	

}
