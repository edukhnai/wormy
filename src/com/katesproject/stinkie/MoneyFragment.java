package com.katesproject.stinkie;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
/**�����, ��������������� ���������, ������������� ������� ������� ������ ������������*/
public class MoneyFragment extends Fragment{
   /**�������� ��������� � ��������*/
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View indicatsView = inflater.inflate(R.layout.moneyfrag,
                container, false);
        return indicatsView;
    }
}