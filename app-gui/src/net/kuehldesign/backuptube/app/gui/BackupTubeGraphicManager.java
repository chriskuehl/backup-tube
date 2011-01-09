package net.kuehldesign.backuptube.app.gui;

import java.awt.Container;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
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
        JLabel label;
        JComboBox dropDown;
        JTextField textField;
        JButton button;
        JSeparator separator;
        JPanel panel;
        JTable table;
        TableModel tableModel;
        JScrollPane scrollPane;
        
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
        label = new JLabel("Site:");
        label.setHorizontalAlignment(SwingConstants.RIGHT);

        constraints = new GridBagConstraints();
        constraints.weightx = 0;
        constraints.weighty = 0;
        constraints.fill = GridBagConstraints.HORIZONTAL;
        constraints.gridx = 0;
        constraints.gridy = 0;
        constraints.insets = new Insets(0, 0, 0, 5);

        topPanel.add(label, constraints);

        // site dropdown
        String[] sites = {"YouTube"};
        dropDown = new JComboBox(sites);

        constraints = new GridBagConstraints();
        constraints.weightx = 1;
        constraints.weighty = 0;
        constraints.fill = GridBagConstraints.HORIZONTAL;
        constraints.gridx = 1;
        constraints.gridy = 0;

        topPanel.add(dropDown, constraints);

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

        topPanel.add(label, constraints);

        // user input field
        textField = new JTextField(20);

        constraints = new GridBagConstraints();
        constraints.weightx = 1;
        constraints.weighty = 0;
        constraints.fill = GridBagConstraints.HORIZONTAL;
        constraints.gridx = 1;
        constraints.gridy = 1;

        topPanel.add(textField, constraints);

        // "Folder:" label
        label = new JLabel("Folder:");
        label.setHorizontalAlignment(SwingConstants.RIGHT);

        constraints = new GridBagConstraints();
        constraints.weightx = 0;
        constraints.weighty = 0;
        constraints.fill = GridBagConstraints.HORIZONTAL;
        constraints.gridx = 0;
        constraints.gridy = 2;
        constraints.insets = new Insets(0, 0, 0, 5);

        topPanel.add(label, constraints);

        // browser + label container
        panel = new JPanel(new GridBagLayout());

        label = new JLabel("(no folder selected)");

        constraints = new GridBagConstraints();
        constraints.weightx = 1;
        constraints.weighty = 0;
        constraints.fill = GridBagConstraints.HORIZONTAL;
        constraints.gridx = 0;
        constraints.gridy = 0;

        panel.add(label, constraints);

        button = new JButton("Browse");

        constraints = new GridBagConstraints();
        constraints.weightx = 0;
        constraints.weighty = 0;
        constraints.fill = GridBagConstraints.HORIZONTAL;
        constraints.gridx = 1;
        constraints.gridy = 0;

        panel.add(button, constraints);

        constraints = new GridBagConstraints();
        constraints.weightx = 1;
        constraints.weighty = 0;
        constraints.fill = GridBagConstraints.HORIZONTAL;
        constraints.gridx = 1;
        constraints.gridy = 2;

        topPanel.add(panel, constraints);

        // separator
        separator = new JSeparator(SwingConstants.HORIZONTAL);

        constraints = new GridBagConstraints();
        constraints.weightx = 0;
        constraints.weighty = 0;
        constraints.fill = GridBagConstraints.HORIZONTAL;
        constraints.gridx = 0;
        constraints.gridy = 3;
        constraints.gridwidth = 2;

        topPanel.add(separator, constraints);

        // "Load Videos" button
        button = new JButton("Load Videos");

        constraints = new GridBagConstraints();
        constraints.weightx = 0;
        constraints.weighty = 0;
        constraints.fill = GridBagConstraints.NONE;
        constraints.anchor = GridBagConstraints.EAST;
        constraints.gridx = 1;
        constraints.gridy = 4;

        topPanel.add(button, constraints);

        // video table
        String[] columns = {"", "Title", "Date"};
        

        tableModel = new AbstractTableModel() {
            private String[] columnNames = {"", "Title", "Date"};
            private Object[][] data = {
                                        {false, "Test", "Jan 1"}
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


        table = new JTable(tableModel);
        table.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
        table.getColumnModel().getColumn(0).setPreferredWidth(1);

        constraints = new GridBagConstraints();
        constraints.weightx = 1;
        constraints.weighty = 1;
        constraints.fill = GridBagConstraints.BOTH;
        constraints.gridx = 0;
        constraints.gridy = 5;
        constraints.gridwidth = 2;

        scrollPane = new JScrollPane(table);
        topPanel.add(scrollPane, constraints);
    }
}
