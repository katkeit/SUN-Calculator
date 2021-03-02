package character;

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
import utility.Convert;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CalcLevel implements ActionListener, ICharacter
{
    private String className;
    private int currentLevel = 0;
    private int originalLevel = 0;
    private static int  hp;
    private static int hpRec;
    private static int spMp;

    private Convert convert = new Convert();

    @Override
    public void actionPerformed(ActionEvent e)
    {
        className = StatsTab.getcName();
        validateLevel();
        calculateLevel();
    }

    private void validateLevel()
    {
        currentLevel = convert.stringToInt(StatsTab.getTfLevel().getText());
        int maxLevel = Integer.parseInt(FileIO.getMaxLevel());

        if(originalLevel == 0)
            originalLevel = currentLevel;

        if(currentLevel < 1)
        {
            currentLevel = 1;
            originalLevel = 1;
            StatsTab.getTfLevel().setText("1");
        }
        else if (currentLevel > maxLevel)
        {
            currentLevel = maxLevel;
            originalLevel = maxLevel;
            StatsTab.getTfLevel().setText(String.valueOf(currentLevel));
        }
        else
        {
            resetLevel();
            StatsTab.getTfLevel().setText(String.valueOf(currentLevel));
        }


        if(currentLevel < originalLevel)
            resetLevel();

        originalLevel = currentLevel;
    }

    private void calculateLevel()
    {
        StatsTab.getRemainStatPoints().setText(String.valueOf((currentLevel - 1) * 5));

        switch (className) {
            case "Berserker" -> {
                hp = Integer.parseInt(berserkerBaseAddStats[1]) + (berserkerLevelGrowth[1] * (currentLevel - 1));
                hpRec = Integer.parseInt(berserkerBaseAddStats[2]);
                spMp = Integer.parseInt(berserkerBaseAddStats[3]) + (berserkerLevelGrowth[3] * (currentLevel - 1));

                StatsTab.getSdValue().setText(String.valueOf(calculateSD()));
                StatsTab.getHpValue().setText(String.valueOf(hp));
                StatsTab.getHpRecoveryValue().setText(String.valueOf(calculateHPR(false, 2)));
                StatsTab.getSpMPValue().setText(String.valueOf(spMp));
            }
            case "Dragon Knight" -> {
                hp = Integer.parseInt(dkBaseAddStats[1]) + (dkLevelGrowth[1] * (currentLevel - 1));
                hpRec = Integer.parseInt(dkBaseAddStats[2]);
                spMp = Integer.parseInt(dkBaseAddStats[3]) + (dkLevelGrowth[3] * (currentLevel - 1));

                StatsTab.getSdValue().setText(String.valueOf(calculateSD()));
                StatsTab.getHpValue().setText(String.valueOf(hp));
                StatsTab.getHpRecoveryValue().setText(String.valueOf(calculateHPR(false, 1)));
                StatsTab.getSpMPValue().setText(String.valueOf(spMp));
            }
            case "Valkyrie" -> {
                hp = Integer.parseInt(valkBaseAddStats[1]) + (valkLevelGrowth[1] * (currentLevel - 1));
                hpRec = Integer.parseInt(valkBaseAddStats[2]);
                spMp = Integer.parseInt(valkBaseAddStats[3]) + (valkLevelGrowth[3] * (currentLevel - 1));

                StatsTab.getSdValue().setText(String.valueOf(calculateSD()));
                StatsTab.getHpValue().setText(String.valueOf(hp));
                StatsTab.getHpRecoveryValue().setText(String.valueOf(calculateHPR(true, 1)));
                StatsTab.getSpMPValue().setText(String.valueOf(spMp));
            }
            case "Elementalist" -> {
                hp = Integer.parseInt(eleBaseAddStats[1]) + (eleLevelGrowth[1] * (currentLevel - 1));
                hpRec = Integer.parseInt(eleBaseAddStats[2]);
                spMp = Integer.parseInt(eleBaseAddStats[3]) + (eleLevelGrowth[3] * (currentLevel - 1));

                StatsTab.getSdValue().setText(String.valueOf(calculateSD()));
                StatsTab.getHpValue().setText(String.valueOf(hp));
                StatsTab.getHpRecoveryValue().setText(String.valueOf(calculateHPR(true, 1)));
                StatsTab.getSpMPValue().setText(String.valueOf(spMp));
            }
            case "Shadow" -> {
                hp = Integer.parseInt(shadowBaseAddStats[1]) + (shadowLevelGrowth[1] * (currentLevel - 1));
                hpRec = Integer.parseInt(shadowBaseAddStats[2]);
                spMp = (Integer.parseInt(shadowBaseAddStats[3]) + calculateMP(true));

                StatsTab.getSdValue().setText(String.valueOf(calculateSD()));
                StatsTab.getHpValue().setText(String.valueOf(hp));
                StatsTab.getHpRecoveryValue().setText(String.valueOf(calculateHPR(false, 1)));
                StatsTab.getSpMPValue().setText(String.valueOf(spMp));
            }
            default -> StatsTab.getSystemTextArea().append(FileIO.getCalcLevelMessages().get(0) + className + "\n\n");
        }
    }

    private int calculateSD()
    {
        int sd = 201;
        int sdCounter;
        int sdAmount;

        sdCounter = 0;
        sdAmount = 1;

        for(int i = 1; i < currentLevel; i++)
        {
            sdCounter += 1;

            if((sdCounter % 2) == 0)
                sdAmount += 2;

            sd += sdAmount;
        }

        return sd;
    }

    private int calculateHPR(boolean twoPattern, int hprCounter)
    {
        for(int i = 1; i <= currentLevel; i++)
        {
            if (hprCounter == 3 && !twoPattern)
            {
                hpRec += 1;
                hprCounter = 1;
                twoPattern = true;
            }
            else if (hprCounter == 2 && twoPattern)
            {
                hpRec += 1;
                hprCounter = 1;
                twoPattern = false;
            }
            else
                hprCounter += 1;
        }

        return hpRec;
    }

    private int calculateMP(boolean eightPattern)
    {
        int mpGained = 0;

        if(className.equals("Shadow"))
        {
            for(int i = 1; i < currentLevel; i++)
            {
                if(eightPattern)
                {
                    mpGained += 8;
                    eightPattern = false;
                }
                else
                {
                    mpGained += 9;
                    eightPattern = true;
                }
            }
        }

        return mpGained;
    }

    private void resetLevel()
    {
        StatsTab.getTfSTR().setText("");
        StatsTab.getTfAGI().setText("");
        StatsTab.getTfVIT().setText("");
        StatsTab.getTfINT().setText("");
        StatsTab.getTfSPI().setText("");
        StatsTab.getRemainStatPoints().setText("");
        StatsTab.getSdValue().setText("");
        StatsTab.getHpValue().setText("");
        StatsTab.getPlus1().setText("");
        StatsTab.getHpRecoveryValue().setText("");
        StatsTab.getSpMPValue().setText("");
        StatsTab.getPlus2().setText("");
        StatsTab.getSpMpRecoveryValue().setText("");
        StatsTab.getBasicDamageLowValue().setText("");
        StatsTab.getTilde().setText("");
        StatsTab.getBasicDamageHighValue().setText("");
        StatsTab.getDefenseValue().setText("");
        StatsTab.getPlus3().setText("");
        StatsTab.getAddDefenseValue().setText("");
        StatsTab.getDefenseSuccessValue().setText("");
        StatsTab.getPercent1().setText("");
        StatsTab.getAttackSuccessValue().setText("");
        StatsTab.getPercent2().setText("");
        StatsTab.getAttackSpeedValue().setText("");
        StatsTab.getCritChanceValue().setText("");
        StatsTab.getPercent3().setText("");
        StatsTab.getSkillEnhValue().setText("");
        StatsTab.getIncDebuffTimeValue().setText("");
        StatsTab.getSeconds().setText("");

        Character character = new Character(className);

        StatsTab.getTfLevel().setText(String.valueOf(currentLevel));
    }

    // GETTER
    public static int getHp() {
    return hp;
}

    public static int getHpRec() {
    return hpRec;
}

    public static int getSpMp() {
    return spMp;
}
}
