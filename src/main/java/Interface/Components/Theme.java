package Interface.Components;

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

import Interface.Interface;

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

            createLightTheme();
        }
        else if(theme.equals("DARK"))
        {
            MenuBar.getItemDarkTheme().setSelected(true);
            MenuBar.getItemLightTheme().setSelected(false);

            createDarkTheme();
        }
    }

    private void createLightTheme()
    {
        // Sets application's background to white.
        Interface.getFrame().getContentPane().setBackground(Color.WHITE);
        // Set StatsPanel's background to white.
        StatsTab.getStatPanel().setBackground(Color.WHITE);
        // Sets menu bar's background to white.
        MenuBar.getMenuBar().setBackground(Color.WHITE);

            /* --------------------
                      File
               -------------------- */
        // Text color for main menu File was set to black.
        MenuBar.getMenuFile().setForeground(Color.BLACK);
        // Background color for submenu Open was set to white.
        MenuBar.getItemOpen().setBackground(Color.WHITE);
        // Text color for submenu Open was set to black.
        MenuBar.getItemOpen().setForeground(Color.BLACK);
        // Background color for submenu Save was set to white.
        MenuBar.getItemSave().setBackground(Color.WHITE);
        // Text color for submenu Save was set to black.
        MenuBar.getItemSave().setForeground(Color.BLACK);

             /* --------------------
                     Language
               -------------------- */
        MenuBar.getMenuLanguage().setForeground(Color.BLACK);
        MenuBar.getMenuLanguage().setBackground(Color.WHITE);
        MenuBar.getItemEnglish().setForeground(Color.BLACK);
        MenuBar.getItemEnglish().setBackground(Color.WHITE);
        MenuBar.getItemSpanish().setForeground(Color.BLACK);
        MenuBar.getItemSpanish().setBackground(Color.WHITE);
        MenuBar.getItemPortuguese().setForeground(Color.BLACK);
        MenuBar.getItemPortuguese().setBackground(Color.WHITE);

            /* --------------------
                   Options
            -------------------- */
        // Text color for main menu Option was set to black.
        MenuBar.getMenuOption().setForeground(Color.BLACK);
        // Background color for submenu Change Theme was set to white.
        MenuBar.getMenuThemes().setBackground(Color.WHITE);
        // Text color for submenu Change Theme was set to black.
        MenuBar.getMenuThemes().setForeground(Color.BLACK);
        MenuBar.getMenuThemes().setOpaque(true);

        MenuBar.getItemLightTheme().setBackground(Color.WHITE);
        MenuBar.getItemLightTheme().setForeground(Color.BLACK);

        MenuBar.getItemDarkTheme().setBackground(Color.WHITE);
        MenuBar.getItemDarkTheme().setForeground(Color.BLACK);

        MenuBar.getItemPreferences().setForeground(Color.BLACK);
        MenuBar.getItemPreferences().setBackground(Color.WHITE);

            /* ---------------------
                      Help
               --------------------- */
        MenuBar.getMenuHelp().setBackground(Color.WHITE);
        MenuBar.getMenuHelp().setForeground(Color.BLACK);

        MenuBar.getItemTutorial().setBackground(Color.WHITE);
        MenuBar.getItemTutorial().setForeground(Color.BLACK);

        MenuBar.getItemCheckUpdates().setBackground(Color.WHITE);
        MenuBar.getItemCheckUpdates().setForeground(Color.BLACK);

        MenuBar.getItemContactSupport().setBackground(Color.WHITE);
        MenuBar.getItemContactSupport().setForeground(Color.BLACK);

        MenuBar.getItemAbout().setBackground(Color.WHITE);
        MenuBar.getItemAbout().setForeground(Color.BLACK);

        /* ---------------------
                  Tabs
           --------------------- */
        Interface.getTabs().setBackground(Color.WHITE);
        Interface.getTabs().setForeground(Color.BLACK);

        /* ---------------------
               Left Section
           --------------------- */
        StatsTab.getCharPanel().setBackground(Color.WHITE);
        StatsTab.getCharPanel().setForeground(Color.BLACK);
        StatsTab.getSelectClass().setBackground(Color.WHITE);
        StatsTab.getSelectClass().setForeground(Color.BLACK);
        StatsTab.getSelectClassBorder().setTitleColor(Color.BLACK);

        StatsTab.getTipsPanel().setBackground(Color.WHITE);
        StatsTab.getTipsPanel().setForeground(Color.BLACK);
        StatsTab.getTipsBorder().setTitleColor(Color.BLACK);

        StatsTab.getTipsTextArea().setBackground(Color.WHITE);
        StatsTab.getTipsTextArea().setForeground(Color.BLACK);

        StatsTab.getSystemPanel().setBackground(Color.WHITE);
        StatsTab.getSystemPanel().setForeground(Color.BLACK);
        StatsTab.getSystemBorder().setTitleColor(Color.BLACK);

        StatsTab.getSystemTextArea().setBackground(Color.WHITE);
        StatsTab.getSystemTextArea().setForeground(Color.BLACK);

        /* ---------------------
              Center Section
           --------------------- */
        StatsTab.getCenterPanel().setBackground(Color.WHITE);
        StatsTab.getCenterPanel().setForeground(Color.BLACK);
        StatsTab.getCharInfoBorder().setTitleColor(Color.BLACK);

        StatsTab.getGenCharPanel().setBackground(Color.WHITE);
        StatsTab.getGenCharPanel().setForeground(Color.BLACK);

        StatsTab.getLevelPanel().setBackground(Color.WHITE);
        StatsTab.getLevelPanel().setForeground(Color.BLACK);
        StatsTab.getLevelBorder().setTitleColor(Color.BLACK);
        StatsTab.getTfLevel().setBackground(Color.WHITE);
        StatsTab.getTfLevel().setForeground(Color.BLACK);

        StatsTab.getBaseStatsPanel().setBackground(Color.WHITE);
        StatsTab.getBaseStatsPanel().setForeground(Color.BLACK);
        StatsTab.getBaseStatBorder().setTitleColor(Color.BLACK);

        StatsTab.getTfSTR().setBackground(Color.WHITE);
        StatsTab.getTfSTR().setForeground(Color.BLACK);
        StatsTab.getLblSTR().setForeground(Color.BLACK);

        StatsTab.getTfAGI().setBackground(Color.WHITE);
        StatsTab.getTfAGI().setForeground(Color.BLACK);
        StatsTab.getLblAGI().setForeground(Color.BLACK);

        StatsTab.getTfVIT().setBackground(Color.WHITE);
        StatsTab.getTfVIT().setForeground(Color.BLACK);
        StatsTab.getLblVIT().setForeground(Color.BLACK);

        StatsTab.getTfINT().setBackground(Color.WHITE);
        StatsTab.getTfINT().setForeground(Color.BLACK);
        StatsTab.getLblINT().setForeground(Color.BLACK);

        StatsTab.getTfSPI().setBackground(Color.WHITE);
        StatsTab.getTfSPI().setForeground(Color.BLACK);
        StatsTab.getLblSPI().setForeground(Color.BLACK);

        StatsTab.getRemainStatPanel().setBackground(Color.WHITE);
        StatsTab.getRemainStatPanel().setForeground(Color.BLACK);
        StatsTab.getRemainStatBorder().setTitleColor(Color.BLACK);
        StatsTab.getRemainStatPoints().setForeground(Color.BLACK);

        StatsTab.getAddStatsPanel().setBackground(Color.WHITE);
        StatsTab.getAddStatsPanel().setForeground(Color.BLACK);
        StatsTab.getAddStatBorder().setTitleColor(Color.BLACK);

        StatsTab.getSd().setForeground(Color.BLACK);
        StatsTab.getSdValue().setForeground(Color.BLACK);

        StatsTab.getHp().setForeground(Color.BLACK);
        StatsTab.getHpValue().setForeground(Color.BLACK);
        StatsTab.getPlus1().setForeground(Color.BLACK);
        StatsTab.getHpRecoveryValue().setForeground(Color.BLACK);

        StatsTab.getSpMp().setForeground(Color.BLACK);
        StatsTab.getSpMPValue().setForeground(Color.BLACK);
        StatsTab.getPlus2().setForeground(Color.BLACK);
        StatsTab.getSpMpRecoveryValue().setForeground(Color.BLACK);

        StatsTab.getBasicDamage().setForeground(Color.BLACK);
        StatsTab.getBasicDamageLowValue().setForeground(Color.BLACK);
        StatsTab.getTilde().setForeground(Color.BLACK);
        StatsTab.getBasicDamageHighValue().setForeground(Color.BLACK);
        StatsTab.getPlus3().setForeground(Color.BLACK);
        StatsTab.getAddBasicDamageValue().setForeground(Color.BLACK);

        StatsTab.getDefense().setForeground(Color.BLACK);
        StatsTab.getDefenseValue().setForeground(Color.BLACK);
        StatsTab.getPlus4().setForeground(Color.BLACK);
        StatsTab.getAddDefenseValue().setForeground(Color.BLACK);

        StatsTab.getDefenseSuccess().setForeground(Color.BLACK);
        StatsTab.getDefenseSuccessValue().setForeground(Color.BLACK);
        StatsTab.getPercent1().setForeground(Color.BLACK);

        StatsTab.getAttackSuccess().setForeground(Color.BLACK);
        StatsTab.getAttackSuccessValue().setForeground(Color.BLACK);
        StatsTab.getPercent2().setForeground(Color.BLACK);

        StatsTab.getAttackSpeed().setForeground(Color.BLACK);
        StatsTab.getAttackSpeedValue().setForeground(Color.BLACK);

        StatsTab.getCritChance().setForeground(Color.BLACK);
        StatsTab.getCritChanceValue().setForeground(Color.BLACK);
        StatsTab.getPercent3().setForeground(Color.BLACK);

        StatsTab.getSkillEnh().setForeground(Color.BLACK);
        StatsTab.getSkillEnhValue().setForeground(Color.BLACK);

        StatsTab.getIncDebuffTime().setForeground(Color.BLACK);
        StatsTab.getIncDebuffTimeValue().setForeground(Color.BLACK);
        StatsTab.getSeconds().setForeground(Color.BLACK);

        StatsTab.getConAddPanel().setForeground(Color.BLACK);
        StatsTab.getConAddPanel().setBackground(Color.WHITE);
        StatsTab.getConAddBorder().setTitleColor(Color.BLACK);

        // Update frame to show changes.
        Interface.getFrame().revalidate();

        /* -------------------------------------------------------------
                            Preference Window
           ------------------------------------------------------------- */
        Preference.getFrame().setForeground(Color.BLACK);
        Preference.getFrame().setBackground(Color.WHITE);
        Preference.getPreferences().setTitleColor(Color.BLACK);
        Preference.getPreferencePanel().setForeground(Color.BLACK);
        Preference.getPreferencePanel().setBackground(Color.WHITE);
        Preference.getLanguage().setTitleColor(Color.BLACK);
        Preference.getLangPanel().setForeground(Color.BLACK);
        Preference.getLangPanel().setBackground(Color.WHITE);
        Preference.getThemes().setTitleColor(Color.BLACK);
        Preference.getThemePanel().setForeground(Color.BLACK);
        Preference.getThemePanel().setBackground(Color.WHITE);
        Preference.getEnglish().setForeground(Color.BLACK);
        Preference.getEnglish().setBackground(Color.WHITE);
        Preference.getSpanish().setForeground(Color.BLACK);
        Preference.getSpanish().setBackground(Color.WHITE);
        Preference.getPortuguese().setForeground(Color.BLACK);
        Preference.getPortuguese().setBackground(Color.WHITE);
        Preference.getLightTheme().setForeground(Color.BLACK);
        Preference.getLightTheme().setBackground(Color.WHITE);
        Preference.getDarkTheme().setForeground(Color.BLACK);
        Preference.getDarkTheme().setBackground(Color.WHITE);

        Preference.getFrame().revalidate();

        /* -------------------------------------------------------------
                                About Window
           ------------------------------------------------------------- */
        About.getFrame().setBackground(Color.WHITE);
        About.getAboutPanel().setBackground(Color.WHITE);
        About.getAbout().setTitleColor(Color.BLACK);
        About.getTextArea().setBackground(Color.WHITE);
        About.getTextArea().setForeground(Color.BLACK);

        About.getFrame().revalidate();
    }

    private void createDarkTheme()
    {
        // Sets application's background to black.
        Interface.getFrame().getContentPane().setBackground(Color.BLACK);
        // Set StatsPanel's background to black.
        StatsTab.getStatPanel().setBackground(Color.BLACK);
        // Sets menu bar's background to black.
        MenuBar.getMenuBar().setBackground(Color.BLACK);

            /* --------------------
                      File
               -------------------- */
        // Text color for main menu File was set to white.
        MenuBar.getMenuFile().setForeground(Color.WHITE);
        // Background color for submenu Open was set to black.
        MenuBar.getItemOpen().setBackground(Color.DARK_GRAY);
        // Text color for submenu Open was set to white.
        MenuBar.getItemOpen().setForeground(Color.WHITE);
        // Background color for submenu Save was set to black.
        MenuBar.getItemSave().setBackground(Color.DARK_GRAY);
        // Text color for submenu Save was set to white.
        MenuBar.getItemSave().setForeground(Color.WHITE);

             /* --------------------
                     Language
               -------------------- */
        MenuBar.getMenuLanguage().setForeground(Color.WHITE);
        MenuBar.getMenuLanguage().setBackground(Color.BLACK);
        MenuBar.getItemEnglish().setForeground(Color.WHITE);
        MenuBar.getItemEnglish().setBackground(Color.DARK_GRAY);
        MenuBar.getItemSpanish().setForeground(Color.WHITE);
        MenuBar.getItemSpanish().setBackground(Color.DARK_GRAY);
        MenuBar.getItemPortuguese().setForeground(Color.WHITE);
        MenuBar.getItemPortuguese().setBackground(Color.DARK_GRAY);

        /* --------------------
                 Options
           -------------------- */
        // Text color for main menu Option was set to white.
        MenuBar.getMenuOption().setForeground(Color.WHITE);
        // Background color for menu Themes was set to black.
        MenuBar.getMenuThemes().setBackground(Color.DARK_GRAY);
        MenuBar.getMenuThemes().setOpaque(true);
        // Text color for menu Themes was set to white.
        MenuBar.getMenuThemes().setForeground(Color.WHITE);

        MenuBar.getItemLightTheme().setBackground(Color.DARK_GRAY);
        MenuBar.getItemLightTheme().setForeground(Color.WHITE);

        MenuBar.getItemDarkTheme().setBackground(Color.DARK_GRAY);
        MenuBar.getItemDarkTheme().setForeground(Color.WHITE);

        MenuBar.getItemPreferences().setBackground(Color.DARK_GRAY);
        MenuBar.getItemPreferences().setForeground(Color.WHITE);

        /* ---------------------
                  Help
           --------------------- */
        MenuBar.getMenuHelp().setBackground(Color.BLACK);
        MenuBar.getMenuHelp().setForeground(Color.WHITE);

        MenuBar.getItemTutorial().setBackground(Color.DARK_GRAY);
        MenuBar.getItemTutorial().setForeground(Color.WHITE);

        MenuBar.getItemCheckUpdates().setBackground(Color.DARK_GRAY);
        MenuBar.getItemCheckUpdates().setForeground(Color.WHITE);

        MenuBar.getItemContactSupport().setBackground(Color.DARK_GRAY);
        MenuBar.getItemContactSupport().setForeground(Color.WHITE);

        MenuBar.getItemAbout().setBackground(Color.DARK_GRAY);
        MenuBar.getItemAbout().setForeground(Color.WHITE);

        /* ---------------------
                  Tabs
           --------------------- */
        Interface.getTabs().setBackground(Color.BLACK);
        Interface.getTabs().setForeground(Color.WHITE);

        /* ---------------------
               Left Section
           --------------------- */
        StatsTab.getCharPanel().setBackground(Color.BLACK);
        StatsTab.getCharPanel().setForeground(Color.WHITE);
        StatsTab.getSelectClass().setBackground(Color.DARK_GRAY);
        StatsTab.getSelectClass().setForeground(Color.WHITE);
        StatsTab.getSelectClassBorder().setTitleColor(Color.WHITE);

        StatsTab.getTipsPanel().setBackground(Color.BLACK);
        StatsTab.getTipsPanel().setForeground(Color.WHITE);
        StatsTab.getTipsBorder().setTitleColor(Color.WHITE);

        StatsTab.getTipsTextArea().setBackground(Color.DARK_GRAY);
        StatsTab.getTipsTextArea().setForeground(Color.WHITE);

        StatsTab.getSystemPanel().setBackground(Color.BLACK);
        StatsTab.getSystemPanel().setForeground(Color.WHITE);
        StatsTab.getSystemBorder().setTitleColor(Color.WHITE);

        StatsTab.getSystemTextArea().setBackground(Color.DARK_GRAY);
        StatsTab.getSystemTextArea().setForeground(Color.WHITE);

        /* ---------------------
              Center Section
           --------------------- */
        StatsTab.getCenterPanel().setBackground(Color.BLACK);
        StatsTab.getCenterPanel().setForeground(Color.WHITE);
        StatsTab.getCharInfoBorder().setTitleColor(Color.WHITE);

        StatsTab.getGenCharPanel().setBackground(Color.BLACK);
        StatsTab.getGenCharPanel().setForeground(Color.WHITE);

        StatsTab.getLevelPanel().setBackground(Color.BLACK);
        StatsTab.getLevelPanel().setForeground(Color.WHITE);
        StatsTab.getLevelBorder().setTitleColor(Color.WHITE);
        StatsTab.getTfLevel().setBackground(Color.DARK_GRAY);
        StatsTab.getTfLevel().setForeground(Color.WHITE);

        StatsTab.getBaseStatsPanel().setBackground(Color.BLACK);
        StatsTab.getBaseStatsPanel().setForeground(Color.WHITE);
        StatsTab.getBaseStatBorder().setTitleColor(Color.WHITE);

        StatsTab.getTfSTR().setBackground(Color.DARK_GRAY);
        StatsTab.getTfSTR().setForeground(Color.WHITE);
        StatsTab.getLblSTR().setForeground(Color.WHITE);

        StatsTab.getTfAGI().setBackground(Color.DARK_GRAY);
        StatsTab.getTfAGI().setForeground(Color.WHITE);
        StatsTab.getLblAGI().setForeground(Color.WHITE);

        StatsTab.getTfVIT().setBackground(Color.DARK_GRAY);
        StatsTab.getTfVIT().setForeground(Color.WHITE);
        StatsTab.getLblVIT().setForeground(Color.WHITE);

        StatsTab.getTfINT().setBackground(Color.DARK_GRAY);
        StatsTab.getTfINT().setForeground(Color.WHITE);
        StatsTab.getLblINT().setForeground(Color.WHITE);

        StatsTab.getTfSPI().setBackground(Color.DARK_GRAY);
        StatsTab.getTfSPI().setForeground(Color.WHITE);
        StatsTab.getLblSPI().setForeground(Color.WHITE);

        StatsTab.getRemainStatPanel().setBackground(Color.BLACK);
        StatsTab.getRemainStatPanel().setForeground(Color.WHITE);
        StatsTab.getRemainStatBorder().setTitleColor(Color.WHITE);
        StatsTab.getRemainStatPoints().setForeground(Color.WHITE);

        StatsTab.getAddStatsPanel().setBackground(Color.BLACK);
        StatsTab.getAddStatsPanel().setForeground(Color.WHITE);
        StatsTab.getAddStatBorder().setTitleColor(Color.WHITE);

        StatsTab.getSd().setForeground(Color.WHITE);
        StatsTab.getSdValue().setForeground(Color.WHITE);

        StatsTab.getHp().setForeground(Color.WHITE);
        StatsTab.getHpValue().setForeground(Color.WHITE);
        StatsTab.getPlus1().setForeground(Color.WHITE);
        StatsTab.getHpRecoveryValue().setForeground(Color.WHITE);

        StatsTab.getSpMp().setForeground(Color.WHITE);
        StatsTab.getSpMPValue().setForeground(Color.WHITE);
        StatsTab.getPlus2().setForeground(Color.WHITE);
        StatsTab.getSpMpRecoveryValue().setForeground(Color.WHITE);

        StatsTab.getBasicDamage().setForeground(Color.WHITE);
        StatsTab.getBasicDamageLowValue().setForeground(Color.WHITE);
        StatsTab.getTilde().setForeground(Color.WHITE);
        StatsTab.getBasicDamageHighValue().setForeground(Color.WHITE);
        StatsTab.getPlus3().setForeground(Color.WHITE);
        StatsTab.getAddBasicDamageValue().setForeground(Color.WHITE);

        StatsTab.getDefense().setForeground(Color.WHITE);
        StatsTab.getDefenseValue().setForeground(Color.WHITE);
        StatsTab.getPlus4().setForeground(Color.WHITE);
        StatsTab.getAddDefenseValue().setForeground(Color.WHITE);

        StatsTab.getDefenseSuccess().setForeground(Color.WHITE);
        StatsTab.getDefenseSuccessValue().setForeground(Color.WHITE);
        StatsTab.getPercent1().setForeground(Color.WHITE);

        StatsTab.getAttackSuccess().setForeground(Color.WHITE);
        StatsTab.getAttackSuccessValue().setForeground(Color.WHITE);
        StatsTab.getPercent2().setForeground(Color.WHITE);

        StatsTab.getAttackSpeed().setForeground(Color.WHITE);
        StatsTab.getAttackSpeedValue().setForeground(Color.WHITE);

        StatsTab.getCritChance().setForeground(Color.WHITE);
        StatsTab.getCritChanceValue().setForeground(Color.WHITE);
        StatsTab.getPercent3().setForeground(Color.WHITE);

        StatsTab.getSkillEnh().setForeground(Color.WHITE);
        StatsTab.getSkillEnhValue().setForeground(Color.WHITE);

        StatsTab.getIncDebuffTime().setForeground(Color.WHITE);
        StatsTab.getIncDebuffTimeValue().setForeground(Color.WHITE);
        StatsTab.getSeconds().setForeground(Color.WHITE);

        StatsTab.getConAddPanel().setForeground(Color.WHITE);
        StatsTab.getConAddPanel().setBackground(Color.BLACK);
        StatsTab.getConAddBorder().setTitleColor(Color.WHITE);

        // Update frame to show changes.
        Interface.getFrame().revalidate();

        /* -------------------------------------------------------------
                            Preference Window
           ------------------------------------------------------------- */
        Preference.getFrame().setForeground(Color.WHITE);
        Preference.getFrame().setBackground(Color.BLACK);
        Preference.getPreferences().setTitleColor(Color.WHITE);
        Preference.getPreferencePanel().setForeground(Color.WHITE);
        Preference.getPreferencePanel().setBackground(Color.BLACK);
        Preference.getLanguage().setTitleColor(Color.WHITE);
        Preference.getLangPanel().setForeground(Color.WHITE);
        Preference.getLangPanel().setBackground(Color.BLACK);
        Preference.getThemes().setTitleColor(Color.WHITE);
        Preference.getThemePanel().setForeground(Color.WHITE);
        Preference.getThemePanel().setBackground(Color.BLACK);
        Preference.getEnglish().setForeground(Color.WHITE);
        Preference.getEnglish().setBackground(Color.BLACK);
        Preference.getSpanish().setForeground(Color.WHITE);
        Preference.getSpanish().setBackground(Color.BLACK);
        Preference.getPortuguese().setForeground(Color.WHITE);
        Preference.getPortuguese().setBackground(Color.BLACK);
        Preference.getLightTheme().setForeground(Color.WHITE);
        Preference.getLightTheme().setBackground(Color.BLACK);
        Preference.getDarkTheme().setForeground(Color.WHITE);
        Preference.getDarkTheme().setBackground(Color.BLACK);

        Preference.getFrame().revalidate();

        /* -------------------------------------------------------------
                                About Window
           ------------------------------------------------------------- */
        About.getFrame().setBackground(Color.BLACK);
        About.getAboutPanel().setBackground(Color.BLACK);
        About.getAbout().setTitleColor(Color.WHITE);
        About.getTextArea().setBackground(Color.BLACK);
        About.getTextArea().setForeground(Color.WHITE);

        About.getFrame().revalidate();
    }
}
