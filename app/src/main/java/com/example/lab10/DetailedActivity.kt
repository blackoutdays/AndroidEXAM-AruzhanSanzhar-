package com.example.lab10
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.lab10.R
import androidx.viewpager.widget.ViewPager
import com.example.lab10.ImagePagerAdapter
import android.app.DatePickerDialog
import android.widget.ImageView
import android.widget.TextView
import java.text.SimpleDateFormat
import java.util.*

class DetailedActivity : AppCompatActivity() {
    private lateinit var calendarImage: ImageView
    private lateinit var textView4: TextView
    private lateinit var startDate: Calendar
    private lateinit var endDate: Calendar

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detailed)

        val viewPager: ViewPager = findViewById(R.id.viewPager)
        val adapter = ImagePagerAdapter(this, listOf(R.drawable.img_1, R.drawable.img_3, R.drawable.img_4))
        viewPager.adapter = adapter

        calendarImage = findViewById(R.id.calendar_image)
        textView4 = findViewById(R.id.textView4)

        // Initialize Calendar instances for start and end dates
        startDate = Calendar.getInstance()
        endDate = Calendar.getInstance()

        // Set OnClickListener for the calendar icon
        calendarImage.setOnClickListener {
            showDatePicker()
        }
    }

    private fun showDatePicker() {
        val calendar = Calendar.getInstance()
        val year = calendar.get(Calendar.YEAR)
        val month = calendar.get(Calendar.MONTH)
        val day = calendar.get(Calendar.DAY_OF_MONTH)

        val datePickerDialog = DatePickerDialog(
            this,
            { _, selectedYear, selectedMonth, selectedDay ->
                if (startDate.timeInMillis == 0L) {
                    startDate.set(selectedYear, selectedMonth, selectedDay)
                    textView4.text = SimpleDateFormat("dd/MM/yyyy", Locale.getDefault()).format(startDate.time)
                } else {
                    endDate.set(selectedYear, selectedMonth, selectedDay)
                    val dateFormat = SimpleDateFormat("dd/MM/yyyy", Locale.getDefault())
                    val startDateString = dateFormat.format(startDate.time)
                    val endDateString = dateFormat.format(endDate.time)
                    val dateRangeText = getString(R.string.date_range_format, startDateString, endDateString)
                    textView4.text = dateRangeText
                }
            },
            year,
            month,
            day
        )

        // If start date is already selected, set min date for end date picker
        if (startDate.timeInMillis != 0L) {
            datePickerDialog.datePicker.minDate = startDate.timeInMillis
        }

        datePickerDialog.show()
    }
}

