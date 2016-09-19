package org.sbx.managers;

import java.io.*;
import java.util.List;
import java.util.Scanner;

/**
 * Created by aloginov on 14.09.16.
 */
public class FileManager {

    private File file;
    private PrintStream out;
    private FileInputStream inputStream;
    private Scanner scanner;
    private boolean append;
    private boolean success;

    public FileManager(String fileName){
        this.file = new File(fileName);
        this.success = false;
    }



    public void openFileForInput(){

        if (!isFileExists()){
            createNewFile();
        }

        if (isFileExists()){
            try {
                this.inputStream = new FileInputStream(file);
                this.scanner = new Scanner(inputStream);

                if (this.scanner != null) {
                    this.success = true;
                }
            } catch (IOException ex){
                System.err.println(ex);
            } finally {
                if (!success){
                    System.err.println("Input file cannot be oppened.");
                }
            }
        } else
            createNewFile();

    }

    public void openFileForOutput(boolean append){

        this.append = append;

        if (!isFileExists()){
            createNewFile();
        }

        if (isFileExists()){
            try {
                this.out = new PrintStream(
                        new BufferedOutputStream(
                                new FileOutputStream(file, append)
                        )
                );
                if (this.out != null){
                    this.success = true;
                }
            } catch (IOException ex) {
                System.err.println(ex);
            } finally {
                if (!success){
                    System.err.println("File cannot be out for output.");
                }
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

            for (String s: list)
                out.println(s);

    }

    public void writeToFile(String s){
        out.println(s);
        out.close();
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
