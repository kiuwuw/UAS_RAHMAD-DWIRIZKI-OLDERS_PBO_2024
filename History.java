import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import javax.xml.validation.Schema;

import java.util.Date;
import java.text.SimpleDateFormat;
import java.time.format.DateTimeFormatter;

public class History {
    public static ArrayList<List<Object>> data = new ArrayList<>();
    
    public History(){}

    public History(String barang, Integer Jumlah){
        Date tanggal = new Date();
        SimpleDateFormat formattanggal = new SimpleDateFormat("dd-MM-yyyy");
        String stringtanggal = formattanggal.format(tanggal);
        data.add(List.of(barang,Jumlah,stringtanggal));
        System.out.println("Pembelian " + barang + " " + Jumlah + " buah pada tanggal " + stringtanggal  );
        CRUD crud = new CRUD();
        crud.runData();
        crud.createData( barang, Jumlah, stringtanggal);
        System.out.println("apakah anda ingin menghapus semua data : ");
        Scanner cin = new Scanner(System.in);
        String ans = cin.next();
        if(ans.toLowerCase().equals("yes")){
            crud.removeAllData();
        }
        System.out.println("apakah anda ingin melihat semua data pada database : ");
        ans = cin.next();
        if(ans.toLowerCase().equals("yes")){
            crud.readData();
        }
        System.out.println("apakah anda ingin update semua data : ");
        ans = cin.next();
        if(ans.toLowerCase().equals("yes")){
            Scanner string = new Scanner(System.in);
            Scanner dstring = new Scanner(System.in);
            Scanner integer = new Scanner(System.in);
            System.out.println("inputkan data yang akan di update :");
            System.out.println("nama barang    : ");
            String fbarang = dstring.nextLine();
            System.out.println("jumlah barang  : ");
            Integer fjumlah = integer.nextInt();
            System.out.println("tanggal pembelian : ");
            String ftanggal = string.next();
            System.out.println("inputkan data update ");
            System.out.println("nama barang    : ");
            String nbarang = dstring.nextLine();
            System.out.println("jumlah barang  : ");
            Integer njumlah = integer.nextInt();
            System.out.println("tanggal pembelian : ");
            String ntanggal = string.next();
            crud.updateData(fbarang, fjumlah, ftanggal, nbarang, njumlah, ntanggal);
        }

        crud.stopData();
    }

    public void printHistory(){
        for (List<Object> triple : data) {
            String barang = (String) triple.get(0);
            int jumlah = (int) triple.get(1);
            String tanggal = (String) triple.get(2);

            System.out.println(triple + ".Barang : " + barang + ", Jumlah: " + jumlah + ", Tanggal Pembelian: " + tanggal);
        }
    }
}
