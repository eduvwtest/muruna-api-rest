package com.muruna.apirest.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.muruna.apirest.constants.AppConstants;
import com.muruna.apirest.model.User;
import com.muruna.apirest.service.JwtUtilService;
import com.muruna.apirest.service.UserService;


@RestController
@RequestMapping(value = AppConstants.REQUEST_MAPPING)
@Tag(name = AppConstants.NAME_USER_CONTROLLER, description = AppConstants.DESCRIPTION_USER_CONTROLLER)
public class UserController {

    @Autowired
    private UserService service;

    @Autowired
    private JwtUtilService jwt;

    @Operation(summary = AppConstants.SUMMARY_CREATE_USER, description = AppConstants.DESCRIPTION_CREATE_USER)
    @ApiResponses(value = {
            @ApiResponse(responseCode = AppConstants.API_RESPONSE_SUCCESS_STATUS, description = AppConstants.API_RESPONSE_SUCCESS),
            @ApiResponse(responseCode = AppConstants.API_RESPONSE_BADREQUEST_STATUS, description = AppConstants.API_RESPONSE_BADREQUEST)
    })
    @PostMapping("/create")
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<User> create(@Valid @RequestBody User user) {
        user.setToken(jwt.generateToken(user.getEmail()));
        User newUser = service.create(user);
        return ResponseEntity.status(HttpStatus.CREATED).body(newUser);
    }
}