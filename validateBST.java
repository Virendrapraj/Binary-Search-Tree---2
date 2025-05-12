public class validateBST {

    static class Node{
        int data ;
        Node left;
        Node right;
        Node (int data){
            this.data = data;
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
    public static boolean ValidTree(Node root ,Node min ,Node max){
        if (root == null){
            return true;
        }
        if(min != null && root.data <= min.data){
            return false;
        } else if (max != null && root.data >= max.data){
            return false;
        }
        return ValidTree(root.left,min,root)&& ValidTree(root.right ,root,max);
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
        if (ValidTree(root,null,null)){
            System.out.println("Valida");
        }
        else{
            System.out.println("Not valida");
        }
    }

}
