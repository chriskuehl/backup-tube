package net.kuehldesign.backuptube.video;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class YouTubeVideoDate {
    private String type;
    private String $t;
    
    public YouTubeVideoDate() {

    }

    public long getDate() {
        Date epoch;

        try {
            String myDate = $t;
            myDate = myDate.replaceAll("T", " ");
            myDate = myDate.replaceAll("Z", " ");
            
            epoch = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(myDate);
        } catch (ParseException ex) {
            System.out.println(ex.getMessage());
            return 0;
        }

        return epoch.getTime();
    }
}
