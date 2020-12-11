package dk.colourit.model;

import java.io.File;
import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.util.Scanner;

public class ReadFromBin {
  public static void main(String[] args) {
    Scanner input = new Scanner(System.in);
    System.out.println("Please input the filename(no extension) for the BIN file you want to open to read");
    String filename = input.nextLine() + ".bin";
    File file = new File(filename);
    System.out.println("The file "+filename+" reads:");
    int counter;
    String[] text = null;
    try {
      FileInputStream fis = new FileInputStream(file);
      ObjectInputStream in = new ObjectInputStream(fis);
      counter = in.readInt();
      text = new String[counter];
      for (int i = 0; i < counter; i++) {
        text[i] = in.readUTF();
      }
      in.close();
    } catch (Exception e) {
      System.out.println("!<ERROR ENCOUNTERED>!");
      System.out.println(e);
    }
    for (String string : text) {
      System.out.println(string);
    }
  }
}
