import javax.swing.*;
import java.io.*;
import java.nio.file.FileSystemNotFoundException;
import java.nio.file.Files;
import java.nio.file.Path;
import static java.nio.file.StandardOpenOption.CREATE;


public class Main
{

    public static void main(String[] args)
    {
        JFileChooser chooser = new JFileChooser();
        File selectedFile;
        String read = " ";
        int lineNum = 0;
        int wordNum = 0;
        int charNum = 0;
        String[] lines;
        try
        {
            File pick = new File(System.getProperty("user.dir"));
            chooser.setCurrentDirectory(pick);

            if(chooser.showOpenDialog(null) == JFileChooser.APPROVE_OPTION)
            {
                selectedFile = chooser.getSelectedFile();
                Path file = selectedFile.toPath();
                InputStream in = new BufferedInputStream(Files.newInputStream(file, CREATE)); // input stream creation //
                BufferedReader reader = new BufferedReader(new InputStreamReader(in)); // reads the text from the input //

                while(reader.ready())
                {
                    read = reader.readLine();
                    lineNum += 1; // add to the line count //
                    lines = read.split(" ");
                    wordNum = wordNum + lines.length; // add to the word count //
                    charNum = charNum + read.length(); // add to the character count //
                }
                System.out.println("The number of lines in the file are " + lineNum); // outputs the line count in the text file //
                System.out.println("The name of the file selected is " + selectedFile.getName()); // outputs the name of the text file //
                System.out.println("The number of words in the file are " + wordNum); // outputs the word count in the text file //
                System.out.println("The number of characters in the file chosen are " + charNum); // outputs the character count in the text file //
                reader.close(); //force closes the stream and any data that is tied to it
                System.out.println();
                System.out.println( selectedFile.getName() + " has been processed!"); // confirms that the file has been parsed //
            }
            else
            {
                System.out.println("Please Select a File.");
                System.out.println("Please Rerun the Program");
                System.exit(0);

            }
        }
        catch (IOException e) {
            throw new RuntimeException(e);
        }
        catch (FileSystemNotFoundException e)
        {
            System.out.println("File was not Found");
            e.printStackTrace();
        }
    }
    }