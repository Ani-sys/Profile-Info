package com.example.profileinfo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.method.TextKeyListener.clear

import android.widget.EditText
import android.widget.Toast
import com.example.profileinfo.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding:ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)


        binding.btnSave.setOnClickListener {
            clickingOnSaveButton()
            isEmailValid() }

//        binding.btnClear.setOnLongClickListener {
//            EditText.clear()
//        }
    }

   private fun clickingOnSaveButton(){
        if (binding.etEmail.text.toString().isEmpty() || binding.etFirstName.text.toString().isEmpty() ||
            binding.etLastName.text.toString().isEmpty() || binding.etUsername.text.toString().isEmpty() ||
            binding.etAge.text.toString().isEmpty())
       {
           Toast.makeText(this,"Please enter all fields!",Toast.LENGTH_LONG).show()
       }
       else
       {
           charInUsername()
       }
   }

    private fun isEmailValid():Boolean
    {
        val email = binding.etEmail.text.toString()
      if (email.contains('@') && email.endsWith(".com")) {

          android.util.Patterns.EMAIL_ADDRESS.matcher(email).matches()
      }
      else{
          Toast.makeText(this,"E-mail is not valid!",Toast.LENGTH_LONG).show()
      }

        return android.util.Patterns.EMAIL_ADDRESS.matcher(email).matches()
    }

    private fun charInUsername()
    {
        val user = binding.etUsername.text.toString()
        val char:CharArray = user.toCharArray()
        if (user.isEmpty() || user.length < 10)
        {
            Toast.makeText(this,"Username must contain minimum 10 characters!",Toast.LENGTH_LONG).show()
        }
        else
        {
            Toast.makeText(this,"Your data has been successfully saved!",Toast.LENGTH_LONG).show()
        }

    }

    private fun EditText.clear()
    {
        binding.etEmail.clear()
        binding.etFirstName.clear()
        binding.etLastName.clear()
        binding.etUsername.clear()
        binding.etAge.clear()

    }

}


//       binding.etAge.text.toString().toInt() - რადგან, Age უნდა იყოს მთელი დადებითი რიცხვი, კოდის დაწერის გარეშეც, xml-ში EditText inputTypeში
//                                                 მივუთითე რომ შესაყვანი მონაცემები მხოლოდ ციფრები უნდა ყოფილიყო და სწორად მუშაობს,userს არ აქვს საშუალება
//                                                 რიცხვების შეყვანისას გამოიყენოს სიმბოლოები,როგორიცაა: ',', '.', '-'.
//                                                 თუმცა, ამ ვერსიასაც ვფიქრობდი სადაც კონვერტირება შეიძლება ტექსტის Integerში ან უშუალოდ ფუნქციაში გატანას Age-ს.


