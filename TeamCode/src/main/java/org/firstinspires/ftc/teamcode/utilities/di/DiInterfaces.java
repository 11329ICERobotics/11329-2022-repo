package org.firstinspires.ftc.teamcode.utilities.di;

public class DiInterfaces {
    public interface IInitializable {
        public void Initialize();
    }
    public interface ITickable {
        public void Tick();
    }
    public interface IDisposable {
        public void Dispose();
    }
}
