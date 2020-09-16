/**
 * Main Driver Class
 * <p>Note: in this Word List, contractions are seperated into 2 whole words.</p>
 * 
 * @authors: Christopher Lim
 *           Ivan Jerwin Lim
 *           James Matthew Sy
 */

import java.io.File;
import java.io.IOException;
import java.util.Scanner;
import java.io.PrintStream;

class Main {
  public static void main(String[] args) throws IOException {
    // asks for user input for the filename
    Scanner scanner = new Scanner(System.in);
    String inputFilename;
    File inputFile;
    // accepts only for the correct filename (which exists)
    do {
        System.out.print("Input filename: ");
        inputFilename = scanner.nextLine();
        inputFile = new File("./inputs/" + inputFilename);
        if(!inputFile.exists()) System.err.println(String.format("%s not found...", inputFilename));
    } while(!inputFile.exists());

    BinarySearchTree BST = new BinarySearchTree();

    Scanner sc = new Scanner(inputFile);
    // loops ever line of the File
    while (sc.hasNextLine()){
      String line = sc.nextLine();
      // converts it into lowercase
      line = line.toLowerCase();
      // format word shortcuts/contractions into the whole seperated words
      line = line.replaceAll("'ll", " will");
      line = line.replaceAll("'re", " are");
      line = line.replaceAll("'m", " am");
      line = line.replaceAll("n't", " not");
      line = line.replaceAll("'s", " is");
      line = line.replaceAll("'ve", " have");
      line = line.replaceAll("'d", " would");
      // replace all symbol with a space
      line = line.replaceAll("[^a-z]", " ");

      // loop every word
      for(String str : line.split("\\s")) {
        if(str.length() >= 3) BST.insertWord(str);
      }
    }
    
    // searches words to prove search is working
    // System.out.println(BST.searchWord("hello"));
    // System.out.println(BST.searchWord("how"));
    // System.out.println(BST.searchWord("why"));
    
    // from this point, all System.out.println will be printed to the output file
    System.out.println("Output will be found at ./outputs/" + inputFilename);
    File outputFile = new File("./outputs/" + inputFilename);
    outputFile.createNewFile();
    // https://www.tutorialspoint.com/redirecting-system-out-println-output-to-a-file-in-java
    PrintStream stream = new PrintStream(outputFile);
    System.setOut(stream);
    // shows the alphabetically-ordered words
    BST.inorder(BST.getRoot());

    // destroys the BST then shows it's inorder traversal
    // to show that destroying the BST works.
    // BST.destroy();
    // BST.inorder(BST.getRoot());
  }
}