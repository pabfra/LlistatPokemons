package com.example.llistatpokemons;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.navigation.fragment.NavHostFragment;

import com.example.llistatpokemons.databinding.FragmentFirstBinding;

import java.util.ArrayList;
import java.util.Arrays;

public class FirstFragment extends Fragment {

    private FragmentFirstBinding binding;

    @Override
    public View onCreateView(
            LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState
    ) {

        binding = FragmentFirstBinding.inflate(inflater, container, false);
        return binding.getRoot();

    }

    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        String[] pokemonsPrueba = {"Bulbassaur", "Pikachu", "Charmander"};
        ArrayList<String> items = new ArrayList<>(Arrays.asList(pokemonsPrueba));
        ArrayAdapter<String> adapter = new ArrayAdapter<>(
                getContext(),
                R.layout.lv_pokemon_row,
                R.id.txtListName,
                items
        );

        binding.lvPokemons.setAdapter(adapter);

    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }

}