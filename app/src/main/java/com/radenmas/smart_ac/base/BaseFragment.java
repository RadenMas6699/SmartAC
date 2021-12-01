package com.radenmas.smart_ac.base;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;

public abstract class BaseFragment extends Fragment {

    protected abstract int getLayoutResource();

    protected abstract void myCodeHere(View view);

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(getLayoutResource(), container, false);

        myCodeHere(view);

        return view;
    }
}