package net.kuehldesign.backuptube.video;

import java.util.List;

public class YouTubeVideoGroup {
    private YouTubeVideoFeed feed;

    public List<YouTubeVideo> getVideos() {
        return feed.getVideos();
    }

    public YouTubeVideoGroup() {
        
    }
}