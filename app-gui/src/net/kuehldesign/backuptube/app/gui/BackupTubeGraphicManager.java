package net.kuehldesign.backuptube.app.gui;

import java.awt.Container;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class BackupTubeGraphicManager {
    JFrame frame;

    public BackupTubeGraphicManager() {
        frame = createInterface();
    }

    private JFrame createInterface() {
        JFrame newFrame = new JFrame("BackupTube");
        newFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        newFrame.setLayout(new GridBagLayout());
        newFrame.setMinimumSize(new Dimension(400, 200));

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
        JTextField textField;
        GridBagConstraints constraints;
        
        Container pane = frame.getContentPane();
        JPanel panel = new JPanel(new GridBagLayout());

        constraints = new GridBagConstraints();
        constraints.weightx = 1;
        constraints.weighty = 1;
        constraints.fill = GridBagConstraints.BOTH;
        constraints.gridx = 0;
        constraints.gridy = 0;
        int padding = 10;
        constraints.insets = new Insets(padding, padding, padding, padding);

        pane.add(panel, constraints);

        // "Site:" label
        label = new JLabel("Site:");
        label.setHorizontalAlignment(SwingConstants.RIGHT);

        constraints = new GridBagConstraints();
        constraints.weightx = 0;
        constraints.weighty = 0;
        constraints.fill = GridBagConstraints.HORIZONTAL;
        constraints.gridx = 0;
        constraints.gridy = 0;
        constraints.insets = new Insets(0, 0, 0, 5);

        panel.add(label, constraints);

        // site dropdown
        String[] sites = {"YouTube"};
        dropDown = new JComboBox(sites);

        constraints = new GridBagConstraints();
        constraints.weightx = 1;
        constraints.weighty = 0;
        constraints.fill = GridBagConstraints.HORIZONTAL;
        constraints.gridx = 1;
        constraints.gridy = 0;

        panel.add(dropDown, constraints);

        // "Site:" label
        label = new JLabel("User:");
        label.setHorizontalAlignment(SwingConstants.RIGHT);

        constraints = new GridBagConstraints();
        constraints.weightx = 0;
        constraints.weighty = 0;
        constraints.fill = GridBagConstraints.HORIZONTAL;
        constraints.gridx = 0;
        constraints.gridy = 1;
        constraints.insets = new Insets(0, 0, 0, 5);

        panel.add(label, constraints);

        // user input field
        textField = new JTextField(20);

        constraints = new GridBagConstraints();
        constraints.weightx = 1;
        constraints.weighty = 0;
        constraints.fill = GridBagConstraints.HORIZONTAL;
        constraints.gridx = 1;
        constraints.gridy = 1;

        panel.add(textField, constraints);
    }
}
