package ua.lviv.iot.lab5.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import org.springframework.hateoas.RepresentationModel;
import org.springframework.hateoas.server.core.Relation;
import ua.lviv.iot.lab5.domain.Country;

@Builder
@Getter
@EqualsAndHashCode(callSuper = false)
@JsonInclude(JsonInclude.Include.NON_NULL)
@Relation(itemRelation = "city", collectionRelation = "cities")
public class CityDto extends RepresentationModel<CityDto> {
    private final Integer id;
    private final String name;
    private final String country;
}