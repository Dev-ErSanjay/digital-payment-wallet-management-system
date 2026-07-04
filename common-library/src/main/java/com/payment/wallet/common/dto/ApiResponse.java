package com.payment.wallet.common.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ApiResponse<T> {

    private String status;
    private String messsage;
    private T data;

    public static <T> ApiResponse<T> success(T data) {

        return ApiResponse.<T>builder()
                .status("SUCCESS")
                .messsage("Request processed successfully")
                .data(data)
                .build();
    }

    public static <T> ApiResponse<T> failure(String message) {

        return ApiResponse.<T>builder()
                .status("FAILED")
                .messsage(message)
                .build();
    }

}
