package khahliso.Test;

import khahliso.Cards;
import org.junit.jupiter.api.Test;

import static org.junit.Assert.*;

public class TestCards {

    @Test
    void initialCardSize() {
        Cards cards = new Cards();
        cards.generateCards();
        assertEquals(54, cards.getCurrentCards().size());
    }

    @Test
    void Shuffle() {
        Cards cards = new Cards();
        cards.generateCards();
        cards.shuffleCards();
        assertNotEquals(cards.getCurrentCards(), cards.getAllCards());
    }

    @Test
    void updateTable() {
        Cards cards = new Cards();
        cards.generateCards();
        cards.shuffleCards();
        cards.setTABLE();
        cards.updateTable("5_HEART");
        assertEquals("5_HEART",cards.getTABLE());
    }

    @Test
    void updateDishes() {
        Cards cards = new Cards();
        cards.generateCards();
        cards.shuffleCards();
        cards.setTABLE();
        String tableCard = cards.getTABLE();
        cards.updateTable("5_HEART");
        assertTrue(cards.getDishes().contains(tableCard));
    }

}
