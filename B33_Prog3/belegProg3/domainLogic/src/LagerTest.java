import static org.junit.jupiter.api.Assertions.*;

class LagerTest {

    void crate_false_when_null() {
        //setup
        Lager lager = new Lager();
        Object cargo = null;

        //test
        boolean r = lager.create(cargo);

        //assert
        assertEquals(false, r);
        fail();
    }

    @org.junit.jupiter.api.Test
    void create() {
    }

    @org.junit.jupiter.api.Test
    void read() {
    }

    @org.junit.jupiter.api.Test
    void update() {
    }

    @org.junit.jupiter.api.Test
    void delete() {
    }
}