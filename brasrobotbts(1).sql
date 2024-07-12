-- phpMyAdmin SQL Dump
-- version 4.6.5.2
-- https://www.phpmyadmin.net/
--
-- Client :  127.0.0.1
-- Généré le :  Lun 05 Mars 2018 à 20:32
-- Version du serveur :  10.1.21-MariaDB
-- Version de PHP :  5.6.30

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de données :  `brasrobotbts`
--

-- --------------------------------------------------------

--
-- Structure de la table `moteur`
--

CREATE TABLE `moteur` (
  `IDMOTEUR` int(11) NOT NULL,
  `POSITION` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Contenu de la table `moteur`
--

INSERT INTO `moteur` (`IDMOTEUR`, `POSITION`) VALUES
(1, 500);

-- --------------------------------------------------------

--
-- Structure de la table `musicien`
--

CREATE TABLE `musicien` (
  `IDMUSICIEN` int(11) NOT NULL,
  `CAMERA` tinyint(1) DEFAULT '0',
  `LASER` tinyint(1) DEFAULT '0',
  `NOM` varchar(255) DEFAULT NULL,
  `SON` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Contenu de la table `musicien`
--

INSERT INTO `musicien` (`IDMUSICIEN`, `CAMERA`, `LASER`, `NOM`, `SON`) VALUES
(2, 0, 1, 'antoine', 60),
(4, 0, 1, 'maxence', 35),
(5, 1, 0, 'jereme', 50);

-- --------------------------------------------------------

--
-- Structure de la table `preference`
--

CREATE TABLE `preference` (
  `IDPREFERENCE` int(11) NOT NULL,
  `IMAGE` varchar(255) DEFAULT NULL,
  `NOMPREFERENCE` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Contenu de la table `preference`
--

INSERT INTO `preference` (`IDPREFERENCE`, `IMAGE`, `NOMPREFERENCE`) VALUES
(1, '', 'ac dc');

--
-- Index pour les tables exportées
--

--
-- Index pour la table `moteur`
--
ALTER TABLE `moteur`
  ADD PRIMARY KEY (`IDMOTEUR`);

--
-- Index pour la table `musicien`
--
ALTER TABLE `musicien`
  ADD PRIMARY KEY (`IDMUSICIEN`);

--
-- Index pour la table `preference`
--
ALTER TABLE `preference`
  ADD PRIMARY KEY (`IDPREFERENCE`);

--
-- AUTO_INCREMENT pour les tables exportées
--

--
-- AUTO_INCREMENT pour la table `moteur`
--
ALTER TABLE `moteur`
  MODIFY `IDMOTEUR` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;
--
-- AUTO_INCREMENT pour la table `musicien`
--
ALTER TABLE `musicien`
  MODIFY `IDMUSICIEN` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;
--
-- AUTO_INCREMENT pour la table `preference`
--
ALTER TABLE `preference`
  MODIFY `IDPREFERENCE` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
