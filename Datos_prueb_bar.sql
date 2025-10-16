-- =====================================================
-- DATOS DE PRUEBA REALISTAS PARA UCACUE_APP
-- Sistema de Gestión de Restaurante
-- =====================================================

USE `ucacue_app`;

-- =====================================================
-- LIMPIEZA DE DATOS EXISTENTES (en orden inverso por dependencias)
-- =====================================================
SET FOREIGN_KEY_CHECKS = 0;

TRUNCATE TABLE `app_sale_detail`;
TRUNCATE TABLE `app_recipe`;
TRUNCATE TABLE `app_purchase_order_detail`;
TRUNCATE TABLE `app_sale`;
TRUNCATE TABLE `app_purchase_order`;
TRUNCATE TABLE `app_product_sale`;
TRUNCATE TABLE `app_consumable`;
TRUNCATE TABLE `app_product`;
TRUNCATE TABLE `app_category_sale`;
TRUNCATE TABLE `app_category_consumable`;
TRUNCATE TABLE `app_category`;
TRUNCATE TABLE `app_user`;
TRUNCATE TABLE `app_supplier`;
TRUNCATE TABLE `app_role`;

SET FOREIGN_KEY_CHECKS = 1;

-- =====================================================
-- 1. ROLES
-- =====================================================
INSERT INTO `app_role` (`id_role`, `created_date`, `role_name`, `updated_date`) VALUES
(1, '2024-01-15 08:00:00', 'ADMIN', '2024-01-15 08:00:00'),
(2, '2024-01-15 08:00:00', 'GERENTE', '2024-01-15 08:00:00'),
(3, '2024-01-15 08:00:00', 'CAJERO', '2024-01-15 08:00:00'),
(4, '2024-01-15 08:00:00', 'MESERO', '2024-01-15 08:00:00'),
(5, '2024-01-15 08:00:00', 'COCINERO', '2024-01-15 08:00:00');

-- =====================================================
-- 2. USUARIOS
-- =====================================================
INSERT INTO `app_user` (`id_user`, `active`, `address`, `created_date`, `email`, `full_name`, `identification`, `password_hash`, `phone`, `updated_date`, `id_role`) VALUES
(1, b'1', 'Av. Solano 12-34 y Av. 12 de Abril', '2024-01-15 08:30:00', 'admin@ucacue.com', 'Carlos Mendoza Pérez', '0102345678', '$2a$10$xyzABCD1234567890', '0987654321', '2024-01-15 08:30:00', 1),
(2, b'1', 'Calle Larga 45-67', '2024-01-20 09:00:00', 'maria.torres@ucacue.com', 'María Torres Sánchez', '0103456789', '$2a$10$xyzABCD1234567891', '0987654322', '2024-01-20 09:00:00', 2),
(3, b'1', 'Av. Remigio Crespo 78-90', '2024-02-01 10:00:00', 'juan.garcia@ucacue.com', 'Juan García Molina', '0104567890', '$2a$10$xyzABCD1234567892', '0987654323', '2024-02-01 10:00:00', 3),
(4, b'1', 'Calle Borrero 23-45', '2024-02-10 11:00:00', 'ana.lopez@ucacue.com', 'Ana López Vega', '0105678901', '$2a$10$xyzABCD1234567893', '0987654324', '2024-02-10 11:00:00', 4),
(5, b'1', 'Av. Huayna Capac 56-78', '2024-02-15 12:00:00', 'pedro.ramirez@ucacue.com', 'Pedro Ramírez Castro', '0106789012', '$2a$10$xyzABCD1234567894', '0987654325', '2024-02-15 12:00:00', 5);

-- =====================================================
-- 3. PROVEEDORES
-- =====================================================
INSERT INTO `app_supplier` (`id_supplier`, `active`, `address`, `created_date`, `email`, `name`, `phone`, `updated_date`) VALUES
(1, b'1', 'Parque Industrial, Cuenca', '2024-01-10 08:00:00', 'ventas@distribuidorasanmiguel.com', 'Distribuidora San Miguel', '0723456789', '2024-01-10 08:00:00'),
(2, b'1', 'Av. de las Américas, Cuenca', '2024-01-12 09:00:00', 'contacto@lacteoseloro.com', 'Lácteos El Oro', '0723456790', '2024-01-12 09:00:00'),
(3, b'1', 'Sector El Arenal, Cuenca', '2024-01-15 10:00:00', 'info@carnesdelaustro.com', 'Cárnicas del Austro', '0723456791', '2024-01-15 10:00:00'),
(4, b'1', 'Mercado 10 de Agosto, Cuenca', '2024-01-18 11:00:00', 'ventas@verdurasfrescas.com', 'Verduras Frescas Hnos.', '0723456792', '2024-01-18 11:00:00'),
(5, b'1', 'Av. España, Cuenca', '2024-01-20 12:00:00', 'pedidos@bebidaspremium.com', 'Bebidas Premium Cía.', '0723456793', '2024-01-20 12:00:00');

-- =====================================================
-- 4. CATEGORÍAS DE CONSUMIBLES (Inventario)
-- =====================================================
INSERT INTO `app_category_consumable` (`id_category_consumable`, `active`, `created_date`, `description`, `name`, `updated_date`) VALUES
(1, b'1', '2024-01-15 08:00:00', 'Carnes rojas, blancas y embutidos', 'Carnes y Embutidos', '2024-01-15 08:00:00'),
(2, b'1', '2024-01-15 08:00:00', 'Verduras y hortalizas frescas', 'Verduras', '2024-01-15 08:00:00'),
(3, b'1', '2024-01-15 08:00:00', 'Lácteos y derivados', 'Lácteos', '2024-01-15 08:00:00'),
(4, b'1', '2024-01-15 08:00:00', 'Granos, harinas y cereales', 'Granos y Cereales', '2024-01-15 08:00:00'),
(5, b'1', '2024-01-15 08:00:00', 'Condimentos, salsas y especias', 'Condimentos', '2024-01-15 08:00:00'),
(6, b'1', '2024-01-15 08:00:00', 'Aceites y grasas comestibles', 'Aceites', '2024-01-15 08:00:00'),
(7, b'1', '2024-01-15 08:00:00', 'Bebidas alcohólicas y no alcohólicas', 'Bebidas', '2024-01-15 08:00:00');

-- =====================================================
-- 5. CONSUMIBLES (Inventario)
-- =====================================================
INSERT INTO `app_consumable` (`id_consumable`, `active`, `code`, `created_date`, `current_stock`, `description`, `discount`, `image_url`, `maximum_stock`, `minimum_stock`, `name`, `purchase_price`, `sale_price`, `updated_date`, `id_category_consumable`) VALUES
-- Carnes
(1, b'1', 'CONS-001', '2024-01-20 08:00:00', 45, 'Pechuga de pollo fresca sin hueso', 0.00, '/images/consumables/pollo.jpg', 100, 20, 'Pechuga de Pollo', 3.50, 5.25, '2024-10-10 10:00:00', 1),
(2, b'1', 'CONS-002', '2024-01-20 08:00:00', 30, 'Carne de res molida premium', 0.00, '/images/consumables/carne-molida.jpg', 80, 15, 'Carne Molida de Res', 4.00, 6.50, '2024-10-10 10:00:00', 1),
(3, b'1', 'CONS-003', '2024-01-20 08:00:00', 25, 'Chorizo criollo artesanal', 0.00, '/images/consumables/chorizo.jpg', 60, 10, 'Chorizo Criollo', 3.20, 5.00, '2024-10-10 10:00:00', 1),
(4, b'1', 'CONS-004', '2024-01-20 08:00:00', 20, 'Tocino ahumado en lonchas', 0.00, '/images/consumables/tocino.jpg', 50, 10, 'Tocino Ahumado', 4.50, 7.00, '2024-10-10 10:00:00', 1),

-- Verduras
(5, b'1', 'CONS-005', '2024-01-20 08:00:00', 50, 'Tomate riñón fresco', 0.00, '/images/consumables/tomate.jpg', 100, 20, 'Tomate Riñón', 0.80, 1.50, '2024-10-10 10:00:00', 2),
(6, b'1', 'CONS-006', '2024-01-20 08:00:00', 40, 'Cebolla perla blanca', 0.00, '/images/consumables/cebolla.jpg', 80, 15, 'Cebolla Perla', 0.60, 1.20, '2024-10-10 10:00:00', 2),
(7, b'1', 'CONS-007', '2024-01-20 08:00:00', 35, 'Pimiento verde fresco', 0.00, '/images/consumables/pimiento.jpg', 70, 15, 'Pimiento Verde', 1.00, 1.80, '2024-10-10 10:00:00', 2),
(8, b'1', 'CONS-008', '2024-01-20 08:00:00', 30, 'Lechuga crespa', 0.00, '/images/consumables/lechuga.jpg', 60, 10, 'Lechuga Crespa', 0.50, 1.00, '2024-10-10 10:00:00', 2),

-- Lácteos
(9, b'1', 'CONS-009', '2024-01-20 08:00:00', 60, 'Queso mozzarella para pizza', 0.00, '/images/consumables/mozzarella.jpg', 120, 25, 'Queso Mozzarella', 5.00, 8.00, '2024-10-10 10:00:00', 3),
(10, b'1', 'CONS-010', '2024-01-20 08:00:00', 40, 'Queso crema Philadelphia', 0.00, '/images/consumables/queso-crema.jpg', 80, 20, 'Queso Crema', 3.50, 5.50, '2024-10-10 10:00:00', 3),
(11, b'1', 'CONS-011', '2024-01-20 08:00:00', 70, 'Mantequilla sin sal', 0.00, '/images/consumables/mantequilla.jpg', 120, 30, 'Mantequilla', 2.80, 4.50, '2024-10-10 10:00:00', 3),

-- Granos y Cereales
(12, b'1', 'CONS-012', '2024-01-20 08:00:00', 100, 'Arroz blanco de grano largo', 0.00, '/images/consumables/arroz.jpg', 200, 40, 'Arroz Blanco', 1.20, 2.00, '2024-10-10 10:00:00', 4),
(13, b'1', 'CONS-013', '2024-01-20 08:00:00', 80, 'Harina de trigo todo uso', 0.00, '/images/consumables/harina.jpg', 150, 30, 'Harina de Trigo', 1.00, 1.80, '2024-10-10 10:00:00', 4),
(14, b'1', 'CONS-014', '2024-01-20 08:00:00', 50, 'Pasta espagueti', 0.00, '/images/consumables/pasta.jpg', 100, 20, 'Pasta Espagueti', 1.50, 2.50, '2024-10-10 10:00:00', 4),

-- Condimentos
(15, b'1', 'CONS-015', '2024-01-20 08:00:00', 45, 'Sal de mesa refinada', 0.00, '/images/consumables/sal.jpg', 80, 20, 'Sal Refinada', 0.40, 0.80, '2024-10-10 10:00:00', 5),
(16, b'1', 'CONS-016', '2024-01-20 08:00:00', 30, 'Salsa de tomate Heinz', 0.00, '/images/consumables/ketchup.jpg', 60, 15, 'Salsa de Tomate', 2.50, 4.00, '2024-10-10 10:00:00', 5),
(17, b'1', 'CONS-017', '2024-01-20 08:00:00', 25, 'Mayonesa tradicional', 0.00, '/images/consumables/mayonesa.jpg', 50, 12, 'Mayonesa', 2.80, 4.50, '2024-10-10 10:00:00', 5),

-- Aceites
(18, b'1', 'CONS-018', '2024-01-20 08:00:00', 40, 'Aceite de girasol', 0.00, '/images/consumables/aceite.jpg', 80, 20, 'Aceite de Girasol', 3.00, 5.00, '2024-10-10 10:00:00', 6),

-- Bebidas
(19, b'1', 'CONS-019', '2024-01-20 08:00:00', 120, 'Coca Cola 2 litros', 0.00, '/images/consumables/coca-cola.jpg', 200, 50, 'Coca Cola 2L', 1.80, 3.00, '2024-10-10 10:00:00', 7),
(20, b'1', 'CONS-020', '2024-01-20 08:00:00', 100, 'Agua mineral sin gas', 0.00, '/images/consumables/agua.jpg', 180, 40, 'Agua Mineral', 0.40, 0.80, '2024-10-10 10:00:00', 7);

-- =====================================================
-- 6. CATEGORÍAS DE PRODUCTOS (Menú)
-- =====================================================
INSERT INTO `app_category` (`id_category`, `active`, `created_date`, `description`, `name`, `updated_date`) VALUES
(1, b'1', '2024-01-15 08:00:00', 'Ingredientes principales para preparación', 'Ingredientes Base', '2024-01-15 08:00:00'),
(2, b'1', '2024-01-15 08:00:00', 'Proteínas procesadas', 'Proteínas', '2024-01-15 08:00:00'),
(3, b'1', '2024-01-15 08:00:00', 'Guarniciones y acompañamientos', 'Guarniciones', '2024-01-15 08:00:00');

-- =====================================================
-- 7. PRODUCTOS (Ingredientes para Recetas)
-- =====================================================
INSERT INTO `app_product` (`id_product`, `active`, `code`, `created_date`, `description`, `image_url`, `name`, `purchase_price`, `updated_date`, `id_category`) VALUES
(1, b'1', 'PROD-001', '2024-02-01 08:00:00', 'Pollo cortado en cuadritos', '/images/products/pollo-cubos.jpg', 'Pollo en Cubos', 3.50, '2024-02-01 08:00:00', 2),
(2, b'1', 'PROD-002', '2024-02-01 08:00:00', 'Carne de res preparada', '/images/products/carne-res.jpg', 'Carne de Res Preparada', 4.00, '2024-02-01 08:00:00', 2),
(3, b'1', 'PROD-003', '2024-02-01 08:00:00', 'Mix de verduras salteadas', '/images/products/mix-verduras.jpg', 'Mix de Verduras', 2.50, '2024-02-01 08:00:00', 3),
(4, b'1', 'PROD-004', '2024-02-01 08:00:00', 'Arroz blanco cocido', '/images/products/arroz-cocido.jpg', 'Arroz Cocido', 1.20, '2024-02-01 08:00:00', 3),
(5, b'1', 'PROD-005', '2024-02-01 08:00:00', 'Papas fritas caseras', '/images/products/papas-fritas.jpg', 'Papas Fritas', 1.80, '2024-02-01 08:00:00', 3);

-- =====================================================
-- 8. CATEGORÍAS DE PRODUCTOS PARA VENTA (Menú del Restaurante)
-- =====================================================
INSERT INTO `app_category_sale` (`id_category_sale`, `active`, `created_date`, `description`, `name`, `updated_date`) VALUES
(1, b'1', '2024-02-01 08:00:00', 'Platos principales del menú', 'Platos Fuertes', '2024-02-01 08:00:00'),
(2, b'1', '2024-02-01 08:00:00', 'Entradas y aperitivos', 'Entradas', '2024-02-01 08:00:00'),
(3, b'1', '2024-02-01 08:00:00', 'Postres y dulces', 'Postres', '2024-02-01 08:00:00'),
(4, b'1', '2024-02-01 08:00:00', 'Bebidas frías y calientes', 'Bebidas', '2024-02-01 08:00:00'),
(5, b'1', '2024-02-01 08:00:00', 'Pizzas artesanales', 'Pizzas', '2024-02-01 08:00:00'),
(6, b'1', '2024-02-01 08:00:00', 'Hamburguesas gourmet', 'Hamburguesas', '2024-02-01 08:00:00');

-- =====================================================
-- 9. PRODUCTOS PARA VENTA (Menú Final)
-- =====================================================
INSERT INTO `app_product_sale` (`id_product_sale`, `active`, `code`, `created_date`, `description`, `discount`, `image_url`, `name`, `sale_price`, `status`, `stock`, `updated_date`, `id_category_sale`) VALUES
-- Platos Fuertes
(1, b'1', 'MENU-001', '2024-02-05 08:00:00', 'Arroz con pollo al estilo casero con ensalada', 0.00, '/images/menu/arroz-pollo.jpg', 'Arroz con Pollo', 8.50, 'AVAILABLE', 100, '2024-10-10 12:00:00', 1),
(2, b'1', 'MENU-002', '2024-02-05 08:00:00', 'Seco de carne con arroz y maduro', 0.00, '/images/menu/seco-carne.jpg', 'Seco de Carne', 9.00, 'AVAILABLE', 100, '2024-10-10 12:00:00', 1),
(3, b'1', 'MENU-003', '2024-02-05 08:00:00', 'Lomo saltado con papas fritas', 1.00, '/images/menu/lomo-saltado.jpg', 'Lomo Saltado', 10.50, 'AVAILABLE', 100, '2024-10-10 12:00:00', 1),
(4, b'1', 'MENU-004', '2024-02-05 08:00:00', 'Chaulafán mixto especial de la casa', 0.00, '/images/menu/chaulafan.jpg', 'Chaulafán Mixto', 9.50, 'AVAILABLE', 100, '2024-10-10 12:00:00', 1),

-- Entradas
(5, b'1', 'MENU-005', '2024-02-05 08:00:00', 'Alitas de pollo BBQ con salsa ranch', 0.50, '/images/menu/alitas.jpg', 'Alitas BBQ', 6.50, 'AVAILABLE', 100, '2024-10-10 12:00:00', 2),
(6, b'1', 'MENU-006', '2024-02-05 08:00:00', 'Dedos de queso empanizados', 0.00, '/images/menu/dedos-queso.jpg', 'Dedos de Queso', 5.00, 'AVAILABLE', 100, '2024-10-10 12:00:00', 2),
(7, b'1', 'MENU-007', '2024-02-05 08:00:00', 'Ensalada César con pollo', 0.00, '/images/menu/ensalada-cesar.jpg', 'Ensalada César', 7.00, 'AVAILABLE', 100, '2024-10-10 12:00:00', 2),

-- Pizzas
(8, b'1', 'MENU-008', '2024-02-05 08:00:00', 'Pizza con jamón, queso y champiñones', 2.00, '/images/menu/pizza-hawaiana.jpg', 'Pizza Hawaiana', 12.00, 'AVAILABLE', 50, '2024-10-10 12:00:00', 5),
(9, b'1', 'MENU-009', '2024-02-05 08:00:00', 'Pizza con pepperoni y extra queso', 0.00, '/images/menu/pizza-pepperoni.jpg', 'Pizza Pepperoni', 13.50, 'AVAILABLE', 50, '2024-10-10 12:00:00', 5),
(10, b'1', 'MENU-010', '2024-02-05 08:00:00', 'Pizza 4 quesos gourmet', 0.00, '/images/menu/pizza-quesos.jpg', 'Pizza 4 Quesos', 14.00, 'AVAILABLE', 50, '2024-10-10 12:00:00', 5),

-- Hamburguesas
(11, b'1', 'MENU-011', '2024-02-05 08:00:00', 'Hamburguesa clásica con papas fritas', 0.00, '/images/menu/hamburguesa-clasica.jpg', 'Hamburguesa Clásica', 7.50, 'AVAILABLE', 80, '2024-10-10 12:00:00', 6),
(12, b'1', 'MENU-012', '2024-02-05 08:00:00', 'Doble carne, tocino y queso cheddar', 1.50, '/images/menu/hamburguesa-premium.jpg', 'Hamburguesa Premium', 10.00, 'AVAILABLE', 80, '2024-10-10 12:00:00', 6),

-- Postres
(13, b'1', 'MENU-013', '2024-02-05 08:00:00', 'Tres leches casero', 0.00, '/images/menu/tres-leches.jpg', 'Tres Leches', 4.50, 'AVAILABLE', 30, '2024-10-10 12:00:00', 3),
(14, b'1', 'MENU-014', '2024-02-05 08:00:00', 'Helado de chocolate con brownies', 0.00, '/images/menu/helado-brownie.jpg', 'Helado con Brownie', 5.00, 'AVAILABLE', 30, '2024-10-10 12:00:00', 3),

-- Bebidas
(15, b'1', 'MENU-015', '2024-02-05 08:00:00', 'Jugo natural de naranja', 0.00, '/images/menu/jugo-naranja.jpg', 'Jugo de Naranja', 2.50, 'AVAILABLE', 200, '2024-10-10 12:00:00', 4),
(16, b'1', 'MENU-016', '2024-02-05 08:00:00', 'Gaseosa 500ml', 0.00, '/images/menu/gaseosa.jpg', 'Gaseosa', 1.50, 'AVAILABLE', 200, '2024-10-10 12:00:00', 4),
(17, b'1', 'MENU-017', '2024-02-05 08:00:00', 'Limonada frozen', 0.00, '/images/menu/limonada.jpg', 'Limonada Frozen', 3.00, 'AVAILABLE', 200, '2024-10-10 12:00:00', 4),
(18, b'1', 'MENU-018', '2024-02-05 08:00:00', 'Café americano', 0.00, '/images/menu/cafe.jpg', 'Café Americano', 2.00, 'AVAILABLE', 200, '2024-10-10 12:00:00', 4);

-- =====================================================
-- 10. RECETAS (Relación Productos - Productos Venta)
-- =====================================================
INSERT INTO `app_recipe` (`id_recipe`, `created_date`, `notes`, `quantity`, `unit`, `updated_date`, `id_product`, `id_product_sale`) VALUES
-- Arroz con Pollo
(1, '2024-02-10 08:00:00', 'Porción estándar', 0.25, 'kg', '2024-02-10 08:00:00', 1, 1),
(2, '2024-02-10 08:00:00', 'Porción estándar', 0.20, 'kg', '2024-02-10 08:00:00', 4, 1),
(3, '2024-02-10 08:00:00', 'Porción guarnición', 0.10, 'kg', '2024-02-10 08:00:00', 3, 1),

-- Lomo Saltado
(4, '2024-02-10 08:00:00', 'Porción generosa', 0.30, 'kg', '2024-02-10 08:00:00', 2, 3),
(5, '2024-02-10 08:00:00', 'Acompañamiento', 0.15, 'kg', '2024-02-10 08:00:00', 5, 3),
(6, '2024-02-10 08:00:00', 'Mix de verduras', 0.12, 'kg', '2024-02-10 08:00:00', 3, 3),

-- Pizza Hawaiana
(7, '2024-02-10 08:00:00', 'Base de la pizza', 0.35, 'kg', '2024-02-10 08:00:00', 1, 8),

-- Hamburguesa Premium
(8, '2024-02-10 08:00:00', 'Carne principal', 0.25, 'kg', '2024-02-10 08:00:00', 2, 12),
(9, '2024-02-10 08:00:00', 'Acompañamiento', 0.15, 'kg', '2024-02-10 08:00:00', 5, 12);

-- =====================================================
-- 11. ÓRDENES DE COMPRA
-- =====================================================
INSERT INTO `app_purchase_order` (`id_purchase_order`, `code`, `issue_date`, `notes`, `status`, `subtotal`, `taxes`, `total`, `id_supplier`) VALUES
(1, 'OC-2024-001', '2024-09-15 09:00:00', 'Pedido quincenal de carnes', 'RECEIVED', 250.00, 30.00, 280.00, 3),
(2, 'OC-2024-002', '2024-09-20 10:00:00', 'Reposición de verduras frescas', 'RECEIVED', 120.00, 14.40, 134.40, 4),
(3, 'OC-2024-003', '2024-10-01 08:30:00', 'Pedido mensual de lácteos', 'APPROVED', 180.00, 21.60, 201.60, 2),
(4, 'OC-2024-004', '2024-10-05 11:00:00', 'Bebidas y gaseosas', 'PENDING', 200.00, 24.00, 224.00, 5),
(5, 'OC-2024-005', '2024-10-10 09:15:00', 'Pedido urgente - Stock bajo', 'APPROVED', 150.00, 18.00, 168.00, 1);

-- =====================================================
-- 12. DETALLES DE ÓRDENES DE COMPRA
-- =====================================================
INSERT INTO `app_purchase_order_detail` (`id_purchase_order_detail`, `quantity`, `subtotal`, `unit_price`, `id_consumable`, `id_purchase_order`) VALUES
-- OC-2024-001 (Carnes)
(1, 20, 70.00, 3.50, 1, 1),  -- Pechuga de pollo
(2, 15, 60.00, 4.00, 2, 1),  -- Carne molida
(3, 20, 64.00, 3.20, 3, 1),  -- Chorizo
(4, 12, 54.00, 4.50, 4, 1),  -- Tocino

-- OC-2024-002 (Verduras)
(5, 30, 24.00, 0.80, 5, 2),  -- Tomate
(6, 25, 15.00, 0.60, 6, 2),  -- Cebolla
(7, 20, 20.00, 1.00, 7, 2),  -- Pimiento
(8, 40, 20.00, 0.50, 8, 2),  -- Lechuga

-- OC-2024-003 (Lácteos)
(9, 20, 100.00, 5.00, 9, 3),   -- Mozzarella
(10, 15, 52.50, 3.50, 10, 3),  -- Queso crema
(11, 10, 28.00, 2.80, 11, 3),  -- Mantequilla

-- OC-2024-004 (Bebidas)
(12, 60, 108.00, 1.80, 19, 4),  -- Coca Cola
(13, 80, 32.00, 0.40, 20, 4),   -- Agua mineral

-- OC-2024-005 (Granos y Aceites)
(14, 50, 60.00, 1.20, 12, 5),  -- Arroz
(15, 30, 30.00, 1.00, 13, 5),  -- Harina
(16, 20, 60.00, 3.00, 18, 5);  -- Aceite

-- =====================================================
-- 13. VENTAS
-- =====================================================
INSERT INTO `app_sale` (`id_sale`, `created_date`, `discount`, `notes`, `order_type`, `payment_method`, `status`, `subtotal`, `total`, `updated_date`) VALUES
-- Septiembre 2024
(1, '2024-09-25 12:30:00', 0.00, 'Mesa 5 - Almuerzo familiar', 'TABLE', 'CASH', 'DELIVERED', 45.50, 45.50, '2024-09-25 13:15:00'),
(2, '2024-09-25 13:45:00', 2.00, 'Para llevar - Cliente frecuente', 'CARRY', 'TRANSFER', 'DELIVERED', 28.00, 26.00, '2024-09-25 14:00:00'),
(3, '2024-09-26 19:20:00', 0.00, 'Mesa 2 - Cena romántica', 'TABLE', 'CASH', 'DELIVERED', 52.00, 52.00, '2024-09-26 20:30:00'),
(4, '2024-09-27 12:00:00', 0.00, 'Mesa 8 - Almuerzo ejecutivo', 'TABLE', 'TRANSFER', 'DELIVERED', 35.50, 35.50, '2024-09-27 12:45:00'),
(5, '2024-09-28 14:30:00', 3.00, 'Para llevar - Pedido grande', 'CARRY', 'CASH', 'DELIVERED', 68.00, 65.00, '2024-09-28 15:00:00'),

-- Octubre 2024
(6, '2024-10-01 12:15:00', 0.00, 'Mesa 3 - Almuerzo', 'TABLE', 'CASH', 'DELIVERED', 42.00, 42.00, '2024-10-01 13:00:00'),
(7, '2024-10-02 13:30:00', 1.50, 'Mesa 7 - Descuento cumpleaños', 'TABLE', 'TRANSFER', 'DELIVERED', 56.50, 55.00, '2024-10-02 14:30:00'),
(8, '2024-10-03 18:45:00', 0.00, 'Para llevar', 'CARRY', 'CASH', 'DELIVERED', 25.00, 25.00, '2024-10-03 19:00:00'),
(9, '2024-10-04 20:00:00', 0.00, 'Mesa 1 - Cena', 'TABLE', 'TRANSFER', 'DELIVERED', 48.50, 48.50, '2024-10-04 21:15:00'),
(10, '2024-10-05 12:30:00', 0.00, 'Mesa 6 - Almuerzo familiar', 'TABLE', 'CASH', 'DELIVERED', 72.00, 72.00, '2024-10-05 13:45:00'),
(11, '2024-10-06 14:00:00', 2.50, 'Para llevar - Promoción', 'CARRY', 'TRANSFER', 'DELIVERED', 32.50, 30.00, '2024-10-06 14:20:00'),
(12, '2024-10-07 19:30:00', 0.00, 'Mesa 4 - Cena', 'TABLE', 'CASH', 'DELIVERED', 38.00, 38.00, '2024-10-07 20:30:00'),
(13, '2024-10-08 12:00:00', 0.00, 'Mesa 9 - Almuerzo ejecutivo', 'TABLE', 'TRANSFER', 'DELIVERED', 29.00, 29.00, '2024-10-08 12:50:00'),
(14, '2024-10-09 13:15:00', 0.00, 'Para llevar', 'CARRY', 'CASH', 'DELIVERED', 21.50, 21.50, '2024-10-09 13:30:00'),
(15, '2024-10-10 18:00:00', 0.00, 'Mesa 2 - Cena especial', 'TABLE', 'TRANSFER', 'DELIVERED', 64.00, 64.00, '2024-10-10 19:30:00'),
(16, '2024-10-11 12:45:00', 1.00, 'Mesa 5 - Cliente frecuente', 'TABLE', 'CASH', 'DELIVERED', 41.00, 40.00, '2024-10-11 13:40:00'),
(17, '2024-10-12 14:30:00', 0.00, 'Para llevar - Pedido múltiple', 'CARRY', 'TRANSFER', 'DELIVERED', 55.50, 55.50, '2024-10-12 15:00:00'),
(18, '2024-10-13 19:00:00', 0.00, 'Mesa 8 - Cena', 'TABLE', 'CASH', 'DELIVERED', 33.00, 33.00, '2024-10-13 20:00:00'),
(19, '2024-10-14 12:20:00', 0.00, 'Mesa 3 - Almuerzo', 'TABLE', 'TRANSFER', 'DELIVERED', 36.50, 36.50, '2024-10-14 13:10:00'),
(20, '2024-10-15 13:00:00', 0.00, 'Mesa 1 - En proceso', 'TABLE', 'CASH', 'PENDING', 28.00, 28.00, '2024-10-15 13:00:00');

-- =====================================================
-- 14. DETALLES DE VENTAS
-- =====================================================
INSERT INTO `app_sale_detail` (`id_detail`, `created_date`, `quantity`, `subtotal`, `unit_price`, `updated_date`, `id_product_sale`, `id_sale`) VALUES
-- Venta 1 (Mesa 5 - Familiar)
(1, '2024-09-25 12:30:00', 2, 17.00, 8.50, '2024-09-25 12:30:00', 1, 1),   -- 2 Arroz con pollo
(2, '2024-09-25 12:30:00', 1, 10.50, 10.50, '2024-09-25 12:30:00', 3, 1),  -- 1 Lomo saltado
(3, '2024-09-25 12:30:00', 1, 13.50, 13.50, '2024-09-25 12:30:00', 9, 1),  -- 1 Pizza pepperoni
(4, '2024-09-25 12:30:00', 2, 5.00, 2.50, '2024-09-25 12:30:00', 15, 1),   -- 2 Jugos naranja

-- Venta 2 (Para llevar)
(5, '2024-09-25 13:45:00', 2, 20.00, 10.00, '2024-09-25 13:45:00', 12, 2), -- 2 Hamburguesas premium
(6, '2024-09-25 13:45:00', 2, 6.00, 3.00, '2024-09-25 13:45:00', 17, 2),   -- 2 Limonadas
(7, '2024-09-25 13:45:00', 1, 2.00, 2.00, '2024-09-25 13:45:00', 18, 2),   -- 1 Café

-- Venta 3 (Mesa 2 - Cena romántica)
(8, '2024-09-26 19:20:00', 2, 28.00, 14.00, '2024-09-26 19:20:00', 10, 3), -- 2 Pizza 4 quesos
(9, '2024-09-26 19:20:00', 2, 14.00, 7.00, '2024-09-26 19:20:00', 7, 3),   -- 2 Ensaladas césar
(10, '2024-09-26 19:20:00', 2, 10.00, 5.00, '2024-09-26 19:20:00', 14, 3), -- 2 Helados brownie

-- Venta 4 (Mesa 8 - Ejecutivo)
(11, '2024-09-27 12:00:00', 2, 18.00, 9.00, '2024-09-27 12:00:00', 2, 4),  -- 2 Seco de carne
(12, '2024-09-27 12:00:00', 2, 13.00, 6.50, '2024-09-27 12:00:00', 5, 4),  -- 2 Alitas BBQ
(13, '2024-09-27 12:00:00', 2, 4.50, 2.25, '2024-09-27 12:00:00', 15, 4),  -- 2 Jugos (con descuento receta)

-- Venta 5 (Para llevar - Pedido grande)
(14, '2024-09-28 14:30:00', 3, 25.50, 8.50, '2024-09-28 14:30:00', 1, 5),  -- 3 Arroz con pollo
(15, '2024-09-28 14:30:00', 2, 19.00, 9.50, '2024-09-28 14:30:00', 4, 5),  -- 2 Chaulafán
(16, '2024-09-28 14:30:00', 3, 22.50, 7.50, '2024-09-28 14:30:00', 11, 5), -- 3 Hamburguesas clásicas
(17, '2024-09-28 14:30:00', 1, 1.00, 1.00, '2024-09-28 14:30:00', 16, 5),  -- 1 Gaseosa

-- Venta 6 (Mesa 3)
(18, '2024-10-01 12:15:00', 2, 24.00, 12.00, '2024-10-01 12:15:00', 8, 6), -- 2 Pizza hawaiana
(19, '2024-10-01 12:15:00', 2, 13.00, 6.50, '2024-10-01 12:15:00', 5, 6),  -- 2 Alitas
(20, '2024-10-01 12:15:00', 2, 5.00, 2.50, '2024-10-01 12:15:00', 15, 6),  -- 2 Jugos

-- Venta 7 (Mesa 7 - Cumpleaños)
(21, '2024-10-02 13:30:00', 2, 21.00, 10.50, '2024-10-02 13:30:00', 3, 7), -- 2 Lomo saltado
(22, '2024-10-02 13:30:00', 3, 27.00, 9.00, '2024-10-02 13:30:00', 2, 7),  -- 3 Seco de carne
(23, '2024-10-02 13:30:00', 2, 9.00, 4.50, '2024-10-02 13:30:00', 13, 7),  -- 2 Tres leches

-- Venta 8 (Para llevar)
(24, '2024-10-03 18:45:00', 2, 15.00, 7.50, '2024-10-03 18:45:00', 11, 8), -- 2 Hamburguesas
(25, '2024-10-03 18:45:00', 1, 10.00, 10.00, '2024-10-03 18:45:00', 12, 8), -- 1 Hamburguesa premium

-- Venta 9 (Mesa 1 - Cena)
(26, '2024-10-04 20:00:00', 1, 13.50, 13.50, '2024-10-04 20:00:00', 9, 9), -- 1 Pizza pepperoni
(27, '2024-10-04 20:00:00', 1, 14.00, 14.00, '2024-10-04 20:00:00', 10, 9), -- 1 Pizza 4 quesos
(28, '2024-10-04 20:00:00', 2, 14.00, 7.00, '2024-10-04 20:00:00', 7, 9),   -- 2 Ensaladas
(29, '2024-10-04 20:00:00', 2, 7.00, 3.50, '2024-10-04 20:00:00', 17, 9),   -- 2 Limonadas

-- Venta 10 (Mesa 6 - Familiar grande)
(30, '2024-10-05 12:30:00', 4, 34.00, 8.50, '2024-10-05 12:30:00', 1, 10),  -- 4 Arroz con pollo
(31, '2024-10-05 12:30:00', 2, 19.00, 9.50, '2024-10-05 12:30:00', 4, 10),  -- 2 Chaulafán
(32, '2024-10-05 12:30:00', 3, 13.50, 4.50, '2024-10-05 12:30:00', 13, 10), -- 3 Tres leches
(33, '2024-10-05 12:30:00', 3, 4.50, 1.50, '2024-10-05 12:30:00', 16, 10),  -- 3 Gaseosas

-- Venta 11 (Para llevar)
(34, '2024-10-06 14:00:00', 2, 20.00, 10.00, '2024-10-06 14:00:00', 12, 11), -- 2 Hamburguesas premium
(35, '2024-10-06 14:00:00', 2, 13.00, 6.50, '2024-10-06 14:00:00', 5, 11),   -- 2 Alitas

-- Venta 12 (Mesa 4)
(36, '2024-10-07 19:30:00', 2, 27.00, 13.50, '2024-10-07 19:30:00', 9, 12), -- 2 Pizza pepperoni
(37, '2024-10-07 19:30:00', 2, 10.00, 5.00, '2024-10-07 19:30:00', 6, 12),  -- 2 Dedos queso
(38, '2024-10-07 19:30:00', 1, 1.00, 1.00, '2024-10-07 19:30:00', 16, 12),  -- 1 Gaseosa

-- Venta 13 (Mesa 9 - Ejecutivo)
(39, '2024-10-08 12:00:00', 2, 21.00, 10.50, '2024-10-08 12:00:00', 3, 13), -- 2 Lomo saltado
(40, '2024-10-08 12:00:00', 2, 5.00, 2.50, '2024-10-08 12:00:00', 15, 13),  -- 2 Jugos
(41, '2024-10-08 12:00:00', 2, 3.00, 1.50, '2024-10-08 12:00:00', 16, 13),  -- 2 Gaseosas

-- Venta 14 (Para llevar)
(42, '2024-10-09 13:15:00', 1, 9.50, 9.50, '2024-10-09 13:15:00', 4, 14),   -- 1 Chaulafán
(43, '2024-10-09 13:15:00', 1, 12.00, 12.00, '2024-10-09 13:15:00', 8, 14), -- 1 Pizza hawaiana

-- Venta 15 (Mesa 2 - Especial)
(44, '2024-10-10 18:00:00', 2, 28.00, 14.00, '2024-10-10 18:00:00', 10, 15), -- 2 Pizza 4 quesos
(45, '2024-10-10 18:00:00', 2, 20.00, 10.00, '2024-10-10 18:00:00', 12, 15), -- 2 Hamburguesas premium
(46, '2024-10-10 18:00:00', 2, 10.00, 5.00, '2024-10-10 18:00:00', 14, 15),  -- 2 Helados
(47, '2024-10-10 18:00:00', 2, 6.00, 3.00, '2024-10-10 18:00:00', 17, 15),   -- 2 Limonadas

-- Venta 16 (Mesa 5)
(48, '2024-10-11 12:45:00', 3, 25.50, 8.50, '2024-10-11 12:45:00', 1, 16),  -- 3 Arroz con pollo
(49, '2024-10-11 12:45:00', 2, 13.00, 6.50, '2024-10-11 12:45:00', 5, 16),  -- 2 Alitas
(50, '2024-10-11 12:45:00', 2, 3.00, 1.50, '2024-10-11 12:45:00', 16, 16),  -- 2 Gaseosas

-- Venta 17 (Para llevar - Múltiple)
(51, '2024-10-12 14:30:00', 3, 22.50, 7.50, '2024-10-12 14:30:00', 11, 17), -- 3 Hamburguesas
(52, '2024-10-12 14:30:00', 2, 27.00, 13.50, '2024-10-12 14:30:00', 9, 17), -- 2 Pizza pepperoni
(53, '2024-10-12 14:30:00', 2, 6.00, 3.00, '2024-10-12 14:30:00', 17, 17),  -- 2 Limonadas

-- Venta 18 (Mesa 8)
(54, '2024-10-13 19:00:00', 2, 18.00, 9.00, '2024-10-13 19:00:00', 2, 18),  -- 2 Seco de carne
(55, '2024-10-13 19:00:00', 2, 15.00, 7.50, '2024-10-13 19:00:00', 11, 18), -- 2 Hamburguesas

-- Venta 19 (Mesa 3)
(56, '2024-10-14 12:20:00', 2, 19.00, 9.50, '2024-10-14 12:20:00', 4, 19),  -- 2 Chaulafán
(57, '2024-10-14 12:20:00', 2, 13.00, 6.50, '2024-10-14 12:20:00', 5, 19),  -- 2 Alitas
(58, '2024-10-14 12:20:00', 2, 4.50, 2.25, '2024-10-14 12:20:00', 15, 19),  -- 2 Jugos

-- Venta 20 (Mesa 1 - En proceso)
(59, '2024-10-15 13:00:00', 2, 17.00, 8.50, '2024-10-15 13:00:00', 1, 20),  -- 2 Arroz con pollo
(60, '2024-10-15 13:00:00', 2, 10.00, 5.00, '2024-10-15 13:00:00', 6, 20),  -- 2 Dedos queso
(61, '2024-10-15 13:00:00', 1, 1.00, 1.00, '2024-10-15 13:00:00', 16, 20);  -- 1 Gaseosa

-- =====================================================
-- RESUMEN DE DATOS INSERTADOS
-- =====================================================
-- Roles: 5
-- Usuarios: 5
-- Proveedores: 5
-- Categorías Consumibles: 7
-- Consumibles (Inventario): 20
-- Categorías Productos: 3
-- Productos (Ingredientes): 5
-- Categorías Venta: 6
-- Productos Venta (Menú): 18
-- Recetas: 9
-- Órdenes de Compra: 5
-- Detalles OC: 16
-- Ventas: 20
-- Detalles Venta: 61
-- =====================================================