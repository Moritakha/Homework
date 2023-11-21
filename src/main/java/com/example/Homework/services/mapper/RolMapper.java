package com.example.Homework.services.mapper;

import com.example.Homework.domain.entities.Rol;
import com.example.Homework.dto.RolDTO;
import org.springframework.stereotype.Component;


@Component
public class RolMapper implements CustomMapper<RolDTO, Rol>{
        @Override
        public RolDTO toDto(Rol rol) {
            RolDTO rolDTO = new RolDTO();
            rolDTO.setId(rol.getId());
            rolDTO.setNombre(rol.getNombre());

            return rolDTO;
        }

        @Override
        public Rol toEntity(RolDTO rolDTO) {
            Rol rol = new Rol();
            rol.setId(rolDTO.getId());
            rol.setNombre(rolDTO.getNombre());

            return rol;
        }
}

