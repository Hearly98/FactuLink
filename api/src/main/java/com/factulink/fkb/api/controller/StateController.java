package com.factulink.fkb.api.controller;

import com.factulink.fkb.api.service.StateService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/states")
@AllArgsConstructor
public class StateController {
    private final StateService stateService;

    @GetMapping()
    public ResponseEntity<Object> getAllStates(){
        return stateService.getStates();
    }
}
