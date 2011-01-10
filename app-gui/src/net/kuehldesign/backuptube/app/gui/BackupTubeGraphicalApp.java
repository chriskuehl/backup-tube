package net.kuehldesign.backuptube.app.gui;

import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

public class BackupTubeGraphicalApp {
    BackupTubeGraphicManager manager;

    public BackupTubeGraphicalApp() {
        manager = new BackupTubeGraphicManager();
    }

    public static void main(String[] args) {
        // system properties
        System.setProperty("apple.laf.useScreenMenuBar", "true");

        try {
            UIManager.setLookAndFeel(
                UIManager.getSystemLookAndFeelClassName());
        }
        catch (UnsupportedLookAndFeelException ex) {
        }
        catch (ClassNotFoundException ex) {
        }
        catch (InstantiationException ex) {
        }
        catch (IllegalAccessException ex) {
        }

        // make class
        new BackupTubeGraphicalApp();
    }
}