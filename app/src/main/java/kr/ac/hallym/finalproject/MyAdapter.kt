package kr.ac.hallym.finalproject

import android.content.Context
import android.graphics.Color
import android.graphics.Rect
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.ViewCompat
import androidx.recyclerview.widget.RecyclerView
import kr.ac.hallym.finalproject.databinding.CardLayoutBinding

class MyViewHolder(val binding: CardLayoutBinding):RecyclerView.ViewHolder(binding.root)
class MyAdapter (val contents1: MutableList<Int>? ,val contents2: MutableList<String>? ,
                 val contents3: MutableList<String>?, val context: MutableList<String>?):RecyclerView.Adapter<RecyclerView.ViewHolder>(){
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder =
        MyViewHolder(CardLayoutBinding.inflate(LayoutInflater.from(parent.context),parent,false))


    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val binding = (holder as MyViewHolder).binding

        binding.imageView.setImageResource(contents1!![position])
        binding.titleText.text = contents2!![position]
        binding.detailText.text = contents3!![position]
        binding.contentMain.text = context!![position]
    }

    override fun getItemCount(): Int {
        return contents1?.size ?: 0
    }


}
class MyDecoration(val context:Context): RecyclerView.ItemDecoration(){
    override fun getItemOffsets(
        outRect: Rect,
        view: View,
        parent: RecyclerView,
        state: RecyclerView.State
    ) {
        super.getItemOffsets(outRect, view, parent, state)
        val index = parent.getChildAdapterPosition(view) +1
        if(index % 3==0)
            outRect.set(10,10,10,60)
        else
            outRect.set(10,10,10,0)
        view.setBackgroundColor(Color.parseColor("#28A0FF"))
        ViewCompat.setElevation(view, 20.0f)
    }
}