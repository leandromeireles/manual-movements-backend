package com.api.movements.repository;

import com.api.movements.entity.MovimentoManual;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface MovimentoManualRepository extends JpaRepository<MovimentoManual, Long> {

    @Query("SELECT MAX(m.numeroLancamento) FROM MovimentoManual m WHERE m.mes = :mes AND m.ano = :ano")
    Optional<Integer> findMaxNumeroLancamentoByMesAndAno(@Param("mes") Integer mes, @Param("ano") Integer ano);
}