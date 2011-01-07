package net.kuehldesign.backuptube.app.common.stored.site.youtube;

public class StoredYouTubeResponseInfo {
    private String user;
    private String title;
    private String url;

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
