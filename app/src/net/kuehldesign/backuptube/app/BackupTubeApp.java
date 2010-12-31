package net.kuehldesign.backuptube.app;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import net.kuehldesign.backuptube.BackupHelper;
import net.kuehldesign.backuptube.FileDownloader;
import net.kuehldesign.backuptube.exception.BadVideoException;
import net.kuehldesign.backuptube.exception.FatalBackupException;
import net.kuehldesign.backuptube.exception.UnableToOpenURLConnectionException;
import net.kuehldesign.backuptube.video.YouTubeVideo;

public class BackupTubeApp {
    public static void main(String[] args) {
        String user = args[0];
        String saveDir = args[1];

        BackupHelper helper = new BackupHelper();
        helper.setUser(user);

        ArrayList<YouTubeVideo> videos = null;

        try {
            videos = helper.getVideos();
        } catch (FatalBackupException ex) {
            System.err.println("Fatal exception: " + ex.getMessage());
            ex.printStackTrace();
        } catch (UnableToOpenURLConnectionException ex) {
            System.err.println("Unable to open URL connection; does YouTube account exist?");
            ex.printStackTrace();
        }

        // now, start downloading the videos
        try {
            int videoCount = 0;
            int totalVideoCount = videos.size();

            for (YouTubeVideo video : videos) {
                for (int downloadTry = 0; downloadTry < 3; downloadTry ++) {
                    System.out.println("Starting try " + (downloadTry + 1) + "/3 to download \"" + video.getTitle() + "\"");

                    try {
                        video.init();
                        String downloadURL = video.getDownloadURL();
                        FileDownloader d = new FileDownloader(new URL(downloadURL), saveDir + BackupHelper.escapeFileName(video.getTitle()) + "." + video.getExtension());
                        d.startDownload();
                        boolean hasError = false;

                        while (! d.isFinished()) {
                            if (d.hasError()) {
                                hasError = true;
                                break;
                            }

                            double progress = d.getProgress();
                            progress *= 10000;
                            progress = Math.round(progress);
                            progress /= 100;

                            System.out.println("Progress (" + videoCount + "/" + totalVideoCount + " \"" + video.getTitle() + "\"): " + progress + "%");

                            try {
                                Thread.sleep(1000);
                            } catch (InterruptedException ex) {

                            }
                        }

                        if (hasError) {
                            System.out.println("Has error, starting new try.");
                            continue;
                        }

                        System.out.println("Successfully downloaded video \"" + video.getTitle() + "\"");
                        break;
                    } catch (BadVideoException ex) {
                        ex.printStackTrace();
                    } catch (MalformedURLException ex) {
                        ex.printStackTrace();
                    }
                }

                videoCount ++;
            }
        } catch (FatalBackupException ex) {
            System.err.println("Fatal exception: " + ex.getMessage());
            ex.printStackTrace();
        }
    }
}