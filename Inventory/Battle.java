import java.util.*;

public class Battle {
    private Integer totalPowerPlayer;
    private Integer totalPowerEnemy;
    private double elementAdvPlayer;
    private double elementAdvEnemy;

    public int Sum (int num){
        if (num != 0){
            return num + Sum(num-1);
        }
        else {
            return num;
        }
    }

    public int TotalPower(Engimon w, int elementAdv, Skill s){
        return w.getLevel() * elementAdv + Sum(s.getBasePower() * s.getMasteryLevel());
    }

	public void showTotalPower(int total, int tag){
        if(tag == 0){ /* Player */
            System.out.println("My Total Power\t\t: " + total); // Sesuaikan dengan GUI
        }
        else if(tag == 1){ /* Enemy */
            System.out.println("Enemy Total Power\t: " + total); // Sesuaikan dengan GUI
        }
    }

    // Ini teh
    public void showStatusWildEngimon(Spawner w){

    }

    public void beforeBattle(Player w1, Spawner w2, int numEngimon, Skill s1, Skill s2){ // Sesuaikan dengan GUI
        String answer;

        // Tampilkan status lengkap engimon musuh
        totalPowerPlayer = TotalPower(w2.getInventoryEngimon().getEngimon(numEngimon), elementAdvPlayer, s1);
        showTotalPower(totalPowerEnemy,1);
        showStatusWildEngimon(w2); // Disesuaikan dengan GUI

        Scanner keyboard = new Scanner(System.in);
        System.out.print("Apakah Ingin Melanjutkan Battle: ");
        answer = keyboard.nextLine();

        if (answer.toLowerCase().equals("ya")){
            tanding(w1, numEngimon, w2, s1, s2);
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

	public void tanding(Player w1, int numEngimon, Spawner w2, Skill s1, Skill s2){
        // Hitung total power level
        totalPowerPlayer = TotalPower(w1.getInventoryEngimon().getEngimon(numEngimon), elementAdvPlayer, s1);
        totalPowerEnemy = TotalPower(w2, elementAdvPlayer, s2);

        //Tampilkan total power Level
        showTotalPower(totalPowerPlayer,0);
        showTotalPower(totalPowerEnemy,1);

        if (totalPowerPlayer < totalPowerEnemy){
            System.out.println("\n T_T ---- you lose ---- T_T\n");
        }
        else{
            int exp = 200 + w1.getInventoryEngimon().getEngimon(numEngimon).getXp();
            w1.getInventoryEngimon().getEngimon(numEngimon).setXp(exp);
            System.out.println("\n## Anda Mendapatkan tambahan EXP sebesar 200 ##");

            // Menambahkan Engimon hadiah
            w2.setStatus(PLAYER_ENGIMON);

            w1.addEngimon(w2);
            System.out.println("## Engimon Reward \t>>> " + w2.getSpecies() + "\n");

            //Menambahkan Skill hadiah
            Skill skillReward;
            //skillReward.operator=(GameState::generateSkill(w2));
            System.out.println("## Skill Reward \t>>> " + skillReward.getNamaSkill() + "\n");
        }
    }
}
