package lk.exame.test.dao;


import org.springframework.data.repository.CrudRepository;

import lk.exame.test.entity.ExameDetailsEntity;

public interface ExameDetailDAO extends CrudRepository<ExameDetailsEntity, Integer>{

}
