package ir.mz10.alertcustomdialog;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.dialog.MaterialAlertDialogBuilder;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.textfield.TextInputLayout;

public class MainActivity extends AppCompatActivity {
    private MaterialAlertDialogBuilder materialAlertDialogBuilder;
    private View customAlertDialog;
    private FloatingActionButton floatingActionButton;
    private TextInputLayout nameTextField;
    private TextInputLayout phoneNumberTextField;
    private TextInputLayout addressTextField;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        materialAlertDialogBuilder = new MaterialAlertDialogBuilder(this);
        Button floatingActionButton = findViewById(R.id.floatingActionButton);
        floatingActionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                customAlertDialog = LayoutInflater.from(MainActivity.this).inflate(R.layout.order_details_custom_dialog, null, false);
                nameTextField = customAlertDialog.findViewById(R.id.name_text_field);
                phoneNumberTextField = customAlertDialog.findViewById(R.id.phone_number_text_field);
                addressTextField = customAlertDialog.findViewById(R.id.address_text_field);

                materialAlertDialogBuilder.setView(customAlertDialog)
                        .setTitle("Details")
                        .setMessage("Enter your basic details")
                        .setPositiveButton("Add", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                String name = nameTextField.getEditText().toString();
                                String phoneNumber = phoneNumberTextField.getEditText().toString();
                                String address = addressTextField.getEditText().toString();
                                dialog.dismiss();
                            }
                        }).setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                    }
                }).show();
            }
        });
    }



}