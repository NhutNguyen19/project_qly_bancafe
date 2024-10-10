package project.duan.qlybancafe.mapper;

import org.mapstruct.Mapper;

import project.duan.qlybancafe.dto.request.RoleRequest;
import project.duan.qlybancafe.dto.response.RoleResponse;
import project.duan.qlybancafe.model.Role;

@Mapper(componentModel = "spring")
public interface RoleMapper {
    Role toRole(RoleRequest request);

    RoleResponse toRoleResponse(Role role);
}
