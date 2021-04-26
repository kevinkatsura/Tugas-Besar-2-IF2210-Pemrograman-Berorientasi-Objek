import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

public class WildEngimonNames {
    private ArrayList<String> fireEngimonNames;
    private ArrayList<String> electricEngimonNames;
    private ArrayList<String> iceEngimonNames;
    private ArrayList<String> groundEngimonNames;
    private ArrayList<String> waterEngimonNames;

    public WildEngimonNames(){
        initFire();
        initElectric();
        initIce();
        initGround();
        initWater();
    }

    private void initFire(){
        fireEngimonNames = new ArrayList<String>(
                Arrays.asList(
                        "Iris", "Violet", "Hestia", "Thairnian", "Gillyiuh", "Wali", "Demoncrest",
                        "Infernorush", "Demonforge", "Idleheart", "Steampunk", "Flam", "Burns",
                        "Hellhell", "Aghni", "Hi", "Kaen", "Homura", "Naar", "Scorchie", "Sahara",
                        "Pyr", "Pyrie", "Boilspell", "Coalblade", "Magmagazo", "Blooming", "Boyle",
                        "Vulcan", "Crimsonstone", "Netherite", "Blazing", "Bastion", "Glowria", "Amber",
                        "Adora", "Ash", "Phoenix", "Hateshine", "Braveshine", "Heatstar", "Heatspell",
                        "Katlamakan", "Atacama", "Gobi", "Aghast", "Solarflare", "Sungift", "Devilwill",
                        "Kalahari", "Patagonia", "Karakum", "Mojave", "Rekka", "Ra"
                )
        );
    }

    private void  initElectric(){
        electricEngimonNames = new ArrayList<String>(
                Arrays.asList(
                        "Electroon", "Ferro", "Hex", "Codex", "Energy", "Cosmos", "Oracle", "Radar",
                        "Systempatch", "Power", "Spark", "Tesla", "Edison", "Bell", "Data", "Circuit",
                        "Signal", "Dirac", "Delta", "Lightning", "Storm", "Sprite", "Synapse", "Blackout",
                        "Ampere", "Volta", "Cathoode", "Faraday", "Kircof", "Magneto", "Norton", "Plazma",
                        "Radyo", "Vacuum", "Watt", "Ydelta", "Transformater", "Opamp", "Rezistanks", "Shneider",
                        "Shinkansen", "Android", "Linuz", "Joulee", "Galvan", "Helmholtz", "Lenx", "Coulomb",
                        "Ohm", "X", "Gamma", "Reiz", "Alfa", "Betha", "Aurora", "Flash", "Flux", "Wifi",
                        "Roaming", "Boolean", "Buzz", "Channel", "Diode", "Shock", "Fourier", "Hertz", "Lazer"
                )
        );
    }

    private void initGround(){
        groundEngimonNames = new ArrayList<String>(
                Arrays.asList(
                        "Terraforma", "Bigboulder", "Ytterbius", "Hardgranit", "Shinymarble", "Ceramixu",
                        "Grimestone", "Gravensoil", "Stownesy", "Cobblestone", "Polisheddiorite", "Shinyadamas",
                        "Fertilesoil", "Hwumwusy", "Wormhouse", "Treerooting", "Lilpebbly", "Slaitquarry",
                        "Teragranius", "Oristerbis", "Therrisslab", "Therristerra", "Earthcore", "Animosgranius",
                        "Vitaelutu", "Lemahjagad", "Bhumimandhala", "L'Foundation", "Therrisfirmis", "Gravoriagraund",
                        "Terrosvox", "Clayeharden", "Glazedterracotta", "Basaltquarris", "Fieldusroxy", "Andesitestone",
                        "Blackstone", "Mesasandstone", "Alambuwana", "Voidscreamer", "Amethystsparkle", "Terranullius",
                        "Zhamrouth", "Swanapada", "Laksititala", "Sitikisma", "Atmawretika", "Wukirgiriwara"
                )
        );
    }

    private void initWater(){
        waterEngimonNames = new ArrayList<String>(
                Arrays.asList(
                        "Aqua", "Ariela", "Avaneva" , "Mareena", "Guadalupe", "Aquavianna", "Hyris",
                        "Asphyxia", "Aerirea", "Oceana", "Peisicea", "Coromine", "Raerene", "Leunassa",
                        "Sargassina", "Atalanta", "Pacifica", "Fontala", "Melothea", "Ocerain", "Thelxierephis",
                        "Iphathesis", "Azalorea", "Euphenore", "Aquanelle", "Evaleia", "Helirose", "Morgala",
                        "Echidna", "Dolfeanne", "Sereshell", "Nemethea", "Euselacheus", "Agnatha", "Coelacanthea",
                        "Arririen", "Aigatiax", "Miraxie", "Loarela", "Oalura", "Melineira", "Daphigale",
                        "Evimea", "Nerilina", "Alulle", "Aigania", "Phionophe", "Zhalora", "Calyxera", "Amypheia"
                )
        );
    }

    private void initIce(){
        iceEngimonNames = new ArrayList<String>(
                Arrays.asList(
                        "Firn", "Snift", "Chills", "Hayle", "Flo", "Blizz", "Flayke", "Neige", "Frose",
                        "Gliss", "Flurr", "Crystal", "Cryo", "Ais", "Icy", "Thawe", "Glace", "Avalan",
                        "Lanche", "Melte", "Yce", "Yuki", "Dryft", "Flo", "Cryogen", "Snow", "Tsaljee",
                        "Spyke", "Igloo", "Gletz", "Rime", "Minocelc", "Lumi", "Nieva", "North", "Winter",
                        "Fuyu", "Alaska"
                )
        );
    }

    public String giveEngimonName(Engimon e){
        Random random = new Random();
        ArrayList<Element> elements = e.getElements();
        String namaDepan, namaBelakang;
        // Get nama depan
        Element element = elements.get(random.nextInt(elements.size()));
        if(element.getElementName().equals("Fire")){
            namaDepan = fireEngimonNames.get(random.nextInt(fireEngimonNames.size()));
        } else if(element.getElementName().equals("Ground")){
            namaDepan = groundEngimonNames.get(random.nextInt(groundEngimonNames.size()));
        } else if(element.getElementName().equals("Electric")){
            namaDepan = electricEngimonNames.get(random.nextInt(electricEngimonNames.size()));
        } else if(element.getElementName().equals("Ice")){
            namaDepan = iceEngimonNames.get(random.nextInt(iceEngimonNames.size()));
        } else {
            namaDepan = waterEngimonNames.get(random.nextInt(waterEngimonNames.size()));
        }
        // Get nama belakang
        element = elements.get(random.nextInt(elements.size()));
        if(element.getElementName().equals("Fire")){
            namaBelakang = fireEngimonNames.get(random.nextInt(fireEngimonNames.size()));
        } else if(element.getElementName().equals("Ground")){
            namaBelakang = groundEngimonNames.get(random.nextInt(groundEngimonNames.size()));
        } else if(element.getElementName().equals("Electric")){
            namaBelakang = electricEngimonNames.get(random.nextInt(electricEngimonNames.size()));
        } else if(element.getElementName().equals("Ice")){
            namaBelakang = iceEngimonNames.get(random.nextInt(iceEngimonNames.size()));
        } else {
            namaBelakang = waterEngimonNames.get(random.nextInt(waterEngimonNames.size()));
        }
        String nama = namaDepan + " " + namaBelakang;
        return nama;
    }
}
