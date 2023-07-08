-- phpMyAdmin SQL Dump
-- version 5.2.0
-- https://www.phpmyadmin.net/
--
-- Anamakine: 127.0.0.1
-- Üretim Zamanı: 24 Haz 2023, 13:04:09
-- Sunucu sürümü: 10.4.25-MariaDB
-- PHP Sürümü: 8.1.10

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Veritabanı: `kantinotomasyonu`
--

-- --------------------------------------------------------

--
-- Tablo için tablo yapısı `admin`
--

CREATE TABLE `admin` (
  `UrunKategoriler` varchar(50) COLLATE utf8_turkish_ci NOT NULL,
  `Urun` varchar(50) COLLATE utf8_turkish_ci NOT NULL,
  `Fiyat` int(20) NOT NULL,
  `StokDurumu` int(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_turkish_ci;

--
-- Tablo döküm verisi `admin`
--

INSERT INTO `admin` (`UrunKategoriler`, `Urun`, `Fiyat`, `StokDurumu`) VALUES
('Yemek', 'CigKofte', 40, 5),
('Yemek', 'Hamburger', 50, 15),
('Yemek', 'Doner', 40, 10),
('Yemek', 'Pogaca', 15, 5),
('Yemek', 'Sandvic', 20, 50),
('Yemek', 'Tost', 40, 20),
('Yemek', 'Simit', 10, 10),
('Yemek', 'Kumru', 40, 10),
('Atistirmalik', 'Albeni', 10, 10),
('Atistirmalik', 'Browni visneli kek', 10, 10),
('Atistirmalik', 'Patlamis misir', 15, 10),
('Atistirmalik', 'Sut burger', 10, 10),
('Atistirmalik', 'Eti cin biskuvi', 10, 10),
('Atistirmalik', 'Cocostar biskuvi', 15, 10),
('Atistirmalik', 'Halley', 10, 10),
('Atistirmalik', 'İkram ', 15, 10),
('Atistirmalik', 'Nero', 20, 10),
('Atistirmalik', 'Eti Tutku ', 15, 10),
('Dondurma', 'Boom', 20, 10),
('Dondurma', 'Bravo', 15, 10),
('Dondurma', 'Bravo Gold', 20, 10),
('Dondurma', 'Marasim', 15, 10),
('Dondurma', 'Nogger', 15, 10),
('Dondurma', 'Oreo', 10, 10),
('Dondurma', 'Snickers', 20, 10),
('Dondurma', 'Toblerone', 25, 10),
('SuVeİcecekler', 'Ayran', 12, 10),
('SuVeİcecekler', 'Kahve', 15, 10),
('SuVeİcecekler', 'Kefir', 20, 10),
('SuVeİcecekler', 'Kola', 20, 10),
('SuVeİcecekler', 'Meyvesuyu', 15, 10),
('SuVeİcecekler', 'Redbull', 30, 10),
('SuVeİcecekler', 'Sogukcay', 15, 10),
('SuVeİcecekler', 'Su', 10, 10);

--
-- Tetikleyiciler `admin`
--
DELIMITER $$
CREATE TRIGGER `update_price_trigger` AFTER UPDATE ON `admin` FOR EACH ROW BEGIN
    UPDATE sepet
    SET Fiyat = NEW.Fiyat
    WHERE Urun = NEW.Urun;
END
$$
DELIMITER ;

-- --------------------------------------------------------

--
-- Tablo için tablo yapısı `kullanıcılar`
--

CREATE TABLE `kullanıcılar` (
  `KID` int(11) NOT NULL,
  `Kullanıcıadı` varchar(50) COLLATE utf8_turkish_ci NOT NULL,
  `Parola` varchar(50) COLLATE utf8_turkish_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_turkish_ci;

--
-- Tablo döküm verisi `kullanıcılar`
--

INSERT INTO `kullanıcılar` (`KID`, `Kullanıcıadı`, `Parola`) VALUES
(1, 'Aras', '123456');

-- --------------------------------------------------------

--
-- Tablo için tablo yapısı `sepet`
--

CREATE TABLE `sepet` (
  `Urun` varchar(250) COLLATE utf8_turkish_ci NOT NULL,
  `Fiyat` int(50) NOT NULL,
  `id` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_turkish_ci;

--
-- Dökümü yapılmış tablolar için indeksler
--

--
-- Tablo için indeksler `kullanıcılar`
--
ALTER TABLE `kullanıcılar`
  ADD PRIMARY KEY (`KID`);

--
-- Tablo için indeksler `sepet`
--
ALTER TABLE `sepet`
  ADD PRIMARY KEY (`id`);

--
-- Dökümü yapılmış tablolar için AUTO_INCREMENT değeri
--

--
-- Tablo için AUTO_INCREMENT değeri `kullanıcılar`
--
ALTER TABLE `kullanıcılar`
  MODIFY `KID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=16;

--
-- Tablo için AUTO_INCREMENT değeri `sepet`
--
ALTER TABLE `sepet`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=65;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
