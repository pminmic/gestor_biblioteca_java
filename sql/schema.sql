USE biblioteca;

CREATE TABLE documentos (
    identificador VARCHAR(50) PRIMARY KEY,
    titulo VARCHAR(50) NOT NULL,
    ejemplares INT NOT NULL,
    fecha_publi DATE NOT NULL,
    autor VARCHAR(50),
    director VARCHAR(50),
    editorial VARCHAR(50),
    productora VARCHAR(50),
    tipo_doc ENUM('dvd', 'libro', 'revista')
);

CREATE TABLE socios (
    socio_id SERIAL PRIMARY KEY,
    nombre VARCHAR(50) NOT NULL,
    email VARCHAR(50) NOT NULL UNIQUE,
    telefono VARCHAR(25) NOT NULL UNIQUE,
    fecha_registro DATE NOT NULL
);

CREATE TABLE prestamos (
    prestamo_id SERIAL,
    identificador VARCHAR(50) NOT NULL,
    socio_id BIGINT(20) UNSIGNED NOT NULL,
    fecha_prestamo DATE NOT NULL,
    fecha_retorno DATE NOT NULL,
    PRIMARY KEY (identificador, socio_id, fecha_prestamo),
    FOREIGN KEY (identificador) REFERENCES documentos(identificador),
    FOREIGN KEY (socio_id) REFERENCES socios(socio_id)
);