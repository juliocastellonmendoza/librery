package com.web.librery.service;

import com.web.librery.domain.DetalleOrden;
import com.web.librery.repository.DetalleOrdenRepository;
import org.springframework.stereotype.Service;

@Service
public class DetalleOrdenServiceImpl implements DetalleOrdenService{

    private DetalleOrdenRepository detalleOrdenRepository;

    public DetalleOrdenServiceImpl(DetalleOrdenRepository detalleOrdenRepository){
        this.detalleOrdenRepository = detalleOrdenRepository;
    }

    @Override
    public DetalleOrden save(DetalleOrden detalleOrden) {
        return detalleOrdenRepository.save(detalleOrden);
    }
}
