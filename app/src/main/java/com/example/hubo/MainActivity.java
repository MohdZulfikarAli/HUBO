package com.example.hubo;

import androidx.appcompat.app.AppCompatActivity;

import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.VideoView;

import com.google.android.material.bottomsheet.BottomSheetDialog;

public class MainActivity extends AppCompatActivity {

    Button meet;

    VideoView video;

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        meet = findViewById(R.id.meet);
        video = findViewById(R.id.video);

        String videoPath = "android.resource://" + getPackageName() + "/" + R.raw.speech;
        playVideo(videoPath);

        meet.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String videoPath = "android.resource://" + getPackageName() + "/" + R.raw.meet;
                playVideo(videoPath);
                video.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                    @Override
                    public void onCompletion(MediaPlayer mediaPlayer) {
                        showPersonListBottomSheet();
                    }
                });
            }
        });
    }
    private void showPersonListBottomSheet() {
        // Sample list of persons
        String[] persons = {"Person A", "Person B", "Person C", "Person D", "Person E", "Person F", "Person G", "Person H"};

        // Create a bottom sheet dialog
        BottomSheetDialog bottomSheetDialog = new BottomSheetDialog(this);
        View bottomSheetView = getLayoutInflater().inflate(R.layout.persons_bottom_sheet, null);
        bottomSheetDialog.setContentView(bottomSheetView);

        // Set up the ListView with the list of persons
        ListView listView = bottomSheetView.findViewById(R.id.listViewPersons);
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, persons);
        listView.setAdapter(adapter);

        // Set item click listener for the ListView
        listView.setOnItemClickListener((adapterView, view, position, id) -> {
            String selectedPerson = persons[position];
            findPerson(selectedPerson);
            bottomSheetDialog.dismiss();
        });

        // Show the bottom sheet
        bottomSheetDialog.show();
    }

    public void findPerson(String name)
    {
        if(name.equals("Person A"))
        {
            String videoPath = "android.resource://" + getPackageName() + "/" + R.raw.speech;
            playVideo(videoPath);
        }
    }

    public void playVideo(String path)
    {
        video.setVideoURI(Uri.parse(path));
        video.start();
    }
}