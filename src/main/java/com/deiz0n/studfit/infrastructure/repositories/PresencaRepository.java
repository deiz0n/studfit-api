package com.deiz0n.studfit.infrastructure.repositories;

import com.deiz0n.studfit.domain.dtos.PresencaDTO;
import com.deiz0n.studfit.domain.entites.Presenca;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface PresencaRepository extends JpaRepository<Presenca, UUID> {

    Optional<Presenca> getFirstByData(LocalDate data);
    @Query("SELECT p FROM tb_presenca p WHERE p.aluno.id = :id ORDER BY p.data DESC")
    List<Presenca> getLastTwo(UUID id);

    @Query("SELECT NEW " +
            "com.deiz0n.studfit.domain.dtos.PresencaDTO(p.id, p.data, p.presente, " +
            "NEW com.deiz0n.studfit.domain.dtos.AlunoEfetivadoDTO(a.id, a.nome, null)) " +
            "FROM tb_presenca p JOIN tb_aluno a ON p.aluno.id = a.id " +
            "AND p.usuario IS NOT NULL " +
            "AND p.data = :data"
    )
    List<PresencaDTO> buscarPresencaPorData(LocalDate data);

    @Query("SELECT NEW " +
            "com.deiz0n.studfit.domain.dtos.PresencaDTO(p.id, p.data, p.presente, " +
            "NEW com.deiz0n.studfit.domain.dtos.AlunoEfetivadoDTO(a.id, a.nome, null)) " +
            "FROM tb_presenca p JOIN tb_aluno a ON p.aluno.id = a.id " +
            "AND p.usuario IS NOT NULL"
    )
    List<PresencaDTO> buscarPresencas();

}
