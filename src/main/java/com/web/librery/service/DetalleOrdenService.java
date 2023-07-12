package com.web.librery.service;

import com.web.librery.domain.DetalleOrden;
import org.springframework.stereotype.Service;

@Service
public interface DetalleOrdenService {
    DetalleOrden save(DetalleOrden detalleOrden);
}
