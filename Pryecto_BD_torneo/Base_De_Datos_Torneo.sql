-- MySQL dump 10.13  Distrib 5.5.55, for debian-linux-gnu (x86_64)
--
-- Host: localhost    Database: Torneo
-- ------------------------------------------------------
-- Server version	5.5.55-0+deb8u1

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `Arbitro`
--

DROP TABLE IF EXISTS `Arbitro`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `Arbitro` (
  `idArbitro` int(11) NOT NULL,
  `nombre` varchar(20) NOT NULL,
  `apellido1` varchar(20) NOT NULL,
  `apellido2` varchar(29) DEFAULT NULL,
  `tipo_de_arbitro` int(11) NOT NULL,
  PRIMARY KEY (`idArbitro`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Arbitro`
--

LOCK TABLES `Arbitro` WRITE;
/*!40000 ALTER TABLE `Arbitro` DISABLE KEYS */;
INSERT INTO `Arbitro` VALUES (1,'wilmar','Roldan','Perez',1),(2,'Jose','Gonzalez','Ruiz',2),(3,'David','Morales','Castaño',1),(4,'Camilo','villa','Patiño',4),(5,'Andres','Muñoz','Perez',2),(6,'Pedro','Castro','Alvarez',2),(7,'Victor','Ramiez','Ususga',4);
/*!40000 ALTER TABLE `Arbitro` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `Cancha`
--

DROP TABLE IF EXISTS `Cancha`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `Cancha` (
  `idCancha` int(11) NOT NULL,
  `capacidad` int(11) NOT NULL,
  `medida` int(11) NOT NULL,
  `Nombre` varchar(45) NOT NULL,
  PRIMARY KEY (`idCancha`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Cancha`
--

LOCK TABLES `Cancha` WRITE;
/*!40000 ALTER TABLE `Cancha` DISABLE KEYS */;
INSERT INTO `Cancha` VALUES (1,45000,900,'Atanasio Girardot'),(2,40000,850,'Pascual Guerrero');
/*!40000 ALTER TABLE `Cancha` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `Equipo`
--

DROP TABLE IF EXISTS `Equipo`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `Equipo` (
  `idEquipo` int(11) NOT NULL,
  `nombre` varchar(30) NOT NULL,
  `eslogan` varchar(50) NOT NULL,
  `puntos` int(11) NOT NULL,
  PRIMARY KEY (`idEquipo`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Equipo`
--

LOCK TABLES `Equipo` WRITE;
/*!40000 ALTER TABLE `Equipo` DISABLE KEYS */;
INSERT INTO `Equipo` VALUES (1,'Medellin','El Poderoso',0),(2,'Nacional','El Rey de Copas',0),(3,'Cali','Los Azucareros',0),(4,'America','Los Diablos',0);
/*!40000 ALTER TABLE `Equipo` ENABLE KEYS */;
UNLOCK TABLES;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = '' */ ;
DELIMITER ;;
/*!50003 CREATE*/ /*!50017 DEFINER=`root`@`localhost`*/ /*!50003 trigger trigger_respaldo_equipo before delete on Equipo for each row begin insert into Respaldo_Equipo(idEquipo,nombre,eslogan,puntos) values(old.idEquipo,old.nombre,old.eslogan,old.puntos); end */;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;

--
-- Table structure for table `Informe`
--

DROP TABLE IF EXISTS `Informe`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `Informe` (
  `idInforme` int(11) NOT NULL,
  `idPartido` int(11) NOT NULL,
  `marcador` varchar(5) NOT NULL,
  PRIMARY KEY (`idInforme`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Informe`
--

LOCK TABLES `Informe` WRITE;
/*!40000 ALTER TABLE `Informe` DISABLE KEYS */;
INSERT INTO `Informe` VALUES (1,1,'2-1'),(2,2,'2-2');
/*!40000 ALTER TABLE `Informe` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `Jugador`
--

DROP TABLE IF EXISTS `Jugador`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `Jugador` (
  `idJugador` int(11) NOT NULL,
  `nombre` varchar(20) NOT NULL,
  `apellido1` varchar(20) NOT NULL,
  `apellido2` varchar(20) NOT NULL,
  `numero` int(11) NOT NULL,
  `num_goles` int(11) NOT NULL,
  `estado` tinyint(1) NOT NULL,
  `idEquipo` int(11) NOT NULL,
  PRIMARY KEY (`idJugador`),
  KEY `idEquipo` (`idEquipo`),
  CONSTRAINT `Jugador_ibfk_1` FOREIGN KEY (`idEquipo`) REFERENCES `Equipo` (`idEquipo`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Jugador`
--

LOCK TABLES `Jugador` WRITE;
/*!40000 ALTER TABLE `Jugador` DISABLE KEYS */;
INSERT INTO `Jugador` VALUES (1,'David','Gonzalez','Ususga',1,0,1,1),(2,'Andres','Mosquera','Guardia',4,0,1,1),(3,'Mauricio','Molina','Guardiola',20,1,1,1),(4,'Juan','Quintero','Alvarez',10,3,1,1),(5,'Juan','Caicedo','Mosquera',9,2,1,1),(6,'Valentin','Viola','Perez',13,2,1,1),(7,'Franco','Armani','Gamboa',1,0,1,2),(8,'Francisco','Nagera','Ortiz',3,0,1,2),(10,'Aldo','Leado','Ramirez',8,0,1,2),(11,'Macnelly','Torres','Velez',10,0,1,2),(12,'Farid','Diaz','Bermudez',14,0,1,2),(13,'Farid','Mondragon','Bermudez',1,0,1,3),(14,'Steven','Ramirez','Arango',4,0,1,3),(15,'Juan','Villa','Cespedes',5,0,1,3),(16,'Jorge','Holguin','Cabrales',7,0,1,3),(17,'Luis','Lopez','Mora',9,0,1,3),(18,'Carlos','Mendez','Soto',9,0,1,3),(19,'Carlos','Bejarano','Mena',1,0,1,4),(20,'Diego','Herner','Morantes',6,0,1,4),(21,'Manuel','Molina','Ibarguen',9,0,1,4),(22,'Jorge','Farias','Sanchez',10,0,1,4),(23,'Jesús','Zapata','Raigoza',11,0,1,4),(24,'Nicolas','Ortiz','Arboleda',12,0,1,4),(1000,'Fake','Fake','Fake',1000,10,1,2);
/*!40000 ALTER TABLE `Jugador` ENABLE KEYS */;
UNLOCK TABLES;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = '' */ ;
DELIMITER ;;
/*!50003 CREATE*/ /*!50017 DEFINER=`root`@`localhost`*/ /*!50003 trigger nombre_eq_trigger after insert on Jugador for each row begin declare aux varchar(30); select nombre_eq(new.idEquipo) into aux; insert into Jugador_partido_aux (nombre,apellido1,equipo) values(new.nombre,new.apellido1,aux); end */;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = '' */ ;
DELIMITER ;;
/*!50003 CREATE*/ /*!50017 DEFINER=`root`@`localhost`*/ /*!50003 TRIGGER eliminar_jugador_sancionado before DELETE ON Jugador FOR EACH ROW BEGIN delete from Sancionados WHERE Sancionados.idJugador=old.idJugador; end */;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;

--
-- Table structure for table `Jugador_partido_aux`
--

DROP TABLE IF EXISTS `Jugador_partido_aux`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `Jugador_partido_aux` (
  `nombre` varchar(30) DEFAULT NULL,
  `apellido1` varchar(30) DEFAULT NULL,
  `equipo` varchar(40) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Jugador_partido_aux`
--

LOCK TABLES `Jugador_partido_aux` WRITE;
/*!40000 ALTER TABLE `Jugador_partido_aux` DISABLE KEYS */;
/*!40000 ALTER TABLE `Jugador_partido_aux` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `Partido`
--

DROP TABLE IF EXISTS `Partido`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `Partido` (
  `idPartido` int(11) NOT NULL,
  `idEquipo_L` int(11) NOT NULL,
  `idEquipo_V` int(11) NOT NULL,
  `tiempo` int(11) NOT NULL,
  `idCancha` int(11) NOT NULL,
  PRIMARY KEY (`idPartido`),
  KEY `idEquipo_L` (`idEquipo_L`),
  KEY `idEquipo_V` (`idEquipo_V`),
  KEY `idCancha` (`idCancha`),
  CONSTRAINT `Partido_ibfk_1` FOREIGN KEY (`idEquipo_L`) REFERENCES `Equipo` (`idEquipo`),
  CONSTRAINT `Partido_ibfk_2` FOREIGN KEY (`idEquipo_V`) REFERENCES `Equipo` (`idEquipo`),
  CONSTRAINT `Partido_ibfk_3` FOREIGN KEY (`idCancha`) REFERENCES `Cancha` (`idCancha`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Partido`
--

LOCK TABLES `Partido` WRITE;
/*!40000 ALTER TABLE `Partido` DISABLE KEYS */;
INSERT INTO `Partido` VALUES (1,1,2,92,1),(2,3,4,95,2);
/*!40000 ALTER TABLE `Partido` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `Partido_Arbitro`
--

DROP TABLE IF EXISTS `Partido_Arbitro`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `Partido_Arbitro` (
  `idPartido` int(11) NOT NULL,
  `idArbitro_C` int(11) NOT NULL,
  `idArbitro_L1` int(11) NOT NULL,
  `idArbitro_L2` int(11) NOT NULL,
  `idArbitro_Cuarto` int(11) NOT NULL,
  PRIMARY KEY (`idPartido`,`idArbitro_C`,`idArbitro_L1`,`idArbitro_L2`,`idArbitro_Cuarto`),
  KEY `idArbitro_C` (`idArbitro_C`),
  KEY `idArbitro_L1` (`idArbitro_L1`),
  KEY `idArbitro_L2` (`idArbitro_L2`),
  KEY `idArbitro_Cuarto` (`idArbitro_Cuarto`),
  CONSTRAINT `Partido_Arbitro_ibfk_1` FOREIGN KEY (`idPartido`) REFERENCES `Partido` (`idPartido`),
  CONSTRAINT `Partido_Arbitro_ibfk_2` FOREIGN KEY (`idArbitro_C`) REFERENCES `Arbitro` (`idArbitro`),
  CONSTRAINT `Partido_Arbitro_ibfk_3` FOREIGN KEY (`idArbitro_L1`) REFERENCES `Arbitro` (`idArbitro`),
  CONSTRAINT `Partido_Arbitro_ibfk_4` FOREIGN KEY (`idArbitro_L2`) REFERENCES `Arbitro` (`idArbitro`),
  CONSTRAINT `Partido_Arbitro_ibfk_5` FOREIGN KEY (`idArbitro_Cuarto`) REFERENCES `Arbitro` (`idArbitro`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Partido_Arbitro`
--

LOCK TABLES `Partido_Arbitro` WRITE;
/*!40000 ALTER TABLE `Partido_Arbitro` DISABLE KEYS */;
INSERT INTO `Partido_Arbitro` VALUES (1,1,2,6,7),(2,3,5,6,7);
/*!40000 ALTER TABLE `Partido_Arbitro` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `Partido_Final`
--

DROP TABLE IF EXISTS `Partido_Final`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `Partido_Final` (
  `idEquipo_Campeon` int(11) NOT NULL,
  `idEquipo_Subcampeon` int(11) NOT NULL,
  `idJugador_goleador` int(11) NOT NULL,
  `Marcador` varchar(5) NOT NULL,
  KEY `idEquipo_Campeon` (`idEquipo_Campeon`),
  KEY `idEquipo_Subcampeon` (`idEquipo_Subcampeon`),
  KEY `idJugador_goleador` (`idJugador_goleador`),
  CONSTRAINT `Partido_Final_ibfk_1` FOREIGN KEY (`idEquipo_Campeon`) REFERENCES `Equipo` (`idEquipo`),
  CONSTRAINT `Partido_Final_ibfk_2` FOREIGN KEY (`idEquipo_Subcampeon`) REFERENCES `Equipo` (`idEquipo`),
  CONSTRAINT `Partido_Final_ibfk_3` FOREIGN KEY (`idJugador_goleador`) REFERENCES `Jugador` (`idJugador`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Partido_Final`
--

LOCK TABLES `Partido_Final` WRITE;
/*!40000 ALTER TABLE `Partido_Final` DISABLE KEYS */;
INSERT INTO `Partido_Final` VALUES (1,2,6,'3-1'),(1,2,1000,'5-2');
/*!40000 ALTER TABLE `Partido_Final` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `Premiacion`
--

DROP TABLE IF EXISTS `Premiacion`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `Premiacion` (
  `idPremiacion` int(11) NOT NULL,
  `idEquipo_campeon` int(11) NOT NULL,
  `idEquipo_subcampeon` int(11) NOT NULL,
  `Marcador` varchar(5) NOT NULL,
  `idJugador_goleador` int(11) NOT NULL,
  PRIMARY KEY (`idPremiacion`),
  KEY `idEquipo_campeon` (`idEquipo_campeon`),
  KEY `idEquipo_subcampeon` (`idEquipo_subcampeon`),
  KEY `idJugador_goleador` (`idJugador_goleador`),
  CONSTRAINT `Premiacion_ibfk_1` FOREIGN KEY (`idEquipo_campeon`) REFERENCES `Equipo` (`idEquipo`),
  CONSTRAINT `Premiacion_ibfk_2` FOREIGN KEY (`idEquipo_subcampeon`) REFERENCES `Equipo` (`idEquipo`),
  CONSTRAINT `Premiacion_ibfk_3` FOREIGN KEY (`idJugador_goleador`) REFERENCES `Jugador` (`idJugador`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Premiacion`
--

LOCK TABLES `Premiacion` WRITE;
/*!40000 ALTER TABLE `Premiacion` DISABLE KEYS */;
/*!40000 ALTER TABLE `Premiacion` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `Respaldo_Equipo`
--

DROP TABLE IF EXISTS `Respaldo_Equipo`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `Respaldo_Equipo` (
  `idEquipo` int(11) DEFAULT NULL,
  `nombre` varchar(30) DEFAULT NULL,
  `eslogan` varchar(50) DEFAULT NULL,
  `puntos` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Respaldo_Equipo`
--

LOCK TABLES `Respaldo_Equipo` WRITE;
/*!40000 ALTER TABLE `Respaldo_Equipo` DISABLE KEYS */;
INSERT INTO `Respaldo_Equipo` VALUES (123,'Paola','Bases de datos',0);
/*!40000 ALTER TABLE `Respaldo_Equipo` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `Sancionados`
--

DROP TABLE IF EXISTS `Sancionados`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `Sancionados` (
  `idSancionados` int(11) NOT NULL,
  `tipo_sancion` int(11) NOT NULL,
  `idJugador` int(11) NOT NULL,
  `idInforme` int(11) NOT NULL,
  PRIMARY KEY (`idSancionados`),
  KEY `idJugador` (`idJugador`),
  KEY `idInforme` (`idInforme`),
  CONSTRAINT `Sancionados_ibfk_1` FOREIGN KEY (`idJugador`) REFERENCES `Jugador` (`idJugador`),
  CONSTRAINT `Sancionados_ibfk_2` FOREIGN KEY (`idInforme`) REFERENCES `Informe` (`idInforme`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Sancionados`
--

LOCK TABLES `Sancionados` WRITE;
/*!40000 ALTER TABLE `Sancionados` DISABLE KEYS */;
INSERT INTO `Sancionados` VALUES (1,1,1,1),(2,1,4,1),(3,2,8,1);
/*!40000 ALTER TABLE `Sancionados` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2017-05-22 11:11:15
