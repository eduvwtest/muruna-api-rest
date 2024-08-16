package com.muruna.apirest.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.muruna.apirest.constants.AppConstants;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.*;
import lombok.Data;

@Entity(name = AppConstants.PHONE_ENTITY_NAME)
@Data
public class Phone {

    @Schema(hidden = true)
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Schema(description = AppConstants.PHONE_NUMBER_FIELD_DESCRIPTION, example = AppConstants.PHONE_NUMBER_FIELD_EXAMPLE)
    @JsonProperty(AppConstants.PHONE_ENTITY_COLUMN_NUMBER)
    private int number;

    @Schema(description = AppConstants.PHONE_CITYCODE_FIELD_DESCRIPTION, example = AppConstants.PHONE_CITYCODE_FIELD_EXAMPLE)
    @JsonProperty(AppConstants.PHONE_ENTITY_COLUMN_CITYCODE)
    private int cityCode;

    @Schema(description = AppConstants.PHONE_COUNTRYCODE_FIELD_DESCRIPTION, example = AppConstants.PHONE_COUNTRYCODE_FIELD_EXAMPLE)
    @JsonProperty(AppConstants.PHONE_ENTITY_COLUMN_COUNTRYCODE)
    private int contryCode;

}
