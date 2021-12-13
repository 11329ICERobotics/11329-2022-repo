package org.firstinspires.ftc.teamcode.utilities.di;

public class DiInterfaces {
    public interface IInitializable {
        void Initialize();
    }
    public interface ITickable {
        void Tick();
    }
    public interface IDisposable {
        void Dispose();
    }
}
