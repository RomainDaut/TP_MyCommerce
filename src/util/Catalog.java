package util;

import model.Produit;

import java.io.Serializable;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class Catalog implements Serializable {
    private Map<String, Produit> items = new HashMap<>();

    synchronized public Map<String, Produit> getItems() {
        return Collections.unmodifiableMap(items);
    }

    synchronized public Produit getItem(String itemId) {
        return items.get(itemId);
    }

    synchronized public void setItem(String itemId, Produit item) {
        items.put(itemId, item);
    }

    public Catalog(Map<String, Produit> items) {
        this.items = items;
    }

}