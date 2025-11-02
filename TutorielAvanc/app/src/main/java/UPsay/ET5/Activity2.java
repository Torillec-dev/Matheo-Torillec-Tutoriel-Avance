package UPsay.ET5;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

public class Activity2 extends AppCompatActivity {

    public static final String EXTRA = "message";
    EditText monTexte;
    Fragment page1 = new FragmentHaut();
    Fragment page2 = new FragmentBas();
    FragmentManager fm;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_2);

        fm = getSupportFragmentManager();
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }

    public void lanceActivy1(View view) {
        Intent messageIntent = new Intent();
        monTexte = findViewById(R.id.textInputLayout);
        String message = monTexte.getText().toString();
        messageIntent.putExtra(EXTRA, message);
        setResult(Activity.RESULT_OK, messageIntent);
        finish();
    }

    public void lancePage1(View view) {
        FragmentTransaction ft = fm.beginTransaction();
        ft.replace(R.id.frame, page1);
        ft.addToBackStack(null);
        ft.commit();
    }

    public void lancePage2(View view) {
        FragmentTransaction ft = fm.beginTransaction();
        ft.replace(R.id.frame, page2);
        ft.addToBackStack(null);
        ft.commit();
    }
}
