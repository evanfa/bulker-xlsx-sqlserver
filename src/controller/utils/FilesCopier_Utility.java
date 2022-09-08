package controller.utils;

import java.io.*;

public class FilesCopier_Utility {

    private static void copyFileUsingStream(File source, File dest) throws IOException {
        InputStream is = null;
        OutputStream os = null;
        try {
            is = new FileInputStream(source);
            os = new FileOutputStream(dest);
            byte[] buffer = new byte[1024];
            int length;
            while ((length = is.read(buffer)) > 0) {
                os.write(buffer, 0, length);
            }
        } finally {
            is.close();
            os.close();
        }
    }

    public static void fileCopier(File input, File output) {
        try {
            if (input.exists()) {
                copyFileUsingStream(input, output);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void generateCopyFileInPath(String tempFile, String destPath) {
        try {

            //System.out.println("Temp File: "+tempFile+" - DestPath: "+destPath);

            File temp = new File(tempFile);

            destPath = destPath.concat(temp.getName());
            File dest = new File(destPath);

            fileCopier(temp, dest);

        } catch (NullPointerException e) {
            System.out.println("Error in file: " + e);
        }

    }
}