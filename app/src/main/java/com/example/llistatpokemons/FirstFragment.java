package com.example.llistatpokemons;

import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.navigation.fragment.NavHostFragment;

import com.example.llistatpokemons.databinding.FragmentFirstBinding;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class FirstFragment extends Fragment {

    private FragmentFirstBinding binding;
    private ArrayAdapter adapter;

    @Override
    public View onCreateView(
            LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState
    ) {

        binding = FragmentFirstBinding.inflate(inflater, container, false);
        setHasOptionsMenu(true);
        return binding.getRoot();

    }

    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        //String[] pokemonsPrueba = {"Bulbassaur", "Pikachu", "Charmander"};
        ArrayList<String> items = new ArrayList<>();
        adapter = new ArrayAdapter<String>(
                getContext(),
                R.layout.lv_pokemon_row,
                R.id.txtListName,
                items
        );


        binding.lvPokemons.setAdapter(adapter);
        refresh();
    }
    public boolean onOptionsItemSelected (MenuItem item) {
        if (item.getItemId() == R.id.refresh)
            refresh();
        return false;
    }

    public void refresh() {
        Toast.makeText(getContext(), "Refrescando", Toast.LENGTH_LONG).show();
        ExecutorService executor = Executors.newSingleThreadExecutor();
        Handler handler = new Handler(Looper.getMainLooper());

        executor.execute(() -> {
            PokemonApi api = new PokemonApi();
            ArrayList<Pokemon>  pokemons = api.getPokemons();

            handler.post(() -> {
                adapter.clear();
                adapter.addAll(pokemons);
            });
        });
    }



    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }

}