package com.example.practic17

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowCompat.enableEdgeToEdge
import androidx.core.view.WindowInsetsCompat
import androidx.viewpager2.widget.ViewPager2
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator

class MainActivity : AppCompatActivity() {
    private lateinit var adapter: NumberAdapter
    private lateinit var viewPager: ViewPager2
    private lateinit var tabLayout: TabLayout
    private val tabNumbers: Array<Int> = arrayOf(
        R.drawable.baseline_send_black_36,
        R.drawable.baseline_send_black_36,
        R.drawable.baseline_send_black_36,
        R.drawable.baseline_send_black_36,
        R.drawable.baseline_send_black_36,
        R.drawable.baseline_send_black_36,
        R.drawable.baseline_send_black_36,
        R.drawable.baseline_send_black_36,
        R.drawable.baseline_send_black_36,
        R.drawable.baseline_send_black_36,
    )
    private val tabNames: Array<String> = arrayOf(
        "Первый",
        "Второй",
        "Третий",
        "Четвертый",
        "Пятый",
        "Шестой",
        "Седьмой",
        "Восьмой",
        "Девятый",
        "Десятый",
    )
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        adapter = NumberAdapter(this)
        viewPager = findViewById(R.id.pager)
        viewPager.adapter = adapter

        tabLayout = findViewById(R.id.tab_layout)
        TabLayoutMediator(tabLayout, viewPager) { tab, position ->
            tab.text = tabNames[position]


            tab.setIcon(tabNumbers[position])

            if (position == 2) {
                val badge = tab.getOrCreateBadge()
                badge.number = 1
            }

        }.attach()

    }
}