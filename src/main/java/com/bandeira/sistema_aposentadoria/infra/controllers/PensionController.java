package com.bandeira.sistema_aposentadoria.infra.controllers;

import com.bandeira.sistema_aposentadoria.application.usecases.*;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/api/v1/pension")
@RequiredArgsConstructor
public class PensionController {

    private final MaleAgeSimulation maleAgeSimulation;

    private final MaleSimulationByAgeAndContributionTime maleSimulationByAgeAndContributionTime;

    private final MaleSimulationForContributionTimeAndPoints maleSimulationForContributionTimeAndPoints;

    private final FemaleAgeSimulation femaleAgeSimulation;

    private final FemaleSimulationByAgeAndContributionTime femaleSimulationByAgeAndContributionTime;

    private  final FemaleSimulationForContributionTimeAndPoints femaleSimulationForContributionTimeAndPoints;




    @GetMapping("/male/age-simulation")
    public ResponseEntity<String> doMaleAgeSimulation(@RequestBody Long id) {
        var response = maleAgeSimulation.doMaleAgeSimulation(id);
        return ResponseEntity.ok().body(response);
    }


    @GetMapping("/male/contribution-points-simulation")
    public ResponseEntity<String> doMaleSimulationForContributionTimeAndPoints(@RequestBody Long id) {
        var response = maleSimulationForContributionTimeAndPoints
                .doMaleSimulationForContributionTimeAndPoints(id);
        return ResponseEntity.ok().body(response);
    }


    @GetMapping("/male/age-contribution-simulation")
    public ResponseEntity<String> doMaleSimulationByAgeAndContributionTime(@RequestBody Long id) {
        var response = maleSimulationByAgeAndContributionTime
                .doMaleSimulationByAgeAndContributionTime(id);
        return ResponseEntity.ok().body(response);
    }


    @GetMapping("/female/age-simulation")
    public ResponseEntity<String> doFemaleAgeSimulation(@RequestBody Long id) {
        var response = femaleAgeSimulation.doFemaleAgeSimulation(id);
        return ResponseEntity.ok().body(response);
    }


    @GetMapping("/female/contribution-points-simulation")
    public ResponseEntity<String> doFemaleSimulationForContributionTimeAndPoints(@RequestBody Long id) {
        var response = femaleSimulationForContributionTimeAndPoints
                .doFemaleSimulationForContributionTimeAndPoints(id);
        return ResponseEntity.ok().body(response);
    }


    @GetMapping("/female/age-contribution-simulation")
    public ResponseEntity<String> doFemaleSimulationByAgeAndContributionTime(@RequestBody Long id){
        var response = femaleSimulationByAgeAndContributionTime.doFemaleSimulationByAgeAndContributionTime(id);
        return ResponseEntity.ok().body(response);
    }

}
