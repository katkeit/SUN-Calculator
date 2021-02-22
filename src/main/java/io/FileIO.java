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

import gui.components.StatsTab;
import org.ini4j.Wini;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

public class FileIO
{
    private Wini ini = null;
    // settings.txt
    private static String appVersion;
    private static String clientVersion;
    private static String appIcon;
    private static String enInterface;
    private static String esInterface;
    private static String ptInterface;
    private static String enSystem;
    private static String esSystem;
    private static String ptSystem;
    private static String enTooltips;
    private static String esTooltips;
    private static String ptTooltips;
    private static String enTips;
    private static String esTips;
    private static String ptTips;
    private static String enTutorial;
    private static String esTutorial;
    private static String ptTutorial;
    private static String supportLink;
    private static String maxLevel;
    private static String maxStat;
    private static String downloadFolder;
    private static String downloadLink;
    private static String prefLanguage;
    private static String prefTheme;
    private static String updateVersion;
    private static String updateLink;

    private static final ArrayList<String> buildLoaderMessages = new ArrayList<>();
    private static final ArrayList<String> calcLevelMessages = new ArrayList<>();
    private static final ArrayList<String> calcStatsMessages = new ArrayList<>();
    private static final ArrayList<String> disclaimerMessages = new ArrayList<>();
    private static final ArrayList<String> fileIOMessages = new ArrayList<>();
    private static final ArrayList<String> languageMessages = new ArrayList<>();
    private static final ArrayList<String> tooltipsMessages = new ArrayList<>();
    private static final ArrayList<String> updaterMessages = new ArrayList<>();

    public void readFile(String fileName)
    {
        if(fileName.equals("config/settings.txt"))
            loadSettings(fileName);
        else if(fileName.contains("system"))
            loadSystemMessage(fileName);
        else if(fileName.equals("config/preferences.txt"))
            loadPreferences(fileName);
        else if(fileName.equals("update/download/version.txt"))
            loadVersion(fileName);
    }

    public void writeFile(String fileName, String[] settings)
    {
        switch (fileName) {
            case "config/preferences.txt" -> savePreferences(fileName, settings);
            case "update/config/settings.txt" -> saveUpdaterConfig(fileName, settings);
            case "update/config/preferences.txt" -> saveUpdaterPreferences(fileName, settings);
        }
    }

    private void loadSettings(String fileName)
    {
        try
        {
            ini = new Wini(new File(fileName));

            // ------------- VERSION -------------
            appVersion = ini.get("VERSION", "APP");
            clientVersion = ini.get("VERSION", "CLIENT");

            // ------------- GENERAL -------------
            appIcon = ini.get("GENERAL", "ICON");

            // ------------ INTERFACE ------------
            enInterface = ini.get("INTERFACE", "ENGLISH");
            esInterface = ini.get("INTERFACE", "SPANISH");
            ptInterface = ini.get("INTERFACE", "PORTUGUESE");

            // ------------ SYSTEM ------------
            enSystem = ini.get("SYSTEM", "ENGLISH");
            esSystem = ini.get("SYSTEM", "SPANISH");
            ptSystem = ini.get("SYSTEM", "PORTUGUESE");

            // -------------- TIPS --------------
            enTips = ini.get("TIPS", "ENGLISH");
            esTips = ini.get("TIPS", "SPANISH");
            ptTips = ini.get("TIPS", "PORTUGUESE");

            // -------------- TOOLTIPS --------------
            enTooltips = ini.get("TOOLTIPS", "ENGLISH");
            esTooltips = ini.get("TOOLTIPS", "SPANISH");
            ptTooltips = ini.get("TOOLTIPS", "PORTUGUESE");

            // ------------- TUTORIAL -------------
            enTutorial = ini.get("TUTORIAL", "ENGLISH");
            esTutorial = ini.get("TUTORIAL", "SPANISH");
            ptTutorial = ini.get("TUTORIAL", "PORTUGUESE");

            // ------------- SUPPORT -------------
            supportLink = ini.get("SUPPORT", "LINK");

            // ------------- LEVEL -------------
            maxLevel = ini.get("LEVEL", "MAX LEVEL");

            // ------------- STATS -------------
            maxStat = ini.get("STATS", "MAX STAT");

            // ------------- DOWNLOAD -------------
            downloadFolder = ini.get("DOWNLOAD", "FOLDER");
            downloadLink = ini.get("DOWNLOAD", "LINK");

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void loadSystemMessage(String fileName)
    {
        try
        {
            ini = new Wini(new File(fileName));

            // ------------- BUILDLOADER -------------
            buildLoaderMessages.add(ini.get("BUILDLOADER", "001"));
            buildLoaderMessages.add(ini.get("BUILDLOADER", "002"));
            buildLoaderMessages.add(ini.get("BUILDLOADER", "003"));

            // ------------- CALC_LEVEL -------------
            calcLevelMessages.add(ini.get("CALC_LEVEL", "001"));

            // ------------- CALC_STATS -------------
            calcStatsMessages.add(ini.get("CALC_STATS", "001"));
            calcStatsMessages.add(ini.get("CALC_STATS", "002"));
            calcStatsMessages.add(ini.get("CALC_STATS", "003"));
            calcStatsMessages.add(ini.get("CALC_STATS", "004"));
            calcStatsMessages.add(ini.get("CALC_STATS", "005"));

            // ------------- DISCLAIMER -------------
            disclaimerMessages.add(ini.get("DISCLAIMER", "001"));

            // ------------- FILEIO -------------
            fileIOMessages.add(ini.get("FILEIO", "001"));

            // ------------- LANGUAGE -------------
            languageMessages.add(ini.get("LANGUAGE", "001"));
            languageMessages.add(ini.get("LANGUAGE", "002"));

            // ------------- TOOLTIPS -------------
            tooltipsMessages.add(ini.get("TOOLTIPS", "001"));
            tooltipsMessages.add(ini.get("TOOLTIPS", "002"));

            // ------------- UPDATER -------------
            updaterMessages.add(ini.get("UPDATER", "001"));
            updaterMessages.add(ini.get("UPDATER", "002"));
            updaterMessages.add(ini.get("UPDATER", "003"));
            updaterMessages.add(ini.get("UPDATER", "004"));
            updaterMessages.add(ini.get("UPDATER", "005"));
            updaterMessages.add(ini.get("UPDATER", "006"));
            updaterMessages.add(ini.get("UPDATER", "007"));

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void loadPreferences(String fileName)
    {
        try
        {
            ini = new Wini(new File(fileName));

            // ------------- PREFERENCES -------------
            prefLanguage = ini.get("PREFERENCES", "LANGUAGE");
            prefTheme = ini.get("PREFERENCES", "THEME");

        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void savePreferences(String fileName, String[] settings)
    {
        try
        {
            ini = new Wini(new File(fileName));
            ini.put("PREFERENCES", "LANGUAGE", settings[0]);
            ini.put("PREFERENCES", "THEME", settings[1]);

            ini.store();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void loadVersion(String fileName)
    {
        try
        {
            ini = new Wini(new File(fileName));

            // ------------- CALCULATOR -------------
            updateVersion = ini.get("CALCULATOR", "VERSION");
            updateLink = ini.get("CALCULATOR", "DOWNLOAD");

        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void saveUpdaterConfig(String fileName, String[] settings)
    {
        try
        {
            ini = new Wini(new File(fileName));
            ini.put("GENERAL", "CALC_PATH", settings[0]);
            ini.store();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void saveUpdaterPreferences(String fileName, String[] settings)
    {
        try
        {
            ini = new Wini(new File(fileName));
            ini.put("PREFERENCES", "LANGUAGE", settings[0]);
            ini.store();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void deleteFile(String fileName)
    {
        File file = new File(fileName);

        if(file.exists())
        {
            do {
                if(file.delete())
                    break;
                else
                    StatsTab.getSystemTextArea().append(fileIOMessages.get(0) + " " + fileName + "!");
            } while(!file.delete());
        }

//        if(file.exists())
//            file.delete();
//        else
//            StatsTab.getSystemTextArea().append(fileIOMessages.get(0) + " " + fileName + "!");
    }

    /* -----------------------------------
                   GETTERS
      ----------------------------------- */
    public static String getAppVersion() {
        return appVersion;
    }

    public static String getClientVersion() {
        return clientVersion;
    }

    public static String getAppIcon() {
        return appIcon;
    }

    public static String getEnInterface() {
        return enInterface;
    }

    public static String getEsInterface() {
        return esInterface;
    }

    public static String getPtInterface() {
        return ptInterface;
    }

    public static String getEnTooltips() {
        return enTooltips;
    }

    public static String getEsTooltips() {
        return esTooltips;
    }

    public static String getPtTooltips() {
        return ptTooltips;
    }

    public static String getEnTutorial() {
        return enTutorial;
    }

    public static String getEsTutorial() {
        return esTutorial;
    }

    public static String getPtTutorial() {
        return ptTutorial;
    }

    public static String getSupportLink() {
        return supportLink;
    }

    public static String getMaxLevel() {
        return maxLevel;
    }

    public static String getPrefLanguage() {
        return prefLanguage;
    }

    public static String getPrefTheme() {
        return prefTheme;
    }

    public static String getEnSystem() {
        return enSystem;
    }

    public static String getEsSystem() {
        return esSystem;
    }

    public static String getPtSystem() {
        return ptSystem;
    }

    public static String getDownloadFolder() {
        return downloadFolder;
    }

    public static String getDownloadLink() {
        return downloadLink;
    }

    public static String getUpdateVersion() {
        return updateVersion;
    }

    public static ArrayList<String> getBuildLoaderMessages() {
        return buildLoaderMessages;
    }

    public static ArrayList<String> getCalcLevelMessages() {
        return calcLevelMessages;
    }

    public static ArrayList<String> getCalcStatsMessages() {
        return calcStatsMessages;
    }

    public static ArrayList<String> getDisclaimerMessages() {
        return disclaimerMessages;
    }

    public static ArrayList<String> getLanguageMessages() {
        return languageMessages;
    }

    public static ArrayList<String> getTooltipsMessages() {
        return tooltipsMessages;
    }

    public static ArrayList<String> getUpdaterMessages() {
        return updaterMessages;
    }

    public static String getMaxStat() {
        return maxStat;
    }
}
