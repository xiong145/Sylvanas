//package test.server;
//
//import org.jnativehook.GlobalScreen;
//import org.jnativehook.NativeHookException;
//import org.jnativehook.mouse.NativeMouseEvent;
//import org.jnativehook.mouse.NativeMouseInputListener;
//
//public class GlobalMouseListenerExample implements NativeMouseInputListener {
//    @Override
//    public void nativeMouseClicked(NativeMouseEvent e) {
//        System.out.println("Mouse Clicked: " + e.getClickCount());
//    }
//
//    @Override
//    public void nativeMousePressed(NativeMouseEvent e) {
//        System.out.println("Mouse Pressed: " + e.getButton());
//    }
//
//    @Override
//    public void nativeMouseReleased(NativeMouseEvent e) {
//        System.out.println("Mouse Released: " + e.getButton());
//    }
//
//    @Override
//    public void nativeMouseMoved(NativeMouseEvent e) {
//        System.out.println("Mouse Moved: " + e.getX() + ", " + e.getY());
//    }
//
//    @Override
//    public void nativeMouseDragged(NativeMouseEvent e) {
//        System.out.println("Mouse Dragged: " + e.getX() + ", " + e.getY());
//    }
//
//    public static void main(String[] args) {
//        try {
//            GlobalScreen.registerNativeHook();
//        }
//        catch (NativeHookException ex) {
//            System.err.println("There was a problem registering the native hook.");
//            System.err.println(ex.getMessage());
//
//            System.exit(1);
//        }
//
//        // Construct the example object.
//        GlobalMouseListenerExample example = new GlobalMouseListenerExample();
//
//        // Add the appropriate listeners.
//        GlobalScreen.addNativeMouseListener(example);
//        GlobalScreen.addNativeMouseMotionListener(example);
//    }
//}
