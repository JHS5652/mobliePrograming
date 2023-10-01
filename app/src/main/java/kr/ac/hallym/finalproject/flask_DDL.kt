package kr.ac.hallym.finalproject

import android.app.Activity
import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import kr.ac.hallym.finalproject.databinding.ActivityCardViewBinding
import kr.ac.hallym.finalproject.databinding.FragmentFlaskDDLBinding

class flask_DDL : Fragment() {
    lateinit var binding: FragmentFlaskDDLBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding = FragmentFlaskDDLBinding.inflate(layoutInflater)

        val contents1 = mutableListOf<Int>(R.drawable.web1,R.drawable.web)
        val contents2 = mutableListOf<String>("첫번째 시작 페이지","블로그 전체 페이지")
        val contents3 = mutableListOf<String>("2022.12.12","2022.12.13")
        val contentsMain = mutableListOf<String>("첫번째 시작페이지 배경화면을 최근에 전역한 나의 모습을 나타내기 위하여 전역 당일 사진을 추가하였고 버튼을 클릭시 홈페이지로 들어가게된다.",
            "홈페이지의 메뉴에는 나의 이력서, 모바일 프로그래밍, 데이터 베이스, 아두이노가 있고 클릭시에 각각에 맞는 홈페이지로 너어가게 된다. 그리고 왼쪽에는 세부 메뉴를 넣어서 더 쉽게 가시적으로 볼 수 있다. 또한" +
                    "또한 iframe안의 오른쪽의 사이드 바를 보게되면 4가지의 태그가 보이는데 이것을 클릭할 시에는 각각에 맞는 내용으로 iframe내에서 이동하게 된다. 마지막으로 iframe위의 홈 아이콘을 누르게 되면 " +
                    "다시 첫번째 군대 배경화면 사진으로 이동한다. ")
        binding.recyclerview.layoutManager = LinearLayoutManager(this.context)
        binding.recyclerview.adapter = MyAdapter(contents1,contents2,contents3,contentsMain)
        binding.recyclerview.addItemDecoration(
            DividerItemDecoration(this.context, LinearLayoutManager.VERTICAL)
        )
        return binding.root
    }
}