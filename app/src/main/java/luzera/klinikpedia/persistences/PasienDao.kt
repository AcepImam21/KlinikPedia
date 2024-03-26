package luzera.klinikpedia.persistences

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Query
import luzera.klinikpedia.models.Pasien
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Delete

@Dao
interface PasienDao {

    @Query("select * from pasien")
    fun loadAll(): LiveData<List<Pasien>>

    @Query("select * from pasien where id = :id")
    fun load(id: String): LiveData<Pasien>

    @Query("select * from pasien where id = :id")
    suspend fun getById(id: String): Pasien?

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun upsert(vararg items: Pasien)

    @Query("delete from pasien where id = :id")
    suspend fun delete(id: String)

    @Delete
    suspend fun delete(item: Pasien)
}