package com.alkemy.icons.icons.services.implem;


import com.alkemy.icons.icons.dto.ContinenteDTO;
import com.alkemy.icons.icons.entity.ContinenteEntity;
import com.alkemy.icons.icons.mapper.ContinenteMapper;
import com.alkemy.icons.icons.repository.ContinenteRepository;
import com.alkemy.icons.icons.services.ContinenteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ContinenteServiceImpl implements ContinenteService {

    @Autowired
    private ContinenteMapper continenteMapper;

    @Autowired
    private ContinenteRepository continenteRepository;


    //metodo para guardar
    //se llama dto porque va a haber entidades y dtos
    public ContinenteDTO save(ContinenteDTO dto) {


        ContinenteEntity entity = continenteMapper.continenteDTO2Entity(dto); //se convierte en entity
        //guardar continente
        ContinenteEntity entitySaved = continenteRepository.save(entity); //se guarda
        ContinenteDTO result = continenteMapper.continenteEntity2DTO(entitySaved); //la entidad guardada se convierte a dto
        return result; //devuelvo
        /*System.out.println("GUARDAR CONTINENTE");
        //devolvemos el mismo dto que llego al servicio para probar que el servicio funciona
        return dto;*/
    }


    public List<ContinenteDTO> getAllContinentes() {
        List<ContinenteEntity> entities = continenteRepository.findAll();
        List<ContinenteDTO> result = continenteMapper.continenteEntityList2DTOList(entities);
        return result;
    }
}
