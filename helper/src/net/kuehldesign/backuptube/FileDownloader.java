package net.kuehldesign.backuptube;

import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;


public class FileDownloader extends Thread {
    private URL url;
    private double bytesDownloaded;
    private double totalBytes = (- 1);
    private String saveLocation;
    private boolean hasError;

    public FileDownloader(URL url, String file) {
        this.url = url;
        this.saveLocation = file;
    }

    public void startDownload() {
        start();
    }

    public URL getURL() {
        return url;
    }

    public String getSaveLocation() {
        return saveLocation;
    }

    public void run() {
        try {
            URLConnection connection = getURL().openConnection();
            connection.setReadTimeout(10 * 1000);
            InputStream input = connection.getInputStream();
            FileOutputStream fos = new FileOutputStream(getSaveLocation());
            BufferedOutputStream output = new BufferedOutputStream(fos, 1024);

            totalBytes = connection.getContentLength();
            bytesDownloaded = 0;
            
            byte buffer[] = new byte[1024];
            int bytesRead;

            while ((bytesRead = input.read(buffer)) != -1) {
                bytesDownloaded += 1024;
                output.write(buffer, 0, bytesRead);
            }
        } catch (IOException ex) {
            ex.printStackTrace();
            this.error();
        }
    }

    private void error() {
        hasError = true;
    }

    public boolean hasError() {
        return hasError;
    }

    public double getProgress() {
        if (totalBytes == (- 1)) {
            return 0;
        }
        
        return (bytesDownloaded / totalBytes);
    }

    public boolean isFinished() {
        if (totalBytes == (- 1)) {
            return false;
        }

        return bytesDownloaded >= totalBytes;
    }
}
