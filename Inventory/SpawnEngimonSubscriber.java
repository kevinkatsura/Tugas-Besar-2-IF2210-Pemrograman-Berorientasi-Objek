public class SpawnEngimonSubscriber implements Subscriber {
    @Override
    public void update(Engimon engimon) {
        Spawner.removeEngimon(engimon);
    }
}
