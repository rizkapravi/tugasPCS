package com.example.tokoserbaserbi.ui.resep

import android.content.Context
import android.content.Intent
import androidx.databinding.ViewDataBinding
import com.bumptech.glide.Glide
import com.example.tokoserbaserbi.R
import com.example.tokoserbaserbi.data.model.Resep
import com.example.tokoserbaserbi.databinding.ItemResepBinding
import com.example.tokoserbaserbi.ui.base.BaseAdapter

class ResepAdapter(val context: Context) : BaseAdapter<Resep>(R.layout.item_resep) {
    override fun onBind(binding: ViewDataBinding?, data: Resep) {
        val mBinding = binding as ItemResepBinding
        Glide.with(context).load(data.thumb).into(mBinding.itemThumb)
    }


    override fun onClick(binding: ViewDataBinding?, data: Resep) {
        val intent = Intent(context, ResepActivity::class.java)
        intent.putExtra(ResepActivity.OPEN_RESEP, data)
        context.startActivity(intent)
    }
}