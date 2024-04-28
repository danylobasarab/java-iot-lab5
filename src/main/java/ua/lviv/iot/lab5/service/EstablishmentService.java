package ua.lviv.iot.lab5.service;

import ua.lviv.iot.lab5.domain.City;
import ua.lviv.iot.lab5.domain.Establishment;
import ua.lviv.iot.lab5.domain.ReviewOfEstablishment;

import java.util.List;
import java.util.Optional;

public interface EstablishmentService extends GeneralService<Establishment, Integer> {
    List<ReviewOfEstablishment> findReviewByEstablishmentId(Integer id);
}
