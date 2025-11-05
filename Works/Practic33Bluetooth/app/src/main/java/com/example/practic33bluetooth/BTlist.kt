package com.example.practic33bluetooth

import android.Manifest
import android.bluetooth.BluetoothAdapter
import android.bluetooth.BluetoothDevice
import android.bluetooth.BluetoothManager
import android.content.Intent
import android.content.pm.PackageManager
import android.os.Bundle
import android.util.Log
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.practic33bluetooth.databinding.ActivityBtlistBinding

class BTList : AppCompatActivity(), RcAdapter.Listener  {
    companion object{
        const val DEVICE_KEY = "device_key"
    }
    private var btAdapter: BluetoothAdapter? = null
    private lateinit var binding: ActivityBtlistBinding
    private lateinit var adapter: RcAdapter


    private val requestPermissionLauncher = registerForActivityResult(
        ActivityResultContracts.RequestPermission()
    ) { isGranted ->
        if (isGranted) {
            // Разрешение предоставлено, получаем устройства
            getPairedDevises()
        } else {
            // Разрешение не предоставлено, показываем сообщение
            Log.e("BTList", "Bluetooth permission denied")
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityBtlistBinding.inflate(layoutInflater)
        setContentView(binding.root)
        adapter = RcAdapter(this)
        binding.rcView.layoutManager = LinearLayoutManager(this)
        binding.rcView.adapter = adapter
        init()
        checkPermissionsAndGetDevices()
    }

    private fun checkPermissionsAndGetDevices() {
        if (ContextCompat.checkSelfPermission(this, Manifest.permission.BLUETOOTH_CONNECT) == PackageManager.PERMISSION_GRANTED) {
            getPairedDevises()
        } else {
            requestPermissionLauncher.launch(Manifest.permission.BLUETOOTH_CONNECT)
        }
    }

    private fun init(){
        val btManager = getSystemService(BLUETOOTH_SERVICE) as BluetoothManager
        btAdapter = btManager.adapter
    }


    private fun getPairedDevises() {
        if (ContextCompat.checkSelfPermission(this, Manifest.permission.BLUETOOTH_CONNECT)
            != PackageManager.PERMISSION_GRANTED) {
            return
        }

        val pairedDevices: Set<BluetoothDevice>? = btAdapter?.bondedDevices
        val tempList = ArrayList<ListItem>()
        pairedDevices?.forEach {
            tempList.add(ListItem(it.name, it.address))
        }
        adapter.submitList(tempList)
    }

    override fun onClick(item: ListItem) {
        val i= Intent().apply {
            putExtra(DEVICE_KEY, item)
        }
        setResult(RESULT_OK, i)
        finish()
    }
}