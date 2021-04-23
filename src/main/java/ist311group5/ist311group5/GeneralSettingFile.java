package ist311group5.ist311group5;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class GeneralSettingFile extends Account{
    private String theme;
    private int fontSize;
    
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
    
    public void manipulateFile(String filename, int textSize, boolean isDark) {
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
    
    public String[] readFile() {
        String file = "DefaultGeneralSettings.txt";
        String[] lines = new String[4];
        String line;
        try {
            File accountFile = new File(file);
            Scanner reader = new Scanner(accountFile);
            while(reader.hasNextLine()) {
                line = reader.nextLine();
                lines  = line.split(" ");
                
//                String category = line.split(" ");
            }
            reader.close();
        } catch (FileNotFoundException e) {
            System.out.println("No file found.");
        }
        return lines;
    }
    
    public String[] readFile(String username) {
        String file = username + "GeneralSettings.txt";
        String[] lines = new String[2];
        String line;
//        List lines = new ArrayList<String>();
        
        try {
            File accountFile = new File(file);
            Scanner reader = new Scanner(accountFile);
            while(reader.hasNextLine()) {
                line = reader.nextLine();
                String[] temp = line.split(" ");
                if (temp[0].equals("FontSize")) {
                    lines[0] = temp[1];
                    fontSize = Integer.parseInt(temp[1]);
                } else if (temp[0].equals("Theme")) {
                    lines[1] = temp[1];
                    theme = temp[1];
                }
            }
            reader.close();
        } catch (FileNotFoundException e) {
            System.out.println("No file found.");
        }
        
        return lines;
    }
    
    public void setFontSize(int fontSize) {
        this.fontSize = fontSize;
    }
    
    public int getFontSize() {
        return fontSize;
    }
    
    public void setTheme(String theme) {
        this.theme = theme;
    }
    
    public String getTheme() {
        return theme;
    }    
}