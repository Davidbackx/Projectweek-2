package domain;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class TekeningTest {
    private Vorm gebouw;
    private Vorm dak;
    private Vorm deur;
    private Vorm raam;
    private Vorm deurknop;
    private Vorm raambalk1;
    private Vorm raambalk2;
    private Vorm schouwNietInTekening;
    private Omhullende omhullende;

    @Before
    public void setUp() {
        gebouw = new Rechthoek(new Punt(100, 200), 200, 180);
        dak = new Driehoek(new Punt(100, 200), new Punt(300, 200), new Punt(200, 100));
        deur = new Rechthoek(new Punt(130, 280), 50,100);
        raam = new Rechthoek(new Punt(210, 220), 80, 60);
        deurknop = new Cirkel(new Punt(170, 320), 2);
        raambalk1 = new LijnStuk(new Punt(210, 250), new Punt(290, 250));
        raambalk2 = new LijnStuk(new Punt(250, 220), new Punt(250, 280));
        schouwNietInTekening = new Rechthoek(new Punt(150, 150), 20,40);
        omhullende = new Omhullende(new Punt(200,150),150,200);
    }

    @Test
    public void Tekening_moet_een_tekening_aanmaken_met_een_geldige_naam_en_0_vormen() {
        Tekening huis = new Tekening("huis");
        assertEquals("huis", huis.getNaam());
        assertEquals(0, huis.getAantalVormen());
    }

    @Test (expected = IllegalArgumentException.class)
    public void Tekening_moet_exception_gooien_als_naam_null() {
        new Tekening(null);
    }

    @Test (expected = IllegalArgumentException.class)
    public void Tekening_moet_exception_gooien_als_naam_leeg() {
        new Tekening("");
    }

    @Test
    public void getAantalVormen_moet_aantal_vormen_teruggeven() {
        Tekening huis = createHuisZonderShouw();
        assertEquals(7, huis.getAantalVormen());
    }

    @Test
    public void bevat_geeft_true_als_gegeven_vorm_deel_uitmaakt_van_de_tekening(){
        Tekening huis = createHuisZonderShouw();
        assertTrue(huis.bevat(deur));
    }

    @Test
    public void bevat_geeft_false__als_gegeven_vorm_geen_deel_uitmaakt_van_de_tekening(){
        Tekening huis = createHuisZonderShouw();
        assertFalse(huis.bevat(schouwNietInTekening));
    }

    @Test
    public void equals_moet_false_teruggeven_als_parameter_null(){
        Tekening huis = createHuisZonderShouw();
        assertFalse(huis.equals(null));
    }

    @Test
    public void equals_moet_false_teruggeven_als_parameter_tekening_is_met_verschillend_aantal_vormen(){
        Tekening huis = createHuisZonderShouw();
        Tekening huisMetSchouw = createHuisMetSchouw();
        assertFalse(huis.equals(huisMetSchouw));
    }

    @Test
    public void equals_moet_false_teruggeven_als_parameter_tekening_is_met_zelfde_aantal_vormen_ander_vorm(){
        Tekening huis = createHuisZonderShouw();
        Tekening huisMetSchouwZonderDeur = createHuisMetSchouwZonderDeur();
        assertFalse(huis.equals(huisMetSchouwZonderDeur));
    }

    @Test
    public void equals_moet_true_teruggeven_als_parameter_tekening_is_met_zelfde_aantal_vormen_andere_volgorde(){
        Tekening huis = createHuisZonderShouw();
        Tekening huisMetSchouwZonderDeur = createHuisMetSchouwZonderDeur();
        huisMetSchouwZonderDeur.verwijder(schouwNietInTekening);
        huisMetSchouwZonderDeur.voegToe(deur);
        assertTrue(huis.equals(huisMetSchouwZonderDeur));
    }

    @Test
    public void equals_moet_true_teruggeven_alsparameter_tekening_is_met_zelfde_aantal_vormen_zelfde_volgorde(){
        Tekening huis = createHuisZonderShouw();
        Tekening huisMetSchouw = createHuisMetSchouw();
        huisMetSchouw.verwijder(schouwNietInTekening);
        assertTrue(huis.equals(huisMetSchouw));
    }

    //@Test (expected = IllegalArgumentException.class)
    //public void getVorm_moet_exception_gooien_als_parameter_niet_in_de_lijst_voorkomt(){

    //}
    @Test (expected = DomainException.class)
    public void voegToe_gooit_exception_wanneer_minX_van_omhullende_kleiner_is_dan_minX_van_tekening(){
        Tekening tekening = createHuisMetSchouw();
        tekening.voegToe(new Cirkel(new Punt(10,10),15));

    }

    @Test (expected = DomainException.class)
    public void getVorm_gooit_excepion_als_i_negatief_is() {
        Tekening tekening = createHuisMetSchouw();
        tekening.getVorm(-5);
    }

    @Test (expected = DomainException.class)
    public void getVorm_gooit_excepion_als_i_groter_is_dan_size() {
        Tekening tekening = createHuisMetSchouw();
        tekening.getVorm(10);
    }

    @Test (expected = DomainException.class)
    public void verwijder_gooit_exception_als_vorm_null_is() {
        Tekening tekening = createHuisMetSchouw();
        tekening.verwijder(null);
    }

    @Test (expected = DomainException.class)
    public void verwijder_gooit_exception_als_vorm_niet_aanwezig_is() {
        Tekening tekening = createHuisMetSchouwZonderDeur();
        tekening.verwijder(deur);
    }

    public Tekening createHuisMetSchouw() {
        Tekening huisMetSchouw = new Tekening("huisMetSchouw");
        huisMetSchouw.voegToe(gebouw);
        huisMetSchouw.voegToe(dak);
        huisMetSchouw.voegToe(deur);
        huisMetSchouw.voegToe(raam);
        huisMetSchouw.voegToe(deurknop);
        huisMetSchouw.voegToe(raambalk1);
        huisMetSchouw.voegToe(raambalk2);
        huisMetSchouw.voegToe(schouwNietInTekening);
        return huisMetSchouw;
    }

    public Tekening createHuisZonderShouw() {
        Tekening huis = new Tekening("huis");
        huis.voegToe(gebouw);
        huis.voegToe(dak);
        huis.voegToe(deur);
        huis.voegToe(raam);
        huis.voegToe(deurknop);
        huis.voegToe(raambalk1);
        huis.voegToe(raambalk2);
        return huis;
    }

    public Tekening createHuisMetSchouwZonderDeur() {
        Tekening huisMetSchouwZonderDeur = new Tekening("huisMetSchouwZonderDeur");
        huisMetSchouwZonderDeur.voegToe(gebouw);
        huisMetSchouwZonderDeur.voegToe(dak);
        huisMetSchouwZonderDeur.voegToe(raam);
        huisMetSchouwZonderDeur.voegToe(deurknop);
        huisMetSchouwZonderDeur.voegToe(raambalk1);
        huisMetSchouwZonderDeur.voegToe(raambalk2);
        huisMetSchouwZonderDeur.voegToe(schouwNietInTekening);
        return huisMetSchouwZonderDeur;
    }

}
