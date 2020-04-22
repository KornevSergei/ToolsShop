package com.example.toolsshop;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    //добавляем слушатель событий для определния клика элементов листВью
    private ListView listViewTools;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        //получаем ссылку на экшенбар и если не равно нал - скрываем
        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.hide();
        }

        //связываем
        listViewTools = findViewById(R.id.listViewTools);
        //добавляем слушатель событий и делаем переход через свичкейс
        //выводим тост для определения позиций при клике
        listViewTools.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(getApplicationContext(), "Позиция: " + position, Toast.LENGTH_SHORT).show();
                switch (position){
                    case 0:
                        Intent intent = new Intent(getApplicationContext(),DrillCategoryActivity.class);
                        startActivity(intent);
                        break;
                }
            }
        });
    }
}
