package com.acv.paises;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.preference.Preference;
import androidx.preference.PreferenceManager;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import com.acv.paises.placeholder.PlaceholderContent;

import java.util.ArrayList;
import java.util.List;

/**
 * A fragment representing a list of Items.
 */
public class PaisesFragment extends Fragment {

    ArrayList<Bandera> banderas;
    List<PlaceholderContent.Pais> pais;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_paises_list, container, false);

        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(getContext());

        // Set the adapter
        if (view instanceof RecyclerView) {
            Context context = view.getContext();
            RecyclerView recyclerView = (RecyclerView) view;
            String tipoVisualizacion = prefs.getString("tipo_visualizacion","tipo_visualizacion");
            if (tipoVisualizacion.equals("listado")) {
                recyclerView.setLayoutManager(new LinearLayoutManager(context));
            } else { //Si fuera "rejilla"
                recyclerView.setLayoutManager(new GridLayoutManager(context, 2));
            }

            boolean useDivider = prefs.getBoolean("linea",false);
            if(useDivider){
                DividerItemDecoration verticalDecoration = new DividerItemDecoration(recyclerView.getContext(), LinearLayout.VERTICAL);
                recyclerView.addItemDecoration(verticalDecoration);
            }

            PlaceholderContent placeholderContent = new PlaceholderContent(getResources(),getContext().getPackageName());
            banderas = new ArrayList<>();
            anyadirBanderas();
            pais = new ArrayList<>();
            recyclerView.setAdapter(new PaisRecyclerViewAdapter(placeholderContent.PAISES,banderas));
        }
        return view;
    }

    private void anyadirBanderas(){
        banderas.add(new Bandera(R.drawable.bandera_argentina,"Argentina"));
        banderas.add(new Bandera(R.drawable.bandera_australia,"Australia"));
        banderas.add(new Bandera(R.drawable.bandera_belgica,"Belgica"));
        banderas.add(new Bandera(R.drawable.bandera_canada,"Canada"));
        banderas.add(new Bandera(R.drawable.bandera_dinamarca,"Dinamarca"));
        banderas.add(new Bandera(R.drawable.bandera_espana,"España"));
    }
}