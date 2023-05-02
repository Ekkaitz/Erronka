import java.io.*;
import java.util.ArrayList;
import java.util.Iterator;

public class Numbers {
    public static int generate1Num(int min,int max){
        int rnd=0;
        rnd=(int) Math.random()*max+min;

        return rnd;
    }

    public static ArrayList<Integer> generateNums(int min, int max, int cantidad){
        int rnd=0;
        ArrayList<Integer> arrayList=new ArrayList<>(cantidad);

        for (int i = 0; i < arrayList.size(); i++) {
            arrayList.set(i,generate1Num(min,max));
        }
        return arrayList;
    }

    public  static void add1Num(String izena,int zenbakia){
        try {
            FileOutputStream file=new FileOutputStream(izena);
            file.write(zenbakia);
            file.close();
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static void addNums(String izena,ArrayList<Integer> arrayLista){
        try {
            FileOutputStream file=new FileOutputStream(izena);
            for (int i = 0; i < arrayLista.size(); i++) {
                file.write(arrayLista.get(i));
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

    public static int findInFile(String izena,int posizioa) {
        int x;
        try {
            FileInputStream in = new FileInputStream(izena);
            FileOutputStream out = new FileOutputStream(izena);

            x = in.read();
            int kont = 0;

            while (kont != posizioa && in.read() != -1) {
                x = in.read();
                kont++;
            }

        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        return x;
    }

    public static void displayfile(DataInputStream a) throws IOException {
        int kont=0;
        int kantitatea=a.available()/4;

        for (int i = 0; i < kantitatea ; i++) {
            int cont=a.readInt();
            System.out.println(cont);
        }
    }


}
