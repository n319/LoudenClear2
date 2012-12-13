import java.util.ArrayList;


public class TreeNode {
	private ArrayList<TreeNode> children;
	private String name; 
	private ArrayList<String> args;
	
	public TreeNode(){
		name = null;
		children = new ArrayList<TreeNode>();
		args = new ArrayList<String>();
	}
	
	public TreeNode(String s){
		name = s;
		children = new ArrayList<TreeNode>();
		args = new ArrayList<String>();
	}
	
	public void setName(String n){
		name = n;
	}
	
	public String getName(){
		return this.name;
	}
	
	public void addChild(TreeNode c){
		children.add(c);
	}
	
	public TreeNode getChild(int i){
		if(i < children.size())
			return children.get(i);
		else
			return null;
	}
	
	public int getSize(){
		return children.size();
	}
	
	public void addArg(String s){
		args.add(s);
	}
	
	public String getArg(int i){
		if(i < args.size())
			return args.get(i);
		return null;
	}
}
