package copyright;

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
import gui.components.StatsTab;

import java.util.Timer;
import java.util.TimerTask;

public class Disclaimer
{
    private static FileIO io = new FileIO();

    public Disclaimer()
    {
        TimerTask task = new TimerTask() {
            @Override
            public void run() {
                StatsTab.getSystemTextArea().append(FileIO.getDisclaimerMessages().get(0) + "\n\n");
            }
        };

        Timer timer = new Timer("disclaimerTimer", true);
        timer.scheduleAtFixedRate(task, 0, 1200000); //Loops the disclaimer every 20 mins.
    }
}
