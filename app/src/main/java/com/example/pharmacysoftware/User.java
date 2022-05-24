package com.example.pharmacysoftware;

public class User {

        public String fullName, email, number, password, conformPassword;

        public User(){

        }

        public User(String fullName, String email, String number, String password, String conformPassword) {
            this.fullName=fullName;
            this.email=email;
            this.number=number;
            this.password=password;
            this.conformPassword=conformPassword;

        }
}
