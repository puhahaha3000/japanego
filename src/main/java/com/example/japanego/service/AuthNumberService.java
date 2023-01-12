package com.example.japanego.service;

public interface AuthNumberService {

    void publishAuthNo(int memberNo, String email);

    boolean auth(int memberNo, String no);

    int checkExpired();
}
