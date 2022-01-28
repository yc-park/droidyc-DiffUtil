package yc.droid.diffutil

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import yc.droid.diffutil.databinding.SampleItemBinding

class SampleAdapter(dataSet: List<Sample>) : RecyclerView.Adapter<SampleAdapter.ViewHolder>() {
  private var itemList: List<Sample> = dataSet

  override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
    val layoutInflater = parent.context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
    val binding = SampleItemBinding.inflate(layoutInflater, parent, false)

    return ViewHolder(binding)
  }

  override fun onBindViewHolder(holder: ViewHolder, position: Int) {
    holder.bind(itemList[position])
  }

  override fun getItemCount(): Int = itemList.size

  fun updateItems(items: List<Sample>) {
    val diffCallback = SampleDiffCallback(itemList, items)
    val diffResult = DiffUtil.calculateDiff(diffCallback)

    diffResult.dispatchUpdatesTo(this)
    itemList = items
  }

  class ViewHolder(private val binding: SampleItemBinding) : RecyclerView.ViewHolder(binding.root) {
    fun bind(item: Sample) {
      binding.sample = item
    }
  }
}