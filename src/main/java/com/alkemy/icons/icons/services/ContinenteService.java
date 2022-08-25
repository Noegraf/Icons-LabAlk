package com.alkemy.icons.icons.services;


import com.alkemy.icons.icons.dto.ContinenteDTO;
import org.springframework.stereotype.Service;

@Service
public class ContinenteService {

    //metodo para guardar
    //se llama dto porque va a haber entidades y dtos
    public ContinenteDTO save(ContinenteDTO dto) {
        //TODO: guardar continente
        System.out.println("GUARDAR CONTINENTE");
        //devolvemos el mismo dto que llego al servicio para probar que el servicio funciona
        return dto;
    }
}
