package trydelete1;

public class TreeNode<E> {
	private E value;
	private TreeNode<E> parent;
	private TreeNode<E> left;
	private TreeNode<E> right;
	
	private TreeNode<E> testroot;
	
	public TreeNode(E val, TreeNode<E> par)
	{
		this.value = val;
		this.parent = par;
		this.left = null;
		this.right = null;
	}
	
	public TreeNode() {
		this.testroot = null;
	}
	
	public TreeNode<E> addLeftChild(E val)
	{
		this.left = new TreeNode<E>(val, this);
		return this.left;
	}
	
	//methods below are my own that I made up!
	
	public TreeNode<E> getLeftChild(){
		this.left = new TreeNode<E>();
		return this.left;
	}
	
	public TreeNode<E> getRightChild(){
		this.right = new TreeNode<E>();
		return this.right;
	}
	
	public E visit(){
		this.value = null;
		return this.value;
	}
	
	//came up with this empty() method on my own
	//could be used to check if tree is empty or something..
	public boolean empty(TreeNode<E> node)
	{
		if(node != null)
		{
			return false;
		}
		return true;
	}

}
