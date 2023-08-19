import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class Word_Counter {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("Enter a text or provide a file path to count words: ");
        String userInput = scanner.nextLine();
        
        String text = "";
        try {
            text = readTextFromFile(userInput);
        } catch (Exception e) {
            text = userInput;
        }
        
        text = text.toLowerCase().replaceAll("[\\p{Punct}]", "");
        String[] words = text.split("\\s+");
        
        int wordCount = words.length;
        System.out.println("Total words: " + wordCount);
        
        // Count frequency of each word and display
        Map<String, Integer> wordFrequency = new HashMap<>();
        for (String word : words) {
            wordFrequency.put(word, wordFrequency.getOrDefault(word, 0) + 1);
        }
        
        System.out.println("Word frequency:");
        wordFrequency.forEach((word, frequency) -> System.out.println(word + ": " + frequency));
        
        scanner.close();
    }
    
    public static String readTextFromFile(String filePath) throws Exception {
        // Implementation for reading from a file (similar to the previous code)
        StringBuilder text = new StringBuilder();
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                text.append(line).append("\n");
            }
        }
        return text.toString();
    }
    
    // ... Other methods ...
}

