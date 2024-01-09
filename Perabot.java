public class Perabot implements iPerabot {
    public String nama;
    public String cat;
    public String detail;
    public Integer jumlah;

    public Perabot(String nama,String cat,String detail,Integer jumlah){
        this.nama = nama;
        this.cat = cat;
        this.detail = detail;
        this.jumlah = jumlah;
        System.out.println("Pesanan : " + nama + " warna " + cat +" "+ detail + " sebanyak "+ jumlah + " buah");
        geser(nama);
        cetak();
        History history = new History(nama, jumlah);
    }

    @Override
    public void geser(String nama) {
        System.out.println();
        if(nama.equals("meja")){
            System.out.println("Bisa di geser");
        }else{
            System.out.println("Tidak Bisa di geser");
        }
    }

    public void cetak(){

        System.out.println("Berhasil Di Pesan!");
    }


    

}
