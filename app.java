import java.util.Scanner;

public class app {
    public static void main(String [] args){
        System.out.println("Selamat Datang di Olders Perabot");
        System.out.println("Silahkan buat Pesanan");
        boolean ulang = false;
        do{
            Pembelian pembelian = new Pembelian();
            System.out.println("apakah anda ingin memesan lagi?");
            Scanner cin = new Scanner(System.in);
            String ans = cin.next();
            if(ans.toLowerCase().equals("yes")){
                ulang = true;
            }else{
                ulang = false;
            }
        }while(ulang == true);
        
        History history = new History();
        history.printHistory();
        
    }
}
