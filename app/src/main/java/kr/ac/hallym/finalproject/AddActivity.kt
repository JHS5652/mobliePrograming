package kr.ac.hallym.finalproject

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kr.ac.hallym.finalproject.databinding.ActivityAddBinding

class AddActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //setContentView(R.layout.activity_add)
        var binding = ActivityAddBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.input.setOnClickListener {
            val intent: Intent = Intent(this, CardViewActivity::class.java)
            val data1= binding.subject.toString()
            intent.putExtra("data1",data1)

            val data2= binding.subject.toString()
            intent.putExtra("data2",data2)

            val data3= binding.subject.toString()
            intent.putExtra("data3",data3)
            startActivity(intent)
            finish()
        }
    }

}