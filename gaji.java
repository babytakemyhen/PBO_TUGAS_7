import java.util.Scanner;

public class gaji {
     public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int jamKerja, golongan, gaji, gajiLembur;
        double gajiBersih;

        System.out.print("Golongan: ");
        golongan = Integer.parseInt(input.nextLine());
        System.out.print("Jam Kerja: ");
        jamKerja = Integer.parseInt(input.nextLine());

        Karyawan karyawan = new Karyawan(golongan, jamKerja);

        gaji = karyawan.getGaji();
        gajiLembur = karyawan.getGajiLembur();
        gajiBersih = (gaji + gajiLembur) * 99.5 / 100;

        System.out.printf("Gaji Bersih Karyawan Tersebut Adalah: "+ gajiBersih);
    }
}

class Karyawan{
    int golongan;
    int gajiPokok;
    int tunjangan;
    int jamKerja;

    public Karyawan(int golongan, int jamKerja){
        this.golongan = golongan;
        this.jamKerja = jamKerja;
        switch (golongan) {
            case 1:
                this.gajiPokok = 1486500;
                this.tunjangan = 250000;
                break;
            case 2:
                this.gajiPokok = 1926000;
                this.tunjangan = 300000;
                break;
            case 3:
                this.gajiPokok = 2456700;
                this.tunjangan = 350000;
                break;
            case 4:
                this.gajiPokok = 2899500;
                this.tunjangan = 400000;
                break;
        }
    }

    public int getGaji (){
        int gajiKotor;
        gajiKotor=gajiPokok+tunjangan;

        return gajiKotor;
    }

    public int getGajiLembur (){
        int gajiLembur, jamLembur;
        if (jamKerja > 173){
            jamLembur =  jamKerja - 173;
            gajiLembur = jamLembur * 20000;
        } else {
            jamLembur = 0;
            gajiLembur = 0;
        }

        return gajiLembur;
    }
}
