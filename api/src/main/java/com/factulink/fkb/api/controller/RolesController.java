package com.factulink.fkb.api.controller;

import com.factulink.fkb.api.service.RolesService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/roles")
@AllArgsConstructor
public class RolesController {
    private final RolesService rolesService;

    @GetMapping()
    public ResponseEntity<Object> getAllRoles(){
        return rolesService.getRoles();
    }
}
