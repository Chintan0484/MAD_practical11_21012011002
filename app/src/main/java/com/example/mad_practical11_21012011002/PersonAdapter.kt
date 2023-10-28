package com.example.mad_practical11_21012011002

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.google.android.material.button.MaterialButton

class PersonAdapter (val context: Context, val PersonArray:ArrayList<Person>):RecyclerView.Adapter<PersonAdapter.PersonViewHolder>() {

    inner class PersonViewHolder(val view:View):RecyclerView.ViewHolder(view)



    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PersonViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.person_item, parent, false)
        return PersonViewHolder(view)

    }

    override fun getItemCount(): Int {
        return PersonArray.size
    }


    override fun onBindViewHolder(holder: PersonViewHolder, position: Int) {
        val view=holder.view
        view.findViewById<TextView>(R.id.name).text = PersonArray[position].name
        view.findViewById<TextView>(R.id.mobile).text = PersonArray[position].phoneNo
        view.findViewById<TextView>(R.id.emailid).text = PersonArray[position].emailId
        view.findViewById<TextView>(R.id.address).text = PersonArray[position].address
        view.findViewById<MaterialButton>(R.id.btnLocation).setOnClickListener {
            Intent(context, MapsActivity::class.java).putExtra("Object", PersonArray[position])
                .apply { context.startActivity(this) }}

    }
}
