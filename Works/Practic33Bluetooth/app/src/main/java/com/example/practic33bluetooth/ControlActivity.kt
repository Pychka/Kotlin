package com.example.practic33bluetooth

import android.bluetooth.BluetoothManager
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import androidx.activity.enableEdgeToEdge
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.practic33bluetooth.databinding.ActivityControlBinding
import kotlinx.coroutines.delay

class ControlActivity : AppCompatActivity() {
    private lateinit var binding: ActivityControlBinding
    private lateinit var actListLauncher: ActivityResultLauncher<Intent>
    lateinit var btConnection: BTConnection
    private var listItem: ListItem? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityControlBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setSupportActionBar(binding.toolbar)
        supportActionBar?.setDisplayShowTitleEnabled(true)

        init()
        onBtListResult()
        updateUI()
    }
    private fun updateUI() {
        listItem?.let { device ->
            binding.tvDeviceInfo.text = "Устройство: ${device.name}"
            binding.tvMacAddress.text = "MAC: ${device.mac}"
            binding.tvStatus.text = "Статус: Готово к подключению"
            binding.tvStatus.setTextColor(ContextCompat.getColor(this, R.color.green))
        } ?: run {
            binding.tvDeviceInfo.text = "Устройство не выбрано"
            binding.tvMacAddress.text = "MAC: ---"
            binding.tvStatus.text = "Статус: Не подключено"
            binding.tvStatus.setTextColor(ContextCompat.getColor(this, R.color.red))
        }
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.controlmenu, menu)
        return super.onCreateOptionsMenu(menu)
    }

    private fun init() {
        val btManager = getSystemService(BLUETOOTH_SERVICE) as BluetoothManager
        val btAdapter = btManager.adapter
        btConnection = BTConnection(btAdapter)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if(item.itemId == R.id.id_list){
            actListLauncher.launch(Intent(this, BTList::class.java))
        } else if(item.itemId == R.id.id_connect){
            listItem.let {
                btConnection.connect(it?.mac!!)
            }
        }
        return super.onOptionsItemSelected(item)
    }


    private fun onBtListResult() {
        actListLauncher = registerForActivityResult(
            ActivityResultContracts.StartActivityForResult()
        ) {
            binding.tvStatus.text = "Статус: подключение"
            if (it.resultCode == RESULT_OK) {
                listItem = it.data?.getSerializableExtra(BTList.DEVICE_KEY) as ListItem
                updateUI()
            }
            binding.tvStatus.text = "Статус: Готово к подключению"
        }
    }
}