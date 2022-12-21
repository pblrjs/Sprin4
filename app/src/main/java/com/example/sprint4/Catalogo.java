package com.example.sprint4;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ListView;
import java.util.ArrayList;
import com.example.sprint4.Adaptador.ProductoAdapter;
import com.example.sprint4.DB.DBFirebase;
import com.example.sprint4.Entidades.Producto;

public class Catalogo extends AppCompatActivity {
    private DBFirebase dbFirebase;
    private ListView listViewProducts;
    private ArrayList<Producto> arrayProductos;
    private ProductoAdapter productoAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_catalogo);

        listViewProducts = (ListView) findViewById(R.id.listViewProducts);
        arrayProductos = new ArrayList<>();
        dbFirebase = new DBFirebase();
/*
        // **** PRODUCTOS
        Producto prod1 = new Producto("Prod1", "Desc1", 1000, "", "", "");
        Producto prod2 = new Producto("Producto2", "Desc2", 2000, "", "", "");
        Producto prod3 = new Producto("Producto3", "Desc3", 3000, "", "", "");
        Producto prod4 = new Producto("Producto4", "Desc4", 4000, "", "", "");

        arrayProductos.add(prod1);
        arrayProductos.add(prod2);
        arrayProductos.add(prod3);
        */
        // --------------------------------------------------------------

        productoAdapter = new ProductoAdapter(this, arrayProductos);
        listViewProducts.setAdapter(productoAdapter);
        dbFirebase.getData(productoAdapter);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        Intent intent;
        switch (item.getItemId()){
            case R.id.itemAdd:
                intent = new Intent(getApplicationContext(), Form.class);
                startActivity(intent);
                return true;
            case R.id.itemMap:
                intent = new Intent(getApplicationContext(), Map.class);
                startActivity(intent);
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
}