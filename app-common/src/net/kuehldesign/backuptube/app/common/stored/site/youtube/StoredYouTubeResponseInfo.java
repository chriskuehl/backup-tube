package net.kuehldesign.backuptube.app.common.stored.site.youtube;

import net.kuehldesign.backuptube.app.common.stored.VideoInfoModule;
import net.kuehldesign.backuptube.app.common.stored.VideoInfoTable;

public class StoredYouTubeResponseInfo extends VideoInfoTable implements VideoInfoModule {
    private String user;
    private String title;
    private String url;

    @Override
    public void initInfoTable() {
        setInfoTableTitle("Video Response To:");

        // title of video responding to (links to it), user
        addInfoTableEntry("Video Title", "<a href=\"" + getUrl() + "\">" + getTitle() + "</a>");
        addInfoTableEntry("Uploader", getUser());
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public StoredYouTubeResponseInfo() {
    }
}
