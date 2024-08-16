package com.muruna.apirest.constants;

public class AppConstants {
    private AppConstants() {

    }

    public static final String API_REST_TITLE = "Muruna Rest API";
    public static final String API_REST_VERSION = "1.0.0-SNAPSHOT";

    public static final String REQUEST_MAPPING = "/v1";

    // Swagger
    public static final String NAME_USER_CONTROLLER = "User Controller";

    public static final String DESCRIPTION_USER_CONTROLLER = "Controlador de Usuarios";

    public static final String SUMMARY_CREATE_USER = "Crear Usuario";
    public static final String DESCRIPTION_CREATE_USER = "Este endpoint permite crear nuevos usuarios basados en las condiciones del negocio.";

    public static final String API_RESPONSE_SUCCESS_STATUS = "201";
    public static final String API_RESPONSE_SUCCESS = "El usuario ha sido creado exitosamente";

    public static final String API_RESPONSE_BADREQUEST_STATUS = "400";
    public static final String API_RESPONSE_BADREQUEST = "Problema al registar un usuario";

    public static final String USER_NAME_FIELD_DESCRIPTION = "Nombre del Usuario";
    public static final String USER_NAME_FIELD_EXAMPLE = "Juan Rodriguez";

    public static final String USER_EMAIL_FIELD_DESCRIPTION = "Email del Usuario";
    public static final String USER_EMAIL_FIELD_EXAMPLE ="juan@rodriguez.org";

    public static final String USER_PASSWORD_FIELD_DESCRIPTION = "Password del Usuario";
    public static final String USER_PASSWORD_FIELD_EXAMPLE = "juan$Rodriguez";

    public static final String PHONE_NUMBER_FIELD_DESCRIPTION = "Numero de Telefono";
    public static final String PHONE_NUMBER_FIELD_EXAMPLE = "12345678";

    public static final String PHONE_CITYCODE_FIELD_DESCRIPTION = "Codigo de Ciudad";
    public static final String PHONE_CITYCODE_FIELD_EXAMPLE = "Codigo de Ciudad";

    public static final String PHONE_COUNTRYCODE_FIELD_DESCRIPTION = "Codigo de Pais";
    public static final String PHONE_COUNTRYCODE_FIELD_EXAMPLE = "56";

    // Table
    public static final String USER_ENTITY_NAME = "USERS";

    public static final String USER_ENTITY_COLUMN_NAME = "name";
    public static final String USER_ENTITY_COLUMN_EMAIL = "email";
    public static final String USER_ENTITY_COLUMN_PASSWORD = "password";
    public static final String USER_ENTITY_COLUMN_CREATED = "created";
    public static final String USER_ENTITY_COLUMN_MODIFIED = "modified";
    public static final String USER_ENTITY_COLUMN_LASTLOGIN = "last_login";
    public static final String USER_ENTITY_COLUMN_TOKEN = "token";
    public static final String USER_ENTITY_COLUMN_ISACTIVE = "isactive";

    public static final String PHONE_ENTITY_NAME = "PHONE";

    public static final String PHONE_ENTITY_COLUMN_NUMBER = "number";
    public static final String PHONE_ENTITY_COLUMN_CITYCODE = "citycode";
    public static final String PHONE_ENTITY_COLUMN_COUNTRYCODE = "countrycode";


    // Validations
    public static final String INVALID_USER_EMAIL_DUPLICATED_MSG = "Error: Este Correo ya esta Registrado";

    public static final String INVALID_PASSWORD_MSG = "Password: Formato Invalido, intente nuevamente";

    public static final String INVALID_EMAIL_MSG = "Email: Formato Invalido, intente nuevamente";

}
