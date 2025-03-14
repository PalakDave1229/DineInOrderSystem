package com.example.dine_in_order_api.service.serviceImpl;

import com.example.dine_in_order_api.service.QRcodeGaneratorService;
import com.example.dine_in_order_api.utility.QRcodeGanerator;
import com.google.zxing.WriterException;
import org.springframework.stereotype.Service;


import java.io.IOException;

@Service
public class QRcodeGaneratorServiceImpl implements QRcodeGaneratorService {
    @Override
    public byte[] ganerateQR(String url) throws IOException, WriterException {
        return QRcodeGanerator.ganerateQR(url,250,250);
    }
}
