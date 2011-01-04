package net.kuehldesign.backuptube;

import java.util.LinkedList;
import net.kuehldesign.backuptube.exception.FatalBackupException;
import net.kuehldesign.backuptube.exception.UnableToOpenURLConnectionException;
import net.kuehldesign.backuptube.site.youtube.YouTubeHelper;
import net.kuehldesign.backuptube.video.DownloadableVideo;

public class BackupHelper {
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

    public static final String SITE_YOUTUBE = "youtube";

    private String siteID;

    String user;
    int maxResults = 50;

    public BackupHelper(String siteID) {
        this.siteID = siteID;
    }

    public void setUser(String user) {
        this.user = user;
    }
    
    public String getUser() {
        return user;
    }

    public String getSiteID() {
        return siteID;
    }

    public LinkedList<DownloadableVideo> getVideos() throws FatalBackupException, UnableToOpenURLConnectionException {
        if (getSiteID().equals(SITE_YOUTUBE)) {
            return YouTubeHelper.getVideos(getUser());
        } else {
            return null;
        }
    }
}
