package com.saolong.contactmanage;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;

import java.util.List;

public class MyViewModel extends AndroidViewModel {
    // If you need to use context inside your ViewModel
    // you should use AndroidViewModel (AVM)
    // because it contains the application context
    private final  Repository myRepository;

    // LiveData
    private LiveData<List<Contacts>> allContacts;

    public MyViewModel(@NonNull Application application) {
        super(application);
        this.myRepository = new Repository(application);
    }

    public LiveData<List<Contacts>> getAllContacts() {
        allContacts = myRepository.getAllContacts();
        return allContacts;
    }

    public void addNewContact(Contacts contacts) {
        myRepository.addContact(contacts);
    }

    public void deleteContact(Contacts contacts){
        myRepository.deleteContact(contacts);
    }
}
