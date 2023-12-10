CREATE TABLE USUARIO (
    ID BIGINT GENERATED BY DEFAULT AS IDENTITY(START WITH 0, INCREMENT BY 1) PRIMARY KEY,
    NOMBRE_USUARIO VARCHAR(25) NOT NULL,
    CONTRASENA VARCHAR(14) NOT NULL,
    ESTADO INTEGER NOT NULL,
    PERSONA_ID BIGINT NOT NULL,
    FECHA_INGRESO TIMESTAMP DEFAULT NOW() NOT NULL
);

CREATE TABLE PERSONA (
    ID BIGINT GENERATED BY DEFAULT AS IDENTITY(START WITH 0, INCREMENT BY 1) PRIMARY KEY,
    TIPO_DOCUMENTO INTEGER NOT NULL,
    NUMERO_DOCUMENTO VARCHAR(25) NOT NULL,
    PRIMER_NOMBRE VARCHAR(250) NOT NULL,
    SEGUNDO_NOMBRE VARCHAR(250) NOT NULL,
    APELLIDO_PATERNO VARCHAR(250) NOT NULL,
    APELLIDO_MATERNO VARCHAR(250) NOT NULL,
    ESTADO INTEGER NOT NULL,
    FECHA_INGRESO TIMESTAMP DEFAULT NOW() NOT NULL
);

ALTER TABLE USUARIO ADD FOREIGN KEY (PERSONA_ID) REFERENCES PERSONA (ID);