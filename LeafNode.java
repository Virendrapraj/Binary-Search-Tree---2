import  java.util.*;
public class LeafNode {
    static class Node {
        int data;
        Node left;
        Node right;
        Node(int data){
            this.data = data;
        }
    }

    public static void Printpath(ArrayList<Integer> list) {
        for (int i =0 ;i< list.size();i++){
            System.out.print(list.get(i)+" -> ");
        }
        System.out.println("Null");

    }
    public static Node insert(Node root , int val){
        if(root == null){
            root = new Node(val);
            return root;
        }

        if (root.data > val){
            root.left = insert(root.left , val);
        }else {
            root.right = insert( root.right ,val);
        }
        return root;
    }
    public static void PrintLeavPath(Node root ,ArrayList<Integer> list){
        if (root == null){
            return;
        }
        list.add(root.data);
        if (root.left == null && root.right == null){
            Printpath(list);
        }
        PrintLeavPath(root.left,list);
        PrintLeavPath(root.right,list);
        list.remove(list.size()-1);
    }
    public static void inorder(Node root){
        if(root == null){
            return;
        }
        inorder(root.left );
        System.out.print(root.data+" ");
        inorder(root.right);

    }
    public static void main(String[] args) {
        int value[] = {5,4,3,2,6,1,8};
        Node root = null;
        for (int i =  0;i< value.length;i++){
            root = insert(root,value[i]);
        }
        System.out.println();
        inorder(root);
        System.out.println();
        PrintLeavPath(root,new ArrayList<Integer>());
        inorder(root);
    }
}
