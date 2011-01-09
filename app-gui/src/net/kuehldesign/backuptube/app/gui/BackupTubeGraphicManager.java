package net.kuehldesign.backuptube.app.gui;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

public class BackupTubeGraphicManager {
    JFrame frame;

    public BackupTubeGraphicManager() {
        frame = createInterface();
    }

    private JFrame createInterface() {
        JFrame newFrame = new JFrame("BackupTube");
        newFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        addMenuBarToFrame(newFrame);
        addControlsToFrame(newFrame);

        newFrame.pack();
        newFrame.setVisible(true);

        return newFrame;
    }

    private void addMenuBarToFrame(JFrame frame) {
        JMenuBar menuBar = new JMenuBar();
        JMenu helpMenu = new JMenu("Help");
        JMenuItem menuItem;

        menuItem = new JMenuItem("About");
        helpMenu.add(menuItem);

        menuItem = new JMenuItem("Visit Project Page");
        helpMenu.add(menuItem);

        menuBar.add(helpMenu);
        
        frame.setJMenuBar(menuBar);
    }

    private void addControlsToFrame(JFrame frame) {
        
    }
}
