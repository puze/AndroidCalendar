package com.puze.androiodcalendar

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.GridLayoutManager
import com.puze.androiodcalendar.databinding.ActivityMainBinding
import java.util.*
import kotlin.collections.ArrayList

class MainActivity : AppCompatActivity() {
    private val calendar = Calendar.getInstance()

    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // 레이아웃 디자인
        val numberOfWeek = 7
        val layoutManager = GridLayoutManager(baseContext, numberOfWeek)

        binding.calendar.calendarContents.layoutManager = layoutManager

        setCalendar()
        setMonth()
    }

    private fun setCalendar() {
        val dataSet = ArrayList<CalendarItem>()
        calendar.set(Calendar.DAY_OF_MONTH, 1)
        val maxDay = calendar.getActualMaximum(Calendar.DAY_OF_MONTH)
        val dayPadding = calendar.get(Calendar.DAY_OF_WEEK)

        // 1일이 해당하는 요일까지 패딩 (1일이 수요일이라면 일, 월, 화요일이 패딩)
        for (i in 1 until dayPadding) {
            dataSet.add(CalendarItem(0))
        }

        // 실제 캘린더에 들어갈 데이터 작성
        for (i in 1..maxDay) {
            calendar.set(Calendar.DAY_OF_MONTH, i)
            dataSet.add(
                CalendarItem(
                    i
                )
            )
        }
        // binding
        binding.calendar.calendarContents.adapter = CalendarAdapter(dataSet)
    }

    private fun setMonth() {
        binding.calendar.calendarMonth.text = "${calendar.get(Calendar.MONTH)}월"
    }
}