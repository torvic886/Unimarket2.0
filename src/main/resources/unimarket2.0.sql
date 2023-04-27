-- MySQL dump 10.13  Distrib 8.0.28, for macos11 (x86_64)
--
-- Host: localhost    Database: unimarket
-- ------------------------------------------------------
-- Server version	8.0.28

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `autorizacion`
--

DROP TABLE IF EXISTS `autorizacion`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `autorizacion` (
  `id_autorizacion` int NOT NULL,
  `estado` enum('PENDIENTE','APROBADA','RECHAZADA') DEFAULT NULL,
  `fecha_autorizacion` date DEFAULT NULL,
  `id_moderador` int NOT NULL,
  `id_producto` int NOT NULL,
  PRIMARY KEY (`id_autorizacion`),
  KEY `fk_moderador_autorizacion` (`id_moderador`),
  KEY `fk_producto_autorizacion` (`id_producto`),
  CONSTRAINT `fk_moderador_autorizacion` FOREIGN KEY (`id_moderador`) REFERENCES `moderador` (`id_moderador`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `fk_producto_autorizacion` FOREIGN KEY (`id_producto`) REFERENCES `producto` (`id_producto`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `autorizacion`
--

LOCK TABLES `autorizacion` WRITE;
/*!40000 ALTER TABLE `autorizacion` DISABLE KEYS */;
INSERT INTO `autorizacion` VALUES (1,'APROBADA','2023-03-30',1,1);
/*!40000 ALTER TABLE `autorizacion` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `carritocompra`
--

DROP TABLE IF EXISTS `carritocompra`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `carritocompra` (
  `id_carrito_compra` int NOT NULL AUTO_INCREMENT,
  `fecha_compra` datetime NOT NULL,
  `estado` enum('EN_PROCESO','COMPLETADO') NOT NULL DEFAULT 'EN_PROCESO',
  `id_usuario` int NOT NULL,
  PRIMARY KEY (`id_carrito_compra`),
  KEY `fk_usuario_carritoCompra` (`id_usuario`),
  CONSTRAINT `fk_usuario_carritoCompra` FOREIGN KEY (`id_usuario`) REFERENCES `usuario` (`id_usuario`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `carritocompra`
--

LOCK TABLES `carritocompra` WRITE;
/*!40000 ALTER TABLE `carritocompra` DISABLE KEYS */;
INSERT INTO `carritocompra` VALUES (1,'2023-03-30 00:00:00','COMPLETADO',1);
/*!40000 ALTER TABLE `carritocompra` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `categoria`
--

DROP TABLE IF EXISTS `categoria`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `categoria` (
  `id_categoria` int NOT NULL AUTO_INCREMENT,
  `nombre` varchar(120) DEFAULT NULL,
  `fecha_creacion` date DEFAULT NULL,
  `id_producto` int NOT NULL,
  PRIMARY KEY (`id_categoria`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `categoria`
--

LOCK TABLES `categoria` WRITE;
/*!40000 ALTER TABLE `categoria` DISABLE KEYS */;
INSERT INTO `categoria` VALUES (1,'Producto Limpieza Bebe','2023-03-30',0);
/*!40000 ALTER TABLE `categoria` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `comentario`
--

DROP TABLE IF EXISTS `comentario`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `comentario` (
  `id_comentario` int NOT NULL AUTO_INCREMENT,
  `comentario` varchar(120) DEFAULT NULL,
  `fecha_creacion` date DEFAULT NULL,
  `id_producto` int NOT NULL,
  `id_categoria` int DEFAULT NULL,
  `id_usuario` int DEFAULT NULL,
  PRIMARY KEY (`id_comentario`),
  KEY `fk_categoria_comentario` (`id_categoria`),
  KEY `fk_usuario_comentario` (`id_usuario`),
  CONSTRAINT `fk_categoria_comentario` FOREIGN KEY (`id_categoria`) REFERENCES `categoria` (`id_categoria`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `fk_usuario_comentario` FOREIGN KEY (`id_usuario`) REFERENCES `usuario` (`id_usuario`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `FKj1ykc9n3finwrt8psbd4n1u1x` FOREIGN KEY (`id_comentario`) REFERENCES `producto` (`id_producto`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `comentario`
--

LOCK TABLES `comentario` WRITE;
/*!40000 ALTER TABLE `comentario` DISABLE KEYS */;
INSERT INTO `comentario` VALUES (1,'Es un buen producto para el bebe','2023-03-30',1,1,1),(2,'Es un buen producto para mi niño','2023-03-30',1,1,1);
/*!40000 ALTER TABLE `comentario` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `compra`
--

DROP TABLE IF EXISTS `compra`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `compra` (
  `id_compra` int NOT NULL AUTO_INCREMENT,
  `fecha_compra` date NOT NULL,
  `total` decimal(10,2) NOT NULL,
  `estado` enum('CREADA','ENVIADA','ENTREGADA') NOT NULL,
  `metodo_pago` enum('TARJETA_CREDITO','TARJETA_DEBITO','EFECTIVO','TRANSFERENCIA_BANCARIA','PAYPAL','OTRO') DEFAULT NULL,
  `id_usuario` int NOT NULL,
  `id_carrito_compra` int NOT NULL,
  PRIMARY KEY (`id_compra`),
  KEY `fk_usuario_compra` (`id_usuario`),
  KEY `fk_carritoCompra_compra` (`id_carrito_compra`),
  CONSTRAINT `fk_carritoCompra_compra` FOREIGN KEY (`id_carrito_compra`) REFERENCES `carritocompra` (`id_carrito_compra`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `fk_usuario_compra` FOREIGN KEY (`id_usuario`) REFERENCES `usuario` (`id_usuario`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `compra`
--

LOCK TABLES `compra` WRITE;
/*!40000 ALTER TABLE `compra` DISABLE KEYS */;
INSERT INTO `compra` VALUES (1,'2023-03-30',30000.00,'CREADA','EFECTIVO',1,1);
/*!40000 ALTER TABLE `compra` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `detallecarrito`
--

DROP TABLE IF EXISTS `detallecarrito`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `detallecarrito` (
  `id_detalle_carrito` int NOT NULL AUTO_INCREMENT,
  `cantidad` int NOT NULL,
  `subtotal` decimal(10,2) NOT NULL,
  `id_carrito_compra` int NOT NULL,
  `id_producto` int NOT NULL,
  PRIMARY KEY (`id_detalle_carrito`),
  KEY `fk_producto_detalleCarrito` (`id_producto`),
  KEY `fk_carritoCompra_detalleCarrito` (`id_carrito_compra`),
  CONSTRAINT `fk_carritoCompra_detalleCarrito` FOREIGN KEY (`id_carrito_compra`) REFERENCES `carritocompra` (`id_carrito_compra`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `fk_producto_detalleCarrito` FOREIGN KEY (`id_producto`) REFERENCES `producto` (`id_producto`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `detallecarrito`
--

LOCK TABLES `detallecarrito` WRITE;
/*!40000 ALTER TABLE `detallecarrito` DISABLE KEYS */;
INSERT INTO `detallecarrito` VALUES (1,2,30000.00,1,1);
/*!40000 ALTER TABLE `detallecarrito` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `detallecompra`
--

DROP TABLE IF EXISTS `detallecompra`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `detallecompra` (
  `id_detalle_compra` int NOT NULL AUTO_INCREMENT,
  `cantidad` int NOT NULL,
  `precio_unitario` decimal(10,2) NOT NULL,
  `id_compra` int NOT NULL,
  `id_producto` int NOT NULL,
  PRIMARY KEY (`id_detalle_compra`),
  KEY `fk_compra_detalleCompra` (`id_compra`),
  KEY `fk_producto_detalleCompra` (`id_producto`),
  CONSTRAINT `FK9ld5ltal8av5lyp5kb1oh256v` FOREIGN KEY (`id_detalle_compra`) REFERENCES `compra` (`id_compra`),
  CONSTRAINT `fk_compra_detalleCompra` FOREIGN KEY (`id_compra`) REFERENCES `compra` (`id_compra`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `fk_producto_detalleCompra` FOREIGN KEY (`id_producto`) REFERENCES `producto` (`id_producto`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `detallecompra`
--

LOCK TABLES `detallecompra` WRITE;
/*!40000 ALTER TABLE `detallecompra` DISABLE KEYS */;
INSERT INTO `detallecompra` VALUES (1,2,30000.00,1,1);
/*!40000 ALTER TABLE `detallecompra` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `direccionenvio`
--

DROP TABLE IF EXISTS `direccionenvio`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `direccionenvio` (
  `id_direccion_envio` int NOT NULL AUTO_INCREMENT,
  `direccion` varchar(100) NOT NULL,
  `ciudad` varchar(50) NOT NULL,
  `region` varchar(50) DEFAULT NULL,
  `codigoPostal` varchar(20) NOT NULL,
  `pais` varchar(50) NOT NULL,
  `id_usuario` int NOT NULL,
  `codigo_postal` varchar(255) NOT NULL,
  PRIMARY KEY (`id_direccion_envio`),
  KEY `fk_usuario_direccionEnvio` (`id_usuario`),
  CONSTRAINT `fk_usuario_direccionEnvio` FOREIGN KEY (`id_usuario`) REFERENCES `usuario` (`id_usuario`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `direccionenvio`
--

LOCK TABLES `direccionenvio` WRITE;
/*!40000 ALTER TABLE `direccionenvio` DISABLE KEYS */;
INSERT INTO `direccionenvio` VALUES (1,'Recreo mz p # 2','Armenia','Quindio','630001','Colombia',1,'');
/*!40000 ALTER TABLE `direccionenvio` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `estadoproducto`
--

DROP TABLE IF EXISTS `estadoproducto`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `estadoproducto` (
  `id_estado_producto` int NOT NULL AUTO_INCREMENT,
  `nombre` varchar(60) DEFAULT NULL,
  PRIMARY KEY (`id_estado_producto`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `estadoproducto`
--

LOCK TABLES `estadoproducto` WRITE;
/*!40000 ALTER TABLE `estadoproducto` DISABLE KEYS */;
INSERT INTO `estadoproducto` VALUES (1,'Aprobado'),(2,'Rechazado');
/*!40000 ALTER TABLE `estadoproducto` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `favorito`
--

DROP TABLE IF EXISTS `favorito`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `favorito` (
  `id_favorito` int NOT NULL AUTO_INCREMENT,
  `nombre_producto` varchar(100) NOT NULL,
  `id_usuario` int NOT NULL,
  `id_producto` int NOT NULL,
  PRIMARY KEY (`id_favorito`),
  KEY `fk_usuario_favorito` (`id_usuario`),
  KEY `fk_producto_favorito` (`id_producto`),
  CONSTRAINT `fk_producto_favorito` FOREIGN KEY (`id_producto`) REFERENCES `producto` (`id_producto`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `fk_usuario_favorito` FOREIGN KEY (`id_usuario`) REFERENCES `usuario` (`id_usuario`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `favorito`
--

LOCK TABLES `favorito` WRITE;
/*!40000 ALTER TABLE `favorito` DISABLE KEYS */;
INSERT INTO `favorito` VALUES (1,'Jabon Baby',1,1);
/*!40000 ALTER TABLE `favorito` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `imagen`
--

DROP TABLE IF EXISTS `imagen`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `imagen` (
  `id_imagen` int NOT NULL AUTO_INCREMENT,
  `url` varchar(255) NOT NULL,
  `id_producto` int NOT NULL,
  PRIMARY KEY (`id_imagen`),
  KEY `fk_producto_imagen` (`id_producto`),
  CONSTRAINT `fk_producto_imagen` FOREIGN KEY (`id_producto`) REFERENCES `producto` (`id_producto`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `imagen`
--

LOCK TABLES `imagen` WRITE;
/*!40000 ALTER TABLE `imagen` DISABLE KEYS */;
INSERT INTO `imagen` VALUES (1,'/Users/VictorGutierrez/Desktop/Ruta Docker.png',1);
/*!40000 ALTER TABLE `imagen` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `moderador`
--

DROP TABLE IF EXISTS `moderador`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `moderador` (
  `id_moderador` int NOT NULL AUTO_INCREMENT,
  `nombre_completo` varchar(120) DEFAULT NULL,
  `cedula` varchar(120) DEFAULT NULL,
  `email` varchar(120) DEFAULT NULL,
  `telefono` varchar(120) DEFAULT NULL,
  `contrasena` varchar(120) DEFAULT NULL,
  `id_usuario` int NOT NULL,
  `id_producto` int NOT NULL,
  PRIMARY KEY (`id_moderador`),
  KEY `fk_usuario_moderador` (`id_usuario`),
  KEY `fk_producto_moderador` (`id_producto`),
  CONSTRAINT `fk_producto_moderador` FOREIGN KEY (`id_producto`) REFERENCES `producto` (`id_producto`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `fk_usuario_moderador` FOREIGN KEY (`id_usuario`) REFERENCES `usuario` (`id_usuario`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `moderador`
--

LOCK TABLES `moderador` WRITE;
/*!40000 ALTER TABLE `moderador` DISABLE KEYS */;
INSERT INTO `moderador` VALUES (1,'Victor Gutierrez','9772','victor@gmail.com','1111','1234',1,1);
/*!40000 ALTER TABLE `moderador` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `producto`
--

DROP TABLE IF EXISTS `producto`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `producto` (
  `id_producto` int NOT NULL AUTO_INCREMENT,
  `nombre` varchar(120) DEFAULT NULL,
  `descripcion` varchar(120) DEFAULT NULL,
  `precio` decimal(10,0) DEFAULT NULL,
  `disponibilidad` int DEFAULT NULL,
  `fecha_limite` date NOT NULL,
  `estado` varchar(120) NOT NULL,
  `id_usuario` int NOT NULL,
  `id_categoria` int NOT NULL,
  `id_estado_producto` int NOT NULL,
  `id_comentario` int NOT NULL,
  PRIMARY KEY (`id_producto`),
  KEY `fk_categoria_producto` (`id_categoria`),
  KEY `fk_usuario_producto` (`id_usuario`),
  KEY `fk_estadoproducto_producto` (`id_estado_producto`),
  KEY `fk_comentario_producto_idx` (`id_comentario`),
  CONSTRAINT `fk_categoria_producto` FOREIGN KEY (`id_categoria`) REFERENCES `categoria` (`id_categoria`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `fk_comentario_producto` FOREIGN KEY (`id_comentario`) REFERENCES `comentario` (`id_comentario`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `fk_estadoproducto_producto` FOREIGN KEY (`id_estado_producto`) REFERENCES `estadoproducto` (`id_estado_producto`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `fk_usuario_producto` FOREIGN KEY (`id_usuario`) REFERENCES `usuario` (`id_usuario`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `producto`
--

LOCK TABLES `producto` WRITE;
/*!40000 ALTER TABLE `producto` DISABLE KEYS */;
INSERT INTO `producto` VALUES (1,'Jabon Baby','Para la piel del bebe',15000,10,'2023-03-30','1',1,1,1,1),(2,'Crema','Piel de bebe fiu fiu',23000,5,'2023-03-30','1',1,1,1,1);
/*!40000 ALTER TABLE `producto` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `usuario`
--

DROP TABLE IF EXISTS `usuario`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `usuario` (
  `id_usuario` int NOT NULL AUTO_INCREMENT,
  `nombre_completo` varchar(120) DEFAULT NULL,
  `cedula` varchar(120) DEFAULT NULL,
  `email` varchar(120) DEFAULT NULL,
  `telefono` varchar(120) DEFAULT NULL,
  `direccion` varchar(120) DEFAULT NULL,
  `contrasena` varchar(120) DEFAULT NULL,
  PRIMARY KEY (`id_usuario`)
) ENGINE=InnoDB AUTO_INCREMENT=16 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `usuario`
--

LOCK TABLES `usuario` WRITE;
/*!40000 ALTER TABLE `usuario` DISABLE KEYS */;
INSERT INTO `usuario` VALUES (1,'Juan Jose Gutierrez Londoño \"Fiu Fiu\"','10923','juan@gmail.com','1111','Recreo','1234'),(2,'Johan Ortiz','22222','johan@gmail.com','2222','Ciudad Dorada','1234'),(3,'Pepe Aguilar','3333','pepe@gmail.com','3333','PepaLandia','1234'),(4,'Kevin Mackias','4444','pepe@gmail.com','4444','Calarcho',NULL),(5,'María Castro','1234567890','mariacastro@mail.com','+573211234567','Cra 10 #45-67','mariacastro123'),(6,'Pedro Rodríguez','0987654321','pedrorodriguez@mail.com','+573198765432','Calle 5 #20-30','pedrorodriguez123'),(7,'Laura Torres','1112223334','lauratorres@mail.com','+573176543210','Av 4 #9-55','lauratorres123'),(8,'Juan Sánchez','0987654321','juansanchez@mail.com','+573211234567','Cra 23 #17-08','juansanchez123'),(9,'Ana García','1112223334','anagarcia@mail.com','+573198765432','Cra 5 #15-60','anagarcia123'),(10,'Santiago Pérez','1234567890','santiagoperez@mail.com','+573176543210','Cra 25 #30-50','santiagoperez123'),(11,'Valentina Gómez','0987654321','valentinagomez@mail.com','+573211234567','Calle 7 #11-05','valentinagomez123'),(12,'Andrés Castro','1112223334','andrescastro@mail.com','+573198765432','Cra 18 #12-35','andrescastro123'),(13,'Lucía Torres','1234567890','luciatorres@mail.com','+573176543210','Cra 12 #8-15','luciatorres123'),(14,'Carlos Ramírez','0987654321','carlosramirez@mail.com','+573211234567','Cra 30 #25-40','carlosramirez123'),(15,'Mariana Ortiz','1112223334','marianaortiz@mail.com','+573198765432','Cra 10 #15-23','marianaortiz123');
/*!40000 ALTER TABLE `usuario` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2023-04-25  6:22:18
