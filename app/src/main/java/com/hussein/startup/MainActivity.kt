package com.hussein.startup

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import  kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.food_ticket.view.*

class MainActivity : AppCompatActivity() {

    var adapter:FoodAdapter?=null
    var listOfFoods =ArrayList<Food>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // load products
        listOfFoods.add(Food("Refrigerator"," This 236 L  will be a stylish and efficient addition to your home. It ensures that the freshness of your fruits, veggies, and other items is locked for up to 24 hours. This way, you can safely eat and cook with the perishables throughout the day. Its Anti-bacterial Removable Gasket ensures that your food stays fresh and germ-free to ensure safe consumption.     Starting bid at $130 ",R.drawable.refrigerator))
        listOfFoods.add(Food("Washing Machine"," If you are looking for a smart and efficient washing machine, then this front-load washing machine is ideal for you. Its steam cycle removes stubborn stains by cleaning your clothes with steam, which originates from the bottom of the drum. On top of that, the quick wash feature allows you to clean your lightly soiled clothes in a jiffy. Furthermore, the eco drum clean feature not only reminds you to clean the drum, but it also ensures that it is cleaned in a chemical-free way.     Starting bid at $112 " ,R.drawable.washing_machine))
        listOfFoods.add(Food("Television","Bring home this TV and experience the stunning visuals that result from its Chroma Boost Picture Engine. Boasting a Bezel-less design and Dolby Surround Audio, this Android TV blends right into your decor and offers you audio performance that makes your favourite TV shows, movies, and other video content all the more enjoyable.     Starting Bid at $360 ",R.drawable.tv))
        listOfFoods.add(Food("Air Conditioner"," Enjoy soothing cool air during summers and comfortable warmness during winters in your home with the Hot and Cold Split Inverter AC. This home appliance features an HD Filter to give you clean air, a durable Copper Condenser for effective cooling, and a Fast Cooling Mode to offer instant relief during summers.     Starting Bid at $250",R.drawable.air_conditioner))
        listOfFoods.add(Food("Laptop"," This laptop features an AMD Ryzen 5 4600H processor so that you can enjoy a powerful gaming performance, every time. With Bluetooth 5.0, you can enjoy quick connections. And, with a long-lasting battery life, you can enjoy gaming or working on projects for a long time .     Starting Bid at $800 ",R.drawable.laptop2))
        listOfFoods.add(Food("Microwave"," Delight your loved ones to a tasty meal that you prepare with the help of this 23 L microwave oven . It is designed to quickly defrost your food, so that you don’t have to waste time by waiting for your ingredients to thaw. It also has the Keep Warm Function that keeps your food warm inside the oven, without overheating it.     Starting Bid at $200",R.drawable.microwave))
        adapter= FoodAdapter(this,listOfFoods)

        gvListFood.adapter =adapter

    }


    class  FoodAdapter:BaseAdapter {
        var listOfFood= ArrayList<Food>()
        var context:Context?=null
        constructor(context:Context,listOfFood:ArrayList<Food>):super(){
            this.context=context
            this.listOfFood=listOfFood
        }
        override fun getView(p0: Int, p1: View?, p2: ViewGroup?): View {
            val food = this.listOfFood[p0]
            var inflator = context!!.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
            var foodView= inflator.inflate(R.layout.food_ticket,null)
            foodView.ivFoodImage.setImageResource(food.image!!)
            foodView.ivFoodImage.setOnClickListener {

                val intent = Intent(context,FoodDetails::class.java)
                intent.putExtra("name",food.name!!)
                intent.putExtra("des",food.des!!)
                intent.putExtra("image",food.image!!)
                context!!.startActivity(intent)
            }
            foodView.tvName.text =  food.name!!
            return  foodView

        }

        override fun getItem(p0: Int): Any {
            return listOfFood[p0]
        }

        override fun getItemId(p0: Int): Long {
           return p0.toLong()
        }

        override fun getCount(): Int {

            return listOfFood.size
        }

    }
}
