package com.katesproject.stinkie;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
/**Класс, соответствующий фрагменту, отображающему текущий игровой баланс пользователя*/
public class MoneyFragment extends Fragment{
   /**Раздутие фрагмента с балансом*/
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View indicatsView = inflater.inflate(R.layout.moneyfrag,
                container, false);
        return indicatsView;
    }
}