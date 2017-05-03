/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package NapakalakiGame;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

/**
 *
 * @author alfonsogmw
 */
public class CardDealer {
    private static CardDealer instance = null;
    
    private ArrayList<Treasure> usedTreasures = new ArrayList();
    private ArrayList<Treasure> unusedTreasures = new ArrayList();
    private ArrayList<Monster> usedMonsters = new ArrayList();
    private ArrayList<Monster> unusedMonsters = new ArrayList();
    private ArrayList<Cultist> unusedCultists = new ArrayList();

    
    private CardDealer()
    {
        
    }
    
    private void initTreasureCardDeck()
    {
       
        unusedTreasures.add(new Treasure("¡Sí mi amo!",4,TreasureKind.HELMET));
        
        unusedTreasures.add(new Treasure("Botas de investigación",3,TreasureKind.SHOES));
        
        unusedTreasures.add(new Treasure("Capucha de Cthulhu",3,TreasureKind.HELMET));
        
        unusedTreasures.add(new Treasure("A prueba de babas",2,TreasureKind.ARMOR));
        
        unusedTreasures.add(new Treasure("Botas de lluvia ácida",1,TreasureKind.SHOES));
        
        unusedTreasures.add(new Treasure("Casco minero",2,TreasureKind.HELMET));
        
        unusedTreasures.add(new Treasure("Ametralladora ACME",4,TreasureKind.BOTHHANDS));
        
        unusedTreasures.add(new Treasure("Camiseta de la ETSIIT",1,TreasureKind.ARMOR));
        
        unusedTreasures.add(new Treasure("Clavo de rail ferroviario",3,TreasureKind.ONEHAND));
        
        unusedTreasures.add(new Treasure("Cuchillo de sushi arcano",2,TreasureKind.ONEHAND));
        
        unusedTreasures.add(new Treasure("Fez alópodo",3,TreasureKind.HELMET));
        
        unusedTreasures.add(new Treasure("Hacha prehistórica",2,TreasureKind.ONEHAND));
        
        unusedTreasures.add(new Treasure("El aparato del Pr. Tesla",4,TreasureKind.ARMOR));
        
        unusedTreasures.add(new Treasure("Gaita",4,TreasureKind.BOTHHANDS));
        
        unusedTreasures.add(new Treasure("Insecticida",2,TreasureKind.ONEHAND));
        
        unusedTreasures.add(new Treasure("Escopeta de 3 cañodes",4,TreasureKind.BOTHHANDS));
        
        unusedTreasures.add(new Treasure("Garabato místico",2,TreasureKind.ONEHAND));
        
        unusedTreasures.add(new Treasure("La rebeca metálica",2,TreasureKind.ARMOR));
        
        unusedTreasures.add(new Treasure("Lanzallamas",4,TreasureKind.BOTHHANDS));
        
        unusedTreasures.add(new Treasure("Necro-comicón",1,TreasureKind.ONEHAND));
        
        unusedTreasures.add(new Treasure("Necronomicón",5,TreasureKind.BOTHHANDS));
        
        unusedTreasures.add(new Treasure("Linterna a 2 manos",3,TreasureKind.BOTHHANDS));
        
        unusedTreasures.add(new Treasure("Necro-gnomicrón",2,TreasureKind.ONEHAND));
        
        unusedTreasures.add(new Treasure("Necrotelecom",2,TreasureKind.HELMET));
        
        unusedTreasures.add(new Treasure("Mazo de ls antiguos",3,TreasureKind.ONEHAND));
        
        unusedTreasures.add(new Treasure("Necro-playboycón",3,TreasureKind.ONEHAND));
        
        unusedTreasures.add(new Treasure("Porra preternatural",2,TreasureKind.ONEHAND));
        
        unusedTreasures.add(new Treasure("Shogulador",1,TreasureKind.BOTHHANDS));
        
        unusedTreasures.add(new Treasure("Varita de atizamiento",3,TreasureKind.ONEHAND));
        
        unusedTreasures.add(new Treasure("Tentáculo de pega",2,TreasureKind.HELMET));
        
        unusedTreasures.add(new Treasure("Zapato deja-amigos",1,TreasureKind.SHOES));
        
        shuffleTreasures();
    }
    
    
    private void initMonsterCardDeck()
    {
        // Añadimos monstruo 'El rey de rosado'
        BadConsequence badConsequence = new NumericBadConsequence("Piernes 5 niveles y"
                + "3 tesoros visibles", 5, 3, 0);

        Prize prize = new Prize(4, 2);

        unusedMonsters.add(new Monster("El rey de rosado", 11, badConsequence, prize));

        
        // Añadimos monstruo 'Demonios de Magaluf'
        badConsequence = new SpecificBadConsequence("Te atrapan para llevarte de fiesta y te"
                + " dejan caer en mitad del vuelo. Descarta 1 mano visible y 1 mano oculta", 0,
                new ArrayList(Arrays.asList(TreasureKind.ONEHAND)),
                new ArrayList(Arrays.asList(TreasureKind.ONEHAND)));

        prize = new Prize(4, 1);

        unusedMonsters.add(new Monster("Demonios de Magaluf", 2, badConsequence, prize));

        
        // Añadimos monstruo 'Byakhees de bonanza'
        badConsequence = new SpecificBadConsequence("Pierdes tu armadura visible y otra oculta",
                0, new ArrayList(Arrays.asList(TreasureKind.ARMOR)),
                new ArrayList(Arrays.asList(TreasureKind.ARMOR)));

        prize = new Prize(2, 1);

        unusedMonsters.add(new Monster("Byakhees de bonanza", 8, badConsequence, prize));

        
        // Añadimos monstruo 'Tenochtitlan'
        badConsequence = new SpecificBadConsequence("Embobados con el lindo primigenio,"
                + " te descartas de tu casco visible", 0,
                new ArrayList(Arrays.asList(TreasureKind.HELMET)), new ArrayList());

        prize = new Prize(1, 1);

        unusedMonsters.add(new Monster("Tenochtitlan", 2, badConsequence, prize));

        
        // Añadimos monstruo 'El sopor de Dunwich'
        badConsequence = new SpecificBadConsequence("El primordial bostezo contagioso. "
                + "Pierdes el calzado visible", 0,
                new ArrayList(Arrays.asList(TreasureKind.SHOES)), new ArrayList());

        prize = new Prize(1,1);

        unusedMonsters.add(new Monster("El sopor de Dunwich", 2, badConsequence, prize));

        
        // Añadimos monstruo 'El gorrón en el umbral'
        badConsequence = new NumericBadConsequence("Pierdes todos tus tesoros visibles",
                0, BadConsequence.MAXTREASURES, 0);

        prize = new Prize(3, 1);

        unusedMonsters.add(new Monster("El gorrón en el umbral", 13,
                badConsequence, prize));

        
        // Añadimos monstruo "Munchcraft"
        badConsequence = new SpecificBadConsequence("Pierdes la armadura visible",
                0, new ArrayList(Arrays.asList(TreasureKind.ARMOR)), new ArrayList());

        prize = new Prize(2, 1);

        unusedMonsters.add(new Monster("Munchcraft", 6, badConsequence, prize));

        
        // Añadimos monstruo 'Necrófago'
        badConsequence = new SpecificBadConsequence("Sientes bichos bajo la ropa. "
                + "Descarta la armadura visible", 0,
                new ArrayList(Arrays.asList(TreasureKind.ARMOR)), new ArrayList());

        prize = new Prize(1, 1);

        unusedMonsters.add(new Monster("Necrófago", 13, badConsequence, prize));

        
        // Añadimos monstruo 'Flecher'
        badConsequence = new NumericBadConsequence("Toses los pulmones y pierdes 2 niveles",
                2, 0, 0);

        prize = new Prize(1, 1);

        unusedMonsters.add(new Monster("Fletcher", 2, badConsequence, prize));

        
        // Añadimos monstruo 'Los hondos'
        badConsequence = new DeathBadConsequence("Estos monstruos resultan bastante"
                + " superficiales y te aburren mortalmente. Estas muerto.", true);

        prize = new Prize(2, 1);

        unusedMonsters.add(new Monster("Los hondos", 8, badConsequence, prize));

        // Añadimos monstruo 'Semillas Cthulhu'
        badConsequence = new NumericBadConsequence("Pierdes 2 niveles y "
                + "2 tesoros ocultos.", 2, 0, 2);

        prize = new Prize(2, 1);

        unusedMonsters.add(new Monster("Semillas Cthulhu", 4, badConsequence, prize));
        
        
        //Añadimos monstruo 'Dameargo'
        badConsequence = new SpecificBadConsequence("Te intentas escaquear."
                + "Pierdes una mano visible",
                0, new ArrayList(Arrays.asList(TreasureKind.ONEHAND)),
                new ArrayList());
        
        prize = new Prize(2,1);
        
        unusedMonsters.add(new Monster("Dameargo",1,badConsequence,prize));
        
        
        // Añadimos monstruo 'Pollipólipo volante'
        badConsequence = new NumericBadConsequence("Da mucho asquito. Pierdes 3 niveles",
                3,0,0);
        
        prize = new Prize(2,1);
        
        unusedMonsters.add(new Monster("Pollipólido volante",3,badConsequence,prize));
        
        
        // Añadimos monstruo 'Yskhtihyssg-Goth'
        badConsequence = new DeathBadConsequence("No le hace gracia que pronuncien "
                + "mal su nombre. Estás muerto",true);
        
        prize = new Prize(3,1);
        
        unusedMonsters.add(new Monster("Yskhtihyssg-Goth",14,badConsequence,prize));
        
        
        // Añadimos monstruo 'Familia Feliz'
        badConsequence = new DeathBadConsequence("La familia te atrapa. "
                + "Estás muerto",true);
        
        prize = new Prize(3,1);
        
        unusedMonsters.add(new Monster("Familia feliz",1,badConsequence,prize));
        
        
        // Añadimos monstruo 'Roboggoth'
        badConsequence = new SpecificBadConsequence("La quinta directiva primaria te "
                + "obliga a perder 2 niveles y un tesoro 2 manos visible",
                2, new ArrayList(Arrays.asList(TreasureKind.BOTHHANDS)),
                new ArrayList());
        
        prize = new Prize(2,1);
        
        unusedMonsters.add(new Monster("Roboggoth",8,badConsequence,prize));
        
        
        // Añadimos monstruo 'El espía sordo'
        badConsequence = new SpecificBadConsequence("Te asusta en la noche. Pierdes un "
                + "casco visible",0,new ArrayList(Arrays.asList(TreasureKind.HELMET)),
                new ArrayList());
        
        prize = new Prize(1,1);
        
        unusedMonsters.add(new Monster("El espía sordo",5,badConsequence,prize));
        
        
        // Añadimos monstruo 'Tongue'
        badConsequence = new NumericBadConsequence("Menudo susto te llevas. Pierdes 2"
                + " niveles y 5 tesoros visibles", 2, 5, 0);
        
        prize = new Prize(2,1);
        
        unusedMonsters.add(new Monster("Tongue", 19, badConsequence, prize));
        
        
        // Añadimos monstruo 'Bicéfalo'
        badConsequence = new SpecificBadConsequence("Te faltan manos para tanta cabeza."
                + " Pierdes 3 niveles y tus tesoros visibles de las manos",
                3,new ArrayList(Arrays.asList(TreasureKind.ONEHAND,
                TreasureKind.ONEHAND, TreasureKind.BOTHHANDS)),new ArrayList());
        
        prize = new Prize(2,1);
        
        unusedMonsters.add(new Monster("Bicéfalo", 21, badConsequence,prize));
        
        
        // Añadimos monstruo con modif. de sectario 'El mal indecible impronunciable'
        badConsequence = new SpecificBadConsequence("Pierdes  1 mano visible", 0,
                new ArrayList(Arrays.asList(TreasureKind.ONEHAND)), new ArrayList());
        
        prize = new Prize(3,1);
        
        unusedMonsters.add(new Monster("El mal indecible impronunciable", 10,
                badConsequence,prize,-2));
        
        
        // Añadimos monstruo con modif. de sectario 'Testigos oculares'
        badConsequence = new NumericBadConsequence("Pierdes tus tesoros visibles. Jajaja.",
                0,BadConsequence.MAXTREASURES,0);
        
        prize = new Prize(2,1);
        
        unusedMonsters.add(new Monster("Testigos oculares", 6, badConsequence,prize,2));
        
        
        // Añadimos monstruo con modif. de sectario 'El gran cthulhu'
        badConsequence = new DeathBadConsequence("Hoy no es tu día de suerte. Mueres.",true);
        
        prize = new Prize(2,5);
        
        unusedMonsters.add(new Monster("El gran cthulhu",20,badConsequence,prize,4));
        
        
        // Añadimos monstruo con modif. de sectario 'Serpiente Político'
        badConsequence = new NumericBadConsequence("Tu gobierno te recorta 2 niveles.",2,0,0);
        
        prize = new Prize(2,1);
        
        unusedMonsters.add(new Monster("Serpiente Político",8,badConsequence,prize,-2));
        
        
        // Añadimos monstruo con modif. de sectario 'Felpuggoth'
        badConsequence = new SpecificBadConsequence("Pierdes tu casco y tu " +
                "armadura visible. Pierdes tus manos ocultas.",0,
                new ArrayList(Arrays.asList(TreasureKind.HELMET,TreasureKind.ARMOR)),
                new ArrayList(Arrays.asList(TreasureKind.ONEHAND,TreasureKind.ONEHAND,
                TreasureKind.BOTHHANDS)));
        
        prize = new Prize(1,1);
        
        unusedMonsters.add(new Monster("Felpuggoth",2,badConsequence,prize,5));
        
        
        // Añadimos monstruo con modif. de sectario 'Shoggoth'
        badConsequence = new NumericBadConsequence("Pierdes 2 niveles",2,0,0);
        
        prize = new Prize(4,2);
        
        unusedMonsters.add(new Monster("Shoggoth",16,badConsequence,prize,-4));
        
        
        // Añadimos monstruo con modif. de sectario 'Lolitagooth'
        badConsequence = new NumericBadConsequence("Pintalabios negro. Pierdes 2 niveles.",
                2,0,0);
        
        prize = new Prize(1,1);
        
        unusedMonsters.add(new Monster("Lolitagooth",2,badConsequence,prize,3));
        
        
        
        
        shuffleMonsters();
    }
    
    
    private void initCultistCardDeck()
    {

        unusedCultists.add(new Cultist("Sectario 1",1));
        unusedCultists.add(new Cultist("Sectario 2",2));
        unusedCultists.add(new Cultist("Sectario 3",1));
        unusedCultists.add(new Cultist("Sectario 4",2));
        unusedCultists.add(new Cultist("Sectario 5",1));
        unusedCultists.add(new Cultist("Sectario 6",1));
        
        
        shuffleCultists();
    }
    
    
    private void shuffleTreasures()
    {
        Collections.shuffle(unusedTreasures);
    }
    
    private void shuffleMonsters()
    {
        Collections.shuffle(unusedMonsters);
    }
    
    private void shuffleCultists()
    {
        Collections.shuffle(unusedCultists);
    }
    
    public static CardDealer getInstance()
    {   if (instance==null)
            instance = new CardDealer();
        return instance;
    }
            
    public Treasure nextTreasure()
    {
        if (unusedTreasures.isEmpty())
        {
            for (Treasure t : usedTreasures)
            {
                unusedTreasures.add(t);
            }
            usedTreasures.clear();
            this.shuffleTreasures();
        }
        
        Treasure treasure = this.unusedTreasures.get(0);
        this.unusedTreasures.remove(treasure);
        giveTreasureBack(treasure);
        
        return treasure;
    }
    
    public Monster nextMonster()
    {
        if (unusedMonsters.isEmpty())
        {
            for (Monster m : usedMonsters)
            {
                unusedMonsters.add(m);
            }
            usedMonsters.clear();
            this.shuffleMonsters();
        }
        
        Monster monster = this.unusedMonsters.get(0);
        this.unusedMonsters.remove(monster);
        giveMonsterBack(monster);
        
        return monster;
    }
    
    
    public Cultist nextCultist()
    {
        Cultist cultist = this.unusedCultists.get(0);
        this.unusedCultists.remove(cultist);
        
        return cultist;
    }
    
    
    public void giveTreasureBack(Treasure t)
    {
        usedTreasures.add(t);
    }
    
    public void giveMonsterBack(Monster m)
    {
        usedMonsters.add(m);
    }
    
    public void initCards()
    {
        this.initMonsterCardDeck();
        this.initTreasureCardDeck();
        this.initCultistCardDeck();
    }
  
    
}
