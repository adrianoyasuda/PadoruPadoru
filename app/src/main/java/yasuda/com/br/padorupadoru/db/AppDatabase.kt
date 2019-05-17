package yasuda.com.br.padorupadoru.db

import androidx.room.Database
import androidx.room.RoomDatabase
import yasuda.com.br.padorupadoru.entities.Padoru


@Database(entities = arrayOf(Padoru::class),version = 1)
abstract class AppDatabase: RoomDatabase() {
    abstract fun padoruDao(): PadoruDao
}