package net.kuehldesign.backuptube.app.common.stored;

import java.util.LinkedList;

public class VideoInfoTable {
    private String infoTableTitle;
    private LinkedList<String[]> infoTableEntries = new LinkedList();

    private String getInfoTableTitle() {
        return infoTableTitle;
    }

    public void setInfoTableTitle(String title) {
        infoTableTitle = title;
    }

    public void addInfoTableEntry(String header, String content) {
        String[] entry = new String[2];

        entry[0] = header;
        entry[1] = content;

        infoTableEntries.add(entry);
    }

    public String getHTML() {
        initInfoTable();
        
        String html = "<h2>" + getInfoTableTitle() + "</h2>\n";
        html += "<table class=\"info\">\n";

        for (String[] entry : infoTableEntries) {
            html += "<tr>\n<th>" + entry[0] + ":</th>\n<td>" + entry[1] + "</td>\n</tr>\n";
        }

        html += "</table>";

        return html;
    }

    public void initInfoTable() {
        // do nothing, this should be overridden
    }
}
