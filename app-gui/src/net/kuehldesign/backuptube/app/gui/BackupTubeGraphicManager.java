package net.kuehldesign.backuptube.app.gui;

import javax.swing.JFrame;

public class BackupTubeGraphicManager {
    JFrame frame;

    public BackupTubeGraphicManager() {
        frame = createInterface();
    }

    private JFrame createInterface() {
        JFrame newFrame = new JFrame("BackupTube");
        newFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        addControlsToFrame(newFrame);

        newFrame.pack();
        newFrame.setVisible(true);

        return newFrame;
    }

    private void addControlsToFrame(JFrame frame) {
        
    }
}
