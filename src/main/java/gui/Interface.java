package gui;

/*
    @project SUN Calculator
    @author Katelyn Eitel
    Created on 2/20/2021.

    Copyright (C) 2021  Katelyn Eitel

    This program is free software: you can redistribute it and/or modify
    it under the terms of the GNU General Public License as published by
    the Free Software Foundation, either version 3 of the License, or
    any later version.

    This program is distributed in the hope that it will be useful,
    but WITHOUT ANY WARRANTY; without even the implied warranty of
    MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
    GNU General Public License for more details.

    You should have received a copy of the GNU General Public License
    along with this program.  If not, see <https://www.gnu.org/licenses/>.
*/

import io.FileIO;
import io.Language;
import gui.components.MenuBar;
import gui.components.TabManager;
import gui.components.Theme;

import javax.swing.*;
import java.awt.*;

public class Interface
{
    private final MenuBar menu = new MenuBar();
    private final TabManager tabManager = new TabManager();

    // Entire frame of the GUI.
    private static JFrame frame = new JFrame();
    // A pane that has tabs.
    private static JTabbedPane tabs = new JTabbedPane();
    // The JMenuBar that is passed after creation.
    private static JMenuBar menuBar;

    public void createGUI()
    {
        // Preferred size of the frame.
        frame.setPreferredSize(new Dimension(780, 600));
        // Application's title.
        frame.setTitle("SUN Calculator v" + FileIO.getAppVersion());
        // Application's icon.
        frame.setIconImage(Toolkit.getDefaultToolkit().getImage(FileIO.getAppIcon()));
        // Change application's background to white.
        frame.getContentPane().setBackground(Color.WHITE);
        // Set default's close to the X (Exit button) at top right of frame.
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        // Set frame's layout to BorderLayout.
        frame.setLayout(new BorderLayout());

        // Create all sections of the application.
        menuBar = menu.initMenuBar();

        // Add menu bar to the frame (Northern section).
        frame.add(menuBar, BorderLayout.NORTH);

        tabs.add("Stats", tabManager.create("Stats"));
        tabs.addChangeListener(new TabManager());
        // TODO: Patch in Skills and Armor tabs when Stats panel is 100% complete.
//        tabs.add("Skills", new JPanel());
//        tabs.add("Armor", new JPanel());

        tabs.setBackground(Color.WHITE);

        // Put the tabs underneath the menu bar.
        frame.add(tabs, BorderLayout.CENTER);

        Language language = new Language(FileIO.getPrefLanguage());
        language.setLanguage();

        Theme theme = new Theme(FileIO.getPrefTheme());
        theme.initTheme();

        // Pack and set frame to visible.
        frame.pack();
        frame.setVisible(true);
    }

    /* ----------------------
             Getters
      ---------------------- */
    public static JFrame getFrame() {
        return frame;
    }

    public static JTabbedPane getTabs() {
        return tabs;
    }
}
