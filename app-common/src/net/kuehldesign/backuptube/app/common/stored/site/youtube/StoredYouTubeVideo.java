package net.kuehldesign.backuptube.app.common.stored.site.youtube;

import net.kuehldesign.backuptube.app.common.stored.StoredVideo;
import net.kuehldesign.backuptube.app.common.stored.StoredVideoResponseInfo;

public class StoredYouTubeVideo extends StoredVideo {
    private String category;
    private StoredVideoResponseInfo videoResponse;
    private String tags;

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getTags() {
        return tags;
    }

    public void setTags(String tags) {
        this.tags = tags;
    }

    public StoredVideoResponseInfo getVideoResponse() {
        return videoResponse;
    }

    public void setVideoResponse(StoredVideoResponseInfo videoResponse) {
        this.videoResponse = videoResponse;
    }
}