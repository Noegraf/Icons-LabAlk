package com.alkemy.icons.icons.controller;


import com.alkemy.icons.icons.dto.ContinenteDTO;
import com.alkemy.icons.icons.services.ContinenteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

//Tipo de componente
@RestController
//Base de pack para acceder al control
@RequestMapping("continentes")
public class ContinentController {
    //decirle al servicio que save continente
    //la anotacion @Autowired hace que spring inicialice el servicio
    //entonces cuando spring inicialice va a poner aca dentro el continenteservicio y puedo hacer uso de este continente
    @Autowired
    private ContinenteService continenteService;

    /* endpoint para guardar continentes
    definir metodo, continente dto todavia no fue creado */
    // En responseEntity decimos que va a devolver el continente guardado
    //Como estoy guardando usamos el verbo post, se puede agregar un sub path para acceder ej: @PostMapping("/agregar")
    //una vez creado el dto importar la clase
    @PostMapping
    public ResponseEntity<ContinenteDTO> save(@RequestBody ContinenteDTO continente) {
        // TODO: decirle al servicio que save continente

        //definir variable, este continente guardado lo pone directamente en el body y responde con CREADO
        ContinenteDTO continenteGuardado = continenteService.save(continente);

        //201, continente guardado.
        return ResponseEntity.status(HttpStatus.CREATED).body(continenteGuardado);

    }

}
