package yasuda.com.br.padorupadoru.db

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import yasuda.com.br.padorupadoru.entities.Padoru

@Dao
interface PadoruDao {

    @Insert
    fun  insert(padoru: Padoru)

    @Update
    fun update(padoru: Padoru)

    @Query("SELECT * FROM padoru")
    fun getpadoru(): Padoru?
}