package gui.components;

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
import io.Language;

import javax.swing.*;
import javax.swing.border.TitledBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Preference implements ActionListener
{
    private static JFrame frame = new JFrame();
    private static final TitledBorder preferences = new TitledBorder("");
    private static final TitledBorder language = new TitledBorder("");
    private static final TitledBorder themes = new TitledBorder("");
    private static final JPanel preferencePanel = new JPanel();
    private static final JPanel langPanel = new JPanel();
    private static final JPanel themePanel = new JPanel();
    private static final ButtonGroup langGroup = new ButtonGroup();
    private static final ButtonGroup themeGroup = new ButtonGroup();
    private static final JRadioButton english = new JRadioButton("");
    private static final JRadioButton spanish = new JRadioButton("");
    private static final JRadioButton portuguese = new JRadioButton("");
    private static final JRadioButton lightTheme = new JRadioButton();
    private static final JRadioButton darkTheme = new JRadioButton("");
    private static final GridBagConstraints gbc = new GridBagConstraints();
    private static final JButton applyButton = new JButton("");

    private static final FileIO fileIO = new FileIO();

    @Override
    public void actionPerformed(ActionEvent e)
    {
        frame = new JFrame();
        frame.setTitle("");

        // Application's icon.
        frame.setIconImage(Toolkit.getDefaultToolkit().getImage(FileIO.getAppIcon()));
        // Change application's background to white.
        frame.getContentPane().setBackground(Color.WHITE);
        // Set default's close to the X (Exit button) at top right of frame.
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        preferencePanel.setMaximumSize(new Dimension(200, 200));
        preferences.setTitleJustification(TitledBorder.CENTER);
        preferences.setTitlePosition(TitledBorder.TOP);

        preferencePanel.setBorder(preferences);
        preferencePanel.setLayout(new GridBagLayout());

        if(FileIO.getPrefLanguage().equals("EN"))
            english.setSelected(true);
        else if (FileIO.getPrefLanguage().equals("ES"))
            spanish.setSelected(true);
        else
            portuguese.setSelected(true);

        langGroup.add(english);
        langGroup.add(spanish);
        langGroup.add(portuguese);

        langPanel.add(english);
        langPanel.add(spanish);
        langPanel.add(portuguese);

        language.setTitlePosition(TitledBorder.TOP);
        language.setTitleJustification(TitledBorder.CENTER);
        langPanel.setBorder(language);

        if(FileIO.getPrefTheme().equals("LIGHT"))
            lightTheme.setSelected(true);
        else
            darkTheme.setSelected(true);

        themeGroup.add(lightTheme);
        themeGroup.add(darkTheme);

        themePanel.add(lightTheme);
        themePanel.add(darkTheme);

        themes.setTitlePosition(TitledBorder.TOP);
        themes.setTitleJustification(TitledBorder.CENTER);
        themePanel.setBorder(themes);

        gbc.gridx = 0;
        gbc.gridy = 0;
        preferencePanel.add(langPanel, gbc);

        gbc.gridx = 1;
        gbc.gridy = 0;
        preferencePanel.add(themePanel, gbc);

        gbc.gridx = 1;
        gbc.gridy = 1;
        gbc.anchor = GridBagConstraints.EAST;
        applyButton.addActionListener(new SetPreferences());
        preferencePanel.add(applyButton, gbc);

        frame.add(preferencePanel);

        // Pack and set frame to visible.
        frame.pack();
        frame.setVisible(true);
    }

    private static class SetPreferences implements ActionListener
    {
        private final String[] settings = new String[2];

        @Override
        public void actionPerformed(ActionEvent e)
        {
            String preferredLang = "";
            String preferredTheme = "";

            if(english.isSelected())
                preferredLang = "EN";
            else if(spanish.isSelected())
                preferredLang = "ES";
            else
                preferredLang = "PT";

            if(lightTheme.isSelected())
                preferredTheme = "LIGHT";
            else
                preferredTheme = "DARK";

            settings[0] = preferredLang;
            settings[1] = preferredTheme;

            fileIO.writeFile("config/preferences.txt", settings);
            fileIO.readFile("config/preferences.txt");

            Language lang = new Language(preferredLang);
            lang.setLanguage();

            Theme theme = new Theme(preferredTheme);
            theme.initTheme();

            frame.dispose();
        }
    }

    // GETTERS
    public static JFrame getFrame() {
        return frame;
    }

    public static TitledBorder getPreferences() {
        return preferences;
    }

    public static TitledBorder getLanguage() {
        return language;
    }

    public static TitledBorder getThemes() {
        return themes;
    }

    public static JRadioButton getEnglish() {
        return english;
    }

    public static JRadioButton getSpanish() {
        return spanish;
    }

    public static JRadioButton getPortuguese() {
        return portuguese;
    }

    public static JRadioButton getLightTheme() {
        return lightTheme;
    }

    public static JRadioButton getDarkTheme() {
        return darkTheme;
    }

    public static JButton getApplyButton() {
        return applyButton;
    }

    public static JPanel getPreferencePanel() {
        return preferencePanel;
    }

    public static JPanel getLangPanel() {
        return langPanel;
    }

    public static JPanel getThemePanel() {
        return themePanel;
    }
}
