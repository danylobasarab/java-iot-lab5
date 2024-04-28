package ua.lviv.iot.lab5.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.CollectionModel;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ua.lviv.iot.lab5.domain.TypeOfEstablishment;
import ua.lviv.iot.lab5.dto.TypeOfEstablishmentDto;
import ua.lviv.iot.lab5.dto.assembler.TypeOfEstablishmentDtoAssembler;
import ua.lviv.iot.lab5.service.TypeOfEstablishmentService;

import java.util.List;

@RestController
@RequestMapping("/api/type-of-establishment")
public class TypeOfEstablishmentController {
    private final TypeOfEstablishmentService typeOfEstablishmentService;
    private final TypeOfEstablishmentDtoAssembler typeOfEstablishmentDtoAssembler;

    @Autowired
    public TypeOfEstablishmentController(TypeOfEstablishmentService typeOfEstablishmentService, TypeOfEstablishmentDtoAssembler typeOfEstablishmentDtoAssembler) {
        this.typeOfEstablishmentService = typeOfEstablishmentService;
        this.typeOfEstablishmentDtoAssembler = typeOfEstablishmentDtoAssembler;
    }

    @GetMapping(value = "/{typeOfEstablishmentId}")
    public ResponseEntity<TypeOfEstablishmentDto> getTypeOfEstablishment(@PathVariable("typeOfEstablishmentId") Integer typeOfEstablishmentId) {
        TypeOfEstablishment typeOfEstablishment = typeOfEstablishmentService.findById(typeOfEstablishmentId);
        TypeOfEstablishmentDto typeOfEstablishmentDto = typeOfEstablishmentDtoAssembler.toModel(typeOfEstablishment);
        return new ResponseEntity<>(typeOfEstablishmentDto, HttpStatus.OK);
    }

    @GetMapping(value = "")
    public ResponseEntity<CollectionModel<TypeOfEstablishmentDto>> getAllTypeOfEstablishments() {
        List<TypeOfEstablishment> typeOfEstablishments = typeOfEstablishmentService.findAll();
        CollectionModel<TypeOfEstablishmentDto> typeOfEstablishmentDtos = typeOfEstablishmentDtoAssembler.toCollectionModel(typeOfEstablishments);
        return new ResponseEntity<>(typeOfEstablishmentDtos, HttpStatus.OK);
    }

    @PostMapping(value = "")
    public ResponseEntity<TypeOfEstablishmentDto> addStreet(@RequestBody TypeOfEstablishment typeOfEstablishment) {
        TypeOfEstablishment newTypeOfEstablishment = typeOfEstablishmentService.create(typeOfEstablishment);
        TypeOfEstablishmentDto typeOfEstablishmentDto = typeOfEstablishmentDtoAssembler.toModel(newTypeOfEstablishment);
        return new ResponseEntity<>(typeOfEstablishmentDto, HttpStatus.CREATED);
    }

    @PutMapping(value = "/{typeOfEstablishmentId}")
    public ResponseEntity<?> updateTypeOfEstablishment(@RequestBody TypeOfEstablishment typeOfEstablishment, @PathVariable("typeOfEstablishmentId") Integer typeOfEstablishmentId) {
        typeOfEstablishmentService.update(typeOfEstablishmentId, typeOfEstablishment);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping(value = "/{typeOfEstablishmentId}")
    public ResponseEntity<?> deleteTypeOfEstablishment(@PathVariable("typeOfEstablishmentId") Integer streetId) {
        typeOfEstablishmentService.delete(streetId);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
