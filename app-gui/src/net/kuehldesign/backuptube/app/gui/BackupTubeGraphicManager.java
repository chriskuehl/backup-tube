package net.kuehldesign.backuptube.app.gui;

import java.awt.Container;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.SwingConstants;
import javax.swing.border.EtchedBorder;

public class BackupTubeGraphicManager {
    JFrame frame;

    public BackupTubeGraphicManager() {
        frame = createInterface();
    }

    private JFrame createInterface() {
        JFrame newFrame = new JFrame("BackupTube");
        newFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        newFrame.setLayout(new GridBagLayout());

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
        JLabel label;
        JComboBox dropDown;
        Container pane = frame.getContentPane();
        
        GridBagConstraints constraints = new GridBagConstraints();

        // "Site:" label
        label = new JLabel("Site:");
        label.setBorder(new EtchedBorder());
        label.setHorizontalAlignment(SwingConstants.RIGHT);

        constraints.weightx = 0;
        constraints.weighty = 0;
        constraints.fill = GridBagConstraints.HORIZONTAL;
        constraints.gridx = 0;
        constraints.gridy = 0;

        pane.add(label, constraints);

        // site dropdown
        String[] sites = {"YouTube"};
        dropDown = new JComboBox(sites);

        constraints.weightx = 1;
        constraints.weighty = 0;
        constraints.fill = GridBagConstraints.HORIZONTAL;
        constraints.gridx = 1;
        constraints.gridy = 0;

        pane.add(dropDown, constraints);

        // "Site:" label
        label = new JLabel("User:");
        label.setBorder(new EtchedBorder());
        label.setHorizontalAlignment(SwingConstants.RIGHT);

        constraints.weightx = 0;
        constraints.weighty = 0;
        constraints.fill = GridBagConstraints.HORIZONTAL;
        constraints.gridx = 0;
        constraints.gridy = 1;

        pane.add(label, constraints);

        // user input field
    }
}
