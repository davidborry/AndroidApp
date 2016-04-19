package com.example.david.polynews2.fragment;

import android.content.Intent;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.GridView;

import com.example.david.polynews2.R;
import com.example.david.polynews2.adapter.VideosCustomAdapter;

import java.util.List;

import com.example.david.polynews2.html.video.Video;
import com.example.david.polynews2.html.video.YoutubeAPI;

/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * to handle interaction events.
 * Use the {@link VideosListFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class VideosListFragment extends Fragment {

    public VideosListFragment() {
        // Required empty public constructor
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        new AsyncTask<String, Void, List<Video>>() {
            @Override
            protected List<Video> doInBackground(String... params) {
                return new YoutubeAPI("UUC0wTzkzyLDrJt1NjeIT3Yg").getVideos();
            }

            @Override
            protected void onPostExecute(List<Video> vids) {
                final VideosCustomAdapter videos = new VideosCustomAdapter(getActivity(), R.id.news_empty);
                videos.addAll(vids);
                ((GridView) getActivity().findViewById(R.id.news_grid_layout)).setAdapter(videos);
                ((GridView) getActivity().findViewById(R.id.news_grid_layout)).setOnItemClickListener(new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                        Video video = (Video) parent.getItemAtPosition(position);
                        Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.youtube.com/watch?v="+video.getVideoId()));
                                startActivity(browserIntent);
                    }
                });
            }
        }.execute();
    }

    public static VideosListFragment newInstance() {
        VideosListFragment fragment = new VideosListFragment();
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_videos_list, container, false);
    }

}
