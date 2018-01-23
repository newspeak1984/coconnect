package com.example.ivanchow.portablepc;

import android.content.Intent;
import android.net.Uri;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;


public class AddGroup extends AppCompatActivity{

    private static final int RESULT_LOAD_IMAGE = 1;

    EditText editTextName;
    Button buttonAdd;
    DatabaseReference databaseGroups;

    ImageView upload;
    Button uploadImage;
    LinearLayout group_list;
    Uri pic;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_addgroup);

        databaseGroups = FirebaseDatabase.getInstance().getReference("groups");
        editTextName = (EditText) findViewById(R.id.editTextName);
        buttonAdd = (Button) findViewById(R.id.buttonAddGroup);
        group_list = (LinearLayout) findViewById(R.id.temp);
        buttonAdd.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                addGroup();
                Intent intent = new Intent(AddGroup.this, GroupList.class);
                createGroupButton(pic);
                //startActivity(intent);
            }
        });

        upload = (ImageView) findViewById(R.id.imageToUpload);
        uploadImage = (Button) findViewById(R.id.buttonAddImage);
        uploadImage.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                addPicture();
            }
        });
    }
    private void addPicture(){
        Intent galleryIntent = new Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
        startActivityForResult(galleryIntent, RESULT_LOAD_IMAGE);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode == RESULT_LOAD_IMAGE && resultCode == RESULT_OK && data != null){
            Uri selectedImage = data.getData();
            pic = data.getData();
            upload.setImageURI(selectedImage);
        }
    }

    private void addGroup(){
        String name = editTextName.getText().toString().trim();
        if(!TextUtils.isEmpty(name)){
            String id = databaseGroups.push().getKey();
            Group group = new Group(id, name);
            databaseGroups.child(id).setValue(group);
            Toast.makeText(this,"Group added", Toast.LENGTH_LONG).show();
        }else{
            Toast.makeText(this, "Enter a group name", Toast.LENGTH_LONG).show();
        }
    }

    public void createGroupButton(Uri uri){
        ImageButton but = new ImageButton(getApplicationContext());
        but.setMaxHeight(500);
        but.setMaxWidth(300);
        but.setImageURI(uri);
        group_list.addView(but);
    }
}