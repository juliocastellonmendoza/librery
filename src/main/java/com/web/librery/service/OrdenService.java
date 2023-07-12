package com.web.librery.service;

import com.web.librery.domain.Orden;

import java.util.List;

public interface OrdenService {

    List<Orden> findAll();
    Orden save(Orden orden);

    String generarNumeroOrden();

}
