package edu.utsa.cs3443.dinoParkManager.controller;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.AssetManager;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Scanner;

import edu.utsa.cs3443.dinoParkManager.MainActivity;
import edu.utsa.cs3443.dinoParkManager.R;

/**
 * DinoController class is controller for DinoActivity
 * @author Andres Tostado
 */
public class DinoController implements View.OnClickListener {

    Activity activity;
    AssetManager manager;

    /**
     * DinoController constructor
     * @param activity activity on screen (Activity)
     */
    public DinoController(Activity activity){
        this.activity = activity;
        this.manager = activity.getAssets();
    }

    /**
     * Relocates dino if info is correct and button is clicked, also returns to map
     * @param view view on screen (View)
     */
    @Override
    public void onClick(View view) {
        boolean nameExists = false;
        boolean zoneExists = false;
        String type = null;
        OutputStream out = null;
        int count = 0;
        switch (view.getId()){
            case R.id.buttonRelo:
                try {
                    InputStream in = activity.openFileInput("dinos.csv");
                    Scanner scan = new Scanner(in);
                    String line = "";
                    ArrayList<String> lines = new ArrayList<>();
                    String[] tokens1;
                    TextView zoneTxt = activity.findViewById(R.id.textViewZone2);
                    String currZone = zoneTxt.getText().toString();
                    String zToken[] = currZone.split(" ");
                    currZone = zToken[1];
                    //Get data from user
                    EditText editName = activity.findViewById(R.id.EditTextName);
                    EditText editZone = activity.findViewById(R.id.editTextZone);
                    String enteredName = editName.getText().toString();
                    String enteredZone = editZone.getText().toString();
                    String dino = "";
                    while (scan.hasNextLine()) {
                        dino = scan.nextLine();
                        tokens1 = dino.split(",");
                        String name = tokens1[0];
                        type = tokens1[1];
                        String zone = tokens1[2];
                        count++;
                        //makes sure dino exists and is in current zone
                        if (name.equals(enteredName) && zone.equals(currZone)) {
                            nameExists = true;
                            break;
                        }
                    }
                    InputStream in2 = manager.open("zones.csv");
                    scan = new Scanner(in2);
                    String zone = "";
                    String[] tokens2;

                    while (scan.hasNextLine()) {
                        zone = scan.nextLine();
                        tokens2 = zone.split(",");

                        String DinoType = tokens2[0];
                        String risk = tokens2[1];
                        String ZoneName = tokens2[2];
                        String guests = tokens2[3];
                        if (ZoneName.equals(enteredZone)) {
                            zoneExists = true;
                        }
                    }   //Exception handling
                    if (zoneExists == false && nameExists == false) {
                            Toast toast = Toast.makeText(activity, "Invalid zone and name entered!", Toast.LENGTH_SHORT);
                            toast.show();
                    } else if (nameExists == false) {
                            Toast toast = Toast.makeText(activity, "Invalid name entered, " + enteredName + " not in current zone!", Toast.LENGTH_SHORT);
                            toast.show();
                    } else if (zoneExists == false) {
                            Toast toast = Toast.makeText(activity, "Invalid zone entered!", Toast.LENGTH_SHORT);
                            toast.show();
                            //Valid info entered
                        } else if (nameExists && zoneExists) {
                            String printLine = enteredName + "," + type + "," + enteredZone + "\n";
                            in.close();
                            in = activity.openFileInput("dinos.csv");
                            scan = new Scanner(in);
                            while (scan.hasNextLine()) {
                                line = scan.nextLine();
                                line = line + "\n";
                                lines.add(line);
                            }
                            in.close();
                            scan.close();
                            out = activity.openFileOutput("dinosCpy.csv", Context.MODE_PRIVATE);
                            File origFile = activity.getApplicationContext().getFileStreamPath("dinos.csv");
                            File tempFile = activity.getApplicationContext().getFileStreamPath("dinosCpy.csv");
                            for (int i = 0; i < lines.size(); i++) {
                                if (i == count-1) {
                                    out.write(printLine.getBytes(StandardCharsets.UTF_8));
                                }else {
                                    out.write(lines.get(i).getBytes(StandardCharsets.UTF_8));
                                }
                            }
                            //Writes to a copy file, copy file replaces original file
                            activity.deleteFile("dinos.csv");
                            tempFile.renameTo(origFile);
                            out.close();
                            Toast toast = Toast.makeText(activity, enteredName + " moved to Zone " + enteredZone + "!", Toast.LENGTH_SHORT);
                            toast.show();
                        }
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
                break;
            case R.id.buttonMap:
                Intent intent = new Intent(activity, MainActivity.class);
                activity.startActivity(intent);
        }

    }

    /**
     * Sets zone name at top of screen
     * @param zoneName zone name (String)
     */
        public void setScreen(String zoneName){
            TextView tvTitle = (TextView) activity.findViewById(R.id.textViewZone2);
            tvTitle.setText(zoneName);
        }

}
