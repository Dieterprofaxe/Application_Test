-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Erstellungszeit: 27. Jun 2025 um 07:27
-- Server-Version: 10.4.32-MariaDB
-- PHP-Version: 8.2.12

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Datenbank: `meinedb`
--

-- --------------------------------------------------------

--
-- Tabellenstruktur für Tabelle `gerichte`
--

CREATE TABLE `gerichte` (
  `id` int(11) NOT NULL,
  `name` varchar(255) NOT NULL,
  `dauer` int(11) NOT NULL,
  `personenanzahl` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Daten für Tabelle `gerichte`
--

INSERT INTO `gerichte` (`id`, `name`, `dauer`, `personenanzahl`) VALUES
(93, 'Thunfisch Salat', 90, 4),
(94, 'Knoblauchknoten', 160, 4),
(95, 'Tomatenburger', 30, 1),
(96, 'Linguine alla genovese ', 35, 1),
(97, 'Markus Rühl Thunfisch Shake', 1, 1);

--
-- Indizes der exportierten Tabellen
--

--
-- Indizes für die Tabelle `gerichte`
--
ALTER TABLE `gerichte`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT für exportierte Tabellen
--

--
-- AUTO_INCREMENT für Tabelle `gerichte`
--
ALTER TABLE `gerichte`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=98;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
