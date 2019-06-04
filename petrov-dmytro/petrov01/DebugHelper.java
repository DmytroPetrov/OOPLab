package ua.lpnuai.oop.petrov01;

public class DebugHelper {
    private static boolean debuging = false;

    public static void OnDebug(){
        debuging = true;
    }

    public static void OffDebug(){
        debuging = false;
    }

    public static boolean IsDebuging(){
        return debuging;
    }
}
