package nic.ocean.enquiryform;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import nic.ocean.enquiryform.databinding.ActivityMainBinding;
import nic.ocean.enquiryform.model.FormModel;
import nic.ocean.enquiryform.utilities.KeysFormDeatails;

public class MainActivity extends AppCompatActivity implements View.OnClickListener, RadioGroup.OnCheckedChangeListener {

    private ActivityMainBinding binding;
    Context context;
    private String gender = "";
    private String cbItemsText = "";
    private String fname,lname,conNum,email;
    String MobilePattern = "[0-9][10]";
    String emailPattern = "[a-zA-Z0-9._-]+@[a-z]+\\.+[a-z]+";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        context = this;

        binding.btnSubmitForm.setOnClickListener((View.OnClickListener) this);
        binding.btnReset.setOnClickListener((View.OnClickListener) this);
        //setContentView(R.layout.activity_main);
//        binding.radioGroupGender.setOnCheckedChangeListener(this);
//        binding.cbCybersecu.setOnCheckedChangeListener(this);
//        binding.cbJava.setOnCheckedChangeListener(this);
//        binding.cbAndroid.setOnCheckedChangeListener(this);
//        binding.cbPython.setOnCheckedChangeListener(this);
//        binding.cbCloudComp.setOnCheckedChangeListener(this);
//        binding.cbBigdata.setOnCheckedChangeListener(this);
//        binding.cbDevops.setOnCheckedChangeListener(this);
//        binding.cbMachineLearning.setOnCheckedChangeListener(this);
//        binding.cbFrontendDev.setOnCheckedChangeListener(this);
//        binding.cbBackendDev.setOnCheckedChangeListener(this);
//        binding.cbFullstackDev.setOnCheckedChangeListener(this);
//        binding.cbFlutter.setOnCheckedChangeListener(this);

//        binding.cbJava.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
//            @Override
//            public void onCheckedChanged(CompoundButton compoundButton, boolean isChecked) {
//                if (binding.cbJava.isChecked()) {
//                    cbItemsText += binding.cbJava.getText().toString();
//                    Toast.makeText(context, cbItemsText, Toast.LENGTH_SHORT).show();
//                }else {
//                    cbItemsText = "";
//                }
//            }
//        });
//        binding.cbAndroid.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
//            @Override
//            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
//                if(binding.cbAndroid.isChecked()){
//                    cbItemsText += binding.cbAndroid.getText().toString();
//                    //Toast.makeText(context, cbItemsText, Toast.LENGTH_SHORT).show();
//                }else {
//                    cbItemsText = "";
//                }
//            }
//        });
//        binding.cbPython.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
//            @Override
//            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
//                if(binding.cbPython.isChecked()){
//                    cbItemsText += binding.cbPython.getText().toString();
//                    //Toast.makeText(context, cbItemsText, Toast.LENGTH_SHORT).show();
//                }else {
//                    cbItemsText = "";
//                }
//            }
//        });
//        binding.cbCybersecu.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
//            @Override
//            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
//                if (binding.cbCybersecu.isChecked()) {
//                    cbItemsText += binding.cbCybersecu.getText().toString();
//                    //Toast.makeText(context, cbItemsText, Toast.LENGTH_SHORT).show();
//                }else {
//                    cbItemsText = "";
//                }
//            }
//        });
//        binding.cbCloudComp.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
//            @Override
//            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
//                if (binding.cbCloudComp.isChecked()) {
//                    cbItemsText += binding.cbCloudComp.getText().toString();
//                    //Toast.makeText(context, cbItemsText, Toast.LENGTH_SHORT).show();
//                }else {
//                    cbItemsText = "";
//                }
//            }
//
//        });
//        binding.cbBigdata.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
//            @Override
//            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
//                if (binding.cbBigdata.isChecked()) {
//                    cbItemsText += binding.cbBigdata.getText().toString();
//                    //Toast.makeText(context, cbItemsText, Toast.LENGTH_SHORT).show();
//                }else {
//                    cbItemsText = "";
//                }
//            }
//
//        });
//        binding.cbCybersecu.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
//            @Override
//            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
//                if (binding.cbCybersecu.isChecked()) {
//                    cbItemsText += binding.cbCybersecu.getText().toString();
//                    //Toast.makeText(context, cbItemsText, Toast.LENGTH_SHORT).show();
//                }else {
//                    cbItemsText = "";
//                }
//            }
//        });
//        binding.cbDevops.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
//            @Override
//            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
//                if (binding.cbDevops.isChecked()) {
//                    cbItemsText += binding.cbDevops.getText().toString();
//                    //Toast.makeText(context, cbItemsText, Toast.LENGTH_SHORT).show();
//                }else {
//                    cbItemsText = "";
//                }
//            }
//        });
//        binding.cbMachineLearning.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
//            @Override
//            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
//                if (binding.cbMachineLearning.isChecked()) {
//                    cbItemsText += binding.cbMachineLearning.getText().toString();
//                    //Toast.makeText(context, cbItemsText, Toast.LENGTH_SHORT).show();
//                }else {
//                    cbItemsText = "";
//                }
//            }
//        });
//        binding.cbFrontendDev.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
//            @Override
//            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
//                if (binding.cbFrontendDev.isChecked()) {
//                    cbItemsText += binding.cbFrontendDev.getText().toString();
//                    //Toast.makeText(context, cbItemsText, Toast.LENGTH_SHORT).show();
//                }else {
//                    cbItemsText = "";
//                }
//            }
//        });
//        binding.cbBackendDev.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
//            @Override
//            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
//                if (binding.cbBackendDev.isChecked()) {
//                    cbItemsText += binding.cbBackendDev.getText().toString();
//                    //Toast.makeText(context, cbItemsText, Toast.LENGTH_SHORT).show();
//                }else {
//                    cbItemsText = "";
//                }
//            }
//        });
//        binding.cbFullstackDev.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
//            @Override
//            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
//                if (binding.cbFullstackDev.isChecked()) {
//                    cbItemsText += binding.cbFullstackDev.getText().toString();
//                    //Toast.makeText(context, cbItemsText, Toast.LENGTH_SHORT).show();
//                }else {
//                    cbItemsText = "";
//                }
//            }
//        });
//        binding.cbFlutter.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
//            @Override
//            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
//                if (binding.cbFlutter.isChecked()) {
//                    cbItemsText += binding.cbFlutter.getText().toString();
//                    //Toast.makeText(context, cbItemsText, Toast.LENGTH_SHORT).show();
//                }else {
//                    cbItemsText = "";
//                }
//            }
//        });

        binding.cbJava.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (binding.cbJava.isChecked()) {
                    cbItemsText += binding.cbJava.getText().toString();
                    Toast.makeText(context, cbItemsText, Toast.LENGTH_SHORT).show();
                }else {
                    cbItemsText = "";
                }
            }
        });
        binding.cbAndroid.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (binding.cbAndroid.isChecked()) {
                    cbItemsText += binding.cbAndroid.getText().toString();
                    Toast.makeText(context, cbItemsText, Toast.LENGTH_SHORT).show();
                }else {
                    cbItemsText = "";
                }
            }
        });
        binding.cbPython.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (binding.cbPython.isChecked()) {
                    cbItemsText += binding.cbPython.getText().toString();
                    Toast.makeText(context, cbItemsText, Toast.LENGTH_SHORT).show();
                }else {
                    cbItemsText = "";
                }
            }
        });
        binding.cbCybersecu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (binding.cbCybersecu.isChecked()) {
                    cbItemsText += binding.cbCybersecu.getText().toString();
                    Toast.makeText(context, cbItemsText, Toast.LENGTH_SHORT).show();
                }else {
                    cbItemsText = "";
                }
            }
        });
        binding.cbCybersecu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (binding.cbCybersecu.isChecked()) {
                    cbItemsText += binding.cbCybersecu.getText().toString();
                    Toast.makeText(context, cbItemsText, Toast.LENGTH_SHORT).show();
                }else {
                    cbItemsText = "";
                }
            }
        });
        binding.cbCloudComp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (binding.cbCloudComp.isChecked()) {
                    cbItemsText += binding.cbCloudComp.getText().toString();
                    Toast.makeText(context, cbItemsText, Toast.LENGTH_SHORT).show();
                }else {
                    cbItemsText = "";
                }
            }
        });
        binding.cbBigdata.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (binding.cbBigdata.isChecked()) {
                    cbItemsText += binding.cbBigdata.getText().toString();
                    Toast.makeText(context, cbItemsText, Toast.LENGTH_SHORT).show();
                }else {
                    cbItemsText = "";
                }
            }
        });
        binding.cbDevops.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (binding.cbDevops.isChecked()) {
                    cbItemsText += binding.cbDevops.getText().toString();
                    Toast.makeText(context, cbItemsText, Toast.LENGTH_SHORT).show();
                }else {
                    cbItemsText = "";
                }
            }
        });
        binding.cbMachineLearning.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (binding.cbMachineLearning.isChecked()) {
                    cbItemsText += binding.cbMachineLearning.getText().toString();
                    Toast.makeText(context, cbItemsText, Toast.LENGTH_SHORT).show();
                }else {
                    cbItemsText = "";
                }
            }
        });
        binding.cbFrontendDev.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (binding.cbFrontendDev.isChecked()) {
                    cbItemsText += binding.cbFrontendDev.getText().toString();
                    Toast.makeText(context, cbItemsText, Toast.LENGTH_SHORT).show();
                }else {
                    cbItemsText = "";
                }
            }
        });
        binding.cbBackendDev.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (binding.cbBackendDev.isChecked()) {
                    cbItemsText += binding.cbBackendDev.getText().toString();
                    Toast.makeText(context, cbItemsText, Toast.LENGTH_SHORT).show();
                }else {
                    cbItemsText = "";
                }
            }
        });
        binding.cbFullstackDev.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (binding.cbFullstackDev.isChecked()) {
                    cbItemsText += binding.cbFullstackDev.getText().toString();
                    Toast.makeText(context, cbItemsText, Toast.LENGTH_SHORT).show();
                }else {
                    cbItemsText = "";
                }
            }
        });
        binding.cbFlutter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (binding.cbFlutter.isChecked()) {
                    cbItemsText += binding.cbFlutter.getText().toString();
                    Toast.makeText(context, cbItemsText, Toast.LENGTH_SHORT).show();
                }else {
                    cbItemsText = "";
                }
            }
        });


    }

    //radio group on checked change event
    @Override
    public void onCheckedChanged(RadioGroup radioGroup, int checkedId) {
        Log.d("Radio Group Checked Id :", "onCheckedChanged: " + checkedId);
        RadioButton radioButton = findViewById(checkedId);
        if (radioButton == null)return;
        //Toast.makeText(context, radioButton.getText().toString(), Toast.LENGTH_SHORT).show();
        gender = radioButton.getText().toString();
    }

    //on click event
    @Override
    public void onClick(View view) {

        switch (view.getId()){
            case R.id.btnSubmitForm:
//                binding.linearLayoutFormView.setVisibility(View.VISIBLE);
//                binding.btnReset.setVisibility(View.VISIBLE);
                validation();
                if (fname != null && lname != null && email != null && conNum != null && gender != null && cbItemsText != null) {

                    //selectedCourseView();
                    //TODO : Passing Parceble Data;
                    Intent intent = new Intent(context, FormModel.class);
                    FormModel dataParceble = new FormModel(binding.etFirstName.getText().toString(),
                                                            binding.etLastName.getText().toString(),
                                                            binding.etPhoneNum.getText().toString(),
                                                            binding.etEmail.getText().toString(),
                                                            gender,cbItemsText);
                    intent.putExtra(KeysFormDeatails.PARCEBLE_DATA, dataParceble);
                    startActivity(intent);
                    Log.d("Passing Parceble Data", "onClick: getting value through intent ---" + intent);
//                    binding.btnSubmitForm.setVisibility(View.GONE);
//                    binding.linearLayoutFormView.setVisibility(View.VISIBLE);
//                    binding.btnReset.setVisibility(View.VISIBLE);
//                    binding.tvName.setText(fname + " " + lname);
//                    binding.tvContactNum.setText(conNum);
//                    binding.tvEmail.setText(email);
//                    binding.tvGender.setText(gender);
//                    //selectedCourseView();
//                    binding.tvInterestedCourse.setText(cbItemsText);
                }

                break;
            case R.id.btnReset:
                    binding.linearLayoutFormView.setVisibility(View.GONE);
                    binding.btnReset.setVisibility(View.GONE);
                    binding.btnSubmitForm.setVisibility(View.VISIBLE);
                    binding.etFirstName.setText(null);
                    binding.etLastName.setText(null);
                    binding.etEmail.setText(null);
                    binding.etPhoneNum.setText(null);
                    binding.radioGroupGender.clearCheck();
                binding.cbJava.setChecked(false);
                binding.cbAndroid.setChecked(false);
                binding.cbPython.setChecked(false);
                binding.cbCloudComp.setChecked(false);
                binding.cbCybersecu.setChecked(false);
                binding.cbBackendDev.setChecked(false);
                binding.cbBigdata.setChecked(false);
                binding.cbDevops.setChecked(false);
                binding.cbMachineLearning.setChecked(false);
                binding.cbFlutter.setChecked(false);
                binding.cbFrontendDev.setChecked(false);
                binding.cbFullstackDev.setChecked(false);
                break;
        }
    }

    //validation for form fields
    private void validation() {
        fname = binding.etFirstName.getText().toString();
        lname = binding.etLastName.getText().toString();
        email = binding.etEmail.getText().toString();
        conNum = binding.etPhoneNum.getText().toString();

        if (TextUtils.isEmpty(binding.etFirstName.getText())){
            binding.etFirstName.setError("PLEASE ENTER FIRST NAME");
            binding.etFirstName.requestFocus();
        }
        else if (TextUtils.isEmpty(binding.etLastName.getText())){
            binding.etLastName.setError("PLEASE ENTER LAST NAME");
            binding.etLastName.requestFocus();
        }
        else if (TextUtils.isEmpty(binding.etPhoneNum.getText())){
            binding.etPhoneNum.setError("PLEASE ENTER CONTACT NUMBER");
            binding.etPhoneNum.requestFocus();
        }
        else if (TextUtils.isEmpty(binding.etEmail.getText())){
            binding.etEmail.setError("PLEASE ENTER EMAIL");
            binding.etEmail.requestFocus();
        }
        else if (TextUtils.isEmpty(gender)){
            Toast.makeText(context, "PLEASE SELECT YOUR GENDER !", Toast.LENGTH_SHORT).show();
        }
        else if (TextUtils.isEmpty(cbItemsText)){
            Toast.makeText(context, "PLEASE SELECT ANY ONE COURSE", Toast.LENGTH_SHORT).show();
        }
        else if (binding.etEmail.getText().toString().matches(emailPattern)){
            return;
        }
        else if (!binding.etEmail.getText().toString().matches(emailPattern)){
            binding.etEmail.setError("Please Enter Valid Email Address");
            binding.etEmail.requestFocus();
        }
        else if(!binding.etPhoneNum.getText().toString().matches(MobilePattern)) {

            binding.etPhoneNum.setError("Please enter valid 10 digit phone number");
            binding.etPhoneNum.requestFocus();

        }
        else if (binding.etPhoneNum.getText().toString().matches(MobilePattern)){
            return;
        }
    }


//    private void selectedCourseView() {
//
//        Toast.makeText(context, "--------------------------", Toast.LENGTH_SHORT).show();
//
//    }



//    @Override
//    public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
//
////        if (binding.cbJava.isChecked()) {
////            cbItemsText += binding.cbJava.getText().toString();
////        }
////        if (binding.cbFlutter.isChecked()){
////            cbItemsText += binding.cbFlutter.getText().toString();
////        }if (binding.cbAndroid.isChecked()){
////            cbItemsText += binding.cbAndroid.getText().toString();
////        }
////        if (binding.cbFullstackDev.isChecked()){
////            cbItemsText += binding.cbFullstackDev.getText().toString();
////        }if (binding.cbPython.isChecked()){
////            cbItemsText += binding.cbPython.getText().toString();
////        }if (binding.cbCybersecu.isChecked()){
////            cbItemsText += binding.cbCybersecu.getText().toString();
////        }if (binding.cbCloudComp.isChecked()){
////            cbItemsText += binding.cbCloudComp.getText().toString();
////        }if (binding.cbFullstackDev.isChecked()){
////            cbItemsText += binding.cbFullstackDev.getText().toString();
////        }if (binding.cbBigdata.isChecked()){
////            cbItemsText += binding.cbBigdata.getText().toString();
////        }if (binding.cbDevops.isChecked()){
////            cbItemsText += binding.cbDevops.getText().toString();
////        }if (binding.cbMachineLearning.isChecked()){
////            cbItemsText += binding.cbMachineLearning.getText().toString();
////        }if (binding.cbBackendDev.isChecked()){
////            cbItemsText += binding.cbBackendDev.getText().toString();
////        }if (binding.cbFrontendDev.isChecked()){
////            cbItemsText += binding.cbFrontendDev.getText().toString();
////        }
////        else {
////        cbItemsText = "";
////        }
////
////        Log.d("cbItemsText--------------", "onCheckedChanged: " + cbItemsText);
//    }
}