package com.github.diszexuf.personservice.mapper;

import com.github.diszexuf.person.dto.IndividualWriteDto;
import com.github.diszexuf.personservice.entity.Individual;
import com.github.diszexuf.personservice.entity.User;
import com.github.diszexuf.personservice.util.DateTimeUtil;
import lombok.Setter;
import org.mapstruct.*;
import org.springframework.beans.factory.annotation.Autowired;

import static org.mapstruct.InjectionStrategy.CONSTRUCTOR;
import static org.mapstruct.MappingConstants.ComponentModel.SPRING;

@Mapper(
        componentModel = SPRING,
        injectionStrategy = CONSTRUCTOR,
        uses = {
                AddressMapper.class
        }
)
@Setter(onMethod_ = @Autowired)
public abstract class UserMapper {

    protected DateTimeUtil dateTimeUtil;

    @Named("toUser")
    @Mapping(target = "active", constant = "true")
    @Mapping(target = "created", expression = "java(dateTimeUtil.now())")
    @Mapping(target = "updated", expression = "java(dateTimeUtil.now())")
    @Mapping(target = "address", source = ".", qualifiedByName = "toAddress")
    public abstract User to(IndividualWriteDto dto);

    @BeanMapping(ignoreByDefault = true)
    @Mapping(target = "updated", expression = "java(dateTimeUtil.now())")
    @Mapping(target = "firstName", source = "firstName")
    @Mapping(target = "lastName", source = "lastName")
    @Mapping(target = "address", expression = "java(addressMapper.update(user, dto))")
    public abstract User update(
            @MappingTarget
            User user,
            IndividualWriteDto dto
    );

    public User update(Individual individual, IndividualWriteDto dto) {
        return update(individual.getUser(), dto);
    }
}
