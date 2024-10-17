package com.bandeira.sistema_aposentadoria.application.gateways;

public interface PensionSimulationGateway {


    String doMaleAgeSimulation(Long id);

    String doMaleSimulationForContributionTimeAndPoints(Long id);

    String doMaleSimulationByAgeAndContributionTime(Long id);

    String doFemaleAgeSimulation(Long id);

    String doFemaleSimulationForContributionTimeAndPoints(Long id);

    String doFemaleSimulationByAgeAndContributionTime(Long id);
}
