import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class TextParser{

    public static void main(String[] args){

        BufferedReader reader;
		try {
			reader = new BufferedReader(new FileReader(
					"input.txt"));
			String line = reader.readLine();
			while (line != null) {
                line = line.toLowerCase();
				System.out.println(isUniqueChar(line) + "\t" + sortWord(line));
				// read next line
				line = reader.readLine();
			}
			reader.close();
		} catch (IOException e) {
			e.printStackTrace();
		}

    }

    public static boolean isUniqueChar(String line){

        String str = line;
        for (int i = 0; i < str.length(); i++) 
        for (int j = i + 1; j < str.length(); j++) 
            if (str.charAt(i) == str.charAt(j)) 
                return false; 

    // If no duplicate characters encountered, 
    // return true 
    return true; 
    }

    //sorting function
    public static String sortWord(String line){
        char [] array = line.toCharArray();
        int len = array.length;

        for (int i = len - 1; i > 0; i--) {
            if (array[i] < array[i - 1]) {
                swap(array, i, i - 1);
            }
        }

        for (int i = 2; i < len; i++) {
            char temp = array[i];
            int j = i;
            while (temp < array[j - 1]) {
                array[j] = array[j - 1];
                j--;
            }
            array[j] = temp;
        }

        return new String(array);
    }

    //swapping function
    private static  void swap(char[] array, int i, int j) {
        char temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }
}