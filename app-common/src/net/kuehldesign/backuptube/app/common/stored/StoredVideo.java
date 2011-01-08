package net.kuehldesign.backuptube.app.common.stored;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.LinkedList;
import net.kuehldesign.backuptube.app.common.BackupTubeCommon;

public class StoredVideo extends VideoInfoTable implements VideoInfoModule {
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

    public LinkedList<VideoInfoModule> getExtraModules() {
        return new LinkedList();
    }

    @Override
    public void initInfoTable() {
        setInfoTableTitle("General Info");

        // url, uploader, uploaded on, downloaded on, description
        addInfoTableEntry("Published URL", "<a href=\"" + getUrl() + "\">Video</a>");
        addInfoTableEntry("Uploader", getUploader());
        addInfoTableEntry("Uploaded on", getPublishedOn());
        addInfoTableEntry("Downloaded on", getDownloadedOn());
        addInfoTableEntry("Description", getDescription());
    }

    public void saveHTML(File file, String videoFileName, String clientType, String clientVersion) throws FileNotFoundException {
        String html = BackupTubeCommon.getHTMLTemplate();

        html = html.replaceAll(BackupTubeCommon.TEMPLATE_CLIENT_TYPE, clientType);
        html = html.replaceAll(BackupTubeCommon.TEMPLATE_CLIENT_VERSION, clientVersion);
        html = html.replaceAll(BackupTubeCommon.TEMPLATE_GEN_DATE, BackupTubeCommon.getTimeString(BackupTubeCommon.getCurrentTime()));
        html = html.replaceAll(BackupTubeCommon.TEMPLATE_TITLE, getTitle() + " - " + getUploader());
        html = html.replaceAll(BackupTubeCommon.TEMPLATE_VIDEO_FILE, videoFileName); // TODO: fix spaces, fails validation
        
        /*try {
            html = html.replaceAll(BackupTubeCommon.TEMPLATE_VIDEO_FILE, URLEncoder.encode(videoFileName, "UTF-8"));
        } catch (UnsupportedEncodingException ex) {
        }*/

        html = html.replaceAll(BackupTubeCommon.TEMPLATE_VIDEO_TITLE, getTitle());

        // generate info (details of the video, using VideoInfoModule
        String info = "";
        
        LinkedList<VideoInfoModule> infoModules = new LinkedList();
        infoModules.add(this);

        for (VideoInfoModule module : getExtraModules()) {
            infoModules.add(module);
        }

        infoModules.add(getSiteInfo());
        
        for (VideoInfoModule moduleToShow : infoModules) {
            info += moduleToShow.getHTML() + "\n";
        }

        html = html.replaceAll(BackupTubeCommon.TEMPLATE_INFO, info);

        PrintWriter writer = new PrintWriter(file);
        writer.write(html);
        writer.close();
    }
}