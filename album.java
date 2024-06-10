package com.manogna;

import java.util.ArrayList;
import java.util.LinkedList;

public class album {
    private String name;
    private String artist;
    private ArrayList<song> songs;

    public album(String name, String artist) {
        this.name = name;
        this.artist = artist;
        this.songs = new ArrayList<song>();
    }
    public album() {

    }

    public song findsong(String title) {
        for(song checkedsong : songs) {
            if(checkedsong.getTitle().equals(title)) return checkedsong;
        }
        return null;
    }
    public boolean addsong(String title, double duration) {
        if (findsong(title) == null) {
            songs.add(new song(title, duration));
//            System.out.println(title + "successfully added to list");
            return true;
        } else {
 //           System.out.println("Song with name" + title + "already exist in the list");
            return false;
        }
    }
    public boolean addToPlaylist(int trackNumber, LinkedList<song> playlist) {
        int index=trackNumber -1;
        if(index>0 && index<=this.songs.size()) {
            playlist.add(this.songs.get(index));
            return true;
        }
//        System.out.println("This album does not have tracknumber"+trackNumber);
        return false;
    }

    public boolean addToPlaylist(String title, LinkedList<song> playlist) {
        for(song checkedsong : this.songs) {
            if(checkedsong.getTitle().equals(title)) {
                playlist.add(checkedsong);
                return true;
            }
        }
 //       System.out.println("There is no such song in album");
        return false;

    }
}
