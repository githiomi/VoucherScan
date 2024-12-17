package com.dhosio.voucherscan.services.impl;

import com.dhosio.voucherscan.services.VoucherService;
import org.springframework.stereotype.Service;

import java.util.Random;

@Service
public class VoucherServiceImpl implements VoucherService {

    @Override
    public Integer redeemVoucher(String voucherId) {
        System.out.println("Redeeming voucher number: " + voucherId);
        return new Random().nextInt(6);
    }
}
