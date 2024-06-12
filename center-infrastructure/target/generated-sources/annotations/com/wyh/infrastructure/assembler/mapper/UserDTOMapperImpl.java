package com.wyh.infrastructure.assembler.mapper;

import com.wyh.application.api.response.UserLoginResponseDTO;
import com.wyh.infrastructure.po.UserPO;
import javax.annotation.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-06-11T08:58:05+0800",
    comments = "version: 1.4.2.Final, compiler: javac, environment: Java 1.8.0_151 (Oracle Corporation)"
)
public class UserDTOMapperImpl implements UserDTOMapper {

    @Override
    public UserLoginResponseDTO toUserLoginResponseDTO(UserPO po) {
        if ( po == null ) {
            return null;
        }

        UserLoginResponseDTO userLoginResponseDTO = new UserLoginResponseDTO();

        userLoginResponseDTO.setUserId( po.getUserId() );

        return userLoginResponseDTO;
    }
}
