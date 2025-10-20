package UPsay.ET5;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    private ActivityResultLauncher<Intent> lanceActivity2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        lanceActivity2 = registerForActivityResult( new ActivityResultContracts.StartActivityForResult(), result -> {
            if(result.getResultCode()== MainActivity.RESULT_OK){
                Intent data=result.getData();
                if(data != null){
                    String message= data.getStringExtra(Activity2.EXTRA);
                    TextView textView=findViewById(R.id.textView);
                    textView.setText(message);
                }
            }
        });
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }

    public void lanceActivite2(View view) {
        Intent intent = new Intent(this, Activity2.class);
        lanceActivity2.launch(intent);
    }
}