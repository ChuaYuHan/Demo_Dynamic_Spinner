package sg.edu.rp.c346.id19020844.demodynamicspinner;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;

import java.util.ArrayList;
import java.util.Arrays;

public class MainActivity extends AppCompatActivity {

    Spinner spn1, spn2;
    Button btnUpdate;
    ArrayList<String> alNumbers;
    ArrayAdapter<String> aaNumbers;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        spn1 = findViewById(R.id.spinner1);
        spn2 = findViewById(R.id.spinner2);
        btnUpdate = findViewById(R.id.buttonUpdate);

        // initialise the ArrayList
        alNumbers = new ArrayList<>();

        // APPROACH 1
//        alNumbers.add("2");
//        alNumbers.add("4");
//        alNumbers.add("6");

        // APPROACH 2
        // get the string-array and store as an Array
        String[] strNumbers = getResources().getStringArray(R.array.even_numbers);

        // convert Array to List and add to the ArrayList
        alNumbers.addAll(Arrays.asList(strNumbers));

        // create an ArrayAdapter using the default spinner layout and the ArrayList
        aaNumbers = new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, alNumbers);

        // bind the ArrayAdapter to the spinner
        spn2.setAdapter(aaNumbers);

        spn1.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                // Approach 2
                alNumbers.clear();
                if (i == 0) {
                    String[] strNumbers = getResources().getStringArray(R.array.even_numbers);
                    alNumbers.addAll(Arrays.asList(strNumbers));
                    spn2.setSelection(2);
                }
                else {
                    String[] strNumbers = getResources().getStringArray(R.array.odd_numbers);
                    alNumbers.addAll(Arrays.asList(strNumbers));
                    spn2.setSelection(1);
                }

                aaNumbers.notifyDataSetChanged();
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        btnUpdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int pos = spn1.getSelectedItemPosition();
                alNumbers.clear();

                // Apply either of the two approaches
                // to load the correct number list based on the selection of spn1
                // Approach 2
                if (pos == 0) {
                    String[] strEvenNumbers = getResources().getStringArray(R.array.even_numbers);

                    alNumbers.addAll(Arrays.asList(strEvenNumbers));
                    spn2.setAdapter(aaNumbers);
                }
                else {
                    String[] strOddNumbers = getResources().getStringArray(R.array.odd_numbers);

                    alNumbers.addAll(Arrays.asList(strOddNumbers));
                    spn2.setAdapter(aaNumbers);
                }

            }
        });


    }
}
