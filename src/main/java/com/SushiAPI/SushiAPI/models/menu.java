package com.SushiAPI.SushiAPI.models;

import java.util.ArrayList;

public interface menu {
    ArrayList<Item> filter(String keyword);
}
