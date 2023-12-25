package com.example.hubo;

import androidx.appcompat.app.AppCompatActivity;
<<<<<<< HEAD

import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
=======
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.speech.RecognitionListener;
import android.speech.RecognizerIntent;
import android.speech.SpeechRecognizer;
import android.util.Log;
>>>>>>> 45e6250 (second commit)
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
<<<<<<< HEAD
=======
import android.widget.TextView;
import android.widget.Toast;
>>>>>>> 45e6250 (second commit)
import android.widget.VideoView;

import com.google.android.material.bottomsheet.BottomSheetDialog;

<<<<<<< HEAD
public class MainActivity extends AppCompatActivity {

    Button meet;

    VideoView video;

    @Override
    protected void onCreate(Bundle savedInstanceState){
=======
import java.util.ArrayList;

public  class MainActivity extends AppCompatActivity {

    Button meet;

    Button start;

    boolean flag = true;

    VideoView video;

    TextView tv;

    private SpeechRecognizer speechRecognizer;

    private static final int RECORD_AUDIO_PERMISSION_CODE = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
>>>>>>> 45e6250 (second commit)
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        meet = findViewById(R.id.meet);
        video = findViewById(R.id.video);
<<<<<<< HEAD
=======
        tv = findViewById(R.id.txt);
        start = findViewById(R.id.start);
>>>>>>> 45e6250 (second commit)

        String videoPath = "android.resource://" + getPackageName() + "/" + R.raw.speech;
        playVideo(videoPath);

<<<<<<< HEAD
=======
        if (ContextCompat.checkSelfPermission(this, android.Manifest.permission.RECORD_AUDIO)
                != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(this,
                    new String[]{android.Manifest.permission.RECORD_AUDIO},
                    RECORD_AUDIO_PERMISSION_CODE);
        } else {
            initializeSpeechRecognizer();
        }

        start.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startSpeechRecognition();
            }
        });

        video.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mediaPlayer) {
                startSpeechRecognition();
            }
        });


>>>>>>> 45e6250 (second commit)
        meet.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String videoPath = "android.resource://" + getPackageName() + "/" + R.raw.meet;
                playVideo(videoPath);
<<<<<<< HEAD
                video.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                    @Override
                    public void onCompletion(MediaPlayer mediaPlayer) {
                        showPersonListBottomSheet();
=======
                flag = true;
                video.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                    @Override
                    public void onCompletion(MediaPlayer mediaPlayer) {
                        if (flag) {
                            showPersonListBottomSheet();
                            flag = false;
                        }
>>>>>>> 45e6250 (second commit)
                    }
                });
            }
        });
    }
<<<<<<< HEAD
=======
        private void initializeSpeechRecognizer() {
            speechRecognizer = SpeechRecognizer.createSpeechRecognizer(this);
            speechRecognizer.setRecognitionListener(new RecognitionListener() {
                @Override
                public void onReadyForSpeech(Bundle params) {
                    // Called when the speech recognition service is ready to listen.
                    Toast.makeText(MainActivity.this, "Started Listening", Toast.LENGTH_SHORT).show();
                }

                @Override
                public void onBeginningOfSpeech() {
                    // Called when the user starts speaking.
                    Toast.makeText(MainActivity.this, "Started speech", Toast.LENGTH_SHORT).show();
                }

                @Override
                public void onRmsChanged(float rmsdB) {
                    // Called when the RMS changes.
                }

                @Override
                public void onBufferReceived(byte[] buffer) {
                    // Called when partial recognition results are available.
                }

                @Override
                public void onEndOfSpeech() {
                    // Called when the user stops speaking.
                }

                @Override
                public void onError(int error) {
                    Log.e("SpeechRecognition", "Error: " + error);
                    // or use Toast to display an error message
                    Toast.makeText(MainActivity.this, "Speech recognition error: " + error, Toast.LENGTH_SHORT).show();
                }

                @Override
                public void onResults(Bundle results) {
                    // Called when recognition results are ready.
                    ArrayList<String> matches = results.getStringArrayList(SpeechRecognizer.RESULTS_RECOGNITION);
                    if (matches != null && matches.size() > 0) {
                        String result = matches.get(0);
                        tv.setText(result);
                    }
                }

                @Override
                public void onPartialResults(Bundle partialResults) {
                    // Called when partial recognition results are available.
                }

                @Override
                public void onEvent(int eventType, Bundle params) {
                    // Reserved for future use.
                }
            });
    }

    private void startSpeechRecognition() {
        if (ContextCompat.checkSelfPermission(this, android.Manifest.permission.RECORD_AUDIO)
                == PackageManager.PERMISSION_GRANTED) {
            Intent intent = new Intent(RecognizerIntent.ACTION_RECOGNIZE_SPEECH);
            intent.putExtra(RecognizerIntent.EXTRA_LANGUAGE_MODEL, RecognizerIntent.LANGUAGE_MODEL_FREE_FORM);
            intent.putExtra(RecognizerIntent.EXTRA_LANGUAGE, "en-US");
            intent.putExtra(RecognizerIntent.EXTRA_PROMPT, "Speak something");

            speechRecognizer.startListening(intent);
        } else {
            Toast.makeText(this, "Microphone permission not granted", Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, String[] permissions, int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);

        if (requestCode == RECORD_AUDIO_PERMISSION_CODE) {
            if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                // Permission granted, initialize SpeechRecognizer
                initializeSpeechRecognizer();
            } else {
                // Permission denied, inform the user
                Toast.makeText(this, "Microphone permission denied", Toast.LENGTH_SHORT).show();
            }
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (speechRecognizer != null) {
            speechRecognizer.destroy();
        }
    }


>>>>>>> 45e6250 (second commit)
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

<<<<<<< HEAD
=======

>>>>>>> 45e6250 (second commit)
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