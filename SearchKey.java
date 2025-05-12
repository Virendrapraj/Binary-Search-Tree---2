import javax.naming.directory.SearchControls;

public class SearchKey {
    static  class Node {
        int data;
        Node left;
        Node right;
        Node (int data){
            this.data = data;
        }
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
    public static boolean Search(Node root , int key){
        if(root == null){
            return false;
        }
        if (root.data == key){
            return  true;
        }
        if (root.data > key){
           return Search(root.left ,key);
        }else{
          return Search(root.right ,key);
        }
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
        int arr[] = {1,3,5,4,8,9,2,7};
        Node root = null;
        for (int i = 0;i< arr.length;i++){
            root = insert(root,arr[i]);
        }
        inorder(root);
        System.out.println();
        if (Search(root,7)){
            System.out.println("Key Found");
        }else{
            System.out.println("Not Found");
        }
    }
}
