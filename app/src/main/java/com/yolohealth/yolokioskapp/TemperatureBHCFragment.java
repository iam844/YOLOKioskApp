package com.yolohealth.yolokioskapp;

import android.media.MediaPlayer;
import android.os.Bundle;

import android.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import pl.droidsonroids.gif.GifImageView;

public class TemperatureBHCFragment extends Fragment {

    View view;
    GifImageView instructionAudioGif;
    MediaPlayer mediaPlayer;

    public TemperatureBHCFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mediaPlayer = new MediaPlayer();
        mediaPlayer = MediaPlayer.create(getContext(), R.raw.put_temp_sensor_on_neck_or_underarm);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        view = inflater.inflate(R.layout.fragment_temperature_bhc, container, false);
        instructionAudioGif = view.findViewById(R.id.instruction_playing_image_gif);

        try{
            mediaPlayer.start();
        }catch(Exception e){e.printStackTrace();}

        instructionAudioGif.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mediaPlayer.start();
            }
        });

        return view;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();

        mediaPlayer.release();
        mediaPlayer = null;
    }

}
