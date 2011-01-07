// used with GSON for storage of data

package net.kuehldesign.backuptube.app.common.datafile;

import java.util.LinkedList;
import net.kuehldesign.backuptube.app.common.listed.ListedVideo;


public class BackupTubeDataFile {
    // videos will be looped through to check for videos which have been deleted
    // and also possibly to display a library -- not sure yet
    private LinkedList<ListedVideo> videos;
    private long lastUpdated;

    public void setVideos(LinkedList<ListedVideo> videos) {
        this.videos = videos;
    }

    public LinkedList<ListedVideo> getVideos() {
        return videos;
    }

    public void setLastUpdated(long lastUpdated) {
        this.lastUpdated = lastUpdated;
    }

    public long getLastUpdated() {
        return lastUpdated;
    }
}
