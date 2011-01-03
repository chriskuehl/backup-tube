// used with GSON for storage of data

package net.kuehldesign.backuptube.app.common.datafile;

import java.util.LinkedList;
import net.kuehldesign.backuptube.site.youtube.YouTubeVideo;


public class BackupTubeDataFile {
    // videos will be looped through to check for videos which have been deleted
    // and also possibly to display a library -- not sure yet
    private LinkedList<YouTubeVideo> videos;
    private long lastUpdated;

    public void setVideos(LinkedList<YouTubeVideo> videos) {
        this.videos = videos;
    }

    public LinkedList<YouTubeVideo> getVideos() {
        return videos;
    }

    public void setLastUpdated(long lastUpdated) {
        this.lastUpdated = lastUpdated;
    }

    public long getLastUpdated() {
        return lastUpdated;
    }
}
