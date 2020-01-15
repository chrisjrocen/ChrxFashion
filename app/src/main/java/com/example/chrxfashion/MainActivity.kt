package com.example.chrxfashion

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.fashion_ticket.view.*

class MainActivity : AppCompatActivity() {


    //desclare an array of the items
    var fashionList= ArrayList<item>()

    //declare a user adapter that holds data for each instance
    //fashionAdapter is user defined
    var adapter: fashionAdapter?=null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        //all items are decalred here
        fashionList.add(item("Shirt","Blue shirt",R.drawable.blue_shirt))
        fashionList.add(item("Cap","Baseball cap",R.drawable.cap))
        fashionList.add(item("Beard","Classic beard",R.drawable.chris_pic))
        fashionList.add(item("umbrella","Blue ans white umbrella",R.drawable.umbrellaa))
        fashionList.add(item("Shirt","White shirt",R.drawable.white_shirt))

        fashionList.add(item("Shirt","Blue shirt",R.drawable.blue_shirt))
        fashionList.add(item("Cap","Baseball cap",R.drawable.cap))
        fashionList.add(item("Beard","Classic beard",R.drawable.chris_pic))
        fashionList.add(item("umbrella","Blue ans white umbrella",R.drawable.umbrellaa))
        fashionList.add(item("Shirt","White shirt",R.drawable.white_shirt))

        fashionList.add(item("Shirt","Blue shirt",R.drawable.blue_shirt))
        fashionList.add(item("Cap","Baseball cap",R.drawable.cap))
        fashionList.add(item("Beard","Classic beard",R.drawable.chris_pic))
        fashionList.add(item("umbrella","Blue ans white umbrella",R.drawable.umbrellaa))
        fashionList.add(item("Shirt","White shirt",R.drawable.white_shirt))

        fashionList.add(item("Shirt","Blue shirt",R.drawable.blue_shirt))
        fashionList.add(item("Cap","Baseball cap",R.drawable.cap))
        fashionList.add(item("Beard","Classic beard",R.drawable.chris_pic))
        fashionList.add(item("umbrella","Blue ans white umbrella",R.drawable.umbrellaa))
        fashionList.add(item("Shirt","White shirt",R.drawable.white_shirt))




        //decalre an instance of the adapter
        adapter = fashionAdapter(fashionList,this)

       //code to display the items in the grid
        gvListItem.adapter =adapter


    }


    //class of the above adapter is created below with methods to be implemented

    class fashionAdapter:BaseAdapter {
        //define unstance of the class
        var fashionList= ArrayList<item>()
        var context: Context?=null

        //declare a constructor to initialise the instance of the class
        constructor(fashionList: ArrayList<item>,context: Context):super(){
            this.context=context
            this.fashionList=fashionList
        }

        //the following are the implemented methods of the class above
        override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {  //method to call the different items to be viewd in the grid

            val selectedItem = this.fashionList[position]

            //declare a var whihc is an instance of the layout inflator
            var inflatorVar = context!!.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
            //define the infaltor to display what is in the fashion_ticket
            var itemView =inflatorVar.inflate(R.layout.fashion_ticket,null)

            //image and item name are called inorder to be displayed
            itemView.ivImage.setImageResource(selectedItem.image!!)

            //set callback function to intent to another activity when the image is tapped
            itemView.ivImage.setOnClickListener(){
                val intent = Intent(context,Item_details::class.java) //intent from current context to the item_detials activity
                //declare the items to be dispalyed in the item_detials activity
                intent.putExtra("name",selectedItem.name!!)
                intent.putExtra("desc",selectedItem.desc!!)
                intent.putExtra("image",selectedItem.image!!)
                context!!.startActivity(intent)

            }

            itemView.tvName.text = selectedItem.name!!

            return itemView

        }

        override fun getItem(position: Int): Any { //returns a particular item in the array accordfinto the position
            return fashionList[position]

        }

        override fun getItemId(position: Int): Long {
            return position.toLong()
        }

        override fun getCount(): Int { //returns the number of items
            return fashionList.size
        }
    }
}
