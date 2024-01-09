import java.util.Scanner;

public class Kunsen extends Perabot {




    public Kunsen(String nama, String cat, Integer lubangKunsen , Integer jumlah){
        super(nama, cat,lubangKunsen.toString() + " lubang",jumlah);
        // cetak();
    }

    public void cetak(){
        System.out.println("Berhasil di pesan!");
    }

}