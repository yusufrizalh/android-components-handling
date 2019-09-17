package id.inixindosurabaya.comphandling;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    // 1. inisialisasi komponen dalam layout
    EditText edit_fullname;
    Spinner spin_branch;
    CheckBox chk_android, chk_ios, chk_cisco, chk_oracle;
    RadioGroup radioGroup1;
    RadioButton radio_regular, radio_extension;
    Button btn_show;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // 2. mengenali semua komponen
        edit_fullname = findViewById(R.id.edit_fullname);
        spin_branch = findViewById(R.id.spin_branch);
        chk_android = findViewById(R.id.chk_android);
        chk_ios = findViewById(R.id.chk_ios);
        chk_cisco = findViewById(R.id.chk_cisco);
        chk_oracle = findViewById(R.id.chk_oracle);
        radioGroup1 = findViewById(R.id.radioGroup1);
        radio_regular = findViewById(R.id.radio_regular);
        radio_extension = findViewById(R.id.radio_extension);
        btn_show = findViewById(R.id.btn_show);

        // 3. event handling untuk masing-masing komponen

        // event handling spinner
        // membuat isian kantor cabang sebagai pilihan dalam spinner
        final List<String> cabang = new ArrayList<String>();
        cabang.add("Jakarta");
        cabang.add("Surabaya");
        cabang.add("Bandung");
        cabang.add("Jogjakarta");
        cabang.add("Batam");
        cabang.add("Makassar");

        // membuat adapter
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(
                this, android.R.layout.simple_spinner_item, cabang
        );

        // menghubungkan adapter dengan spinner
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spin_branch.setAdapter(adapter);

        // jika salah satu cabang dipilih, munculkan dalam toast
        spin_branch.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String text = parent.getItemAtPosition(position).toString();
                Toast.makeText(parent.getContext(),
                        "Branch: " + text, Toast.LENGTH_LONG).show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        // event handling checkbox
        chk_android.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                Toast.makeText(MainActivity.this,
                        "Training Android Programming", Toast.LENGTH_SHORT).show();
            }
        });

        chk_ios.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                Toast.makeText(MainActivity.this,
                        "Training iOS Programming", Toast.LENGTH_SHORT).show();
            }
        });

        chk_cisco.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                Toast.makeText(MainActivity.this,
                        "Training Cisco Networking", Toast.LENGTH_SHORT).show();
            }
        });

        chk_oracle.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                Toast.makeText(MainActivity.this,
                        "Training Oracle Database", Toast.LENGTH_SHORT).show();
            }
        });

        // event handling radio group dan radio button
        radioGroup1.clearCheck();
        radioGroup1.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @SuppressLint("ResourceType")
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                RadioButton myRadio = radioGroup1.findViewById(checkedId);
                if (myRadio != null && checkedId > -1) {
                    Toast.makeText(MainActivity.this,
                            "Class: " + myRadio.getText(), Toast.LENGTH_SHORT).show();
                }
            }
        });

        // event handling button show
        btn_show.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String fullname = edit_fullname.getText().toString();
                String showFullname = "\nFullname: ";
                String showBranch = "\nBranch: ";
                String showMaterial = "\nMaterial: ";
                String showClass = "\nClass: ";

                // mengambil nilai dari cabang
                String myBranch = spin_branch.getSelectedItem().toString();

                // mengambil nilai dari material
                if (chk_android.isChecked()) {
                    showMaterial += "Training Android Programming";
                }
                if (chk_ios.isChecked()) {
                    showMaterial += "Training iOS Programming";
                }
                if (chk_cisco.isChecked()) {
                    showMaterial += "Training Cisco CCNA";
                }
                if (chk_oracle.isChecked()) {
                    showMaterial += "Training Oracle Database";
                }

                // mengambil nilai dari class
                if (radio_regular.isChecked()) {
                    showClass += "Regular Class";
                }
                if (radio_extension.isChecked()) {
                    showClass += "Extension Class";
                }

                // menampilkan secara keseluruhan
                Toast.makeText(MainActivity.this,
                        "-Show All Data-\n" +
                        showFullname + fullname +
                        showBranch + myBranch +
                        showMaterial + showClass, Toast.LENGTH_LONG).show();
            }
        });
    }
}
