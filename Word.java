/**
 * stores the word and its count
 */

public class Word {
    private String word;
    private int wordCount;

    public Word(String word) {
        this.word = word;
        this.wordCount = 1;
    }

    /**
     * Increments word count
     */
    public void addWordCount() {
        this.wordCount++;
    }

    public String getWord() {
        return word;
    }

    public int getWordCount() {
        return wordCount;
    }

    public int compareWord(String word) {
        return this.word.compareTo(word);
    }

    @Override 
    public String toString() {
        return String.format("Word: %s, Count: %d", getWord(), getWordCount());
    }
} 