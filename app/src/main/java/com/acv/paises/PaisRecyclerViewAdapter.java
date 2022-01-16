package com.acv.paises;

import android.os.Bundle;
import androidx.recyclerview.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.navigation.Navigation;

import com.acv.paises.placeholder.PlaceholderContent.Pais;
import com.acv.paises.databinding.FragmentPaisBinding;

import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

/**
 * {@link RecyclerView.Adapter} that can display a {@link Pais}.
 * TODO: Replace the implementation with code for your data type.
 */
public class PaisRecyclerViewAdapter extends RecyclerView.Adapter<PaisRecyclerViewAdapter.ViewHolder> {

    private final List<Pais> mValues;
    ArrayList<Bandera> banderas;

    public PaisRecyclerViewAdapter(List<Pais> items, ArrayList<Bandera> banderas) {
        mValues = items;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        return new ViewHolder(FragmentPaisBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false));

    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, int position) {
        holder.mItem = mValues.get(position);
        holder.mContentView.setText(mValues.get(position).nombre);

        holder.imgBanderaClase.setImageResource(banderas.get(position).getIdImagen());
        holder.textoTarjeta.setText(banderas.get(position).getNombrePais());
    }

    @Override
    public int getItemCount() {
        //return mValues.size();
        return banderas.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        public final TextView mContentView;
        public Pais mItem;

        ImageView imgBanderaClase;
        TextView textoTarjeta;

        public ViewHolder(FragmentPaisBinding binding) {
            super(binding.getRoot());
            mContentView = binding.content;
            binding.getRoot().setOnClickListener(this);
            imgBanderaClase = binding.imgBandera;
            textoTarjeta = binding.content;
        }

        @Override
        public String toString() {
            return super.toString() + " '" + mContentView.getText() + "'";
        }

        @Override
        public void onClick(View view) {
            Bundle args = new Bundle();
            args.putParcelable("pais", mItem);
            args.putString("title", mItem.nombre);

            Navigation.findNavController(view).navigate(R.id.action_paisesFragment_to_detallePaisFragment, args);
        }
    }
}