package com.dhosio.voucherscan.models;

import java.time.LocalDateTime;

public record ApiResponse<T>(
        T body,
        LocalDateTime dateTime,
        boolean isSuccessful
) {
}
