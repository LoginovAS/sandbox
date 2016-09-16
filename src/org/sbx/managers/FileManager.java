package org.sbx.managers;

import java.io.*;
import java.util.List;
import java.util.Scanner;

/**
 * Created by aloginov on 14.09.16.
 */
public class FileManager {

    private File file;
    private BufferedWriter out;
    private FileInputStream inputStream;
    private Scanner scanner;

    public FileManager(String fileName){
        this.file = new File(fileName);
    }



    public void openFileForInput(){

        if (!isFileExists()){
            createNewFile();
        }

        if (isFileExists()){
            try {
                this.inputStream = new FileInputStream(file);
                this.scanner = new Scanner(inputStream);
            } catch (IOException ex){
                System.err.println(ex);
            }
        } else
            createNewFile();

    }

    public void openFileForOutput(){

        if (!isFileExists()){
            createNewFile();
        }

        if (isFileExists()){
            try {
                this.out = new BufferedWriter(new FileWriter(file));
            } catch (IOException ex) {
                System.err.println(ex);
            }
        }

    }

    public <T extends List<String>>void readFileToList(T list){

        try {
            while (scanner.hasNextLine()){
                list.add(scanner.nextLine());
            }
        } finally {
            if (scanner != null){
                scanner.close();
            }
        }

    }

    public <T extends List<String>>void writeListToFile(T list){

        try {
            for (String s: list){
                out.write(s);
                out.newLine();
            }
        } catch (IOException ex) {
            System.err.println(ex);
        } finally {
            if (out != null){
                try {
                    out.close();
                } catch (IOException ex) {
                    System.err.println(ex);
                }
            }
        }

    }

    private boolean isFileExists(){
        boolean f = false;
        if (this.file.exists())
            f = true;

        return f;
    }

    private void createNewFile(){

        if (!isFileExists()){
            try {
                file.createNewFile();
            } catch (IOException ex) {
                System.err.println(ex);
            }
        }

    }
}
