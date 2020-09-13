package me.cwpark.chapter2.item9;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URISyntaxException;

public class TryWithResources {

    public static void main(String[] args) throws Exception {
        //firstLineOfFile("/text-source.txt");
        copy("/", "/text-output.txt");
    }

    static int firstLineOfFile(String path) throws IOException, URISyntaxException {

        try(InputStream in = TryFinallyObliteration.class.getResourceAsStream(path);) {
            byte[] buf = new byte[1000];
            if(1==1) throw new RuntimeException("Exception in try clause !!!");
            return in.read(buf);
        }
    }

    static void copy(String src, String dst) throws Exception {
        try(InputStream in = TryFinallyObliteration.class.getResourceAsStream(src);
            OutputStream out = new FileOutputStream(TryFinallyObliteration.class.getProtectionDomain().getCodeSource().getLocation().getPath().concat("/dst"));) {
            byte[] buf = new byte[1000];
            int n;
            while ((n = in.read(buf)) >= 0) { // It could occur error!
                if (1 == 1) throw new RuntimeException("Exception in try clause !!!");
                out.write(buf, 0, n);
            }
        } // Invisible close exception is suppressed in favor of the exception in try clause.
    }
}
