package main;

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

import copyright.Disclaimer;
import io.FileIO;
import gui.Interface;
import utility.Utility;
import utility.Updater;

public class Calculator
{
    public static void main(String[] args)
    {
        FileIO fileIO = new FileIO();
        // Calls on readFile method to read and pull data from .txt files.
        fileIO.readFile("config/settings.txt");
        fileIO.readFile("config/preferences.txt");

        Interface gui = new Interface();
        // Calls on createGUI method to create the user interface.
        gui.createGUI();

        // Creates Disclaimer object. This object pushes messages to System Message UI box.
        Disclaimer disclaimer = new Disclaimer();

        Utility utility = new Utility();
        // Calls findDirectory method in Utility object to store absolute path in settings.txt file.
        fileIO.writeFile("update/config/settings.txt", utility.findDirectory());

        Updater updater = new Updater();
        // Calls checkUpdates method for checking new version updates and calling on update/updater.jar.
        updater.checkUpdates();
    }
}
