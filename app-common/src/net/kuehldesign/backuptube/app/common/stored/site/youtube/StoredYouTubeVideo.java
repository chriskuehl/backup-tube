package net.kuehldesign.backuptube.app.common.stored.site.youtube;

import net.kuehldesign.backuptube.app.common.stored.StoredVideo;

public class StoredYouTubeVideo extends StoredVideo {
    private String category;
    private StoredYouTubeResponseInfo videoResponse;
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

    public StoredYouTubeResponseInfo getVideoResponse() {
        return videoResponse;
    }

    public void setVideoResponse(StoredYouTubeResponseInfo videoResponse) {
        this.videoResponse = videoResponse;
    }
}