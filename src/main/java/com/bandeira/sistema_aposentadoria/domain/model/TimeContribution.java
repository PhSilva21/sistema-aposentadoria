package com.bandeira.sistema_aposentadoria.domain.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class TimeContribution {


    private Long id;

    private LocalDate date;

    private LocalDate timeContribution;

    private List<TimeContribution> timeContributions = new ArrayList<>();

}
