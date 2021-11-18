package com.acv.paises;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.TextView;

import com.acv.paises.databinding.FragmentJuegaBinding;

import java.util.ArrayList;

public class Juega extends Fragment {

    private FragmentJuegaBinding binding;


    public Juega() {
        // Required empty public constructor
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        binding = FragmentJuegaBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();

        return view;
    }


    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        String [] banderas = getResources().getStringArray(R.array.banderas);
        String [] respuestas = getResources().getStringArray(R.array.respuestas);

        int pregunta = (int)(Math.random()*6);

        ImageView iv = binding.imgbandera;
        RadioButton rb0 = binding.rg0;
        RadioButton rb1 = binding.rg1;
        RadioButton rb2 = binding.rg2;
        iv.setImageResource(getImageId(banderas[pregunta]));

        int posRespuestaCorrecta = (int)(Math.random()*3);
        String respuestaCorrecta = "rg"+String.valueOf(posRespuestaCorrecta);

        int respuestaIncorrectaUno;
        int respuestaIncorrectaDos;

        switch(respuestaCorrecta){
            case "rg0":

                rb0.setText(respuestas[pregunta]);

                do {
                    respuestaIncorrectaUno = (int)(Math.random()*6);
                } while (respuestaIncorrectaUno == pregunta);

                do {
                    respuestaIncorrectaDos = (int)(Math.random()*6);
                } while (respuestaIncorrectaDos == pregunta || respuestaIncorrectaDos == respuestaIncorrectaUno);

                rb1.setText(respuestas[respuestaIncorrectaUno]);
                rb2.setText(respuestas[respuestaIncorrectaDos]);

                break;

            case "rg1":

                rb1.setText(respuestas[pregunta]);

                do {
                    respuestaIncorrectaUno = (int)(Math.random()*6);
                } while (respuestaIncorrectaUno == pregunta);

                do {
                    respuestaIncorrectaDos = (int)(Math.random()*6);
                } while (respuestaIncorrectaDos == pregunta || respuestaIncorrectaDos == respuestaIncorrectaUno);

                rb0.setText(respuestas[respuestaIncorrectaUno]);
                rb2.setText(respuestas[respuestaIncorrectaDos]);


                break;
            case "rg2":

                rb2.setText(respuestas[pregunta]);

                do {
                    respuestaIncorrectaUno = (int)(Math.random()*6);
                } while (respuestaIncorrectaUno == pregunta);

                do {
                    respuestaIncorrectaDos = (int)(Math.random()*6);
                } while (respuestaIncorrectaDos == pregunta || respuestaIncorrectaDos == respuestaIncorrectaUno);

                rb0.setText(respuestas[respuestaIncorrectaUno]);
                rb1.setText(respuestas[respuestaIncorrectaDos]);

                break;
        }
    }

    private int getImageId(String imagePath){
        String imageName = imagePath.substring(imagePath.lastIndexOf("/")+1,imagePath.lastIndexOf("."));
        return getResources().getIdentifier(imageName,"drawable",getContext().getPackageName());
    }
}