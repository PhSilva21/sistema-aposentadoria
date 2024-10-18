package com.bandeira.sistema_aposentadoria.application.gateways;


import com.bandeira.sistema_aposentadoria.application.usecases.SendRequestConfirmationEmail;
import com.bandeira.sistema_aposentadoria.domain.model.User;
import com.bandeira.sistema_aposentadoria.infra.dto.ApplyingForBenefitsDTO;
import com.bandeira.sistema_aposentadoria.infra.feign.UserFeign;
import com.bandeira.sistema_aposentadoria.infra.persistence.Benefit;
import com.bandeira.sistema_aposentadoria.infra.persistence.BenefitRepository;
import jakarta.mail.MessagingException;

import java.io.UnsupportedEncodingException;

public interface BenefitGateway {


    void applyingForBenefits(ApplyingForBenefitsDTO applyingForBenefitsDTO) throws MessagingException, UnsupportedEncodingException;

    void findBenefitByCpf(String cpf);

    User findUserByCpf(String cpf);
}
