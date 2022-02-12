package nic.ocean.enquiryform;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import nic.ocean.enquiryform.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity implements View.OnClickListener, RadioGroup.OnCheckedChangeListener{

    private ActivityMainBinding binding;
    Context context;

//    EditText etFirstName, etLastName, etConNum, etEmail;
//    RadioGroup rgGender;
//    RadioButton rbMale, rbFemale, rbOther;
//    CheckBox cbCourse1, cbCourse2, cbCourse3, cbCourse4,
//            cbCourse5, cbCourse6, cbCourse7, cbCourse8,
//            cbCourse9, cbCourse10, cbCourse11, cbCourse12;
//    Button btnSubmit, btnReset;
    String gender = "", cbItemsText = "";
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

        binding.cbCourse1.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean isChecked) {
                cbItemsText = binding.cbCourse1.getText().toString();
            }
        });

    }
    @Override
    public void onCheckedChanged(RadioGroup radioGroup, int checkedId) {
        RadioButton radioButton = findViewById(checkedId);
        Toast.makeText(context, radioButton.getText().toString(), Toast.LENGTH_SHORT).show();
        gender = radioButton.getText().toString();
    }

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
//                else if (TextUtils.isEmpty(gender)){
//                    Toast.makeText(context, "PLEASE SELECT YOUR GENDER !", Toast.LENGTH_SHORT).show();
//                }
                else if (TextUtils.isEmpty(cbItemsText)){
                    Toast.makeText(context, "PLEASE SELECT ANY TWO COURSE", Toast.LENGTH_SHORT).show();
                }
                else if (fname != null || lname != null || email != null || conNum != null || gender != null || cbItemsText != null) {

                    binding.btnSubmitForm.setVisibility(View.GONE);
                    binding.linearLayoutFormView.setVisibility(View.VISIBLE);
                    binding.btnReset.setVisibility(View.VISIBLE);

                    binding.tvName.setText(fname + " " + lname);
                    binding.tvContactNum.setText(conNum);
                    binding.tvEmail.setText(email);
                    binding.tvGender.setText(gender);
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
                binding.cbCourse1.setChecked(false);
                binding.cbCourse2.setChecked(false);
                binding.cbCourse3.setChecked(false);
                binding.cbCourse4.setChecked(false);
                binding.cbCourse6.setChecked(false);
                binding.cbCourse7.setChecked(false);
                binding.cbCourse8.setChecked(false);
                binding.cbCourse9.setChecked(false);
                binding.cbCourse10.setChecked(false);
                binding.cbCourse11.setChecked(false);
                binding.cbCourse12.setChecked(false);

                break;
        }
    }



}