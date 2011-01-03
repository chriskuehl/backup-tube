package net.kuehldesign.backuptube.video;

import java.util.LinkedList;

public class YouTubeVideoGroup {
    private YouTubeVideoFeed feed;

    public LinkedList<YouTubeVideo> getVideos() {
        return feed.getVideos();
    }

    public YouTubeVideoGroup() {
        
    }
}