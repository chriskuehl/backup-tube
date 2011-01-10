package net.kuehldesign.backuptube.app.gui;

import java.awt.Container;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSeparator;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.TableModel;

public class BackupTubeGraphicManager implements ActionListener {
    private JFrame frame;
    private JLabel siteLabel;
    private JComboBox siteDropDown;
    private JLabel userLabel;
    private JTextField userTextBox;
    private JLabel folderLabel;
    private JPanel saveDirectoryPanel;
    private JLabel saveDirectoryLabel;
    private JButton browseButton;
    private JSeparator separator;
    private JButton loadVideosButton;
    private TableModel videosTableModel;
    private JTable videosTable;
    private JScrollPane videosTableScrollPane;
    private JPanel statusPanel;
    private JLabel statusLabel;
    private JButton downloadButton;
    private JButton helpButton;

    public BackupTubeGraphicManager() {
        frame = createInterface();
    }

    private JFrame createInterface() {
        JFrame newFrame = new JFrame("BackupTube");
        newFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        newFrame.setLayout(new GridBagLayout());
        newFrame.setMinimumSize(new Dimension(400, 300));
        newFrame.setPreferredSize(new Dimension(500, 400));
        newFrame.setLocationRelativeTo(null); // center

        // addMenuBarToFrame(newFrame);
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
        GridBagConstraints constraints;
        
        Container pane = frame.getContentPane();
        JPanel topPanel = new JPanel(new GridBagLayout());

        constraints = new GridBagConstraints();
        constraints.weightx = 1;
        constraints.weighty = 1;
        constraints.fill = GridBagConstraints.BOTH;
        constraints.gridx = 0;
        constraints.gridy = 0;
        int padding = 10;
        constraints.insets = new Insets(padding, padding, padding, padding);

        pane.add(topPanel, constraints);

        // "Site:" label
        siteLabel = new JLabel("Site:");
        siteLabel.setHorizontalAlignment(SwingConstants.RIGHT);

        constraints = new GridBagConstraints();
        constraints.weightx = 0;
        constraints.weighty = 0;
        constraints.fill = GridBagConstraints.HORIZONTAL;
        constraints.gridx = 0;
        constraints.gridy = 0;
        constraints.insets = new Insets(0, 0, 5, 5);

        topPanel.add(siteLabel, constraints);

        // site dropdown
        String[] sites = {"YouTube"};
        siteDropDown = new JComboBox(sites);

        constraints = new GridBagConstraints();
        constraints.weightx = 1;
        constraints.weighty = 0;
        constraints.fill = GridBagConstraints.HORIZONTAL;
        constraints.gridx = 1;
        constraints.gridy = 0;
        constraints.insets = new Insets(0, 0, 5, 0);

        topPanel.add(siteDropDown, constraints);

        // "User:" label
        userLabel = new JLabel("User:");
        userLabel.setHorizontalAlignment(SwingConstants.RIGHT);

        constraints = new GridBagConstraints();
        constraints.weightx = 0;
        constraints.weighty = 0;
        constraints.fill = GridBagConstraints.HORIZONTAL;
        constraints.gridx = 0;
        constraints.gridy = 1;
        constraints.insets = new Insets(0, 0, 5, 5);

        topPanel.add(userLabel, constraints);

        // user input field
        userTextBox = new JTextField(20);

        constraints = new GridBagConstraints();
        constraints.weightx = 1;
        constraints.weighty = 0;
        constraints.fill = GridBagConstraints.HORIZONTAL;
        constraints.gridx = 1;
        constraints.gridy = 1;
        constraints.insets = new Insets(0, 0, 5, 0);

        topPanel.add(userTextBox, constraints);

        // "Folder:" label
        folderLabel = new JLabel("Folder:");
        folderLabel.setHorizontalAlignment(SwingConstants.RIGHT);

        constraints = new GridBagConstraints();
        constraints.weightx = 0;
        constraints.weighty = 0;
        constraints.fill = GridBagConstraints.HORIZONTAL;
        constraints.gridx = 0;
        constraints.gridy = 2;
        constraints.insets = new Insets(0, 0, 5, 5);

        topPanel.add(folderLabel, constraints);

        // browser + label container
        saveDirectoryPanel = new JPanel(new GridBagLayout());

        saveDirectoryLabel = new JLabel("(no folder selected)");

        constraints = new GridBagConstraints();
        constraints.weightx = 1;
        constraints.weighty = 0;
        constraints.fill = GridBagConstraints.HORIZONTAL;
        constraints.gridx = 0;
        constraints.gridy = 0;

        saveDirectoryPanel.add(saveDirectoryLabel, constraints);

        browseButton = new JButton("Browse");

        constraints = new GridBagConstraints();
        constraints.weightx = 0;
        constraints.weighty = 0;
        constraints.fill = GridBagConstraints.HORIZONTAL;
        constraints.gridx = 1;
        constraints.gridy = 0;

        saveDirectoryPanel.add(browseButton, constraints);

        constraints = new GridBagConstraints();
        constraints.weightx = 1;
        constraints.weighty = 0;
        constraints.fill = GridBagConstraints.HORIZONTAL;
        constraints.gridx = 1;
        constraints.gridy = 2;
        constraints.insets = new Insets(0, 0, 5, 0);

        topPanel.add(saveDirectoryPanel, constraints);

        // separator
        separator = new JSeparator(SwingConstants.CENTER);
        separator.setPreferredSize(new Dimension(10, 1));

        constraints = new GridBagConstraints();
        constraints.weightx = 1;
        constraints.weighty = 0;
        constraints.fill = GridBagConstraints.HORIZONTAL;
        constraints.gridx = 0;
        constraints.gridy = 3;
        constraints.gridwidth = 2;
        constraints.insets = new Insets(0, 0, 5, 0);

        topPanel.add(separator, constraints);

        // "Load Videos" button
        loadVideosButton = new JButton("Load Videos");
        loadVideosButton.setEnabled(false);

        constraints = new GridBagConstraints();
        constraints.weightx = 0;
        constraints.weighty = 0;
        constraints.fill = GridBagConstraints.NONE;
        constraints.anchor = GridBagConstraints.EAST;
        constraints.gridx = 1;
        constraints.gridy = 4;
        constraints.insets = new Insets(0, 0, 5, 0);

        topPanel.add(loadVideosButton, constraints);

        // video table
        String[] columns = {"", "Title", "Date"};
        

        videosTableModel = new AbstractTableModel() {
            private String[] columnNames = {"Backup", "Title", "Date"};
            private Object[][] data = {
                                        {false, "Test", "January 1, 2011"}
                                      };
            
            @Override
            public String getColumnName(int col) {
                return columnNames[col].toString();
            }

            @Override
            public Class getColumnClass(int c) {
                return getValueAt(0, c).getClass();
            }

            public int getRowCount() {
                return data.length;
            }

            public int getColumnCount() {
                return columnNames.length;
            }

            public Object getValueAt(int row, int col) {
                return data[row][col];
            }

            @Override
            public boolean isCellEditable(int row, int col) {
                return (col == 0);
            }
            
            @Override
            public void setValueAt(Object value, int row, int col) {
                data[row][col] = value;
                fireTableCellUpdated(row, col);
            }
        };


        videosTable = new JTable(videosTableModel);
        videosTable.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
        videosTable.getColumnModel().getColumn(0).setPreferredWidth(1);

        constraints = new GridBagConstraints();
        constraints.weightx = 1;
        constraints.weighty = 1;
        constraints.fill = GridBagConstraints.BOTH;
        constraints.gridx = 0;
        constraints.gridy = 5;
        constraints.gridwidth = 2;

        videosTableScrollPane = new JScrollPane(videosTable);
        topPanel.add(videosTableScrollPane, constraints);

        // status at the bottom
        statusPanel = new JPanel();
        statusPanel.setLayout(new GridBagLayout());

        statusLabel = new JLabel("Status text here...");
        statusLabel.setHorizontalAlignment(SwingConstants.LEFT);

        constraints = new GridBagConstraints();
        constraints.weightx = 1;
        constraints.weighty = 0;
        constraints.fill = GridBagConstraints.HORIZONTAL;
        constraints.gridx = 0;
        constraints.gridy = 0;
        constraints.insets = new Insets(5, 0, 0, 0);

        statusPanel.add(statusLabel, constraints);

        downloadButton = new JButton("Download");
        downloadButton.setEnabled(false);

        constraints = new GridBagConstraints();
        constraints.weightx = 0;
        constraints.weighty = 0;
        constraints.fill = GridBagConstraints.HORIZONTAL;
        constraints.gridx = 1;
        constraints.gridy = 0;
        constraints.insets = new Insets(5, 0, 0, 5);

        statusPanel.add(downloadButton, constraints);

        helpButton = new JButton("Help");
        // button.setPreferredSize(new Dimension(30, (int) button.getPreferredSize().getHeight()));

        constraints = new GridBagConstraints();
        constraints.weightx = 0;
        constraints.weighty = 0;
        constraints.fill = GridBagConstraints.HORIZONTAL;
        constraints.gridx = 2;
        constraints.gridy = 0;
        constraints.insets = new Insets(5, 0, 0, 0);

        statusPanel.add(helpButton, constraints);

        constraints = new GridBagConstraints();
        constraints.weightx = 1;
        constraints.weighty = 0;
        constraints.fill = GridBagConstraints.HORIZONTAL;
        constraints.gridx = 0;
        constraints.gridy = 6;
        constraints.gridwidth = 2;

        topPanel.add(statusPanel, constraints);
    }

    public void actionPerformed(ActionEvent e) {
        System.out.println(e.getSource());
    }
}
