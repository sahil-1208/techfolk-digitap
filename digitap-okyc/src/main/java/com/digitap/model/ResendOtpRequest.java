package com.digitap.model;

import lombok.Data;

@Data
public class ResendOtpRequest {

    private String uniqueId;
    private String uId;
    private String transactionId;
    private String fwdp;

}
