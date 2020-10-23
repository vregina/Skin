package com.example.skin.addchore.view

import android.content.Context
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.TextView
import com.example.skin.R

class SpinnerAdapter(
    private val values: List<String> = emptyList(),
    context: Context,
    resource: Int
) : ArrayAdapter<String>(context, resource) {

    override fun getCount() = values.size
    override fun getItem(position: Int) = values[position]
    override fun getItemId(position: Int) = 0L
    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        val tv = super.getView(position, convertView, parent) as TextView

        if (position == FIRST_ITEM) {
            tv.setTextColor(parent.resources.getColor(R.color.grayText))
        } else {
            tv.setTextColor(parent.resources.getColor(R.color.grayText))
        }
        tv.text = values[position]
        return tv
    }

    companion object {
        private const val FIRST_ITEM = 0
    }
}

