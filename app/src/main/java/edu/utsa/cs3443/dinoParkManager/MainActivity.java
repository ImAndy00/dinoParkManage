package edu.utsa.cs3443.dinoParkManager;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.os.Bundle;
import android.widget.Button;

import java.io.IOException;

import edu.utsa.cs3443.dinoParkManager.controller.MainController;

/**
 * MainActivity class displays the first view
 * @author Andres Tostado (wvm376)
 */
public class MainActivity extends AppCompatActivity {

    MainController controller;
    Activity activity;
    private static boolean firstRun = true;

    /**
     * Method called when view is created
     * @param savedInstanceState returns to a previous state (Bundle)
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        controller = new MainController(this);
            try {
                controller.createCpy(firstRun);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        firstRun = false;
        setupButton(R.id.buttonTR);
        setupButton(R.id.buttonTY);
        setupButton(R.id.buttonD);
        setupButton(R.id.buttonB);
        setupButton(R.id.buttonG);
        setupButton(R.id.buttonX);
        setupButton(R.id.buttonR);
    }

    /**
     * Sets up buttons on screen
     * @param buttonID ID of button (int)
     */
    private void setupButton(int buttonID) {
        Button button = findViewById(buttonID);
        button.setOnClickListener(controller);
    }
}