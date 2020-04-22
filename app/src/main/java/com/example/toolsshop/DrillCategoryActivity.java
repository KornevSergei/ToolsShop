package com.example.toolsshop;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class DrillCategoryActivity extends AppCompatActivity {

    //создаем ссылку а лист
    private ListView listViewDrills;

    //создаём ссылку на массив дрелей
    private ArrayList<Drill> drills;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_drill_category);

        //получаем ссылку на экшенбар и если не равно нал - скрываем
        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.hide();
        }
        listViewDrills = findViewById(R.id.listViewDrills);

        drills = new ArrayList<>();
        //добавляем дрели в лист
        drills.add(new Drill(getString(R.string.drill_interskol_title),getString(R.string.drill_interskol_info),R.drawable.drill1));
        drills.add(new Drill(getString(R.string.drill_makita_title),getString(R.string.drill_makita_info),R.drawable.drill2));
        drills.add(new Drill(getString(R.string.drill_dewolt_title),getString(R.string.drill_dewolt_info),R.drawable.drill3));
        //Создаём адаптер для заполнения листа из массива
        ArrayAdapter<Drill> adapter = new ArrayAdapter<>(getApplicationContext(), android.R.layout.simple_list_item_1, drills);
        listViewDrills.setAdapter(adapter);

        //добавляем слушатель событий и делаем переход по клику и выводим информацию
        listViewDrills.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Drill drill = drills.get(position);
                Intent intent = new Intent(getApplicationContext(),DrillCategoryActivity.class);
                intent.putExtra("title",drill.getTitle());
                intent.putExtra("info",drill.getInfo());
                intent.putExtra("resId",drill.getImageResourceId());
                startActivity(intent);
            }
        });
    }
}
