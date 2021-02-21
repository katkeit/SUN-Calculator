package Utility;

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

import FileIO.FileIO;
import Interface.Components.StatsTab;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

public class Updater implements ActionListener
{
    private FileIO fileIO = new FileIO();
    private Downloader downloader = new Downloader();

    @Override
    public void actionPerformed(ActionEvent e)
    {
        checkUpdates();
    }

    public void checkUpdates()
    {
        StatsTab.getSystemTextArea().append(FileIO.getUpdaterMessages().get(0) + "\n\n");

        if(downloader.startDownload(FileIO.getDownloadLink()))
        {
            fileIO.readFile(FileIO.getDownloadFolder() + "version.txt");

            if(FileIO.getAppVersion().matches(FileIO.getUpdateVersion()))
            {
                StatsTab.getSystemTextArea().append(FileIO.getUpdaterMessages().get(1)+ "\n\n");
                fileIO.deleteFile(FileIO.getDownloadFolder() + "version.txt");
            }
            else
            {
                int input = JOptionPane.showOptionDialog(null, FileIO.getUpdaterMessages().get(2) + "\n" + FileIO.getUpdaterMessages().get(3) + "\n" + FileIO.getUpdaterMessages().get(4) + " " + FileIO.getUpdateVersion(),"Update", JOptionPane.YES_NO_OPTION, JOptionPane.INFORMATION_MESSAGE, null, null, null);

                if(input == JOptionPane.YES_OPTION)
                {
                    try
                    {
                        Runtime.getRuntime().exec("java -jar update/updater.jar");
                    }
                    catch (IOException e) {
                        e.printStackTrace();
                    }

                    System.exit(0);
                }
                else if(input == JOptionPane.NO_OPTION)
                {
                    StatsTab.getSystemTextArea().append(FileIO.getUpdaterMessages().get(5) + "\n\n");
                }
            }
        }
        else
            StatsTab.getSystemTextArea().append(FileIO.getUpdaterMessages().get(6) + "\n\n");
    }
}
