create database restaurante_chino;
use restaurante_chino;
SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";
CREATE TABLE `categoria` (
 `id` bigint(20) UNSIGNED NOT NULL,
 `nombre` varchar(255) NOT NULL,
 `tipo` enum('Inventario','Menu') NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
--
-- Volcado de datos para la tabla `categoria`
--
INSERT INTO `categoria` (`id`, `nombre`, `tipo`) VALUES
(1, 'Bebidas', 'Menu'),
(3, 'Frutas', 'Inventario');
-- --------------------------------------------------------
--
-- Estructura de tabla para la tabla `clientes`
--
CREATE TABLE `clientes` (
 `id` bigint(20) UNSIGNED NOT NULL,
 `dni_ruc` varchar(255) NOT NULL,
 `telefono` varchar(255) NOT NULL,
 `correo` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
--
-- Volcado de datos para la tabla `clientes`
--
INSERT INTO `clientes` (`id`, `dni_ruc`, `telefono`, `correo`) VALUES
(1, '72702638', '912905731', 'easp0104@gmail.com');
-- --------------------------------------------------------
--
-- Estructura de tabla para la tabla `detallepedido`
--
CREATE TABLE `detallepedido` (
 `id` bigint(20) UNSIGNED NOT NULL,
 `id_menu` bigint(20) UNSIGNED NOT NULL,
 `cantidad` int(11) NOT NULL,
 `subtotal` decimal(8,2) NOT NULL,
 `id_pedido` bigint(20) UNSIGNED NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
-- --------------------------------------------------------
--
-- Estructura de tabla para la tabla `inventario`
--
CREATE TABLE `inventario` (
 `id` bigint(20) UNSIGNED NOT NULL,
 `id_categoria` bigint(20) UNSIGNED NOT NULL,
 `nombre` varchar(255) NOT NULL,
 `unidad` enum('KG','L','UN') NOT NULL,
 `precio_unitario` decimal(8,2) NOT NULL,
 `inventario_inicial` int(11) NOT NULL,
 `stock` int(11) NOT NULL,
 `stock_min` int(11) NOT NULL DEFAULT 0,
 `caducidad` date NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
--
-- Volcado de datos para la tabla `inventario`
--
INSERT INTO `inventario` (`id`, `id_categoria`, `nombre`, `unidad`, `precio_unitario`,
`inventario_inicial`, `stock`, `stock_min`, `caducidad`) VALUES
(2, 3, 'Manzanassss', 'KG', 34.90, 56, 56, 8, '2018-02-27');
-- --------------------------------------------------------
--
-- Estructura de tabla para la tabla `menu`
--
CREATE TABLE `menu` (
 `id` bigint(20) UNSIGNED NOT NULL,
 `nombre` varchar(255) NOT NULL,
 `descripcion` varchar(255) NOT NULL,
 `imagen` text DEFAULT NULL,
 `precio` decimal(8,2) NOT NULL,
 `estado` enum('Venta','Desactivado') DEFAULT 'Venta',
 `id_categoria` bigint(20) UNSIGNED NOT NULL 
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
-- --------------------------------------------------------
--
-- Estructura de tabla para la tabla `mesa`
--
CREATE TABLE `mesa` (
 `id` bigint(20) UNSIGNED NOT NULL,
 `n_salon` int(11) NOT NULL,
 `n_mesa` int(11) NOT NULL,
 `estado` enum('Libre','Reservado','Ocupado') DEFAULT 'Libre',
 `created_at` timestamp NOT NULL DEFAULT current_timestamp(),
 `updated_at` timestamp NOT NULL DEFAULT current_timestamp() ON UPDATE
current_timestamp()
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
--
-- Volcado de datos para la tabla `mesa`
--
INSERT INTO `mesa` (`id`, `n_salon`, `n_mesa`, `estado`, `created_at`, `updated_at`) VALUES
(14, 2, 1, 'Ocupado', '2024-10-09 22:01:30', '2024-10-09 22:53:18'),
(15, 6, 7, 'Libre', '2024-10-09 23:05:10', '2024-10-09 23:05:10');
-- --------------------------------------------------------
--
-- Estructura de tabla para la tabla `pedidos`
--
CREATE TABLE `pedidos` (
 `id` bigint(20) UNSIGNED NOT NULL,
 `id_cliente` bigint(20) UNSIGNED NOT NULL,
 `id_mesa` bigint(20) UNSIGNED NOT NULL,
 `estado` enum('Pendiente','Completado','Cancelado') NOT NULL DEFAULT 'Pendiente',
 `tipo_recibo` enum('Factura','Boleta') DEFAULT NULL,
 `metodo_pago` enum('Efectivo','Tarjeta','Transferencia') DEFAULT NULL,
 `total` decimal(8,2) NOT NULL,
 `id_trabajador` bigint(20) UNSIGNED NOT NULL,
 `created_at` datetime NOT NULL DEFAULT current_timestamp()
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
--
-- Volcado de datos para la tabla `pedidos`
--
INSERT INTO `pedidos` (`id`, `id_cliente`, `id_mesa`, `estado`, `tipo_recibo`, `metodo_pago`,
`total`, `id_trabajador`, `created_at`) VALUES
(1, 1, 14, 'Pendiente', 'Factura', 'Tarjeta', 24.80, 2, '2024-10-09 00:00:00'),
(3, 1, 15, 'Pendiente', 'Factura', 'Efectivo', 67.90, 2, '2024-10-09 18:11:40');
-- --------------------------------------------------------
--
-- Estructura Stand-in para la vista `pedidosview`
-- (Véase abajo para la vista actual)
--
CREATE TABLE `pedidosview` (
`id` bigint(20) unsigned
,`dni_ruc` varchar(255)
,`n_mesa` int(11)
,`estado` enum('Pendiente','Completado','Cancelado')
,`tipo_recibo` enum('Factura','Boleta')
,`metodo_pago` enum('Efectivo','Tarjeta','Transferencia')
,`total` decimal(8,2)
,`created_at` datetime
);
-- --------------------------------------------------------
--
-- Estructura de tabla para la tabla `rol`
--
CREATE TABLE `rol` (
 `id` bigint(20) UNSIGNED NOT NULL,
 `nombre` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
--
-- Volcado de datos para la tabla `rol`
--
INSERT INTO `rol` VALUES (1, 'Administrador');
INSERT INTO `rol` VALUES (2, 'Cocinero');
INSERT INTO `rol` VALUES (3, 'Mozo');
-- --------------------------------------------------------
--
-- Estructura de tabla para la tabla `trabajadores`
--
CREATE TABLE `trabajadores` (
 `id` bigint(20) UNSIGNED NOT NULL,
 `apellido` varchar(100) NOT NULL,
 `nombre` varchar(100) NOT NULL,
 `dni` varchar(8) NOT NULL,
 `correo` varchar(50) NOT NULL,
 `usuario` varchar(30) NOT NULL,
 `password` blob NOT NULL,
 `celular` varchar(9) NOT NULL,
 `id_rol` bigint(20) UNSIGNED NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
--
-- Volcado de datos para la tabla `trabajadores`
--
INSERT INTO `trabajadores` VALUES
(1,'Suarez', 'Elena', '72324369', 'lena@gmail.com','lsp', 0x313233, '912905731', 1),
(2, 'Castañeda', 'Yoshua', '73993482','f4r3ver@gmail.com','DevJourney19', 0x313233,
'998162677', 1);
-- --------------------------------------------------------
--
-- Estructura para la vista `pedidosview`
--
DROP TABLE IF EXISTS `pedidosview`;
CREATE ALGORITHM=UNDEFINED DEFINER=`root`@`localhost` SQL SECURITY DEFINER VIEW
`pedidosview` AS SELECT `pedidos`.`id` AS `id`, `clientes`.`dni_ruc` AS `dni_ruc`,
`mesa`.`n_mesa` AS `n_mesa`, `pedidos`.`estado` AS `estado`, `pedidos`.`tipo_recibo` AS
`tipo_recibo`, `pedidos`.`metodo_pago` AS `metodo_pago`, `pedidos`.`total` AS `total`,
`pedidos`.`created_at` AS `created_at` FROM ((`pedidos` join `clientes`
on(`pedidos`.`id_cliente` = `clientes`.`id`)) join `mesa` on(`pedidos`.`id_mesa` = `mesa`.`id`)) ;
--
-- Índices para tablas volcadas
--
--
-- Indices de la tabla `categoria`
--
ALTER TABLE `categoria`
 ADD PRIMARY KEY (`id`);
--
-- Indices de la tabla `clientes`
--
ALTER TABLE `clientes`
 ADD PRIMARY KEY (`id`);
--
-- Indices de la tabla `detallepedido`
--
ALTER TABLE `detallepedido`
 ADD PRIMARY KEY (`id`),
 ADD KEY `detallepedido_id_menu_foreign` (`id_menu`),
 ADD KEY `detallepedido_id_pedido_foreign` (`id_pedido`);
--
-- Indices de la tabla `inventario`
--
ALTER TABLE `inventario`
 ADD PRIMARY KEY (`id`),
 ADD KEY `inventario_id_categoria_foreign` (`id_categoria`);
--
-- Indices de la tabla `menu`
--
ALTER TABLE `menu`
 ADD PRIMARY KEY (`id`),
 ADD KEY `idx_categoria` (`id_categoria`) USING BTREE;
--
-- Indices de la tabla `mesa`
--
ALTER TABLE `mesa`
 ADD PRIMARY KEY (`id`);
--
-- Indices de la tabla `pedidos`
--
ALTER TABLE `pedidos`
 ADD PRIMARY KEY (`id`),
 ADD KEY `pedidos_id_cliente_foreign` (`id_cliente`),
 ADD KEY `pedidos_id_trabajador_foreign` (`id_trabajador`),
 ADD KEY `pedidos_id_mesa_foreign` (`id_mesa`);
--
-- Indices de la tabla `trabajadores`
--
ALTER TABLE `trabajadores`
 ADD PRIMARY KEY (`id`),
 ADD KEY `trabajadores_id_rol_foreign` (`id_rol`);
--
-- AUTO_INCREMENT de las tablas volcadas
--
--
-- AUTO_INCREMENT de la tabla `categoria`
--
ALTER TABLE `categoria`
 MODIFY `id` bigint(20) UNSIGNED NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;
--
-- AUTO_INCREMENT de la tabla `clientes`
--
ALTER TABLE `clientes`
 MODIFY `id` bigint(20) UNSIGNED NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;
--
-- AUTO_INCREMENT de la tabla `detallepedido`
--
ALTER TABLE `detallepedido`
 MODIFY `id` bigint(20) UNSIGNED NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT de la tabla `inventario`
--
ALTER TABLE `inventario`
 MODIFY `id` bigint(20) UNSIGNED NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;
--
-- AUTO_INCREMENT de la tabla `menu`
--
ALTER TABLE `menu`
 MODIFY `id` bigint(20) UNSIGNED NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT de la tabla `mesa`
--
ALTER TABLE `mesa`
 MODIFY `id` bigint(20) UNSIGNED NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=16;
--
-- AUTO_INCREMENT de la tabla `pedidos`
--
ALTER TABLE `pedidos`
 MODIFY `id` bigint(20) UNSIGNED NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;
--
-- AUTO_INCREMENT de la tabla `rol`
--
ALTER TABLE `rol`
MODIFY `id` bigint(20) UNSIGNED NOT NULL AUTO_INCREMENT,
ADD PRIMARY KEY (`id`);
--
-- AUTO_INCREMENT de la tabla `trabajadores`
--
ALTER TABLE `trabajadores`
 MODIFY `id` bigint(20) UNSIGNED NOT NULL AUTO_INCREMENT;
--
-- Restricciones para tablas volcadas
--
--
-- Filtros para la tabla `detallepedido`
--
ALTER TABLE `detallepedido`
 ADD CONSTRAINT `detallepedido_id_menu_foreign` FOREIGN KEY (`id_menu`) REFERENCES
`menu` (`id`),
 ADD CONSTRAINT `detallepedido_id_pedido_foreign` FOREIGN KEY (`id_pedido`)
REFERENCES `pedidos` (`id`);
--
-- Filtros para la tabla `inventario`
--
ALTER TABLE `inventario`
 ADD CONSTRAINT `inventario_id_categoria_foreign` FOREIGN KEY (`id_categoria`)
REFERENCES `categoria` (`id`);

ALTER TABLE `menu`
 ADD CONSTRAINT `menu_id_categoria_foreig` FOREIGN KEY (`id_categoria`)
REFERENCES `categoria` (`id`);
--
-- Filtros para la tabla `pedidos`
--
ALTER TABLE `pedidos`
 ADD CONSTRAINT `pedidos_id_cliente_foreign` FOREIGN KEY (`id_cliente`) REFERENCES
`clientes` (`id`),
 ADD CONSTRAINT `pedidos_id_mesa_foreign` FOREIGN KEY (`id_mesa`) REFERENCES `mesa`
(`id`),
 ADD CONSTRAINT `pedidos_id_trabajador_foreign` FOREIGN KEY (`id_trabajador`)
REFERENCES `trabajadores` (`id`);
--
-- Filtros para la tabla `trabajadores`
--
ALTER TABLE `trabajadores`
 ADD CONSTRAINT `trabajadores_id_rol_foreign` FOREIGN KEY (`id_rol`) REFERENCES `rol`
(`id`);
COMMIT;
