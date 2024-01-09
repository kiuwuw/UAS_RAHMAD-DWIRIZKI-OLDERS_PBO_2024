public class Mebel extends Perabot  {


    public void geser() {
        String s = super.nama;
        s += " bisa di geser ke mana saja";
    }

    
    public Mebel(String nama, String cat, String detail , Integer jumlah){
        super(nama, cat,detail,jumlah);
        // cetak();
    }
    public void cetak(){
        System.out.println("Berhasil di pesan!");
    }


}
