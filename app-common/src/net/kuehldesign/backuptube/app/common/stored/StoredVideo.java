package net.kuehldesign.backuptube.app.common.stored;

public class StoredVideo {
    private String url;
    private String publishedOn;
    private String description;
    private String downloadedOn;
    private String title;
    private StoredVideoSiteInfo siteInfo;
    private String uploader;
    private boolean hasBeenDeleted;

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDownloadedOn() {
        return downloadedOn;
    }

    public void setDownloadedOn(String downloadedOn) {
        this.downloadedOn = downloadedOn;
    }

    public boolean hasBeenDeleted() {
        return hasBeenDeleted;
    }

    public void setHasBeenDeleted(boolean hasBeenDeleted) {
        this.hasBeenDeleted = hasBeenDeleted;
    }

    public String getPublishedOn() {
        return publishedOn;
    }

    public void setPublishedOn(String publishedOn) {
        this.publishedOn = publishedOn;
    }

    public StoredVideoSiteInfo getSiteInfo() {
        return siteInfo;
    }

    public void setSiteInfo(StoredVideoSiteInfo siteInfo) {
        this.siteInfo = siteInfo;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getUploader() {
        return uploader;
    }

    public void setUploader(String uploader) {
        this.uploader = uploader;
    }

    public StoredVideo() {

    }
}