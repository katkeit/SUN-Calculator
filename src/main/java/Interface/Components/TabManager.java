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

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import Interface.Interface;

public class TabManager implements ChangeListener
{
    StatsTab stats = new StatsTab();

    private static JPanel statPanel;
//    private static JPanel skillPanel;
//    private static JPanel armorPanel;

    public JPanel create(String tabName)
    {
        if(tabName.equals("Stats"))
            statPanel = stats.create();

        return statPanel;
    }

    @Override
    public void stateChanged(ChangeEvent e)
    {
        JTabbedPane source = (JTabbedPane) e.getSource();

        // TODO: Future patch. This class will handle creating the UI of each tab and saving data from each tab.
        // Stats Tab is index 0
        if(source.getSelectedIndex() == 0)
        {
            Interface.getTabs().setComponentAt(0, stats.create());
            Interface.getFrame().revalidate();
        }
    }
}
