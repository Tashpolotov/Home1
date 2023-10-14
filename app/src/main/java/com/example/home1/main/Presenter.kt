package com.example.home1.main

import com.example.home1.model.CountModel
import com.example.home1.view.CounterView

class Presenter {

    var model = CountModel()
    lateinit var view : CounterView

    fun increment(){
        model.increment()
        view.getCounter(model.count)
        if (model.count == 10) {
            model.toast
            view.getShowToast()
        } else if (model.count == 15) {
            model.setColortText
            view.getSetTextColor()
        }


    }
    fun attachView(view: CounterView){
     this.view = view
    }
}