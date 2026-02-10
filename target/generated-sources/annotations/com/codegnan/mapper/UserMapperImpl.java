package com.codegnan.mapper;

import com.codegnan.dto.UserDto;
import com.codegnan.model.User;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2026-02-10T06:51:16+0530",
    comments = "version: 1.5.5.Final, compiler: Eclipse JDT (IDE) 3.44.0.v20251118-1623, environment: Java 25.0.1 (Eclipse Adoptium)"
)
@Component
public class UserMapperImpl implements UserMapper {

    @Override
    public UserDto toDto(User user) {
        if ( user == null ) {
            return null;
        }

        UserDto userDto = new UserDto();

        userDto.setFname( user.getFirstName() );
        userDto.setLname( user.getLastName() );
        userDto.setEmailAddress( user.getEmail() );
        userDto.setUserId( user.getUserId() );
        userDto.setPhone( user.getPhone() );

        return userDto;
    }

    @Override
    public User toEntity(UserDto userDto) {
        if ( userDto == null ) {
            return null;
        }

        User user = new User();

        user.setFirstName( userDto.getFname() );
        user.setLastName( userDto.getLname() );
        user.setEmail( userDto.getEmailAddress() );
        user.setUserId( userDto.getUserId() );
        user.setPhone( userDto.getPhone() );

        return user;
    }
}
