package com.manogna;

import java.util.*;

public class Main {
    private static ArrayList<album> albums=new ArrayList<>();

    public static void main(String[] args) {

        album album= new album("Album1","SPB");
        album.addsong("Materani",4.02);
        album.addsong("Nee prashnalu",3.55);
        album.addsong("Sundari Neeve",3.25);
        album.addsong("Jilibili Palukula",4.01);
        albums.add(album);

        album= new album("Album2","Ilayaraja");

        album.addsong("Singarala",2.54);
        album.addsong("Hello Guru",3.54);
        album.addsong("Kammani",3.44);
        albums.add(album);

        LinkedList<song> playlist1=new LinkedList<>();
        albums.get(0).addToPlaylist("Mataerani",playlist1);
        albums.get(0).addToPlaylist("Sundari Neeve",playlist1);
        albums.get(1).addToPlaylist("Kammani",playlist1);
        albums.get(1).addToPlaylist("Singarala",playlist1);

        play(playlist1);
    }
    private static void play(LinkedList<song> playlist) {
        Scanner sc=new Scanner(System.in);
        boolean quit=false;
        boolean forward=true;
        ListIterator<song> listIterator = playlist.listIterator();

        if(playlist.size()==0) {
            System.out.println("This playlist has no song");
        } else {
            System.out.println("Now playing"+listIterator.next().toString());
            printMenu();
        }
        while (!quit) {
            int action=sc.nextInt();
            sc.nextLine();

            switch (action) {
                case 0:
                    System.out.println("Playlist completed");
                    quit=true;
                    break;
                case 1:
                    if(!forward) {
                        if(listIterator.hasNext()) {
                            listIterator.next();
                        }
                        forward=true;
                    }
                    if(listIterator.hasNext()) {
                        System.out.println("Now playing"+listIterator.next().toString());
                    } else {
                        System.out.println("No song available");
                        forward=false;
                    }
                    break;
                case 2:
                    if(forward){
                        if(listIterator.hasPrevious()){
                            listIterator.previous();
                        }
                        forward=false;
                    }
                    if(listIterator.hasPrevious()){
                        System.out.println("Now playing"+listIterator.previous().toString());
                    } else {
                        System.out.println("Now at 1st song");
                        forward=false;
                    }
                    break;
                case 3:
                    if(forward){
                        if(listIterator.hasPrevious()){
                            System.out.println("Now playing"+listIterator.previous().toString());
                            forward=false;
                        } else {
                            System.out.println("Now at start of list");
                        }
                    } else {
                        if(listIterator.hasNext()){
                            System.out.println("Now playing"+listIterator.next().toString());
                            forward=true;
                        } else {
                            System.out.println("Reached to end of list");
                        }
                    }
                    break;
                case 4:
                    printList(playlist);
                    break;
                case 5:
                    printMenu();
                    break;
                case 6:
                    if(playlist.size()>0){
                        listIterator.remove();
                        if(listIterator.hasNext()){
                            System.out.println("Now playing"+listIterator.next().toString());
                        } else {
                            if(listIterator.hasPrevious())
                            System.out.println("Now playing"+listIterator.previous().toString());
                        }
                    }
            }
        }
    }

    private static void printMenu() {
        System.out.println("Available options\npress");
        System.out.println("Quit - 0\n"+
                "To play song - 1\n" +
                "To play previous song - 2\n"+
                "Loop - 3"+
                "List of songs - 4\n"+
                "print all available options - 5\n"+
                "Delete song - 6");
    }

    private static void printList(LinkedList<song> playlist) {
        Iterator<song> iterator=playlist.iterator();
        System.out.println("---------------");

        while (iterator.hasNext()) {
            System.out.println(iterator.next());

        }
        System.out.println("---------------");
    }
}