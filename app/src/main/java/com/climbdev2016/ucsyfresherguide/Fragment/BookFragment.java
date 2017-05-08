package com.climbdev2016.ucsyfresherguide.Fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.climbdev2016.ucsyfresherguide.R;
import com.climbdev2016.ucsyfresherguide.adapters.BookRVAdapter;
import com.climbdev2016.ucsyfresherguide.model.Book;

import java.util.ArrayList;
import java.util.List;



/**
 * A simple {@link Fragment} subclass.
 */
public class BookFragment extends Fragment {

    private RecyclerView firstRV, secRV, thirdRV, fourthRV;
    private BookRVAdapter bookRVAdapter;
    private List<Book> firstBooks = new ArrayList<>();
    private List<Book> secBooks = new ArrayList<>();
    private List<Book> thirdBooks = new ArrayList<>();
    private List<Book> fourthBooks = new ArrayList<>();


    String[] firstYrBook = {
            "ျမန္မာစာ", "ဇာတိမာန္", "College Physics", "Maths I", "IELTS Foundation", "Infotech for Computer Users", "OOP in C++", "HTML -5 (6th edition)"
            , "Data Structure", "Programming Logic & Design", "Digital Fundamental", "Computer Fundamental (6th Edition)"};

    String[] firstPrice = {
            "2200ks", "1000ks", "6700ks", "5800ks", "1500ks", "1200ks", "5600ks", "5000ks", "1500ks", "4600ks", "5500ks", "2600ks"
    };

    String[] secYrBook = {
            "IELTS Objective (Intermediate)", "Maths II", "Learn to Java", "E-Circuit", "DBMS", "Objective Oriented System Design", "Java Black Book"
            , "Data structure in Java", "SE-8", "Professional Java Script", "SAD", "Digital Fundamental", "HCI"
    };

    String[] secPrice = {
            "1500ks", "2300ks", "2800ks", "5200ks", "6000ks", "2300ks", "3700ks", "5200ks", "6000ks"
            , "6200ks", "3200ks", "5500ks", "5300ks"
    };

    String[] thirdYrBook = {
            "IELTS-7", "Cambridge Grammer for IELTS", "Maths III", "Structure CO (New) 6th Edition", "J2EE", "Operating System"
            , "MicroProcessor(CT)", "SE- 8", "DBMS", "Data Communication", "E-device (9th Edition)"
            , "Modern control (12th Edition)", "Computer Architecture (chp 1-3)", "C#", "Computer Networking", "E-Curcuit", "PL"
    };

    String[] thirdPrice = {
            "1200ks", "1500ks", "4000ks", "5200ks", "3300ks", "5800ks", "6800ks", "6700ks"
            , "6000ks", "5700ks", "5300ks", "5200ks", "1800ks", "3500ks", "5500ks"
            , "5200ks", "4500ks"
    };

    String[] fourthYrBook = {
            "IELTS-8", "IELTS Grammmar", "Operation Research(401)", "Maths(402) vol.IV", "Operating system", "Analysic of Algorithm", "Computer Graphic"
            , "MIS ", "POOD with UML", "CAO (chap 4-7)", "Cryptography", "E-Device(9th Edition)", "Modern Control (12th Edit)"
            , "Computer Networking", "Data Communication", "Aritificial Intelligence", "E business 3200ks", "Embedded System(CT) chp.8,9,10(2nd term)"
    };

    String[] fourthPrice = {
            "1200ks", "1500ks", "2000ks", "2200ks", "6700ks", "4000ks", "2200ks", "5000ks", "2800ks", "3200ks"
            , "5500ks", "5300ks", "5200ks", "5500ks", "5700ks", "3300ks", "3200ks", "- - - - ks"
    };

    public BookFragment() {

    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_book, container, false);

        setupRecyclerView(firstRV, firstBooks, view, R.id.rv_first, firstYrBook, firstPrice);

        setupRecyclerView(secRV, secBooks, view, R.id.rv_second, secYrBook, secPrice);

        setupRecyclerView(thirdRV, thirdBooks, view, R.id.rv_third, thirdYrBook, thirdPrice);

        setupRecyclerView(fourthRV, fourthBooks, view, R.id.rv_fourth, fourthYrBook, fourthPrice);

        return view;
    }

    private void prepareData(String[] bookName, String[] price, List<Book> bookList) {
        for (int i = 0; i<bookName.length; i++) {
            Book book = new Book(bookName[i], price[i]);
            bookList.add(book);
        }
    }

    private void setupRecyclerView (RecyclerView recyclerView, List<Book> bookList, View view, int id, String[] bookName, String[] price) {
        recyclerView = (RecyclerView) view.findViewById(id);
        bookRVAdapter = new BookRVAdapter(bookList) {
        };
        RecyclerView.LayoutManager manager = new LinearLayoutManager(view.getContext());
        recyclerView.setLayoutManager(manager);
        recyclerView.setAdapter(bookRVAdapter);

        prepareData(bookName, price, bookList);
    }
}
