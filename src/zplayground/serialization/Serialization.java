package zplayground.serialization;

import java.io.*;

public class Serialization {

  public static void main(String[] args) {
    ArbitraryClass arbitraryObj = new ArbitraryClass("arbitraryValue");
    try (FileOutputStream fs = new FileOutputStream("arbitraryFile.txt")) {
      ObjectOutputStream os = new ObjectOutputStream(fs);

      os.writeObject(arbitraryObj);
      os.close();

    } catch (IOException e) {
      throw new RuntimeException(e);
    }

    try (FileInputStream fs = new FileInputStream("arbitraryFile.txt")) {
      ObjectInputStream oi = new ObjectInputStream(fs);

      ArbitraryClass readObj = (ArbitraryClass) oi.readObject();
      System.out.println(readObj.getArbitraryValue());
      oi.close();
    } catch (IOException e) {
        throw new RuntimeException(e);
    } catch (ClassNotFoundException e) {
        throw new RuntimeException(e);
    }
  }
}
