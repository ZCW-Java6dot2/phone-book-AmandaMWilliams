package com.zipcodewilmington.phonebook;

import java.lang.reflect.Array;
import java.util.*;
//import java.util.HashMap;


/**
 * Created by leon on 1/23/18.
 * Made WAY better by kristofer 6/16/20
 */
public class PhoneBook {

    private final Map<String, List<String>> phonebook;

    public PhoneBook(Map<String, List<String>> map) {

        this.phonebook = map;
    }

    public PhoneBook() {
        phonebook = new LinkedHashMap<String, List<String>>();
    }

    public void add(String name, String phoneNumber) {
        //Check if the key already exists before adding new name (key) and phone number
        if(phonebook.containsKey(name)){
            List<String> updatedNumbers = phonebook.get(name);
            updatedNumbers.add(phoneNumber);
            phonebook.replace(name, updatedNumbers);
        } else {
            phonebook.put(name, Collections.singletonList(phoneNumber));
        }

    }

    public void addAll(String name, String... phoneNumbers) {
        if(phonebook.containsKey(name)){
            List<String> updatedNumbers = phonebook.get(name);
            updatedNumbers.addAll(Arrays.asList(phoneNumbers)); //converting array to a list
            phonebook.replace(name, updatedNumbers);
        } else {
            phonebook.put(name, Arrays.asList(phoneNumbers));
        }
    }

    public void remove(String name) {
        phonebook.remove(name);

    }

    public Boolean hasEntry(String name) {
        return phonebook.containsKey(name);
    }

    public List<String> lookup(String name) {
        return phonebook.get(name);
    }

    public String reverseLookup(String phoneNumber) {
        Set<String> allKeys = phonebook.keySet();
        for (String key : allKeys
             ) { List<String> values = phonebook.get(key);
            if(values.contains(phoneNumber)){
                return key;
            }
        } return "";
    }

    public List<String> getAllContactNames() {
        List<String> contactNames = new ArrayList<String>();  //make a list
        for (String key: phonebook.keySet()                   //take each key
             ) {contactNames.add(key);                        //add it to the list
        }
        return contactNames;                                  //return keys
    }

    public Map<String, List<String>> getMap() {
        return phonebook;
    }
}
