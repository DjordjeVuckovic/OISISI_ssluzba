package serial;

import model.BazaPodataka;

import java.io.*;

public class Serialization {

    public static void writeToFile(BazaPodataka bazaPodataka) throws IOException{
        File f = new File("BazaPodataka.txt");
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(new BufferedOutputStream(new FileOutputStream(f)));
        try {
            objectOutputStream.writeObject(bazaPodataka);
        }finally {
            objectOutputStream.close();//
        }
    }
    public static BazaPodataka readFile() {

        File f = new File("BazaPodataka.txt");
        try {
            ObjectInputStream objectInputStream = new ObjectInputStream(new BufferedInputStream(new FileInputStream(f)));
            try {
                BazaPodataka bp = (BazaPodataka) objectInputStream.readObject();
                return bp;
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }finally {
                objectInputStream.close();
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

}
