package com.saolong.contactmanage;

import android.app.Application;
import android.os.Handler;
import android.os.Looper;

import androidx.lifecycle.LiveData;

import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Repository {
    // The Available Data Sources:
    // - ROOM Database

     private final ContactDAO contactDAO;
    ExecutorService executor;
    Handler handler;

    public Repository(Application application) {

        ContactDatabase contactsDatabase = ContactDatabase.getInstance(application);

        this.contactDAO = contactsDatabase.getContactDAO();

        // Used for Background Database Operations
        executor = Executors.newSingleThreadExecutor();

        // Used for updating the UI
        handler = new Handler(Looper.getMainLooper());
    }

    // Methods in DAO being executed from Repository
    public void addContact(Contacts contacts) {

        executor.execute(new Runnable() {
            @Override
            public void run() {
                contactDAO.insert(contacts);
            }
        });

    }

    public void deleteContact(Contacts contacts){

        executor.execute(new Runnable() {
            @Override
            public void run() {
                contactDAO.delete(contacts);
            }
        });

    }

    public LiveData<List<Contacts>> getAllContacts(){

        return contactDAO.getAllContacts();
    }
}
