package net.kuehldesign.backuptube.app.common.stored;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.logging.Level;
import java.util.logging.Logger;
import net.kuehldesign.backuptube.app.common.BackupTubeCommon;

public class StoredVideo implements VideoInfoModule {
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

    public String getHTML() {
        return ""; // TODO: add HTML stuff
    }

    public void saveHTML(File file, String videoFileName, String clientType, String clientVersion) throws FileNotFoundException {
        String html = BackupTubeCommon.getHTMLTemplate();

        html = html.replaceAll(BackupTubeCommon.TEMPLATE_CLIENT_TYPE, clientType);
        html = html.replaceAll(BackupTubeCommon.TEMPLATE_CLIENT_VERSION, clientVersion);
        html = html.replaceAll(BackupTubeCommon.TEMPLATE_GEN_DATE, BackupTubeCommon.getTimeString(BackupTubeCommon.getCurrentTime()));
        html = html.replaceAll(BackupTubeCommon.TEMPLATE_TITLE, getTitle() + " - " + getUploader());
        
        try {
            html = html.replaceAll(BackupTubeCommon.TEMPLATE_VIDEO_FILE, URLEncoder.encode(videoFileName, "UTF-8"));
        } catch (UnsupportedEncodingException ex) {
        }

        html = html.replaceAll(BackupTubeCommon.TEMPLATE_VIDEO_TITLE, getTitle());
        html = html.replaceAll(BackupTubeCommon.TEMPLATE_INFO, "info here");

        PrintWriter writer = new PrintWriter(file);
        writer.write(html);
        writer.close();
    }
}