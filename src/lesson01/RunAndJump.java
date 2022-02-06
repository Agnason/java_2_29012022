package lesson01;

public interface RunAndJump {
    public void run();
    public void jump();
    public int getMaxDistance();
    public int getMaxHeight();
    public void doJumpThroughWall(Wall wall);
    public void doRunOnRunTrack(RunTrack runTrack);
}
