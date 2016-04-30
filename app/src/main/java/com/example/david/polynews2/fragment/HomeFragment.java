package com.example.david.polynews2.fragment;

import android.app.Activity;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.widget.GridView;
import android.widget.ImageSwitcher;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.ViewSwitcher;

import com.example.david.polynews2.ImageItem;
import com.example.david.polynews2.R;
import com.example.david.polynews2.adapter.SpinnerAdapter;
import com.example.david.polynews2.storage.Copy;
import com.example.david.polynews2.adapter.GridViewAdapter;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;

/**
 * Created by david on 19/04/2016.
 */
public class HomeFragment extends Fragment {
    public static final String ARG_PAGE = "ARG_PAGE";
    private int mPage;

    public static HomeFragment newInstance(int page){
        Bundle args = new Bundle();
        args.putInt(ARG_PAGE, page);
        HomeFragment fragment = new HomeFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mPage = getArguments().getInt(ARG_PAGE);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_home, container, false);

        try{
            myMethod(view);
        }

        catch(IOException e){
            Log.e("ERROR : ", e.toString());
        }

        return view;
    }
    /*

    public void initializeWebView(View v) throws IOException{
        Copy.store(getContext(), "html/home.html", "databases/home.html");

        WebView webView = (WebView) v.findViewById(R.id.home_web);
        webView.loadUrl("file:///data/data/com.example.david.polynews2/databases/home.html");
    }
    */
    public void myMethod(View v) throws IOException{

        //initializeWebView(v);
        Spinner presentation = (Spinner) v.findViewById(R.id.home_presentation);
        String text = "Polytech Nice-Sophia est l'école d'ingénieur de l'Université Nice - Sophia Antipolis. Elle fait partie du regroupement des écoles du réseau national Polytech d'école d'ingénieur polytechnique (Ecole Polytechnique Universitaire). Inscrite au titre de grande école d’ingénieurs, habilitée par la commission des titres d'ingénieur (CTI), notre école est au centre d'une synergie Enseignement - Recherche - Industrie. Nous sommes implantés au coeur de la technopole Sophia-Antipolis, sur le campus SophiaTech. Avec une admission Post-Bac, Bac+2 et Bac+3, Nous proposons des formations originales, innovantes et de niveau international : Bâtiments, Electronique, Electronique et Informatique Industrielle, Génie Biologie, Génie l'Eau, Mathématiques Appliquées et Modélisation et Sciences Informatiques. Ainsi qu'un parcours des écoles d'ingénieurs Polytech (PeiP/CiP) d'admission post-Bac. Polytech Nice-Sophia affiche clairement sa volonté d’ouverture sur le monde industriel. Dans un environnement favorable, notre école forme des ingénieurs ayant une base scientifique et technique solide, possédant une bonne culture d’entreprise, capables de communiquer et initiés aux fonctions d’encadrement. Nous offrons une formation en adéquation avec les besoins de l’entreprise. 95% de nos diplômés trouvent un emploi dans les 3 mois qui suivent la sortie de notre école. Nous sommes nés en 2005 du regroupement de plusieurs écoles d'ingénieurs locales : de l'Ecole Supérieure d'Ingénieurs de Nice Sophia Antipolis (ESINSA), de l'Ecole Supérieure en Sciences Informatiques (ESSI) et du Magistère de Pharmacologie de l'Université.\n" +
                "\n";
        String[] array = {"Présentation",text};
        SpinnerAdapter sa = new SpinnerAdapter(getContext(),R.layout.spinner_row,array);
        presentation.setAdapter(sa);


        final ImageSwitcher sw;
        sw = (ImageSwitcher) v.findViewById(R.id.imageSwitcher);
        sw.setFactory(new ViewSwitcher.ViewFactory() {
            @Override
            public View makeView() {
                ImageView myView = new ImageView(getContext());
                myView.setScaleType(ImageView.ScaleType.CENTER);
                myView.setLayoutParams(new ImageSwitcher.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.MATCH_PARENT));
                return myView;
            }
        });

        new Timer().scheduleAtFixedRate(new TimerTask() {
            int i = 0;

            @Override
            public void run() {
                try{
                    getActivity().runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            if (i == 0)
                                sw.setImageResource(R.drawable.presentation1);
                            else if (i == 1) {
                                sw.setImageResource(R.drawable.presentation2);
                            } else if (i == 2) {
                                sw.setImageResource(R.drawable.presentation3);
                                i = -1;
                            }
                            i++;
                        }
                    });
                }

                catch(Exception e){
                    Log.e("HomeFragment","Error",e);
                }


            }
        }, 0, 3000);


        TextView galerie = (TextView) v.findViewById(R.id.home_galerie);
        galerie.setText("Galerie Photos");
        GridView grid = (GridView)v.findViewById(R.id.gridView);
        ArrayList<ImageItem> test = new ArrayList<>();
        TypedArray imgs = getResources().obtainTypedArray(R.array.image_ids);


        for (int i = 0; i < imgs.length(); i++) {
            Bitmap bitmap;
            bitmap = Bitmap.createScaledBitmap(BitmapFactory.decodeResource(getResources(), imgs.getResourceId(i, -1)),100,100,true);
           // Bitmap bitmap = BitmapFactory.decodeResource(getResources(), imgs.getResourceId(i, -1));
            test.add(new ImageItem(bitmap, "Image#" + i));
        }

        GridViewAdapter gridAdapter = new GridViewAdapter(getContext(), R.layout.grid_item_layout,test);
        grid.setAdapter(gridAdapter);



    }

}
