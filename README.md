## Creamos y nos ubicamos en la base de datos del restaurante
create database restaurante;
use restaurante;

## Creamos las tablas respectivas

````sql
CREATE TABLE roles (
    id INT AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(20)
);

CREATE TABLE trabajadores (
    codigo VARCHAR(4) PRIMARY KEY,
    nombre VARCHAR(50),
    apellido VARCHAR(50),
    usuario VARCHAR(20),
    password BLOB,
    celular VARCHAR(9),
    id_rol INT,
    CONSTRAINT fk_rol FOREIGN KEY (id_rol) REFERENCES roles(id) 
        ON DELETE CASCADE ON UPDATE CASCADE
);

CREATE TABLE inventario (
    id INT AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(30),
    stock INT,
    stock_min INT,
    id_trabajador VARCHAR(4), -- Cambiado a VARCHAR(4) para coincidir con el tipo de `codigo` en trabajadores
    CONSTRAINT fk_trabajador FOREIGN KEY (id_trabajador) REFERENCES trabajadores(codigo) 
        ON DELETE CASCADE ON UPDATE CASCADE
);

CREATE TABLE clientes (
    id INT AUTO_INCREMENT PRIMARY KEY,
    dni_ruc VARCHAR(11),
    celular VARCHAR(9),
    correo VARCHAR(50)
);

CREATE TABLE pedidos (
    id INT AUTO_INCREMENT PRIMARY KEY,
    descripcion VARCHAR(200),
    tipo_recibo VARCHAR(20),
    metodo_pago VARCHAR(20),
    total DECIMAL(10,2),
    id_cliente INT,
    CONSTRAINT fk_cliente FOREIGN KEY (id_cliente) REFERENCES clientes(id) 
        ON DELETE CASCADE ON UPDATE CASCADE
);

CREATE TABLE menu (
    id INT AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(30),
    img BLOB,
    descripcion VARCHAR(200),
    precio DECIMAL(10,2)
);

CREATE TABLE detalle_pedidos (
    id INT AUTO_INCREMENT PRIMARY KEY,
    id_menu INT,
    cantidad INT,
    subtotal DECIMAL(10,2),
    id_pedido INT,
    id_trabajador VARCHAR(4), -- Cambiado a VARCHAR(4) para coincidir con el tipo de `codigo` en trabajadores
    CONSTRAINT fk_trabajador_dp FOREIGN KEY (id_trabajador) REFERENCES trabajadores(codigo) 
        ON DELETE CASCADE ON UPDATE CASCADE,
    CONSTRAINT fk_pedido_dp FOREIGN KEY (id_pedido) REFERENCES pedidos(id) 
        ON DELETE CASCADE ON UPDATE CASCADE,
    CONSTRAINT fk_menu_dp FOREIGN KEY (id_menu) REFERENCES menu(id) 
        ON DELETE CASCADE ON UPDATE CASCADE
);

```
