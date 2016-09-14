package classes;

import java.io.*;
import java.util.List;

/**
 * Created by aloginov on 14.09.16.
 */
public class FileManager {

    private File file;
    private BufferedReader in;
    private BufferedWriter out;

    public FileManager(String fileName){
        this.file = new File(fileName);
    }



    public void openFileForInput(){

        if (!isFileExists()){
            createNewFile();
        }

        if (isFileExists()){
            try {
                this.in = new BufferedReader(new FileReader(file));
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

    public void readFileToList(List<String> list){

        String s;
        try {
            while ((s = in.readLine()) != null){
                list.add(s);
            }
        } catch (IOException ex) {
            System.err.println(ex);
        }

    }

    public void writeListToFile(List<String> list){

        try {
            for (String s: list){
                out.write(s);
                out.newLine();
            }
        } catch (IOException ex) {
            System.err.println(ex);
        }

    }

    public void close(){
        if (out != null) {
            closeFile(out);
            out = null;
        }
        else if (in != null) {
            closeFile(in);
            in = null;
        }
    }

    private void closeFile(Object object){
        if (object instanceof Reader){
            try{
                in.close();
            } catch (IOException ex) {
                System.err.println(ex);
            }
        } else if (object instanceof Writer){
            try {
                out.close();
            } catch (IOException ex) {
                System.err.println(ex);
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
