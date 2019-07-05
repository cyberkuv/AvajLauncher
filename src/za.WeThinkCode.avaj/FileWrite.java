package AvajLauncher.src.za.WeThinkCode.avaj;

import AvajLauncher.src.za.WeThinkCode.avaj.*;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class FileWrite {
    private static FileWrite fileWrite = null;
    private static FileWriter fileWriter = null;
    private static BufferedWriter bufferedWriter = null;
    private static File file = null;
    private FileWrite(){}
    public static FileWrite getFileWrite(){
        if(fileWrite == null)
            try {
                fileWrite = new FileWrite();
                file = new File("Simulator.txt");
                fileWriter = new FileWriter(file);
                bufferedWriter = new BufferedWriter(fileWriter);
            } catch (IOException e) {
                System.out.println(e);
            }
        return fileWrite;
    }
    public void writeToFile(String str) {
        try {
            if(!file.exists())
                file.createNewFile();
            bufferedWriter.write(str + "\n");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void Close(){
        try {
            if(bufferedWriter != null)
                bufferedWriter.close();
        } catch (Exception e) {
            System.out.println("FileWrite : error writting " + e);
        }
    }
}
