package com.muruna.apirest.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.muruna.apirest.constants.AppConstants;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import lombok.Data;

import java.util.Date;
import java.util.List;
import java.util.UUID;

@Table(uniqueConstraints = {@UniqueConstraint(columnNames = {AppConstants.USER_ENTITY_COLUMN_EMAIL})})
@Entity(name = AppConstants.USER_ENTITY_NAME)
@JsonInclude(JsonInclude.Include.NON_NULL)
@Data
public class User {

    @Schema(accessMode = Schema.AccessMode.READ_ONLY)
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID userId;

    @Schema(description = AppConstants.USER_NAME_FIELD_DESCRIPTION, example = AppConstants.USER_NAME_FIELD_EXAMPLE)
    @Column(length = 30)
    @JsonProperty(AppConstants.USER_ENTITY_COLUMN_NAME)
    private String name;

    @Schema(description = AppConstants.USER_EMAIL_FIELD_DESCRIPTION, example = AppConstants.USER_EMAIL_FIELD_EXAMPLE)
    @Column(length = 30, name = AppConstants.USER_ENTITY_COLUMN_EMAIL)
    @Email(message = AppConstants.INVALID_EMAIL_MSG)
    @JsonProperty(AppConstants.USER_ENTITY_COLUMN_EMAIL)
    private String email;

    @Schema(description = AppConstants.USER_PASSWORD_FIELD_DESCRIPTION, example = AppConstants.USER_PASSWORD_FIELD_EXAMPLE)
    @Column(length = 20)
    @JsonProperty(AppConstants.USER_ENTITY_COLUMN_PASSWORD)
    private String password;

    @OneToMany(cascade = CascadeType.ALL)
    private List<Phone> phones;

    @Schema(accessMode = Schema.AccessMode.READ_ONLY)
    @JsonProperty(AppConstants.USER_ENTITY_COLUMN_CREATED)
    @Temporal(value = TemporalType.TIMESTAMP)
    private Date created;

    @Schema(accessMode = Schema.AccessMode.READ_ONLY)
    @JsonProperty(AppConstants.USER_ENTITY_COLUMN_MODIFIED)
    @Temporal(value = TemporalType.TIMESTAMP)
    private Date modified;

    @Schema(accessMode = Schema.AccessMode.READ_ONLY)
    @JsonProperty(AppConstants.USER_ENTITY_COLUMN_LASTLOGIN)
    @Temporal(value = TemporalType.TIMESTAMP)
    private Date lastLogin;

    @Schema(accessMode = Schema.AccessMode.READ_ONLY)
    @JsonProperty(AppConstants.USER_ENTITY_COLUMN_TOKEN)
    private String token;

    @Schema(accessMode = Schema.AccessMode.READ_ONLY)
    @JsonProperty(AppConstants.USER_ENTITY_COLUMN_ISACTIVE)
    private Boolean isActive;
}
