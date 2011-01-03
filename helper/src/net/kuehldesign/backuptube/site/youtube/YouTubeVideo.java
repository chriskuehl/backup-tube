package net.kuehldesign.backuptube.site.youtube;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.util.LinkedList;
import net.kuehldesign.backuptube.BackupHelper;
import net.kuehldesign.backuptube.exception.BadVideoException;
import net.kuehldesign.backuptube.exception.FatalBackupException;
import net.kuehldesign.backuptube.exception.UnableToGetSourceException;

public class YouTubeVideo {
    private YouTubeVideoTitle title;
    private YouTubeVideoDescription content;
    private YouTubeVideoDate published;
    private LinkedList<YouTubeVideoLink> link;
    private boolean hasError = false;

    private int cacheFormatValue = 0;
    private String cacheURL;
    private String cacheToken;

    public String getTitle() {
        return title.getTitle();
    }

    public String getDescription() {
        return content.getDescription();
    }

    public long getPublished() {
        return published.getDate();
    }

    public String getURL() {
        return link.get(0).getURL();
    }

    public String getID() {
        String url = getURL();
        return BackupHelper.between(url, "?v=", "&feature");
    }

//    public String getToken() {
//        return cache_token;
//    }

    private String findToken(String source) throws FatalBackupException, BadVideoException {
        try {
            String t = URLEncoder.encode(BackupHelper.between(source, "\"t\": \"", "\""), "UTF-8");

            if (! t.endsWith("%3D")) {
                t = BackupHelper.betweenMore(source, "&t=", "&", 2);
            }

            if (t == null) {
                // http://www.youtube.com/get_video_info?video_id=ID
                String infoSource;

                try {
                    infoSource = BackupHelper.getSource("http://www.youtube.com/get_video_info?video_id=" + getID());
                } catch (UnableToGetSourceException ex) {
                    throw new BadVideoException("Unable to get source for info");
                }

                String infoSourceUnencoded;

                infoSourceUnencoded = URLDecoder.decode(infoSource, "UTF-8");
                
                if (infoSourceUnencoded.contains("status=fail")) {
                    hasError = true;
                } else {
                    t = BackupHelper.between(infoSourceUnencoded, "&token=", "&");
                }
            }

            return t;
        } catch (UnsupportedEncodingException ex) {
            throw new FatalBackupException("UTF-8 encoding not supported");
        }
    }

    public String getDownloadURL() {
        return cacheURL;
    }

    private void findURLs(String source, String source18) throws FatalBackupException {
        // URL map
        String urlMap = BackupHelper.between(source, "&fmt_url_map=", "&") + "%2C" + BackupHelper.between(source18, "&fmt_url_map=", "&");
        String[] mapParts = urlMap.split("%2C");

        for (String mapPart : mapParts) {
            String[] parts = mapPart.split("%7C");
            String qual;
            String url;

            try {
                qual = URLDecoder.decode(parts[0], "UTF-8");
                url = URLDecoder.decode(parts[1], "UTF-8");
            } catch (UnsupportedEncodingException ex) {
                throw new FatalBackupException("UTF-8 encoding not supported");
            } catch (ArrayIndexOutOfBoundsException ex) {
                continue;
            }

            // qual is an identifier based on the type of video it is (e.g. MP4 High Quality)
            int format = 0;;

            switch (Integer.valueOf(qual)) {
                case 13:
                    format = BackupHelper.FORMAT_3GP_LOW;
                break;

                case 16:
                    format = BackupHelper.FORMAT_3GP_MEDIUM;
                break;

                case 36:
                    format = BackupHelper.FORMAT_3GP_HIGH;
                break;

                case 5:
                    format = BackupHelper.FORMAT_FLV_LOW;
                break;

                case 34:
                    format = BackupHelper.FORMAT_FLV_MEDIUM;
                break;

                case 6:
                    format = BackupHelper.FORMAT_FLV_MEDIUM2;
                break;

                case 35:
                    format = BackupHelper.FORMAT_FLV_HIGH;
                break;

                case 18:
                    format = BackupHelper.FORMAT_MP4_HIGH;
                break;

                case 22:
                    format = BackupHelper.FORMAT_MP4_720P;
                break;

                case 37:
                    format = BackupHelper.FORMAT_MP4_1080P;
                break;

                case 38:
                    format = BackupHelper.FORMAT_MP4_4K;
                break;
            }

            if (cacheFormatValue < format) {
                cacheFormatValue = format;
                cacheURL = url;
            }
        }
    }

    public String getExtension() {
        if (cacheFormatValue >= BackupHelper.FORMAT_MP4_HIGH) {
            return "mp4";
        } else if (cacheFormatValue >= BackupHelper.FORMAT_FLV_LOW) {
            return "flv";
        } else {
            return "3gp";
        }
    }

    public void init() throws FatalBackupException, BadVideoException {
        String source;
        String source18;

        try {
            source = BackupHelper.getSource(getURL());
            source18 = BackupHelper.getSource(getURL() + "&fmt=18");

            cacheToken = findToken(source);
        } catch (Exception ex) {
            ex.printStackTrace();
            throw new BadVideoException(ex.getMessage());
        }

        findURLs(source, source18);
        
        if (getURL() == null || getURL().length() <= 0) {
            throw new BadVideoException("Couldn't get a URL");
        }
    }

    public YouTubeVideo() {
    }
}