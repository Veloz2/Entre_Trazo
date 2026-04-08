

CREATE DATABASE IF NOT EXISTS entretrazo;
USE entretrazo;

CREATE TABLE IF NOT EXISTS solicitudes (
    id              BIGINT AUTO_INCREMENT PRIMARY KEY,
    nombre          VARCHAR(100) NOT NULL,
    telefono        VARCHAR(20)  NOT NULL,
    email           VARCHAR(100) NOT NULL,
    tipo            VARCHAR(20)  NOT NULL,
    descripcion     TEXT         NOT NULL,
    fecha_preferida DATE,
    estado          VARCHAR(20)  DEFAULT 'pendiente',
    fecha_registro  DATETIME     DEFAULT CURRENT_TIMESTAMP
);

CREATE TABLE IF NOT EXISTS usuarios_admin (
    id            BIGINT AUTO_INCREMENT PRIMARY KEY,
    username      VARCHAR(50)  NOT NULL UNIQUE,
    password_hash VARCHAR(255) NOT NULL,
    ultimo_acceso DATETIME
);