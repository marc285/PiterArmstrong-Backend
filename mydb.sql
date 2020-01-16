-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema mydb
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema mydb
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `mydb` DEFAULT CHARACTER SET utf8 ;
USE `mydb` ;

-- -----------------------------------------------------
-- Table `mydb`.`User`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`User` (
  `ID` INT NOT NULL AUTO_INCREMENT,
  `nickname` VARCHAR(45) NOT NULL,
  `password` VARCHAR(45) NOT NULL,
  `vida` INT NOT NULL,
  `defensa` INT NOT NULL,
  `ataque` INT NOT NULL,
  `dinero` INT NOT NULL,
  `piezas` INT NOT NULL,
  `pantalla` INT NULL,
  PRIMARY KEY (`ID`),
  UNIQUE INDEX `ID_UNIQUE` (`ID` ASC) VISIBLE,
  UNIQUE INDEX `nickname_UNIQUE` (`nickname` ASC) VISIBLE)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`employee`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`employee` (
  `ID` INT NOT NULL,
  `name` VARCHAR(45) NOT NULL,
  `surname` VARCHAR(45) NOT NULL,
  `salary` INT NOT NULL,
  UNIQUE INDEX `ID_UNIQUE` (`ID` ASC) VISIBLE,
  PRIMARY KEY (`ID`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`Objeto`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`Objeto` (
  `ID` INT NOT NULL AUTO_INCREMENT,
  `nombre` VARCHAR(45) NOT NULL,
  `tipo` VARCHAR(45) NOT NULL,
  `stat` VARCHAR(45) NOT NULL,
  `coste` VARCHAR(45) NOT NULL,
  UNIQUE INDEX `ID_UNIQUE` (`ID` ASC) VISIBLE,
  PRIMARY KEY (`ID`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`UserObject`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`UserObject` (
  `idUser` INT NOT NULL,
  `idObject` INT NOT NULL,
  PRIMARY KEY (`idUser`, `idObject`),
  INDEX `fk_objetosuser_objects1_idx` (`idObject` ASC) VISIBLE,
  CONSTRAINT `fk_objetosuser_login`
    FOREIGN KEY (`idUser`)
    REFERENCES `mydb`.`User` (`ID`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_objetosuser_objects1`
    FOREIGN KEY (`idObject`)
    REFERENCES `mydb`.`Objeto` (`ID`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`Partidas`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`Partidas` (
  `ID` INT NOT NULL,
  `IDpartida` INT NULL AUTO_INCREMENT,
  `Puntos` INT NOT NULL,
  PRIMARY KEY (`ID`),
  INDEX `fk_Partidas_User1_idx` (`ID` ASC) VISIBLE,
  UNIQUE INDEX `IDpartida_UNIQUE` (`IDpartida` ASC) VISIBLE,
  CONSTRAINT `fk_Partidas_User1`
    FOREIGN KEY (`ID`)
    REFERENCES `mydb`.`User` (`ID`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;

-- -----------------------------------------------------
-- Data for table `mydb`.`User`
-- -----------------------------------------------------
START TRANSACTION;
USE `mydb`;
INSERT INTO `mydb`.`User` (`ID`, `nickname`, `password`, `vida`, `defensa`, `ataque`, `dinero`, `piezas`, `pantalla`) VALUES (9999, 'Pepe', '1234', 10, 10, 10, 10, 10, 10);

COMMIT;

