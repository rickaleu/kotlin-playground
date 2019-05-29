package br.com.ricardo.kotlinplayground

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_detail.*

class DetailActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

        detail_button_save.setOnClickListener {
            val name = detail_edit_name.text.toString()
            val age = detail_edit_age.text.toString().toInt()

            val person = Person(name, age)

            val intent = Intent()
            intent.putExtra("person", person)
            setResult(RESULT_OK, intent)
            finish()
        }
    }

    companion object {
        val EXTRA_PERSON = "people"
    }
}
