package project.duan.qlybancafe.controller;

import java.util.List;

import org.springframework.web.bind.annotation.*;

import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import project.duan.qlybancafe.dto.ApiResponse;
import project.duan.qlybancafe.dto.request.RoleRequest;
import project.duan.qlybancafe.dto.response.RoleResponse;
import project.duan.qlybancafe.service.RoleService;

@RestController
@RequiredArgsConstructor
@RequestMapping("/roles")
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@Slf4j
public class RoleController {
    RoleService roleService;

    @PostMapping()
    ApiResponse<RoleResponse> createRole(@RequestBody RoleRequest request) {
        return ApiResponse.<RoleResponse>builder()
                .result(roleService.createRole(request))
                .message("Successfully created role")
                .build();
    }

    @GetMapping()
    ApiResponse<List<RoleResponse>> getAll() {
        return ApiResponse.<List<RoleResponse>>builder()
                .result(roleService.getALl())
                .message("Successfully retrieved all roles")
                .build();
    }

    @DeleteMapping("/{id}")
    ApiResponse<RoleResponse> deleteRole(@PathVariable String id) {
        roleService.deleteRole(id);
        return ApiResponse.<RoleResponse>builder()
                .message("Successfully deleted role")
                .build();
    }
}
