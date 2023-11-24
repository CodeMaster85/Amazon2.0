package projetfinal.amazon;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button btn = findViewById(R.id.confirmerBouton);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = ((EditText) findViewById(R.id.nameEditText)).getText().toString();
                String password = ((EditText) findViewById(R.id.passwordEditText)).getText().toString();
                if (DataBaseAChanger.isUserGood(name, password))
                {
                    Toast.makeText(MainActivity.this, "lesgo", Toast.LENGTH_SHORT).show();
                    Intent shopActivityIntent = new Intent(MainActivity.this, ShopActivity.class);
                    startActivity(shopActivityIntent);
                }
                else
                    Toast.makeText(MainActivity.this, "Wrong password or name: "  + name + " " + password , Toast.LENGTH_SHORT).show();
            }
        });
    }
}