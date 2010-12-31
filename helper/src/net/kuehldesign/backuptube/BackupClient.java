package net.kuehldesign.backuptube;

import net.kuehldesign.backuptube.video.YouTubeVideo;
import net.kuehldesign.backuptube.video.YouTubeVideoGroup;
import com.google.gson.Gson;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.List;
import net.kuehldesign.backuptube.exception.FatalBackupException;
import net.kuehldesign.backuptube.exception.MalformedFeedURLException;
import net.kuehldesign.backuptube.exception.UnableToGetSourceException;
import net.kuehldesign.backuptube.exception.UnableToOpenURLConnectionException;

public class BackupClient {

    public static final int FORMAT_3GP_LOW     = 1;
    public static final int FORMAT_3GP_MEDIUM  = 2;
    public static final int FORMAT_3GP_HIGH    = 3;
    public static final int FORMAT_FLV_LOW     = 4;
    public static final int FORMAT_FLV_MEDIUM  = 5;
    public static final int FORMAT_FLV_MEDIUM2 = 6;
    public static final int FORMAT_FLV_HIGH    = 7;
    public static final int FORMAT_MP4_HIGH    = 8;
    public static final int FORMAT_MP4_720P    = 9;
    public static final int FORMAT_MP4_1080P   = 10;
    public static final int FORMAT_MP4_4K      = 11;


    public static String between(String content, String first, String last) {
        /* content = content.substring(content.indexOf(first) + first.length());
        content = content.substring(0, content.indexOf(last));

        return content; */

        return betweenMore(content, first, last, 1);
    }

    public static String betweenMore(String content, String first, String last, int index) {
        try {
            for (int i = 0; i < index; i ++) {
                content = content.substring(content.indexOf(first) + first.length());
            }

            content = content.substring(0, content.indexOf(last));
        } catch (Exception ex) {
            return null;
        }
        
        return content;
    }

    public static String getSource(String url) throws UnableToGetSourceException {
        try {
            URL u = new URL(url);
            URLConnection connection = u.openConnection();
            InputStream input = connection.getInputStream();

            ByteArrayOutputStream output = new ByteArrayOutputStream();
            byte buffer[] = new byte[1024];
            int bytesRead;

            while ((bytesRead = input.read(buffer)) != -1) {
                output.write(buffer, 0, bytesRead);
            }

            return output.toString();
        } catch (IOException ex) {
            ex.printStackTrace();
            System.err.println(ex.getMessage());
            throw new UnableToGetSourceException("");
        }
    }

    String user;
    int maxResults = 50;

    public BackupClient() {

    }

    public void setUser(String user) {
        this.user = user;
    }
    
    public String getUser() {
        return user;
    }

    public int getMaxResults() {
        return maxResults;
    }
    
    public void setMaxResults(int maxResults) {
        this.maxResults = maxResults;
    }

    public URL getFeedURL(int startIndex) throws FatalBackupException, MalformedFeedURLException {
        // max-results is 50
        // start-index should increase by 50

        try {
            return new URL("http://gdata.youtube.com/feeds/api/users/" + URLEncoder.encode(getUser(), "UTF-8") + "/uploads?max-results=" + URLEncoder.encode(String.valueOf(getMaxResults()), "UTF-8") + "&alt=json&start-index=" + URLEncoder.encode(String.valueOf(startIndex), "UTF-8"));
        } catch (UnsupportedEncodingException ex) {
            throw new FatalBackupException("UTF-8 encoding not supported");
        } catch (MalformedURLException ex) {
            throw new MalformedFeedURLException("Malformed URL [101]");
        }
    }

    public ArrayList<YouTubeVideo> getVideos() throws FatalBackupException, UnableToOpenURLConnectionException {
        ArrayList<YouTubeVideo> videos = new ArrayList();
        int total = (- 1);
        int startIndex = 1; // YouTube is dumb and starts at 1 instead of 0...
        int i = 0;

        while (true) {
            URL url;

            try {
                url = getFeedURL(startIndex);
            } catch (MalformedFeedURLException ex) {
                throw new FatalBackupException("Unable to get feed URL");
            }

            URLConnection connection;

            YouTubeVideoGroup videoGroup;

            try {
                connection = url.openConnection();
                videoGroup = new Gson().fromJson(new InputStreamReader(connection.getInputStream()), YouTubeVideoGroup.class);
            } catch (IOException ex) {
                throw new UnableToOpenURLConnectionException("Unable to open URL connection; does YouTube video exist?");
            }

            List<YouTubeVideo> feedVideos = videoGroup.getVideos();

            if (feedVideos != null) {
                total = feedVideos.size();

                for (YouTubeVideo video : feedVideos) {
                    videos.add(video);
                }

                startIndex += total;
            } else {
                break;
            }
        }
        
        return videos;
    }

    public static String escapeFileName(String fileName) {
        fileName = fileName.replaceAll("/", "-");
        return fileName;
    }

}
