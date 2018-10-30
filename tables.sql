CREATE TABLE IF NOT EXISTS `Usuario` (
  `Id` INT NOT NULL,
  `Nombre` VARCHAR(255)  NOT NULL,
  `Email` VARCHAR(255)  NOT NULL,
  `Rol_id` INT  NOT NULL);

-- -----------------------------------------------------
-- Table `rol`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `Rol` (
  `Id` INT NOT NULL,
  `Nombre` VARCHAR(20)  NOT NULL);


-- -----------------------------------------------------
-- Table `apoyar`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `Apoyar` (
  `Usuario_id` INT NOT NULL,
  `Inciativa_id` INT  NOT NULL);


-- -----------------------------------------------------
-- Table `inciativa`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `Iniciativa` (
  `Id` INT NOT NULL ,
  `Descripcion` varchar(250) NOT NULL,
  `Estado` varchar(15) NOT NULL,
  `Votos` INT NOT NULL,
  `Fecha_creacion` DATE NOT NULL,
  `Usuario_id` INT NOT NULL,
  `Area_id` INT not null);

-- -----------------------------------------------------
-- Table `area`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `Area` (
  `Id` INT NOT NULL ,
  `Nombre` varchar(50) NOT NULL);


