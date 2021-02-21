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

import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class BuildLoader implements ActionListener
{
    private JFrame parentFrame = new JFrame();
    private JFileChooser fileChooser = new JFileChooser();
    private FileNameExtensionFilter filter = new FileNameExtensionFilter(".txt", "txt");
    private File file = null;
    private Wini ini = null;
    private String ioAction;

    public BuildLoader(String ioAction)
    {
        this.ioAction = ioAction;
    }

    @Override
    public void actionPerformed(ActionEvent e)
    {
        fileChooser.setFileFilter(filter);

        if(ioAction.equals("Open..."))
        {
            fileChooser.setDialogTitle("Open file...");
            int userSelection = fileChooser.showOpenDialog(parentFrame);

            if(userSelection == JFileChooser.APPROVE_OPTION)
            {
                file = fileChooser.getSelectedFile();

                loadData();
            }

            StatsTab.getSystemTextArea().append(FileIO.getBuildLoaderMessages().get(0) + " " + file.getName() + "\n\n");
        }
        else if(ioAction.equals("Save As..."))
        {
            fileChooser.setDialogTitle("Save file...");
            int userSelection = fileChooser.showSaveDialog(parentFrame);

            if(userSelection == JFileChooser.APPROVE_OPTION)
            {
                file = fileChooser.getSelectedFile();

                String temp = file.getAbsolutePath();

                if(!temp.endsWith(".txt"))
                    file = new File(temp + ".txt");

                saveData();

                StatsTab.getSystemTextArea().append(FileIO.getBuildLoaderMessages().get(1) + " " + file.getName() + "!\n\n");
            }
        }

    }

    private void loadData()
    {
        try
        {
            ini = new Wini(new File(file.getAbsolutePath()));

            StatsTab.getSelectClass().setSelectedItem(ini.get("CLASS", "CLASS"));
            //ini.put("CLASS", "BUILD", "");

            StatsTab.getTfLevel().setText(ini.get("LEVEL", "LEVEL"));
            StatsTab.getRemainStatPoints().setText(ini.get("LEVEL", "EXTRA POINTS"));

            StatsTab.getTfSTR().setText(ini.get("STATS", "STR"));
            StatsTab.getTfAGI().setText(ini.get("STATS", "AGI"));
            StatsTab.getTfVIT().setText(ini.get("STATS", "VIT"));
            StatsTab.getTfINT().setText(ini.get("STATS", "INT"));
            StatsTab.getTfSPI().setText(ini.get("STATS", "SPI"));

            StatsTab.getSdValue().setText(ini.get("ADD STATS 1", "SD"));
            StatsTab.getHpValue().setText(ini.get("ADD STATS 1", "HP"));
            StatsTab.getHpRecoveryValue().setText(ini.get("ADD STATS 1", "HP RECOVERY"));
            StatsTab.getSpMPValue().setText(ini.get("ADD STATS 1", "SPMP"));
            StatsTab.getSpMpRecoveryValue().setText(ini.get("ADD STATS 1", "SPMP RECOVERY"));
            StatsTab.getBasicDamageLowValue().setText(ini.get("ADD STATS 1", "DAMAGE LOW"));
            StatsTab.getBasicDamageHighValue().setText(ini.get("ADD STATS 1", "DAMAGE HIGH"));
            StatsTab.getAddBasicDamageValue().setText(ini.get("ADD STATS 1", "ADD DAMAGE"));
            StatsTab.getDefenseValue().setText(ini.get("ADD STATS 1", "DEFENSE"));
            StatsTab.getAddDefenseValue().setText(ini.get("ADD STATS 1", "ADD DEFENSE"));
            StatsTab.getDefenseSuccessValue().setText(ini.get("ADD STATS 1", "DEF SUCCESS RATE"));
            StatsTab.getAttackSuccessValue().setText(ini.get("ADD STATS 1", "ATT SUCCESS RATE"));
            StatsTab.getAttackSpeedValue().setText(ini.get("ADD STATS 1", "ATTACK SPEED"));
            StatsTab.getCritChanceValue().setText(ini.get("ADD STATS 1", "CRITICAL CHANCE"));
            StatsTab.getSkillEnhValue().setText(ini.get("ADD STATS 1", "SKILL ENHANCEMENT"));
            StatsTab.getIncDebuffTimeValue().setText(ini.get("ADD STATS 1", "INC DEBUFF TIME"));
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void saveData()
    {
        try
        {
            Date date = new Date();
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("MM/dd/yyyy HH:mm:ss");

            if(!file.exists())
            {
                if(file.createNewFile())
                {
                    ini = new Wini(new File(file.toString()));
                    ini.put("GENERAL", "CREATED ON", simpleDateFormat.format(date));
                }
                else
                    StatsTab.getSystemTextArea().append(FileIO.getBuildLoaderMessages().get(2) + file.getName() + "!\n\n");

            }
            else
            {
                ini = new Wini(new File(fileChooser.getSelectedFile().getAbsolutePath()));
            }

            ini.put("GENERAL", "MODIFIED ON", simpleDateFormat.format(date));
            ini.put("GENERAL", "VERSION", "KR SUN v" + FileIO.getClientVersion());

            ini.put("CLASS", "CLASS", StatsTab.getcName());
            //ini.put("CLASS", "BUILD", "");

            ini.put("LEVEL", "LEVEL", StatsTab.getTfLevel().getText());
            ini.put("LEVEL", "EXTRA POINTS", StatsTab.getRemainStatPoints().getText());

            ini.put("STATS", "STR", StatsTab.getTfSTR().getText());
            ini.put("STATS", "AGI", StatsTab.getTfAGI().getText());
            ini.put("STATS", "VIT", StatsTab.getTfVIT().getText());
            ini.put("STATS", "INT", StatsTab.getTfINT().getText());
            ini.put("STATS", "SPI", StatsTab.getTfSPI().getText());

            ini.put("ADD STATS 1", "SD", StatsTab.getSdValue().getText());
            ini.put("ADD STATS 1", "HP", StatsTab.getHpValue().getText());
            ini.put("ADD STATS 1", "HP RECOVERY", StatsTab.getHpRecoveryValue().getText());
            ini.put("ADD STATS 1", "SPMP", StatsTab.getSpMPValue().getText());
            ini.put("ADD STATS 1", "SPMP RECOVERY", StatsTab.getSpMpRecoveryValue().getText());
            ini.put("ADD STATS 1", "DAMAGE LOW", StatsTab.getBasicDamageLowValue().getText());
            ini.put("ADD STATS 1", "DAMAGE HIGH", StatsTab.getBasicDamageHighValue().getText());
            ini.put("ADD STATS 1", "ADD DAMAGE", StatsTab.getAddBasicDamageValue().getText());
            ini.put("ADD STATS 1", "DEFENSE", StatsTab.getDefenseValue().getText());
            ini.put("ADD STATS 1", "ADD DEFENSE", StatsTab.getAddDefenseValue().getText());
            ini.put("ADD STATS 1", "DEF SUCCESS RATE", StatsTab.getDefenseSuccessValue().getText());
            ini.put("ADD STATS 1", "ATT SUCCESS RATE", StatsTab.getAttackSuccessValue().getText());
            ini.put("ADD STATS 1", "ATTACK SPEED", StatsTab.getAttackSpeedValue().getText());
            ini.put("ADD STATS 1", "CRITICAL CHANCE", StatsTab.getCritChanceValue().getText());
            ini.put("ADD STATS 1", "SKILL ENHANCEMENT", StatsTab.getSkillEnhValue().getText());
            ini.put("ADD STATS 1", "INC DEBUFF TIME", StatsTab.getIncDebuffTimeValue().getText());

            ini.store();
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }
}
