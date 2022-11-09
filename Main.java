import java.util.Random;

public class Main {
    public static void main(String[] args) {
        Random random = new Random();
        boolean phoenixSpecialActivated = false;
        boolean dryadSpecialActivated = false;
        boolean hydraSpecialActivated = false;

        SimpleMonster.fireMonster Phoenix = new SimpleMonster.fireMonster("Phoenix", "Fire",
                "Grass","Water", 0, 1, 10*1.3, 10*0.7, 100, 100);

        SimpleMonster.grassMonster Dryad = new SimpleMonster.grassMonster("Dryad", "Grass",
                "Water","Fire", 0, 1, 10, 10, 150, 150);

        // Grass vs Fire
        System.out.println("Dryad (Grass monster) vs Phoenix (Fire monster)\n");

        while (Phoenix.getHP() > 0 && Dryad.getHP() > 0) {
            int phoenixSpecial = random.nextInt(4) + 1;

            // Check if Phoenix (Fire monster) is more than 0 hp
            if (Phoenix.getHP() > 0) {

                // When special is activated through randomizer and not activated ever since
                if (phoenixSpecial == 1 && !phoenixSpecialActivated) {
                    Phoenix.specialSkill();
                    phoenixSpecialActivated = true;
                }
                Phoenix.attack(Dryad); // Phoenix (Fire monster) attack the opponent
            }

            System.out.println(""); // Spacing

            // Check if Dryad (Grass monster) is more than 0 hp
            if (Dryad.getHP() > 0) {

                // When dryad (Grass monster) hp is below half and special is not activated ever since
                if (Dryad.getHP() <= Dryad.getMaxHP() / 2 && !dryadSpecialActivated) {
                    Dryad.specialSkill();
                    dryadSpecialActivated = true;
                }
                Dryad.attack(Phoenix); // Dryad (Grass monster) attack the opponent
            }

            System.out.println(""); // Spacing
        }

        // Fire vs Water
        SimpleMonster.fireMonster Phoenix2 = new SimpleMonster.fireMonster("Phoenix", "Fire",
                "Grass","Water", 0, 1, 10*1.3, 10*0.7, 100, 100);

        SimpleMonster.waterMonster Hydra = new SimpleMonster.waterMonster("Hydra", "Water",
                "Fire","Grass", 0, 1, 10*0.7, 10*1.3, 100, 100);

        System.out.println("Phoenix (Fire monster) vs Hydra (Water monster)\n");
        phoenixSpecialActivated = false;

        while (Hydra.getHP() > 0 && Phoenix2.getHP() > 0) {
            int hydraSpecial = random.nextInt(4) + 1;

            // Check if Hydra (Water monster) is more than 0 hp
            if (Hydra.getHP() > 0) {

                // When special is activated through randomizer and not activated ever since
                if (hydraSpecial == 1 && !hydraSpecialActivated) {
                    Hydra.specialSkill();
                    hydraSpecialActivated = true;
                }
                Hydra.attack(Phoenix2); // Hydra (water monster) attack the opponent
            }

            System.out.println(""); // Spacing

            // Check if Phoenix (Fire monster) is more than 0 hp
            if (Phoenix2.getHP() > 0) {
                int phoenixSpecial = random.nextInt(4) + 1;
                // When special is activated through randomizer and not activated ever since
                if (phoenixSpecial == 1 && !phoenixSpecialActivated) {
                    Phoenix2.specialSkill();
                    phoenixSpecialActivated = true;
                }
                Phoenix2.attack(Hydra); // Phoenix (Fire monster) attack the opponent
            }

            System.out.println(""); // Spacing
        }

        // Water vs Grass
        SimpleMonster.grassMonster Dryad2 = new SimpleMonster.grassMonster("Dryad", "Grass",
                "Water","Fire", 0, 1, 10, 10, 150, 150);

        SimpleMonster.waterMonster Hydra2 = new SimpleMonster.waterMonster("Hydra", "Water",
                "Fire","Grass", 0, 1, 10*0.7, 10*1.3, 100, 100);

        System.out.println("Hydra (Water monster) vs Dryad (Grass monster)\n");
        hydraSpecialActivated = false;
        dryadSpecialActivated = false;

        while (Dryad2.getHP() > 0 && Hydra2.getHP() > 0) {
            int hydraSpecial = random.nextInt(4) + 1;

            // Check if Hydra (Water monster) is more than 0 hp
            if (Hydra2.getHP() > 0) {

                // When special is activated through randomizer and not activated ever since
                if (hydraSpecial == 1 && !hydraSpecialActivated) {
                    Hydra2.specialSkill();
                    hydraSpecialActivated = true;
                }
                Hydra2.attack(Dryad2); // Hydra (water monster) attack the opponent
            }

            System.out.println(""); // Spacing

            // Check if Dryad (Grass monster) is more than 0 hp
            if (Dryad2.getHP() > 0) {

                // When dryad (Grass monster) hp is below half and special is not activated ever since
                if (Dryad2.getHP() <= Dryad2.getMaxHP() / 2 && !dryadSpecialActivated) {
                    Dryad2.specialSkill();
                    dryadSpecialActivated = true;
                }
                Dryad2.attack(Hydra2); // Dryad (Grass monster) attack the opponent
            }

            System.out.println(""); // Spacing
        }
        
    }
}
