package util;

import javafx.scene.Cursor;
import javafx.scene.Scene;
import javafx.stage.Screen;
import javafx.stage.Stage;

/**
 * 使窗体在initStayle为UNDECORATED时能够缩放的工具类
 * **/
public final class ResizeUtils {
	//记录鼠标按下时需要记录的某个X，Y坐标
	private static double mousePressedForResizeX;
	private static double mousePressedForResizeY;
	//记录窗体的高度和宽度
	private static double stageWidth;
	private static double stageHeigth;
	//记录屏幕的可视化宽度和高度
	static double ScreenWidth = Screen.getPrimary().getVisualBounds().getWidth();
	static double ScreenHeight = Screen.getPrimary().getVisualBounds().getHeight();

	//设置stage对象能够拖拽边缘的像素实现缩放的静态方法
	public static void addResizable(Stage stage,double stageMinWidth,double stageMinHeight) {
		try {
			//记录stage的scene对象
			Scene scene=stage.getScene();
			stageWidth = stage.getWidth();
			stageHeigth = stage.getHeight();
			//记录鼠标按下时的scene坐标
			scene.setOnMousePressed(e->{
				mousePressedForResizeX=e.getSceneX();
				mousePressedForResizeY=e.getSceneY();
			});
			scene.setOnMouseMoved(e -> {
				if (!stage.isMaximized()) {
					if (e.getSceneX() <= 5 && e.getSceneY() > 5 && stage.getHeight() - e.getSceneY() > 5) {
						// 改变鼠标的形状
						scene.setCursor(Cursor.W_RESIZE);
					} else if (stage.getWidth() - e.getSceneX() <= 5 && e.getSceneY() > 5 && stage.getHeight() - e.getSceneY() > 5) {
						scene.setCursor(Cursor.E_RESIZE);
					} else if (e.getSceneY() <= 5 && e.getSceneX() > 5 && stage.getWidth() - e.getSceneX() > 5) {
						scene.setCursor(Cursor.N_RESIZE);
					} else if (stage.getHeight() - e.getSceneY() <= 5 && e.getSceneX() > 5 && stage.getWidth() - e.getSceneX() > 5) {
						scene.setCursor(Cursor.S_RESIZE);
					} else if (e.getSceneX() <= 5 && e.getSceneY() <= 5) {
						scene.setCursor(Cursor.NW_RESIZE);
					} else if (stage.getWidth() - e.getSceneX() <= 5 && e.getSceneY() <= 5) {
						scene.setCursor(Cursor.NE_RESIZE);
					} else if (e.getSceneX() <= 5 && stage.getHeight() - e.getSceneY() <= 5) {
						scene.setCursor(Cursor.SW_RESIZE);
					} else if (stage.getWidth() - e.getSceneX() <= 5 && stage.getHeight() - e.getSceneY() <= 5) {
						scene.setCursor(Cursor.SE_RESIZE);
					} else {
						scene.setCursor(Cursor.DEFAULT);
					}
				}
			});
			scene.setOnMouseDragged(e -> {
				if(scene.getCursor()==Cursor.S_RESIZE){
					if ((stage.getHeight() + (e.getSceneY() - mousePressedForResizeY) >= stageMinHeight
							&& e.getScreenY() < ScreenHeight-2)) {
						stage.setHeight(stage.getHeight() + (e.getSceneY() - mousePressedForResizeY));
						mousePressedForResizeY = e.getSceneY();
					}
				}
				else if(scene.getCursor()==Cursor.E_RESIZE){
					if (stage.getWidth() + (e.getSceneX() - mousePressedForResizeX) >= stageMinWidth
							&& e.getScreenX() < ScreenWidth-2) {
						stage.setWidth(stage.getWidth() + (e.getSceneX() - mousePressedForResizeX));
						mousePressedForResizeX = e.getSceneX();
					}
				}
				else if(scene.getCursor()==Cursor.SE_RESIZE){
					if ((stage.getHeight() + (e.getSceneY() - mousePressedForResizeY) >= stageMinHeight
							&& e.getScreenY() < ScreenHeight-2)) {
						stage.setHeight(stage.getHeight() + (e.getSceneY() - mousePressedForResizeY));
						mousePressedForResizeY = e.getSceneY();
					}
					if (stage.getWidth() + (e.getSceneX() - mousePressedForResizeX) >= stageMinWidth
							&& e.getScreenX() < ScreenWidth-2) {
						stage.setWidth(stage.getWidth() + (e.getSceneX() - mousePressedForResizeX));
						mousePressedForResizeX = e.getSceneX();
					}
				}
				else if(scene.getCursor()==Cursor.N_RESIZE){
					if ((stage.getHeight() + (mousePressedForResizeY-e.getSceneY() ) >= stageMinHeight
							&& e.getScreenY() < ScreenHeight-2)) {
						stage.setHeight(stage.getY() - e.getScreenY() + stage.getHeight());
						stage.setY(e.getScreenY());
					}
				}
				else if(scene.getCursor()==Cursor.W_RESIZE){
					if ((stage.getWidth() + (mousePressedForResizeX-e.getSceneX() ) >= stageMinWidth
							&& e.getScreenX() < ScreenWidth-2)) {
						stage.setWidth(stage.getX() - e.getScreenX() + stage.getWidth());
						stage.setX(e.getScreenX());
					}
				}
				else if(scene.getCursor()==Cursor.NW_RESIZE){
					if ((stage.getHeight() + (mousePressedForResizeY-e.getSceneY() ) >= stageMinHeight
							&& e.getScreenY() < ScreenHeight-2)) {
						stage.setHeight(stage.getY() - e.getScreenY() + stage.getHeight());
						stage.setY(e.getScreenY());
					}
					if ((stage.getWidth() + (mousePressedForResizeX-e.getSceneX() ) >= stageMinWidth
							&& e.getScreenX() < ScreenWidth-2)) {
						stage.setWidth(stage.getX() - e.getScreenX() + stage.getWidth());
						stage.setX(e.getScreenX());
					}
				}
				else if(scene.getCursor()==Cursor.NE_RESIZE){
					if ((stage.getHeight() + (mousePressedForResizeY-e.getSceneY() ) >= stageMinHeight
							&& e.getScreenY() < ScreenHeight-2)) {
						stage.setHeight(stage.getY() - e.getScreenY() + stage.getHeight());
						stage.setY(e.getScreenY());
					}
					if (stage.getWidth() + (e.getSceneX() - mousePressedForResizeX) >= stageMinWidth
							&& e.getScreenX() < ScreenWidth-2) {
						stage.setWidth(stage.getWidth() + (e.getSceneX() - mousePressedForResizeX));
						mousePressedForResizeX = e.getSceneX();
					}
				}
				else if(scene.getCursor()==Cursor.SW_RESIZE){
					if ((stage.getWidth() + (mousePressedForResizeX-e.getSceneX() ) >= stageMinWidth
							&& e.getScreenX() < ScreenWidth-2)) {
						stage.setWidth(stage.getX() - e.getScreenX() + stage.getWidth());
						stage.setX(e.getScreenX());
					}
					if ((stage.getHeight() + (e.getSceneY() - mousePressedForResizeY) >= stageMinHeight
							&& e.getScreenY() < ScreenHeight-2)) {
						stage.setHeight(stage.getHeight() + (e.getSceneY() - mousePressedForResizeY));
						mousePressedForResizeY = e.getSceneY();
					}
				}
			});
		}catch (Exception e) {
			System.out.println("舞台对象未设置scene对象");
			return;
		}

	}
}
