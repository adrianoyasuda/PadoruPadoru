package yasuda.com.br.padorupadoru.entities

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "padoru")
data class Padoru(var count: Int = 0){
    @PrimaryKey(autoGenerate = true)
    var id: Int = 0
}