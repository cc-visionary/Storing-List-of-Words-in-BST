public class BinarySearchTree {
    Node root;

    public BinarySearchTree() {
        root = null;
    }
    
    public Node getRoot() {
        return root;
    }

    public void setRoot(Node root) {
        this.root = root;
    }
    
    /**
     * Inserts a Word to the BST
     * @param word word to be inserted
     */
    public void insertWord(String word) {
        insertNode(this.root, new Node(word));
    }

    /**
     * Inserts a Node to the BST
     * @param root    root node
     * @param newNode new node to be inserted
     */
    public void insertNode(Node root, Node newNode) {
        // if root is null, inserts a new Node
        if(this.root == null) this.root = newNode;
        else if(root.compareTo(newNode) > 0) {
            // if new word is less than current word and left node is empty,
            // assign the word on the left node
            if(root.getLeft() == null) root.setLeft(newNode);
            else insertNode(root.getLeft(), newNode);
        } else if(root.compareTo(newNode) < 0) {
            // if new word is greater than current word and right node is empty,
            // assign the word on the right node
            if(root.getRight() == null) root.setRight(newNode);
            else insertNode(root.getRight(), newNode);
        } 
        // if word is found, append it
        else root.getWord().addWordCount();
    }

    /**
     * Searches a word within the BST and checks if it exists or not 
     * @param word word to be searched
     * @return boolean value to determine if the word was found inside the BST or not
     */
    public boolean searchWord(String word) {
        return searchNode(this.root, word);
    }

    /**
     * Searches a target String from the BST
     * @param root   root of the BST
     * @param target target String to find
     * @return boolean value to determine if the word was found inside the BST or not
     */
    public boolean searchNode(Node root, String target) {
        if(root == null) {
            System.out.println("Node not found.");
            return false;
        } 
        
        // checks the left subtree
        if(root.getWord().compareWord(target) > 0) return searchNode(root.getLeft(), target);
        // checks the right subtree
        else if(root.getWord().getWord().compareTo(target) < 0) return searchNode(root.getRight(), target); 
        // found the node
        else {
            System.out.println("Found the Node: " + root);
            return true;
        }
    }

    public void inorder(Node root) {
        if(root != null) {
            inorder(root.getLeft());
            System.out.println(root.getWord());
            inorder(root.getRight());
        }
    }

    public void destroy() {
        root = null;
    }
}