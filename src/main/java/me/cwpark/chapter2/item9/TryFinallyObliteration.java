package me.cwpark.chapter2.item9;

import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;

public class TryFinallyObliteration {
    public static void main(String[] args) throws Exception {
        copy("/text-source.txt", "/text-output.txt");
    }

    static void copy(String src, String dst) throws Exception {
        InputStream in = TryFinallyObliteration.class.getResourceAsStream(src);
        try {

            OutputStream out = new FileOutputStream(TryFinallyObliteration.class.getProtectionDomain().getCodeSource().getLocation().getPath().concat("/dst"));
            try {
                byte[] buf = new byte[1000];
                int n;
                while ( (n = in.read(buf)) >= 0) { // It could occur error!
                    if(1 == 1) throw new RuntimeException("some exception occurs.");
                    out.write(buf, 0, n);
                }
            } finally {
                System.out.println("Inner Exception !");
                out.close();
                throw new RuntimeException("some exception occurs.");
            }
        } finally {
            System.out.println("Outer Exception !"); // It will not print.
            in.close();
        }
    }

}
