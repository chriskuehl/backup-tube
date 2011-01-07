package net.kuehldesign.backuptube.app.common.stored;

public class StoredVideoSiteInfo {
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

    public StoredVideoSiteInfo() {
    }
}
