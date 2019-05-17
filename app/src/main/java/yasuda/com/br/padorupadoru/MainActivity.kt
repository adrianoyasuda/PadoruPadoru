package yasuda.com.br.padorupadoru

import android.media.MediaPlayer
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.animation.AnimationUtils
import android.widget.Toast
import androidx.room.Room
import kotlinx.android.synthetic.main.activity_main.*
import yasuda.com.br.padorupadoru.db.AppDatabase
import yasuda.com.br.padorupadoru.db.PadoruDao
import yasuda.com.br.padorupadoru.entities.Padoru
import kotlin.random.Random

class MainActivity : AppCompatActivity() {

    lateinit var padoru : MediaPlayer
    lateinit var padoruDao: PadoruDao
    var count = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val db =
            Room.databaseBuilder(
                applicationContext,
                AppDatabase::class.java,
                "padoru.db"
            )
                .allowMainThreadQueries()
                .build()
        padoruDao = db.padoruDao()


        if(padoruDao.getpadoru() != null) {
            count = padoruDao.getpadoru()!!.count
            txt_count.text = count.toString()
        }
        else{
            val pad = Padoru()
            padoruDao.insert(pad)
        }

        img_padoru.setOnClickListener{
            press()
        }
    }

    private fun press (){

        val pad = padoruDao.getpadoru()
        var shake = AnimationUtils.loadAnimation(this, R.anim.shakeanimation)

        var rand = Random.nextInt(0,2)

        if(rand == 1){
            shake = AnimationUtils.loadAnimation(this, R.anim.shakeanimation2)
        }
        if (rand == 2){
//            muda imagem and trigged sound
        }

        Toast.makeText(this, "Padoru PADORUUUU!!!",Toast.LENGTH_LONG ).show()

        padoru = MediaPlayer.create(this, R.raw.padoru_padoru)
        padoru.start()

        img_padoru.animation = shake
        txt_count.text = count.toString()

        if (pad != null) {
            pad.count = count
            padoruDao.update(pad)
        }
        count++
    }
}
