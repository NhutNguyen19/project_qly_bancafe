package project.duan.qlybancafe.service;

import java.util.List;

import org.springframework.stereotype.Service;

import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import project.duan.qlybancafe.dto.request.RoleRequest;
import project.duan.qlybancafe.dto.response.RoleResponse;
import project.duan.qlybancafe.mapper.RoleMapper;
import project.duan.qlybancafe.model.Role;
import project.duan.qlybancafe.repository.RoleRepository;

@Service
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class RoleService {
    RoleRepository roleRepository;
    RoleMapper roleMapper;

    public RoleResponse createRole(RoleRequest roleRequest) {
        Role role = roleMapper.toRole(roleRequest);
        roleRepository.save(role);
        return roleMapper.toRoleResponse(role);
    }

    public List<RoleResponse> getALl() {
        return roleRepository.findAll().stream().map(roleMapper::toRoleResponse).toList();
    }

    public void deleteRole(String roleId) {
        roleRepository.deleteById(roleId);
    }
}
