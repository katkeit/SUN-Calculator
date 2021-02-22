package io;

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

import gui.components.About;
import gui.components.Preference;
import gui.Interface;
import gui.components.MenuBar;
import gui.components.StatsTab;
import org.ini4j.Wini;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;

public class Language implements ActionListener
{
    private String language;

    private static FileIO fileIO = new FileIO();
    private ToolTips toolTips = new ToolTips();
    private static String[] updaterPreferences = new String[1];

    public Language(String language) {
        this.language = language;
    }

    @Override
    public void actionPerformed(ActionEvent e)
    {
        setLanguage();
    }

    public void setLanguage()
    {
        Wini ini = null;

        try
        {
            switch (language)
            {
                case "EN" -> {
                    ini = new Wini(new File(FileIO.getEnInterface()));
                    MenuBar.getItemEnglish().setSelected(true);
                    MenuBar.getItemSpanish().setSelected(false);
                    MenuBar.getItemPortuguese().setSelected(false);
                    updaterPreferences[0] = language;
                    fileIO.writeFile("update/config/preferences.txt", updaterPreferences);
                    fileIO.readFile(FileIO.getEnSystem());
                    toolTips.loadToolTips(FileIO.getEnTooltips());
                }
                case "ES" -> {
                    ini = new Wini(new File(FileIO.getEsInterface()));
                    MenuBar.getItemEnglish().setSelected(false);
                    MenuBar.getItemSpanish().setSelected(true);
                    MenuBar.getItemPortuguese().setSelected(false);
                    updaterPreferences[0] = language;
                    fileIO.writeFile("update/config/preferences.txt", updaterPreferences);
                    fileIO.readFile(FileIO.getEsSystem());
                    toolTips.loadToolTips(FileIO.getEsTooltips());
                }
                case "PT" -> {
                    ini = new Wini(new File(FileIO.getPtInterface()));
                    MenuBar.getItemEnglish().setSelected(false);
                    MenuBar.getItemSpanish().setSelected(false);
                    MenuBar.getItemPortuguese().setSelected(true);
                    updaterPreferences[0] = language;
                    fileIO.writeFile("update/config/preferences.txt", updaterPreferences);
                    fileIO.readFile(FileIO.getPtSystem());
                    toolTips.loadToolTips(FileIO.getPtTooltips());
                }
            }
            
            readData(ini);
        }
        catch (IOException ex) {
            StatsTab.getSystemTextArea().append(FileIO.getLanguageMessages().get(0) + " " + ini.getFile() + "!\n\n");
        }
    }

    private void readData(Wini ini)
    {
        // -------- MENU BAR --------
        MenuBar.getMenuFile().setText(ini.get("MENU BAR", "FILE"));
        MenuBar.getItemOpen().setText(ini.get("MENU BAR", "OPEN"));
        MenuBar.getItemSave().setText(ini.get("MENU BAR", "SAVE AS"));
        MenuBar.getMenuLanguage().setText(ini.get("MENU BAR", "LANGUAGE"));
        MenuBar.getItemEnglish().setText(ini.get("MENU BAR", "ENGLISH"));
        MenuBar.getItemSpanish().setText(ini.get("MENU BAR", "SPANISH"));
        MenuBar.getItemPortuguese().setText(ini.get("MENU BAR", "PORTUGUESE"));
        MenuBar.getMenuOption().setText(ini.get("MENU BAR", "OPTIONS"));
        MenuBar.getMenuThemes().setText(ini.get("MENU BAR", "THEMES"));
        MenuBar.getItemLightTheme().setText(ini.get("MENU BAR", "LIGHT"));
        MenuBar.getItemDarkTheme().setText(ini.get("MENU BAR", "DARK"));
        MenuBar.getItemPreferences().setText(ini.get("MENU BAR", "PREFERENCE"));
        MenuBar.getMenuHelp().setText(ini.get("MENU BAR", "HELP"));
        MenuBar.getItemTutorial().setText(ini.get("MENU BAR", "TUTORIAL"));
        MenuBar.getItemContactSupport().setText(ini.get("MENU BAR", "SUPPORT"));
        MenuBar.getItemCheckUpdates().setText(ini.get("MENU BAR", "UPDATE"));
        MenuBar.getItemAbout().setText(ini.get("MENU BAR", "ABOUT"));

        // -------- INTERFACE TABS --------
        Interface.getTabs().setTitleAt(0, ini.get("TABS", "STATS"));
        // -------- CLASS SELECTOR (DROP-DOWN) --------
        StatsTab.getSelectClassBorder().setTitle(ini.get("CLASS SELECTOR", "TITLE"));

        // Update the drop-down box for "Selecting a class".
        updateComboBox(ini);

        // -------- TIPS BORDER --------
        StatsTab.getTipsBorder().setTitle(ini.get("TIPS", "TITLE"));
        // -------- SYSTEM BORDER --------
        StatsTab.getSystemBorder().setTitle(ini.get("SYSTEM", "TITLE"));
        // -------- CHAR INFO BORDER --------
        StatsTab.getCharInfoBorder().setTitle(ini.get("CHAR INFORMATION", "TITLE"));
        // -------- LEVEL BORDER --------
        StatsTab.getLevelBorder().setTitle(ini.get("LEVEL", "TITLE"));
        // -------- STATS --------
        StatsTab.getBaseStatBorder().setTitle(ini.get("STATS", "TITLE"));
        StatsTab.getLblSTR().setText(ini.get("STATS", "STR"));
        StatsTab.getLblAGI().setText(ini.get("STATS", "AGI"));
        StatsTab.getLblVIT().setText(ini.get("STATS", "VIT"));
        StatsTab.getLblINT().setText(ini.get("STATS", "INT"));
        StatsTab.getLblSPI().setText(ini.get("STATS", "SPI"));
        // -------- EXTRA POINTS --------
        StatsTab.getRemainStatBorder().setTitle(ini.get("EXTRA POINTS", "TITLE"));
        // -------- ADDITIONAL STATS --------
        StatsTab.getAddStatBorder().setTitle(ini.get("ADD STATS 1", "TITLE"));
        StatsTab.getSd().setText(ini.get("ADD STATS 1", "SD"));
        StatsTab.getHp().setText(ini.get("ADD STATS 1", "HP"));
        StatsTab.getHp().setText(ini.get("ADD STATS 1", "HP"));
        StatsTab.getSpMp().setText(ini.get("ADD STATS 1", "SP"));
        StatsTab.getBasicDamage().setText(ini.get("ADD STATS 1", "BASIC DAMAGE"));
        StatsTab.getDefense().setText(ini.get("ADD STATS 1", "DEFENSE"));
        StatsTab.getDefenseSuccess().setText(ini.get("ADD STATS 1", "DEFENSE SUCCESS RATE"));
        StatsTab.getAttackSuccess().setText(ini.get("ADD STATS 1", "ATTACK SUCCESS RATE"));
        StatsTab.getAttackSpeed().setText(ini.get("ADD STATS 1", "ATTACK SPEED"));
        StatsTab.getCritChance().setText(ini.get("ADD STATS 1", "CRITICAL CHANCE"));
        StatsTab.getSkillEnh().setText(ini.get("ADD STATS 1", "SKILL ENHANCEMENT"));
        StatsTab.getIncDebuffTime().setText(ini.get("ADD STATS 1", "INCREASE DEBUFF TIME"));
        // -------- ADDITIONAL STATS 2 --------
        StatsTab.getConAddBorder().setTitle(ini.get("ADD STATS 2", "TITLE"));
        // -------- PREFERENCE WINDOW --------
        Preference.getFrame().setTitle(ini.get("PREFERENCES", "TITLE"));
        Preference.getPreferences().setTitle(ini.get("PREFERENCES", "TITLE"));
        Preference.getLanguage().setTitle(ini.get("PREFERENCES", "LANGUAGE"));
        Preference.getEnglish().setText(ini.get("PREFERENCES", "ENGLISH"));
        Preference.getSpanish().setText(ini.get("PREFERENCES", "SPANISH"));
        Preference.getPortuguese().setText(ini.get("PREFERENCES", "PORTUGUESE"));
        Preference.getThemes().setTitle(ini.get("PREFERENCES", "THEMES"));
        Preference.getLightTheme().setText(ini.get("PREFERENCES", "LIGHT"));
        Preference.getDarkTheme().setText(ini.get("PREFERENCES", "DARK"));
        Preference.getApplyButton().setText(ini.get("PREFERENCES", "BUTTON"));
        // -------- ABOUT WINDOW --------
        About.getFrame().setTitle(ini.get("ABOUT", "TITLE"));
        About.getAbout().setTitle(ini.get("ABOUT", "INFORMATION"));
        About.setCalcVersion(ini.get("ABOUT", "PROJECT"));
        About.setDevelopedBy(ini.get("ABOUT", "DEVELOPED"));
        About.setDisclaimer(ini.get("ABOUT", "DISCLAIMER"));

        StatsTab.getSystemTextArea().append(FileIO.getLanguageMessages().get(1) + " " + ini.getFile().toString() + "\n\n");
    }

    private void updateComboBox(Wini ini)
    {
        if(StatsTab.getComboBoxModel().getSize() == 0)
        {
            StatsTab.getSelectClass().addItem(ini.get("CLASS SELECTOR", "DEFAULT"));
            StatsTab.getSelectClass().addItem(ini.get("CLASS SELECTOR", "BERSERKER"));
            StatsTab.getSelectClass().addItem(ini.get("CLASS SELECTOR", "DRAGON KNIGHT"));
//            StatsTab.getSelectClass().addItem(ini.get("CLASS SELECTOR", "VALKYRIE"));
            StatsTab.getSelectClass().addItem(ini.get("CLASS SELECTOR", "ELEMENTALIST"));
            StatsTab.getSelectClass().addItem(ini.get("CLASS SELECTOR", "SHADOW"));
//            StatsTab.getSelectClass().addItem(ini.get("CLASS SELECTOR", "MYSTIC"));
        }
        else
        {
            StatsTab.getComboBoxModel().insertElementAt(ini.get("CLASS SELECTOR", "DEFAULT"), 0);
            StatsTab.getComboBoxModel().removeElementAt(1);
        }
    }
}
