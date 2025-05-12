public class Renge {
    static class Node{
        int data;
        Node left;
        Node right;
        Node (int data){
            this.data = data;
        }
    }
    public static Node insertvalue(Node root ,int val){
        if (root == null){
            return new Node(val);
        }
        if (root.data > val){
            root.left = insertvalue(root.left ,val);
        }else{
            root.right = insertvalue(root.right ,val);
        }
        return root;
    }
    public static void PrintRenge(Node root , int k1 ,int k2){
        if (root == null){
            return;
        }
        if (root.data >= k1 && root.data <= k2){
            PrintRenge(root.left ,k1,k2);
            System.out.print(root.data+" ");
            PrintRenge(root.right,k1,k2);
        }
        else if (root.data < k1) {
           PrintRenge(root.right,k1,k2);
        }else {
            PrintRenge(root.left,k1,k2);
        }
    }
    public static void inorder(Node root){
        if (root == null){
            return;
        }
        inorder(root.left);
        System.out.print(root.data+" ");
        inorder(root.right);
    }

    public static void main(String[] args) {
        int arr[] = {1,2,3,4,5,6,7,8,9};
       Node root = null;
        for (int i =0;i< arr.length;i++){
            root = insertvalue(root,arr[i]);
        }
        inorder(root);
        System.out.println();

        PrintRenge(root,5,12);


    }
}
