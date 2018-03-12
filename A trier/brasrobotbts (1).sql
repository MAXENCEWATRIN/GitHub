-- phpMyAdmin SQL Dump
-- version 4.6.5.2
-- https://www.phpmyadmin.net/
--
-- Client :  127.0.0.1
-- Généré le :  Lun 12 Mars 2018 à 12:00
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
-- Structure de la table `bobine`
--

CREATE TABLE `bobine` (
  `IDBOBINE` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Structure de la table `joystick`
--

CREATE TABLE `joystick` (
  `IDJOYSTICK` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Structure de la table `moteur`
--

CREATE TABLE `moteur` (
  `IDMOTEUR` int(11) NOT NULL,
  `PASINTERVAL` int(11) DEFAULT NULL,
  `PASREVOLUTION` int(11) DEFAULT NULL,
  `POSITION` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Structure de la table `musicien`
--

CREATE TABLE `musicien` (
  `IDMUSICIEN` int(11) NOT NULL,
  `CAMERA` tinyint(1) DEFAULT '0',
  `IMAGE` varchar(255) DEFAULT NULL,
  `LASER` tinyint(1) DEFAULT '0',
  `NOM` varchar(255) DEFAULT NULL,
  `SON` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Contenu de la table `musicien`
--

INSERT INTO `musicien` (`IDMUSICIEN`, `CAMERA`, `IMAGE`, `LASER`, `NOM`, `SON`) VALUES
(1, 0, NULL, 1, 'setoxTv', 35),
(2, 1, NULL, 0, 'maxence', 35);

-- --------------------------------------------------------

--
-- Structure de la table `preference`
--

CREATE TABLE `preference` (
  `IDPREFERENCE` int(11) NOT NULL,
  `NOMPREFERENCE` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Index pour les tables exportées
--

--
-- Index pour la table `bobine`
--
ALTER TABLE `bobine`
  ADD PRIMARY KEY (`IDBOBINE`);

--
-- Index pour la table `joystick`
--
ALTER TABLE `joystick`
  ADD PRIMARY KEY (`IDJOYSTICK`);

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
-- AUTO_INCREMENT pour la table `bobine`
--
ALTER TABLE `bobine`
  MODIFY `IDBOBINE` int(11) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT pour la table `joystick`
--
ALTER TABLE `joystick`
  MODIFY `IDJOYSTICK` int(11) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT pour la table `moteur`
--
ALTER TABLE `moteur`
  MODIFY `IDMOTEUR` int(11) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT pour la table `musicien`
--
ALTER TABLE `musicien`
  MODIFY `IDMUSICIEN` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;
--
-- AUTO_INCREMENT pour la table `preference`
--
ALTER TABLE `preference`
  MODIFY `IDPREFERENCE` int(11) NOT NULL AUTO_INCREMENT;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
