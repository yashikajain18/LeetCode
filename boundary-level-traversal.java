/************************************************************

    Following is the Binary Tree node structure:
    
   class TreeNode {
	    int data;
	    TreeNode left;
	    TreeNode right;

	    TreeNode(int data) {
		    this.data = data;
		    this.left = null;
		    this.right = null;
	    }

    }

************************************************************/

import java.util.ArrayList;

public class Solution {
    public static boolean isLeaf(TreeNode root){
        return (root.left==null)&& (root.right==null);
    }
    public static void left(TreeNode root, ArrayList<Integer> ans){
        TreeNode cur=root.left;
        while(cur!=null){
            if(!isLeaf(cur)) ans.add(cur.data);
            if(cur.left!=null)cur=cur.left;
            else cur=cur.right;
        }
    }
    public static void right(TreeNode root, ArrayList<Integer> ans){
        TreeNode cur=root.right;
        ArrayList<Integer> temp=new ArrayList<>();
        while(cur!=null){
            if(!isLeaf(cur)) temp.add(cur.data);
            if(cur.left!=null)cur=cur.right;
            else cur=cur.left;
        }
        for(int i=temp.size()-1; i>=0; i--){
            ans.add(temp.get(i));
        }
    }
    public static void leaf(TreeNode root, ArrayList<Integer> ans){
        if(isLeaf(root)){
            ans.add(root.data);
            return;
        }
        if (root.left != null) leaf(root.left, ans);
        if (root.right != null) leaf(root.right, ans);
    }
	public static void ArrayList<Integer> traverseBoundary(TreeNode root){
		// Write your code here.
        ArrayList <Integer> ans = new ArrayList<>();
        if (!isLeaf(root)) ans.add(root.data);
        left(root, ans);
        leaf(root, ans);
        right(root, ans);
        return ans;
	}
}