package com.jose1593.repository;

import java.util.List;

import org.springframework.data.repository.Repository;

import com.jose1593.entity.JBoard;

public interface BoardRepository extends Repository<JBoard, Long> {

	void save(JBoard jBoard);

	List<JBoard> findAll();

	JBoard findByBno(int bno);

}
