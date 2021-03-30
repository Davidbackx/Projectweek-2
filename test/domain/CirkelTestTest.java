package domain;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import domain.Cirkel;
import org.junit.Test;
public class CirkelTestTest {
        private Punt punt1 = new Punt(5, 3);
        private Punt punt2 = new Punt(8, 2);
        private Punt punt3 = new Punt(5, 5);
        private Punt punt4 = new Punt(0, 0);

        private Cirkel cirkel1 = new Cirkel(punt1, 5);
        private Cirkel zelfdeAlsCirkel1 = new Cirkel(punt4, 5);
        private Cirkel cirkel2 = new Cirkel(punt3, -5);

    @Test
    public void Cirkel_aanmaken_met_gegeven_radius_en_middelpunt() {
        Cirkel cirkel = new Cirkel(punt1, 5);

        assertEquals(punt1, cirkel.getMiddelPunt());
        assertEquals(5, cirkel.getRadius());

    }

    @Test (expected = DomainException.class)
    public void Cirkel_Moet_exception_gooien_als_middelPunt_null()  {
        new Cirkel(null, 5);
    }

    @Test (expected = DomainException.class)
    public void Cirkel_Moet_exception_gooien_als_radius_negatief()  {
        new Cirkel(punt1, -5);
    }

}


