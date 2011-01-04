package net.kuehldesign.backuptube.app.common.stored;

public class StoredVideo {
    private String folderName;
    private long downloadedTime;
    private String title;
    private String siteID;
    private String videoID;

    public String getSiteID() {
        return siteID;
    }

    public void setSiteID(String siteID) {
        this.siteID = siteID;
    }

    public String getVideoID() {
        return videoID;
    }

    public void setVideoID(String videoID) {
        this.videoID = videoID;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getFolderName() {
        return folderName;
    }

    public void setFolderName(String folderName) {
        this.folderName = folderName;
    }

    public long getDownloadedTime() {
        return downloadedTime;
    }

    public void setDownloadedTime(long downloadedTime) {
        this.downloadedTime = downloadedTime;
    }

    // this should be overridden by child classes
    public boolean hasBeenDeleted() {
        return false;
    }
}
