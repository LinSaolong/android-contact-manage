package com.saolong.contactmanage;

import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import androidx.lifecycle.ViewModelProvider;

public class AddNewContactClickHandler {
    Contacts contacts;
    Context context;
    MyViewModel myViewModel;

    public AddNewContactClickHandler(Contacts contacts, Context context, MyViewModel myViewModel) {
        this.contacts = contacts;
        this.context = context;
        this.myViewModel = myViewModel;
    }

    public void onSubmitBtnClicked(View view) {
        try {
            if (contacts.getName() == null || contacts.getEmail() == null) {
                Toast.makeText(context, "Please fill all the fields", Toast.LENGTH_SHORT).show();
            } else {
                Intent i = new Intent(view.getContext(), MainActivity.class);
                // i.putExtra("Name", contacts.getName());
                // i.putExtra("Email", contacts.getEmail());
                Contacts c = new Contacts(contacts.getName(), contacts.getEmail());
                myViewModel.addNewContact(c);
                context.startActivity(i);
            }
        } catch (Exception e) {
            Log.d("TAG", "onSubmitBtnClicked: " + e.getMessage());
        }

    }
}
