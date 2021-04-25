import java.util.*;

public class Battle {
    private Integer totalPowerPlayer;
    private Integer totalPowerEnemy;
    private double elementAdvPlayer;
    private double elementAdvEnemy;
    private int lifeEngimon;

    public int Sum (int num){
        if (num != 0){
            return num + Sum(num-1);
        }
        else {
            return num;
        }
    }

    public int TotalPower(Engimon e, double elementAdvPlayer2, Skill s){
        return (int) (e.getLevel() * elementAdvPlayer2 + Sum(s.getBasePower() * s.getMasteryLevel()));
    }

	public void showTotalPower(int total, int tag){
        if(tag == 0){ /* Player */
            System.out.println("My Total Power\t\t: " + total); // Sesuaikan dengan GUI
        }
        else if(tag == 1){ /* Enemy */
            System.out.println("Enemy Total Power\t: " + total); // Sesuaikan dengan GUI
        }
    }

    public void showStatusWildEngimon(Engimon e){
        System.out.println("Nama : " + e.getName());
        System.out.println("Spesies : " + e.getSpecies());
        System.out.println("Skill : " + e.getSkills());
        System.out.println("Banyak Element : " + e.getNumberElements());
        System.out.println("Element : " + e.getElements());
        System.out.println("Level : " + e.getLevel());
    }

    public void beforeBattle(Engimon e, Engimon w, int numEngimon, Skill s1, Skill s2, InventoryEngimon wI){ // Sesuaikan dengan GUI
        // Tampilkan status lengkap engimon musuh
        this.showStatusWildEngimon(w); // Disesuaikan dengan GUI
        totalPowerPlayer = TotalPower(wI.getInventoryEngimon().get(numEngimon), elementAdvPlayer, s1);
        showTotalPower(totalPowerEnemy,1);

        System.out.println("Apakah Ingin Melanjutkan Battle: ");
        Scanner keyboard = new Scanner(System.in);
        String answer = keyboard.nextLine();
        System.out.print("[ ya/tidak ] : ");

        if (answer.toLowerCase().equals("ya")){
            tanding(e, numEngimon, w, s1, s2, wI);
        }
        else {
            System.out.println("Gajadi battle deh");
        }
    }


	public void elementAdv1(Engimon e1, Engimon e2){
        int i = 0, j = 0;

        double[][] matriks = {
                                {1, 0, 1, 0.5, 2},
                                {2, 1, 0, 1, 1},
                                {1, 2, 1, 0, 1.5},
                                {1.5, 1, 2, 1, 0},
                                {0, 1, 0.5, 2, 1}
                            };

        
        for(int k = 0; k < e1.getNumberElements(); k++){
            for(int l= 0; l < e2.getNumberElements(); l++) {
                switch (e1.getElements().get(k).getElementName()) {
                    case "Fire" -> i = 0;
                    case "Water" -> i = 1;
                    case "Electric" -> i = 2;
                    case "Ground" -> i = 3;
                    case "Ice" -> i = 4;
                }
                switch (e2.getElements().get(l).getElementName()) {
                    case "Fire" -> j = 0;
                    case "Water" -> j = 1;
                    case "Electric" -> j = 2;
                    case "Ground" -> j = 3;
                    case "Ice" -> j = 4;
                }

                if (matriks[i][j] >= elementAdvPlayer){
			        elementAdvPlayer = matriks[i][j];
                }
                if (matriks[j][i] >= elementAdvEnemy){
                    elementAdvEnemy = matriks[j][i];
                }
            }
        }
    }

	public int tanding(Engimon w1, int numEngimon, Engimon w2, Skill s1, Skill s2, InventoryEngimon wI){
        // Hitung total power level
        totalPowerPlayer = TotalPower(wI.getInventoryEngimon().get(numEngimon), elementAdvPlayer, s1);
        totalPowerEnemy = TotalPower(w2, elementAdvPlayer, s2);

        //Tampilkan total power Level
        showTotalPower(totalPowerPlayer,0);
        showTotalPower(totalPowerEnemy,1);

        if (totalPowerPlayer < totalPowerEnemy){
            return 1; // Menang
            System.out.println("\n T_T ---- you lose ---- T_T");
            lifeEngimon = w1.getLife();
            lifeEngimon--;
            if (lifeEngimon == 0){
                System.out.println("Engimon Mati T_T");
            }
        }
        else{
            return 0 ; // Kalah
            int exp = 200 + wI.getInventoryEngimon().get(numEngimon).getCumulXp();
            wI.getInventoryEngimon().get(numEngimon).setCumulXp(exp);
            System.out.println("\n## Anda Mendapatkan tambahan EXP sebesar 200 ##");

            // Menambahkan Engimon hadiah
            w2.setStatus(PLAYER_ENGIMON);

            w1.addToInventoryEngimon(w2);
            System.out.println("## Engimon Reward \t>>> " + w2.getSpecies() + "\n");

            //Menambahkan Skill hadiah
            Skill skillReward;
            //skillReward.operator=(GameState::generateSkill(w2));
            System.out.println("## Skill Reward \t>>> " + skillReward.getNama() + "\n");
        }
    }
}
