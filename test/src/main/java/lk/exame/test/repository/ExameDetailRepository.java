package lk.exame.test.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import lk.exame.test.entity.ExameDetailsEntity;

public interface ExameDetailRepository extends JpaRepository<ExameDetailsEntity, Integer>{

}
