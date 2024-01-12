package com.digitap.controller;

import com.digitap.model.*;
import com.digitap.service.DigitapService;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
@RequestMapping("/kyc")
public class DigitapController {


    private final DigitapService digitapService;
    private final ObjectMapper objectMapper;

    @PostMapping(value = "/initiatekyc", consumes = "application/json", produces = "application/json")
    public ResponseEntity<InitiateKycResponse> initiateKyc(@RequestBody String requestBody) {
        try {
            InitiateKycRequest initiateKycRequest = objectMapper.readValue(requestBody, InitiateKycRequest.class);
            InitiateKycResponse response = digitapService.initiateKyc(initiateKycRequest.getUniqueId(), initiateKycRequest.getUid());
            return ResponseEntity.ok(response);
        } catch (Exception e) {
            return ResponseEntity.badRequest().build();
        }


    }

//    @PostMapping("/submitOtp")
//    public ResponseEntity<SubmitOtpResponse> submitOtp(@RequestBody SubmitOtpRequest submitOtpRequest) {
//        SubmitOtpResponse response = digitapService.submitOtp(submitOtpRequest.getShareCode(), submitOtpRequest.getTransactionId(), submitOtpRequest.getOtp(),
//                submitOtpRequest.getFwdp(), submitOtpRequest.getCodeVerifier(), submitOtpRequest.getValidateXml());
//        return ResponseEntity.ok(response);
//    }
//
//    @PostMapping("/resendOtp")
//    public ResponseEntity<ResendOtpResponse> resendOtpResponseResponseEntity(@RequestBody ResendOtpRequest resendOtpRequest) {
//        ResendOtpResponse response = digitapService.resendOtp(resendOtpRequest.getUniqueId(), resendOtpRequest.getUId(), resendOtpRequest.getTransactionId(), resendOtpRequest.getFwdp());
//        return ResponseEntity.ok(response);
//    }
}
