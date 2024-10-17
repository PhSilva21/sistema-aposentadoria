package com.bandeira.sistema_aposentadoria.infra.persistence;

import com.bandeira.sistema_aposentadoria.domain.unums.StatusBenefits;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.UUID;

@Getter
@Setter
@Table(name = "tb_benefits")
@Entity
public class Benefit {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private UUID id;

    private String name;

    private String organResponsible;

    private String organShipper;

    private LocalDate date;

    private StatusBenefits statusBenefits;




    public Benefit(UUID id, String name, String organResponsible, String organShipper
            , LocalDate date) {
        this.id = id;
        this.name = name;
        this.organResponsible = organResponsible;
        this.organShipper = organShipper;
        this.date = date;
    }
}
