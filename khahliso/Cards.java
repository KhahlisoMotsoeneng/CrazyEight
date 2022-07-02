package khahliso;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class Cards {
    private List<String> currentCards = new ArrayList<>();


    private List<String> allCards = new ArrayList<>();

    private List<String> specialCards = new ArrayList<>();
    private List<String> shapes = new ArrayList<>();

    private List<String> Dishes = new ArrayList<>();

    private String TABLE;
    public Cards(){}
    public void generateCards(){

        this.currentCards.add("JOKER_BLACK");
        this.currentCards.add("JOKER_RED");

        for(int i=1; i<=10; i++){
            this.currentCards.add(i+"_HEART");
        }
        this.currentCards.add("J_HEART");
        this.currentCards.add("Q_HEART");
        this.currentCards.add("K_HEART");

        for(int i=1; i<=10; i++){
            this.currentCards.add(i+"_DIAMOND");
        }
        this.currentCards.add("J_DIAMOND");
        this.currentCards.add("Q_DIAMOND");
        this.currentCards.add("K_DIAMOND");

        for(int i=1; i<=10; i++){
            this.currentCards.add(i+"_SPADE");
        }
        this.currentCards.add("J_SPADE");
        this.currentCards.add("Q_SPADE");
        this.currentCards.add("K_SPADE");

        for(int i=1; i<=10; i++){
            this.currentCards.add(i+"_FLOWER");
        }
        this.currentCards.add("J_FLOWER");
        this.currentCards.add("Q_FLOWER");
        this.currentCards.add("K_FLOWER");

    }

    public List<String> getCurrentCards(){
        return this.currentCards;
    }

    public void shuffleCards(){
        Collections.shuffle(this.currentCards);
    }

    public void removeCard(String card){
        this.currentCards.remove(card);
    }

    public List<String> getAllCards() {
        return allCards;
    }

    public void setAllCards() {
        this.allCards.add("JOKER_BLACK");
        this.allCards.add("JOKER_RED");

        for(int i=1; i<=10; i++){
            this.allCards.add(i+"_HEART");
        }
        this.allCards.add("J_HEART");
        this.allCards.add("Q_HEART");
        this.allCards.add("K_HEART");

        for(int i=1; i<=10; i++){
            this.allCards.add(i+"_DIAMOND");
        }
        this.allCards.add("J_DIAMOND");
        this.allCards.add("Q_DIAMOND");
        this.allCards.add("K_DIAMOND");

        for(int i=1; i<=10; i++){
            this.allCards.add(i+"_SPADE");
        }
        this.allCards.add("J_SPADE");
        this.allCards.add("Q_SPADE");
        this.allCards.add("K_SPADE");

        for(int i=1; i<=10; i++){
            this.allCards.add(i+"_FLOWER");
        }
        this.allCards.add("J_FLOWER");
        this.allCards.add("Q_FLOWER");
        this.allCards.add("K_FLOWER");
    }

    public List<String> getShapes() {
        return this.shapes;
    }

    public void setShapes() {
        this.shapes.add("HEART");
        this.shapes.add("SPADE");
        this.shapes.add("DIAMOND");
        this.shapes.add("FLOWER");

    }

    public String getTABLE() {
        return this.TABLE;
    }

    public void setTABLE() {
        Random random = new Random();
        int index = random.nextInt(currentCards.size());
        this.TABLE = currentCards.get(index);
        removeCard(this.TABLE);

    }

    public void updateTable(String card){
        updateDishes(this.TABLE);
        this.TABLE = card;
    }


    public List<String> getDishes() {
        return this.Dishes;
    }

    public void updateDishes(String dish) {
         this.Dishes.add(dish);
    }


    public List<String> getSpecialCards() {
        return specialCards;
    }

    public void setSpecialCards() {
        for(int i = 0; i< currentCards.size(); i++){
            if(currentCards.get(i).contains("JOKER") || currentCards.get(i).contains("2")||
                currentCards.get(i).contains("7") || currentCards.get(i).contains("8") ||
                    currentCards.get(i).contains("J")){
                this.specialCards.add(currentCards.get(i));
            }
        }

    }

}
