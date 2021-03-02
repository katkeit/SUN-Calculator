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

import javax.swing.*;
import javax.swing.border.TitledBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class About implements ActionListener
{
    private static JFrame frame = new JFrame();
    private static JPanel aboutPanel = new JPanel();
    private static TitledBorder about = new TitledBorder("");
    private static String calcVersion = "";
    private static String developedBy = "";
    private static String disclaimer = "";
    private static JTextArea textArea = new JTextArea();
    private static JScrollPane scroll = new JScrollPane(textArea);

    @Override
    public void actionPerformed(ActionEvent e)
    {
        frame = new JFrame();
        frame.revalidate();
        // Application's icon.
        frame.setIconImage(Toolkit.getDefaultToolkit().getImage(FileIO.getAppIcon()));
        // Change application's background to white.
        frame.getContentPane().setBackground(Color.WHITE);
        // Set default's close to the X (Exit button) at top right of frame.
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setPreferredSize(new Dimension(350,200));

        about.setTitlePosition(TitledBorder.TOP);
        about.setTitleJustification(TitledBorder.CENTER);

        aboutPanel.setBorder(about);

        if(textArea.getText() != null)
            textArea.setText("");

        textArea.setLineWrap(true);
        textArea.setWrapStyleWord(true);
        textArea.setEditable(false);

        scroll.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        scroll.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED);
        scroll.setWheelScrollingEnabled(true);
        scroll.setPreferredSize(new Dimension(300, 135));
        scroll.setBorder(null);

        textArea.append(calcVersion + FileIO.getAppVersion() + "\n");
        textArea.append(developedBy + "\n\n");
        textArea.append(disclaimer);

        aboutPanel.add(scroll);

        frame.add(aboutPanel);
        frame.pack();
        frame.setVisible(true);
    }

    // GETTERS
    public static JFrame getFrame() {
        return frame;
    }

    public static JPanel getAboutPanel() {
        return aboutPanel;
    }

    public static TitledBorder getAbout() {
        return about;
    }

    public static JTextArea getTextArea() {
        return textArea;
    }

    // SETTERS
    public static void setCalcVersion(String calcVersion) {
        About.calcVersion = calcVersion;
    }

    public static void setDevelopedBy(String developedBy) {
        About.developedBy = developedBy;
    }

    public static void setDisclaimer(String disclaimer) {
        About.disclaimer = disclaimer;
    }
}

