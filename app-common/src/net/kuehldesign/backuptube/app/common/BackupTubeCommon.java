package net.kuehldesign.backuptube.app.common;

import java.io.File;

public class BackupTubeCommon {
    public static String escapeFileName(String fileName) {
        String newFileName = "";
        String alphanumeric = "abcdefghijklmnopqrstuvwxyzABCDEFGHIZJKLMNOPQRSTUV0234567890 ";

        // make it alphanumeric for max compatibility
        for (int i = 0; i < fileName.length(); i ++) {
            String c = fileName.substring(i, i + 1);

            if (alphanumeric.indexOf(c) > (- 1)) {
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