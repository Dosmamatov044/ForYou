package com.example.foryou

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.foryou.databinding.DataItemBinding

class Adapter(val childPlusOnCLick:(Int,MyModel)->Unit,val childMinusOnCLick:(Int,MyModel)->Unit,val parentPlusOnCLick:(Int,MyModel)->Unit,val parentMinusOnCLick:(Int,MyModel)->Unit):RecyclerView.Adapter<Adapter.MyViewHolder>() {

var list= mutableListOf<MyModel>()


set(value) {
    field=value
    notifyDataSetChanged()

}




    class MyViewHolder(val binding:DataItemBinding):RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {


        return  MyViewHolder(DataItemBinding.inflate(LayoutInflater.from(parent.context),parent,false))
    }

    override fun getItemCount(): Int {
        return  list.size
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {

        val binding=holder.binding

        binding.parentTextId.text=list[position].list.parent.toString()
        binding.childTextId.text=list[position].list.child.toString()

        binding.roomId.text="Комната ${list[position].roomName}"


        binding.childMinusId.setOnClickListener {
            childMinusOnCLick(position,list[position])
        }

        binding.childPlusId.setOnClickListener {
            childPlusOnCLick(position,list[position])


        }


        binding.parentPlusId.setOnClickListener {
            parentPlusOnCLick(position,list[position])

        }

binding.parentMinusId.setOnClickListener {

    parentMinusOnCLick(position,list[position])


}



    }


}