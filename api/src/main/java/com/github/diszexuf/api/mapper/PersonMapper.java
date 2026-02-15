package com.github.diszexuf.api.mapper;

import com.github.diszexuf.individual.dto.IndividualDto;
import com.github.diszexuf.individual.dto.IndividualWriteDto;
import com.github.diszexuf.individual.dto.IndividualWriteResponseDto;
import org.mapstruct.Mapper;

import static org.mapstruct.InjectionStrategy.CONSTRUCTOR;
import static org.mapstruct.MappingConstants.ComponentModel.SPRING;


@Mapper(componentModel = SPRING, injectionStrategy = CONSTRUCTOR)
public interface PersonMapper {

    com.github.diszexuf.person.dto.IndividualWriteDto from(IndividualWriteDto dto);

    com.github.diszexuf.person.dto.IndividualDto from(IndividualDto dto);

    IndividualDto from(com.github.diszexuf.person.dto.IndividualDto dto);

    IndividualWriteResponseDto from(com.github.diszexuf.person.dto.IndividualWriteResponseDto dto);
}
