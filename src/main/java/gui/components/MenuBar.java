package gui.components;

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

import io.BuildLoader;
import io.FileIO;
import io.Language;
import utility.Updater;
import utility.Utility;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

public class MenuBar
{
    private final Utility utility = new Utility();

    // JMenuBar holds the JMenu and JMenuItem options.
    private static final JMenuBar menuBar = new JMenuBar();
    // JMenu is a container for the JMenuItem(s).
    private static JMenu menuFile;
    private static JMenu menuLanguage;
    private static JMenu menuOption;
    private static JMenu menuThemes;
    private static JMenu menuHelp;
    // JMenuItem holds each menu option.
    private static JMenuItem itemOpen;
    private static JMenuItem itemSave;
    private static JMenuItem itemPreferences;
    private static JMenuItem itemTutorial;
    private static JMenuItem itemContactSupport;
    private static JMenuItem itemCheckUpdates;
    private static JMenuItem itemAbout;
    private static JRadioButtonMenuItem itemEnglish;
    private static JRadioButtonMenuItem itemSpanish;
    private static JRadioButtonMenuItem itemPortuguese;
    private static JRadioButtonMenuItem itemLightTheme;
    private static JRadioButtonMenuItem itemDarkTheme;

    public JMenuBar initMenuBar()
    {
        // Preferred size of the menu bar.
        menuBar.setPreferredSize(new Dimension(800, 25));

        createFileMenu();
        createLanguageMenu();
        createOptionsMenu();
        createHelpMenu();

        return menuBar;
    }

    private void createFileMenu()
    {
        // Create main menu option called File.
        menuFile = new JMenu("");
        // Add File menu option to the menu bar.
        menuBar.add(menuFile);

        // Create menu item called Open.
        itemOpen = new JMenuItem("");

        // Add the Open item menu to the File menu (File -> Open. Open is a submenu).
        itemOpen.addActionListener(new BuildLoader("Open..."));
        menuFile.add(itemOpen);

        // Create submenu called Save.
        itemSave = new JMenuItem("");

        // Add submenu Save to File menu (File -> Save).
        itemSave.addActionListener(new BuildLoader("Save As..."));
        menuFile.add(itemSave);
    }

    private void createLanguageMenu()
    {
        menuLanguage = new JMenu("");

        itemEnglish = new JRadioButtonMenuItem("");
        itemEnglish.addActionListener(new Language("EN"));
        menuLanguage.add(itemEnglish);

        itemSpanish = new JRadioButtonMenuItem("");
        itemSpanish.addActionListener(new Language("ES"));
        menuLanguage.add(itemSpanish);

        itemPortuguese = new JRadioButtonMenuItem("");
        itemPortuguese.addActionListener(new Language("PT"));
        menuLanguage.add(itemPortuguese);

        menuBar.add(menuLanguage);
    }

    private void createOptionsMenu()
    {
        // Create Option menu.
        menuOption = new JMenu("");

        // Create submenu Change Theme. (Option -> Themes).
        menuThemes = new JMenu("");

        // Create submenu Light Theme. (Option -> Themes -> Light Theme
        itemLightTheme = new JRadioButtonMenuItem("");
        itemLightTheme.addActionListener(new Theme("LIGHT"));
        menuThemes.add(itemLightTheme);

        // Create submenu Dark Theme. (Option -> Themes -> Dark Theme).
        itemDarkTheme = new JRadioButtonMenuItem("");
        itemDarkTheme.addActionListener(new Theme("DARK"));
        menuThemes.add(itemDarkTheme);

        // Add Change Them to Option menu.
        menuOption.add(menuThemes);

        itemPreferences = new JMenuItem("");
        itemPreferences.addActionListener(new Preference());

        menuOption.add(itemPreferences);
        menuBar.add(menuOption);
    }

    private void createHelpMenu()
    {
        menuHelp = new JMenu("");

        itemTutorial = new JMenuItem("");
        itemTutorial.addActionListener((ActionEvent e) -> {
            switch (FileIO.getPrefLanguage()) {
                case "EN" -> utility.openBrowser(FileIO.getEnTutorial(), false);
                case "ES" -> utility.openBrowser(FileIO.getEsTutorial(), false);
                case "PT" -> utility.openBrowser(FileIO.getPtTutorial(), false);
            }
        });

        menuHelp.add(itemTutorial);

        itemCheckUpdates = new JMenuItem("");
        itemCheckUpdates.addActionListener(new Updater());

        menuHelp.add(itemCheckUpdates);

        itemContactSupport = new JMenuItem("");
        itemContactSupport.addActionListener((ActionEvent e) -> utility.openBrowser(FileIO.getSupportLink(), true));

        menuHelp.add(itemContactSupport);

        itemAbout = new JMenuItem("");
        itemAbout.addActionListener(new About());

        menuHelp.add(itemAbout);
        menuBar.add(menuHelp);
    }

    /* ----------------------
             Getters
      ---------------------- */
    public static JMenuBar getMenuBar() {
        return menuBar;
    }

    public static JMenu getMenuFile() {
        return menuFile;
    }

    public static JMenu getMenuOption() {
        return menuOption;
    }

    public static JMenuItem getItemOpen() {
        return itemOpen;
    }

    public static JMenuItem getItemSave() {
        return itemSave;
    }

    public static JMenu getMenuLanguage() {
        return menuLanguage;
    }

    public static JMenuItem getItemEnglish() {
        return itemEnglish;
    }

    public static JMenuItem getItemSpanish() {
        return itemSpanish;
    }

    public static JRadioButtonMenuItem getItemPortuguese() {
        return itemPortuguese;
    }

    public static JMenu getMenuThemes() {
        return menuThemes;
    }

    public static JRadioButtonMenuItem getItemLightTheme() {
        return itemLightTheme;
    }

    public static JRadioButtonMenuItem getItemDarkTheme() {
        return itemDarkTheme;
    }

    public static JMenu getMenuHelp() {
        return menuHelp;
    }

    public static JMenuItem getItemPreferences() {
        return itemPreferences;
    }

    public static JMenuItem getItemContactSupport() {
        return itemContactSupport;
    }

    public static JMenuItem getItemCheckUpdates() {
        return itemCheckUpdates;
    }

    public static JMenuItem getItemAbout() {
        return itemAbout;
    }

    public static JMenuItem getItemTutorial() {
        return itemTutorial;
    }
}
