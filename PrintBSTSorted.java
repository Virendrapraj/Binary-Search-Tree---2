import com.sun.source.tree.ArrayAccessTree;

import java.util.ArrayList;

public class PrintBSTSorted {
    static class Node{
        int data;
        Node left;
        Node right;
        Node(int data){
            this.data =data;
        }
    }
    public static void GetInorder(Node root , ArrayList<Integer> list){
        if (root == null){
            return;
        }
        GetInorder(root.left,list);
        list.add(root.data);
        GetInorder(root.right,list);
    }
    public static Node NewBst(ArrayList<Integer> list ,int st , int ed){
        if (st> ed){
            return null;
        }
        int mid =( st + ed)/2;
        Node root = new Node(list.get(mid));
        root.left =  NewBst(list ,st,mid-1);
        root.right = NewBst(list,mid+1,ed);
        return root;
    }
    public static Node BSTPrint(Node root){
        ArrayList<Integer>  inorder = new ArrayList<>();
        GetInorder(root , inorder);
        root = NewBst(inorder , 0 , inorder.size()-1);
        return root;

    }
    public static void main(String args []){
        Node root = new Node (8);
        root.left  = new Node(6);
        root.left.left = new Node(5);
        root.left.left.left = new Node (3);
        root.right = new Node(10);
        root.right.right = new Node(11);
        root.right.right.right = new Node(12);
        BSTPrint(root);
    }
}
