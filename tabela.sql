CREATE TABLE `carros` (
  `idCarro` INT NOT NULL AUTO_INCREMENT,
  `peca` VARCHAR(45) NOT NULL,
  `fabricante` VARCHAR(32),
  `modelo` VARCHAR(45),
  `anoFabricacao` INT,
  `cor` VARCHAR(16),
  `valor` DECIMAL(10,2),
  quantidade INT NOT NULL,
  PRIMARY KEY (`idCarro`));

CREATE TABLE `usuario` (
  `iduser` INT NOT NULL AUTO_INCREMENT,
  `nome` VARCHAR(32) NOT NULL,
  `usuario` VARCHAR(15) NOT NULL UNIQUE,
  `senha` VARCHAR(15) NOT NULL,
  PRIMARY KEY (`iduser`));

INSERT INTO `usuario` (`iduser`, `nome`, `usuario`, `senha`) VALUES (NULL, 'admin', 'admin', '123');

CREATE TABLE `cliente` (
  `idCli` INT NOT NULL AUTO_INCREMENT,
  `nomeCli` VARCHAR(32) NOT NULL,
  `cnpj` VARCHAR(18) NOT NULL UNIQUE,
  `email` VARCHAR(32),
  `endereco` VARCHAR(32) NOT NULL,
  `bairro` VARCHAR(20) NOT NULL,
  `cidade` VARCHAR(20) NOT NULL,
  `UF` VARCHAR(2) NOT NULL,
  `CEP` VARCHAR(32),
  `tel` VARCHAR(32),
  `cel` VARCHAR(32),
  PRIMARY KEY (`idCli`));

CREATE TABLE caixa (
	data_venda Varchar(15),
    peca Varchar(30), 
    quantidade int,
    valor decimal(10,2),
    idCarro int(11) REFERENCES carros
)