package net.kuehldesign.backuptube.app.common.stored;

public class StoredVideo {
    public String folderName;
    public long downloadedTime;

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
