package com.example.recyleviewtugas

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.recyleviewtugas.databinding.ItemPesanBinding


typealias OnClickGmail = (pesanGmail) -> Unit
class GmailAdapter(private val listpesangmail : List<pesanGmail>, private val onclickGmail : OnClickGmail) : RecyclerView.Adapter<GmailAdapter.ItemPesanViewHolder>() {
    inner class ItemPesanViewHolder(private val binding: ItemPesanBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(data: pesanGmail) {
            with(binding) {
                val previewText = data.titlePesan.split(" ").take(4).joinToString(" ") + "…"
                txtNamaPengirim.text = data.pengirimPesan
                txtTanggal.text = data.tanggalPesan
                txtTitle.text = previewText
                itemView.setOnClickListener {
                    onclickGmail(data)
                }
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemPesanViewHolder {
        val binding =
            ItemPesanBinding.inflate(
                LayoutInflater.from(parent.context), parent,
                false)
        return ItemPesanViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return listpesangmail.size
    }

    override fun onBindViewHolder(holder: ItemPesanViewHolder, position: Int) {
        holder.bind(listpesangmail[position])
    }
}