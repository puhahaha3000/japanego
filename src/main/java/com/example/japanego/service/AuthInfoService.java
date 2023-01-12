package com.example.japanego.service;

public interface AuthInfoService {

    void publishAuthNo(int memberNo, String email);

    boolean auth(int memberNo, String no);

    int auth(String randomUrl);

    void checkExpired();

    void sendResetMail(int memberNo, String email);
}
