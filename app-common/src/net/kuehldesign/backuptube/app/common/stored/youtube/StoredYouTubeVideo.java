package net.kuehldesign.backuptube.app.common.stored.youtube;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.logging.Level;
import java.util.logging.Logger;
import net.kuehldesign.backuptube.app.common.stored.StoredVideo;
import net.kuehldesign.jnetutils.JNetUtils;
import net.kuehldesign.jnetutils.exception.UnableToGetSourceException;

public class StoredYouTubeVideo extends StoredVideo {
    private String videoID;

    public void setVideoID(String videoID) {
        this.videoID = videoID;
    }

    public String getVideoID() {
        return videoID;
    }

    @Override
    public boolean hasBeenDeleted() {
        String source = null;
        
        try {
            String feedURL = "http://gdata.youtube.com/feeds/api/videos/" + getVideoID();
            source = JNetUtils.getSource(feedURL);
        } catch (UnableToGetSourceException ex) {
            return false; // couldn't load for some reason
        }

        return (source == null ? false : (! source.equals("Invalid id")));
    }
}
