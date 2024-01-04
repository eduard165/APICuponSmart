

----------------------------------------------

-- Creacion de usuario y asignacion de permisos 
CREATE USER 'Eduard'@'127.0.0.1' IDENTIFIED BY 'FlowLetal';
GRANT ALL PRIVILEGES ON smartcupon TO 'Eduard'@'127.0.0.1';

----------------------------------------------------

-- Crear base de datos si no existe
CREATE DATABASE IF NOT EXISTS smartcupon;
USE smartcupon;

-- Tablas primarias
CREATE TABLE estado (
    id_estado int AUTO_INCREMENT PRIMARY KEY,
    nombre varchar(45)
);

CREATE TABLE estatus (
    id_estatus int AUTO_INCREMENT PRIMARY KEY,
    nombre_estatus varchar(50)
);

CREATE TABLE tipo_promocion (
    id_tipo_promocion int AUTO_INCREMENT PRIMARY KEY,
    nombre_tipo varchar(50)
);

CREATE TABLE categoria (
    id_categoria int AUTO_INCREMENT PRIMARY KEY,
    nombre_categoria varchar(100)
);

CREATE TABLE rol (
    id_rol int AUTO_INCREMENT PRIMARY KEY,
    nombre_rol varchar(50)
);

CREATE TABLE empresa (
    rfc varchar(20) PRIMARY KEY,
    nombre varchar(255),
    nombre_comercial varchar(255),
    representante_legal varchar(255),
    email varchar(100),
    telefono varchar(20),
    pagina_web varchar(255),
    id_estatus int,
    logo longblob,
    FOREIGN KEY (id_estatus) REFERENCES estatus(id_estatus)
);

CREATE TABLE cliente (
    id_cliente int AUTO_INCREMENT PRIMARY KEY,
    nombre varchar(100),
    apellido_paterno varchar(100),
    apellido_materno varchar(100),
    telefono varchar(20),
    correo_electronico varchar(100),
    fecha_nacimiento date,
    password varchar(255)
);

CREATE TABLE usuario (
    id_usuario int AUTO_INCREMENT PRIMARY KEY,
    nombre varchar(100),
    apellido_paterno varchar(100),
    apellido_materno varchar(100),
    curp varchar(18),
    correo_electronico varchar(100),
    username varchar(50),
    password varchar(255),
    id_rol int,
    empresa_rfc varchar(20),
    FOREIGN KEY (id_rol) REFERENCES rol(id_rol),
    FOREIGN KEY (empresa_rfc) REFERENCES empresa(rfc)
);

-- Tablas con referencias a tablas primarias creadas previamente
CREATE TABLE promocion (
    id_promocion int AUTO_INCREMENT PRIMARY KEY,
    nombre_promocion varchar(255),
    descripcion text,
    fecha_inicio date,
    fecha_termino date,
    restricciones text,
    id_tipo_promocion int,
    porcentaje_descuento decimal(5,2),
    codigo_promocion varchar(8),
    id_estatus int,
    empresa_rfc varchar(20),
    id_categoria int,
    imagen longblob,
    usos_disponibles int,
    FOREIGN KEY (id_tipo_promocion) REFERENCES tipo_promocion(id_tipo_promocion),
    FOREIGN KEY (id_estatus) REFERENCES estatus(id_estatus),
    FOREIGN KEY (empresa_rfc) REFERENCES empresa(rfc),
    FOREIGN KEY (id_categoria) REFERENCES categoria(id_categoria)
);

CREATE TABLE cupon (
    id_cupon int AUTO_INCREMENT PRIMARY KEY,
    codigo_cupon varchar(8),
    id_promocion int,
    fecha_generacion date,
    id_estatus int,
    FOREIGN KEY (id_promocion) REFERENCES promocion(id_promocion),
    FOREIGN KEY (id_estatus) REFERENCES estatus(id_estatus)
);

CREATE TABLE municipio (
    id_municipio int AUTO_INCREMENT PRIMARY KEY,
    nombre varchar(45),
    id_estado int,
    FOREIGN KEY (id_estado) REFERENCES estado(id_estado)
);

CREATE TABLE sucursal (
    id_sucursal int AUTO_INCREMENT PRIMARY KEY,
    nombre varchar(255),
    telefono varchar(20),
    latitud decimal(10,8),
    longitud decimal(11,8),
    nombre_encargado varchar(255),
    empresa_rfc varchar(20),
    FOREIGN KEY (empresa_rfc) REFERENCES empresa(rfc)
);

CREATE TABLE direccion (
    id_direccion int AUTO_INCREMENT PRIMARY KEY,
    calle varchar(255),
    numero int,
    codigo_postal varchar(10),
    colonia varchar(100),
    id_municipio int,
    id_cliente int,
    empresa_rfc varchar(20),
    id_sucursal int,
    FOREIGN KEY (id_municipio) REFERENCES municipio(id_municipio),
    FOREIGN KEY (id_cliente) REFERENCES cliente(id_cliente),
    FOREIGN KEY (empresa_rfc) REFERENCES empresa(rfc),
    FOREIGN KEY (id_sucursal) REFERENCES sucursal(id_sucursal)
);

-- Tabla compuesta sin la llave primaria idSucursalPromocion
CREATE TABLE sucursal_promocion (
    sucursal_id int,
    promocion_id int,
    FOREIGN KEY (sucursal_id) REFERENCES sucursal(id_sucursal),
    FOREIGN KEY (promocion_id) REFERENCES promocion(id_promocion),
    PRIMARY KEY (sucursal_id, promocion_id)
);


----------------------------------------------
-- Insertar estados
INSERT INTO estado (nombre) VALUES
('Aguascalientes'), ('Baja California'), ('Baja California Sur'), ('Campeche'), ('Chiapas'),
('Chihuahua'), ('Coahuila de Zaragoza'), ('Colima'), ('Durango'), ('Guanajuato');

-- Insertar municipios para los estados

-- Aguascalientes
INSERT INTO municipio (nombre, idEstado) VALUES
('Aguascalientes', 1), ('Asientos', 1), ('Calvillo', 1), ('Cosío', 1), ('Jesús María', 1),
('Pabellón de Arteaga', 1), ('Rincón de Romos', 1), ('San José de Gracia', 1),
('Tepezalá', 1), ('El Llano', 1);

-- Baja California
INSERT INTO municipio (nombre, idEstado) VALUES
('Tijuana', 2), ('Mexicali', 2), ('Ensenada', 2), ('Rosarito', 2), ('Tecate', 2),
('Playas de Rosarito', 2), ('La Rumorosa', 2), ('San Felipe', 2), ('Puertecitos', 2),
('San Quintín', 2);

-- Baja California Sur
INSERT INTO municipio (nombre, idEstado) VALUES
('La Paz', 3), ('Cabo San Lucas', 3), ('San José del Cabo', 3), ('Comondú', 3), ('Loreto', 3),
('Mulegé', 3), ('Santa Rosalía', 3), ('Guerrero Negro', 3), ('Villa Alberto Andrés Alvarado Arámburo', 3),
('Ciudad Constitución', 3);

-- Campeche
INSERT INTO municipio (nombre, idEstado) VALUES
('Campeche', 4), ('Calkiní', 4), ('Carmen', 4), ('Champotón', 4), ('Hecelchakán', 4),
('Hopelchén', 4), ('Palizada', 4), ('Tenabo', 4), ('Escárcega', 4), ('Calakmul', 4);

-- Chiapas
INSERT INTO municipio (nombre, idEstado) VALUES
('Tuxtla Gutiérrez', 5), ('Tapachula', 5), ('San Cristóbal de las Casas', 5),
('Tonalá', 5), ('Chiapa de Corzo', 5), ('Comitán de Domínguez', 5), ('Ocosingo', 5),
('Villaflores', 5), ('Palenque', 5), ('Cintalapa', 5);

-- Chihuahua
INSERT INTO municipio (nombre, idEstado) VALUES
('Chihuahua', 6), ('Juárez', 6), ('Cuauhtémoc', 6), ('Delicias', 6), ('Parral', 6),
('Hidalgo del Parral', 6), ('Nuevo Casas Grandes', 6), ('Camargo', 6), ('Jiménez', 6),
('Meoqui', 6);

-- Coahuila de Zaragoza
INSERT INTO municipio (nombre, idEstado) VALUES
('Saltillo', 7), ('Torreón', 7), ('Monclova', 7), ('Piedras Negras', 7), ('Acuña', 7),
('Matamoros', 7), ('Sabinas', 7), ('Nueva Rosita', 7), ('Frontera', 7), ('Allende', 7);

-- Colima
INSERT INTO municipio (nombre, idEstado) VALUES
('Colima', 8), ('Manzanillo', 8), ('Tecomán', 8), ('Villa de Álvarez', 8), ('Minatitlán', 8),
('Armería', 8), ('Cuauhtémoc', 8), ('Coquimatlán', 8), ('Comala', 8), ('Ixtlahuacán', 8);

-- Durango
INSERT INTO municipio (nombre, idEstado) VALUES
('Durango', 9), ('Gómez Palacio', 9), ('Lerdo', 9), ('Victoria de Durango', 9), ('Canatlán', 9),
('Tlahualilo', 9), ('Guadalupe Victoria', 9), ('San Juan del Río', 9), ('Peñón Blanco', 9),
('Pueblo Nuevo', 9);

-- Guanajuato
INSERT INTO municipio (nombre, idEstado) VALUES
('León', 10), ('Irapuato', 10), ('Celaya', 10), ('Salamanca', 10), ('Guanajuato', 10),
('San Miguel de Allende', 10), ('Acámbaro', 10), ('Silao', 10), ('Dolores Hidalgo', 10),
('Valle de Santiago', 10);

-- Insertar roles
INSERT INTO rol (nombreRol) VALUES ('Administrador general'), ('Administrador comercial');

-- Insertar estatus
INSERT INTO estatus (nombreEstatus) VALUES ('Activo'), ('Inactivo');

----------------------------------------------

-- SELECT de la tabla estado
SELECT * FROM estado;

-- SELECT de la tabla estatus
SELECT * FROM estatus;

-- SELECT de la tabla tipo_promocion
SELECT * FROM tipo_promocion;

-- SELECT de la tabla categoria
SELECT * FROM categoria;

-- SELECT de la tabla rol
SELECT * FROM rol;

-- SELECT de la tabla empresa
SELECT * FROM empresa;

-- SELECT de la tabla cliente
SELECT * FROM cliente;

-- SELECT de la tabla usuario
SELECT * FROM usuario;

-- SELECT de la tabla promocion
SELECT * FROM promocion;

-- SELECT de la tabla cupon
SELECT * FROM cupon;

-- SELECT de la tabla municipio
SELECT * FROM municipio;

-- SELECT de la tabla sucursal
SELECT * FROM sucursal;

-- SELECT de la tabla direccion
SELECT * FROM direccion;

-- SELECT de la tabla sucursal_promocion
SELECT * FROM sucursal_promocion;
