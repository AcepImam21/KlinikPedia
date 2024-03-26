package luzera.klinikpedia.persistences

import androidx.room.Database
import androidx.room.RoomDatabase
import luzera.klinikpedia.models.Pasien

@Database(entities = [Pasien::class], version = 1, exportSchema = false)
abstract class AppDatabase : RoomDatabase(){
    abstract fun pasienDao(): PasienDao

    companion object {
        const val DATABASE_NAME = "pasien_database"
    }
}