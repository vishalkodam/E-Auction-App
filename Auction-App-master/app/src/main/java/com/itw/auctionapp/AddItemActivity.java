package com.itw.auctionapp;

import android.app.DatePickerDialog;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.CompoundButton;
import android.widget.DatePicker;

import androidx.appcompat.app.AppCompatActivity;

import com.itw.auctionapp.databinding.ActivityAddItemBinding;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class AddItemActivity extends AppCompatActivity implements View.OnFocusChangeListener {

    ActivityAddItemBinding activityAddItemBinding;
    int mYear, mDay, mMonth;
    List<String> bool = new ArrayList<>();
    ArrayAdapter<String> itemCategory;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        activityAddItemBinding = ActivityAddItemBinding.inflate(getLayoutInflater());
        setContentView(activityAddItemBinding.getRoot());

        activityAddItemBinding.termsCheckBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    activityAddItemBinding.addItemButton.setEnabled(true);
                } else {
                    activityAddItemBinding.addItemButton.setEnabled(false);
                }
            }
        });
        activityAddItemBinding.closingDate.setOnFocusChangeListener(this);
        activityAddItemBinding.startDate.setOnFocusChangeListener(this);

        activityAddItemBinding.originality.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
                activityAddItemBinding.originality.setEnabled(false);
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if (activityAddItemBinding.originality.getText().toString().toUpperCase().equals("YES")) {
                    activityAddItemBinding.addDocuments.setEnabled(true);
                } else {
                    activityAddItemBinding.addDocuments.setEnabled(false);
                }
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
        setupET();

    }

    private void setupET() {
        bool.add("Yes");
        bool.add("No");
        itemCategory = new ArrayAdapter<>(this, R.layout.simple_list_item, bool);
        activityAddItemBinding.originality.setAdapter(itemCategory);
    }

    @Override
    public void onFocusChange(View view, boolean b) {
        final Calendar c = Calendar.getInstance();
        mYear = c.get(Calendar.YEAR);
        mMonth = c.get(Calendar.MONTH);
        mDay = c.get(Calendar.DAY_OF_MONTH);
        if (view.hasFocus()) {
            switch (view.getId()) {
                case R.id.startDate:

                    DatePickerDialog datePickerDialogRecieved = new DatePickerDialog(this,
                            new DatePickerDialog.OnDateSetListener() {
                                @Override
                                public void onDateSet(DatePicker view12, int year, int monthOfYear, int dayOfMonth) {
                                    activityAddItemBinding.startDate.setText(dayOfMonth + "-" + (monthOfYear + 1) + "-" + year);
                                }
                            }, mYear, mMonth, mDay);
                    datePickerDialogRecieved.show();
                    break;

                case R.id.closingDate:

                    DatePickerDialog datePickerDialogInvoice = new DatePickerDialog(this,
                            new DatePickerDialog.OnDateSetListener() {
                                @Override
                                public void onDateSet(DatePicker view1, int year, int monthOfYear, int dayOfMonth) {
                                    activityAddItemBinding.closingDate.setText(dayOfMonth + "-" + (monthOfYear + 1) + "-" + year);
                                }
                            }, mYear, mMonth, mDay);
                    datePickerDialogInvoice.show();
                    break;


            }
        }

    }
}