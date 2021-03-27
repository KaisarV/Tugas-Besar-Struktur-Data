package Tubes;

import javax.swing.JOptionPane;
import java.util.*;

public class Tubes {

    static class Feedback {

        String caption;
        Feedback next;
        Feedback prev;
    }

    static class User {

        String user[][] = {
            {"nathanael", "123", "Nathanael Billy", "0812659890"},
            {"kaisar", "456", "Kaisar Valentino", "0812785632"},
            {"edwan", "789", "Edwan Limanjaya", "081256437891"}
        };

        String admin[] = {"admin", "admin"};

        //Pulsa , kuota, poin, 
        int pulsa[][] = {
            {10000, 100, 210},//saldo billy
            {200000, 50, 5000},//saldo kaisar
            {50000, 80, 60}//saldo edwan
        };

        //Saldo, Pin
        int bank[][] = {
            {1, 500000, 12345},//Akun billy (BCA)
            {2, 1000000, 45678},//Akun kaisar (Mandiri)
            {3, 200000, 56789}//Akun edwan (CIMB Niaga)
        };
    }

    public static String username;
    public static String password;
    static Feedback head = null;
    static Feedback tail = null;

    //Fungsi untuk login user ataupun admin
    static int loginUser(int pilihan, User data) {
        int cek = 0;

        username = JOptionPane.showInputDialog(null,
                "                                MyPulsa"
                + "\n===================================="
                + "\nSilahkan masukkan username anda"
                + "\n\nUsername : ");
        password = JOptionPane.showInputDialog(null,
                "                                MyPulsa"
                + "\n===================================="
                + "\nSilahkan masukkan password anda"
                + "\n\nPassword : ");

        if (pilihan == 1) {
            for (int i = 0; i < 3; i++) {
                if (username.equals(data.user[i][0]) && password.equals(data.user[i][1])) {
                    cek = 1;
                    JOptionPane.showMessageDialog(null, "Login Berhasil !");
                    JOptionPane.showMessageDialog(null, "Selamat Datang, "
                            + data.user[userArrayLocation(data)][2]);
                    break;
                } else {
                    cek = 0;
                }
            }
            if (cek == 0) {
                JOptionPane.showMessageDialog(null, "Username atau Password salah !");
            }
        } else {
            if (username.equals(data.admin[0]) && password.equals(data.admin[1])) {
                cek = 1;
                JOptionPane.showMessageDialog(null, "Login Berhasil !");
            } else {
                cek = 0;
            }
        }
        return cek;
    }

    //Mencari Posisi User pada Array
    static int userArrayLocation(User data) {
        int pengguna = 0;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 2; j++) {
                if (username.equals(data.user[i][0]) && password.equals(data.user[i][1])) {
                    pengguna = i;
                }
            }
        }

        return pengguna;
    }

    //Mengucapkan Salam Sesuai Jam
    public static String getGreetings() {
        Calendar c = Calendar.getInstance();
        int timeOfDay = c.get(Calendar.HOUR_OF_DAY);

        if (timeOfDay < 12) {
            return "Selamat Pagi, ";
        } else if (timeOfDay < 15) {
            return "Selamat Siang, ";
        } else if (timeOfDay < 18) {
            return "Selamat Sore, ";
        } else {
            return "Selamat Malam, ";
        }
    }

    //Fungsi menampilkan tanggal
    public static Date getDate() {
        Date today = Calendar.getInstance().getTime();

        return today;
    }

    //Fungsi untuk menampilkan menu user
    static int menuUser(User data, int pengguna) {
        int pilihan;

        pilihan = Integer.parseInt(JOptionPane.showInputDialog(
                "                        MyPulsa App"
                +"\n================================"
                + "\n" + getGreetings() + data.user[pengguna][2]
                + "\n================================"
                + "\n" + getDate()
                + "\n\n" + data.user[pengguna][3]
                + "\n" + data.pulsa[pengguna][0]
                + "\n\nMasukkan Pilihan anda : "
                + "\n1. Isi Pulsa"
                + "\n2. Beli Kuota"
                + "\n3. Tukar Point"
                + "\n4. Cek Profil"
                + "\n5. Feedback"
                + "\n6. Log Out"
        ));

        return pilihan;
    }

    static void profilUser(User data, int pengguna) {
        JOptionPane.showMessageDialog(null,
                "===================================="
                + "\n                                  Profil"
                + "\n===================================="
                + "\nNama           : " + data.user[pengguna][2]
                + "\nNomor         : " + data.user[pengguna][3]
                + "\nSaldo           : " + data.pulsa[pengguna][0]
                + "\nKuota           : " + data.pulsa[pengguna][1] + "GB"
                + "\nPoin              : " + data.pulsa[pengguna][2]
                + "\n\n===================================="
        );

    }

    //Prosedur untuk melakukan pengisian pulsa
    static void isiPulsa(User data, int pengguna) {

        int pilihPulsa;
        int harga = 0;
        int pilihan = 0;
        int saldo = 0;
        boolean cek = true;
        boolean cek4 = true;

        do {
            do {
                pilihPulsa = Integer.parseInt(JOptionPane.showInputDialog(null,
                        "Masukkan Pilihan Pulsa : "
                        + "\n-------------------------------------"
                        + "\n   Saldo         |     Harga"
                        + "\n-------------------------------------"
                        + "\n1. 5.000        |   Rp. 7.000"
                        + "\n2. 10.000      |   Rp. 12.000"
                        + "\n3. 20.000      |   Rp. 22.000"
                        + "\n4. 50.000      |   Rp. 51.000"
                        + "\n5. 100.000    |   Rp. 100.000"
                        + "\n-------------------------------------"
                        + "\n6. Exit"
                ));
                if (pilihPulsa > 6) {
                    JOptionPane.showMessageDialog(null, "Menu Tidak Tersedia !",
                            "Failure", JOptionPane.ERROR_MESSAGE);
                }
            } while (pilihPulsa > 6);

            switch (pilihPulsa) {
                case 1:
                    saldo = 5000;
                    harga = 7000;
                    break;
                case 2:
                    saldo = 10000;
                    harga = 12000;
                    break;
                case 3:
                    saldo = 20000;
                    harga = 22000;
                    break;
                case 4:
                    saldo = 50000;
                    harga = 51000;
                    break;
                case 5:
                    saldo = 100000;
                    harga = 100000;
                    break;
            }

            if (pilihPulsa != 6) {
                do {
                    do {

                        pilihan = Integer.parseInt(JOptionPane.showInputDialog(null,
                                "Masukkan Metode Pembayaran : "
                                + "\n 1. BCA"
                                + "\n 2. Mandiri"
                                + "\n 3. CIMB Niaga"
                                + "\n 4. Exit"
                        ));

                        String bank[] = {"BCA", "Mandiri", "CIMB Niaga"};
                        if (pilihan > 4) {
                            JOptionPane.showMessageDialog(null, "Menu Tidak Tersedia !",
                                    "Failure", JOptionPane.ERROR_MESSAGE);
                        }

                        if (pilihan < 4 && pilihan != data.bank[pengguna][0]) {
                            JOptionPane.showMessageDialog(null, "Aplikasi Bank " + bank[pilihan - 1] + " Tidak Tersedia di Ponsel anda",
                                    "Failure", JOptionPane.ERROR_MESSAGE);
                            pilihan = 10;
                        }

                    } while (pilihan > 4);

                    if (pilihan < 4) {
                        pulsaBank(pilihan, data, pengguna, harga, saldo);
                    }
                    if (pilihan == 4) {
                        cek4 = false;
                    }
                } while (cek4 != false);

            } else {
                cek = false;
            }

        } while (cek != false);
    }

    //Prosedur untuk pembelian pulsa melalui bank
    static void pulsaBank(int pilihan, User data, int pengguna, int harga, int saldo) {
        Random rand = new Random();
        int pilihan2;
        boolean cek2 = true;
        boolean cek3 = true;
        int va;
        int confirm = 0;
        int pin = 0;

        String array[] = {"BCA", "Mandiri", "CIMB Niaga"};

        int virtual = rand.nextInt(10000000);
        JOptionPane.showConfirmDialog(null, "Virtual Akun anda " + virtual);

        switch (pilihan) {
            case 1:
            case 2:
            case 3:
                do {
                    pilihan2 = Integer.parseInt(JOptionPane.showInputDialog(null,
                            "Aplikasi " + array[pilihan - 1] + " Mobile"
                            + "\n==============================================="
                            + "\n" + getGreetings() + data.user[pengguna][2]
                            + "\n==============================================="
                            + "\n 1. Cek Saldo"
                            + "\n 2. Transfer"
                            + "\n 3. Exit"
                    ));
                    if (pilihan2 != 3) {
                        do {
                            switch (pilihan2) {
                                case 1:
                                    JOptionPane.showMessageDialog(null, "Saldo anda sebesar " + data.bank[pengguna][1]);
                                    cek3 = false;
                                    break;

                                case 2:
                                    //Input Virtual Account
                                    do {
                                        va = Integer.parseInt(JOptionPane.showInputDialog(null,
                                                "Masukkan Nomor Virtual Account : \n0. Exit"));

                                        if (va == 0) {
                                            cek3 = false;
                                        } else if (va != virtual) {
                                            JOptionPane.showMessageDialog(null, "Virtual Account Tidak Ditemukan !",
                                                    "Failure", JOptionPane.ERROR_MESSAGE);
                                            cek3 = true;
                                        } else {
                                            JOptionPane.showMessageDialog(null, "Virtual Account Ditemukan !");
                                            cek3 = false;
                                        }
                                    } while (cek3 != false);

                                    //confirm
                                    if (va == virtual) {
                                        confirm = JOptionPane.showConfirmDialog(null, "Apakah anda yakin akan membayar sebesar "
                                                + harga + " ? ", "Confirm Dialog",
                                                JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE);
                                        cek3 = true;

                                    } else {
                                        cek3 = false;
                                    }

                                    if (confirm == 1) {
                                        cek3 = false;
                                    }

                                    if (cek3 == true) {
                                        do {
                                            pin = Integer.parseInt(JOptionPane.showInputDialog(null, "Masukkan Pin anda : "));
                                            if (pin == 0) {
                                                cek3 = false;
                                            } else if (pin != (data.bank[pengguna][2])) {
                                                JOptionPane.showMessageDialog(null, "Pin Salah !",
                                                        "Failure", JOptionPane.ERROR_MESSAGE);
                                                cek3 = true;
                                            } else {
                                                JOptionPane.showMessageDialog(null, "Pin Benar !");
                                                cek3 = false;
                                            }

                                        } while (cek3 != false);
                                    }

                                    if (pin == (data.bank[pengguna][2])) {
                                        cek3 = true;
                                    }

                                    if (cek3 == true) {
                                        if (data.bank[pengguna][1] < harga) {
                                            JOptionPane.showMessageDialog(null, "Saldo Bank anda tidak mencukupi !");
                                            cek3 = false;
                                        } else {
                                            JOptionPane.showMessageDialog(null, "Pembelian Berhasil !");
                                            data.bank[pengguna][1] -= harga;
                                            data.pulsa[pengguna][0] += saldo;
                                            data.pulsa[pengguna][2] += saldo / 1000;
                                            //Kembali ke menu utama
                                            cek2 = cek3 = false;
                                        }

                                    }
                                    System.out.println(data.bank[pengguna][1]);
                                    break;
                            }
                        } while (cek3 != false);
                    } else {
                        cek2 = false;
                    }

                } while (cek2 != false);
        }

    }

    //Prosedur untuk pembelian kuota dengan pulsa
    static void beliQuota(User data, int pengguna) {
        int pilihQuota = 0;
        do {
            pilihQuota = Integer.parseInt(JOptionPane.showInputDialog(null,
                    "Masukkan Nominal Pulsa : "
                    + "\n1. 1 Gb(Rp. 10.000)"
                    + "\n2. 3 Gb(Rp. 29.500)"
                    + "\n3. 5 Gb(Rp. 48.000)"
                    + "\n4. 10 Gb(Rp. 97.000)"
                    + "\n5. 20 Gb(Rp. 190.000)"
                    + "\n6. exit"));
            if (pilihQuota > 6) {
                JOptionPane.showMessageDialog(null, "Menu Tidak Tersedia !",
                        "Failure", JOptionPane.ERROR_MESSAGE);
            }
        } while (pilihQuota > 6);

        if (pilihQuota != 6) {
            int harga = 0;
            int quota = 0;
            switch (pilihQuota) {
                case 1:
                    harga = 10000;
                    quota = 1;
                    break;
                case 2:
                    harga = 29500;
                    quota = 3;
                    break;
                case 3:
                    harga = 48000;
                    quota = 5;
                    break;
                case 4:
                    harga = 97000;
                    quota = 10;
                    break;
                case 5:
                    harga = 190000;
                    quota = 20;
                    break;
                default:
                    JOptionPane.showMessageDialog(null, "Harga Tidak Tersedia !",
                            "Failure", JOptionPane.ERROR_MESSAGE);
            }
            if (data.pulsa[pengguna][0] < harga) {
                JOptionPane.showMessageDialog(null, "Pulsa anda tidak mencukupi !");
            } else {
                JOptionPane.showMessageDialog(null, "Selamat tansaksi anda berhasil !");
                data.pulsa[pengguna][0] -= harga;
                data.pulsa[pengguna][1] += quota;
                JOptionPane.showMessageDialog(null, "Quota anda telah ditambah sebesar " + quota + " GB");
                System.out.println(data.pulsa[pengguna][1]);
            }
        }

    }

    //Menampilkan data data user
    static void lihatData(User data) {
        for (int i = 0; i < data.user.length; i++) {
            JOptionPane.showMessageDialog(null, "untuk user ke-" + (i + 1)
                    + "\n Nama : " + data.user[i][2]
                    + "\n Nomor telepon : " + data.user[i][3]
                    + "\n Pulsa : " + data.pulsa[i][0]
                    + "\n Kuota : " + data.pulsa[i][1] + " GB"
                    + "\n Poin : " + data.pulsa[i][2]);
        }

    }

    static int penukaranPoint(int point, int pertukaran, int sisa) {
        int total = 0;
        if (point != sisa) {
            total += 10000 + penukaranPoint(point - 100, pertukaran, sisa);
        }
        return total;
    }

    static void menuPoint(User data, int pengguna) {
        int tanyaPoint = 0;
        int cek = 0;
        do {
            tanyaPoint = Integer.parseInt(JOptionPane.showInputDialog(null,
                    "Berapa point yang ingin Anda habiskan ?"
                    + "\n100 point = 10.000 pulsa"));

            if (tanyaPoint % 100 != 0) {
                JOptionPane.showMessageDialog(null, "Poin harus kelipatan 100 !",
                        "Failure", JOptionPane.ERROR_MESSAGE);
            } else if (tanyaPoint > data.pulsa[pengguna][2]) {

                JOptionPane.showMessageDialog(null, "Poin Tidak Mencukupi !",
                        "Failure", JOptionPane.ERROR_MESSAGE);
            } else {
                cek = 1;
            }
        } while (cek == 0);

        int hasilPoint = penukaranPoint(data.pulsa[pengguna][2], tanyaPoint, data.pulsa[pengguna][2] - tanyaPoint);

        data.pulsa[pengguna][0] += hasilPoint;

        JOptionPane.showMessageDialog(null, "Penukaran Berhasil ! ");
    }

    static void inputFeedback(User data, int pengguna) {

        String caption = JOptionPane.showInputDialog(null,
                "Hai, " + data.user[pengguna][2]
                + ". \nSetiap masukkan dari anda sangat berharga bagi kami untuk meningkatkan pelayanan kami"
                + "\n\nFeedback : ");

        Feedback newNode = new Feedback();
        newNode.caption = "\nName : " + data.user[pengguna][2]
                + "\nDate : " + getDate()
                + "\nCaption : \n"
                + caption;
        if (head == null) {
            head = tail = newNode;
        } else {
            //Addfirst
            newNode.next = head;
            head.prev = newNode;
            head = newNode;
        }

        JOptionPane.showMessageDialog(null, "Terimakasih atas masukkan anda !");
    }

    static void printFeedback(int pilihan) {
        if (pilihan == 1) {
            Feedback current = head;
            while (current != null) {
                System.out.println(current.caption);
                System.out.println("");
                System.out.println("==========================================");
                current = current.next;
            }
        } else {
            Feedback current = tail;
            while (current != null) {
                System.out.println(current.caption);
                System.out.println("");
                System.out.println("==========================================");
                current = current.prev;
            }
        }
    }

    //Menampilkan menu untuk admin
    static int menuAdmin() {
        int pilihanAdmin;

        pilihanAdmin = Integer.parseInt(JOptionPane.showInputDialog(null,
                "Menu Admin : "
                + "\n1. Tampilkan data user"
                + "\n2. Tampilkan Feedback"
                + "\n3. Lihat Transaksi"
                + "\n4. Exit"));
        return pilihanAdmin;
    }

    public static void main(String[] args) {

        User data = new User();
        int pilihan1;
        int pilihan2;
        int pengguna;
        int cek;
        int confirm;
        JOptionPane.showMessageDialog(null, "Selamat Datang !");
        do {
            pilihan1 = Integer.parseInt(JOptionPane.showInputDialog(null,
                    "Anda akan login sebagai ? "
                    + "\n1. User"
                    + "\n2. Admin"
                    + "\n3. Exit"));

            switch (pilihan1) {

                //Login sebagai user
                case 1:

                    do {
                        cek = loginUser(1, data);
                    } while (cek == 0);

                    pengguna = userArrayLocation(data);
                    //menu
                    do {
                        pilihan2 = menuUser(data, pengguna);
                        switch (pilihan2) {
                            case 1:
                                isiPulsa(data, pengguna);
                                break;

                            case 2:
                                beliQuota(data, pengguna);
                                break;

                            case 3:
                                menuPoint(data, pengguna);
                                break;
                            case 4:
                                profilUser(data, pengguna);
                                break;
                            case 5:
                                inputFeedback(data, pengguna);
                                break;
                            case 6:
                                confirm = JOptionPane.showConfirmDialog(null, "Anda akan Log Out ? ",
                                        "Confirm Dialog",
                                        JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE);

                                if (confirm == 0) {
                                    JOptionPane.showMessageDialog(null, "Berhasil Logout !");
                                    pilihan2 = 6;
                                } else {
                                    pilihan2 = -1;
                                }
                        }
                        if (pilihan2 > 6) {
                            JOptionPane.showMessageDialog(null, "Menu Tidak Tersedia !",
                                    "Failure", JOptionPane.ERROR_MESSAGE);
                        }

                    } while (pilihan2 != 6);
                    break;

                //Login sebgai admin
                case 2:
                    //Cek validitas

                    int pilihan3;
                    do {
                        cek = loginUser(2, data);
                    } while (cek == 0);

                    do {
                        pilihan2 = menuAdmin();
                        switch (pilihan2) {
                            case 1:
                                lihatData(data);
                                break;
                            case 2:

                                do {
                                    pilihan3 = Integer.parseInt(JOptionPane.showInputDialog(null,
                                            "\n1. Urut dari feedback terbaru"
                                            + "\n2. Urut dari feedback terlama"
                                            + "\n3. Exit"));

                                    if (pilihan3 < 3 && pilihan3 > 0) {
                                        printFeedback(pilihan3);
                                    }

                                } while (pilihan3 != 3);
                            case 3:
                                break;
                            case 4:
                                confirm = JOptionPane.showConfirmDialog(null, "Anda akan Log Out ? ",
                                        "Confirm Dialog",
                                        JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE);

                                if (confirm == 0) {
                                    JOptionPane.showMessageDialog(null, "Berhasil Logout !");
                                    pilihan2 = 4;
                                } else {
                                    pilihan2 = -1;
                                }
                        }
                        if (pilihan2 > 4) {
                            JOptionPane.showMessageDialog(null, "Menu Tidak Tersedia !",
                                    "Failure", JOptionPane.ERROR_MESSAGE);
                        }
                    } while (pilihan2 != 4);
                    break;
            }
            if (pilihan1 == 3) {
                JOptionPane.showMessageDialog(null, "Menutup aplikasi...");
            }
        } while (pilihan1 != 3);
    }
}
