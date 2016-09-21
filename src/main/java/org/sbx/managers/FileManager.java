package org.sbx.managers;

import java.io.*;
import java.util.List;
import java.util.Scanner;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;

/**
 * Created by aloginov on 14.09.16.
 */
public class FileManager {

    private static final Logger logger = LogManager.getLogger(FileManager.class);

    private File file;
    private PrintStream out;
    private FileInputStream inputStream;
    private Scanner scanner;
    private Boolean append;
    private boolean success;

    public FileManager(String fileName){
        this.file = new File(fileName);
        this.success = false;
    }



    public void openFileForInput(){

        if (!isFileExists()){
            logger.warn(LoggerManager.FILE_NOT_EXISTS, file.getAbsolutePath(), LoggerManager.WILL_CREATE_FILE);
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
                logger.error(ex);
            } finally {
                if (success)
                    logger.debug(LoggerManager.FILE_OPENED, file.getAbsolutePath(), "read");
                else{
                    logger.error(LoggerManager.CANNOT_OPEN_FILE, file.getAbsolutePath(), "read");
                }
            }
        } else
            createNewFile();

    }

    public boolean openFileForOutput(boolean append){

        this.append = append;

        logger.debug(LoggerManager.FLAG_VALUE, "append", append);

        if (!isFileExists()){
            logger.warn(LoggerManager.FILE_NOT_EXISTS, file.getAbsolutePath(), LoggerManager.WILL_CREATE_FILE);
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
                logger.error(ex);
            } finally {
                if (success)
                    logger.debug(LoggerManager.FILE_OPENED, file.getAbsolutePath(), "write");
                else{
                    logger.error(LoggerManager.CANNOT_OPEN_FILE, file.getAbsolutePath(), "write");
                }
            }
        }

        return success;
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
        out.close();

    }

    public void writeToFile(String s){
        out.println(s);
        out.close();
    }

    private boolean isFileExists(){
        boolean f = false;
        if (this.file.exists()){
            f = true;
            logger.info(LoggerManager.FILE_EXISTS, file.getAbsolutePath());
        } else
            logger.warn(LoggerManager.FILE_NOT_EXISTS, file.getAbsolutePath(), "");

        return f;
    }

    private void createNewFile(){

        if (!isFileExists()){
            boolean s = false;
            try {
                file.createNewFile();
                s = true;
            } catch (IOException ex) {
                logger.error(ex);
            } finally {
                if (s)
                    logger.info(LoggerManager.FILE_CREATED, file.getAbsolutePath());
                else
                    logger.error(LoggerManager.CANNOT_CREATE_FILE, file.getAbsolutePath());
            }
        }

    }
}
