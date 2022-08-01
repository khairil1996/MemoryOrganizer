
//please note that I use "Apache Commons Collections"
//you may first need to import the "Apache Commons Collections"
//Reference: https://www.tutorialspoint.com/commons_collections/commons_collections_quick_guide.htm
import org.apache.commons.io.FileUtils;
import org.apache.commons.io.FilenameUtils;

import java.io.File;
import java.util.Arrays;

import static org.apache.commons.io.comparator.SizeFileComparator.*;

public class Main {
    public static void main(String[] args) {

        //re-edit the folder Path
        File myFile = new File("C:\\Users\\user\\Desktop\\Aemulus");
        File[] listFiles = myFile.listFiles();

        System.out.println("==================================================");
        System.out.printf("%-30s  %-10s %s%n", "Name", "Size", "Type");
        System.out.println("==================================================");

        if (listFiles != null) {
            //sort the file size from bigger to smaller size
            Arrays.sort(listFiles, SIZE_SUMDIR_REVERSE);
            Main.displayFileOrder(listFiles, true);
        }

    }

    //function to display File List
    private static void displayFileOrder(File[] files, boolean displayDirectory) {
        for (File file : files) {
            //if the file is not a folder, then run below
            if (!file.isDirectory()) {
                //to get file extension
                String extension = FilenameUtils.getExtension(file.getAbsolutePath());
                //use file.length() to get the file size
                System.out.printf("%-30s  %-10s %s%n", file.getName(), FileUtils.byteCountToDisplaySize(file.length()), extension);
                //if the file is a folder, then run below
            } else if (displayDirectory) {
                //use FileUtils.sizeOfDirectory(file) to get the folderSize
                long size = FileUtils.sizeOfDirectory(file);
                String newSize = FileUtils.byteCountToDisplaySize(size);
                String type = "Folder";
                System.out.printf("%-30s  %-10s %s%n", file.getName(), newSize, type);
            }
        }
        System.out.println("==================================================");
    }
}
