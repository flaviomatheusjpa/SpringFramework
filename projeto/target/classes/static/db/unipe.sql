-- phpMyAdmin SQL Dump
-- version 4.5.1
-- http://www.phpmyadmin.net
--
-- Host: 127.0.0.1
-- Generation Time: 23-Maio-2017 às 05:04
-- Versão do servidor: 10.1.19-MariaDB
-- PHP Version: 7.0.13

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `unipe`
--

-- --------------------------------------------------------

--
-- Estrutura da tabela `funcao`
--

CREATE TABLE `funcao` (
  `funcao_id` int(11) NOT NULL,
  `funcao` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Extraindo dados da tabela `funcao`
--

INSERT INTO `funcao` (`funcao_id`, `funcao`) VALUES
(1, 'ADMIN');

-- --------------------------------------------------------

--
-- Estrutura da tabela `tb_contato`
--

CREATE TABLE `tb_contato` (
  `id` bigint(20) NOT NULL,
  `email` varchar(100) NOT NULL,
  `nome` varchar(50) NOT NULL,
  `sobrenome` varchar(50) NOT NULL,
  `telefone` varchar(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Extraindo dados da tabela `tb_contato`
--

INSERT INTO `tb_contato` (`id`, `email`, `nome`, `sobrenome`, `telefone`) VALUES
(2, 'maria@taco.com', 'Maria', 'Alice', '97854682'),
(3, 'thiago@bol.com.br', 'Thiago', 'Felix', '96587456'),
(4, 'ligia@teste.net', 'Lígia', 'Nunes', '88975497'),
(6, 'cabral@bus.com', 'Cabral', 'Carlos', '9685742'),
(8, 'lima@net.com', 'Lima', 'Victoria', '87965421');

-- --------------------------------------------------------

--
-- Estrutura da tabela `usuario`
--

CREATE TABLE `usuario` (
  `usuario_id` int(11) NOT NULL,
  `active` int(11) DEFAULT NULL,
  `email` varchar(255) NOT NULL,
  `nome` varchar(255) NOT NULL,
  `senha` varchar(255) NOT NULL,
  `sobre_nome` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Extraindo dados da tabela `usuario`
--

INSERT INTO `usuario` (`usuario_id`, `active`, `email`, `nome`, `senha`, `sobre_nome`) VALUES
(2, 1, 'admin@admin.com', 'Flávio', '$2a$10$8q1D9nAmtng903sqnyQcMueUwChrqZ.Pa629xYvMObSLLvQIaHvoS', 'Souza'),
(3, 1, 'fulano@net.com', 'Fulano', '$2a$10$hKq8xr04aiVc8nHqIpCfjuvRmthN70fFkp.nI6v7KaIrBYF6M1i4S', 'de Tal'),
(4, 1, 'thiago@bol.com.br', 'Thiago', '$2a$10$TrVycOT2dterjUNtizE4CO1Cs9IN08zB6dFCLzGjs.KA.95p/qEga', 'Lira');

-- --------------------------------------------------------

--
-- Estrutura da tabela `usuario_funcao`
--

CREATE TABLE `usuario_funcao` (
  `usuario_id` int(11) NOT NULL,
  `funcao_id` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Extraindo dados da tabela `usuario_funcao`
--

INSERT INTO `usuario_funcao` (`usuario_id`, `funcao_id`) VALUES
(2, 1),
(3, 1),
(4, 1);

--
-- Indexes for dumped tables
--

--
-- Indexes for table `funcao`
--
ALTER TABLE `funcao`
  ADD PRIMARY KEY (`funcao_id`);

--
-- Indexes for table `tb_contato`
--
ALTER TABLE `tb_contato`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `usuario`
--
ALTER TABLE `usuario`
  ADD PRIMARY KEY (`usuario_id`);

--
-- Indexes for table `usuario_funcao`
--
ALTER TABLE `usuario_funcao`
  ADD PRIMARY KEY (`usuario_id`,`funcao_id`),
  ADD KEY `FKh81lv8tfi61kyewyl167yv8wr` (`funcao_id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `funcao`
--
ALTER TABLE `funcao`
  MODIFY `funcao_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;
--
-- AUTO_INCREMENT for table `tb_contato`
--
ALTER TABLE `tb_contato`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=9;
--
-- AUTO_INCREMENT for table `usuario`
--
ALTER TABLE `usuario`
  MODIFY `usuario_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;
--
-- Constraints for dumped tables
--

--
-- Limitadores para a tabela `usuario_funcao`
--
ALTER TABLE `usuario_funcao`
  ADD CONSTRAINT `FKdfshk73w8udtgpxlxuw4su6b4` FOREIGN KEY (`usuario_id`) REFERENCES `usuario` (`usuario_id`),
  ADD CONSTRAINT `FKh81lv8tfi61kyewyl167yv8wr` FOREIGN KEY (`funcao_id`) REFERENCES `funcao` (`funcao_id`);

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
