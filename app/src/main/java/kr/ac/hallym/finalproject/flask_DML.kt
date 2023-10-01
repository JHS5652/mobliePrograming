package kr.ac.hallym.finalproject

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import kr.ac.hallym.finalproject.databinding.FragmentFlaskDDLBinding


class flask_DML : Fragment() {
    lateinit var binding: FragmentFlaskDDLBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding = FragmentFlaskDDLBinding.inflate(layoutInflater)

        val contents1 = mutableListOf<Int>(R.drawable.ddl_create,R.drawable.ddl_alter,R.drawable.ddl_drop,R.drawable.dml_insert,R.drawable.dml_update,R.drawable.dml_delete)
//        contents1.add(R.drawable.flask)
        val contents2 = mutableListOf<String>("create 문을 이용하여 table 생성","alter문을 이용한 마일리지 컬럼 추가","alter문에서 drop을 이용하여 컬럼 삭제","insert문을 이용하여 데이터 삽입","update문을 이용하여 이미 추가된 데이터를 업데이트","delete를 사용하여 데이터 삭제")
//        contents2.add("flask")
        val contents3 = mutableListOf<String>("2022.09.10","2022.09.18","2022.09.23","2022.09.10","2022.09.10","2022.09.28")
//        contents3.add("데이터 베이스는")

        val contentsMain = mutableListOf<String>("table을 고객이라는 이름으로 만들고 ID와 고객명, 나이, 가입날자라는 컬럼을 만들","마일리지 추가","마일리지 삭제","4가지의 내용을 삽입함","고객명을 김진수, 나이를 21살로 업데이트","101이란 id를 가진 value를 삭제")


        binding.recyclerview.layoutManager = LinearLayoutManager(this.context)
        binding.recyclerview.adapter = MyAdapter(contents1,contents2,contents3,contentsMain)
        binding.recyclerview.addItemDecoration(
            DividerItemDecoration(this.context, LinearLayoutManager.VERTICAL)
        )


        return binding.root
    }

}