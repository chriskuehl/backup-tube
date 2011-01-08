package net.kuehldesign.backuptube.app.common.stored.site.youtube;

import java.util.LinkedList;
import net.kuehldesign.backuptube.app.common.stored.StoredVideo;
import net.kuehldesign.backuptube.app.common.stored.VideoInfoModule;

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

    @Override
    public LinkedList<VideoInfoModule> getExtraModules() {
        LinkedList<VideoInfoModule> extraModules = new LinkedList();
        
        if (getVideoResponse() != null) {
            extraModules.add(getVideoResponse());
        }

        return extraModules;
    }
}