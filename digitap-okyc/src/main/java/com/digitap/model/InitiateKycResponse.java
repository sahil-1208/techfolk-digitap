package com.digitap.model;

import lombok.Data;

@Data
public class InitiateKycResponse {

    private String transactionId;
    private String otp;
    private String fwdp;
    private String codeVerifier;
}
