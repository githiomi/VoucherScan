package com.dhosio.voucherscan.controllers;

import com.dhosio.voucherscan.models.ApiResponse;
import com.dhosio.voucherscan.services.interfaces.VoucherService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.util.UUID;

@RestController
@RequestMapping("/api/v1/voucher")
public class VoucherController {

    private final VoucherService voucherService;

    public VoucherController(VoucherService voucherService) {
        this.voucherService = voucherService;
    }

    @GetMapping("")
    public ResponseEntity<ApiResponse<UUID>> getVoucher() {
        return new ResponseEntity<>(new ApiResponse<>(UUID.randomUUID(), LocalDateTime.now(), true), HttpStatus.OK);
    }

    @GetMapping("/redeem/{voucherUUID}")
    public ResponseEntity<ApiResponse<Integer>> redeemVoucher(@PathVariable("voucherUUID") String voucherId) {
        /*
        Response options
        1. Valid
        2. Invalid
        3. Redeemed
        4. Expired
        5. Doesn't Exist
         */
        int response = this.voucherService.redeemVoucher(voucherId);

        return response == 0
                ? new ResponseEntity<>(new ApiResponse<>(response, LocalDateTime.now(), false), HttpStatus.NO_CONTENT)
                : new ResponseEntity<>(new ApiResponse<>(response, LocalDateTime.now(), true), HttpStatus.OK);
    }


}

