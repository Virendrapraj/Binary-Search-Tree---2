public class Delete {
    static  class Node{
        int data;
        Node left ;
        Node right;
        Node(int data){
            this.data = data;
        }
    }
    public static Node insertvalue(Node root,int key){
        if(root == null){
            return new Node(key);
        }
        if (root.data > key){
            root.left = insertvalue(root.left ,key);
        }else{
            root.right =   insertvalue(root.right ,key);
        }
        return root;
    }
    public static Node delete(Node root ,int val){
        if (root.data > val){
           root.left = delete(root.left,val);
        } else if(root.data < val) {
           root.right = delete(root.right,val);
        }else {
            if (root.left == null && root.right == null){
                return null;
            }
            if (root.left == null) {
                return root.right;
            } else if(root.right == null){
                return root.left;
            }
            Node is = Findsuccessor(root.right);
            root.data = is.data;
            root.right = delete(root.right , is.data);

        }
        return root;
    }
    public static void inorder(Node root){
        if (root == null){
            return;
        }
        inorder(root.left);
        System.out.print(root.data +" ");
        inorder(root.right);
    }
    public static Node Findsuccessor( Node root){
        while ( root.left != null){
            root = root.left;
        }
        return root;
    }

    public static void main(String[] args) {
        int arr[] = {1,2,3,4,5,6,7,8,9};
        Node root = null;
        for (int i =0;i< arr.length;i++){
            root = insertvalue(root,arr[i]);
        }
        inorder(root);
        System.out.println();
        root = delete(root,5);
        System.out.println();
        inorder(root);
    }
}
