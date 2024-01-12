package com.digitap.model;

import lombok.Data;

@Data
public class SubmitOtpRequest {

    private String shareCode;
    private String transactionId;
    private String otp;
    private String fwdp;
    private String codeVerifier;
    private Boolean validateXml;
}
