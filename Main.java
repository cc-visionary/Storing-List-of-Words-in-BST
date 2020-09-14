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
        // loop every word
        for(String str : line.split("\\s")) {
            // format the string to make it into lower case
            // then remove all symbols
            String formattedString = str.toLowerCase().replaceAll("[^a-z]", "");
            if(formattedString.length() >= 3) BST.insertWord(formattedString);
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