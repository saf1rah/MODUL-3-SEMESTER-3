package TUGAS2; //setelah refactor (belum di javadoc)

//dokumentasi class dan method (javadoc)

import java.time.LocalDate;
import java.time.Period;
import java.util.Scanner;


/**
 * kelas <kode>hitungUsia2</kode> digunakan untuk menghitung usia seseorang berdasarkan tanggal lahir yang diinputkan oleh pengguna
 */
public class hitungUsia2 {

    /**
     * metode utama yang meminta pengguna untuk memasukkan tanggal, bulan, dan tahun lahir
     * kemudian menampilkan usia dalam tahun, bulan, dan hari
     *
     * @param args argumen baris perintah (tidak digunakan disini)
     */
        public static void main(String[] args) {
            Scanner scanner = new Scanner(System.in);

            System.out.print("Masukkan tanggal lahir (1-31): ");
            int hariLahir = scanner.nextInt();

            System.out.print("Masukkan bulan lahir (1-12): ");
            int bulanLahir = scanner.nextInt();

            System.out.print("Masukkan tahun lahir (misal: 1990): ");
            int tahunLahir = scanner.nextInt();

            LocalDate tanggalLahir = validasiTanggal(tahunLahir, bulanLahir, hariLahir);
            Period usia = hitungUsia(tanggalLahir);

            //REFACTORING 3: merubah menjadi printf untuk format string yg lebih jelas
            System.out.printf("Usia Anda saat ini: %d tahun, %d bulan, dan %d hari.%n",
                    usia.getYears(), usia.getMonths(), usia.getDays());

            //REFACTORING 5: menghapus scanner.close();
        }

        //REFACTORING 4: menjadi hitungUsia

    /**
     * menghitung usia seseorang berdasarkan tanggal lahir yang diberikan
     *
     * @param tanggalLahir tanggal lahir yang suda divalidasi
     * @return objek <code>period</code> mempresentasikan selisih antara tanggal lahir, dan tanggal saat ini dalam tahun, bulan, dan hari
     */
        private static Period hitungUsia(LocalDate tanggalLahir) {
            LocalDate sekarang = LocalDate.now();
            Period usia = Period.between(tanggalLahir, sekarang);
            return usia;
        }

        //REFACTORING 2: validasi tanggal

    /**
     * memvalidasi tanggal yang diinputkan oleh user atau pengguna
     *
     * @param tahunLahir tahun lahir yang diinputkan
     * @param bulanLahir bulan lahir yang diinputkan
     * @param hariLahir hari lahir yang diinputkan
     * @return tanggal lahir  dalam format <code>LocalDate</code>
     */
        private static LocalDate validasiTanggal(int tahunLahir, int bulanLahir, int hariLahir) {
            LocalDate tanggalLahir = ambilTanggalLahir(tahunLahir, bulanLahir, hariLahir);
            return tanggalLahir;
        }

        //REFACTORING 1

    /**
     * membuat tanggal lahir dalam bentuk objek <code>LocalDate</code> berdasarkan tahun, bulan, dan hari yang diberikan
     *
     * @param tahunLahir tahun lahir yang diinputkan
     * @param bulanLahir bulan lahir yang diinputkan
     * @param hariLahir hari lahir yang diinputkan
     * @return tanggal lahir dalam format <code>LocalDate</code>
     */
        private static LocalDate ambilTanggalLahir(int tahunLahir, int bulanLahir, int hariLahir) {
            LocalDate tanggalLahir = LocalDate.of(tahunLahir, bulanLahir, hariLahir);
            return tanggalLahir;
        }
    }


