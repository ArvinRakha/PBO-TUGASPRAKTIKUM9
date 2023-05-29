/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.praktikum9tugas;

/**
 *
 * @author USER
 */
import java.util.ArrayList;
import java.util.List;

public class ponsel {
    private double pulsa;
    private boolean isMati;
    private final List<Contact> contacts;

    public ponsel() {
        pulsa = 0;
        isMati = false;
        contacts = new ArrayList<>();
    }

    public void topUpPulsa(double amount) {
        if (!isMati) {
            pulsa += amount;
            System.out.println("Top up berhasil. Pulsa sekarang: " + pulsa);
        } else {
            System.out.println("Ponsel mati. Tidak dapat melakukan top up.");
        }
    }

    public void lihatSisaPulsa() {
        if (!isMati) {
            System.out.println("Sisa pulsa: " + pulsa);
        } else {
            System.out.println("Ponsel mati. Tidak dapat melihat sisa pulsa.");
        }
    }

    public void tambahkanKontak(String nama, String nomor) {
        if (!isMati) {
            Contact contact = new Contact(nama, nomor);
            contacts.add(contact);
            System.out.println("Kontak " + nama + " berhasil ditambahkan.");
        } else {
            System.out.println("Ponsel mati. Tidak dapat menambahkan kontak.");
        }
    }

    public void lihatSemuaKontak() {
        if (!isMati) {
            if (contacts.isEmpty()) {
                System.out.println("Tidak ada kontak yang tersimpan.");
            } else {
                System.out.println("Daftar Kontak:");
                for (Contact contact : contacts) {
                    System.out.println(contact.getNama() + ": " + contact.getNomor());
                }
            }
        } else {
            System.out.println("Ponsel mati. Tidak dapat melihat kontak.");
        }
    }

    public void cariKontak(String nama) {
        if (!isMati) {
            boolean found = false;
            for (Contact contact : contacts) {
                if (contact.getNama().equalsIgnoreCase(nama)) {
                    System.out.println("Kontak ditemukan:");
                    System.out.println(contact.getNama() + ": " + contact.getNomor());
                    found = true;
                    break;
                }
            }
            if (!found) {
                System.out.println("Kontak dengan nama " + nama + " tidak ditemukan.");
            }
        } else {
            System.out.println("Ponsel mati. Tidak dapat mencari kontak.");
        }
    }

    public void matikanPonsel() {
        isMati = true;
        System.out.println("Ponsel dimatikan.");
    }

    public void hidupkanPonsel() {
        isMati = false;
        System.out.println("Ponsel dihidupkan.");
    }

    public static void main(String[] args) {
        ponsel mobilePhone = new ponsel();

        mobilePhone.tambahkanKontak("Rakha", "123456789");
        mobilePhone.tambahkanKontak("Jojo", "987654321");
        mobilePhone.tambahkanKontak("Liansyah", "456789123");

        mobilePhone.lihatSemuaKontak();
        mobilePhone.lihatSisaPulsa();

        mobilePhone.topUpPulsa(50.0);
        mobilePhone.lihatSisaPulsa();

        mobilePhone.cariKontak("Rakha");
        mobilePhone.matikanPonsel();
        mobilePhone.lihatSemuaKontak();
        mobilePhone.lihatSisaPulsa();
        mobilePhone.topUpPulsa(25.0);
        mobilePhone.hidupkanPonsel();
        mobilePhone.lihatSisaPulsa();
        mobilePhone.cariKontak("Liansyah");
}
}

class Contact {
private final String nama;
private final String nomor;
      public Contact(String nama, String nomor) {
    this.nama = nama;
    this.nomor = nomor;
}

public String getNama() {
    return nama;
}

public String getNomor() {
    return nomor;
}
}
  

