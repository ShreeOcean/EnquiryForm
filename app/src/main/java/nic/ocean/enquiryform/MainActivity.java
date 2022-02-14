package nic.ocean.enquiryform;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
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

public class MainActivity extends AppCompatActivity implements View.OnClickListener, RadioGroup.OnCheckedChangeListener,CompoundButton.OnCheckedChangeListener{

    private ActivityMainBinding binding;
    Context context;

//    EditText etFirstName, etLastName, etConNum, etEmail;
//    RadioGroup rgGender;
//    RadioButton rbMale, rbFemale, rbOther;
//    CheckBox cbCourse1, cbCourse2, cbCourse3, cbCourse4,
//            cbCourse5, cbCourse6, cbCourse7, cbCourse8,
//            cbCourse9, cbCourse10, cbCourse11, cbCourse12;
//    Button btnSubmit, btnReset;
    private String gender = "", cbItemsText = "";
    String fname,lname,conNum,email;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        context = this;

        binding.btnSubmitForm.setOnClickListener((View.OnClickListener) this);
        binding.btnReset.setOnClickListener((View.OnClickListener) this);
        //setContentView(R.layout.activity_main);
        binding.radioGroupGender.setOnCheckedChangeListener(this);
        binding.cbCybersecu.setOnCheckedChangeListener(this);
        binding.cbJava.setOnCheckedChangeListener(this);
        binding.cbAndroid.setOnCheckedChangeListener(this);
        binding.cbPython.setOnCheckedChangeListener(this);
        binding.cbCloudComp.setOnCheckedChangeListener(this);
        binding.cbBigdata.setOnCheckedChangeListener(this);
        binding.cbDevops.setOnCheckedChangeListener(this);
        binding.cbMachineLearning.setOnCheckedChangeListener(this);
        binding.cbFrontendDev.setOnCheckedChangeListener(this);
        binding.cbBackendDev.setOnCheckedChangeListener(this);
        binding.cbFullstackDev.setOnCheckedChangeListener(this);
        binding.cbFlutter.setOnCheckedChangeListener(this);
//        binding.cbJava.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
//            @Override
//            public void onCheckedChanged(CompoundButton compoundButton, boolean isChecked) {
//                if (binding.cbJava.isChecked()) {
//                    cbItemsText = binding.cbJava.getText().toString() + ", ";
//                }
//            }
//        });
//        binding.cbAndroid.setOnCheckedChangeListener((compoundButton, b) ->{
//            if(binding.cbAndroid.isChecked()){
//                cbItemsText = binding.cbAndroid.getText().toString() + ", ";
//            }
//        });
//        binding.cbPython.setOnCheckedChangeListener((compoundButton, b) -> {
//            if(binding.cbPython.isChecked()){
//                cbItemsText = binding.cbPython.getText().toString() + ", ";
//            }
//        });
//        binding.cbCybersecu.setOnCheckedChangeListener((compoundButton, b) -> {
//            if (binding.cbCybersecu.isChecked()) {
//                cbItemsText = binding.cbCybersecu.getText().toString() + ", ";
//            }
//        });



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
                else if (fname != null && lname != null && email != null && conNum != null && gender != null && cbItemsText != null) {

                    binding.btnSubmitForm.setVisibility(View.GONE);
                    binding.linearLayoutFormView.setVisibility(View.VISIBLE);
                    binding.btnReset.setVisibility(View.VISIBLE);
                    binding.tvName.setText(fname + " " + lname);
                    binding.tvContactNum.setText(conNum);
                    binding.tvEmail.setText(email);
                    binding.tvGender.setText(gender);
                    //selectedCourseView();
                    binding.tvInterestedCourse.setText(cbItemsText);
                }

                break;
            case R.id.btnReset:
                    binding.linearLayoutFormView.setVisibility(View.GONE);
                    binding.btnReset.setVisibility(View.GONE);
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

    private void selectedCourseView() {

        String result = ", ";
        if (binding.cbJava.isChecked()){
            binding.tvInterestedCourse.setText(binding.cbJava.getText() + result);
        }if (binding.cbAndroid.isChecked()){
            binding.tvInterestedCourse.setText(binding.cbAndroid.getText() + result);
        }if (binding.cbPython.isChecked()){
            binding.tvInterestedCourse.setText(binding.cbPython.getText() + result);
        }if(binding.cbCybersecu.isChecked()){
            binding.tvInterestedCourse.setText(binding.cbCybersecu.getText() + result);
        }if (binding.cbCloudComp.isChecked()){
            binding.tvInterestedCourse.setText(binding.cbCloudComp.getText() + result);
        }if (binding.cbBigdata.isChecked()){
            binding.tvInterestedCourse.setText(binding.cbBigdata.getText() + result);
        }if (binding.cbDevops.isChecked()){
            binding.tvInterestedCourse.setText(binding.cbDevops.getText() + result);
        }if(binding.cbMachineLearning.isChecked()){
            binding.tvInterestedCourse.setText(binding.cbMachineLearning.getText() + result);
        }if (binding.cbFrontendDev.isChecked()){
            binding.tvInterestedCourse.setText(binding.cbFrontendDev.getText() + result);
        }if (binding.cbBackendDev.isChecked()){
            binding.tvInterestedCourse.setText(binding.cbBackendDev.getText() + result);
        }if (binding.cbFullstackDev.isChecked()){
            binding.tvInterestedCourse.setText(binding.cbFullstackDev.getText() + result);
        }if(binding.cbFlutter.isChecked()){
            binding.tvInterestedCourse.setText(binding.cbFlutter.getText() + result);
        }
    }


    @Override
    public void onCheckedChanged(CompoundButton compoundButton, boolean b) {

    }
}