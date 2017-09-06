package com.test.bobi.kotlintest

import android.app.Activity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast


class KotlinActivity : Activity(), View.OnClickListener {


    var tvTest: TextView? = null/**使用?是为了标识此变量可为空值*/
    var btnTest: Button?=null
    var editInput:EditText?=null


    /**
     * Lambda表达式简单的使用，只会简单的，难的不会
     */
    var sum = {x: Int,y: Int ->x+y }




    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_kotlin)

        tvTest= findViewById(R.id.tv_test) as TextView/**kotlin里绑定控件的方式*/
        btnTest= findViewById(R.id.btn_test) as Button
        editInput=findViewById(R.id.edit_input) as EditText

        /**kotlin里设置监听的方式1，不需要使用new XXXListener,可以直接写需要实现的代码*/
        tvTest!!.setOnClickListener({
            Toast.makeText(this,"test1",Toast.LENGTH_LONG).show()
        })

        /**kotlin里设置监听的方式2*/
        tvTest!!.setOnClickListener(this)
        btnTest!!.setOnClickListener(this)
    }

    /**kotlin里设置监听的方式2，另外kotlin里没有switch，使用when替代*/
    override fun onClick(v: View?) {
        when(v!!.id){
            R.id.tv_test-> {
                sum(1,2)
//                forTest()
//                Toast.makeText(this, sum(6,6).toString(), Toast.LENGTH_LONG).show()

            }
            else -> {
                rangeTest(editInput!!.text.toString())
//                Toast.makeText(this, isWahtClass("我命由我不由天"), Toast.LENGTH_LONG).show()
//                if(isInt("123")!=null){
//                    Toast.makeText(this, isInt("123").toString(), Toast.LENGTH_LONG).show()
//                }
            }
        }
    }

    /**kotlin中自定义方法1*/
    fun getSum(a:Int,b:Int):String{
        return (a+b).toString()
    }

    /**kotlin中自定义方法2 不需要写返回类型*/
    fun getSum2(a:Int,b:Int){
        Toast.makeText(this, (a+b).toString(), Toast.LENGTH_LONG).show()
    }

    /**kotlin中自定义方法3 作为表达式使用*/
    fun getSum3(a:Int,b:Int)=a+b

    /**kotlin中null检测，toIntOrNull如果不是数字便返回null，同理还有其他的如toFloatOrNull等方法*/
    fun isInt(str:String):Int?{
        return str.toIntOrNull()
    }
    /**kotlin中is检测对象是否属于某个类型，另外java中的object类似乎在kotlin中是any*/
    fun isWahtClass(obj:Any):String?{
        if (obj is String){
            return "这是String类型"
        }else if (obj is Int){
            return "这是Int类型"
        }
        return null
    }
    /**kotlin中for循环的使用2种方式，以及集合的使用,while的使用还是和java的一样，就不写了*/
    fun forTest(){
        val items= listOf("天要灭我我灭天","我命由我不由天")
        for(item in items){
            Toast.makeText(this, item, Toast.LENGTH_SHORT).show()
        }
//        for(index in items.indices){
//            Toast.makeText(this, items[index], Toast.LENGTH_SHORT).show()
//        }
    }
    /**kotlin中的区间，检测数字是否在指定范围内，in也能用在集合中*/
    fun rangeTest(num:String){
        if(!num.isNullOrEmpty()&&num.toFloatOrNull()!=null){
            if (num.toFloat() in 1..10){//in代表属于
                Toast.makeText(this, "属于", Toast.LENGTH_SHORT).show()
            }else{
                Toast.makeText(this, "不属于", Toast.LENGTH_SHORT).show()
            }

        }

        if(!num.isNullOrEmpty()&&num.toFloatOrNull()!=null){
            if (num.toFloat() !in 1..10){//!in代表不属于
                Toast.makeText(this, "不属于", Toast.LENGTH_SHORT).show()
            }else{
                Toast.makeText(this, "属于", Toast.LENGTH_SHORT).show()
            }

        }
    }

    fun testArray(array:List<String>){

    }
}
