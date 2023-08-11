package me.dodas.util;

import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class FileManager {

    public static String getFileExtension(String fileName){

        if (fileName.contains(".")){
            return fileName.substring(fileName.lastIndexOf(".") + 1);
        } else {
            return "";
        }

    }

    public static Boolean verifyImageFile(File imgPath){

        List<String> imgFilesExtensions = new ArrayList<>();
        imgFilesExtensions.add("png");
        imgFilesExtensions.add("jpg");
        imgFilesExtensions.add("jpeg");

        if (imgFilesExtensions.contains(FileManager.getFileExtension(imgPath.getName()))){

            return true;

        } else {

            return false;

        }

    }

    public static Boolean verifyZipFile(File zipPath){

        List<String> zipFileExtensions = new ArrayList<>();
        zipFileExtensions.add("zip");

        if (zipFileExtensions.contains(getFileExtension(zipPath.getName()))){

            return true;

        } else {

            return false;

        }

    }

}
