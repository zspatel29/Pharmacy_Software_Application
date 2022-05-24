package com.example.pharmacysoftware;

public class DoctorModel {

    private String doctor_name;
    private String doctor_dest;
    private int doctor_rating;
    private int doctor_image;

    // Constructor
    public DoctorModel(String doctor_name, String doctor_dest, int doctor_rating, int doctor_image) {
        this.doctor_name = doctor_name;
        this.doctor_dest = doctor_dest;
        this.doctor_rating = doctor_rating;
        this.doctor_image = doctor_image;
    }

    // Getter and Setter
    public String getDoctor_name() {
        return doctor_name;
    }

    public void setDoctor_name(String doctor_name) {
        this.doctor_name = doctor_name;
    }

    public String getDoctor_dest() {
        return doctor_dest;
    }

    public void setDoctor_dest(String doctor_dest) {
        this.doctor_dest = doctor_dest;
    }

    public int getDoctor_rating() {
        return doctor_rating;
    }

    public void setDoctor_rating(int doctor_rating) {
        this.doctor_rating = doctor_rating;
    }

    public int getDoctor_image() {
        return doctor_image;
    }

    public void setDoctor_image(int doctor_image) {
        this.doctor_image = doctor_image;
    }
}

