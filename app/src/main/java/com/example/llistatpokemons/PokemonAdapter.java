package com.example.llistatpokemons;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;


import com.example.llistatpokemons.databinding.LvPokemonRowBinding;

import java.util.ArrayList;

public class PokemonAdapter extends ArrayAdapter<Pokemon> {

    public PokemonAdapter(@NonNull Context context, int resource, @NonNull ArrayList<Pokemon> pokemons) {
        super(context, resource, pokemons);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        Pokemon pokemon = getItem(position);
        //LvPokemonRowBinding binding = null;

        if (convertView == null) {
            LayoutInflater inflater = LayoutInflater.from(getContext());
            convertView = inflater.inflate(R.layout.lv_pokemon_row, parent, false);
        }

        //LvPokemonRowBinding.bind(convertView);

        TextView txtListName = convertView.findViewById(R.id.txtListName);
        TextView txtHeight = convertView.findViewById(R.id.txtHeight);
        TextView txtWeight = convertView.findViewById(R.id.txtWeight);
        ImageView imgView = convertView.findViewById(R.id.imgPokemonFront);

        txtListName.setText(pokemon.getName());
        txtHeight.setText(String.valueOf(pokemon.getHeight()));
        txtWeight.setText(String.valueOf(pokemon.getWeight()));


        return convertView;
    }
}
