package FileIO;

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

import org.ini4j.Wini;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

public class Language
{
    private Wini ini;
    private static FileIO io = new FileIO();

    private static ArrayList<String> updaterMessages = new ArrayList<>();
    private static ArrayList<String> downloaderMessages = new ArrayList<>();
    private static ArrayList<String> extractorMessages = new ArrayList<>();

    public void setLanguage(String language)
    {
        if (language.equals("EN"))
            loadLanguage(FileIO.getEnInterface());
        else if (language.equals("ES"))
            loadLanguage(FileIO.getEsInterface());
        else if (language.equals("PT"))
            loadLanguage(FileIO.getPtInterface());
    }

    private void loadLanguage(String fileName)
    {
        try
        {
            this.ini = new Wini(new File(fileName));

            updaterMessages.add(this.ini.get("UPDATER", "001"));
            updaterMessages.add(this.ini.get("UPDATER", "002"));
            updaterMessages.add(this.ini.get("UPDATER", "003"));
            updaterMessages.add(this.ini.get("UPDATER", "004"));
            updaterMessages.add(this.ini.get("UPDATER", "005"));
            updaterMessages.add(this.ini.get("UPDATER", "006"));
            downloaderMessages.add(this.ini.get("DOWNLOADER", "001"));
            downloaderMessages.add(this.ini.get("DOWNLOADER", "002"));
            extractorMessages.add(this.ini.get("EXTRACTOR", "001"));
            extractorMessages.add(this.ini.get("EXTRACTOR", "002"));
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static ArrayList<String> getUpdaterMessages() {
        return updaterMessages;
    }

    public static ArrayList<String> getDownloaderMessages() {
        return downloaderMessages;
    }

    public static ArrayList<String> getExtractorMessages() {
        return extractorMessages;
    }
}
