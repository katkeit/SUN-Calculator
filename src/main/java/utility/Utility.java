package utility;

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

import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Utility
{
    private static String[] output = new String[1];

    // This class will find the absolute directory where the application resides.
    public String[] findDirectory()
    {
        Path currentRelativePath = Paths.get("");
        String absolutePath = currentRelativePath.toAbsolutePath().toString().replaceAll("\\\\", "/");
        output[0] = absolutePath + "/";

        return output;
    }

    public void openBrowser(String link, boolean status)
    {
        try
        {
            if (Desktop.isDesktopSupported() && Desktop.getDesktop().isSupported(Desktop.Action.BROWSE))
            {
                if(status)
                    Desktop.getDesktop().browse(new URI(link));
                else
                {
                    File htmlFile = new File(link);
                    Desktop.getDesktop().browse(htmlFile.toURI());
                }
            }

        } catch (URISyntaxException | IOException ex) {
            ex.printStackTrace();
        }
    }

    public static String[] getOutput() {
        return output;
    }
}
