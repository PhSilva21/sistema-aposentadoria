package com.bandeira.sistema_aposentadoria.application.usecases;

import com.bandeira.sistema_aposentadoria.application.gateways.PensionSimulationGateway;

public class MaleSimulationByAgeAndContributionTime {

    private final PensionSimulationGateway pensionSimulationGateway;

    public MaleSimulationByAgeAndContributionTime(PensionSimulationGateway pensionSimulationGateway) {
        this.pensionSimulationGateway = pensionSimulationGateway;
    }

    public String doMaleSimulationByAgeAndContributionTime(Long id){
        return pensionSimulationGateway.doMaleSimulationByAgeAndContributionTime(id);
    }
}
