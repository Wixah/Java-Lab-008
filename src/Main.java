/**
 * @author Trevor Hartman
 * @author Rachelle Iloff
 * created 3/21/2023
 * @since version 1.0
 */
import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);// Create a scanner object
        boolean skipWs; // Create a variable called skipWs that stores the user's response as a boolean
        File file; // Reference Java-Assignment-003 to see how to use the java.nio libraries to turn a String path into a File
        Path path;
        String quit = "q";

        while (true) {
            System.out.println("Please enter a file path to gather stats on. Otherwise, please press Q to exit.");// Write a loop that will ask the user to
            // enter a file path to gather stats on,
            String pathName = scanner.nextLine();
            if (pathName.equalsIgnoreCase(quit)) { // and continue until "Q" is entered.
                break;
            }

            path = Paths.get("resources", pathName);
            Path absPath = path.toAbsolutePath();
            file = absPath.toFile();

            System.out.println("Would you like to print this with Whitespace? Y for yes or press N for no.");// Ask the user if they would like to skip whitespace
            String wsAnswer = scanner.nextLine();


            if ("n".equalsIgnoreCase(wsAnswer)) skipWs = false;//no whitespace
            else skipWs = true;  //print whitespace

            try {
                FileStats fileStats = new FileStats(file, skipWs); // You will need to create a FileStats object by passing it the File object and your skipWs variable as args
                fileStats.read();  // You will need to call the fs.read method, which you need to implement!
                System.out.printf("Here are the stats for %s\nLines - %d, Words - %d, Characters = %d \n", fileStats.getFileName(), fileStats.getNumLines(), fileStats.getNumWords(), fileStats.getNumChars()); //* write code to get the line, word, and character count of the File object created above!
                //* You will access the FileStats object's getter methods to get the file's line, word, character count and
                //the files name. You should use a format specifier to print it all out similar to the following example:
                //* Stats: lines - 6, words - 46, chars - 237 /path/to/file/fileName.txt
            } catch (IOException e) {
                System.err.println(e.getMessage()); //

            }

        }
    }
}

