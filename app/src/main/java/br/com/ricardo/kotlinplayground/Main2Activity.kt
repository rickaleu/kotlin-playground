package br.com.ricardo.kotlinplayground

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import kotlinx.android.synthetic.main.activity_main2.*

class Main2Activity : AppCompatActivity() {

    private val people : MutableList<Person> by lazy { mutableListOf<Person>() }
    private var adapter : ArrayAdapter<Person>? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)

        main_button_add_new.setOnClickListener {
            val intent = Intent(this, DetailActivity::class.java)
            startActivityForResult(intent, REQUEST_INSERT)
        }

        adapter = ArrayAdapter<Person>(this, android.R.layout.simple_list_item_1, people)
        list_people.adapter = adapter

    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        if(requestCode == REQUEST_INSERT && resultCode == RESULT_OK){
            val person = data?.getSerializableExtra(DetailActivity.EXTRA_PERSON) as? Person

            if(person != null){
                people.add(person)
                adapter?.notifyDataSetChanged()
            }
        }
    }

    companion object {
        val REQUEST_INSERT = 0
    }
}
