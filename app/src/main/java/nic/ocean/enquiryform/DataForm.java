package nic.ocean.enquiryform;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;

import nic.ocean.enquiryform.databinding.ActivityDataFormBinding;
import nic.ocean.enquiryform.databinding.ActivityMainBinding;
import nic.ocean.enquiryform.model.FormModel;
import nic.ocean.enquiryform.utilities.KeysFormDeatails;

public class DataForm extends AppCompatActivity {

    private ActivityDataFormBinding dataFormBinding;
    Context context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_data_form);

        dataFormBinding = ActivityDataFormBinding.inflate(getLayoutInflater());
        setContentView(dataFormBinding.getRoot());
        context = this;

        //TODO : Getting Parceble Data from Intent
        Intent intent = getIntent();
        FormModel data = intent.getParcelableExtra(KeysFormDeatails.PARCEBLE_DATA);
        //Log.d("DATA", data.getfName()+" "+data.getlName());
        Log.d("Getting Parceble Data from Intent", data.getfName()+" "+data.getlName()+" "+data.getConNum()+" "+data.getGender()+" "+data.getEmail()+" "+data.getCourse());

    }
}