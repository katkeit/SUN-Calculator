package Utility;

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
import FileIO.Language;
import Interface.Interface;

import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URL;
import java.nio.channels.Channels;
import java.nio.channels.ReadableByteChannel;

public class Downloader
{
    private ReadableByteChannel readChannel;
    private FileOutputStream fileOS;

    public boolean startDownload(String url, String fileName)
    {
        try
        {
            Interface.getLabel().setText((String)Language.getDownloaderMessages().get(0) + fileName + "...");
            this.readChannel = Channels.newChannel((new URL(url)).openStream());
            this.fileOS = new FileOutputStream(FileIO.getDownloadFolder() + fileName);
            this.fileOS.getChannel().transferFrom(this.readChannel, 0L, Long.MAX_VALUE);
            this.fileOS.close();

            Interface.getLabel().setText((String)Language.getDownloaderMessages().get(1) + fileName + "...");
            return true;
        }
        catch (IOException e) {
            e.printStackTrace();
            return false;
        }
    }
}
