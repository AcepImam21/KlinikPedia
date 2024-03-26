package luzera.klinikpedia.models

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Pasien(
    @PrimaryKey
    val id: String,
    val namaPasien: String,
    val umur: String,
    val gejala: String,
    val resepObat: String,
    val tanggalMasuk: String,
)