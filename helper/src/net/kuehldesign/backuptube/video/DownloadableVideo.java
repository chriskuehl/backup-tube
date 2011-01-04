package net.kuehldesign.backuptube.video;

import net.kuehldesign.backuptube.exception.BadVideoException;
import net.kuehldesign.backuptube.exception.FatalBackupException;

public interface DownloadableVideo {
    public String getTitle();
    public String getDescription();
    public long getPublished();
    public String getURL();
    public String getSiteID();
    public String getDownloadURL();
    public String getExtension();
    public void init() throws FatalBackupException, BadVideoException;
}