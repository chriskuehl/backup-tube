package net.kuehldesign.backuptube.app.common;

import java.io.File;

public class BackupTubeCommon {
    // locations of various files and directories; directories should NOT have a trailing slash
    public static final String LOCATION_VIDEOS = "Videos";
    public static final String LOCATION_VIDEOS_DELETED = "Deleted Videos";
    public static final String LOCATION_VIDEO = ""; // video file, relative to video's folder, if using another dir REQUIRES a trailing slash
    public static final String LOCATION_VIDEO_DATAFILE = "video.json"; // data for each video, relative to the video's folder
    public static final String LOCATION_DATAFILE = "data.json"; // data in the root directory with info on all videos

    public static String escapeFileName(String fileName) {
        String newFileName = "";
        String allowedCharacters = "abcdefghijklmnopqrstuvwxyzABCDEFGHIZJKLMNOPQRSTUV0234567890 ";

        // make it alphanumeric for max compatibility
        for (int i = 0; i < fileName.length(); i ++) {
            String c = fileName.substring(i, i + 1);

            if (allowedCharacters.indexOf(c) > (- 1)) {
                newFileName += c;
            }
        }

        return newFileName;
    }

    public static boolean isGoodSaveDir(String saveDir) {
        if (! fileExists(saveDir)) {
            boolean wasCreated = new File(saveDir).mkdirs();

            if (! wasCreated) {
                return false; // permission error etc
            } else {
                return true;
            }
        } else {
            return true;
        }
    }

    public static boolean fileExists(String saveDir) {
        return new File(saveDir).exists();
    }

    public static String fixDir(String dir) {
        if (! dir.endsWith("/")) {
            dir += "/";
        }

        return dir;
    }
}