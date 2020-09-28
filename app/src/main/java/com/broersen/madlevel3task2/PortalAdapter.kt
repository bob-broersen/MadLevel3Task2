package com.broersen.madlevel3task2

import android.app.PendingIntent
import android.content.Intent
import android.net.Uri
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ExpandableListView
import androidx.browser.customtabs.CustomTabsIntent
import androidx.core.content.ContextCompat
import androidx.core.content.ContextCompat.startActivity
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.item_portal.view.*

class PortalAdapter (private val portals: List<Portal>, val clickListener: (Portal)->Unit) : RecyclerView.Adapter<PortalAdapter.ViewHolder>(){


    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        fun databind(portal: Portal){
            itemView.tvPortalTitle.text = portal.title
            itemView.tvPortalUrl.text = portal.url
            itemView.setOnClickListener{ clickListener(portal)}

        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.item_portal, parent, false)
        )
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.databind(portals[position])
    }

    override fun getItemCount(): Int {
        return portals.size
    }
}