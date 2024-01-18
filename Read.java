import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;

public class Read
{
    public List<String> fileToList(String file)
    {
        List<String> words = new ArrayList<>();
        try
        {
            File current_file = new File(file);
            Scanner scanner = new Scanner(current_file);
            while (scanner.hasNextLine())
            {
                words.add(scanner.nextLine());
            }
            scanner.close();
        }
        catch (FileNotFoundException e)
        {
            System.out.println("File not found" + file);
        }
        return words; 
    }
}