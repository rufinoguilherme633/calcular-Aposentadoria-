package com.guilherme.livroKotlin

import android.app.Activity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.EditText
import android.widget.Spinner
import android.widget.TextView


class MainActivity : Activity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val spn_sexo = findViewById<Spinner>(R.id.spn_sexo)
        val txt_idade = findViewById<EditText>(R.id.txt_idade)
        val btn_calcular = findViewById<Button>(R.id.btn_calcular)
        val txt_resultado = findViewById<TextView>(R.id.txt_resultado)

        spn_sexo.adapter = ArrayAdapter<String>(this,android.R.layout.simple_spinner_dropdown_item, listOf("masculino","feminino"))

        btn_calcular.setOnClickListener {
            // Aqui estamos pegando o valor selecionado pelo usuário e guardando numa variável

           /* spn_sexo.selectedItem: spn_sexo é o Spinner que foi definido anteriormente e selectedItem é uma propriedade do Spinner que retorna o item selecionado no momento. O retorno desse valor é do tipo Any, ou seja, pode ser qualquer tipo de objeto.
           as String: O operador as é usado para realizar uma operação de "casting" ou "conversão de tipo". Neste caso, estamos tentando converter o valor retornado de spn_sexo.selectedItem para o tipo String. No entanto, se o item selecionado não for uma String, isso pode resultar em uma exceção, se o tipo real do item não puder ser convertido para String.*/
            val  sexo = spn_sexo.selectedItem as String

            //pegar idade digitada
            val idade = txt_idade.text.toString().toInt()
            /*
            * txt_idade.text retorna o conteúdo do EditText como um objeto do tipo Editable.
            toString() transforma esse conteúdo de Editable para String.
            toInt() converte essa representação de string para um valor inteiro, assumindo que o */
            var resultado = 0
            if(sexo == "masculino") {
                resultado = 65 - idade
            }
            else{
                resultado = 60 - idade
            }
            txt_resultado.text = "Faltam $resultado anos para você se aposentar"
        }
    }

}