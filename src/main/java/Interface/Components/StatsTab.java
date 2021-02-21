package Interface.Components;

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

import Character.CalcLevel;
import Character.CalcStats;
import Character.Character;

import javax.swing.*;
import javax.swing.border.TitledBorder;
import java.awt.*;
import java.util.Objects;

public class StatsTab
{
    /* ---------------------------------------------------------------------------------------------
                                        MAIN SECTION
       --------------------------------------------------------------------------------------------- */
    // --------------- Main Panel ---------------
    private static JPanel statPanel;
    // --------------- West Panel ---------------
    private static JPanel westPanel = new JPanel();
    // -------------- Center Panel --------------
    private static JPanel centerPanel = new JPanel();

    /* ---------------------------------------------------------------------------------------------
                                        WEST SECTION
       --------------------------------------------------------------------------------------------- */
    // --------------- Char Panel ---------------
    private static JPanel charPanel = new JPanel();
    private static TitledBorder selectClassBorder;
    private static DefaultComboBoxModel<String> comboBoxModel = new DefaultComboBoxModel<>();
    private static JComboBox<String> selectClass = new JComboBox<>(comboBoxModel);
    private static String cName = "";

    // --------------- Tips Panel ---------------
    private static TitledBorder tipsBorder;
    private static JPanel tipsPanel = new JPanel();
    private static JScrollPane tipsScroll;
    private static JTextArea tipsTextArea = new JTextArea();

    // -------------- System Panel --------------
    private static JPanel systemPanel = new JPanel();
    private static TitledBorder systemBorder;
    private static JScrollPane systemScroll;
    private static JTextArea systemTextArea = new JTextArea();

    /* ---------------------------------------------------------------------------------------------
                                        CENTER SECTION
       --------------------------------------------------------------------------------------------- */
    // --------------- Main Panel ---------------
    private static JPanel genCharPanel = new JPanel();
    private static TitledBorder charInfoBorder;

    // --------------- Level Panel ---------------
    private static JPanel levelPanel = new JPanel();
    private static TitledBorder levelBorder;
    private static JTextField tfLevel = new JTextField();

    // --------------- Stats Panel ---------------
    private static JPanel baseStatsPanel = new JPanel();
    private static TitledBorder baseStatBorder;
    private static JTextField tfSTR = new JTextField(), tfAGI = new JTextField(), tfVIT = new JTextField(),
            tfINT = new JTextField(), tfSPI = new JTextField();
    private static JLabel lblSTR = new JLabel(), lblAGI = new JLabel(), lblVIT = new JLabel(),
            lblINT = new JLabel(), lblSPI = new JLabel();

    // ----------- Remain Stats Panel -----------
    private static JPanel remainStatPanel = new JPanel();
    private static TitledBorder remainStatBorder;
    private static JLabel remainStatPoints = new JLabel();

    // ------------ Add Stats Panel ------------
    private static JPanel addStatsPanel = new JPanel();
    private static TitledBorder addStatBorder;
    private static JLabel sd = new JLabel(), sdValue = new JLabel(), hp = new JLabel(), hpValue = new JLabel(),
            hpRecoveryValue = new JLabel(), spMp = new JLabel(), spMPValue = new JLabel(),
            spMpRecoveryValue = new JLabel(), basicDamage = new JLabel(), basicDamageLowValue = new JLabel(),
            basicDamageHighValue = new JLabel(), addBasicDamageValue = new JLabel(), defense = new JLabel(),
            defenseValue = new JLabel(), addDefenseValue = new JLabel(), defenseSuccess = new JLabel(),
            defenseSuccessValue = new JLabel(), attackSuccess = new JLabel(), attackSuccessValue = new JLabel(),
            attackSpeed = new JLabel(), attackSpeedValue = new JLabel(), critChance = new JLabel(),
            critChanceValue = new JLabel(), skillEnh = new JLabel(), skillEnhValue = new JLabel(),
            incDebuffTime = new JLabel(), incDebuffTimeValue = new JLabel(), seconds1 = new JLabel(),
            plus1 = new JLabel(), plus2 = new JLabel(), plus3 = new JLabel(), plus4 = new JLabel(),
            tilde = new JLabel(), percent1 = new JLabel(), percent2 = new JLabel(), percent3 = new JLabel();

    // ---------- Con Add Stats Panel ----------
    private static JPanel conAddPanel = new JPanel(), buffDebuffPanel = new JPanel();
    private static JScrollPane scrollPane = new JScrollPane();
    private static TitledBorder conAddBorder, buffDebuffBorder;
    private static JLabel incBuffTime, infDamDebuffTime, redTargetDefense;

    // ---------------------------------------------------------------------------------------------

    public JPanel create()
    {
        statPanel = new JPanel();
        statPanel.setPreferredSize(new Dimension(800, 550));
        statPanel.setBackground(Color.WHITE);

        initLeftSection();
        initCenterSection();

        return statPanel;
    }

    private void initLeftSection()
    {
        // Titled border around the charPanel.
        selectClassBorder = new TitledBorder("");
        selectClassBorder.setTitleJustification(TitledBorder.CENTER);
        selectClassBorder.setTitlePosition(TitledBorder.TOP);

        charPanel.setPreferredSize(new Dimension(200, 60));

        /* -----------------------------
               Combo Box - className
           ----------------------------- */
        selectClass.setPreferredSize(new Dimension(180, 20));

        selectClass.addActionListener(e -> {
            cName = Objects.requireNonNull(selectClass.getSelectedItem()).toString();
            Character character = new Character(cName);
        });

        charPanel.add(selectClass);
        charPanel.setBorder(selectClassBorder);

        tipsBorder = new TitledBorder("");
        tipsBorder.setTitleJustification(TitledBorder.CENTER);
        tipsBorder.setTitlePosition(TitledBorder.TOP);

        tipsPanel.setPreferredSize(new Dimension(200, 222));
        tipsPanel.setBorder(tipsBorder);

        tipsTextArea.setLineWrap(true);
        tipsTextArea.setWrapStyleWord(true);
        tipsTextArea.setEditable(false);
        tipsScroll = new JScrollPane (tipsTextArea, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        tipsScroll.setWheelScrollingEnabled(true);
        tipsScroll.setPreferredSize(new Dimension(185, 190));
        tipsPanel.add(tipsScroll);

        systemBorder = new TitledBorder("");
        systemBorder.setTitleJustification(TitledBorder.CENTER);
        systemBorder.setTitlePosition(TitledBorder.TOP);

        systemPanel.setBorder(systemBorder);
        systemPanel.setPreferredSize(new Dimension(200, 222));

        systemTextArea.setLineWrap(true);
        systemTextArea.setWrapStyleWord(true);
        systemTextArea.setEditable(false);
        systemScroll = new JScrollPane (systemTextArea, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        systemScroll.setWheelScrollingEnabled(true);
        systemScroll.setPreferredSize(new Dimension(185, 190));
        systemPanel.add(systemScroll);

        westPanel.setPreferredSize(new Dimension(200, 505));
        westPanel.setLayout(new BoxLayout(westPanel, BoxLayout.PAGE_AXIS));
        westPanel.add(charPanel);
        westPanel.add(tipsPanel);
        westPanel.add(systemPanel);

        statPanel.add(westPanel, BorderLayout.WEST);
    }

    private void initCenterSection()
    {
        charInfoBorder = new TitledBorder("");
        charInfoBorder.setTitleJustification(TitledBorder.CENTER);
        charInfoBorder.setTitlePosition(TitledBorder.TOP);

        centerPanel.setBorder(charInfoBorder);
        centerPanel.setPreferredSize(new Dimension(545, 505));

        initLevelPanel();
        initStatPanel();
        initRemainPanel();
        initAdditionalPanel();
        initContinuedAddPanel();

        genCharPanel.setLayout(new GridBagLayout());

        GridBagConstraints gbc = new GridBagConstraints();

        gbc.gridx = 0;
        gbc.gridy = 0;
        genCharPanel.add(levelPanel, gbc);

        gbc.gridx = 1;
        gbc.gridy = 0;
        gbc.gridheight = 3;
        genCharPanel.add(addStatsPanel, gbc);

        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.anchor = GridBagConstraints.FIRST_LINE_START;
        genCharPanel.add(baseStatsPanel, gbc);

        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.anchor = GridBagConstraints.LAST_LINE_START;
        genCharPanel.add(remainStatPanel, gbc);

        gbc.gridx = 0;
        gbc.gridy = 3;
        gbc.gridwidth = 3;
        genCharPanel.add(conAddPanel, gbc);

        centerPanel.add(genCharPanel);
        statPanel.add(centerPanel, BorderLayout.CENTER);
    }

    private void initLevelPanel()
    {
        levelBorder = new TitledBorder("");
        levelBorder.setTitlePosition(TitledBorder.TOP);
        levelBorder.setTitleJustification(TitledBorder.CENTER);

        levelPanel.setBorder(levelBorder);
        tfLevel.setPreferredSize(new Dimension(100, 20));
        tfLevel.setHorizontalAlignment(JTextField.CENTER);
        tfLevel.addActionListener(new CalcLevel());
        levelPanel.add(tfLevel);
        levelPanel.setPreferredSize(new Dimension(130, 55));
    }

    private void initStatPanel()
    {
        baseStatBorder = new TitledBorder("");
        baseStatBorder.setTitleJustification(TitledBorder.CENTER);
        baseStatBorder.setTitlePosition(TitledBorder.TOP);

        baseStatsPanel.setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();

        baseStatsPanel.setPreferredSize(new Dimension(130, 160));
        baseStatsPanel.setBorder(baseStatBorder);

        /* ---------------
                STR
           --------------- */
        // STR LABEL
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.ipadx = 10;
        gbc.ipady = 5;
        baseStatsPanel.add(lblSTR, gbc);

        // STR TEXT FIELD
        gbc.gridx = 1;
        gbc.gridy = 0;
        tfSTR.setPreferredSize(new Dimension(30, 15));
        tfSTR.setHorizontalAlignment(JTextField.CENTER);
        tfSTR.addActionListener(new CalcStats("STR"));
        baseStatsPanel.add(tfSTR, gbc);

        /* ---------------
                AGI
           --------------- */
        gbc.gridx = 0;
        gbc.gridy = 1;
        baseStatsPanel.add(lblAGI, gbc);

        gbc.gridx = 1;
        gbc.gridy = 1;
        tfAGI.setPreferredSize(new Dimension(30, 15));
        tfAGI.setHorizontalAlignment(JTextField.CENTER);
        tfAGI.addActionListener(new CalcStats("AGI"));
        baseStatsPanel.add(tfAGI, gbc);

        /* ---------------
                VIT
           --------------- */
        gbc.gridx = 0;
        gbc.gridy = 2;
        baseStatsPanel.add(lblVIT, gbc);

        gbc.gridx = 1;
        gbc.gridy = 2;
        tfVIT.setPreferredSize(new Dimension(30, 15));
        tfVIT.setHorizontalAlignment(JTextField.CENTER);
        tfVIT.addActionListener(new CalcStats("VIT"));
        baseStatsPanel.add(tfVIT, gbc);

        /* ---------------
                INT
           --------------- */
        gbc.gridx = 0;
        gbc.gridy = 3;
        baseStatsPanel.add(lblINT, gbc);

        gbc.gridx = 1;
        gbc.gridy = 3;
        tfINT.setPreferredSize(new Dimension(30, 15));
        tfINT.setHorizontalAlignment(JTextField.CENTER);
        tfINT.addActionListener(new CalcStats("INT"));
        baseStatsPanel.add(tfINT, gbc);

        /* ---------------
                SPI
           --------------- */
        gbc.gridx = 0;
        gbc.gridy = 4;
        baseStatsPanel.add(lblSPI, gbc);

        gbc.gridx = 1;
        gbc.gridy = 4;
        tfSPI.setPreferredSize(new Dimension(30, 15));
        tfSPI.setHorizontalAlignment(JTextField.CENTER);
        tfSPI.addActionListener(new CalcStats("SPI"));
        baseStatsPanel.add(tfSPI, gbc);
    }

    private void initRemainPanel()
    {
        remainStatBorder = new TitledBorder("");
        remainStatBorder.setTitlePosition(TitledBorder.TOP);
        remainStatBorder.setTitleJustification(TitledBorder.CENTER);

        remainStatPanel.setBorder(remainStatBorder);
        remainStatPoints.setPreferredSize(new Dimension(100, 20));
        remainStatPoints.setHorizontalAlignment(JLabel.CENTER);

        remainStatPanel.add(remainStatPoints);
        remainStatPanel.setPreferredSize(new Dimension(130, 55));
    }

    private void initAdditionalPanel()
    {
        addStatBorder = new TitledBorder("");
        addStatBorder.setTitleJustification(TitledBorder.CENTER);
        addStatBorder.setTitlePosition(TitledBorder.TOP);

        addStatsPanel.setBorder(addStatBorder);
        addStatsPanel.setPreferredSize(new Dimension(400, 273));
        addStatsPanel.setLayout(new GridBagLayout());

        GridBagConstraints gbc = new GridBagConstraints();

        gbc.ipadx = 12;
        gbc.ipady = 3;

        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.anchor = GridBagConstraints.WEST;
        addStatsPanel.add(sd, gbc);

        gbc.gridx = 1;
        gbc.gridy = 0;
        gbc.anchor = GridBagConstraints.EAST;
        addStatsPanel.add(sdValue, gbc);

        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.anchor = GridBagConstraints.WEST;
        addStatsPanel.add(hp, gbc);

        gbc.gridx = 1;
        gbc.gridy = 1;
        gbc.anchor = GridBagConstraints.EAST;
        addStatsPanel.add(hpValue, gbc);

        gbc.gridx = 2;
        gbc.gridy = 1;
        gbc.anchor = GridBagConstraints.CENTER;
        addStatsPanel.add(plus1, gbc);

        gbc.gridx = 3;
        gbc.gridy = 1;
        gbc.anchor = GridBagConstraints.WEST;
        addStatsPanel.add(hpRecoveryValue, gbc);

        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.anchor = GridBagConstraints.WEST;
        addStatsPanel.add(spMp, gbc);

        gbc.gridx = 1;
        gbc.gridy = 2;
        gbc.anchor = GridBagConstraints.EAST;
        addStatsPanel.add(spMPValue, gbc);

        gbc.gridx = 2;
        gbc.gridy = 2;
        gbc.anchor = GridBagConstraints.CENTER;
        addStatsPanel.add(plus2, gbc);

        gbc.gridx = 3;
        gbc.gridy = 2;
        gbc.anchor = GridBagConstraints.WEST;
        addStatsPanel.add(spMpRecoveryValue, gbc);

        // ------------ BASIC DAMAGE ------------
        gbc.gridx = 0;
        gbc.gridy = 3;
        gbc.anchor = GridBagConstraints.WEST;
        addStatsPanel.add(basicDamage, gbc);

        gbc.gridx = 1;
        gbc.gridy = 3;
        gbc.anchor = GridBagConstraints.EAST;
        addStatsPanel.add(basicDamageLowValue, gbc);

        gbc.gridx = 2;
        gbc.gridy = 3;
        gbc.anchor = GridBagConstraints.CENTER;
        addStatsPanel.add(tilde, gbc);

        gbc.gridx = 3;
        gbc.gridy = 3;
        gbc.anchor = GridBagConstraints.CENTER;
        addStatsPanel.add(basicDamageHighValue, gbc);

        gbc.gridx = 4;
        gbc.gridy = 3;
        gbc.anchor = GridBagConstraints.CENTER;
        addStatsPanel.add(plus3, gbc);

        gbc.gridx = 5;
        gbc.gridy = 3;
        gbc.anchor = GridBagConstraints.WEST;
        addStatsPanel.add(addBasicDamageValue, gbc);

        gbc.gridx = 0;
        gbc.gridy = 4;
        gbc.anchor = GridBagConstraints.WEST;
        addStatsPanel.add(defense, gbc);

        gbc.gridx = 1;
        gbc.gridy = 4;
        gbc.anchor = GridBagConstraints.EAST;
        addStatsPanel.add(defenseValue, gbc);

        gbc.gridx = 2;
        gbc.gridy = 4;
        gbc.anchor = GridBagConstraints.CENTER;
        addStatsPanel.add(plus4, gbc);

        gbc.gridx = 3;
        gbc.gridy = 4;
        gbc.anchor = GridBagConstraints.WEST;
        addStatsPanel.add(addDefenseValue, gbc);

        gbc.gridx = 0;
        gbc.gridy = 5;
        gbc.anchor = GridBagConstraints.WEST;
        addStatsPanel.add(defenseSuccess, gbc);

        gbc.gridx = 1;
        gbc.gridy = 5;
        gbc.anchor = GridBagConstraints.EAST;
        addStatsPanel.add(defenseSuccessValue, gbc);

        gbc.gridx = 2;
        gbc.gridy = 5;
        gbc.anchor = GridBagConstraints.CENTER;
        addStatsPanel.add(percent1, gbc);

        gbc.gridx = 0;
        gbc.gridy = 6;
        gbc.anchor = GridBagConstraints.WEST;
        addStatsPanel.add(attackSuccess, gbc);

        gbc.gridx = 1;
        gbc.gridy = 6;
        gbc.anchor = GridBagConstraints.EAST;
        addStatsPanel.add(attackSuccessValue, gbc);

        gbc.gridx = 2;
        gbc.gridy = 6;
        gbc.anchor = GridBagConstraints.CENTER;
        addStatsPanel.add(percent2, gbc);

        gbc.gridx = 0;
        gbc.gridy = 7;
        gbc.anchor = GridBagConstraints.WEST;
        addStatsPanel.add(attackSpeed, gbc);

        gbc.gridx = 1;
        gbc.gridy = 7;
        gbc.anchor = GridBagConstraints.EAST;
        addStatsPanel.add(attackSpeedValue, gbc);

        gbc.gridx = 0;
        gbc.gridy = 8;
        gbc.anchor = GridBagConstraints.WEST;
        addStatsPanel.add(critChance, gbc);

        gbc.gridx = 1;
        gbc.gridy = 8;
        gbc.anchor = GridBagConstraints.EAST;
        addStatsPanel.add(critChanceValue, gbc);

        gbc.gridx = 2;
        gbc.gridy = 8;
        gbc.anchor = GridBagConstraints.CENTER;
        addStatsPanel.add(percent3, gbc);

        gbc.gridx = 0;
        gbc.gridy = 9;
        gbc.anchor = GridBagConstraints.WEST;
        addStatsPanel.add(skillEnh, gbc);

        gbc.gridx = 1;
        gbc.gridy = 9;
        gbc.anchor = GridBagConstraints.EAST;
        addStatsPanel.add(skillEnhValue, gbc);

        gbc.gridx = 0;
        gbc.gridy = 10;
        gbc.anchor = GridBagConstraints.WEST;
        addStatsPanel.add(incDebuffTime, gbc);

        gbc.gridx = 1;
        gbc.gridy = 10;
        gbc.anchor = GridBagConstraints.EAST;
        addStatsPanel.add(incDebuffTimeValue, gbc);

        gbc.gridx = 2;
        gbc.gridy = 10;
        gbc.anchor = GridBagConstraints.CENTER;
        addStatsPanel.add(seconds1, gbc);
    }

    // TODO: Add all remaining text to conAddPanel from the Character 2 tab in Character menu in game.
    private void initContinuedAddPanel()
    {
        conAddBorder = new TitledBorder("");
        conAddBorder.setTitlePosition(TitledBorder.TOP);
        conAddBorder.setTitleJustification(TitledBorder.CENTER);

        conAddPanel.setBorder(conAddBorder);
        conAddPanel.setPreferredSize(new Dimension(530, 205));

        scrollPane = new JScrollPane (JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        scrollPane.setWheelScrollingEnabled(true);
        scrollPane.setPreferredSize(new Dimension(515, 175));

//        buffDebuffPanel.setLayout(new GridBagLayout());
//        GridBagConstraints gbc = new GridBagConstraints();
//
//        // BUFF & DEBUFF RELATED SECTION
//        buffDebuffBorder = new TitledBorder("Buff & Debuff Related");
//        buffDebuffBorder.setTitlePosition(TitledBorder.TOP);
//        buffDebuffBorder.setTitleJustification(TitledBorder.CENTER);
//        buffDebuffPanel.setBorder(buffDebuffBorder);
//        buffDebuffPanel.setPreferredSize(new Dimension(500,50));
//        buffDebuffPanel.setLayout(new GridBagLayout());
//
//        incBuffTime = new JLabel("Increase Buff Time");
//        gbc.gridx = 0;
//        gbc.gridy = 0;
//        buffDebuffPanel.add(incBuffTime, gbc);
//
//        JLabel tempLabel1 = new JLabel("INSERT WORDS HERE.");
//        gbc.gridx = 0;
//        gbc.gridy = 1;
//        buffDebuffPanel.add(tempLabel1, gbc);
//
//        scrollPane.getViewport().add(buffDebuffPanel);
//
//        TitledBorder titledBorder1 = new TitledBorder("TEMP TITLED BORDER");
//        titledBorder1.setTitlePosition(TitledBorder.TOP);
//        titledBorder1.setTitleJustification(TitledBorder.CENTER);
//        JPanel jpanel = new JPanel();
//        jpanel.setBorder(titledBorder1);
//        jpanel.setPreferredSize(new Dimension(500,50));
//        jpanel.setLayout(new GridBagLayout());
//
//        JLabel tempLabel2 = new JLabel("INSERT WORDS HERE.");
//        gbc.gridx = 0;
//        gbc.gridy = 0;
//        jpanel.add(tempLabel2, gbc);
//
//        scrollPane.getViewport().add(jpanel);

//        conAddPanel.add(scrollPane);
    }

    /* ---------------------------------------------------------------------------------------------
                                            GETTERS
      --------------------------------------------------------------------------------------------- */
    public static JPanel getStatPanel() {
        return statPanel;
    }

    public static JPanel getCenterPanel() {
        return centerPanel;
    }

    public static JPanel getCharPanel() {
        return charPanel;
    }

    public static JPanel getTipsPanel() {
        return tipsPanel;
    }

    public static JPanel getSystemPanel() {
        return systemPanel;
    }

    public static TitledBorder getSelectClassBorder() {
        return selectClassBorder;
    }

    public static TitledBorder getTipsBorder() {
        return tipsBorder;
    }

    public static TitledBorder getSystemBorder() {
        return systemBorder;
    }

    public static TitledBorder getCharInfoBorder() {
        return charInfoBorder;
    }

    public  static JComboBox<String> getSelectClass() {
        return selectClass;
    }

    public static JTextField getTfLevel() {
        return tfLevel;
    }

    public static JTextField getTfSTR() {
        return tfSTR;
    }

    public static JTextField getTfAGI() {
        return tfAGI;
    }

    public static JTextField getTfVIT() {
        return tfVIT;
    }

    public static JTextField getTfINT() {
        return tfINT;
    }

    public static JTextField getTfSPI() {
        return tfSPI;
    }

    public static JLabel getSdValue() {
        return sdValue;
    }

    public static JLabel getHpValue() {
        return hpValue;
    }

    public static JLabel getHpRecoveryValue() {
        return hpRecoveryValue;
    }

    public static JLabel getSpMPValue() {
        return spMPValue;
    }

    public static JLabel getSpMpRecoveryValue() {
        return spMpRecoveryValue;
    }

    public static JLabel getBasicDamageLowValue() {
        return basicDamageLowValue;
    }

    public static JLabel getBasicDamageHighValue() {
        return basicDamageHighValue;
    }

    public static JLabel getDefenseValue() {
        return defenseValue;
    }

    public static JLabel getAddDefenseValue() {
        return addDefenseValue;
    }

    public static JLabel getDefenseSuccessValue() {
        return defenseSuccessValue;
    }

    public static JLabel getAttackSuccessValue() {
        return attackSuccessValue;
    }

    public static JLabel getAttackSpeedValue() {
        return attackSpeedValue;
    }

    public static JLabel getCritChanceValue() {
        return critChanceValue;
    }

    public static JLabel getSkillEnhValue() {
        return skillEnhValue;
    }

    public static JLabel getIncDebuffTimeValue() {
        return incDebuffTimeValue;
    }

    public static JLabel getTilde() {
        return tilde;
    }

    public static JLabel getPlus1() {
        return plus1;
    }

    public static JLabel getPlus2() {
        return plus2;
    }

    public static JLabel getPlus3() {
        return plus3;
    }

    public static JLabel getPercent1() {
        return percent1;
    }

    public static JLabel getPercent2() {
        return percent2;
    }

    public static JLabel getPercent3() {
        return percent3;
    }

    public static JLabel getRemainStatPoints() {
        return remainStatPoints;
    }

    public static JLabel getSeconds() {
        return seconds1;
    }

    public static JPanel getGenCharPanel() {
        return genCharPanel;
    }

    public static JPanel getLevelPanel() {
        return levelPanel;
    }

    public static JPanel getBaseStatsPanel() {
        return baseStatsPanel;
    }

    public static JPanel getRemainStatPanel() {
        return remainStatPanel;
    }

    public static JPanel getAddStatsPanel() {
        return addStatsPanel;
    }

    public static TitledBorder getLevelBorder() {
        return levelBorder;
    }

    public static TitledBorder getBaseStatBorder() {
        return baseStatBorder;
    }

    public static TitledBorder getRemainStatBorder() {
        return remainStatBorder;
    }

    public static TitledBorder getAddStatBorder() {
        return addStatBorder;
    }

    public static JLabel getLblSTR() {
        return lblSTR;
    }

    public static JLabel getLblAGI() {
        return lblAGI;
    }

    public static JLabel getLblVIT() {
        return lblVIT;
    }

    public static JLabel getLblINT() {
        return lblINT;
    }

    public static JLabel getLblSPI() {
        return lblSPI;
    }

    public static JLabel getSd() {
        return sd;
    }

    public static JLabel getHp() {
        return hp;
    }

    public static JLabel getSpMp() {
        return spMp;
    }

    public static JLabel getBasicDamage() {
        return basicDamage;
    }

    public static JLabel getDefense() {
        return defense;
    }

    public static JLabel getDefenseSuccess() {
        return defenseSuccess;
    }

    public static JLabel getAttackSuccess() {
        return attackSuccess;
    }

    public static JLabel getAttackSpeed() {
        return attackSpeed;
    }

    public static JLabel getCritChance() {
        return critChance;
    }

    public static JLabel getSkillEnh() {
        return skillEnh;
    }

    public static JLabel getIncDebuffTime() {
        return incDebuffTime;
    }

    public static String getcName() {
        return cName;
    }

    public static JLabel getAddBasicDamageValue() {
        return addBasicDamageValue;
    }

    public static JLabel getPlus4() {
        return plus4;
    }

    public static JTextArea getSystemTextArea() {
        return systemTextArea;
    }

    public static JPanel getConAddPanel() {
        return conAddPanel;
    }

    public static TitledBorder getConAddBorder() {
        return conAddBorder;
    }

    public static JTextArea getTipsTextArea() {
        return tipsTextArea;
    }

    public static DefaultComboBoxModel<String> getComboBoxModel() {
        return comboBoxModel;
    }
}
