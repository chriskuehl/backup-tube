package net.kuehldesign.backuptube.app.common.stored;

public class StoredVideo {
    public String folderName;
    public long downloadedTime;
    private String title;

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
