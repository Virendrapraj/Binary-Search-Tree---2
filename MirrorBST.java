public class MirrorBST {
    static class Node {
        int data;
        Node left;
       Node right;
        Node(int data){
            this.data = data;
        }
    }
    public static Node Mirror(Node root){
        if (root == null){
            return null;
        }
        Node leftside = Mirror(root.left);
        Node rightside = Mirror(root.right);
         root.left = rightside;
         root.right = leftside;
         return root;
    }
    public static void Preorder(Node root){
        if (root == null){
            return;
        }
        System.out.print(root.data +" ");

        Preorder(root.left);
        Preorder(root.right);
    }

    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.left = new Node(6);
        root.right.right = new Node(7);
        Preorder(root);
        System.out.println();
        Mirror(root);
        Preorder(root);
    }
}
