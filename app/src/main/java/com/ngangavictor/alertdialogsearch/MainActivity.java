package com.ngangavictor.alertdialogsearch;

import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.Toast;

import com.ngangavictor.alertdialogsearch.adapter.AlertAdapter;

import java.util.ArrayList;
import java.util.Arrays;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemClickListener {
    Button button;
    String animal[];
    ArrayList<String> arraySort;
    int textLength=0;
    ListView listView;
    AlertAdapter arrayAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        button = findViewById(R.id.button);

        animal =new String[]{"Buffalo Nyati","Lion Simba","Zebra Pundamilia","Giraffe Twiga","Dog Mbwa","Goat Meeee","Hen Kuku","Rat Panya","Slug Konokono","Chick Kifaranga","Cow Ng'ombe","Ant Siafu"};
        arraySort = new ArrayList<String>(Arrays.asList(animal));
        listView = new ListView(MainActivity.this);

        arrayAdapter=new AlertAdapter(MainActivity.this, arraySort);

        listView.setAdapter(arrayAdapter);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showAlert();
            }
        });


    }

    private void showAlert(){
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setCancelable(false)
                .setTitle("Alert Dialog Search")
                .setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.cancel();
                    }
                });
        final EditText editTextSearch = new EditText(MainActivity.this);

        //editTextSearch.setCompoundDrawablesWithIntrinsicBounds(R.drawable.ic_launcher_background,0,0,0);
        final ArrayList arrayList = new ArrayList<String>(Arrays.asList(animal));
        arrayAdapter.notifyDataSetChanged();

        LinearLayout layout = new LinearLayout(MainActivity.this);

        layout.setOrientation(LinearLayout.VERTICAL);

        layout.addView(editTextSearch);

        layout.addView(listView);

        builder.setView(layout);


        listView.setOnItemClickListener(this);

        editTextSearch.addTextChangedListener(new TextWatcher() {

            public void afterTextChanged(Editable s){

            }

            public void beforeTextChanged(CharSequence s,int start, int count, int after){

            }

            public void onTextChanged(CharSequence s, int start, int before, int count) {
                editTextSearch.setCompoundDrawablesWithIntrinsicBounds(0,0,0,0);
                textLength = editTextSearch.getText().length();
                arraySort.clear();
                for (int i = 0; i < animal.length; i++) {
                    if (textLength <= animal[i].length()) {
                        if(animal[i].toLowerCase().contains(editTextSearch.getText().toString().toLowerCase().trim())) {
                            arraySort.add(animal[i]);
                        }
                    }
                }

                listView.setAdapter(new AlertAdapter(MainActivity.this, arraySort));

            }

        });

        AlertDialog alertDialog = builder.create();
        alertDialog.show();

    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        Toast.makeText(MainActivity.this,animal[position],Toast.LENGTH_LONG).show();
    }
}
