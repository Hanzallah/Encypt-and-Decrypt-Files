import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

public class EncryptDecrypt {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner scan = new Scanner( new File("FILE TO ENCRYPT GOES HERE"));
        PrintWriter out = new PrintWriter("FILE WHERE TO SEND THE ENCRYPTED OUTPUT");

        while(scan.hasNextLine()) {
            int i = 0;
            String line = scan.nextLine();
            while (i < line.length()) {
                char ch = line.charAt(i);
                out.print(encrypt(ch,4));
                i++;
            }
        }

        out.close();
        scan.close();

        scan = new Scanner( new File("FILE TO DECRYPT GOES HERE"));
        out = new PrintWriter("FILE WHERE TO SEND THE DECRYPTED OUTPUT");

        while(scan.hasNextLine()) {
            int i = 0;
            String line = scan.nextLine();
            while (i < line.length()) {
                char ch = line.charAt(i);
                out.print(decrypt(ch,4));
                i++;
            }
        }

        out.close();
        scan.close();

    }

    public static char encrypt(char ch, int shift) {

        int start = 0;
        final int LETTERS = 26;


        if (ch >= 'A' && ch <= 'Z') {
            start = 'A'; // 65
        }
        else if (ch >= 'a' && ch <= 'z') {
            start = 'a'; // 97
        }
        else {
            return ch; // Not a letter
        }


        int offset = ch - start + shift;

        if (offset >= LETTERS) {
            offset = offset - LETTERS;
        }
        else if (offset < 0) {
            offset = offset + LETTERS;
        }

        return (char) (start + offset);
    }

    public static char decrypt(char ch, int shift) {
        int start = 0;
        int end = 0;

        if (ch >= 'A' && ch <= 'Z') {
            start = 'A'; // 65
            end = 'Z';
        } else if (ch >= 'a' && ch <= 'z') {
            start = 'a'; // 97
            end = 'z';
        } else {
            return ch; // Not a letter
        }


        if ((ch - shift) < start) {
            if ((ch - start - shift) < 0) {
                return (char) (end + (ch - start - shift) + 1);
            } else {
                return (char) (end - (ch - start - shift));
            }

        } else {
            return (char) (start + (ch - start - shift));
        }
    }
}