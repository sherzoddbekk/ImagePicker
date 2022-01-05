package com.example.imagepicker

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.ImageView
import androidx.activity.result.contract.ActivityResultContracts

class MainActivity : AppCompatActivity() {
    private  lateinit var selectedImage: ImageView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initView()
    }
    fun initView(){
        val imagePickButton = findViewById<Button>(R.id.button_pickImage)
        selectedImage = findViewById(R.id.image_selected_image)
        imagePickButton.setOnClickListener {
            pickImage()
        }
    }
   private fun pickImage(){
       val intent = Intent(Intent.ACTION_GET_CONTENT)
       intent.type = "image/*"
       intent.putExtra(Intent.EXTRA_ALLOW_MULTIPLE,true)
       launcher.launch(intent)
    }
    var launcher = registerForActivityResult(ActivityResultContracts.StartActivityForResult()){
        if(it.resultCode == RESULT_OK){
            val image = it.data!!.data
            selectedImage.setImageURI(image)

        }
    }
}