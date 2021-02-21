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

import Interface.Components.StatsTab;

public class Character implements iCharacter
{
    private String className;

    public Character(String className)
    {
        this.className = className;

        setLevel();
        setBaseStats();
        setAdditionalStats();
    }

    private void setLevel()
    {
        StatsTab.getTfLevel().setText("1");
        StatsTab.getRemainStatPoints().setText("0");
    }

    private void setBaseStats()
    {
        switch(className)
        {
            case "Berserker":
            {
                StatsTab.getTfSTR().setText(String.valueOf(berserkerBaseStats[0]));
                StatsTab.getTfAGI().setText(String.valueOf(berserkerBaseStats[1]));
                StatsTab.getTfVIT().setText(String.valueOf(berserkerBaseStats[2]));
                StatsTab.getTfINT().setText(String.valueOf(berserkerBaseStats[3]));
                StatsTab.getTfSPI().setText(String.valueOf(berserkerBaseStats[4]));
                break;
            }
            case "Dragon Knight":
            {
                StatsTab.getTfSTR().setText(String.valueOf(dkBaseStats[0]));
                StatsTab.getTfAGI().setText(String.valueOf(dkBaseStats[1]));
                StatsTab.getTfVIT().setText(String.valueOf(dkBaseStats[2]));
                StatsTab.getTfINT().setText(String.valueOf(dkBaseStats[3]));
                StatsTab.getTfSPI().setText(String.valueOf(dkBaseStats[4]));
                break;
            }
            case "Valkyrie":
            {
                StatsTab.getTfSTR().setText(String.valueOf(valkBaseStats[0]));
                StatsTab.getTfAGI().setText(String.valueOf(valkBaseStats[1]));
                StatsTab.getTfVIT().setText(String.valueOf(valkBaseStats[2]));
                StatsTab.getTfINT().setText(String.valueOf(valkBaseStats[3]));
                StatsTab.getTfSPI().setText(String.valueOf(valkBaseStats[4]));
                break;
            }
            case "Elementalist":
            {
                StatsTab.getTfSTR().setText(String.valueOf(eleBaseStats[0]));
                StatsTab.getTfAGI().setText(String.valueOf(eleBaseStats[1]));
                StatsTab.getTfVIT().setText(String.valueOf(eleBaseStats[2]));
                StatsTab.getTfINT().setText(String.valueOf(eleBaseStats[3]));
                StatsTab.getTfSPI().setText(String.valueOf(eleBaseStats[4]));
                break;
            }
            case "Shadow":
            {
                StatsTab.getTfSTR().setText(String.valueOf(shadowBaseStats[0]));
                StatsTab.getTfAGI().setText(String.valueOf(shadowBaseStats[1]));
                StatsTab.getTfVIT().setText(String.valueOf(shadowBaseStats[2]));
                StatsTab.getTfINT().setText(String.valueOf(shadowBaseStats[3]));
                StatsTab.getTfSPI().setText(String.valueOf(shadowBaseStats[4]));
                break;
            }
            default:
            {
                StatsTab.getTfLevel().setText("");
                StatsTab.getTfSTR().setText("");
                StatsTab.getTfAGI().setText("");
                StatsTab.getTfVIT().setText("");
                StatsTab.getTfINT().setText("");
                StatsTab.getTfSPI().setText("");
                StatsTab.getRemainStatPoints().setText("");
                break;
            }
        }
    }

    private void setAdditionalStats()
    {
        StatsTab.getPlus1().setText("+");
        StatsTab.getPlus2().setText("+");
        StatsTab.getPlus3().setText("+");
        StatsTab.getPlus4().setText("+");
        StatsTab.getTilde().setText("~");
        StatsTab.getPercent1().setText("%");
        StatsTab.getPercent2().setText("%");
        StatsTab.getPercent3().setText("%");
        StatsTab.getAddBasicDamageValue().setText("0");
        StatsTab.getSeconds().setText("secs");

        switch(className)
        {
            case "Berserker":
            {
                StatsTab.getSdValue().setText(berserkerBaseAddStats[0]);
                StatsTab.getHpValue().setText(berserkerBaseAddStats[1]);
                StatsTab.getHpRecoveryValue().setText(berserkerBaseAddStats[2]);
                StatsTab.getSpMPValue().setText(berserkerBaseAddStats[3]);
                StatsTab.getSpMpRecoveryValue().setText(berserkerBaseAddStats[4]);
                StatsTab.getBasicDamageLowValue().setText(berserkerBaseAddStats[5]);
                StatsTab.getBasicDamageHighValue().setText(berserkerBaseAddStats[6]);
                StatsTab.getDefenseValue().setText(berserkerBaseAddStats[7]);
                StatsTab.getAddDefenseValue().setText(berserkerBaseAddStats[8]);
                StatsTab.getDefenseSuccessValue().setText(berserkerBaseAddStats[9]);
                StatsTab.getAttackSuccessValue().setText(berserkerBaseAddStats[10]);
                StatsTab.getAttackSpeedValue().setText(berserkerBaseAddStats[11]);
                StatsTab.getCritChanceValue().setText(berserkerBaseAddStats[12]);
                StatsTab.getSkillEnhValue().setText(berserkerBaseAddStats[13]);
                StatsTab.getIncDebuffTimeValue().setText(berserkerBaseAddStats[14]);
                break;
            }
            case "Dragon Knight":
            {
                StatsTab.getSdValue().setText(dkBaseAddStats[0]);
                StatsTab.getHpValue().setText(dkBaseAddStats[1]);
                StatsTab.getHpRecoveryValue().setText(dkBaseAddStats[2]);
                StatsTab.getSpMPValue().setText(dkBaseAddStats[3]);
                StatsTab.getSpMpRecoveryValue().setText(dkBaseAddStats[4]);
                StatsTab.getBasicDamageLowValue().setText(dkBaseAddStats[5]);
                StatsTab.getBasicDamageHighValue().setText(dkBaseAddStats[6]);
                StatsTab.getDefenseValue().setText(dkBaseAddStats[7]);
                StatsTab.getAddDefenseValue().setText(dkBaseAddStats[8]);
                StatsTab.getDefenseSuccessValue().setText(dkBaseAddStats[9]);
                StatsTab.getAttackSuccessValue().setText(dkBaseAddStats[10]);
                StatsTab.getAttackSpeedValue().setText(dkBaseAddStats[11]);
                StatsTab.getCritChanceValue().setText(dkBaseAddStats[12]);
                StatsTab.getSkillEnhValue().setText(dkBaseAddStats[13]);
                StatsTab.getIncDebuffTimeValue().setText(dkBaseAddStats[14]);
                break;
            }
            case "Valkyrie":
            {
                StatsTab.getSdValue().setText(valkBaseAddStats[0]);
                StatsTab.getHpValue().setText(valkBaseAddStats[1]);
                StatsTab.getHpRecoveryValue().setText(valkBaseAddStats[2]);
                StatsTab.getSpMPValue().setText(valkBaseAddStats[3]);
                StatsTab.getSpMpRecoveryValue().setText(valkBaseAddStats[4]);
                StatsTab.getBasicDamageLowValue().setText(valkBaseAddStats[5]);
                StatsTab.getBasicDamageHighValue().setText(valkBaseAddStats[6]);
                StatsTab.getDefenseValue().setText(valkBaseAddStats[7]);
                StatsTab.getAddDefenseValue().setText(valkBaseAddStats[8]);
                StatsTab.getDefenseSuccessValue().setText(valkBaseAddStats[9]);
                StatsTab.getAttackSuccessValue().setText(valkBaseAddStats[10]);
                StatsTab.getAttackSpeedValue().setText(valkBaseAddStats[11]);
                StatsTab.getCritChanceValue().setText(valkBaseAddStats[12]);
                StatsTab.getSkillEnhValue().setText(valkBaseAddStats[13]);
                StatsTab.getIncDebuffTimeValue().setText(valkBaseAddStats[14]);
                break;
            }
            case "Elementalist":
            {
                StatsTab.getSdValue().setText(eleBaseAddStats[0]);
                StatsTab.getHpValue().setText(eleBaseAddStats[1]);
                StatsTab.getHpRecoveryValue().setText(eleBaseAddStats[2]);
                StatsTab.getSpMPValue().setText(eleBaseAddStats[3]);
                StatsTab.getSpMpRecoveryValue().setText(eleBaseAddStats[4]);
                StatsTab.getBasicDamageLowValue().setText(eleBaseAddStats[5]);
                StatsTab.getBasicDamageHighValue().setText(eleBaseAddStats[6]);
                StatsTab.getDefenseValue().setText(eleBaseAddStats[7]);
                StatsTab.getAddDefenseValue().setText(eleBaseAddStats[8]);
                StatsTab.getDefenseSuccessValue().setText(eleBaseAddStats[9]);
                StatsTab.getAttackSuccessValue().setText(eleBaseAddStats[10]);
                StatsTab.getAttackSpeedValue().setText(eleBaseAddStats[11]);
                StatsTab.getCritChanceValue().setText(eleBaseAddStats[12]);
                StatsTab.getSkillEnhValue().setText(eleBaseAddStats[13]);
                StatsTab.getIncDebuffTimeValue().setText(eleBaseAddStats[14]);
                break;
            }
            case "Shadow":
            {
                StatsTab.getSdValue().setText(shadowBaseAddStats[0]);
                StatsTab.getHpValue().setText(shadowBaseAddStats[1]);
                StatsTab.getHpRecoveryValue().setText(shadowBaseAddStats[2]);
                StatsTab.getSpMPValue().setText(shadowBaseAddStats[3]);
                StatsTab.getSpMpRecoveryValue().setText(shadowBaseAddStats[4]);
                StatsTab.getBasicDamageLowValue().setText(shadowBaseAddStats[5]);
                StatsTab.getBasicDamageHighValue().setText(shadowBaseAddStats[6]);
                StatsTab.getDefenseValue().setText(shadowBaseAddStats[7]);
                StatsTab.getAddDefenseValue().setText(shadowBaseAddStats[8]);
                StatsTab.getDefenseSuccessValue().setText(shadowBaseAddStats[9]);
                StatsTab.getAttackSuccessValue().setText(shadowBaseAddStats[10]);
                StatsTab.getAttackSpeedValue().setText(shadowBaseAddStats[11]);
                StatsTab.getCritChanceValue().setText(shadowBaseAddStats[12]);
                StatsTab.getSkillEnhValue().setText(shadowBaseAddStats[13]);
                StatsTab.getIncDebuffTimeValue().setText(shadowBaseAddStats[14]);
                break;
            }
            default:
            {
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
                StatsTab.getPlus3().setText("");
                StatsTab.getAddBasicDamageValue().setText("");
                StatsTab.getDefenseValue().setText("");
                StatsTab.getPlus4().setText("");
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
            }
        }
    }
}
