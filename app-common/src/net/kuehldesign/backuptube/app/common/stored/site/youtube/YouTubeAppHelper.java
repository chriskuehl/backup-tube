package net.kuehldesign.backuptube.app.common.stored.site.youtube;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import net.kuehldesign.backuptube.app.common.listed.ListedVideo;

public class YouTubeAppHelper {
    public static boolean hasBeenDeleted(ListedVideo video) {
        int code = 0;

        try {
            URL url = new URL("http://gdata.youtube.com/feeds/api/videos/" + video.getVideoID());
            URLConnection connection = url.openConnection();
            HttpURLConnection httpConnection = (HttpURLConnection) connection;
            code = httpConnection.getResponseCode();
        } catch (MalformedURLException ex) {
        
        } catch (IOException ex) {

        }

        return code != 200;
    }
}
