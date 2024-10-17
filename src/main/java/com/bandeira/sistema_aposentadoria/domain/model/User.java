package com.bandeira.sistema_aposentadoria.domain.model;

import com.bandeira.sistema_aposentadoria.domain.unums.Sex;
import com.bandeira.sistema_aposentadoria.infra.persistence.Benefit;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Getter
@Setter
public class User {

    private String id;

    private String cpf;

    private String name;

    private String email;

    private String password;

    private Integer age;

    private Sex sex;

    private Integer shortage;

    private Integer yearsContribution;

    private Integer monthsContribution;

    private Integer daysContribution;

    private Integer points;

    private List<Benefit> benefits = new ArrayList<>();
}
