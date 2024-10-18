package com.bandeira.sistema_aposentadoria.infra.gateways;

import com.bandeira.sistema_aposentadoria.application.gateways.BenefitGateway;
import com.bandeira.sistema_aposentadoria.application.usecases.SendRequestConfirmationEmail;
import com.bandeira.sistema_aposentadoria.domain.model.User;
import com.bandeira.sistema_aposentadoria.domain.unums.StatusBenefits;
import com.bandeira.sistema_aposentadoria.infra.dto.ApplyingForBenefitsDTO;
import com.bandeira.sistema_aposentadoria.infra.exceptions.BenefitAlreadyExists;
import com.bandeira.sistema_aposentadoria.infra.exceptions.UserNotFoundException;
import com.bandeira.sistema_aposentadoria.infra.feign.UserFeign;
import com.bandeira.sistema_aposentadoria.infra.persistence.Benefit;
import com.bandeira.sistema_aposentadoria.infra.persistence.BenefitRepository;
import jakarta.mail.MessagingException;
import org.springframework.stereotype.Service;

import java.io.UnsupportedEncodingException;
import java.time.LocalDate;
import java.util.UUID;

@Service
public class BenefitRepositoryGateway implements BenefitGateway {

    private final SendRequestConfirmationEmail sendRequestConfirmationEmail;

    private final BenefitRepository benefitRepository;

    private final UserFeign userFeign;

    public BenefitRepositoryGateway(SendRequestConfirmationEmail sendRequestConfirmationEmail
            , BenefitRepository benefitRepository, UserFeign userFeign) {
        this.sendRequestConfirmationEmail = sendRequestConfirmationEmail;
        this.benefitRepository = benefitRepository;
        this.userFeign = userFeign;
    }

    @Override
    public void applyingForBenefits(ApplyingForBenefitsDTO applyingForBenefitsDTO) throws MessagingException, UnsupportedEncodingException {
        var user = findUserByCpf(applyingForBenefitsDTO.cpf());
        findBenefitByCpf(applyingForBenefitsDTO.cpf());

        Benefit benefit = new Benefit(
                UUID.randomUUID(),
                applyingForBenefitsDTO.name(),
                applyingForBenefitsDTO.cpf(),
                applyingForBenefitsDTO.organResponsible(),
                applyingForBenefitsDTO.organShipper(),
                LocalDate.now(),
                StatusBenefits.UNDER_REVIEW
        );

        benefitRepository.save(benefit);

        sendRequestConfirmationEmail.sendRequestConfirmationEmail(user);
    }

    @Override
    public void findBenefitByCpf(String cpf){
        var benefit = benefitRepository.findByCpf(cpf);
        if(benefit != null){
            throw new BenefitAlreadyExists();
        }
    }

    @Override
    public User findUserByCpf(String cpf){
        var user = userFeign.findByCpf(cpf);
        if(user == null){
            throw new UserNotFoundException();
        }
        return user;
    }
}
