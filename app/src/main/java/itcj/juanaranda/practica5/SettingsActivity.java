package itcj.juanaranda.practica5;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Switch;
import android.widget.Toast;
import android.widget.ToggleButton;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.preference.EditTextPreference;
import androidx.preference.ListPreference;
import androidx.preference.PreferenceFragmentCompat;
import androidx.preference.PreferenceManager;

import java.util.ArrayList;
import java.util.Collections;

public class SettingsActivity extends AppCompatActivity implements View.OnClickListener {

    private ListView listView;
    ArrayList<String> messages = new ArrayList<>();
    ArrayAdapter<String> arrayAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.settings_activity);
        listView = findViewById(R.id.eventsList);

        arrayAdapter = new ArrayAdapter<>(getApplicationContext(), android.R.layout.simple_list_item_1, messages);
        // Set The Adapter
        listView.setAdapter(arrayAdapter);
        arrayAdapter.notifyDataSetChanged();
    }



    @Override
    public void onClick(View v) {
        String message = "";
        if (v.getId() == R.id.toggleButton) {
            ToggleButton  toggleButton = findViewById(R.id.toggleButton);
            boolean value = toggleButton.isChecked();
            if (value) {
                message = "El boton esta encendido";
            } else {
                message = "El boton esta apagado";
            }
        } else if (v.getId() == R.id.checkBox) {
            CheckBox checkBox = findViewById(R.id.checkBox);
            boolean value = checkBox.isChecked();
            if (value) {
                message = "Se activo el ultrainstinto";
            } else {
                message = "Se desactivo el ultrainstinto";
            }
        } else if (v.getId() == R.id.switch1) {
            @SuppressLint("UseSwitchCompatOrMaterialCode") Switch switch1 = findViewById(R.id.switch1);
            boolean value = switch1.isChecked();
            if (value) {
                message = "Se sincronizo en la nube";
            } else {
                message = "Se desincronizo compa";
            }
        } else if (v.getId() == R.id.radioButton2) {
            RadioButton radioButton = findViewById(R.id.radioButton2);
            String name = radioButton.getText().toString();
            message = name + " esta activado";

        } else if (v.getId() == R.id.radioButton3) {

            RadioButton radioButton = findViewById(R.id.radioButton3);
            String name = radioButton.getText().toString();
            message = name + " esta activado";

        } else if (v.getId() == R.id.button) {
            message = "Cambios guardados";

        }


        if (!message.isEmpty()) {
            showToast(message);
        }
    }

    private void showToast(String message) {
        // Toast.makeText(getApplicationContext(), message, Toast.LENGTH_SHORT).show();
        this.messages.add(message);
        Collections.reverse(this.messages);
        listView.setAdapter(arrayAdapter);

    }

}