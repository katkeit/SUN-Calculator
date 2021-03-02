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

import gui.Interface;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Theme implements ActionListener
{
    // Currently selected theme.
    private String theme;

    public Theme(String theme)
    {
        this.theme = theme;
    }

    @Override
    public void actionPerformed(ActionEvent e)
    {
        initTheme();
    }

    public void initTheme()
    {
        if(theme.equals("LIGHT"))
        {
            MenuBar.getItemLightTheme().setSelected(true);
            MenuBar.getItemDarkTheme().setSelected(false);

            createTheme(Color.WHITE, Color.BLACK, Color.WHITE);
        }
        else if(theme.equals("DARK"))
        {
            MenuBar.getItemDarkTheme().setSelected(true);
            MenuBar.getItemLightTheme().setSelected(false);

            createTheme(Color.BLACK, Color.WHITE, Color.DARK_GRAY);
        }
    }

    private void createTheme(Color primaryColor, Color secondaryColor, Color accentColor)
    {
        // Sets application's background to black.
        Interface.getFrame().getContentPane().setBackground(primaryColor);
        // Set StatsPanel's background to black.
        StatsTab.getStatPanel().setBackground(primaryColor);
        // Sets menu bar's background to black.
        MenuBar.getMenuBar().setBackground(primaryColor);

            /* --------------------
                      File
               -------------------- */
        // Text color for main menu File was set to white.
        MenuBar.getMenuFile().setForeground(secondaryColor);
        // Background color for submenu Open was set to black.
        MenuBar.getItemOpen().setBackground(accentColor);
        // Text color for submenu Open was set to white.
        MenuBar.getItemOpen().setForeground(secondaryColor);
        // Background color for submenu Save was set to black.
        MenuBar.getItemSave().setBackground(accentColor);
        // Text color for submenu Save was set to white.
        MenuBar.getItemSave().setForeground(secondaryColor);

             /* --------------------
                     Language
               -------------------- */
        MenuBar.getMenuLanguage().setForeground(secondaryColor);
        MenuBar.getMenuLanguage().setBackground(primaryColor);
        MenuBar.getItemEnglish().setForeground(secondaryColor);
        MenuBar.getItemEnglish().setBackground(accentColor);
        MenuBar.getItemSpanish().setForeground(secondaryColor);
        MenuBar.getItemSpanish().setBackground(accentColor);
        MenuBar.getItemPortuguese().setForeground(secondaryColor);
        MenuBar.getItemPortuguese().setBackground(accentColor);

        /* --------------------
                 Options
           -------------------- */
        // Text color for main menu Option was set to white.
        MenuBar.getMenuOption().setForeground(secondaryColor);
        // Background color for menu Themes was set to black.
        MenuBar.getMenuThemes().setBackground(accentColor);
        MenuBar.getMenuThemes().setOpaque(true);
        // Text color for menu Themes was set to white.
        MenuBar.getMenuThemes().setForeground(secondaryColor);

        MenuBar.getItemLightTheme().setBackground(accentColor);
        MenuBar.getItemLightTheme().setForeground(secondaryColor);

        MenuBar.getItemDarkTheme().setBackground(accentColor);
        MenuBar.getItemDarkTheme().setForeground(secondaryColor);

        MenuBar.getItemPreferences().setBackground(accentColor);
        MenuBar.getItemPreferences().setForeground(secondaryColor);

        /* ---------------------
                  Help
           --------------------- */
        MenuBar.getMenuHelp().setBackground(primaryColor);
        MenuBar.getMenuHelp().setForeground(secondaryColor);

        MenuBar.getItemTutorial().setBackground(accentColor);
        MenuBar.getItemTutorial().setForeground(secondaryColor);

        MenuBar.getItemCheckUpdates().setBackground(accentColor);
        MenuBar.getItemCheckUpdates().setForeground(secondaryColor);

        MenuBar.getItemContactSupport().setBackground(accentColor);
        MenuBar.getItemContactSupport().setForeground(secondaryColor);

        MenuBar.getItemAbout().setBackground(accentColor);
        MenuBar.getItemAbout().setForeground(secondaryColor);

        /* ---------------------
                  Tabs
           --------------------- */
        Interface.getTabs().setBackground(primaryColor);
        Interface.getTabs().setForeground(secondaryColor);

        /* ---------------------
               Left Section
           --------------------- */
        StatsTab.getCharPanel().setBackground(primaryColor);
        StatsTab.getCharPanel().setForeground(secondaryColor);
        StatsTab.getSelectClass().setBackground(accentColor);
        StatsTab.getSelectClass().setForeground(secondaryColor);
        StatsTab.getSelectClassBorder().setTitleColor(secondaryColor);

        StatsTab.getTipsPanel().setBackground(primaryColor);
        StatsTab.getTipsPanel().setForeground(secondaryColor);
        StatsTab.getTipsBorder().setTitleColor(secondaryColor);

        StatsTab.getTipsTextArea().setBackground(accentColor);
        StatsTab.getTipsTextArea().setForeground(secondaryColor);

        StatsTab.getSystemPanel().setBackground(primaryColor);
        StatsTab.getSystemPanel().setForeground(secondaryColor);
        StatsTab.getSystemBorder().setTitleColor(secondaryColor);

        StatsTab.getSystemTextArea().setBackground(accentColor);
        StatsTab.getSystemTextArea().setForeground(secondaryColor);

        /* ---------------------
              Center Section
           --------------------- */
        StatsTab.getCenterPanel().setBackground(primaryColor);
        StatsTab.getCenterPanel().setForeground(secondaryColor);
        StatsTab.getCharInfoBorder().setTitleColor(secondaryColor);

        StatsTab.getGenCharPanel().setBackground(primaryColor);
        StatsTab.getGenCharPanel().setForeground(secondaryColor);

        StatsTab.getLevelPanel().setBackground(primaryColor);
        StatsTab.getLevelPanel().setForeground(secondaryColor);
        StatsTab.getLevelBorder().setTitleColor(secondaryColor);
        StatsTab.getTfLevel().setBackground(accentColor);
        StatsTab.getTfLevel().setForeground(secondaryColor);

        StatsTab.getBaseStatsPanel().setBackground(primaryColor);
        StatsTab.getBaseStatsPanel().setForeground(secondaryColor);
        StatsTab.getBaseStatBorder().setTitleColor(secondaryColor);

        StatsTab.getTfSTR().setBackground(accentColor);
        StatsTab.getTfSTR().setForeground(secondaryColor);
        StatsTab.getLblSTR().setForeground(secondaryColor);

        StatsTab.getTfAGI().setBackground(accentColor);
        StatsTab.getTfAGI().setForeground(secondaryColor);
        StatsTab.getLblAGI().setForeground(secondaryColor);

        StatsTab.getTfVIT().setBackground(accentColor);
        StatsTab.getTfVIT().setForeground(secondaryColor);
        StatsTab.getLblVIT().setForeground(secondaryColor);

        StatsTab.getTfINT().setBackground(accentColor);
        StatsTab.getTfINT().setForeground(secondaryColor);
        StatsTab.getLblINT().setForeground(secondaryColor);

        StatsTab.getTfSPI().setBackground(accentColor);
        StatsTab.getTfSPI().setForeground(secondaryColor);
        StatsTab.getLblSPI().setForeground(secondaryColor);

        StatsTab.getRemainStatPanel().setBackground(primaryColor);
        StatsTab.getRemainStatPanel().setForeground(secondaryColor);
        StatsTab.getRemainStatBorder().setTitleColor(secondaryColor);
        StatsTab.getRemainStatPoints().setForeground(secondaryColor);

        StatsTab.getAddStatsPanel().setBackground(primaryColor);
        StatsTab.getAddStatsPanel().setForeground(secondaryColor);
        StatsTab.getAddStatBorder().setTitleColor(secondaryColor);

        StatsTab.getSd().setForeground(secondaryColor);
        StatsTab.getSdValue().setForeground(secondaryColor);

        StatsTab.getHp().setForeground(secondaryColor);
        StatsTab.getHpValue().setForeground(secondaryColor);
        StatsTab.getPlus1().setForeground(secondaryColor);
        StatsTab.getHpRecoveryValue().setForeground(secondaryColor);

        StatsTab.getSpMp().setForeground(secondaryColor);
        StatsTab.getSpMPValue().setForeground(secondaryColor);
        StatsTab.getPlus2().setForeground(secondaryColor);
        StatsTab.getSpMpRecoveryValue().setForeground(secondaryColor);

        StatsTab.getBasicDamage().setForeground(secondaryColor);
        StatsTab.getBasicDamageLowValue().setForeground(secondaryColor);
        StatsTab.getTilde().setForeground(secondaryColor);
        StatsTab.getBasicDamageHighValue().setForeground(secondaryColor);
        StatsTab.getPlus3().setForeground(secondaryColor);
        StatsTab.getAddBasicDamageValue().setForeground(secondaryColor);

        StatsTab.getDefense().setForeground(secondaryColor);
        StatsTab.getDefenseValue().setForeground(secondaryColor);
        StatsTab.getPlus4().setForeground(secondaryColor);
        StatsTab.getAddDefenseValue().setForeground(secondaryColor);

        StatsTab.getDefenseSuccess().setForeground(secondaryColor);
        StatsTab.getDefenseSuccessValue().setForeground(secondaryColor);
        StatsTab.getPercent1().setForeground(secondaryColor);

        StatsTab.getAttackSuccess().setForeground(secondaryColor);
        StatsTab.getAttackSuccessValue().setForeground(secondaryColor);
        StatsTab.getPercent2().setForeground(secondaryColor);

        StatsTab.getAttackSpeed().setForeground(secondaryColor);
        StatsTab.getAttackSpeedValue().setForeground(secondaryColor);

        StatsTab.getCritChance().setForeground(secondaryColor);
        StatsTab.getCritChanceValue().setForeground(secondaryColor);
        StatsTab.getPercent3().setForeground(secondaryColor);

        StatsTab.getSkillEnh().setForeground(secondaryColor);
        StatsTab.getSkillEnhValue().setForeground(secondaryColor);

        StatsTab.getIncDebuffTime().setForeground(secondaryColor);
        StatsTab.getIncDebuffTimeValue().setForeground(secondaryColor);
        StatsTab.getSeconds().setForeground(secondaryColor);

        StatsTab.getConAddPanel().setForeground(secondaryColor);
        StatsTab.getConAddPanel().setBackground(primaryColor);
        StatsTab.getConAddBorder().setTitleColor(secondaryColor);

        // Update frame to show changes.
        Interface.getFrame().revalidate();

        /* -------------------------------------------------------------
                            Preference Window
           ------------------------------------------------------------- */
        Preference.getFrame().setForeground(secondaryColor);
        Preference.getFrame().setBackground(primaryColor);
        Preference.getPreferences().setTitleColor(secondaryColor);
        Preference.getPreferencePanel().setForeground(secondaryColor);
        Preference.getPreferencePanel().setBackground(primaryColor);
        Preference.getLanguage().setTitleColor(secondaryColor);
        Preference.getLangPanel().setForeground(secondaryColor);
        Preference.getLangPanel().setBackground(primaryColor);
        Preference.getThemes().setTitleColor(secondaryColor);
        Preference.getThemePanel().setForeground(secondaryColor);
        Preference.getThemePanel().setBackground(primaryColor);
        Preference.getEnglish().setForeground(secondaryColor);
        Preference.getEnglish().setBackground(primaryColor);
        Preference.getSpanish().setForeground(secondaryColor);
        Preference.getSpanish().setBackground(primaryColor);
        Preference.getPortuguese().setForeground(secondaryColor);
        Preference.getPortuguese().setBackground(primaryColor);
        Preference.getLightTheme().setForeground(secondaryColor);
        Preference.getLightTheme().setBackground(primaryColor);
        Preference.getDarkTheme().setForeground(secondaryColor);
        Preference.getDarkTheme().setBackground(primaryColor);

        Preference.getFrame().revalidate();

        /* -------------------------------------------------------------
                                About Window
           ------------------------------------------------------------- */
        About.getFrame().setBackground(primaryColor);
        About.getAboutPanel().setBackground(primaryColor);
        About.getAbout().setTitleColor(secondaryColor);
        About.getTextArea().setBackground(primaryColor);
        About.getTextArea().setForeground(secondaryColor);

        About.getFrame().revalidate();
    }
}
