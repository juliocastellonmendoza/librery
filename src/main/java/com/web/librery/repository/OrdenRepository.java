package com.web.librery.repository;

import com.web.librery.domain.Orden;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface OrdenRepository extends JpaRepository<Orden, Long> {

}
