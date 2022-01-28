package yc.droid.diffutil

import androidx.recyclerview.widget.DiffUtil

class SampleDiffCallback(
  private val oldSampleList: List<Sample>,
  private val newSampleList: List<Sample>
) : DiffUtil.Callback() {
  override fun getOldListSize(): Int = oldSampleList.size

  override fun getNewListSize(): Int = newSampleList.size

  override fun areItemsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean =
    oldSampleList[oldItemPosition].id == newSampleList[newItemPosition].id

  override fun areContentsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean =
    oldSampleList[oldItemPosition].title == newSampleList[newItemPosition].title &&
    oldSampleList[oldItemPosition].buttonText == newSampleList[newItemPosition].buttonText


}