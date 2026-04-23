# 🧱 Jobin: Solusi Praktis untuk Tombol Rusak

[![Build Status](https://img.shields.io/github/actions/workflow/status/alfathrzqii/jobin/android.yml?branch=main)](https://github.com/USERNAME/REPO/actions)

**Jobin** adalah aplikasi Android super ringan yang berjalan di latar belakang (tanpa antarmuka pengguna yang rumit) untuk menyediakan tombol pintas di _Quick Settings Tiles_ (Pusat Kontrol).

Aplikasi ini diciptakan khusus untuk mengatasi masalah umum di mana tombol fisik volume perangkat rusak, dan tombol daya (_power button_) secara otomatis terhubung dengan Google Assistant atau Gemini, sehingga menyulitkan pengguna untuk sekadar mengubah volume suara atau melakukan _reboot_ (memulai ulang) perangkat.

Nama **Jobin** sendiri diambil dari bahasa Jawa yang berarti "Ubin" atau _Tile_ — sangat selaras dengan konsep _Quick Settings Tiles_ pada sistem operasi Android.

---

## ✨ Fitur Utama

- **4 Pintasan Quick Settings (Tiles) Kustom:**
  - 🔊 **Volume Naik**
  - 🔉 **Volume Turun**
  - 🎛️ **Panel Volume**
  - ⏻ **Menu Daya** (_Power Dialog_)
- **Super Ringan & Hemat Baterai:** Ukuran aplikasi sangat kecil (< 2MB) dan tidak membebani sistem.
- **Tampilan Bersih:** Aplikasi akan menghilang dari laci aplikasi (_app drawer_) setelah proses pengaturan awal selesai.

---

## 🛠️ Tech Stack

Aplikasi ini dibangun menggunakan teknologi berikut untuk memastikan performa yang cepat dan efisien:
- **Native Android (Kotlin)**
- **XML & Material Design 3** (khusus untuk layar pengaturan awal)
- **GitHub Actions** (untuk proses CI/CD)

---

## 🚀 Panduan Instalasi & Pengaturan

Karena aplikasi ini tidak tersedia di Google Play Store (di-_sideload_) dan memerlukan izin tingkat tinggi, silakan ikuti langkah-langkah penting di bawah ini untuk menginstal dan menggunakan Jobin:

### Langkah 1: Download
Unduh file APK Jobin versi terbaru dari halaman bagian **Releases** di repositori GitHub ini.

### Langkah 2: Melewati Play Protect (_Bypass Play Protect_)
Google Play Protect mungkin akan memblokir instalasi karena aplikasi ini meminta izin `AccessibilityService` dan tidak ditandatangani (_unsigned_) oleh Play Store.
- Nonaktifkan sementara Google Play Protect di aplikasi Play Store Anda.
- Lanjutkan dan instal APK Jobin.
- Aktifkan kembali Play Protect setelah instalasi selesai.

### Langkah 3: Izinkan Setelan Terbatas (Khusus Android 13+)
Pada Android 13 atau yang lebih baru, sistem membatasi izin aksesibilitas untuk aplikasi yang di-_sideload_. Sebelum memberikan izin:
- Buka **Info Aplikasi** (_App Info_) untuk Jobin di pengaturan perangkat Anda.
- Ketuk **ikon tiga titik** di sudut kanan atas.
- Pilih **"Izinkan setelan terbatas"** (_Allow restricted settings_).

### Langkah 4: Berikan Izin Aksesibilitas
- Buka aplikasi Jobin.
- Klik tombol pengaturan (_setup_) yang tersedia.
- Anda akan diarahkan ke pengaturan Aksesibilitas perangkat. Temukan layanan **Jobin** dan aktifkan.

### Langkah 5: Tambahkan _Tiles_ (Pintasan)
- Usap layar dari atas ke bawah untuk membuka panel **Quick Settings** (Pusat Kontrol).
- Ketuk ikon **Edit** (biasanya berbentuk pensil).
- Cari _tiles_ Jobin (Volume Naik, Volume Turun, Panel Volume, dan Menu Daya).
- Seret (tahan dan geser) _tiles_ tersebut ke area aktif di panel atas Anda.

---

## 🛡️ Mengapa Butuh Aksesibilitas? (Transparansi Privasi)

Jobin meminta izin `AccessibilityService` bukan untuk melacak aktivitas Anda. Sistem operasi Android secara bawaan **tidak mengizinkan** aplikasi biasa untuk memicu atau menampilkan dialog Menu Daya (_Power Menu_) secara langsung. Satu-satunya cara resmi untuk melakukannya adalah melalui layanan Aksesibilitas.

**Kami menjamin privasi Anda:**
- ❌ Aplikasi ini **TIDAK** melacak atau membaca konten layar Anda.
- ❌ Aplikasi ini **TIDAK** mengumpulkan data pribadi apa pun.
- ❌ Aplikasi ini **TIDAK** terhubung ke internet.

Jobin sepenuhnya aman, transparan, dan _open-source_.
