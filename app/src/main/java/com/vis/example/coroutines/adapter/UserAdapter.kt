package com.vis.example.coroutines.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.vis.example.coroutines.R
import com.vis.example.coroutines.data.local.entity.User
import kotlinx.android.synthetic.main.item_layout.view.*

class UserAdapter(
    private val users: ArrayList<User>
) : RecyclerView.Adapter<UserAdapter.DataViewHolder>() {
    private var listener: ((User) -> Unit)? = null

    class DataViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bind(user: User) {
            itemView.textViewUserName.text = user.name
            itemView.textViewUserEmail.text = user.email
            Glide.with(itemView.imageViewAvatar.context)
                .load(user.avatar)
                .into(itemView.imageViewAvatar)

        }
    }
    fun setUserClickListener(listener: (User) -> Unit) {
        this.listener = listener
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
        DataViewHolder(
            LayoutInflater.from(parent.context).inflate(
                R.layout.item_layout, parent,
                false
            )
        )

    override fun getItemCount(): Int = users.size

    override fun onBindViewHolder(holder: DataViewHolder, position: Int)// =
       // holder.bind(users[position])
        {
            val user = users[position]
            holder.bind(user)
        }


    fun addData(list: List<User>) {
        users.addAll(list)
    }

}