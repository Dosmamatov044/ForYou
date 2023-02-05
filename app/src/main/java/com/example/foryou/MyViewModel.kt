package com.example.foryou

import android.app.Application
import android.widget.Toast
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MyViewModel(application: Application):AndroidViewModel(application) {
    var i=1
    val list= mutableListOf<MyModel>()
    val listLiveData=MutableLiveData<MutableList<MyModel>>()


    init {

    }


    fun addButton(){

        list.add(MyModel(i, list =ChildModel(0,0) ,0))

        listLiveData.value=list
     i++
    }

    fun plusChild(position:Int,model:MyModel){
var childCount=model.childCount
        childCount++
        val childModel=ChildModel(childCount,model.list.parent)

        val models=MyModel(position,childModel,childCount)

        list[position] = models
        listLiveData.value=list

    }

    fun minusChild(position:Int,model:MyModel){
   var     childCount=model.childCount
if (childCount>=1) {
    childCount--
    val childModel = ChildModel(childCount, model.list.parent)

    val models = MyModel(position, childModel,childCount)

    list[position] = models
    listLiveData.value=list
}else{
    Toast.makeText(getApplication(),"Не может быть меньше 0",Toast.LENGTH_SHORT).show()

}



    }

}