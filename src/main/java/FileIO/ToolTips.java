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

import Interface.Components.StatsTab;
import org.ini4j.Wini;

import java.io.File;
import java.io.IOException;

public class ToolTips
{
    private Wini ini = null;

    public void loadToolTips(String fileName)
    {
        try
        {
            ini = new Wini(new File(fileName));
            // -------- CLASS SELECTOR --------
            StatsTab.getSelectClass().setToolTipText(ini.get("CLASS SELECTOR", "SELECTOR"));
            // -------- LEVEL --------
            StatsTab.getTfLevel().setToolTipText(ini.get("LEVEL", "LEVEL"));
            // -------- STATS --------
            StatsTab.getLblSTR().setToolTipText(ini.get("STATS", "STR"));
            StatsTab.getLblAGI().setToolTipText(ini.get("STATS", "AGI"));
            StatsTab.getLblVIT().setToolTipText(ini.get("STATS", "VIT"));
            StatsTab.getLblINT().setToolTipText(ini.get("STATS", "INT"));
            StatsTab.getLblSPI().setToolTipText(ini.get("STATS", "SPI"));
            // -------- EXTRA POINTS --------
            StatsTab.getRemainStatPoints().setToolTipText(ini.get("EXTRA POINTS", "POINTS"));
            // -------- ADDITIONAL STATS --------
            StatsTab.getSd().setToolTipText(ini.get("ADDITIONAL STATS", "SD"));
            StatsTab.getHp().setToolTipText(ini.get("ADDITIONAL STATS", "HP"));
            StatsTab.getSpMp().setToolTipText(ini.get("ADDITIONAL STATS", "SPMP"));
            StatsTab.getBasicDamage().setToolTipText(ini.get("ADDITIONAL STATS", "BASIC DAMAGE"));
            StatsTab.getDefense().setToolTipText(ini.get("ADDITIONAL STATS", "DEFENSE"));
            StatsTab.getDefenseSuccess().setToolTipText(ini.get("ADDITIONAL STATS", "DEF SUCCESS RATE"));
            StatsTab.getAttackSuccess().setToolTipText(ini.get("ADDITIONAL STATS", "ATT SUCCESS RATE"));
            StatsTab.getAttackSpeed().setToolTipText(ini.get("ADDITIONAL STATS", "ATT SPEED"));
            StatsTab.getCritChance().setToolTipText(ini.get("ADDITIONAL STATS", "CRIT CHANCE"));
            StatsTab.getSkillEnh().setToolTipText(ini.get("ADDITIONAL STATS", "SKILL ENHANCEMENT"));
            StatsTab.getIncDebuffTime().setToolTipText(ini.get("ADDITIONAL STATS", "DEBUFF TIME"));
            // -------- ADDITIONAL STATS --------
            StatsTab.getSystemTextArea().setToolTipText(ini.get("SYSTEM MESSAGES", "SYSTEM"));

            StatsTab.getSystemTextArea().append(FileIO.getTooltipsMessages().get(0) + "\n\n");
        }
        catch (IOException e) {
            e.printStackTrace();
            StatsTab.getSystemTextArea().append(FileIO.getTooltipsMessages().get(1) + "\n\n");
        }
    }
}
