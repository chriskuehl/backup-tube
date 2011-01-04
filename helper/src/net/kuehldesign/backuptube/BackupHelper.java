package net.kuehldesign.backuptube;

import java.util.LinkedList;
import net.kuehldesign.backuptube.exception.FatalBackupException;
import net.kuehldesign.backuptube.exception.UnableToOpenURLConnectionException;
import net.kuehldesign.backuptube.site.youtube.YouTubeHelper;
import net.kuehldesign.backuptube.video.DownloadableVideo;

public class BackupHelper {
    
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
