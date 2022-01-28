package yc.droid.diffutil

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.databinding.ObservableArrayList
import yc.droid.diffutil.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
  private val binding: ActivityMainBinding by lazy {
    DataBindingUtil.setContentView(this, R.layout.activity_main)
  }

  private val firstSampleList = listOf(
    Sample("1a", "title0", "button0"),
    Sample("2b", "title1", "button1"),
    Sample("3c", "title2", "button2"),
    Sample("4d", "title3", "button3"),
    Sample("5e", "title4", "button4"),
  )

  private val secondSampleList = listOf(
    Sample("1a", "title0", "button0"),
    Sample("2b", "tt1", "btn1"),
    Sample("3c", "tt2", "btn2"),
    Sample("5e", "title4", "button4"),
    Sample("4d", "title3", "button3"),
  )

  private val sampleAdapter = SampleAdapter(firstSampleList)


  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContentView(R.layout.activity_main)
    binding.mainActivity = this
    binding.sampleRecyclerView.adapter = sampleAdapter
  }

  fun setFirstOnSampleList() {
    sampleAdapter.updateItems(firstSampleList)
  }

  fun setSecondOnSampleList() {
    sampleAdapter.updateItems(secondSampleList)
  }
}