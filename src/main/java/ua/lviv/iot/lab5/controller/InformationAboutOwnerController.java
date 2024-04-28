package ua.lviv.iot.lab5.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.CollectionModel;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ua.lviv.iot.lab5.domain.InformationAboutOwner;
import ua.lviv.iot.lab5.dto.InformationAboutOwnerDto;
import ua.lviv.iot.lab5.dto.assembler.InformationAboutOwnerDtoAssembler;
import ua.lviv.iot.lab5.service.InformationAboutOwnerService;

import java.util.List;

@RestController
@RequestMapping("/api/information-about-onwer")
public class InformationAboutOwnerController {
    private final InformationAboutOwnerService informationAboutOwnerService;
    private final InformationAboutOwnerDtoAssembler informationAboutOwnerDtoAssembler;

    @Autowired
    public InformationAboutOwnerController(InformationAboutOwnerService informationAboutOwnerService, InformationAboutOwnerDtoAssembler informationAboutOwnerDtoAssembler) {
        this.informationAboutOwnerService = informationAboutOwnerService;
        this.informationAboutOwnerDtoAssembler = informationAboutOwnerDtoAssembler;
    }

    @GetMapping(value = "/{informationAboutOwnerId}")
    public ResponseEntity<InformationAboutOwnerDto> getInformationAboutOwner(@PathVariable("informationAboutOwnerId") Integer informationAboutOwnerId) {
        InformationAboutOwner informationAboutOwner = informationAboutOwnerService.findById(informationAboutOwnerId);
        InformationAboutOwnerDto informationAboutOwnerDto = informationAboutOwnerDtoAssembler.toModel(informationAboutOwner);
        return new ResponseEntity<>(informationAboutOwnerDto, HttpStatus.OK);
    }

    @GetMapping(value = "")
    public ResponseEntity<CollectionModel<InformationAboutOwnerDto>> getAllInformationAboutOnwers() {
        List<InformationAboutOwner> informationAboutOwners = informationAboutOwnerService.findAll();
        CollectionModel<InformationAboutOwnerDto> informationAboutOwnerDtos = informationAboutOwnerDtoAssembler.toCollectionModel(informationAboutOwners);
        return new ResponseEntity<>(informationAboutOwnerDtos, HttpStatus.OK);
    }

    @PostMapping(value = "")
    public ResponseEntity<InformationAboutOwnerDto> addInformationAboutOwner(@RequestBody InformationAboutOwner informationAboutOwner) {
        InformationAboutOwner newInformationAboutOwner = informationAboutOwnerService.create(informationAboutOwner);
        InformationAboutOwnerDto informationAboutOwnerDto = informationAboutOwnerDtoAssembler.toModel(newInformationAboutOwner);
        return new ResponseEntity<>(informationAboutOwnerDto, HttpStatus.CREATED);
    }

    @PutMapping(value = "/{informationAboutOwnerId}")
    public ResponseEntity<?> updateInformationAboutOwner(@RequestBody InformationAboutOwner informationAboutOwner, @PathVariable("informationAboutOwnerId") Integer informationAboutOwnerId) {
        informationAboutOwnerService.update(informationAboutOwnerId, informationAboutOwner);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping(value = "/{informationAboutOwnerId}")
    public ResponseEntity<?> deleteInformationAboutOwner(@PathVariable("informationAboutOwnerId") Integer informationAboutOwnerId) {
        informationAboutOwnerService.delete(informationAboutOwnerId);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
