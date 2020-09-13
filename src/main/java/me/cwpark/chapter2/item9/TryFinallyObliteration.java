package me.cwpark.chapter2.item9;

import java.io.*;
import java.net.URISyntaxException;

public class TryFinallyObliteration {
    public static void main(String[] args) throws Exception {
        //firstLineOfFile("/text-source.txt");
        copy("/", "/text-output.txt");
    }

    static int firstLineOfFile(String path) throws IOException, URISyntaxException {

        //BufferedReader br = new BufferedReader(new FileReader(path1));
        InputStream in = TryFinallyObliteration.class.getResourceAsStream(path);

        try {
            byte[] buf = new byte[1000];
            if(1==1) throw new RuntimeException("Exception in try clause !!!"); // It will not print
            return in.read(buf);
        } finally {
            if(1==1) throw new RuntimeException("Exception in finally clause !!!");
            in.close();
        }
    }

    static void copy(String src, String dst) throws Exception {
        InputStream in = TryFinallyObliteration.class.getResourceAsStream(src);
        try {
            OutputStream out = new FileOutputStream(TryFinallyObliteration.class.getProtectionDomain().getCodeSource().getLocation().getPath().concat("/dst"));
            try {
                byte[] buf = new byte[1000];
                int n;
                while ( (n = in.read(buf)) >= 0) { // It could occur error!
                    if(1 == 1) throw new RuntimeException("Exception in try clause !!!"); // It will not print.
                    out.write(buf, 0, n);
                }
            } finally {
                if(1 == 1) throw new RuntimeException("Exception in first finally clause !!!"); // It will not print.
                out.close();
            }
        } finally {
            if(1 == 1) throw  new RuntimeException("Exception in seconds finally clause !!");
            in.close();
        }
    }

}
