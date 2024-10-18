package com.bandeira.sistema_aposentadoria.application.usecases;

import com.bandeira.sistema_aposentadoria.application.gateways.BenefitGateway;
import com.bandeira.sistema_aposentadoria.infra.dto.ApplyingForBenefitsDTO;
import jakarta.mail.MessagingException;

import java.io.UnsupportedEncodingException;

public class ApplyingForBenefits {

    private final BenefitGateway benefitGateway;

    public ApplyingForBenefits(BenefitGateway benefitGateway) {
        this.benefitGateway = benefitGateway;
    }

    public void applyingForBenefits(ApplyingForBenefitsDTO applyingForBenefits) throws MessagingException, UnsupportedEncodingException {
        benefitGateway.applyingForBenefits(applyingForBenefits);
    }
}
