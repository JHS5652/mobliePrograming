package kr.ac.hallym.finalproject

import android.animation.ObjectAnimator
import android.content.Intent
import android.os.Build.VERSION_CODES.S
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import android.view.MotionEvent
import android.widget.Toast
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.google.android.material.navigation.NavigationView
import com.google.android.material.snackbar.Snackbar
import com.google.android.material.tabs.TabLayoutMediator
import kr.ac.hallym.finalproject.databinding.ActivityCardViewBinding
class CardViewActivity : AppCompatActivity() , NavigationView.OnNavigationItemSelectedListener{
    lateinit var binding: ActivityCardViewBinding
    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        //setContentView(R.layout.activity_card_view)


        binding = ActivityCardViewBinding.inflate(layoutInflater)
        setContentView(binding.root)



        val contents1 = mutableListOf<Int>(R.drawable.middlepro,R.drawable.finalpro)
        //contents1.add(R.drawable.flask)
        val contents2 = mutableListOf<String>("오픈소스 하드웨어 중간 프로젝트","오픈소스 하드웨어 기말 프로젝트")
        //contents2.add("flask")
        val contents3 = mutableListOf<String>("2022.10.21","2022.12.01")
        //contents3.add("데이터 베이스는")
        val contentsMain = mutableListOf<String>("어두워지면 경고음을 발생시긴 후 LED를 킨다. 만약 버튼 스위치를 이용하여 긴급소등할 수 있도록 구현하였다.\n " +
                "조도 센서를 이용하였고 밝기를 상관하지 않고 LED를 점등한다. 거리를 정확히 확인하기 위하여 Serial모니터를 이용하였고, Serial 모니터를 이용하여 값을 확인한다. ",
                " 1. 동작설명 : 전시품 보안 시스템을 구현하였습니다. 저희는 우선 전시품의 입구 부분에 버튼을 통해 패스워드를 입력받고 패스워드를 LCD를 이용하여 우리에게 시각적으로 표현이 되고 만약 패스워드가 맞다면 서브모터를 이용하여 문이 열리는 식으로 첫 번째 보안 시스템을 구현하였습니다. 그리고 전시품 주변에는 조도센서와 LED를 이용하여 낮과 밤에서 전시품을 관람할 수 있도록 조도센서에 빛이 많이 들어온다면 LED가 꺼지고 빛이 적어지면 LED가 켜지는 식으로 조도센서를 활용한 편안한 관람을 구현하였습니다.\n" +
                        " 마지막으로 초음파센서와 피에조 센서, LED를 이용하여 만약 전시품이 사라진다면 즉, 초음파센서의 일정 거리를 벗어난다면 피에조 센서를 이용하여 경보음이 나고 LED가 깜빡이며 시각적으로도 도난 당했다는 것을 알 수 있게 구현하였습니다.")
        binding.recyclerview.layoutManager = LinearLayoutManager(this)
        binding.recyclerview.adapter = MyAdapter(contents1,contents2,contents3,contentsMain)
        binding.recyclerview.addItemDecoration(
            DividerItemDecoration(this, LinearLayoutManager.VERTICAL)
        )
        setSupportActionBar(binding.toolbar)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        val adapter = MyFragmentPagerAdapter(this)
        binding.viewpager.adapter  = adapter


        TabLayoutMediator(binding.tabs,binding.viewpager) { tab, position ->

            if(position==0){
                tab.text="Arduino"
            }else if(position==1){
                tab.text="Web"
            }else if(position==2){
                tab.text="SQL"
            }
        }.attach()

S
        binding.toolbar

        binding.mainFab.setOnClickListener {
            val intent = Intent(this,AddActivity::class.java)
            startActivity(intent)
            finish()
        }
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_main,menu)
        return super.onCreateOptionsMenu(menu)
    }


    override fun onBackPressed() {
        val intent = Intent(this, MainActivity::class.java)
        startActivity(intent)
        super.onBackPressed()
    }


    override fun onSupportNavigateUp(): Boolean {
    onBackPressed()
    return super.onSupportNavigateUp()
    }


    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        when(item.itemId){
            R.id.web ->  Log.d("kkang","네비게이션 드로우 실행")
            R.id.arduino -> {
                val intent = Intent(this,arduinoMain::class.java)
                startActivity(intent)
                finish()
                Log.d("kkang","네비게이션 드로우 실행")
            }

            R.id.arduino -> {
                val intent = Intent(this,CardViewActivity::class.java)
                startActivity(intent)
                finish()
                Log.d("kkang","네비게이션 드로우 실행")
            }

        }
        return false
    }


}
class MyFragmentPagerAdapter(activity: FragmentActivity) :FragmentStateAdapter(activity) {
    val fragments:List<Fragment>
    init {
        fragments = listOf(flask_first(),flask_DDL(),flask_DML())
    }
    override fun getItemCount(): Int = fragments.size

    override fun createFragment(position: Int): Fragment = fragments[position]
}

