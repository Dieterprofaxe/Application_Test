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
-- Tabellenstruktur für Tabelle `zutaten`
--

CREATE TABLE `zutaten` (
  `id` int(11) NOT NULL,
  `gericht_id` int(11) DEFAULT NULL,
  `bezeichnung` text DEFAULT NULL,
  `einheit` text DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Daten für Tabelle `zutaten`
--

INSERT INTO `zutaten` (`id`, `gericht_id`, `bezeichnung`, `einheit`) VALUES
(271, 93, 'Paprikaschoten', '2'),
(272, 93, 'Rote Zwiebel', '1'),
(273, 93, 'Oliven', '80'),
(274, 93, 'Bsilikum', '15'),
(275, 93, 'Thunfisch', '300'),
(276, 93, 'Mais', '200'),
(277, 93, 'Olivenöl', '4EL'),
(278, 93, 'Zitronensaft', '2El'),
(279, 93, 'Chiliflocken', '1 Prise'),
(280, 94, 'Milch', '280'),
(281, 94, 'Zucker', '1EL'),
(282, 94, 'Hefe', '21'),
(283, 94, 'Weizenmehl', '500'),
(284, 94, 'Salz', '1,5'),
(285, 94, 'Olivenöl', '2El'),
(286, 94, 'Butter', '60'),
(287, 94, 'Knoblauch', '2 Zehn'),
(288, 95, 'Fleischtomaten', '2'),
(289, 95, 'EI', '1'),
(290, 95, 'Vollkornmehl', '2El'),
(291, 95, 'Paprika rosenscharf', '0,5'),
(292, 95, 'Salz', '1'),
(293, 95, 'Panku', '6EL'),
(294, 95, 'ÖL', '1'),
(295, 95, 'Babyspinat', '100'),
(296, 95, 'rote Zwiebel', '1'),
(297, 95, 'Mozzarella', '1'),
(298, 95, 'Pesto alla Genovese', '4EL'),
(299, 95, 'Serano Schinken', '80g'),
(300, 96, 'Linguine', '400'),
(301, 96, 'Salz', '1'),
(302, 96, 'Kirschtomaten', '400'),
(303, 96, 'Parmaschinekn', '100'),
(304, 96, 'Olivenöl', '1TL'),
(305, 96, 'Honig', '1EL'),
(306, 96, 'Barilla', '1 Glas'),
(307, 97, 'Thunfisch', '1 Dose'),
(308, 97, 'Reiswaffeln', '2'),
(309, 97, 'Wasser', '300'),
(310, 97, 'Salz', '2g'),
(311, 97, 'Pfeffer', '');

--
-- Indizes der exportierten Tabellen
--

--
-- Indizes für die Tabelle `zutaten`
--
ALTER TABLE `zutaten`
  ADD PRIMARY KEY (`id`),
  ADD KEY `gericht_id` (`gericht_id`);

--
-- AUTO_INCREMENT für exportierte Tabellen
--

--
-- AUTO_INCREMENT für Tabelle `zutaten`
--
ALTER TABLE `zutaten`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=312;

--
-- Constraints der exportierten Tabellen
--

--
-- Constraints der Tabelle `zutaten`
--
ALTER TABLE `zutaten`
  ADD CONSTRAINT `zutaten_ibfk_1` FOREIGN KEY (`gericht_id`) REFERENCES `gerichte` (`id`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
