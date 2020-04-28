package com.hendro.androidx_java_fab_recyclerview_butter_knife;

public class Anggota {
    String nama, kelas, status;
    boolean teknologi, lain, kuliner,
            keuangan, ekonomi, arsitektur;

    public Anggota(String nama, String kelas, String status, boolean teknologi, boolean lain, boolean kuliner, boolean keuangan, boolean ekonomi, boolean arsitektur) {
        this.nama = nama;
        this.kelas = kelas;
        this.status = status;
        this.teknologi = teknologi;
        this.lain = lain;
        this.kuliner = kuliner;
        this.keuangan = keuangan;
        this.ekonomi = ekonomi;
        this.arsitektur = arsitektur;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getKelas() {
        return kelas;
    }

    public void setKelas(String kelas) {
        this.kelas = kelas;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public boolean isTeknologi() {
        return teknologi;
    }

    public void setTeknologi(boolean teknologi) {
        this.teknologi = teknologi;
    }

    public boolean isLain() {
        return lain;
    }

    public void setLain(boolean lain) {
        this.lain = lain;
    }

    public boolean isKuliner() {
        return kuliner;
    }

    public void setKuliner(boolean kuliner) {
        this.kuliner = kuliner;
    }

    public boolean isKeuangan() {
        return keuangan;
    }

    public void setKeuangan(boolean keuangan) {
        this.keuangan = keuangan;
    }

    public boolean isEkonomi() {
        return ekonomi;
    }

    public void setEkonomi(boolean ekonomi) {
        this.ekonomi = ekonomi;
    }

    public boolean isArsitektur() {
        return arsitektur;
    }

    public void setArsitektur(boolean arsitektur) {
        this.arsitektur = arsitektur;
    }
}
