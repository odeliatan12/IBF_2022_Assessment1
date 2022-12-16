package mailMerge;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main{
    public static void main(String[] args) throws IOException {
        
        // Read the file
        BufferedReader reader = null;
        BufferedReader writer = null;
        List<Map<String, String>> data = new ArrayList<>();


        try {
            reader = new BufferedReader(new FileReader(args[0]));
            writer = new BufferedReader(new FileReader("thankyou.txt"));
            

            // Reading the file line by line
            String line;
            String templatereader;
            // Read the first line to get the header
            String firstline = reader.readLine();
            String[] headers = firstline.split(",");
            while ((line = reader.readLine())!= null) {

                
                // Splitting the line
                String[] splitline = line.split(",");

                line = line.replace("\n", "System.out.printf('\n')");

                Map<String, String> record = new HashMap<>();
                for (int i = 0; i < splitline.length; i++) {
                    record.put(headers[i], splitline[i]);
                }
                data.add(record);

                System.out.println(record);



                // Read the txt file line by line
                while ((templatereader = writer.readLine()) != null) {
                    // Reiterating through the values
                    // Replace all <<occurrences>> with "the corresponding values"

                    // Defining the pattern
                    Pattern pattern = Pattern.compile("\\<\\<(\\w+)\\>\\>");
                    
                    // Create a Matcher object
                    Matcher matcher = pattern.matcher(templatereader);

                    // Find all occurrences of the pattern in the input string
                    while (matcher.find()) {
                        // Get the matched string
                        String matchedString = matcher.group();
                        
                        // Get the value of the first capture group (the key)
                        String key = matcher.group(1);
                        
                        String value = record.get(key);
                        // Print the matched string and the key
                        
                        System.out.println(matchedString + " -> " + key);
                    }
                    
                    templatereader = templatereader.replace("<<address>>", record.get("address"));
                    templatereader = templatereader.replace("<<first_name>>", record.get("first_name"));
                    templatereader = templatereader.replace("<<years>>", record.get("years"));
                    
                    // for (int i = 0; i < 1; i++) {
                    //     // Print the modified line to the console
                    //     System.out.println(templatereader);
                    // }
                    String[] emails = templatereader.toString().split("\n");

                    for(String email: emails) {
                        System.out.println(email);
                    }

                    
                }

            }
            reader.close();

        } catch (FileNotFoundException e) {
            // TODO: handle exception
            System.out.println(">>> error: File not found");
        } catch (IOException e) {
            // TODO: handle exception
            System.out.println(">>> error: IO error");
        }

        
        
    }

}