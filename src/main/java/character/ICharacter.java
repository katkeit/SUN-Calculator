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

/* ---------------------------------------------------
                    NOTES

   All classes' base stats follow as STR, AGI,
   VIT, INT, SPI. Example: berserkerBaseStats
   are 26 STR, 13 AGI, 27 VIT, 4 INT, 10 SPI.

   All classes' additional stats follow as SD,
   HP, HP Recovery, SP/MP, SP/MP Recovery, Basic
   Damage (low), Basic Damage (high), Basic Defense,
   Additional Defense, Defense Success Rate, Attack
   Success Rate, Attack Speed, Critical Chance,
   Skill Enhancement, and Increase Debuff Time.
   Example: berserkerBaseAddStats are 201 SD,
   200 HP, 0 HP Recovery, 20 SP/MP, ... etc.

   Every classes' level growth goes as SD,
   HP, HP Recovery, SP/MP, and SP/MP Recovery.
   Example: berserkerLevelGrowth is 1 SD per
   level, 39 HP per level, 1 HP Recovery, ...
   etc.
   --------------------------------------------------- */

public interface ICharacter
{
    // ------------ Berserker ------------
    String[] berserkerBaseStats = {"26", "13", "27", "4", "10"};
    // [0] SD, [1] HP, [2] HP Rec, [3] SP, [4] SP Rec, [5] Low Damage, [6] High Damage, [7] Defense, [8] Add Defense,
    // [9] Def Success Rate, [10] Att Success Rate, [11] Attack Speed, [12] Critical Chance, [13] Skill Enh,
    // [14] Inc Debuff Time.
    String[] berserkerBaseAddStats = {"201", "200", "1", "20", "0", "4", "13", "34", "0", "1", "1", "151", "3", "9", "0.012"};
    Integer[] berserkerLevelGrowth = {1, 39, 1, 5, 0};

    // ---------- Dragon Knight ----------
    String[] dkBaseStats = {"22", "20", "20", "6", "12"};
    // [0] SD, [1] HP, [2] HP Rec, [3] SP, [4] SP Rec, [5] Low Damage, [6] High Damage, [7] Defense, [8] Add Defense,
    // [9] Def Success Rate, [10] Att Success Rate, [11] Attack Speed, [12] Critical Chance, [13] Skill Enh,
    // [14] Inc Debuff Time.
    String[] dkBaseAddStats = {"201", "180", "1", "25", "2", "4", "7", "33", "0", "1", "1", "151", "4", "14", "0.014"};
    // SD, HP, HPR, SP, SPR
    Integer[] dkLevelGrowth = {1, 26, 1, 7, 0};

    // ----------- Valkyrie ------------
    String[] valkBaseStats = {"16", "23", "15", "7", "19"};
    // [0] SD, [1] HP, [2] HP Rec, [3] SP, [4] SP Rec, [5] Low Damage, [6] High Damage, [7] Defense, [8] Add Defense,
    // [9] Def Success Rate, [10] Att Success Rate, [11] Attack Speed, [12] Critical Chance, [13] Skill Enh,
    // [14] Inc Debuff Time.
    String[] valkBaseAddStats = {"201", "160", "0", "32", "2", "2", "4", "31", "0", "1", "1", "151", "4", "16", "0.023"};
    // SD, HP, HPR, SP, SPR
    Integer[] valkLevelGrowth = {1, 25, 1, 8, 0};

    // ---------- Elementalist ----------
    String[] eleBaseStats = {"8", "12", "13", "25", "22"};
    // [0] SD, [1] HP, [2] HP Rec, [3] SP, [4] SP Rec, [5] Low Damage, [6] High Damage, [7] Defense, [8] Add Defense,
    // [9] Def Success Rate, [10] Att Success Rate, [11] Attack Speed, [12] Critical Chance, [13] Skill Enh,
    // [14] Inc Debuff Time.
    String[] eleBaseAddStats = {"201", "150", "0", "232", "3", "0", "2", "31", "0", "1", "1", "151", "2", "56", "0.026"};
    Integer[] eleLevelGrowth = {1, 23, 0, 25, 0};

    // ------------ Shadow ------------
    String[] shadowBaseStats = {"19", "17", "16", "18", "10"};
    String[] shadowBaseAddStats = {"201", "160", "0", "40", "2", "2", "4", "31", "0", "1", "1", "151", "4", "41", "0.012"};
    Integer[] shadowLevelGrowth = {1, 25, 0, 8, 0};


//    Integer[] mysticBaseStats = {15, 21, 15, 19, 10};
//    Integer[] helroidBaseStats = {15, 12, 27, 6, 20};
//    Integer[] wbBaseStats = {18, 20, 24, 8, 10};
}