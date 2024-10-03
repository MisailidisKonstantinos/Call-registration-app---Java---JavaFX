
package project;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.TreeSet;

public class txtReader {
    
    protected String line = "";
    
    protected TreeSet<String> calls;
    
    public txtReader(String fileInput){
        
        try
        {
            BufferedReader read = new BufferedReader(new FileReader(fileInput));
            calls = new TreeSet<String>();

            while((line = read.readLine()) != null)
            {
                calls.add(line);
            }                
        }
        catch(FileNotFoundException e)
        {
            System.out.println("The file was not found, please try again");
        }
        catch(IOException e)
        {
            System.out.println("Input or output error occurred, please try again");
        }
    }
}
