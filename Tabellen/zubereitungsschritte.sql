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
-- Tabellenstruktur für Tabelle `zubereitungsschritte`
--

CREATE TABLE `zubereitungsschritte` (
  `id` int(11) NOT NULL,
  `gericht_id` int(11) NOT NULL,
  `schritt_nr` int(11) NOT NULL,
  `beschreibung` text NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Daten für Tabelle `zubereitungsschritte`
--

INSERT INTO `zubereitungsschritte` (`id`, `gericht_id`, `schritt_nr`, `beschreibung`) VALUES
(348, 93, 1, 'Die Paprikaschoten waschen, Stielansätze und Kerne entfernen und das Fruchtfleisch klein würfeln. Die Zwiebel schälen und in feine Ringe schneiden. Die Oliven, wenn nötig, entsteinen, dann halbieren. Das Basilikum waschen, trocken schütteln, die Blätter von den Stielen zupfen und grob hacken.'),
(349, 93, 2, 'Aus Olivenöl, Zitronensaft und Chiliflocken ein Dressing rühren, mit Salz und Pfeffer abschmecken. Über den Salat geben und alles vorsichtig vermengen. Mit dem Basilikum bestreuen und vor dem Servieren am besten 1 Stunde durchziehen lassen.'),
(350, 93, 3, 'Thunfisch grob zerpflücken und in eine Schüssel geben. Mais, Paprika, Zwiebel und Oliven dazugeben.'),
(351, 94, 1, 'Die Milch lauwarm erwärmen. Zucker und zerbröckelte Hefe einrühren und abgedeckt 10 Minuten ruhen lassen.'),
(352, 94, 2, 'Ein Backblech mit Backpapier belegen. Den Teig noch einmal kurz durchkneten, dann in acht gleich große Stücke teilen. Diese jeweils zu langen Rollen formen und die Rollen zu Knoten binden. Die Knoten auf das Backblech legen und zugedeckt noch einmal 30 Minuten gehen lassen.'),
(353, 94, 3, 'In einer Schüssel das Mehl mit dem Salz mischen und die Hefe-Milch sowie das Olivenöl dazugeben. Alles mit den Knethaken des Handrührgerätes oder den Händen zu einem glatten Teig verkneten. Mit einem feuchten Tuch abgedeckt an einem warmen Ort etwa 1 Stunde gehen lassen, bis der Teig sein Volumen deutlich vergrößert hat.'),
(354, 94, 4, 'Währenddessen den Backofen auf 180 °C Ober- und Unterhitze vorheizen. Die Butter schmelzen. Die Knoblauchzehen schälen und durch eine Knoblauchpresse in die flüssige Butter drücken. Gründlich verrühren. Die Brötchen 20-25 Minuten backen.'),
(355, 94, 5, 'Die Brötchen aus dem Ofen holen und sofort mit der Knoblauchbutter bestreichen und mit etwas grobem Salz bestreuen. Auf einem Kuchengitter kurz abkühlen lassen, dann am besten warm servieren.'),
(356, 95, 1, 'Tomaten in 8 ca. 1,5 cm dicke Scheiben schneiden. Ei verquirlen. Vollkornmehl mit Paprikapulver und Salz vermengen und in einen Teller geben. Panko in einen weiteren Teller geben. Tomatenscheiben erst mehlieren, dann im Ei und zuletzt im Panko wenden.'),
(357, 95, 2, 'Babyspinat waschen und trocken schleudern. Rote Zwiebel schälen und in Ringe schneiden. Mozzarella in Scheiben schneiden.'),
(358, 95, 3, 'Pfanne mit Öl erhitzen und die Tomatenscheiben auf beiden Seiten je 2-3 Minuten goldbraun rösten. Auf einem Küchentuch kurz abtropfen lassen.'),
(359, 95, 4, 'Pro Burger eine Tomatenscheibe mit etwas Pesto bestreichen, darüber etwas Babyspinat, ein bis zwei Scheiben Mozzarella, etwas Pesto, Schinken und Zwiebelringe legen und mit der zweiten Tomatenscheibe schließen. Burger mit einem Spieß fixieren und servieren.'),
(360, 96, 1, 'Vorab die Linguine in kochendem Salzwasser nach Packungsanleitung garen, allerdings 1 Minute kürzer als auf der Packung angegeben. Die Kirschtomaten waschen und trocknen.'),
(361, 96, 2, 'Das Kochwasser der Linguine nach der Garzeit durch ein Pastasieb abgießen und dabei auffangen. Das Pesto in den Topf geben, mit etwas Kochwasser vermengen, sodass es eine schön cremige Konsistenz bekommt. Die Linguine dazugeben. Alles gut vermengen und mit den Kirschtomaten anrichten. Die Parmaschinkenscheiben grob zerbrechen und die Pasta damit verfeinern.'),
(362, 96, 3, 'Parallel in einer großen Pfanne den Parmaschinken ohne Öl kross auslassen und auf einem Teller etwas abkühlen lassen. In der noch heißen Pfanne das Olivenöl erwärmen, die Kirschtomaten darin anbraten und mit Honig übergießen. Alles gut durchschwenken.'),
(363, 97, 1, 'Alles zamma Mischa'),
(364, 97, 3, 'Musss ed schmegggga mussss wirga');

--
-- Indizes der exportierten Tabellen
--

--
-- Indizes für die Tabelle `zubereitungsschritte`
--
ALTER TABLE `zubereitungsschritte`
  ADD PRIMARY KEY (`id`),
  ADD KEY `gericht_id` (`gericht_id`);

--
-- AUTO_INCREMENT für exportierte Tabellen
--

--
-- AUTO_INCREMENT für Tabelle `zubereitungsschritte`
--
ALTER TABLE `zubereitungsschritte`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=365;

--
-- Constraints der exportierten Tabellen
--

--
-- Constraints der Tabelle `zubereitungsschritte`
--
ALTER TABLE `zubereitungsschritte`
  ADD CONSTRAINT `zubereitungsschritte_ibfk_1` FOREIGN KEY (`gericht_id`) REFERENCES `gerichte` (`id`) ON DELETE CASCADE;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
