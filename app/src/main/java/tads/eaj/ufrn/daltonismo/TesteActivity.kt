package tads.eaj.ufrn.daltonismo

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import tads.eaj.ufrn.daltonismo.databinding.ActivityMainBinding
import tads.eaj.ufrn.daltonismo.databinding.ActivityTesteBinding

class TesteActivity : AppCompatActivity() {

    lateinit var  binding: ActivityTesteBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_teste)

        binding = DataBindingUtil.setContentView(this, R.layout.activity_teste)

        var param = intent.extras
        var num = param?.getInt("imagem")

        if (num == 1){
            binding.imageView.setImageResource(R.drawable.dt29)
        }else if (num == 2){
            binding.imageView.setImageResource(R.drawable.dt74)
        }else{
            binding.imageView.setImageResource(R.drawable.dt8)
        }

        binding.okButton.setOnClickListener {
            var intent = Intent()
            intent.putExtra("valor", binding.numeroEditTextNumber.text.toString())
            setResult(Activity.RESULT_OK, intent)
            finish()
        }

        binding.cancelarButton.setOnClickListener {
            val intent = Intent()
            intent.putExtra("CANCELAR", "Cancelou")
            setResult(Activity.RESULT_CANCELED, intent)
            finish()
        }

    }
}