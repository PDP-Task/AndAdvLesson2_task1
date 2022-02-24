package uz.context.andadlesson2_task1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import uz.context.andadlesson2_task1.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var bin: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        bin = ActivityMainBinding.inflate(layoutInflater)
        setContentView(bin.root)

        initViews()
    }
    private fun initViews() {
        val prefsManager = PrefsManager.getInstance(this)
        bin.btnSave.setOnClickListener {
            try {
                val long = bin.editLong.text.toString().trim().toLong()
                val boolean = bin.editBoolean.text.toString().trim().toBoolean()
                val int = bin.editInt.text.toString().trim().toInt()
                val float = bin.editFloat.text.toString().trim().toFloat()
                val string = bin.editStr.text.toString()

                prefsManager!!.apply {
                    saveLong("long",long)
                    saveBoolean("boolean",boolean)
                    saveInt("int",int)
                    saveFloat("float",float)
                    saveString("str",string)
                }
                Toast.makeText(this, "$long, $boolean, $int, $float, $string", Toast.LENGTH_SHORT).show()
            }catch (e: Exception) {
                e.printStackTrace()
                Toast.makeText(this, "Enter texts correctly!", Toast.LENGTH_SHORT).show()
            }
        }

        bin.btnView.setOnClickListener {
            val key = bin.editKey.text.toString().trim()
            Toast.makeText(this, "${prefsManager!!.getData(key)}", Toast.LENGTH_SHORT).show()
        }
    }
}