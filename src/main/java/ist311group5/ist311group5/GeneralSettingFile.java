package ist311group5.ist311group5;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


public class GeneralSettingFile extends Account{
    public GeneralSettingFile(String username, String password) {
        super(username, password);
    }
    
    public void createFile(String username) {
        File accountFile = new File(username + "GeneralSettings.txt");
        try {
            if (accountFile.createNewFile()) {
                System.out.println("Created: " + accountFile.getName());
            } else {
                System.out.println("File already exists.");
            }

            FileWriter fileWriter = new FileWriter(accountFile);
            fileWriter.write("FontSize 12\nTheme light");
            fileWriter.close();
        } catch (IOException e) {
            System.out.println("Error occured");
            e.printStackTrace();
        }
    }
    
    public static void manipulateFile(String filename, int textSize, boolean isDark) {
        try {
            List<String> lines = new ArrayList<String>();
            String line = null;
            File file = new File(filename);
            FileReader fileReader = new FileReader(file);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            while((line = bufferedReader.readLine()) != null) {
                if (line.contains("FontSize")) {
                    line = line.replace(line, "FontSize " + textSize);
                } else if (line.contains("Theme")) {
                    if (isDark) {
                        line = line.replace(line, "Theme Dark");
                    } else {
                        line = line.replace(line, "Theme light");
                    }
                }
                lines.add(line);
                lines.add("\n");
            }
            fileReader.close();
            bufferedReader.close();
            
            FileWriter fileWriter = new FileWriter(file);
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
            for (String s : lines) {
                bufferedWriter.write(s);
            }
            bufferedWriter.flush();
            bufferedWriter.close();
        } catch (IOException e){
            System.out.println("Error during file creation.");
            e.printStackTrace();
        }
    }
}