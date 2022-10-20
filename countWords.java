import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Scanner;

public class countWords {
    public static HashMap<String, Integer> readFileToArray(String fileName) {
        try {
            File file = new File(fileName);
            Scanner scanner = new Scanner(file);
            HashMap<String, Integer> hashMap = new HashMap();
            while (scanner.hasNextLine()) {
                String str = scanner.nextLine();
                if (hashMap.containsKey(str)) {
                    hashMap.put(str, hashMap.get(str) + 1);
                } else {
                    hashMap.put(str, 1);
                }
            }

            scanner.close();
            return hashMap;

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static void writeArrayToFile(HashMap<String, Integer> hashMap , String fileName) throws Exception {
        try {
            FileWriter writer = new FileWriter(fileName);
            for (HashMap.Entry<String, Integer> entry : hashMap.entrySet()) {
                writer.write(entry.getKey() + ": "+ entry.getValue() + "\n");
            }
            writer.close();
        } catch (IOException e) {
            System.out.println("Encountered IO Exception");
            e.printStackTrace();
        }
    }

    public static void main(String[] args) throws Exception {
        
        HashMap<String, Integer> hashMap = new HashMap<>();
        hashMap = readFileToArray("words.txt");
        writeArrayToFile(hashMap, "output.txt");
    }
}