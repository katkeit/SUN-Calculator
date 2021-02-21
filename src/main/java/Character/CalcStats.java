package Character;

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
import Utility.Convert;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CalcStats implements ActionListener, iCharacter
{
    private String statName;
    private int baseSTR, baseAGI, baseVIT, baseINT, baseSPI, inputStat, previousStat = -1;

    private Convert convert = new Convert();

    /* ------------------------------------------------------------------------------------------------------------- */
    //                                              CONSTRUCTOR
    /* ------------------------------------------------------------------------------------------------------------- */
    public CalcStats(String statName)
    {
        this.statName = statName;
    }

    /* ------------------------------------------------------------------------------------------------------------- */
    //                                              ACTION LISTENER
    /* ------------------------------------------------------------------------------------------------------------- */
    @Override
    public void actionPerformed(ActionEvent e)
    {
        String className = StatsTab.getcName();

        switch (className)
        {
            case "Berserker":
            {
                baseSTR = Integer.parseInt(berserkerBaseStats[0]);
                baseAGI = Integer.parseInt(berserkerBaseStats[1]);
                baseVIT = Integer.parseInt(berserkerBaseStats[2]);
                baseINT = Integer.parseInt(berserkerBaseStats[3]);
                baseSPI = Integer.parseInt(berserkerBaseStats[4]);

                validateStat(className);
                break;
            }
            case "Dragon Knight":
            {
                baseSTR = Integer.parseInt(dkBaseStats[0]);
                baseAGI = Integer.parseInt(dkBaseStats[1]);
                baseVIT = Integer.parseInt(dkBaseStats[2]);
                baseINT = Integer.parseInt(dkBaseStats[3]);
                baseSPI = Integer.parseInt(dkBaseStats[4]);

                validateStat(className);
                break;
            }
            case "Valkyrie":
            {
                baseSTR = Integer.parseInt(valkBaseStats[0]);
                baseAGI = Integer.parseInt(valkBaseStats[1]);
                baseVIT = Integer.parseInt(valkBaseStats[2]);
                baseINT = Integer.parseInt(valkBaseStats[3]);
                baseSPI = Integer.parseInt(valkBaseStats[4]);

                validateStat(className);
                break;
            }
            case "Elementalist":
            {
                baseSTR = Integer.parseInt(eleBaseStats[0]);
                baseAGI = Integer.parseInt(eleBaseStats[1]);
                baseVIT = Integer.parseInt(eleBaseStats[2]);
                baseINT = Integer.parseInt(eleBaseStats[3]);
                baseSPI = Integer.parseInt(eleBaseStats[4]);

                validateStat(className);
                break;
            }
            case "Shadow":
            {
                baseSTR = Integer.parseInt(shadowBaseStats[0]);
                baseAGI = Integer.parseInt(shadowBaseStats[1]);
                baseVIT = Integer.parseInt(shadowBaseStats[2]);
                baseINT = Integer.parseInt(shadowBaseStats[3]);
                baseSPI = Integer.parseInt(shadowBaseStats[4]);

                validateStat(className);
                break;
            }
            default:
            {
                StatsTab.getSystemTextArea().append(FileIO.getCalcStatsMessages().get(0) + " " + className + "\n\n");
                break;
            }
        }
    }

    /* ------------------------------------------------------------------------------------------------------------- */
    //                                           VALIDATE STATS
    /* ------------------------------------------------------------------------------------------------------------- */
    private void validateStat(String className)
    {
        JTextField component;
        int currentStatValue;

        switch (statName)
        {
            case "STR":
            {
                inputStat = convert.stringToInt(StatsTab.getTfSTR().getText());

                component = StatsTab.getTfSTR();
                component.setText(String.valueOf(inputStat));

                currentStatValue = calcRemainStatPoints(statName, baseSTR, inputStat);
                StatsTab.getTfSTR().setText(String.valueOf(currentStatValue));
                calculateSTR(className);

                break;
            }
            case "AGI":
            {
                inputStat = convert.stringToInt(StatsTab.getTfAGI().getText());

                component = StatsTab.getTfAGI();
                component.setText(String.valueOf(inputStat));

                currentStatValue = calcRemainStatPoints(statName, baseAGI, inputStat);
                StatsTab.getTfAGI().setText(String.valueOf(currentStatValue));
                calculateAGI(className);

                break;
            }
            case "VIT":
            {
                inputStat = convert.stringToInt(StatsTab.getTfVIT().getText());

                component = StatsTab.getTfVIT();
                component.setText(String.valueOf(inputStat));

                currentStatValue = calcRemainStatPoints(statName, baseVIT, inputStat);
                StatsTab.getTfVIT().setText(String.valueOf(currentStatValue));
                calculateVIT(className);

                break;
            }
            case "INT":
            {
                inputStat = convert.stringToInt(StatsTab.getTfINT().getText());

                component = StatsTab.getTfINT();
                component.setText(String.valueOf(inputStat));

                currentStatValue = calcRemainStatPoints(statName, baseINT, inputStat);
                StatsTab.getTfINT().setText(String.valueOf(currentStatValue));
                calculateINT();

                break;
            }
            case "SPI":
            {
                inputStat = convert.stringToInt(StatsTab.getTfSPI().getText());

                component = StatsTab.getTfSPI();
                component.setText(String.valueOf(inputStat));

                currentStatValue = calcRemainStatPoints(statName, baseSPI, inputStat);
                StatsTab.getTfSPI().setText(String.valueOf(currentStatValue));
                calculateSPI(className);

                break;
            }
            default:
            {
                StatsTab.getSystemTextArea().append(FileIO.getCalcStatsMessages().get(1) + statName + "\n\n");
            }
        }
    }

    /* ------------------------------------------------------------------------------------------------------------- */
    //                                              STRENGTH
    /* ------------------------------------------------------------------------------------------------------------- */
    private void calculateSTR(String className)
    {
        JLabel lowValue = StatsTab.getBasicDamageLowValue();
        JLabel highValue = StatsTab.getBasicDamageHighValue();
        int lowDamage = 0, highDamage = 0;

        if(className.equals("Berserker"))
        {
            for(int i = 1; i <= inputStat; i++)
            {
                if((i % 6) == 0)
                {
                    lowDamage += 1;
                    highDamage += 1;
                }
                else if((i % 2) == 0)
                    highDamage += 1;
            }
        }
        else if(className.equals("Dragon Knight"))
        {
            for(int i = 1; i <= inputStat; i++)
            {
                if((i % 15) == 0)
                {
                    lowDamage += 1;
                    highDamage += 1;
                }
                else if ((i % 5) == 0)
                    lowDamage += 1;
                else if((i % 3) == 0)
                    highDamage += 1;
            }
        }
        else if(className.equals("Valkyrie") || className.equals("Shadow"))
        {
            for(int i = 0; i <= inputStat; i++)
            {
                if((i % 4) == 0)
                    highDamage += 1;

                if((i % 8) == 0)
                    lowDamage += 1;

            }
        }
        else if(className.equals("Elementalist"))
        {
            for(int i = 1; i <= inputStat; i++)
            {
                if((i % 4) == 0)
                    highDamage += 1;

                if((i % 9) == 0)
                    lowDamage += 1;
            }
        }

        lowValue.setText(String.valueOf(lowDamage));
        highValue.setText(String.valueOf(highDamage));
    }

    /* ------------------------------------------------------------------------------------------------------------- */
    //                                              AGILITY
    /* ------------------------------------------------------------------------------------------------------------- */
    private void calculateAGI(String className)
    {
        JLabel attSuccessRate = StatsTab.getAttackSuccessValue();
        JLabel attSpeed = StatsTab.getAttackSpeedValue();
        JLabel critChance = StatsTab.getCritChanceValue();

        int baseASR = 0, baseAS = 150, baseCC = 0;
        int asCounter, ccCounter, ccPattern;

        if(className.equals("Berserker"))
        {
            baseAS = 150;
            asCounter = 1;

            baseASR = calcAttackSuccessRate(className, false,11, 0);
            baseCC = calcCriticalChance(className,1, false,0, 1);

            for(int i = 1; i <= inputStat; i++)
            {
                asCounter++;

                if((asCounter % 8) == 0)
                    baseAS += 1;
            }
        }
        else if(className.equals("Dragon Knight"))
        {
            baseCC = 3;
            ccPattern = 17;
            ccCounter = 14;
            int incCounter = 1;

            baseAS = calcAttackSpeed(className,true,2,1,11,10,150,1);
            baseASR = calcAttackSuccessRate(className,true,9,2);

            for(int i = 1; i <= inputStat; i++)
            {
                // ----------- Critical Chance -----------
                if(ccCounter == ccPattern)
                {
                    baseCC += 1;

                    if(ccPattern > 18)
                        incCounter += 3;

                    ccPattern += incCounter;
                    ccCounter = 0;
                }

                ccCounter++;
            }
        }
        else if(className.equals("Valkyrie"))
        {
            baseCC = 1;
            ccCounter = 4;
            int maxIteration = 7;
            int increaseIteration = 1;

            baseASR = calcAttackSuccessRate(className,true,9,2);
            baseAS = calcAttackSpeed(className,true, 2,1, 13,14, 150, 0);


            //TODO: Fix Valk's CC. Need more information.
            // ----------- Critical Chance -----------
            for(int i = 1; i <= inputStat; i++)
            {
                if(ccCounter == maxIteration)
                {

                }

                ccCounter++;
            }
        }
        else if(className.equals("Elementalist"))
        {
            baseCC = 1;
            ccCounter = 7;
            int maxIteration = 9;
            int increaseIteration = 3;

            baseASR = calcAttackSuccessRate(className, true, 9, 2);
            baseAS = calcAttackSpeed(className,false,2,1,9,10, 150,1);

            // baseCC = 1, ccCounter = 7, maxIteration = 9, increaseIteration = 3,
            for(int i = 1; i <= inputStat; i++)
            {
                if(ccCounter == maxIteration)
                {
                    baseCC += 1;
                    maxIteration += increaseIteration;
                    increaseIteration += 1;
                    ccCounter = 0;
                }

                ccCounter++;
            }
        }
        else if(className.equals("Shadow"))
        {
            asCounter = 1;

            baseASR = calcAttackSuccessRate(className,false,11,0);
            baseCC = calcCriticalChance(className,2,true,1,5);

            for(int i = 1; i <= inputStat; i++)
            {
                if((asCounter % 12) == 0)
                    baseAS += 1;

                asCounter++;
            }
        }

        attSuccessRate.setText(String.valueOf(baseASR));
        attSpeed.setText(String.valueOf(baseAS));
        critChance.setText(String.valueOf(baseCC));
    }

    /* ----------------------------------------------------------- */
    //                        SUB-FUNCTIONS
    /* ----------------------------------------------------------- */
    /**
     *
     * @param className
     * @param rotation // Is there rotation?
     * @param maxRotationIteration // What is the max rotation iterations?
     * @param currentRotationIteration // What is the starting rotation iteration?
     * @param rotationValue // What is the value of the rotating number?
     * @param nonRotationValue // What is the value of the nonrotating number?
     * @return
     */
    private int calcAttackSpeed(String className, boolean rotation, int maxRotationIteration, int currentRotationIteration, int rotationValue, int nonRotationValue, int baseAS, int asCounter)
    {
        if(className.equals("Dragon Knight") || className.equals("Valkyrie") || className.equals("Elementalist"))
        {
            for(int i = 1; i <= inputStat; i++)
            {
                if(!rotation && asCounter == nonRotationValue)
                {
                    baseAS += 1;
                    asCounter = 0;
                    rotation = true;
                }
                else if(rotation && asCounter == rotationValue && currentRotationIteration != maxRotationIteration)
                {
                    baseAS += 1;
                    currentRotationIteration += 1;
                    asCounter = 0;
                }
                else if(rotation && asCounter == rotationValue && currentRotationIteration == maxRotationIteration)
                {
                    baseAS += 1;
                    asCounter = 0;
                    currentRotationIteration = 1;

                    rotation = false;
                }

                asCounter++;
            }

        }

        return baseAS;
    }

    /**
     * @param className
     * @param pattern17 Does the class start with the 17 pattern?
     * @param asrCounter Where does there ASR start in the pattern?
     * @param asr17Counter Where is the 17 pattern at? The 1st or 2nd iteration?
     * @return
     */
    private int calcAttackSuccessRate(String className, boolean pattern17, int asrCounter, int asr17Counter)
    {
        int baseASR = 0;

        if (className.equals("Dragon Knight") || className.equals("Valkyrie") || className.equals("Elementalist"))
        {
            for (int i = 1; i <= inputStat; i++)
            {
                if (pattern17 && asrCounter == 17 && asr17Counter == 1)
                {
                    baseASR += 1;
                    asr17Counter += 1;
                    asrCounter = 0;
                }
                else if (pattern17 && asrCounter == 17 && asr17Counter == 2)
                {
                    baseASR += 1;
                    pattern17 = false;

                    asr17Counter = 1;
                    asrCounter = 0;
                }
                else if (!pattern17 && asrCounter == 16)
                {
                    baseASR += 1;
                    pattern17 = true;

                    asrCounter = 0;
                }

                asrCounter++;
            }
        }

        if(className.equals("Berserker") || className.equals("Shadow"))
        {
            for(int i = 1; i <= inputStat; i++)
            {
                if((asrCounter % 17) == 0)
                    baseASR += 1;

                asrCounter++;
            }
        }

        return baseASR;
    }

    private int calcCriticalChance(String className, int baseCC, boolean fivePattern, int ccCounter, int maxIteration)
    {
        if(className.equals("Berserker") || className.equals("Shadow"))
        {
            for(int i = 1; i <= inputStat; i++)
            {
                if(fivePattern && ccCounter == maxIteration)
                {
                    baseCC += 1;
                    maxIteration += 5;
                    ccCounter = 0;
                    fivePattern = false;
                }
                else if(!fivePattern && ccCounter == maxIteration)
                {
                    baseCC += 1;
                    maxIteration += 6;
                    ccCounter = 0;
                    fivePattern = true;
                }

                ccCounter++;
            }
        }

        return baseCC;
    }

    /* ------------------------------------------------------------------------------------------------------------- */
    //                                              VITALITY
    /* ------------------------------------------------------------------------------------------------------------- */
    private void calculateVIT(String className)
    {
        int currentHp = CalcLevel.getHp();
        int currentHpRec = CalcLevel.getHpRec();
        int gainedHp = 0, gainHpRec = 0, baseDefense = 0, defCounter, hprCounter;

        if(className.equals("Berserker"))
        {
            gainHpRec = 0;
            baseDefense = Integer.parseInt(berserkerBaseAddStats[7]);
            defCounter = 2;
            hprCounter = 2;

            for(int i = baseVIT; i <= inputStat; i++)
            {
                if(((defCounter % 5) == 0) && ((hprCounter % 5) == 0))
                {
                    gainHpRec += 1;
                    baseDefense += 1;
                }

                defCounter += 1;
                hprCounter += 1;
            }

            gainedHp = ((inputStat - baseVIT) * 11);
        }
        else if(className.equals("Dragon Knight"))
        {
            gainHpRec = 0;
            baseDefense = 29;
            defCounter = 1;
            hprCounter = 1;

            for(int i = 1; i <= inputStat; i++)
            {
                if (hprCounter > 20)
                {
                    if((hprCounter % 4) == 0)
                        gainHpRec += 1;
                }

                if((defCounter % 5) == 0)
                    baseDefense += 1;

                defCounter += 1;
                hprCounter += 1;
            }

            gainedHp = ((inputStat - baseVIT) * 9);
        }
        else if(className.equals("Valkyrie"))
        {
            boolean rotation = true;

            int rotationValue = 4;
            int nonRotationValue = 3;
            hprCounter = 1;
            gainedHp = ((inputStat - baseVIT) * 9);

            baseDefense = Integer.parseInt(valkBaseAddStats[7]);
            defCounter = 3;

            for(int i = baseVIT; i <= inputStat; i++)
            {
                if((defCounter % 6) == 0)
                    baseDefense += 1;

                if(!rotation && hprCounter == nonRotationValue)
                {
                    gainHpRec += 1;
                    hprCounter = 0;
                    rotation = true;
                }
                else if(rotation && hprCounter == rotationValue)
                {
                    gainHpRec += 1;
                    hprCounter = 0;
                    rotation = false;
                }

                defCounter++;
                hprCounter++;
            }
        }
        else if(className.equals("Elementalist"))
        {
            baseDefense = 30;

            hprCounter = 1;
            defCounter = 1;

            for(int i = 1; i <= inputStat; i++)
            {
                if(i > baseVIT)
                {
                    if((i % 3) == 0)
                        gainHpRec += 1;
                }

                if((defCounter % 10) == 0)
                    baseDefense += 1;

                hprCounter++;
                defCounter++;
            }

            gainedHp = ((inputStat - baseVIT) * 7);
        }
        else if(className.equals("Shadow"))
        {
            baseDefense = 29;
            defCounter = 0;

            for(int i = 1; i <= inputStat; i++)
            {
                if(i > baseVIT)
                {
                    if((i % 4) == 0)
                        gainHpRec += 1;
                }

                if((defCounter % 7) == 0 && defCounter != 0)
                    baseDefense += 1;

                defCounter++;
            }

            gainedHp = ((inputStat - baseVIT) * 9);
        }

        StatsTab.getHpValue().setText(String.valueOf(currentHp + gainedHp));
        StatsTab.getHpRecoveryValue().setText(String.valueOf(currentHpRec + gainHpRec));
        StatsTab.getDefenseValue().setText(String.valueOf(baseDefense));
        StatsTab.getDefenseSuccessValue().setText(String.valueOf(calcDefSuccessRate()));
    }

    /* ----------------------------------------------------------- */
    //                        SUB-FUNCTIONS
    /* ----------------------------------------------------------- */
    private int calcDefSuccessRate()
    {
        int defSuccessRate = 0;
        int DSRCounter = 11;

        for(int i = 1; i <= inputStat; i++)
        {
            if((DSRCounter % 20) == 0)
                defSuccessRate += 1;

            DSRCounter++;
        }

        return defSuccessRate;
    }

    /* ------------------------------------------------------------------------------------------------------------- */
    //                                              INTELLECT
    /* ------------------------------------------------------------------------------------------------------------- */
    private void calculateINT()
    {
        JLabel skillEnh = StatsTab.getSkillEnhValue();

        int baseSkillEnh = 2;
        int counter = 3;

        for(int i = 1; i < inputStat; i++)
        {
            if((counter % 4) == 0)
                baseSkillEnh += 3;
            else
                baseSkillEnh += 2;

            counter += 1;
        }

        skillEnh.setText(String.valueOf(baseSkillEnh));
    }

    /* ------------------------------------------------------------------------------------------------------------- */
    //                                              SPIRIT
    /* ------------------------------------------------------------------------------------------------------------- */
    private void calculateSPI(String className)
    {
        int currentSpMp = 0;
        int spGained = 0;

        if(className.equals("Berserker"))
        {
            currentSpMp = (CalcLevel.getSpMp());

            for(int i = baseSPI; i < inputStat; i++)
                spGained += 2;
        }
        else if(className.equals("Dragon Knight"))
        {
            currentSpMp = (CalcLevel.getSpMp());

            for(int i = baseSPI; i < inputStat; i++)
                spGained += 4;
        }
        else if(className.equals("Valkyrie"))
        {
            currentSpMp = CalcLevel.getSpMp();

            for(int i = baseSPI; i < inputStat; i++)
                spGained += 5;
        }
        else if(className.equals("Elementalist") || className.equals("Shadow"))
        {
            currentSpMp = CalcLevel.getSpMp();

            for(int i = baseSPI; i < inputStat; i++)
                spGained += 6;
        }

        StatsTab.getSpMPValue().setText(String.valueOf(currentSpMp + spGained));
        StatsTab.getSpMpRecoveryValue().setText(String.valueOf(calcSpMpRecovery(className)));
        StatsTab.getIncDebuffTimeValue().setText(String.valueOf(calcIncDamageDebuffTime()));
    }

    /* ----------------------------------------------------------- */
    //                        SUB-FUNCTIONS
    /* ----------------------------------------------------------- */
    /**
     * @implNote Every class has the same MP/SP Recovery growth per 10 points in SPI.
     * @return An int value from spMPRecovery.
     */
    private int calcSpMpRecovery(String className)
    {
        // At 1 SPI, the spMPCounter and spMpRecovery starts at 1.
        int spMpCounter = 1;
        int spMpRecovery = 1;

        if(className.equals("Berserker"))
            spMpRecovery = 0;
        else
        {
            for(int i = 1; i <= inputStat; i++)
            {
                if((spMpCounter % 10) == 0)
                    spMpRecovery += 1;

                spMpCounter++;
            }
        }

        return spMpRecovery;
    }

    /**
     * @implNote Every class has the same Increase Damage Debuff Time growth per 1 point in SPI.
     * @return A double value from damageDebuffTime.
     */
    private double calcIncDamageDebuffTime()
    {
        // At 1 SPI, the damage debuff count is at 3 out 5.
        int debuffCounter = 3;
        double damageDebuffTime = 0;

        for(int i = 1; i <= inputStat; i++)
        {
            // Situation (1)
            // Every 5 points of SPI, the damage debuff time increases by 2 (0.002).
            if((debuffCounter % 5) == 0)
            {
                damageDebuffTime += 2;
                debuffCounter = 0;
            }
            // Situation (2)
            else
                // Every point 1 point of SPI, the damage debuff time increases by 1 (0.001) Except in Situation (1) as listed above.
                damageDebuffTime += 1;

            debuffCounter += 1;
        }

        damageDebuffTime /= 1000;
        return damageDebuffTime;
    }

    /* ------------------------------------------------------------------------------------------------------------- */
    //                                          REMAINING POINTS
    /* ------------------------------------------------------------------------------------------------------------- */
    /**
     * @param statName The stat name (STR/AGI/VIT/INT/SPI) currently being used. The statName is only used for logging purposes.
     * @param baseStat The base value of the stat in use. This value can be pulled from the arrays inside the interface iCharacter.
     * @param inputStat The user's input value.
     * @return An int value from currentStat. currentStat is the most recent value of the stat in use depending on the user's input.
     */
    private int calcRemainStatPoints(String statName, int baseStat, int inputStat)
    {
        // Current stat's value (return variable).
        int currentStat = 0;
        // Current extra points (AKA remaining stat points).
        int extraPoints = Integer.parseInt(StatsTab.getRemainStatPoints().getText());

        if(inputStat <= baseStat)
        {
            // System message, please check system_en in .../lang/system/. Also check the FileIO's loadSystemMessage method.
            StatsTab.getSystemTextArea().append(FileIO.getCalcStatsMessages().get(2) + " " + inputStat + " "
                    + FileIO.getCalcStatsMessages().get(3) + " " + baseStat + " " + statName + ".\n\n");

            // Sent currentStat to baseStat to prevent the stat going lower than base.
            currentStat = baseStat;

            // Situation (1) - check below.
            // If the previousStat is overwritten (not -1), then adjust the extraPoints back to it's previous state.
            if(previousStat != -1)
                extraPoints = extraPoints + (previousStat - baseStat);
        }
        // Situation (2) - check below.
        // If inputStat equals to previousStat, then display error message and do nothing else.
        else if(inputStat == previousStat)
        {
            // System message, please check system_en in .../lang/system/. Also check the FileIO's loadSystemMessage method.
            StatsTab.getSystemTextArea().append(FileIO.getCalcStatsMessages().get(2) + " " + inputStat + " "
                    + FileIO.getCalcStatsMessages().get(4) + " " + previousStat + " " + statName + ".\n\n");

            // Since the currentStat and inputStat are the same, set currentStat to inputStat to prevent the stat
            // from decreasing or increasing.
            currentStat = inputStat;
        }
        else
        {
            // Situation (3) - check below.
            // If previousStat has been overwritten and is larger than inputStat, then the current stat has decreased.
            if(previousStat > inputStat && previousStat != -1)
            {
                // Equaling the currentStat to the inputStat prevents the stat from increasing.
                currentStat = inputStat;
                // Return the extraPoints back to it's previous state by adding the difference back.
                extraPoints = extraPoints + (previousStat - inputStat);
            }
            else if (extraPoints - (inputStat - baseStat) < 0)
            {
                // Situation (4) - check below.
                // When the inputStat is greater than the extraPoints - add all remaining extraPoints into the
                // currentStat and reduce extraPoints to 0 (zero).
                if(previousStat == -1)
                    currentStat += extraPoints + baseStat;
                else
                    currentStat += extraPoints + previousStat;

                extraPoints = 0;
            }
            else if (extraPoints - (inputStat - baseStat) >= 0)
            {
                // When the extraPoints are greater than or equal to 0 (zero) - get the difference between inputStat
                // and extraPoints to determine the new extraPoints.
                currentStat = inputStat;
                extraPoints = extraPoints - (inputStat - baseStat);
            }
        }

        // Setting previousStat to currentStat helps in situations (1), (2), (3), and (4).
        previousStat = currentStat;
        StatsTab.getRemainStatPoints().setText(String.valueOf(extraPoints));

        return currentStat;
    }
}
