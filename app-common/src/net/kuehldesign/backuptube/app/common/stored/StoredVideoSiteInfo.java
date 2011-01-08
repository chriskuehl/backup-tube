package net.kuehldesign.backuptube.app.common.stored;

public class StoredVideoSiteInfo extends VideoInfoTable implements VideoInfoModule {
    private String siteID;
    private String videoID;

    @Override
    public void initInfoTable() {
        setInfoTableTitle("Site Info");

        // site ID, video ID
        addInfoTableEntry("Site ID", getSiteID());
        addInfoTableEntry("Video ID", getVideoID());
    }

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
