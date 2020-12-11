import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class WriteToBin {
  public static void main(String[] args) throws IOException {
    Scanner in = new Scanner(System.in);
    ArrayList<String> text = new ArrayList<>();
    System.out.println("Please input the desired filename without file extension (if it exists, it will be overwritten)");
    String filename = in.nextLine() + ".bin";
    File file = new File(filename);
    FileOutputStream fos = new FileOutputStream(file);
    ObjectOutputStream out = new ObjectOutputStream(fos);
    do {
      text.add(in.nextLine());
    } while (!text.get(text.size() - 1).equals("quit"));
    text.remove(text.size() - 1);
    System.out.println(text.size());
    out.writeInt(text.size());
    for (String s : text) {
      out.writeUTF(s);
      out.flush();
    }
    out.close();
  }
}
