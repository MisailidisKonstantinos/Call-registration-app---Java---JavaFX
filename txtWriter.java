
package project;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.TreeMap;

public class txtWriter {
    protected String fileN;
    protected String fileOutput;
    
    public txtWriter(String fileName, String s){
        this.fileN = fileName + ".txt";
        this.fileOutput = "src\\project\\Calls\\" + fileN;
        File file = new File(fileOutput);
                
        try{            
            if(!file.exists()){
                System.out.println("A new file was created : " + fileN);                
            }
            else{
                System.out.println("The file already exists and was updated");
            }
            
            BufferedWriter writer = new BufferedWriter(new FileWriter(file, true));
            
            writer.append(s);
            writer.newLine();
            
            writer.close();
            
        }
        catch(IOException e){
            System.out.println("An error occurred");
        }
    }
    
    public txtWriter(String fileName, TreeMap<Integer, String> tree){
        this.fileN = fileName + ".txt";
        this.fileOutput = "src\\project\\Calls\\" + fileN;
        File file = new File(fileOutput);
        
        try{            
            System.out.println("The file was update");
            
            BufferedWriter writer = new BufferedWriter(new FileWriter(file));
            
            
            for(Integer i : tree.keySet()){
                if(i != 0){
                    writer.append(tree.get(i));
                    writer.newLine();
                }                
            }
           
            writer.close();
            
        }
        catch(IOException e){
            System.out.println("An error occurred");
        }
    }
}
