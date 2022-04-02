package com.techelevator.Audit;

import java.io.*;

public class Audit {
    private File auditFile;
    private PrintWriter writer;

    public Audit(String pathName) {
        this.auditFile = new File(pathName);

        if(!auditFile.exists()) {
            try {
                this.writer = new PrintWriter(this.auditFile);
            }catch (FileNotFoundException e) {
                System.out.println("No File Found");
            }
        } else {
            try {
                this.writer = new PrintWriter(new FileWriter(this.auditFile, true));
            } catch (IOException e) {
                System.out.println("No File Found");
            }
        }
    }

    public void write(String logMessage) {
        this.writer.println(logMessage);
        this.writer.flush();
    }

    public void close() throws IOException {
        this.writer.close();
    }

}
