/**
 * The Node of Binary Search Tree
 */

public class Node {
    Node left, right;
    Word word;
    
    public Node(String word) {
        this.word = new Word(word);
    }

    public Word getWord() {
        return word;
    }

    public void setWord(Word word) {
        this.word = word;
    }

    public Node getLeft() {
        return left;
    }

    public void setLeft(Node left) {
        this.left = left;
    }

    public Node getRight() {
        return right;
    }

    public void setRight(Node right) {
        this.right = right;
    }

    /**
     * Compare the word from 2 different node.
     * 1st Node : current node (this class Node)
     * 2nd Node : other node/new node (parameter Node)
     */
    public int compareTo(Node node) {
        return this.word.compareWord(node.getWord().getWord());
    }

    @Override 
    public String toString() {
        return String.format("%s", word);
    }
}