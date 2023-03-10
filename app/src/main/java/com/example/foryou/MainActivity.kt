package com.example.foryou

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.activity.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.foryou.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    lateinit var adapter: Adapter
 val viewModel:MyViewModel by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        initAdapter()


        binding.addBtn.setOnClickListener {
            viewModel.addButton()
        }


        viewModel.listLiveData.observe(this){

            adapter.list=it
        }




    }


    fun initAdapter(){
        adapter= Adapter(this::childPlusOnCLick,this::childMinusOnCLick,this::parentPlusOnCLick,this::parentMinusOnCLick)
        binding.rv.adapter=adapter
        binding.rv.layoutManager=LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false)


    }

    private fun parentMinusOnCLick(position:Int,model:MyModel) {

        viewModel.minusParent(position,model)

    }

    private fun parentPlusOnCLick(position:Int,model:MyModel) {
        if (viewModel.parentCount()<10) {
  viewModel.plusParent(position,model)
        }else{

            Toast.makeText(this,"Превышен",Toast.LENGTH_SHORT).show()
        }


    }

    private fun childMinusOnCLick(position:Int,model:MyModel) {

        viewModel.minusChild(position,model)


    }

    private fun childPlusOnCLick(position:Int,model: MyModel) {
        if (viewModel.childCount()<10) {

            viewModel.plusChild(position, model)
        }else{

            Toast.makeText(this,"Превышен",Toast.LENGTH_SHORT).show()
        }


    }



}