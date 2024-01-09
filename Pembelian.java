import java.util.InputMismatchException;
import java.util.Scanner;

public class Pembelian implements iPerabot  {
    public String s;
    public Integer lubangKunsen;
    public String warna;
    public Integer jumlah;


    public Pembelian(){
        Scanner input = new Scanner(System.in);
        Boolean check = false;
        do{
            if(check == true){
                System.out.println("Inputan Salah!");
            }
            System.out.print ("Pesan Mebel atau Kunsen :");
            s=input.next();
            s = s.toLowerCase();
            check = true;
        }while(!s.equals("mebel") && !s.equals("kunsen"));
        if(s.equals("mebel")){
            mebel();
        }else{
            kunsen();
        }

    }

    public void barang(){
        Scanner cin = new Scanner(System.in);
        Scanner input = new Scanner(System.in);
        System.out.print("Inputkan Warna "+ s + " : " );
        warna = input.next();
        boolean salah = false;
        System.out.print("Inputkan Jumlah Pemesanan : ");
        jumlah = cin.nextInt();

        // do{
        //         if(check>0)
        //             System.out.println("Input ulang !!!");
        //         check++;
        //     try {
        //         jumlah = integer.nextInt();
        //         salah = true;
        //         break;
        //     } catch (InputMismatchException e) {
        //         System.out.println("Masukkan Bilangan !!!");}
        // }while(!salah); 
    }

    @Override
    public void mebel(){
        Scanner input = new Scanner(System.in);
        Scanner cin = new Scanner(System.in);
        Boolean check = false;
        do{
            if(check == true){
                System.out.println("Inputan Salah!");
            }
            System.out.print ("Pesan Pintu , Jendela atau Meja :");
            s=input.next();
            s = s.toLowerCase();
            check = true;
        }while(!s.equals("pintu") && !s.equals("jendela") && !s.equals("meja"));
        
        barang();
        System.out.print("Inputkan Detail barang : ");
        String detail= cin.nextLine();
        Mebel mebel = new Mebel(s,warna,detail,jumlah);
    }

    @Override
    public void kunsen(){
        Scanner input = new Scanner(System.in);
        Scanner cin = new Scanner(System.in);
        Boolean check = false;
        do{
            if(check == true){
                System.out.println("Inputan Salah!");
            }
            System.out.print ("Pesan Pintu atau Jendela :");
            s=input.next();
            s = s.toLowerCase();
            check = true;
        }while(!s.equals("pintu") && !s.equals("jendela"));
        s = "kunsen " + s;
        barang();
        System.out.print("Inputkan berapa banyak Lubang Kunsen : ");
        lubangKunsen = cin.nextInt();
        Kunsen kunsen = new Kunsen(s,warna,lubangKunsen,jumlah);
    }

}
