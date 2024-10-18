package com.bandeira.sistema_aposentadoria.infra.controllers;

import com.bandeira.sistema_aposentadoria.application.usecases.ApplyingForBenefits;
import com.bandeira.sistema_aposentadoria.infra.dto.ApplyingForBenefitsDTO;
import jakarta.mail.MessagingException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.UnsupportedEncodingException;

@RestController
@RequestMapping("/api/v1/benefits")
public class BenefitController {

    private final ApplyingForBenefits applyingForBenefits;


    public BenefitController(ApplyingForBenefits applyingForBenefits) {
        this.applyingForBenefits = applyingForBenefits;
    }


    @PostMapping
    public ResponseEntity<Void> applyingForBenefits(@RequestBody ApplyingForBenefitsDTO request) throws MessagingException, UnsupportedEncodingException {
        applyingForBenefits.applyingForBenefits(request);
        return ResponseEntity.ok().build();
    }


}
