fun main() {
    // Fonksiyonları test etmek için örnek çağrılar
    println("İç açılar toplamı: ${icAciToplami(5)}")
    println("Maaş: ${maasHesapla(22)} ₺")
    println("Kota Ücreti: ${kotaUcretiHesapla(55)} ₺")
    println("Derece Fahrenheit: ${dereceToFahrenheit(30.0)} °F")
    println("Dikdörtgen Çevresi: ${dikdortgenCevresi(5, 10)}")
    println("5! = ${faktoriyel(5)}")
    println("'Merhaba' kelimesinde 'a' harfi sayısı: ${harfSayisi("Merhaba", 'a')}")
}

// 1. Kenar sayısına göre iç açılar toplamı
fun icAciToplami(kenarSayisi: Int): Int {
    return (kenarSayisi - 2) * 180
}

// 2. Gün sayısına göre maaş hesabı
fun maasHesapla(gunSayisi: Int): Int {
    val saatlikUcret = 10
    val mesaiUcret = 20
    val normalSaat = 8 * gunSayisi
    return if (normalSaat <= 160) {
        normalSaat * saatlikUcret
    } else {
        val mesaiSaat = normalSaat - 160
        (160 * saatlikUcret) + (mesaiSaat * mesaiUcret)
    }
}

// 3. Kota miktarına göre ücret hesaplama
fun kotaUcretiHesapla(kullanilanGB: Int): Int {
    val sabitUcret = 100
    val sabitGB = 50
    val ekGBUcreti = 4

    return if (kullanilanGB <= sabitGB) {
        sabitUcret
    } else {
        sabitUcret + (kullanilanGB - sabitGB) * ekGBUcreti
    }
}

// 4. Dereceyi Fahrenheit'a çevirme
fun dereceToFahrenheit(celsius: Double): Double {
    return (celsius * 1.8) + 32
}

// 5. Dikdörtgen çevresi hesaplama
fun dikdortgenCevresi(kisaKenar: Int, uzunKenar: Int): Int {
    return 2 * (kisaKenar + uzunKenar)
}

// 6. Sayının faktöriyelini hesaplama
fun faktoriyel(sayi: Int): Int {
    var sonuc = 1
    for (i in 1..sayi) {
        sonuc *= i
    }
    return sonuc
}

// 7. Bir kelimede belirli bir harften kaç adet olduğunu bulma
fun harfSayisi(kelime: String, harf: Char): Int {
    return kelime.count { it == harf }
}
