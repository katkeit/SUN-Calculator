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

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CalcStats implements ActionListener, ICharacter
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

        switch (className) {
            case "Berserker" -> {
                baseSTR = Integer.parseInt(berserkerBaseStats[0]);
                baseAGI = Integer.parseInt(berserkerBaseStats[1]);
                baseVIT = Integer.parseInt(berserkerBaseStats[2]);
                baseINT = Integer.parseInt(berserkerBaseStats[3]);
                baseSPI = Integer.parseInt(berserkerBaseStats[4]);

                validateStat(className);
            }
            case "Dragon Knight" -> {
                baseSTR = Integer.parseInt(dkBaseStats[0]);
                baseAGI = Integer.parseInt(dkBaseStats[1]);
                baseVIT = Integer.parseInt(dkBaseStats[2]);
                baseINT = Integer.parseInt(dkBaseStats[3]);
                baseSPI = Integer.parseInt(dkBaseStats[4]);

                validateStat(className);
            }
            case "Valkyrie" -> {
                baseSTR = Integer.parseInt(valkBaseStats[0]);
                baseAGI = Integer.parseInt(valkBaseStats[1]);
                baseVIT = Integer.parseInt(valkBaseStats[2]);
                baseINT = Integer.parseInt(valkBaseStats[3]);
                baseSPI = Integer.parseInt(valkBaseStats[4]);

                validateStat(className);
            }
            case "Elementalist" -> {
                baseSTR = Integer.parseInt(eleBaseStats[0]);
                baseAGI = Integer.parseInt(eleBaseStats[1]);
                baseVIT = Integer.parseInt(eleBaseStats[2]);
                baseINT = Integer.parseInt(eleBaseStats[3]);
                baseSPI = Integer.parseInt(eleBaseStats[4]);

                validateStat(className);
            }
            case "Shadow" -> {
                baseSTR = Integer.parseInt(shadowBaseStats[0]);
                baseAGI = Integer.parseInt(shadowBaseStats[1]);
                baseVIT = Integer.parseInt(shadowBaseStats[2]);
                baseINT = Integer.parseInt(shadowBaseStats[3]);
                baseSPI = Integer.parseInt(shadowBaseStats[4]);

                validateStat(className);
            }
            default -> StatsTab.getSystemTextArea().append(FileIO.getCalcStatsMessages().get(0) + " " + className + "\n\n");
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
            case "STR" -> {
                inputStat = convert.stringToInt(StatsTab.getTfSTR().getText());

                component = StatsTab.getTfSTR();
                component.setText(String.valueOf(inputStat));

                currentStatValue = calcRemainStatPoints(statName, baseSTR, inputStat);
                StatsTab.getTfSTR().setText(String.valueOf(currentStatValue));
                calculateSTR(className);
            }
            case "AGI" -> {
                inputStat = convert.stringToInt(StatsTab.getTfAGI().getText());

                component = StatsTab.getTfAGI();
                component.setText(String.valueOf(inputStat));

                currentStatValue = calcRemainStatPoints(statName, baseAGI, inputStat);
                StatsTab.getTfAGI().setText(String.valueOf(currentStatValue));
                calculateAGI(className);
            }
            case "VIT" -> {
                inputStat = convert.stringToInt(StatsTab.getTfVIT().getText());

                component = StatsTab.getTfVIT();
                component.setText(String.valueOf(inputStat));

                currentStatValue = calcRemainStatPoints(statName, baseVIT, inputStat);
                StatsTab.getTfVIT().setText(String.valueOf(currentStatValue));
                calculateVIT(className);
            }
            case "INT" -> {
                inputStat = convert.stringToInt(StatsTab.getTfINT().getText());

                component = StatsTab.getTfINT();
                component.setText(String.valueOf(inputStat));

                currentStatValue = calcRemainStatPoints(statName, baseINT, inputStat);
                StatsTab.getTfINT().setText(String.valueOf(currentStatValue));
                calculateINT();
            }
            case "SPI" -> {
                inputStat = convert.stringToInt(StatsTab.getTfSPI().getText());

                component = StatsTab.getTfSPI();
                component.setText(String.valueOf(inputStat));

                currentStatValue = calcRemainStatPoints(statName, baseSPI, inputStat);
                StatsTab.getTfSPI().setText(String.valueOf(currentStatValue));
                calculateSPI(className);
            }
            default -> StatsTab.getSystemTextArea().append(FileIO.getCalcStatsMessages().get(1) + statName + "\n\n");
        }
    }

    /* ------------------------------------------------------------------------------------------------------------- */
    //                                              STRENGTH
    /* ------------------------------------------------------------------------------------------------------------- */
    private void calculateSTR(String className)
    {
        int lowDamage = 0;
        int highDamage = 0;

        switch(className)
        {
            case "Berserker":
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
            case "Dragon Knight":
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
            case "Valkyrie":
            case "Shadow":
            {
                for(int i = 0; i <= inputStat; i++)
                {
                    if((i % 4) == 0)
                        highDamage += 1;

                    if((i % 8) == 0)
                        lowDamage += 1;

                }
            }
            case "Elementalist":
            {
                for(int i = 1; i <= inputStat; i++)
                {
                    if((i % 4) == 0)
                        highDamage += 1;

                    if((i % 9) == 0)
                        lowDamage += 1;
                }
            }
        }

        StatsTab.getBasicDamageLowValue().setText(String.valueOf(lowDamage));
        StatsTab.getBasicDamageHighValue().setText(String.valueOf(highDamage));
    }

    /* ------------------------------------------------------------------------------------------------------------- */
    //                                              AGILITY
    /* ------------------------------------------------------------------------------------------------------------- */
    private void calculateAGI(String className)
    {
        int attSuccessRate = 0;
        int attSpeed = 150;
        int critChance = 0;

        switch (className)
        {
            case "Berserker" -> {
                attSpeed = calcAttackSpeed(className, false, 0, 0, 0,0, attSpeed, 1);
                attSuccessRate = calcAttackSuccessRate(className, false, 11, 0);
                critChance = calcCriticalChance(className, 1, false, 0, 1, 0);
            }
            case "Dragon Knight" -> {
                attSpeed = calcAttackSpeed(className, true, 2, 1, 11, 10, attSpeed, 1);
                attSuccessRate = calcAttackSuccessRate(className, true, 9, 2);
                critChance = calcCriticalChance(className, 3, false, 14, 17, 1);
            }
            case "Valkyrie" -> {
//                ccCounter = 4;

//                int maxIteration = 7;
//                int increaseIteration = 1;

                attSpeed = calcAttackSpeed(className, true, 2, 1, 13, 14, attSpeed, 0);
                attSuccessRate = calcAttackSuccessRate(className, true, 9, 2);
                // Check Pattern.
                critChance = calcCriticalChance(className, 1, false, 4, 7,1);


                //TODO: Fix Valk's CC. Need more information.
                // ----------- Critical Chance -----------
//                for (int i = 1; i <= inputStat; i++)
//                {
//                    if (ccCounter == maxIteration)
//                    {
//
//                    }
//
//                    ccCounter++;
//                }
            }
            case "Elementalist" -> {
                attSpeed = calcAttackSpeed(className, false, 2, 1, 9, 10, attSpeed, 1);
                attSuccessRate = calcAttackSuccessRate(className, true, 9, 2);
                critChance = calcCriticalChance(className, 1, false, 7, 9, 3);
            }
            case "Shadow" -> {
                attSpeed = calcAttackSpeed("Shadow", false, 0, 0, 0, 0, attSpeed, 1);
                attSuccessRate = calcAttackSuccessRate(className, false, 11, 0);
                critChance = calcCriticalChance(className, 2, true, 1, 5, 0);
            }
        }

        StatsTab.getAttackSuccessValue().setText(String.valueOf(attSuccessRate));
        StatsTab.getAttackSpeedValue().setText(String.valueOf(attSpeed));
        StatsTab.getCritChanceValue().setText(String.valueOf(critChance));
    }

    /* ----------------------------------------------------------- */
    //                        SUB-FUNCTIONS
    /* ----------------------------------------------------------- */
    /**
     *
     * @param className A String value of the class' name.
     * @param rotation Is there rotation?
     * @param maxRotationIteration What is the max rotation iterations?
     * @param currentRotationIteration What is the starting rotation iteration?
     * @param rotationValue What is the value of the rotating number?
     * @param nonRotationValue What is the value of the nonrotating number?
     * @return Returns an int value of the class' current Attack Speed.
     */
    private int calcAttackSpeed(String className, boolean rotation, int maxRotationIteration, int currentRotationIteration, int rotationValue, int nonRotationValue, int baseAS, int attSpeedCounter)
    {
        int asCounter = attSpeedCounter;

        if(className.equals("Berserker"))
        {
            for (int i = 1; i <= inputStat; i++)
            {
                asCounter++;

                if ((asCounter % 8) == 0)
                    baseAS += 1;
            }
        }
        else if(className.equals("Dragon Knight") || className.equals("Valkyrie") || className.equals("Elementalist"))
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
        else if(className.equals("Shadow"))
        {
            for (int i = 1; i <= inputStat; i++)
            {
                if ((asCounter % 12) == 0)
                    baseAS += 1;

                asCounter++;
            }
        }

        return baseAS;
    }

    /**
     * @param className String value of the class' name.
     * @param pattern17 Does the class start with the 17 pattern?
     * @param asrCounter Where does there ASR start in the pattern?
     * @param asr17Counter Where is the 17 pattern at? The 1st or 2nd iteration?
     * @return Returns an int value of the class' current ASR.
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

    /**
     * @param className String of the class' name.
     * @param baseCritChance Int of the class' base Critical Chance.
     * @param fivePattern Is there a five pattern?
     * @param critChanceCounter Where in the counter does the pattern start at?
     * @param maxIteration What is the max iteration of the counter?
     * @return Returns an int of the class' Critical Chance % value.
     */
    private int calcCriticalChance(String className, int baseCritChance, boolean fivePattern, int critChanceCounter, int maxIteration, int increaseCounter)
    {
        int baseCC = baseCritChance;
        int ccCounter = critChanceCounter;
        int incCounter = increaseCounter;

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
        else if(className.equals("Dragon Knight"))
        {
            for (int i = 1; i <= inputStat; i++)
            {
                if (ccCounter == maxIteration)
                {
                    baseCC += 1;

                    if (maxIteration > 18)
                        incCounter += 3;

                    maxIteration += incCounter;
                    ccCounter = 0;
                }

                ccCounter++;
            }
        }
        else if(className.equals("Elementalist"))
        {
            // baseCC = 1, ccCounter = 7, maxIteration = 9, increaseIteration = 3,
            for (int i = 1; i <= inputStat; i++)
            {
                if (ccCounter == maxIteration)
                {
                    baseCC += 1;
                    maxIteration += incCounter;
                    incCounter += 1;
                    ccCounter = 0;
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
        int gainedHp = 0;
        int gainHpRec = 0;
        int baseDefense = 0;
        int defCounter;
        int hprCounter;

        switch (className)
        {
            case "Berserker" -> {
                gainHpRec = 0;
                baseDefense = Integer.parseInt(berserkerBaseAddStats[7]);
                defCounter = 2;
                hprCounter = 2;

                for (int i = baseVIT; i <= inputStat; i++)
                {
                    if (((defCounter % 5) == 0) && ((hprCounter % 5) == 0))
                    {
                        gainHpRec += 1;
                        baseDefense += 1;
                    }

                    defCounter += 1;
                    hprCounter += 1;
                }
                gainedHp = ((inputStat - baseVIT) * 11);
            }
            case "Dragon Knight" -> {
                gainHpRec = 0;
                baseDefense = 29;
                defCounter = 1;
                hprCounter = 1;

                for (int i = 1; i <= inputStat; i++)
                {
                    if (hprCounter > 20)
                    {
                        if ((hprCounter % 4) == 0)
                            gainHpRec += 1;
                    }

                    if ((defCounter % 5) == 0)
                        baseDefense += 1;

                    defCounter += 1;
                    hprCounter += 1;
                }
                gainedHp = ((inputStat - baseVIT) * 9);
            }
            case "Valkyrie" -> {
                boolean rotation = true;
                int rotationValue = 4;
                int nonRotationValue = 3;

                hprCounter = 1;
                gainedHp = ((inputStat - baseVIT) * 9);
                baseDefense = Integer.parseInt(valkBaseAddStats[7]);
                defCounter = 3;

                for (int i = baseVIT; i <= inputStat; i++)
                {
                    if ((defCounter % 6) == 0)
                        baseDefense += 1;

                    if (!rotation && hprCounter == nonRotationValue)
                    {
                        gainHpRec += 1;
                        hprCounter = 0;
                        rotation = true;
                    }
                    else if (rotation && hprCounter == rotationValue)
                    {
                        gainHpRec += 1;
                        hprCounter = 0;
                        rotation = false;
                    }

                    defCounter++;
                    hprCounter++;
                }
            }
            case "Elementalist" -> {
                baseDefense = 30;
                hprCounter = 1;
                defCounter = 1;

                for (int i = 1; i <= inputStat; i++)
                {
                    if (i > baseVIT)
                    {
                        if ((i % 3) == 0)
                            gainHpRec += 1;
                    }

                    if ((defCounter % 10) == 0)
                        baseDefense += 1;

                    hprCounter++;
                    defCounter++;
                }
                gainedHp = ((inputStat - baseVIT) * 7);
            }
            case "Shadow" -> {
                baseDefense = 29;
                defCounter = 0;

                for (int i = 1; i <= inputStat; i++)
                {
                    if (i > baseVIT)
                    {
                        if ((i % 4) == 0)
                            gainHpRec += 1;
                    }

                    if ((defCounter % 7) == 0 && defCounter != 0)
                        baseDefense += 1;

                    defCounter++;
                }
                gainedHp = ((inputStat - baseVIT) * 9);
            }
        }

        StatsTab.getHpValue().setText(String.valueOf(currentHp + gainedHp));
        StatsTab.getHpRecoveryValue().setText(String.valueOf(currentHpRec + gainHpRec));
        StatsTab.getDefenseValue().setText(String.valueOf(baseDefense));
        StatsTab.getDefenseSuccessValue().setText(String.valueOf(calcDefSuccessRate()));
    }

    /* ----------------------------------------------------------- */
    //                        SUB-FUNCTIONS
    /* ----------------------------------------------------------- */

    /**
     * @implNote Every class has the same DSR growth rate.
     * @return Returns an int value of the class' DSR.
     */
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
        int skillEnh = 2;
        int counter = 3;

        for(int i = 1; i < inputStat; i++)
        {
            if((counter % 4) == 0)
                skillEnh += 3;
            else
                skillEnh += 2;

            counter += 1;
        }

        StatsTab.getSkillEnhValue().setText(String.valueOf(skillEnh));
    }

    /* ------------------------------------------------------------------------------------------------------------- */
    //                                              SPIRIT
    /* ------------------------------------------------------------------------------------------------------------- */
    private void calculateSPI(String className)
    {
        int currentSpMp = 0;
        int spGained = 0;

        switch (className)
        {
            case "Berserker" -> {
                currentSpMp = (CalcLevel.getSpMp());

                for (int i = baseSPI; i < inputStat; i++)
                    spGained += 2;
            }
            case "Dragon Knight" -> {
                currentSpMp = (CalcLevel.getSpMp());

                for (int i = baseSPI; i < inputStat; i++)
                    spGained += 4;
            }
            case "Valkyrie" -> {
                currentSpMp = CalcLevel.getSpMp();

                for (int i = baseSPI; i < inputStat; i++)
                    spGained += 5;
            }
            case "Elementalist", "Shadow" -> {
                currentSpMp = CalcLevel.getSpMp();

                for (int i = baseSPI; i < inputStat; i++)
                    spGained += 6;
            }
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
