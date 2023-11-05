package css_3334.lcproject;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;

import android.app.AlertDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

public class MainActivity extends AppCompatActivity {

    EditText editTextName;
    EditText editTextHealth;
    EditText editTextSpeedLow;
    EditText editTextSpeedHigh;
    Spinner spinnerAttack1;
    Spinner spinnerAttack2;
    Spinner spinnerAttack3;

    Spinner spinnerSin1;
    Spinner spinnerSin2;
    Spinner spinnerSin3;



    Button buttonSaveSinner;
    Button buttonToViewer;
    Spinner spinnerRarity;
    Spinner spinnerBlunt;
    Spinner spinnerPierce;
    Spinner spinnerSlash;
    MainViewModel mainViewModel;

    String attackType1;
    String attackType2;
    String attackType3;

    String sinAffinity1;
    String sinAffinity2;
    String sinAffinity3;

    Sinner sinner;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mainViewModel = new ViewModelProvider(this).get(MainViewModel.class);

        editTextName = findViewById(R.id.editTextName);
        editTextHealth = findViewById(R.id.editTextHealth);
        editTextSpeedLow = findViewById(R.id.editTextLowSpeed);
        editTextSpeedHigh = findViewById(R.id.editTextHighSpeed);

        setupSaveButton();

        setupRaritySpinner();
        setupBluntSpinner();
        setupPierceSpinner();
        setupSlashSpinner();

        setupSkillAttack1Spinner();
        setupSkillAttack2Spinner();
        setupSkillAttack3Spinner();

        setupSkillSin1Spinner();
        setupSkillSin2Spinner();
        setupSkillSin3Spinner();

        setupViewerButton();
    }

    /**
     * Set up Save Sinner button so it adds a new sinner to the database
     */
    private void setupSaveButton() {
        buttonSaveSinner = findViewById(R.id.buttonSaveSinner); //temp button for code
        buttonSaveSinner.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = editTextName.getText().toString();
                String rarity = spinnerRarity.getSelectedItem().toString();

                Integer health = Integer.parseInt(editTextHealth.getText().toString());
                Integer speedLow = Integer.parseInt(editTextSpeedLow.getText().toString());
                Integer speedHigh = Integer.parseInt(editTextSpeedHigh.getText().toString());

                String blunt = spinnerBlunt.getSelectedItem().toString();
                String pierce = spinnerPierce.getSelectedItem().toString();
                String slash = spinnerSlash.getSelectedItem().toString();

                //insert skills
                //Attack Type
                String attack1 = spinnerAttack1.getSelectedItem().toString();
                String attack2 = spinnerAttack2.getSelectedItem().toString();
                String attack3 = spinnerAttack3.getSelectedItem().toString();

                //Sin Affinity
                String sin1 = spinnerSin1.getSelectedItem().toString();
                String sin2 = spinnerSin2.getSelectedItem().toString();
                String sin3 = spinnerSin3.getSelectedItem().toString();

                sinner = new Sinner(name, rarity, health, speedLow, speedHigh, blunt, pierce, slash, attack1, attack2, attack3, sin1, sin2, sin3);
                //mainViewModel.insert(name, rarity, health, speedLow, speedHigh, blunt, pierce, slash);
            }
        });
    }

    /**
     * Set up Rarity Spinner, text from rarity_array
     */
    private void setupRaritySpinner() {
        spinnerRarity = (Spinner) findViewById(R.id.spinnerRarity);
        // Read the planet names from the strings.xml file
        String Rarity[] = getResources().getStringArray(R.array.rarity_array);
        // Create an ArrayAdapter using the string array and a default spinner layout
        ArrayAdapter<String> itemsAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, Rarity);
        // Specify the layout to use when the list of choices appears
        itemsAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        // Apply the adapter to the spinner
        spinnerRarity.setAdapter(itemsAdapter);
        //-------------------------------------
        spinnerRarity.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                //tvDisplayItem.setText("Planet: " + parent.getSelectedItem().toString());
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                //Another interface callback
            }
        });
        //-------------------------------------
    }

    /**
     * Set up Blunt Spinner, uses text from resistance array
     */
    private void setupBluntSpinner() {
        spinnerBlunt = (Spinner) findViewById(R.id.spinnerBlunt);
        // Read the planet names from the strings.xml file
        String Blunt[] = getResources().getStringArray(R.array.resistance_array);
        // Create an ArrayAdapter using the string array and a default spinner layout
        ArrayAdapter<String> itemsAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, Blunt);
        // Specify the layout to use when the list of choices appears
        itemsAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        // Apply the adapter to the spinner
        spinnerBlunt.setAdapter(itemsAdapter);
        //-------------------------------------
        spinnerBlunt.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                //tvDisplayItem.setText("Planet: " + parent.getSelectedItem().toString());
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                //Another interface callback
            }
        });
        //-------------------------------------
    }

    /**
     * Set up Pierce Spinner, uses text from resistance array
     */
    private void setupPierceSpinner() {
        spinnerPierce = (Spinner) findViewById(R.id.spinnerPierce);
        // Read the planet names from the strings.xml file
        String Pierce[] = getResources().getStringArray(R.array.resistance_array);
        // Create an ArrayAdapter using the string array and a default spinner layout
        ArrayAdapter<String> itemsAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, Pierce);
        // Specify the layout to use when the list of choices appears
        itemsAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        // Apply the adapter to the spinner
        spinnerPierce.setAdapter(itemsAdapter);
        //-------------------------------------
        spinnerPierce.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                //tvDisplayItem.setText("Planet: " + parent.getSelectedItem().toString());
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                //Another interface callback
            }
        });
        //-------------------------------------
    }

    /**
     * Set up Slash Spinner, uses text from resistance array
     */
    private void setupSlashSpinner() {
        spinnerSlash = (Spinner) findViewById(R.id.spinnerSlash);
        // Read the planet names from the strings.xml file
        String Slash[] = getResources().getStringArray(R.array.resistance_array);
        // Create an ArrayAdapter using the string array and a default spinner layout
        ArrayAdapter<String> itemsAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, Slash);
        // Specify the layout to use when the list of choices appears
        itemsAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        // Apply the adapter to the spinner
        spinnerSlash.setAdapter(itemsAdapter);
        //-------------------------------------
        spinnerSlash.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                //tvDisplayItem.setText("Planet: " + parent.getSelectedItem().toString());
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                //Another interface callback
            }
        });
        //-------------------------------------
    }

    /**
     * Set up Skill Attack 1 Spinner, uses text from attack type array
     */
    private void setupSkillAttack1Spinner() {
        spinnerAttack1 = (Spinner) findViewById(R.id.spinnerAttack1);
        // Read the planet names from the strings.xml file
        String Attack1[] = getResources().getStringArray(R.array.attack_type_array);
        // Create an ArrayAdapter using the string array and a default spinner layout
        ArrayAdapter<String> itemsAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, Attack1);
        // Specify the layout to use when the list of choices appears
        itemsAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        // Apply the adapter to the spinner
        spinnerAttack1.setAdapter(itemsAdapter);
        //-------------------------------------
        spinnerAttack1.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                //tvDisplayItem.setText("Planet: " + parent.getSelectedItem().toString());
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                //Another interface callback
            }
        });
        //-------------------------------------
    }

    /**
     * Set up Skill Attack 2 Spinner, uses text from attack type array
     */
    private void setupSkillAttack2Spinner() {
        spinnerAttack2 = (Spinner) findViewById(R.id.spinnerAttack2);
        // Read the planet names from the strings.xml file
        String Attack2[] = getResources().getStringArray(R.array.attack_type_array);
        // Create an ArrayAdapter using the string array and a default spinner layout
        ArrayAdapter<String> itemsAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, Attack2);
        // Specify the layout to use when the list of choices appears
        itemsAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        // Apply the adapter to the spinner
        spinnerAttack2.setAdapter(itemsAdapter);
        //-------------------------------------
        spinnerAttack2.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                //tvDisplayItem.setText("Planet: " + parent.getSelectedItem().toString());
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                //Another interface callback
            }
        });
        //-------------------------------------
    }

    /**
     * Set up Skill Attack 3 Spinner, uses text from attack type array
     */
    private void setupSkillAttack3Spinner() {
        spinnerAttack3 = (Spinner) findViewById(R.id.spinnerAttack3);
        // Read the planet names from the strings.xml file
        String Attack3[] = getResources().getStringArray(R.array.attack_type_array);
        // Create an ArrayAdapter using the string array and a default spinner layout
        ArrayAdapter<String> itemsAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, Attack3);
        // Specify the layout to use when the list of choices appears
        itemsAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        // Apply the adapter to the spinner
        spinnerAttack3.setAdapter(itemsAdapter);
        //-------------------------------------
        spinnerAttack3.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                //tvDisplayItem.setText("Planet: " + parent.getSelectedItem().toString());
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                //Another interface callback
            }
        });
        //-------------------------------------
    }

    /**
     * Set up Skill Sin 1 Spinner, uses text from sin affinity array
     */
    private void setupSkillSin1Spinner() {
        spinnerSin1 = (Spinner) findViewById(R.id.spinnerSin1);
        // Read the planet names from the strings.xml file
        String Sin1[] = getResources().getStringArray(R.array.sin_affinity_array);
        // Create an ArrayAdapter using the string array and a default spinner layout
        ArrayAdapter<String> itemsAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, Sin1);
        // Specify the layout to use when the list of choices appears
        itemsAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        // Apply the adapter to the spinner
        spinnerSin1.setAdapter(itemsAdapter);
        //-------------------------------------
        spinnerSin1.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                //tvDisplayItem.setText("Planet: " + parent.getSelectedItem().toString());
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                //Another interface callback
            }
        });
        //-------------------------------------
    }

    /**
     * Set up Skill Sin 2 Spinner, uses text from sin affinity array
     */
    private void setupSkillSin2Spinner() {
        spinnerSin2 = (Spinner) findViewById(R.id.spinnerSin2);
        // Read the planet names from the strings.xml file
        String Sin2[] = getResources().getStringArray(R.array.sin_affinity_array);
        // Create an ArrayAdapter using the string array and a default spinner layout
        ArrayAdapter<String> itemsAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, Sin2);
        // Specify the layout to use when the list of choices appears
        itemsAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        // Apply the adapter to the spinner
        spinnerSin2.setAdapter(itemsAdapter);
        //-------------------------------------
        spinnerSin2.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                //tvDisplayItem.setText("Planet: " + parent.getSelectedItem().toString());
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                //Another interface callback
            }
        });
        //-------------------------------------
    }

    /**
     * Set up Skill Sin 3 Spinner, uses text from sin affinity array
     */
    private void setupSkillSin3Spinner() {
        spinnerSin3 = (Spinner) findViewById(R.id.spinnerSin3);
        // Read the planet names from the strings.xml file
        String Sin3[] = getResources().getStringArray(R.array.sin_affinity_array);
        // Create an ArrayAdapter using the string array and a default spinner layout
        ArrayAdapter<String> itemsAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, Sin3);
        // Specify the layout to use when the list of choices appears
        itemsAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        // Apply the adapter to the spinner
        spinnerSin3.setAdapter(itemsAdapter);
        //-------------------------------------
        spinnerSin3.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                //tvDisplayItem.setText("Planet: " + parent.getSelectedItem().toString());
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                //Another interface callback
            }
        });
        //-------------------------------------
    }

    private void setupViewerButton() {
        buttonToViewer = findViewById(R.id.buttonToViewer);
        buttonToViewer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Call the second activity
                Intent secActIntent = new Intent(MainActivity.this, SecondMainActivity.class);
                secActIntent.putExtra("sinner", sinner);
                startActivity(secActIntent);
            }
        });
    }
}