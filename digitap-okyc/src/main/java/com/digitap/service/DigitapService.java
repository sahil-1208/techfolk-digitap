package com.digitap.service;

import com.digitap.model.*;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;


@RequiredArgsConstructor
@Service
public class DigitapService {

    private final RestTemplate restTemplate;


    public InitiateKycResponse initiateKyc(String uniqueId, String uid) {

        String url = "https://svcdemo.digitap.work/ent/v3/kyc/intiate-kyc-auto";

        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.setContentType(MediaType.APPLICATION_JSON);
        httpHeaders.set("Authorization","NDE0ODc1MTU6WVVvTFJYaHVjSEg2ZEtYQ3FpOEVtaGFxdDZkZ0FMdks=");

        InitiateKycRequest initiateKycRequest = new InitiateKycRequest();
        initiateKycRequest.setUniqueId(uniqueId);
        initiateKycRequest.setUid(uid);

        HttpEntity<InitiateKycRequest> requestHttpEntity = new HttpEntity<>(initiateKycRequest, httpHeaders);
        ResponseEntity<InitiateKycResponse> responseEntity =
                restTemplate.postForEntity(url, requestHttpEntity, InitiateKycResponse.class);

        return responseEntity.getBody();
    }


//    public SubmitOtpResponse submitOtp(String shareCode, String transactionId, String otp, String fwdp, String codeVerifier
//            , Boolean validateXml) {
//        SubmitOtpRequest submitOtpRequest = new SubmitOtpRequest();
//        submitOtpRequest.setShareCode(shareCode);
//        submitOtpRequest.setTransactionId(transactionId);
//        submitOtpRequest.setOtp(otp);
//        submitOtpRequest.setFwdp(fwdp);
//        submitOtpRequest.setCodeVerifier(codeVerifier);
//        submitOtpRequest.setValidateXml(validateXml);
//        return digitapClient.submitOtp(submitOtpRequest);
//    }

//    public ResendOtpResponse resendOtp(String uniqueId, String uId, String transactionId, String fwdp) {
//
//        ResendOtpRequest resendOtpRequest = new ResendOtpRequest();
//        resendOtpRequest.setUniqueId(uniqueId);
//        resendOtpRequest.setUId(uId);
//        resendOtpRequest.setTransactionId(transactionId);
//        resendOtpRequest.setFwdp(fwdp);
//        return digitapClient.resendOtp(resendOtpRequest);
//    }

}
