package tads.eaj.ufrn.daltonismo

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import tads.eaj.ufrn.daltonismo.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding

    val MY_REQUEST_CODE_1 = 1
    val MY_REQUEST_CODE_2 = 2
    val MY_REQUEST_CODE_3 = 3

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        binding.resposta1TextView.text = "0"
        binding.resposta2TextView.text = "0"
        binding.resposta3TextView.text = "0"


        binding.teste1Button.setOnClickListener {
            var intent = Intent(this, TesteActivity::class.java)
            var param = Bundle()
            param.putInt("imagem", 1)
            intent.putExtras(param)
            startActivityForResult(intent, MY_REQUEST_CODE_1)
        }
        binding.teste2Button.setOnClickListener {
            var intent = Intent(this, TesteActivity::class.java)
            var param = Bundle()
            param.putInt("imagem", 2)
            intent.putExtras(param)
            startActivityForResult(intent, MY_REQUEST_CODE_2)
        }
        binding.teste3Button.setOnClickListener {
            var intent = Intent(this, TesteActivity::class.java)
            var param = Bundle()
            param.putInt("imagem", 3)
            intent.putExtras(param)
            startActivityForResult(intent, MY_REQUEST_CODE_3)
        }


        binding.verificaButton.setOnClickListener {
            if ( binding.resposta1TextView.text == "0" || binding.resposta2TextView.text == "0" ||  binding.resposta3TextView.text == "0"){
                Toast.makeText(this, "Realize todos os testes", Toast.LENGTH_SHORT).show()
            }else if ( binding.resposta1TextView.text == "29" && binding.resposta2TextView.text == "74" &&  binding.resposta3TextView.text == "8"){
                binding.resultadoTextView.text = "Você é normal"
            }else{
                binding.resultadoTextView.text = "Procurar um médico"
            }
        }

    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
            super.onActivityResult(requestCode, resultCode, data)
            when(requestCode){
                MY_REQUEST_CODE_1->{
                    when (resultCode){
                        Activity.RESULT_OK->{
                            val param = data?.extras
                            val textoResultado = param?.getString("valor")
                            binding.resposta1TextView.text = textoResultado
//                            Toast.makeText(this, "A resposta é $textoResultado", Toast.LENGTH_SHORT).show()
                            }
                        Activity.RESULT_CANCELED->{
                            Toast.makeText(this, "Cancelou", Toast.LENGTH_SHORT).show()
                        }
                    }
                }
                MY_REQUEST_CODE_2->{
                    when (resultCode){
                        Activity.RESULT_OK->{
                            val param = data?.extras
                            val textoResultado = param?.getString("valor")
                            binding.resposta2TextView.text = textoResultado
//                            Toast.makeText(this, "A resposta é $textoResultado", Toast.LENGTH_SHORT).show()
                        }
                        Activity.RESULT_CANCELED->{
                            Toast.makeText(this, "Cancelou", Toast.LENGTH_SHORT).show()
                        }
                    }
                }
                MY_REQUEST_CODE_3->{
                    when (resultCode){
                        Activity.RESULT_OK->{
                            val param = data?.extras
                            val textoResultado = param?.getString("valor")
                            binding.resposta3TextView.text = textoResultado
//                            Toast.makeText(this, "A resposta é $textoResultado", Toast.LENGTH_SHORT).show()
                        }
                        Activity.RESULT_CANCELED->{
                            Toast.makeText(this, "Cancelou", Toast.LENGTH_SHORT).show()
                        }
                    }
                }
            }
        }

}