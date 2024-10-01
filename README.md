## Creamos y nos ubicamos en la base de datos del restaurante
create database restaurante;
use restaurante;

## Creamos las tablas respectivas
create table roles(
id int auto_increment primary key, nombre varchar(20) 
);

create table trabajadores(
id int auto_increment primary key, nombre varchar(50),
apellido varchar(50), usuario varchar(20), password blob, 
telefono varchar(9), id_rol int, 
CONSTRAINT fk_rol foreign key (id) REFERENCES 
roles(id) ON DELETE CASCADE ON UPDATE CASCADE
);

create table inventario(
id int auto_increment primary key, nombre varchar(30), 
stock int, stock_min int, id_trabajdor int, 
CONSTRAINT fk_trabajador foreign key (id) REFERENCES trabajadores(id) 
ON DELETE CASCADE ON UPDATE CASCADE
);

create table clientes(
id int auto_increment primary key, dni_ruc varchar(11),
telefono varchar(9), correo varchar(50)
);

create table pedidos(
id int auto_increment primary key, descripcion varchar(200), tipo_recibo 
varchar(20), metodo_pago varchar(20), total decimal(10,2), id_cliente int, 
CONSTRAINT fk_cliente foreign key (id) REFERENCES clientes(id) 
ON DELETE CASCADE ON UPDATE CASCADE
);

create table menu(
id int auto_increment primary key, nombre varchar(30), img blob, 
descripcion varchar(200), precio decimal(10,2)
);

create table detalle_pedidos(
id int auto_increment primary key, id_menu int, cantidad int, subtotal decimal(10,2), id_pedido int, id_trabajador int, 
CONSTRAINT fk_trabajador_dp foreign key (id) REFERENCES trabajadores(id) ON DELETE CASCADE ON UPDATE CASCADE, 
CONSTRAINT fk_pedido_dp foreign key (id) REFERENCES pedidos(id) ON DELETE CASCADE ON UPDATE CASCADE, 
CONSTRAINT fk_menu_dp foreign key (id) REFERENCES menu(id) ON DELETE CASCADE ON UPDATE CASCADE
);
