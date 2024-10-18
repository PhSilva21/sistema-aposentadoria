package com.bandeira.sistema_aposentadoria.application.gateways;

public interface PensionSimulationGateway {


    String doMaleAgeSimulation(String cpf);

    String doMaleSimulationForContributionTimeAndPoints(String cpf);

    String doMaleSimulationByAgeAndContributionTime(String cpf);

    String doFemaleAgeSimulation(String cpf);

    String doFemaleSimulationForContributionTimeAndPoints(String cpf);

    String doFemaleSimulationByAgeAndContributionTime(String cpf);
}
