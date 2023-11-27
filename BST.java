public class BST <T extends Comparable<T>> {
    // fields
    Node<T> root;

    // methods
    // search
    public Node<T> find(T valueSearchedFor){
        Node<T> finger = root; // finger starts at the root

        while(finger != null){
        if(finger.value.equals(valueSearchedFor)){ // value at finger equals the value searching for return
            return finger;
        } else if(valueSearchedFor.compareTo(finger.value) < 0){ // go left
                finger = finger.left;
            } else {
                finger = finger.right;
            }
        }
        // you get here if the tree does not contain the value searched for
        return null;
    }
    
    //insert
    public Node<T> insert(T valueToAdd){
        Node<T> finger = root; // finger starts at root

        if(isEmpty()){
            return root = new Node<T>(valueToAdd);
        } else {
             finger = root;

            while(true){
                if(valueToAdd.compareTo(finger.value) <= 0){
                    // check if there is a left
                    if(finger.left!=null){
                        finger = finger.left;
                    } else {
                        // if no left, new node is linked in there
                        Node<T> newNode = new Node(valueToAdd);
                        finger.left = newNode;
                        return newNode;
                    }
                } else {
                    // check if there is a right
                    if(finger.right!=null){
                        finger = finger.right;
                    } else {
                        Node<T> newNode = new Node(valueToAdd);
                        finger.right = newNode;
                        return newNode;
                    }
                }
            }
        }
    }
    // traversal
    //inorder LNR
    public void inOrder(){
        inOrderHelper(root);
    }
    public void inOrderHelper(Node<T> finger){
        if(finger == null){
            return;
        }
        inOrderHelper(finger.left); //L - visit the entire left subtree
        System.out.print(finger.value + ", "); // N - visit the current node
        inOrderHelper(finger.right); // R - visit right subtree
    }
    //preorder NLR
        public void preOrder(){
        preOrderHelper(root);
    }
    public void preOrderHelper(Node<T> finger){
        if(finger == null){
            return;
        }
        //L - visit the entire left subtree
        System.out.print(finger.value + ", ");
        inOrderHelper(finger.left); // N - visit the current node
        inOrderHelper(finger.right); // R - visit right subtree
    }
    //postorder LRN
        public void postOrder(){
        postOrderHelper(root);
    }
    public void postOrderHelper(Node<T> finger){
        if(finger == null){
            return;
        }
        //L - visit the entire left subtree
        
        inOrderHelper(finger.left); // N - visit the current node
        inOrderHelper(finger.right); // R - visit right subtree
        System.out.print(finger.value + ", ");
    }
    //isEmpty
    public boolean isEmpty(){
        return root == null;
    }
    //min/max
    public T max() throws Exception{
        Node<T> finger = root;
        if(isEmpty()){
            throw new Exception("no max found.");
        }
        while(finger.right!=null){
            finger = finger.right;
        }
        return finger.value;
    }

    //ctor(s)
}
