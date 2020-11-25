package com.dsi32.customlistview;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashMap;

public class MainActivity extends AppCompatActivity {
    protected ListView maListeViewPerso;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //appel de la liste view
        maListeViewPerso = findViewById(R.id.listviewperso);

        //création de la arraylist qui nous permettra de remplir la listeview préparer les données
        ArrayList<HashMap< String,String>> ListItem = new ArrayList();
        //on déclare la hashmap qui contiendra les infos pour un item
        HashMap<String,String> map;
        //création d'une hashmap pour insérer les infos du premier item de notre listeview
        map= new HashMap<>();
        map.put("titre","Word");
        map.put("description","Editeur de texte");
        map.put("img",String.valueOf(R.drawable.word));
        //enfin on ajoute cette hashmap dans arraylist
        ListItem.add(map);
        map= new HashMap<>();
        map.put("titre","Excel");
        map.put("description","Tableur");
        map.put("img",String.valueOf(R.drawable.excel));
        ListItem.add(map);
        map= new HashMap<>();
        map.put("titre","PowerPoint");
        map.put("description","Logiciel de présentation");
        map.put("img",String.valueOf(R.drawable.powerpoint));
        ListItem.add(map);
        map= new HashMap<>();
        map.put("titre","Outlook");
        map.put("description","Client de courrier electronique");
        map.put("img",String.valueOf(R.drawable.outlook));
        ListItem.add(map);




        SimpleAdapter adapter = new SimpleAdapter(this.getBaseContext(),
                ListItem,
                R.layout.activity_list_item,
                new String[]{"img","titre","description"},
                new int[]{R.id.img,R.id.titre, R.id.description});

        maListeViewPerso.setAdapter(adapter);
        maListeViewPerso.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                HashMap map = (HashMap) maListeViewPerso.getItemAtPosition(position);
                String titre = (String) map.get("titre");
                Toast.makeText(view.getContext(),titre,Toast.LENGTH_SHORT).show();
            }
        });
        maListeViewPerso.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> arg0, View view,
                                           int position, long id) {
                HashMap map = (HashMap) maListeViewPerso.getItemAtPosition(position);
                //on crée une boite de dialogue
                AlertDialog.Builder adhb = new AlertDialog.Builder(view.getContext());
                adhb.setTitle("selection Item");
                adhb.setMessage("votre choix:"+ map.get("titre"));
                //on affiche la boite de dialogue
                adhb.show();
                return true;
            }
        });

    }
}