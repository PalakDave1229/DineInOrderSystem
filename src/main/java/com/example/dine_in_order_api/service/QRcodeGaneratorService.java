package com.example.dine_in_order_api.service;

import com.google.zxing.WriterException;

import java.io.IOException;

public interface QRcodeGaneratorService {
    public byte[] ganerateQR(String url) throws IOException, WriterException;
}
