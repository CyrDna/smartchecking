package com.cyr.smartchecking;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class MainViewModel extends ViewModel {
    // initialize variables
    MutableLiveData<String> mutableLiveData=new MutableLiveData<>();
    public void setText(String s) {
        mutableLiveData.setValue(s);
    }

    // create get text method
    public MutableLiveData<String> getText() {
        return mutableLiveData;
    }
}
