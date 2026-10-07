public class Main {
    public static void main(String[]args){
        Mahasiswa m1 = new Mahasiswa("241001", "Asep");
        Mahasiswa m2 = new Mahasiswa("241002", "Siti");

        System.out.println(m1.getNim() + "-" + m1.getNama());
        System.out.println(m2.getNim() + "-" + m2.getNama());
    }
}